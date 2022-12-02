package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrecognition

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyRecognitionBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrecognition.model.Recognition
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyRecognitionActivity : BaseActivity() {
    private lateinit var binding: ActivityMyRecognitionBinding
    lateinit var allrecognition:String
    override fun enablePresence(): Boolean {
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_recognition)
        binding.lifecycleOwner = this

        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)

        recyclerData()

        if (intent.getStringExtra("type") != null && intent.getStringExtra("type") == "all_recognition") {
            binding.toolbar.tvTitle.text = resources.getText(R.string.all_recognition)
            allrecognition="all_recognition"
            if(isInternetAvailable(this)){
                getMyReCognition("1")
            }

        } else {
            allrecognition="My_recognition"
            binding.toolbar.tvTitle.text = resources.getText(R.string.my_recognition)
            if(isInternetAvailable(this)){
                getMyReCognition("2")
            }
        }

        binding.fabClose.setOnClickListener {
            val intent = Intent(this, MyRecognitionAddActivity::class.java)
            intent.putExtra("type", allrecognition)
            startActivity(intent)
        }

        binding.toolbar.ivBack.setOnClickListener {
            onBackPressed()
        }


    }


    override fun onBackPressed() {
        super.onBackPressed()
        if(intent.getStringExtra("noti").toString().equals("serach")){

        }else {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }



    private fun recyclerData() {
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvMyTestimonials.layoutManager = layoutManager
    }

    private fun getMyReCognition(type:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_recognition(readUsingSharedPreference(this, "userid").toString(),type)
        call.enqueue(object : Callback<Recognition> {
            override fun onResponse(
                    call: Call<Recognition>,
                    response: Response<Recognition>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            binding.linearlayout1.visibility= View.GONE
                            binding.rvMyTestimonials.visibility= View.VISIBLE
                            binding.NoGuestInvited.visibility= View.GONE
                            val mAdapter = AdapterMyRecognition(
                                    this@MyRecognitionActivity,response.body()?.data as MutableList<Recognition.DataReco>
                            )
                            binding.rvMyTestimonials.adapter = mAdapter

                        }
                    }else{
                        binding.linearlayout1.visibility= View.GONE
                        binding.rvMyTestimonials.visibility= View.GONE
                        binding.NoGuestInvited.visibility= View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<Recognition>, t: Throwable) {
                dismissLoader();

            }
        })

    }

}