package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myreportcard

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
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyReportCardBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myreportcard.Model.MyReportData
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.dismissLoader
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.displayToast
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.readUsingSharedPreference
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.showLoader
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MyReportCardActivity : BaseActivity() {
    private lateinit var binding: ActivityMyReportCardBinding
    override fun enablePresence(): Boolean {
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_report_card)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.my_report_card)
      //  customModelData()

        recyclerData()
    }



    private fun recyclerData() {

        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvMyReportCard.layoutManager = layoutManager


        getMyGuestInvites()
    }

    private fun getMyGuestInvites() {
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_my_report_card(readUsingSharedPreference(this, "userid").toString())
        call.enqueue(object : Callback<MyReportData> {
            override fun onResponse(
                    call: Call<MyReportData>,
                    response: Response<MyReportData>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {

                            binding.totalpoints.text=response.body()?.data?.get(0)?.TotalReward1?.total_point

                            binding.linearlayout1.visibility= View.GONE
                            binding.rvMyReportCard.visibility= View.VISIBLE

                            val mAdapter = AdapterMyReportCard(
                                    this@MyReportCardActivity,response.body()?.data?.get(0)?.RewardDetail1 as MutableList<MyReportData.Data.RewardDetail>

                            )
                            binding.rvMyReportCard.adapter = mAdapter

                        }else{
                            binding.linearlayout1.visibility= View.GONE
                            binding.rvMyReportCard.visibility= View.VISIBLE
                        }
                    }else{
                        binding.linearlayout1.visibility= View.GONE
                        binding.rvMyReportCard.visibility= View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<MyReportData>, t: Throwable) {
                dismissLoader();
            }
        })

    }
}