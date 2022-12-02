package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mytestimonials

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyTestimonialsBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.MyEventsDetailsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mytestimonials.model.Testimonial
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyTestimonialsActivity : BaseActivity(),AdapterMyTestimonialsAct.OnClick2 {
    private lateinit var binding: ActivityMyTestimonialsBinding
    var count_available:Int=-1
    override fun enablePresence(): Boolean {
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_testimonials)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.given_testimonial)
        recyclerData()
    }

    private fun recyclerData() {
        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvMyTestimonials.layoutManager = layoutManager

        if(isInternetAvailable(this)){
            app_get_testimonial()
        }

    }

    private fun app_get_testimonial(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_testimonial(readUsingSharedPreference(this, "userid").toString())
        call.enqueue(object : Callback<Testimonial> {
            override fun onResponse(
                    call: Call<Testimonial>,
                    response: Response<Testimonial>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    count_available=response.body()?.count_available!!
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            binding.linearlayout1.visibility= View.GONE
                            binding.linearlayout.visibility= View.VISIBLE
                            binding.rvMyTestimonials.visibility= View.VISIBLE
                            binding.NoGuestInvited.visibility= View.GONE
                            binding.TotalReview.text= "Total no of Review : "+response.body()?.data?.get(0)?.toalcount
                            val mAdapter = AdapterMyTestimonialsAct(
                                    this@MyTestimonialsActivity, response.body()?.data?.get(0)?.reviewdata as MutableList<Testimonial.DataTestimonial.Reviewdata>,this@MyTestimonialsActivity)
                            binding.rvMyTestimonials.adapter = mAdapter

                        }else{
                            binding.linearlayout1.visibility= View.GONE
                            binding.NoGuestInvited.visibility = View.VISIBLE
                        }
                    }else{
                        binding.linearlayout1.visibility= View.GONE
                        binding.NoGuestInvited.visibility= View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<Testimonial>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    override fun OnClick(position: Int, data: String, type: String, is_viewed: Int) {
        if(type.equals("User Review")) {
            if (count_available==0){
                if (is_viewed==0){
                    PermissionDialog(readUsingSharedPreference(this,"ViewExhaustedMsg").toString())
                }else{
                    val intent = Intent(this, ProfileActivity::class.java)
                    intent.putExtra("id", data)
                    intent.putExtra("type", "MyLead")
                    startActivity(intent)
                }
            }else{
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("id", data)
                intent.putExtra("type", "MyLead")
                startActivity(intent)
            }
        }else{

            val intent = Intent(this, MyEventsDetailsActivity::class.java)
            intent.putExtra("type","Testimonials")
            intent.putExtra("Back","activity")
            intent.putExtra("id", data)
            startActivity(intent)
        }
    }

    private fun PermissionDialog(massage:String){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mbsAddAccountDialog: PlanexpaireddialogBinding = DataBindingUtil.inflate(LayoutInflater.from(this),R.layout.planexpaireddialog, null, false)
        dialog.setContentView(mbsAddAccountDialog.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        mbsAddAccountDialog.massage.setText(massage)

        mbsAddAccountDialog.okbtd.setOnClickListener {
            dialog.dismiss()
        }
        mbsAddAccountDialog.txtUpgrade.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this, MyMembershipBenefitsActivity::class.java))
        }
        dialog.show()
    }
}