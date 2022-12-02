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
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment.model.Allevents
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.Adapter.AdapterPastEvents
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.databinding.FragPendingEventsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragPastEvents : BaseFragment(){

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
            getPastEvents()
        }

    }

    private fun getPastEvents(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_event_list("3", readUsingSharedPreference(requireActivity(), "userid").toString())
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
                            binding.rvRequirement.visibility = View.VISIBLE
                            binding.NoLeadInvited.visibility = View.GONE
                            val mAdapter = AdapterPastEvents(
                                    activity,
                                    response.body()?.data as MutableList<Allevents.Alleventsdata>
                            )
                            binding.rvRequirement.adapter = mAdapter

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
                displayToast(requireActivity(),requireActivity().resources.getString(R.string.error_something_wrong))
            }
        })

    }


}