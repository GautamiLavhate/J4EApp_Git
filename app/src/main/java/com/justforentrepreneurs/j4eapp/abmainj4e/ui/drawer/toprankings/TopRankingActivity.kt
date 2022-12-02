package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.toprankings

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
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.toprankings.model.TopRank
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myawardrecognition.AdapterRewardList
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyAwardToprankBinding
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopRankingActivity : BaseActivity(),AdapterRewardList.OnClick2 {
    private lateinit var binding: ActivityMyAwardToprankBinding
    var count_available:Int=-1
    override fun enablePresence(): Boolean {
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_award_toprank)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.top_rankings)
        binding.toolbar.ivRewardPoints.visibility = View.GONE


        recyclerData()

        binding.toolbar.ivBack.setOnClickListener {
            onBackPressed()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (intent.getStringExtra("type") == "pro") {

        }else{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun recyclerData() {
        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvAwardRecognition.layoutManager = layoutManager

        if(isInternetAvailable(this)){
            getTopRanking()
        }
    }

    private fun getTopRanking(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_toprank_list(readUsingSharedPreference(this, "userid").toString())
        call.enqueue(object : Callback<TopRank> {
            override fun onResponse(
                    call: Call<TopRank>,
                    response: Response<TopRank>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    count_available=response.body()?.count_available!!
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            if (response.body()?.data?.size == 0){
                                binding.NoGuestInvited.visibility=View.VISIBLE
                            }else{
                                binding.NoGuestInvited.visibility=View.GONE
                            }
                            binding.linearlayout1.visibility=View.GONE
                            binding.rvAwardRecognition.visibility=View.VISIBLE
                            val mAdapter = AdapterRewardList(
                                    this@TopRankingActivity, response.body()?.data as MutableList<TopRank.DataTopRank>,this@TopRankingActivity)
                            binding.rvAwardRecognition.adapter = mAdapter

                        }else{
                            binding.linearlayout1.visibility=View.GONE
                            binding.NoGuestInvited.visibility=View.VISIBLE
                        }
                    }else{
                        binding.linearlayout1.visibility=View.GONE
                        binding.NoGuestInvited.visibility=View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<TopRank>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    override fun OnClickpro(position: Int, data: String, is_viewed: Int) {
        if (count_available==0){
            if (is_viewed==0){
                PermissionDialog(readUsingSharedPreference(this,"ViewExhaustedMsg").toString())
            }else{
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("id",data)
                intent.putExtra("type","MyLead")
                startActivity(intent)
            }
        }else{
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("id",data)
            intent.putExtra("type","MyLead")
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