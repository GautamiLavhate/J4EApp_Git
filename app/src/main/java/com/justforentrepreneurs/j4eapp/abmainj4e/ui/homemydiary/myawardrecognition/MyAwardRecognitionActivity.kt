package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myawardrecognition

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
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyAwardRecognitionBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myawardrecognition.model.MyAward
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyAwardRecognitionActivity : BaseActivity() {
    override fun enablePresence(): Boolean {
        return true
    }
    private lateinit var binding: ActivityMyAwardRecognitionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_award_recognition)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.award)
        binding.toolbar.ivRewardPoints.visibility = View.GONE
        recyclerData()
    }

    private fun recyclerData() {
        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvAwardRecognition.layoutManager = layoutManager

        if(isInternetAvailable(this)){
            app_get_award_recognition()
        }
    }
    private fun app_get_award_recognition(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_award_recognition(readUsingSharedPreference(this, "userid").toString())

        call.enqueue(object : Callback<MyAward> {
            override fun onResponse(
                    call: Call<MyAward>,
                    response: Response<MyAward>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            binding.linearlayout1.visibility= View.GONE
                            binding.rvAwardRecognition.visibility= View.VISIBLE
                            binding.NoGuestInvited.visibility= View.GONE
                            val mAdapter = AdapterAwardRecognition(
                                    this@MyAwardRecognitionActivity,response.body()?.data as MutableList<MyAward.DataMyAward>

                            )
                            binding.rvAwardRecognition.adapter = mAdapter

                        }else{
                            binding.linearlayout1.visibility= View.GONE
                        }
                    }else{
                        binding.linearlayout1.visibility= View.GONE
                        binding.rvAwardRecognition.visibility= View.GONE
                        binding.NoGuestInvited.visibility= View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<MyAward>, t: Throwable) {
                dismissLoader();

            }
        })

    }
}