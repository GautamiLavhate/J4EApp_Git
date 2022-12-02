package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myguestinvites

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityCreateGuestinviteBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment.model.Allevents
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myguestinvites.adapter.AdapterEventList
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myguestinvites.adapter.AdapterGuestType
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.EventInvite
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import kotlinx.android.synthetic.main.activity_create_guestinvite.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class CreateGuestInviteActivity : BaseActivity(),AdapterEventList.OnClick2,AdapterGuestType.OnClick2,PaymentResultListener {
    private lateinit var binding: ActivityCreateGuestinviteBinding
    var eventid :String=""
    var verificationneed :String=""
    var Freeallowed :String=""
    var registered :String=""
    var event_fees:String=""
    var PaymentBy :String=""
    var PaymentByboth :String=""
    var paymentByAmount:String=""
    var Statusst :String=""

    override fun enablePresence(): Boolean {
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_guestinvite)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.Create_Guest_Invite)
        binding.toolbar.ivPublish.visibility = View.GONE
        binding.toolbar.ivPublish.setTextColor(getColor(R.color.white))
        onInitListener()
    }

    fun validation() : Boolean {

        var Temp: Boolean? = true

        if (binding.edtGuest.text.toString().length == 0) {
            binding.edtGuest.setError("Field is empty")
            Temp = false
        } else {
            binding.edtGuest.setError(null)
        }

        if (binding.edtphonenumber.text.toString().length == 0) {
            binding.edtphonenumber.setError("Field is empty")
            Temp = false
        } else {
            binding.edtphonenumber.setError(null)
        }


        if (binding.edtemailid.text.toString().length == 0) {
            binding.edtemailid.setError("Field is empty")
            Temp = false
        } else {
            binding.edtemailid.setError(null)
        }

        /*if (binding.edtdesignation.text.toString().length == 0) {
            binding.edtdesignation.setError("Field is empty")
            Temp = false
        } else {
            binding.edtdesignation.setError(null)
        }
*/
        val enailvalid:String=binding.edtemailid.text.toString().replace(" ","")

        if (!Patterns.EMAIL_ADDRESS.matcher(enailvalid).matches()) {
            binding.edtemailid.setError("Invalid email")
            Temp = false
        } else {
            binding.edtemailid.setError(null)
        }

        /*if (binding.edtcompanyname.text.toString().length == 0) {
            binding.edtcompanyname.setError("Field is empty")
            Temp = false
        } else {
            binding.edtcompanyname.setError(null)
        }*/

        if (eventid.isEmpty()) {
            displayToast(this, "Select your Event")
            Temp = false
        }

        if( PaymentByboth.equals("yes")) {

            if (PaymentBy.isEmpty()) {
                displayToast(this, "Select Payment By")
                Temp = false
            }
        }


        return Temp!!
    }

    fun onInitListener() {

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvCategory1.layoutManager = layoutManager
        binding.llCategorySelection1.setOnClickListener {
            if (binding.ivDropDown1.isVisible) {
                binding.ivDropDown1.visibility = View.GONE
                binding.ivDropUp1.visibility = View.VISIBLE
                binding.rvCategory1.visibility = View.VISIBLE
            } else {
                binding.ivDropDown1.visibility = View.VISIBLE
                binding.ivDropUp1.visibility = View.GONE


                binding.rvCategory1.visibility = View.GONE
            }
        }

        if(isInternetAvailable(this)){
            getUpcomingEvents("")
        }

        val layoutManager1 = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvCategory2.layoutManager = layoutManager1

        binding.llCategorySelection2.setOnClickListener {
            if (binding.ivDropDown2.isVisible) {
                binding.ivDropDown2.visibility = View.GONE
                binding.ivDropUp2.visibility = View.VISIBLE
                binding.rvCategory2.visibility = View.VISIBLE
            } else {
                binding.ivDropDown2.visibility = View.VISIBLE
                binding.ivDropUp2.visibility = View.GONE
                binding.rvCategory2.visibility = View.GONE
            }
        }

        val list: MutableList<String> = ArrayList()
        list.add("Guest")
        list.add("Member")
        val mAdapter1 = AdapterGuestType(this@CreateGuestInviteActivity,list,this@CreateGuestInviteActivity)
        binding.rvCategory2.adapter = mAdapter1

        binding.edtphonenumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if(validationText()==false){
                    binding.checkbtd.setBackgroundResource(R.drawable.bg_disableupgrade)
                } else {
                    binding.checkbtd.setBackgroundResource(R.drawable.bg_upgrade)
                }

            }
            override fun afterTextChanged(editable: Editable) {

            }
        })


        binding.checkbtd.setOnClickListener {
            if (binding.edtphonenumber.text.toString().length == 0) {
                displayToast(this@CreateGuestInviteActivity,"Enter Mobile Number")
            }else if(binding.edtphonenumber.text.toString().length < 10){
                displayToast(this@CreateGuestInviteActivity, this@CreateGuestInviteActivity.getString(R.string.error_invalid_mobile_num))
            }else if (eventid.isEmpty()) {
            displayToast(this, "Select your Event")
            }else {
                if(isInternetAvailable(this)) {
                    app_check_event_invite()
                }
            }
        }

        binding.invitedPeople.setOnClickListener {
            if(validation()){
                if(isInternetAvailable(this)) {
                    app_create_guest_invite_event("","")
                }
            }
        }

        binding.makepayment.setOnClickListener {
            if(validation()) {
                if (isInternetAvailable(this)) {
                    startPayment(
                        "Guest Invite",
                        paymentByAmount,
                        readUsingSharedPreference(this, "email").toString(),
                        readUsingSharedPreference(this, "mobile").toString()
                    )
                }
            }
        }

        binding.edtEntryfees.setTag( binding.edtEntryfees.getKeyListener())
        binding.edtEntryfees.keyListener=null
    }

    fun validationText() : Boolean {

        var Temp: Boolean? = true
        if (binding.edtphonenumber.text.toString().length == 0) {
            Temp = false
        } else {

        }

        return Temp!!
    }

    private fun app_create_guest_invite_event(paymentid:String,payedate:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val sdf = SimpleDateFormat("dd MMM yyyy")
        val currentDate = sdf.format(Date())

        val sdf1 = SimpleDateFormat("hh:mm a")
        val currentDate1 = sdf1.format(Date())
        val call = request.app_create_guest_invite_event(readUsingSharedPreference(this, "userid").toString(),eventid,binding.edtGuest.text.toString(),binding.edtphonenumber.text.toString(),binding.edtemailid.text.toString(),binding.edtcompanyname.text.toString(),binding.edtdesignation.text.toString(),currentDate,currentDate1,
            event_fees,PaymentBy,paymentByAmount,paymentid,verificationneed,   Statusst,payedate.toString())
        showLoaderf(this);
        call.enqueue(object : Callback<ConnectionDecline> {
            override fun onResponse(
                    call: Call<ConnectionDecline>,
                    response: Response<ConnectionDecline>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        displayToast(this@CreateGuestInviteActivity,response.body()?.message.toString())
                        startActivity(Intent(this@CreateGuestInviteActivity, MyGuestInvitesActivity::class.java))

                    }else{

                        displayToast(this@CreateGuestInviteActivity,response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                dismissLoader();

                displayToast(this@CreateGuestInviteActivity, resources.getString(R.string.error_something_wrong))
            }
        })
    }

    private fun getUpcomingEvents(keyword:String){
        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.layoutmanager1.startAnimation(anim)

        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_event_listkey("2",readUsingSharedPreference(this, "userid").toString(),keyword)
        call.enqueue(object : Callback<Allevents> {
            override fun onResponse(
                call: Call<Allevents>,
                response: Response<Allevents>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            binding.layoutmanager1.visibility=View.GONE
                            binding.layoutmanager.visibility=View.VISIBLE
                            val mAdapter = AdapterEventList(this@CreateGuestInviteActivity,response.body()?.data as MutableList<Allevents.Alleventsdata>,this@CreateGuestInviteActivity)
                            binding.rvCategory1.adapter = mAdapter

                        }else{
                            binding.layoutmanager1.visibility=View.GONE
                            binding.layoutmanager.visibility=View.VISIBLE
                        }
                    }else{
                        binding.layoutmanager1.visibility=View.GONE
                        binding.layoutmanager.visibility=View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<Allevents>, t: Throwable) {
                dismissLoader();

            }
        })

        binding.tvCategory1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                if (s == "") {
                    if (isInternetAvailable(this@CreateGuestInviteActivity)) {
                        getUpcomingEvents("")
                    }
                    binding.crossfun.visibility=View.GONE
                }
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s == "") {
                    if (isInternetAvailable(this@CreateGuestInviteActivity)) {
                        getUpcomingEvents("")
                    }
                    binding.crossfun.visibility=View.GONE
                }
            }

            override fun afterTextChanged(s: Editable) {
                if (isInternetAvailable(this@CreateGuestInviteActivity)) {
                    if (s.length > 0) {
                        binding.rvCategory1.setAdapter(null)
                        binding.crossfun.visibility=View.VISIBLE
                        getUpcomingEvents(s.toString())
                    } else if (s.length == 0) {
                        binding.rvCategory1.setAdapter(null)
                        getUpcomingEvents("")
                        binding.crossfun.visibility=View.GONE
                    }
                }
            }
        })

        binding.crossfun.setOnClickListener {
            binding.tvCategory1.setText("")
            eventid=""
        }

    }

    override fun OnClick(position: String, id: String, gustfees: String) {
        binding.tvCategory1.setText(position)
        eventid=id
        binding.ivDropDown1.visibility = View.VISIBLE
        binding.ivDropUp1.visibility = View.GONE
        binding.rvCategory1.visibility = View.GONE
        binding.edtEntryfees.visibility = View.VISIBLE
        paymentByAmount=gustfees
        event_fees="Paid"
        binding.edtEntryfees.setText("₹ " + fmt(gustfees))
        Log.d("position", position.toString());
    }

    override fun OnClickguesttype(position: String, id: String) {
        binding.tvCategory2.text = position;
        binding.ivDropDown2.visibility = View.VISIBLE
        binding.ivDropUp2.visibility = View.GONE
        binding.rvCategory2.visibility = View.GONE

        if(verificationneed.equals("2")) {

                if (position.equals("Guest")) {
                    PaymentBy = "2"
                    Statusst = "2"
                    binding.edtEntryfees.visibility = View.VISIBLE
                    binding.makepayment.visibility = View.GONE
                    binding.invitedPeople.visibility = View.VISIBLE
                } else if (position.equals("Member")) {
                    PaymentBy = "1"
                    Statusst = "1"
                    verificationneed = "2"
                    binding.paymentbyli.visibility = View.VISIBLE
                    binding.edtEntryfees.visibility = View.VISIBLE
                    binding.invitedPeople.visibility = View.GONE
                    binding.makepayment.visibility = View.VISIBLE
                }
            }else{
            if (position.equals("Guest")) {
                PaymentBy = "2"
            } else if (position.equals("Member")) {
                PaymentBy = "1"
            }
        }
    }

    private fun app_check_event_invite(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_check_event_invite(binding.edtphonenumber.text.toString(),eventid)
        call.enqueue(object : Callback<EventInvite> {
            override fun onResponse(
                call: Call<EventInvite>,
                response: Response<EventInvite>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {

                        binding.edtphonenumber.setTag( binding.edtphonenumber.getKeyListener())
                        binding.edtphonenumber.keyListener=null



                        binding.llCategorySelection1.setClickable(false)


                        binding.ivDropDown1.visibility = View.GONE
                        binding.ivDropUp1.visibility = View.GONE

                        binding.edtphonenumber.setBackgroundResource(R.drawable.rounded_border_b5b5b5_rectangle_graywith_6dp)
                        binding.llCategorySelection3.setBackgroundResource(R.drawable.rounded_border_b5b5b5_rectangle_graywith_6dp)



                        if(response.body()?.data?.registered?.equals("Yes")!!){
                            displayToast(this@CreateGuestInviteActivity,"AllReady Guest Invite")
                            binding.makepayment.visibility = View.GONE
                            binding.invitedPeople.visibility = View.GONE
                        }else {

                            if(response.body()?.data?.Free_allowed?.equals("Yes")!!){
                                paymentByAmount=""
                                event_fees="Free"
                                verificationneed = "2"
                                Statusst="1"
                                binding.edtEntryfees.visibility = View.GONE
                                binding.paymentbyli.visibility = View.GONE
                                binding.invitedPeople.visibility = View.VISIBLE
                                binding.makepayment.visibility = View.GONE

                            }else if (response.body()?.data?.Free_allowed?.equals("No")!! && response.body()?.data?.verification_need?.equals(
                                    "Yes")!!) {
                                binding.paymentbyli.visibility = View.VISIBLE
                                verificationneed = "1"
                                PaymentByboth="yes"
                                Freeallowed = ""
                                Statusst="2"
                                binding.invitedPeople.visibility = View.VISIBLE
                            } else if (response.body()?.data?.Free_allowed?.equals("No")!! && response.body()?.data?.verification_need?.equals(
                                    "No"
                                )!!
                            ) {
                                verificationneed = "2"
                                binding.paymentbyli.visibility = View.VISIBLE
                                PaymentByboth="yes"
                                binding.edtEntryfees.visibility = View.VISIBLE
                                binding.invitedPeople.visibility = View.GONE
                                binding.makepayment.visibility = View.VISIBLE
                            }
                        }

                    }else{

                        displayToast(this@CreateGuestInviteActivity,response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<EventInvite>, t: Throwable) {
                dismissLoader();
            }
        })
    }

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
            val sdf = SimpleDateFormat("dd MMM yyyy, hh:mm")
            val currentDate = sdf.format(Date())
            app_create_guest_invite_event(p0.toString(),currentDate.toString())
        }
        Toast.makeText(this, "Payment is successful", Toast.LENGTH_SHORT).show()
    }

    override fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(this, " Payment Cancel ", Toast.LENGTH_SHORT).show();
    }
}