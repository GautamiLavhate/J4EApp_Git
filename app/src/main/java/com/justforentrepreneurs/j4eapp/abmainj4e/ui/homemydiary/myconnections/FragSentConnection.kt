package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections

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
import com.justforentrepreneurs.j4eapp.abmainj4e.OnClickLiner
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseFragment
import com.justforentrepreneurs.j4eapp.databinding.FragPendingRequirementBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Adapter.AdapterSentConnection
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionReceived
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.DataReceived
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.justforentrepreneurs.j4eapp.databinding.FragPendingConnecsentBinding
import com.justforentrepreneurs.j4eapp.databinding.FragPendingConnectionBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragSentConnection(fragment:String,position:Int) : BaseFragment(),OnClickLiner {
    private val fragmentst:String=fragment
    private lateinit var binding: FragPendingConnecsentBinding
    private val position:Int=position
    var count_available: Int = -1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.frag_pending_connecsent, container, false)
        initListener()
        recyclerData()
        return binding.root
    }

    private fun recyclerData() {
        val anim: Animation = AnimationUtils.loadAnimation(requireActivity(), android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)

        val layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.rvRequirement.layoutManager = layoutManager

        getSendMember()
    }

    private fun initListener() {
    }


    private fun getSendMember(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.getconnection_request_sent_list(readUsingSharedPreference(requireActivity(), "userid").toString())
        call.enqueue(object : Callback<ConnectionReceived> {
            override fun onResponse(
                    call: Call<ConnectionReceived>,
                    response: Response<ConnectionReceived>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.size != 0) {
                            binding.linearlayout1.visibility = View.GONE
                            binding.rvRequirement.visibility=View.VISIBLE
                            binding.NoLeadInvited.visibility=View.GONE
                            count_available=response.body()?.count_available!!
                            val mAdapter = AdapterSentConnection(
                                    activity,
                                    response.body()?.data as MutableList<DataReceived>,this@FragSentConnection,fragmentst,count_available)
                            binding.rvRequirement.adapter = mAdapter
                            binding.rvRequirement.getLayoutManager()?.scrollToPosition(position)

                        }else{
                            binding.linearlayout1.visibility = View.GONE
                            binding.rvRequirement.visibility=View.GONE
                            binding.NoLeadInvited.visibility=View.VISIBLE
                            binding.imagevno.setImageResource(R.drawable.ic_connection_not_available)
                            binding.defaultText.text="No Connection"
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ConnectionReceived>, t: Throwable) {
                dismissLoader();

            }
        })

    }

    override fun onClickPos(
        pos: Int,
        value: String,
        btd: FloatingActionButton,
        mdata: MutableList<DataReceived>
    ) {
        TODO("Not yet implemented")
    }

    override fun onClickDcline(pos: Int, mdata: MutableList<DataReceived>) {
        if (isInternetAvailable(requireActivity())) {
            getgetconnection_request_decline(readUsingSharedPreference(requireActivity(), "userid").toString(), mdata.get(pos).userid,mdata,pos)
        }
    }

    private fun getgetconnection_request_decline(id:String, senderid:String, mdata: MutableList<DataReceived>, pos: Int) {
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.getconnection_request_decline(id,senderid)
        showLoaderf(activity);
        call.enqueue(object : Callback<ConnectionDecline> {
            override fun onResponse(
                call: Call<ConnectionDecline>,
                response: Response<ConnectionDecline>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        mdata.removeAt(pos)
                        binding.rvRequirement.adapter?.notifyDataSetChanged()
                        activity?.let { displayToast(it,response.body()?.message.toString()) }
                    }else{
                        activity?.let { displayToast(it,response.body()?.message.toString()) }
                    }
                }
            }

            override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                dismissLoader();

            }
        })
    }
}