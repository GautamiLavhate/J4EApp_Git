package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.aboutus

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityAboutUsBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.aboutus.model.AboutUs
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.MapsEventsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.dismissLoader
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.displayToast
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.isInternetAvailable
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.showLoader
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AboutUsActivity : BaseActivity() {
    private lateinit var binding: ActivityAboutUsBinding

    override fun enablePresence(): Boolean {
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_about_us)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.about_us)

        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)

        if(isInternetAvailable(this)) {
            getAboutUs()
        }
    }

    private fun getAboutUs(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_aboutus()
        call.enqueue(object : Callback<AboutUs> {
            override fun onResponse(
                    call: Call<AboutUs>,
                    response: Response<AboutUs>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            binding.linearlayout1.visibility = View.GONE
                            binding.linearlayout.visibility = View.VISIBLE
                            binding.vision.text = Html.fromHtml(response.body()?.data?.get(0)?.vision?.replace("<p>","")?.replace("</p>",""))
                            binding.mission.text = Html.fromHtml(response.body()?.data?.get(0)?.mission?.replace("<p>","")?.replace("</p>",""))
                            binding.about.text = Html.fromHtml(response.body()?.data?.get(0)?.aboutus?.replace("<p>","")?.replace("</p>",""))
                            binding.email.text = response.body()?.data?.get(0)?.email
                            binding.numbermobile.text = response.body()?.data?.get(0)?.contactnumber
                            binding.whatsap.text = response.body()?.data?.get(0)?.whatsappnumber
                            binding.website.text = response.body()?.data?.get(0)?.website
                            binding.location.text = Html.fromHtml(response.body()?.data?.get(0)?.address?.replace("<p>","")?.replace("</p>",""))
                            binding.value.text = Html.fromHtml(response.body()?.data?.get(0)?.achievement?.replace("<p>","")?.replace("</p>",""))

                            binding.location.setOnClickListener {
                                val loc:String= Html.fromHtml(response.body()?.data?.get(0)?.address).toString()
                                val intent = Intent(this@AboutUsActivity, MapsEventsActivity::class.java)
                                intent.putExtra("type", "map")
                                intent.putExtra("Back","activity")
                                intent.putExtra("location",loc)
                                intent.putExtra("lat",response.body()?.data?.get(0)?.latitude)
                                intent.putExtra("long",response.body()?.data?.get(0)?.longitude)
                                startActivity(intent)
                            }


                            binding.website.setOnClickListener {
                                val facst = response.body()?.data?.get(0)?.website.toString();
                                if (facst.isEmpty()) {
                                    displayToast(this@AboutUsActivity, "empty link")
                                } else {
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://"+response.body()?.data?.get(0)?.website.toString()))
                                    startActivity(intent)
                                }
                            }
                            binding.numbermobile.setOnClickListener {
                                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + response.body()?.data?.get(0)?.contactnumber))
                                startActivity(intent)
                            }

                            binding.whatsap.setOnClickListener {
                                val formattedNumber = response.body()?.data?.get(0)?.whatsappnumber
                                try {
                                    val sendIntent = Intent("android.intent.action.MAIN")
                                    sendIntent.component = ComponentName("com.whatsapp", "com.whatsapp.Conversation")
                                    sendIntent.action = Intent.ACTION_SEND
                                    sendIntent.type = "text/plain"
                                    sendIntent.putExtra(Intent.EXTRA_TEXT, "")
                                    sendIntent.putExtra("jid", "$formattedNumber@s.whatsapp.net")
                                    sendIntent.setPackage("com.whatsapp")
                                    startActivity(sendIntent)
                                } catch (e: Exception) {
                                    Toast.makeText(this@AboutUsActivity, "Error/n$e", Toast.LENGTH_SHORT).show()
                                }
                            }

                            binding.email.setOnClickListener {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + response.body()?.data?.get(0)?.email))
                                intent.putExtra(Intent.EXTRA_SUBJECT, "email_subject")
                                intent.putExtra(Intent.EXTRA_TEXT, "email_body")
                                startActivity(intent)
                            }

                        }else{
                            binding.linearlayout1.visibility = View.GONE
                            binding.linearlayout.visibility = View.VISIBLE
                        }
                    } else {
                        binding.linearlayout1.visibility = View.GONE
                        binding.linearlayout.visibility = View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<AboutUs>, t: Throwable) {
                dismissLoader();

            }
        })

    }

}