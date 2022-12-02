package com.justforentrepreneurs.j4eapp.abmainj4e.ui.home

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
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.J4EMembersActivity
import com.justforentrepreneurs.j4eapp.databinding.FragAllLeadsBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.MyLeadsDetailActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.Adapter.AdapterAllLead
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.LeadsAll
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.UserdataLead
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.permissions.PermissionsResponse
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragAllLeads(position:Int) : BaseFragment(),AdapterAllLead.OnClick2{

    private lateinit var binding: FragAllLeadsBinding
    private val position:Int=position
    var count_available:Int=-1
    var is_post_exhausted: Int = -1
    var is_requirement_exhausted: Int = -1
    var is_buddy_meet_exhausted: Int = -1
    var is_referral_exhausted: Int = -1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_all_leads, container, false)
        recyclerData()
        return binding.root
    }

    private fun recyclerData() {
        val anim: Animation = AnimationUtils.loadAnimation(requireActivity(), android.R.anim.fade_in)
        binding.linearlayout.startAnimation(anim)

        val layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.rvAllLeads.layoutManager = layoutManager

        if (isInternetAvailable(requireActivity())) {
//            if (readUsingSharedPreference(requireContext(),"PermissionViewLeads").equals("0")){
//                PermissionDialog("You don't have permission to View Leads.")
//            }else{
//                getAllLeads()
//            }

            getAllLeads()
            app_check_permissions()

        }

    }

    private fun app_check_permissions(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_home_screen_permission(readUsingSharedPreference(requireContext(), "userid").toString())
        //showLoader(this);
        call.enqueue(object : Callback<PermissionsResponse> {
            override fun onResponse(
                call: Call<PermissionsResponse>,
                response: Response<PermissionsResponse>
            ) {

                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.permissions?.size!=0){
                            for (i in 0 until response.body()?.data?.permissions?.size!!) {
                                is_post_exhausted=response.body()?.data?.is_post_exhausted!!
                                is_requirement_exhausted=response.body()?.data?.is_requirement_exhausted!!
                                is_buddy_meet_exhausted=response.body()?.data?.is_buddy_meet_exhausted!!
                                is_referral_exhausted=response.body()?.data?.is_buddy_meet_exhausted!!
                                if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("1")){
                                    storeUsingSharedPreference(requireContext(),"PermissionCreatePost",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("2")){
                                    storeUsingSharedPreference(requireContext(),"PermissionCreateRequirement",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("3")){
                                    storeUsingSharedPreference(requireContext(),"PermissionCreateBuddyMeet",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("4")){
                                    storeUsingSharedPreference(requireContext(),"PermissionCreateFollowUp",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("5")){
                                    storeUsingSharedPreference(requireContext(),"PermissionCreateAddGalleryImage",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("6")){
                                    storeUsingSharedPreference(requireContext(),"PermissionConnectionRequest",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("7")){
                                    storeUsingSharedPreference(requireContext(),"PermissionCreateRecommendation",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("8")){
                                    storeUsingSharedPreference(requireContext(),"PermissionReview",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("9")){
                                    storeUsingSharedPreference(requireContext(),"PermissionViewJ4EmemberProfile",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("10")){
                                    storeUsingSharedPreference(requireContext(),"PermissionViewLeads",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("11")){
                                    storeUsingSharedPreference(requireContext(),"PermissionCreateReferral",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }
                            }
                        }else{
                            storeUsingSharedPreference(requireContext(),"PermissionCreatePost","0")
                            storeUsingSharedPreference(requireContext(),"PermissionCreateRequirement","0")
                            storeUsingSharedPreference(requireContext(),"PermissionCreateBuddyMeet","0")
                            storeUsingSharedPreference(requireContext(),"PermissionCreateFollowUp","0")
                            storeUsingSharedPreference(requireContext(),"PermissionCreateAddGalleryImage","0")
                            storeUsingSharedPreference(requireContext(),"PermissionConnectionRequest","0")
                            storeUsingSharedPreference(requireContext(),"PermissionCreateRecommendation","0")
                            storeUsingSharedPreference(requireContext(),"PermissionReview","0")
                            storeUsingSharedPreference(requireContext(),"PermissionViewJ4EmemberProfile","0")
                            storeUsingSharedPreference(requireContext(),"PermissionViewLeads","0")
                            storeUsingSharedPreference(requireContext(),"PermissionCreateReferral","0")

                        }
                    } else {

                    }
                }
            }

            override fun onFailure(call: Call<PermissionsResponse>, t: Throwable) {
                dismissLoader();
            }
        })

    }
    private fun getAllLeads(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_all_leads(readUsingSharedPreference(requireActivity(), "userid").toString())
       // showLoader(requireActivity());
        call.enqueue(object : Callback<LeadsAll> {
            override fun onResponse(
                    call: Call<LeadsAll>,
                    response: Response<LeadsAll>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.user_data != null) {
                            storeUsingSharedPreference(
                                requireActivity(),
                                "LeadCountOld", response.body()?.user_data?.size.toString()
                            )
                            binding.linearlayout.visibility=View.GONE
                            binding.rvAllLeads.visibility=View.VISIBLE
                            binding.NoLeadInvited.visibility=View.GONE
                            val mAdapter = AdapterAllLead(
                                    activity,
                                    response.body()?.user_data as MutableList<UserdataLead>,this@FragAllLeads
                            )
                            binding.rvAllLeads.adapter = mAdapter
                            binding.rvAllLeads.getLayoutManager()?.scrollToPosition(position);
                            count_available=response.body()?.count_available!!


                        }
                    }else{
                        binding.linearlayout.visibility=View.GONE
                        binding.rvAllLeads.visibility=View.GONE
                        binding.NoLeadInvited.visibility=View.VISIBLE
                        binding.defaultText.text="No Leads Available"
                    }
                }
            }

            override fun onFailure(call: Call<LeadsAll>, t: Throwable) {
                dismissLoader();
                displayToast(requireActivity(),requireActivity().resources.getString(R.string.error_something_wrong))
            }
        })

    }

    override fun OnClick(position: Int, data: String, requser: String,is_viewed: Int) {
        if (count_available==0){
            if (is_viewed==0){
                PermissionDialog(readUsingSharedPreference(requireContext(),"ViewExhaustedMsg").toString())
            }else{
                val intent = Intent(requireActivity(), MyLeadsDetailActivity::class.java)
                intent.putExtra("id",data)
                intent.putExtra("position",position.toString())
                intent.putExtra("requireUserid",requser)
                intent.putExtra("own","own")
                intent.putExtra("type", "AllLead")
                startActivity(intent)
            }
        }else{
            val intent = Intent(requireActivity(), MyLeadsDetailActivity::class.java)
            intent.putExtra("id",data)
            intent.putExtra("position",position.toString())
            intent.putExtra("requireUserid",requser)
            intent.putExtra("own","own")
            intent.putExtra("type", "AllLead")
            startActivity(intent)
        }

    }

    override fun OnClickpro(position: Int, data: String,viewed:Int) {
        if (count_available==0){
            if (viewed==0){
                PermissionDialog(readUsingSharedPreference(requireContext(),"ViewExhaustedMsg").toString())
            }else{
                val intent = Intent(requireActivity(), ProfileActivity::class.java)
                intent.putExtra("id",data)
                intent.putExtra("type","AllLeadhome")
                intent.putExtra("position",position.toString())
                startActivity(intent)
            }
        }else{
            val intent = Intent(requireActivity(), ProfileActivity::class.java)
            intent.putExtra("id",data)
            intent.putExtra("type","AllLeadhome")
            intent.putExtra("position",position.toString())
            startActivity(intent)
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