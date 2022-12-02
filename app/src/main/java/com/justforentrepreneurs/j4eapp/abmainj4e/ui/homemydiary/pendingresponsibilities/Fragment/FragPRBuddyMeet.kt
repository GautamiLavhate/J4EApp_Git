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
import com.justforentrepreneurs.j4eapp.databinding.FragPrBuddyMeetBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.CreateBuddyMeetActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.Adapter.AdapterBuddyMeetMonth
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.ScheduleDateSort
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.model.Buddymeet
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.databinding.FragPrFollowupBinding
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class FragPRBuddyMeet : BaseFragment(), View.OnClickListener{

    private lateinit var binding: FragPrFollowupBinding
    var is_buddy_meet_exhausted: Int = -1
    var count_available: Int = -1
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.frag_pr_followup, container, false)
        initListener()
        recyclerData()
        return binding.root
    }

    private fun recyclerData() {
        val layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.rvMyTestimonials.layoutManager = layoutManager



        if(isInternetAvailable(requireActivity())){
            app_get_Buddymeet_list()
        }
    }

    private fun initListener() {
        binding.fabAdd.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            binding.fabAdd.id -> {
                if (readUsingSharedPreference(requireContext(),"PermissionCreateBuddyMeet").equals("0")){
                    PermissionDialog(readUsingSharedPreference(requireContext(),"CreatePermissionMsg").toString())
                }else{
                    if (is_buddy_meet_exhausted == 0){
                        val intent = Intent(context, CreateBuddyMeetActivity::class.java)
                        intent.putExtra("type", "fragbuddymeet")
                        startActivity(intent)
                    }else{
                        PermissionDialog(readUsingSharedPreference(requireContext(),"CreateExhaustedMsg").toString())
                    }

                }

            }

        }
    }
    var buddymeet: MutableList<Buddymeet.UserData> = ArrayList<Buddymeet.UserData>()
    private fun app_get_Buddymeet_list(){
        val anim: Animation = AnimationUtils.loadAnimation(requireActivity(), android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)

        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_buddy_meet_list(readUsingSharedPreference(requireActivity(), "userid").toString())
        call.enqueue(object : Callback<Buddymeet> {
            override fun onResponse(
                    call: Call<Buddymeet>,
                    response: Response<Buddymeet>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {

                            binding.linearlayout1.visibility= View.GONE
                            binding.rvMyTestimonials.visibility= View.VISIBLE
                            binding.NoGuestInvited.visibility= View.GONE

                            is_buddy_meet_exhausted = response.body()?.data?.is_buddy_meet_exhausted!!
                            count_available = response.body()?.count_available!!
                            buddymeet = response.body()?.data?.buddy_meet_info as MutableList<Buddymeet.UserData>
                            Collections.sort(buddymeet, ScheduleDateSort())
                            Collections.reverse(buddymeet)
                            val mAdapter = AdapterBuddyMeetMonth(activity, buddymeet,count_available)
                            binding.rvMyTestimonials.adapter = mAdapter

                        }
                    } else {
                        binding.linearlayout1.visibility= View.GONE
                        binding.rvMyTestimonials.visibility= View.GONE
                        binding.NoGuestInvited.visibility= View.VISIBLE
                        binding.defaultText.text="No Buddy Meet Available"
                    }
                }
            }

            override fun onFailure(call: Call<Buddymeet>, t: Throwable) {
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