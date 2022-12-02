package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityEventJoinerBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.Datauser
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.J4EMember
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.Adapter.EventJoinerAdapter
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.model.EventRegister
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.ConnectionSend
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventJoinerActivity : BaseActivity(),EventJoinerAdapter.OnClick2 {
    override fun enablePresence(): Boolean {
        return true
    }

    private lateinit var binding: ActivityEventJoinerBinding
    var query:String=""

     var eventid:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_event_joiner)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.registered_members)

        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)

        setEventJoinerData()



        binding.searchLinLay.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText != "" || newText.length != 0) {
                    query = newText
                    if (isInternetAvailable(this@EventJoinerActivity)) {
                        binding.recyclerView.setAdapter(null)
                        getDataMember(query.toString())

                    }
                }else {
                   binding.recyclerView.setAdapter(null)
                    getDataMember("")
                }
                return false
            }
        })
    }

    private fun setEventJoinerData() {
        eventid=intent.getStringExtra("id").toString()
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclerView.layoutManager = layoutManager

        if (isInternetAvailable(this)) {
            getDataMember()
        }
    }

    private fun getDataMember(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_event_register_list(readUsingSharedPreference(this, "userid").toString(), eventid,"")
        call.enqueue(object : Callback<EventRegister> {
            override fun onResponse(
                    call: Call<EventRegister>,
                    response: Response<EventRegister>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.size != 0) {

                            binding.linearlayout1.visibility = View.GONE
                            binding.recyclerView.visibility = View.VISIBLE
                            binding.NoLeadInvited.visibility = View.GONE

                            val mAdapter = EventJoinerAdapter(this@EventJoinerActivity,
                                    response.body()?.data as MutableList<EventRegister.Datauser>,this@EventJoinerActivity)
                            binding.recyclerView.adapter = mAdapter

                        }
                    } else {
                        binding.linearlayout1.visibility = View.GONE
                        binding.recyclerView.visibility = View.GONE
                        binding.NoLeadInvited.visibility = View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<EventRegister>, t: Throwable) {
                dismissLoader();

            }
        })

    }

    private fun getDataMember(key:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_event_register_list(readUsingSharedPreference(this, "userid").toString(), eventid,key)
        call.enqueue(object : Callback<EventRegister> {
            override fun onResponse(
                call: Call<EventRegister>,
                response: Response<EventRegister>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.size != 0) {
                            binding.linearlayout1.visibility = View.GONE
                            binding.recyclerView.visibility = View.VISIBLE
                            binding.NoLeadInvited.visibility = View.GONE

                            val mAdapter = EventJoinerAdapter(this@EventJoinerActivity,
                                response.body()?.data as MutableList<EventRegister.Datauser>,this@EventJoinerActivity)
                            binding.recyclerView.adapter = mAdapter

                        }
                    } else {
                        binding.linearlayout1.visibility = View.GONE
                        binding.recyclerView.visibility = View.GONE
                        binding.NoLeadInvited.visibility = View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<EventRegister>, t: Throwable) {
                dismissLoader();

            }
        })

    }


    override fun OnClick(position: Int, mdata: MutableList<Datauser>, lilayout: LinearLayout) {

    }

    override fun OnClickpro(position: Int, data: String) {
        val intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra("id",data)
        intent.putExtra("type","MyLead")
        startActivityForResult(intent,1003)
    }


}