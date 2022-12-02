package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyLeadsStatusListBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.Adapter.AdapterMyLeadsStatusList
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model.MyLeadStatus
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyLeadsStatusListActivity : BaseActivity() {

    private lateinit var binding: ActivityMyLeadsStatusListBinding
    lateinit var requiremenid:String
    lateinit var reconmmend_user:String
    var txt:String=""
    lateinit var OwnRe:String
    var isFrom:String=""

    override fun enablePresence(): Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_leads_status_list)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.lead_status)

        requiremenid=intent.getStringExtra("id").toString()

        reconmmend_user=intent.getStringExtra("reconmmend_user").toString()

        isFrom=intent.getStringExtra("isFrom").toString()

        OwnRe=intent.getStringExtra("own").toString()

        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.abStatuslead.startAnimation(anim)

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvStatuslead.layoutManager = layoutManager

        if(OwnRe.equals("own")) {
            if (isInternetAvailable(this)) {
                getMyLeadsStatusList(readUsingSharedPreference(this, "userid").toString())
            }
        }else{
            if (isInternetAvailable(this)) {
                getMyLeadsStatusList(reconmmend_user)
            }
        }

    }


    override fun onBackPressed() {
        super.onBackPressed()
    }

    fun OnLeadStatusAdd(view: View) {
        val intent = Intent(this, MyLeadsStatusAddActivity::class.java)
        intent.putExtra("id",requiremenid)
        intent.putExtra("reconmmend_user",reconmmend_user)
        intent.putExtra("own",OwnRe)
        startActivityForResult(intent,1001)
    }

    private fun getMyLeadsStatusList(reconmmend_user:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_user_lead_status(reconmmend_user,requiremenid)
        //displayToast(this,reconmmend_user+","+requiremenid)
        call.enqueue(object : Callback<MyLeadStatus> {
            override fun onResponse(
                    call: Call<MyLeadStatus>,
                    response: Response<MyLeadStatus>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.size != 0) {
                            binding.abStatuslead.visibility=View.GONE
                            binding.rvStatuslead.visibility=View.VISIBLE

                            val mAdapter = AdapterMyLeadsStatusList(
                                    this@MyLeadsStatusListActivity,
                                    response.body()?.data as MutableList<MyLeadStatus.DataLeadSt>
                            )
                            binding.rvStatuslead.adapter = mAdapter

                            for (i in 0 until (response.body()?.data as MutableList<MyLeadStatus.DataLeadSt>).size) {
                                if(response.body()?.data?.get(i)?.status_catid=="3"){
                                    binding.toolbar.ivAdd.visibility=View.GONE

                                }else{
                                    if (isFrom.equals("list")){
                                        if (reconmmend_user.equals(readUsingSharedPreference(this@MyLeadsStatusListActivity,"userid"))){
                                            binding.toolbar.ivAdd.visibility=View.VISIBLE
                                        }else{
                                            binding.toolbar.ivAdd.visibility=View.GONE
                                        }
                                    }else{
                                        binding.toolbar.ivAdd.visibility=View.VISIBLE
                                    }

                                }
                            }


                        }else{
                            binding.abStatuslead.visibility=View.GONE
                            binding.rvStatuslead.visibility=View.VISIBLE
                            displayToast(this@MyLeadsStatusListActivity,  response.body()?.message.toString())
                        }
                    }else{
                        binding.abStatuslead.visibility=View.GONE
                        binding.rvStatuslead.visibility=View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<MyLeadStatus>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1001){
            OwnRe=intent.getStringExtra("own").toString()
            if(OwnRe.equals("own")) {
                if (isInternetAvailable(this)) {
                    getMyLeadsStatusList(readUsingSharedPreference(this, "userid").toString())
                }
            }else{
                if (isInternetAvailable(this)) {
                    getMyLeadsStatusList(reconmmend_user)
                }
            }
            if(txt.equals("3")){

                binding.toolbar.ivAdd.visibility=View.GONE
            }
        }
    }


}