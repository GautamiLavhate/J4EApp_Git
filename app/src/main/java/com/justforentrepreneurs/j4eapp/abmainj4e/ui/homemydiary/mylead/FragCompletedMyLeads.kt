package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mylead

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseFragment
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.MyLeadsDetailActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mylead.adapter.AdapterCompletedMyLead
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mylead.model.MyLeadcomplete
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.databinding.FragPendingMyleadsBinding
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragCompletedMyLeads : BaseFragment(),AdapterCompletedMyLead.OnClick2{
    private lateinit var binding: FragPendingMyleadsBinding
    var count_available: Int = -1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.frag_pending_myleads, container, false)

        recyclerData()
        return binding.root
    }

    private fun recyclerData() {
        val anim: Animation = AnimationUtils.loadAnimation(requireActivity(), android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)

        val layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.rvRequirement.layoutManager = layoutManager

        if (isInternetAvailable(requireActivity())) {
            if (readUsingSharedPreference(requireContext(),"PermissionViewLeads").equals("0")){
                PermissionDialog(readUsingSharedPreference(requireContext(),"ViewPermissionMsg").toString())
            }else{
                getMycompleteLead()
            }

        }
    }

    private fun getMycompleteLead(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_complete_leads(readUsingSharedPreference(requireActivity(), "userid").toString())
        call.enqueue(object : Callback<MyLeadcomplete> {
            override fun onResponse(
                    call: Call<MyLeadcomplete>,
                    response: Response<MyLeadcomplete>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.user_data != null) {
                            binding.linearlayout1.visibility = View.GONE
                            binding.rvRequirement.visibility=View.VISIBLE
                            binding.NoLeadInvited.visibility=View.GONE
                            count_available=response.body()?.count_available!!
                            val mAdapter = AdapterCompletedMyLead(
                                    activity,
                                    response.body()?.user_data as MutableList<MyLeadcomplete.MyRequirementpending>,this@FragCompletedMyLeads)
                            binding.rvRequirement.adapter = mAdapter

                        }
                    }else{
                        binding.linearlayout1.visibility = View.GONE
                        binding.rvRequirement.visibility=View.GONE
                        binding.NoLeadInvited.visibility=View.VISIBLE
                        binding.defaultText.text="No Leads Available"
                    }
                }
            }

            override fun onFailure(call: Call<MyLeadcomplete>, t: Throwable) {
                dismissLoader();

            }
        })

    }

    override fun OnClick(position: Int, data: String, requser: String, viewed:Int) {
        if (count_available==0){
            if (viewed==0){
                PermissionDialog(readUsingSharedPreference(requireContext(),"ViewExhaustedMsg").toString())
            }else{
                val intent = Intent(requireActivity(), MyLeadsDetailActivity::class.java)
                intent.putExtra("type", "MyLead")
                intent.putExtra("id",data)
                intent.putExtra("requireUserid",requser)
                intent.putExtra("own","own")
                startActivityForResult(intent,1003)
            }
        }else{
            val intent = Intent(requireActivity(), MyLeadsDetailActivity::class.java)
            intent.putExtra("type", "MyLead")
            intent.putExtra("id",data)
            intent.putExtra("requireUserid",requser)
            intent.putExtra("own","own")
            startActivityForResult(intent,1003)
        }

    }

    override fun OnClickpro(position: Int, data: String, is_viewed: Int) {
        if (count_available == 0){
            if (is_viewed==0){
                PermissionDialog(readUsingSharedPreference(requireContext(),"ViewExhaustedMsg").toString())
            }else{
                val intent = Intent(requireActivity(), ProfileActivity::class.java)
                intent.putExtra("id",data)
                intent.putExtra("type","MyLead")
                startActivityForResult(intent,1003)
            }
        }else{
            val intent = Intent(requireActivity(), ProfileActivity::class.java)
            intent.putExtra("id",data)
            intent.putExtra("type","MyLead")
            startActivityForResult(intent,1003)
        }

    }
    private fun PermissionDialog(massage:String){
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mbsAddAccountDialog: PlanexpaireddialogBinding = DataBindingUtil.inflate(LayoutInflater.from(requireContext()),R.layout.planexpaireddialog, null, false)
        dialog.setContentView(mbsAddAccountDialog.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        mbsAddAccountDialog.massage.setText(massage)

        mbsAddAccountDialog.okbtd.setOnClickListener {
            dialog.dismiss()
        }
        mbsAddAccountDialog.txtUpgrade.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(requireContext(), MyMembershipBenefitsActivity::class.java))
        }
        dialog.show()
    }
}