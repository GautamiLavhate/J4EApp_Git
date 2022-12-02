package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.supportfeedback

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityFeedbackEventBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class FeedbackEventActivity : BaseActivity() {
    private lateinit var binding: ActivityFeedbackEventBinding
    lateinit var eventid:String
    lateinit var eventcatid:String

    override fun enablePresence(): Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_feedback_event)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.feedBack)

        binding.toolbar.ivBack.setOnClickListener {
            onBackPressed()
        }

        if (intent.getStringExtra("type") == "EventReview" ){
            eventid=intent.getStringExtra("id").toString()
            eventcatid=intent.getStringExtra("backType").toString()
        }

        binding.tvSubmit.setOnClickListener {
            if(validation()) {
                if (isInternetAvailable(this)) {
                    val request = ServiceBuilder.buildService(APIinterface::class.java)
                    val sdf = SimpleDateFormat("dd MMM yyyy")
                    val currentDate = sdf.format(Date())

                    val sdf1 = SimpleDateFormat("hh:mm a")
                    val currenttime1 = sdf1.format(Date())

                    val call = request.app_add_event_ratings_reviews(readUsingSharedPreference(this, "userid").toString(),eventid, binding.rating.rating.toString(), binding.edtFeedback.text.toString(), currentDate, currenttime1,eventcatid)
                    showLoaderf(this)
                    call.enqueue(object : Callback<ConnectionDecline> {
                        override fun onResponse(
                                call: Call<ConnectionDecline>,
                                response: Response<ConnectionDecline>
                        ) {
                            dismissLoader();
                            if (response.isSuccessful) {
                                if (response.body()?.status == true) {
                                    displayToast(this@FeedbackEventActivity, response.body()?.message.toString())
                                    val returnIntent = Intent()
                                    returnIntent.putExtra("result", "EventReview")
                                    setResult(RESULT_OK, returnIntent)
                                    finish()

                                } else {
                                    displayToast(this@FeedbackEventActivity, response.body()?.message.toString())
                                }
                            }
                        }

                        override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                            dismissLoader()
                            displayToast(this@FeedbackEventActivity, resources.getString(R.string.error_something_wrong))
                        }
                    })
                }
            }
        }

        binding.tvCancel.setOnClickListener {
            onBackPressed()
        }
    }

    fun validation() : Boolean {

        var Temp: Boolean?= true

        if (binding.rating.rating.toString().equals("0.0")) {
            displayToast(this, "Add Rating")
            Temp = false
        }

        return Temp!!
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}