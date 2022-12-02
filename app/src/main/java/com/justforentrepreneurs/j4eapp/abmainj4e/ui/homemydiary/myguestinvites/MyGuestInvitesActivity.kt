package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myguestinvites

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyguestinvitesBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myguestinvites.adapter.AdapterMyGuestInvites
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myguestinvites.moel.GuestInvitesLi
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONObject
import org.koin.ext.isInt
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


class MyGuestInvitesActivity : BaseActivity(),AdapterMyGuestInvites.OnClick2,
    PaymentResultListener {
    var Eventamount:String=""
    var inviteid :String=""
    var positionst:String=""
    private lateinit var binding: ActivityMyguestinvitesBinding
    override fun enablePresence(): Boolean {
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_myguestinvites)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.my_guest_invites)

        recyclerData()

        binding.toolbar.ivBack.setOnClickListener {
            onBackPressed()
        }

        binding.toolbar.ivguestinvited.setOnClickListener {
            startActivity(Intent(this, CreateGuestInviteActivity::class.java))
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        if(intent.getStringExtra("noti").toString().equals("notification")){
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("type", "notification")
            startActivity(intent)
        }else{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


    private fun recyclerData() {
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvGuestinvites.layoutManager = layoutManager

        if(isInternetAvailable(this)){
            getMyGuestInvites(0)
        }

    }
    private fun getMyGuestInvites(position:Int){
        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_guest_invite_event_list(readUsingSharedPreference(this, "userid").toString())
        call.enqueue(object : Callback<GuestInvitesLi> {
            override fun onResponse(
                    call: Call<GuestInvitesLi>,
                    response: Response<GuestInvitesLi>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            binding.linearlayout1.visibility= View.GONE
                            binding.rvGuestinvites.visibility= View.VISIBLE
                            binding.NoGuestInvited.visibility= View.GONE
                            val mAdapter = AdapterMyGuestInvites(this@MyGuestInvitesActivity, response.body()?.data as MutableList<GuestInvitesLi.DataGuest>,this@MyGuestInvitesActivity)
                            binding.rvGuestinvites.adapter = mAdapter
                            binding.rvGuestinvites.getLayoutManager()?.scrollToPosition(position);

                        }
                    }else{
                        binding.linearlayout1.visibility= View.GONE
                        binding.rvGuestinvites.visibility= View.GONE
                        binding.NoGuestInvited.visibility= View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<GuestInvitesLi>, t: Throwable) {
                dismissLoader();

            }
        })

    }

    override fun OnClick(id: String, eventamount: String, position: String) {
        inviteid=id
        Eventamount=eventamount
        positionst=position
        if (isInternetAvailable(this)) {
            startPayment(
                "Guest Invite",
                eventamount,
                readUsingSharedPreference(this, "email").toString(),
                readUsingSharedPreference(this, "mobile").toString()
            )
        }
    }


    //payment

    private fun startPayment(despiption:String,amount:String,email:String,contact:String) {
        /*
        *  You need to pass current activity in order to let Razorpay create CheckoutActivity
        * */


        val activity: Activity = this
        val co = Checkout()
        val image: Int = R.drawable.applogo200
        co.setImage(image)
        co.setKeyID(readUsingSharedPreference(this,"razorpay_key"))




        try {
            val options = JSONObject()
            options.put("name","J4E")
            options.put("description",despiption)
            //You can omit the image option to fetch the image from dashboard
            options.put("image","https://s3.amazonaws.com/rzp-mobile/images/rzp.png")
            options.put("theme.color", "#084268");
            options.put("currency","INR");

            var total: Double = amount.toDouble()
            total = total * 100
            options.put("amount",total)//pass amount in currency subunits

            val retryObj =  JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);

            val prefill = JSONObject()
            prefill.put("email",email)
            prefill.put("contact",contact)

            options.put("prefill",prefill)
            co.open(activity,options)
        }catch (e: Exception){
            Toast.makeText(activity,"Error in payment: "+ e.message, Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    override fun onPaymentSuccess(p0: String?) {
        if(isInternetAvailable(this)) {
            app_do_guest_invite_payment(p0.toString())
        }
        Toast.makeText(this, "Payment is successful", Toast.LENGTH_SHORT).show()
    }

    override fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(this, " Payment Cancel ", Toast.LENGTH_SHORT).show();
    }

    private fun app_do_guest_invite_payment(paymentid:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)

        val sdf = SimpleDateFormat("dd MMM yyyy, hh:mm")
        val currentDate = sdf.format(Date())

        val call = request.app_do_guest_invite_payment(readUsingSharedPreference(this, "userid").toString(),inviteid,paymentid,"1",Eventamount,currentDate.toString())
        showLoaderf(this);
        call.enqueue(object : Callback<ConnectionDecline> {
            override fun onResponse(
                call: Call<ConnectionDecline>,
                response: Response<ConnectionDecline>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        getMyGuestInvites(positionst.toInt())

                        displayToast(this@MyGuestInvitesActivity,response.body()?.message.toString())

                    }else{

                        displayToast(this@MyGuestInvitesActivity,response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                dismissLoader();
            }
        })
    }
}