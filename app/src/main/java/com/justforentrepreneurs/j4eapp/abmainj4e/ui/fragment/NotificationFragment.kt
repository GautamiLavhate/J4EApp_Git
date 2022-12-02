package com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.network.model.Datauser
import com.justforentrepreneurs.j4eapp.abmainj4e.network.model.NotificationModel
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.notification.NotificationAdapter
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import kotlinx.android.synthetic.main.activity_notification.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotificationFragment : Fragment(R.layout.activity_notification),NotificationAdapter.OnClick2{
    lateinit var mainActivity: MainActivity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity = (activity as MainActivity?)!!
        mainActivity.binding.toolbar.ivCreate.visibility = View.GONE
        mainActivity.binding.toolbar.searchhome.visibility = View.GONE
        mainActivity.binding.toolbar.logotoolbar.visibility = View.GONE
        mainActivity.binding.toolbar.tvTitle.visibility = View.VISIBLE
        mainActivity.binding.toolbar.ivaddCreate.visibility = View.GONE
        mainActivity.binding.toolbar.tvTitle.text="Notification"

        toolbarnoti.visibility = View.GONE

        val anim: Animation = AnimationUtils.loadAnimation(requireActivity(), android.R.anim.fade_in)
        linearlayout1.startAnimation(anim)

        val layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        notificationRecyclerView.layoutManager = layoutManager

        if(isInternetAvailable(requireActivity())){
            getNotificationData()
        }

        view.setFocusableInTouchMode(true)
        view.requestFocus()
        view.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                mainActivity.setBottomIconChange("3")
                mainActivity.loadFragment(HomeFragment(0,0),"Home")
                true
            } else false
        })
    }


    private fun getNotificationData(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_user_notification(readUsingSharedPreference(requireActivity(), "userid").toString())
        call.enqueue(object : Callback<NotificationModel> {
            override fun onResponse(call: Call<NotificationModel>,
                    response: Response<NotificationModel>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.Data?.size != 0) {
                            linearlayout1.visibility = View.GONE
                            txtNoRecord.visibility = View.GONE
                            notificationRecyclerView.visibility = View.VISIBLE
                            storeUsingSharedPreference(
                                requireActivity(),
                                "notificatCountOld", response.body()?.Data?.size.toString()
                            )
                            val layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
                            notificationRecyclerView.layoutManager = layoutManager
                            val mAdapter = NotificationAdapter(requireActivity(), response.body()?.Data as MutableList<Datauser>,this@NotificationFragment)
                            notificationRecyclerView.adapter = mAdapter

                        }else{
                            linearlayout1.visibility = View.GONE
                            notificationRecyclerView.visibility = View.GONE
                            txtNoRecord.visibility = View.VISIBLE
                            storeUsingSharedPreference(
                                requireActivity(),
                                "notificatCountOld", response.body()?.Data?.size.toString()
                            )
                        }
                    }else{
                        linearlayout1.visibility = View.GONE
                        notificationRecyclerView.visibility = View.GONE
                        txtNoRecord.visibility = View.VISIBLE

                    }
                }
            }

            override fun onFailure(call: Call<NotificationModel>, t: Throwable) {
                dismissLoader();
            }
        })

    }


    private fun app_confirm_business_transaction(id:String,Text: TextView) {
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_confirm_business_transaction(id)
        showLoaderf(activity);
        call.enqueue(object : Callback<ConnectionDecline> {
            override fun onResponse(
                call: Call<ConnectionDecline>,
                response: Response<ConnectionDecline>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        Text.visibility=View.GONE
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

    override fun OnClick(position: Int, data: String, Text: TextView) {


        app_confirm_business_transaction(data,Text)
    }


}