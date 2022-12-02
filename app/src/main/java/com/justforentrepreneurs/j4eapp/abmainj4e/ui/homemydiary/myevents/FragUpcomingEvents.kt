package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents

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
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment.model.Allevents
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.Adapter.AdapterUpcomingEvents
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.databinding.FragPendingEventsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragUpcomingEvents(position:Int) : BaseFragment(){
    private val position:Int=position
    var companyName: MutableList<Allevents.Alleventsdata> = mutableListOf<Allevents.Alleventsdata>()

    private lateinit var binding: FragPendingEventsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.frag_pending_events, container, false)

        val anim: Animation = AnimationUtils.loadAnimation(requireActivity(), android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)

        recyclerData()
        return binding.root
    }


    private fun recyclerData() {
        val layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.rvRequirement.layoutManager = layoutManager
        if(isInternetAvailable(requireActivity())){
            getUpcomingEvents()
        }

    }

    private fun getUpcomingEvents(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)

        val call = request.app_get_event_list("2", readUsingSharedPreference(requireActivity(), "userid").toString())
        call.enqueue(object : Callback<Allevents> {
            override fun onResponse(
                    call: Call<Allevents>,
                    response: Response<Allevents>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            binding.linearlayout1.visibility = View.GONE
                            binding.NoLeadInvited.visibility = View.GONE
                            binding.rvRequirement.visibility = View.VISIBLE

                            if(readUsingSharedPreference(requireActivity(), "addpersmisson").toString().equals("1")) {
                                companyName.clear()
                                companyName.addAll(response.body()?.data!!)
                            }else{
                                companyName.clear()
                                for (j in 0 until response.body()?.data!!.size) {
                                    if(response.body()?.data?.get(j)?.event_publish_status.toString().equals("2")){

                                    }else{
                                        companyName.add(response.body()?.data?.get(j)!!)
                                    }
                                }
                            }

                            val mAdapter = AdapterUpcomingEvents(requireActivity(),companyName,"activity")
                            binding.rvRequirement.adapter = mAdapter
                            binding.rvRequirement.getLayoutManager()?.scrollToPosition(position)

                        }
                    }else{
                        binding.linearlayout1.visibility = View.GONE
                        binding.rvRequirement.visibility = View.GONE
                        binding.NoLeadInvited.visibility = View.VISIBLE
                        binding.defaultText.text="No Events Available"
                    }
                }
            }

            override fun onFailure(call: Call<Allevents>, t: Throwable) {
                dismissLoader();
            }
        })

    }

}