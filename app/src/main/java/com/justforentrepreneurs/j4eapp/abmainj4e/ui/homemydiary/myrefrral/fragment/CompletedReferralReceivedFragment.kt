package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrefrral.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.MyLeadsDetailActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrefrral.adapter.AdapterCompletedReferral
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrefrral.model.Data
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrefrral.model.ReferralResponse
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.dismissLoader
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.displayToast
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.isInternetAvailable
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.readUsingSharedPreference
import com.justforentrepreneurs.j4eapp.databinding.FragmentCompletedReferralReceivedBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CompletedReferralReceivedFragment : Fragment(),AdapterCompletedReferral.OnClick2 {
    private lateinit var binding:FragmentCompletedReferralReceivedBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_completed_referral_received, container, false)
        recyclerData()
        return binding.root
    }
    private fun recyclerData() {

        val anim: Animation = AnimationUtils.loadAnimation(requireActivity(), android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)

        val layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.rvRequirement.layoutManager = layoutManager


        if (isInternetAvailable(requireActivity())) {
            getCompletedRequirements()
        }

    }

    private fun getCompletedRequirements() {
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_complete_referral_received(readUsingSharedPreference(requireActivity(), "userid").toString())
        call.enqueue(object : Callback<ReferralResponse> {
            override fun onResponse(
                call: Call<ReferralResponse>,
                response: Response<ReferralResponse>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.size != 0) {
                            binding.linearlayout1.visibility = View.GONE
                            binding.rvRequirement.visibility=View.VISIBLE
                            binding.NoLeadInvited.visibility=View.GONE
                            val mAdapter = AdapterCompletedReferral(
                                activity,
                                response.body()?.data as MutableList<Data>, this@CompletedReferralReceivedFragment,"Receive"
                            )
                            binding.rvRequirement.adapter = mAdapter

                        }
                    } else {
                        binding.linearlayout1.visibility = View.GONE
                        binding.rvRequirement.visibility=View.GONE
                        binding.NoLeadInvited.visibility=View.VISIBLE
                        binding.defaultText.text="No Referrals"
                        //displayToast(requireActivity(),response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ReferralResponse>, t: Throwable) {
                dismissLoader();
                displayToast(requireActivity(), requireActivity().resources.getString(R.string.error_something_wrong))
            }
        })

    }

    override fun OnClick(position: Int, data: String) {
        val intent = Intent(requireActivity(), MyLeadsDetailActivity::class.java)
        intent.putExtra("type", "referral")
        intent.putExtra("id",data)
        intent.putExtra("referral_type","received")
        intent.putExtra("back_type","ref_received")
        intent.putExtra("own","own")
        startActivity(intent)
    }

    override fun OnClickpro(position: Int, data: String) {
        val intent = Intent(requireActivity(), ProfileActivity::class.java)
        intent.putExtra("id",data)
        intent.putExtra("type","MyLead")
        startActivity(intent)
    }

}