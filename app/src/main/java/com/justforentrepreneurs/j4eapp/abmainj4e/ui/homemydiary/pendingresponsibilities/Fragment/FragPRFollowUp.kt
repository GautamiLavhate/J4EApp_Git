package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.Fragment

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
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.CreateBuddyMeetActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.databinding.FragPrBuddyMeetBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.Adapter.AdapterFollowupMeetMonth
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.CreateFollowUpActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.ScheduleDateSortFollow
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.model.FollowUp
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class FragPRFollowUp : BaseFragment(), View.OnClickListener{

    private lateinit var binding: FragPrBuddyMeetBinding
    var is_followup_exhausted: Int = -1
    var count_available: Int = -1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.frag_pr_buddy_meet, container, false)
        initListener()
        recyclerData()
        return binding.root
    }

    private fun recyclerData() {
        val layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.rvMyTestimonials.layoutManager = layoutManager

        if(isInternetAvailable(requireActivity())){
           app_get_fallowup_list()
        }
    }

    private fun initListener() {

        binding.fabAdd.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            binding.fabAdd.id -> {
                if (readUsingSharedPreference(requireContext(),"PermissionCreateFollowUp").equals("0")){
                    PermissionDialog(readUsingSharedPreference(requireContext(),"CreatePermissionMsg").toString())
                }else{
                    if (is_followup_exhausted == 0){
                        startActivity(Intent(context, CreateFollowUpActivity::class.java))
                    }else{
                        PermissionDialog(readUsingSharedPreference(requireContext(),"CreateExhaustedMsg").toString())
                    }

                }

            }

        }

    }

    var buddymeet: MutableList<FollowUp.UserData> = ArrayList<FollowUp.UserData>()

    private fun app_get_fallowup_list(){
        val anim: Animation = AnimationUtils.loadAnimation(requireActivity(), android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)

        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_fallowup_list(readUsingSharedPreference(requireActivity(), "userid").toString())
        call.enqueue(object : Callback<FollowUp> {
            override fun onResponse(
                    call: Call<FollowUp>,
                    response: Response<FollowUp>
            ) {
                dismissLoader()
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            binding.linearlayout1.visibility= View.GONE
                            binding.rvMyTestimonials.visibility= View.VISIBLE
                            binding.NoGuestInvited.visibility= View.GONE
                            is_followup_exhausted = response.body()?.data?.is_followup_exhausted!!
                            count_available = response.body()?.count_available!!
                            buddymeet = response.body()?.data?.followup_info as MutableList<FollowUp.UserData>
                            Collections.sort(buddymeet, ScheduleDateSortFollow())
                            Collections.reverse(buddymeet)
                            val mAdapter = AdapterFollowupMeetMonth(
                                    activity,buddymeet,count_available)
                            binding.rvMyTestimonials.adapter = mAdapter
                        }
                    }else{
                        binding.linearlayout1.visibility= View.GONE
                        binding.rvMyTestimonials.visibility= View.GONE
                        binding.NoGuestInvited.visibility= View.VISIBLE
                        binding.defaultText.text="No FollowUp Meet Available"
                    }
                }
            }

            override fun onFailure(call: Call<FollowUp>, t: Throwable) {
                dismissLoader();
            }
        })

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