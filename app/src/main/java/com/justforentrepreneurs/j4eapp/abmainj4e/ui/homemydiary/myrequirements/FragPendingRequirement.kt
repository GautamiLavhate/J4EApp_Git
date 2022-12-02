package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrequirements

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseFragment
import com.justforentrepreneurs.j4eapp.databinding.FragPendingRequirementBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.MyLeadsDetailActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrequirements.adapter.AdapterPendingRequirement
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrequirements.model.MyRequirement
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrequirements.model.MyRequirementpending
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragPendingRequirement : BaseFragment(),AdapterPendingRequirement.OnClick2 {

    private lateinit var binding: FragPendingRequirementBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.frag_pending_requirement, container, false)
        recyclerData()
        return binding.root
    }

    private fun recyclerData() {
        val anim: Animation = AnimationUtils.loadAnimation(requireActivity(), android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)

        val layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.rvRequirement.layoutManager = layoutManager

        if (isInternetAvailable(requireActivity())) {
            getRequirements()
        }
    }


    private fun getRequirements(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_my_requirements(readUsingSharedPreference(requireActivity(), "userid").toString())
        call.enqueue(object : Callback<MyRequirement> {
            override fun onResponse(
                    call: Call<MyRequirement>,
                    response: Response<MyRequirement>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.user_data != null) {
                            binding.linearlayout1.visibility = View.GONE
                            binding.rvRequirement.visibility=View.VISIBLE
                            binding.NoLeadInvited.visibility=View.GONE
                            val mAdapter = AdapterPendingRequirement(
                                    activity,
                                    response.body()?.user_data as MutableList<MyRequirementpending>,this@FragPendingRequirement)
                            binding.rvRequirement.adapter = mAdapter

                        }
                    }else{
                        binding.linearlayout1.visibility = View.GONE
                        binding.rvRequirement.visibility=View.GONE
                        binding.NoLeadInvited.visibility=View.VISIBLE
                        binding.defaultText.text="No Requirement"
                    }
                }
            }

            override fun onFailure(call: Call<MyRequirement>, t: Throwable) {
                dismissLoader();

            }
        })

    }

    override fun OnClick(position: Int, data: String) {
        val intent = Intent(requireActivity(), MyLeadsDetailActivity::class.java)
        intent.putExtra("type", "requirement")
        intent.putExtra("id",data)
        startActivityForResult(intent,1003)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1003){
            if (isInternetAvailable(requireActivity())) {
               // getRequirements()
            }
        }
    }
}