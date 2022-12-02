package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityEventBookingBinding
import com.justforentrepreneurs.j4eapp.databinding.BsConfirmBookingBinding
import com.justforentrepreneurs.j4eapp.databinding.PaymentFaildBottomsheetBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.model.EventBook
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.model.EventBookDetails
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class EventBookingActivity : BaseActivity() , PaymentResultListener {
    override fun enablePresence(): Boolean {
        return true
    }
    private lateinit var binding: ActivityEventBookingBinding
    lateinit var eventid:String
    lateinit var event_fees:String
    lateinit var Backtype:String
    lateinit var position:String
    lateinit var event_booked_byuser: String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_event_booking)
        Backtype = intent.getStringExtra("Back").toString()
        eventid=intent.getStringExtra("id").toString()
        position=intent.getStringExtra("position").toString()
        event_booked_byuser=intent.getStringExtra("event_booked_byuser").toString()

        Checkout.preload(applicationContext)

        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)

        if (isInternetAvailable(this)) {
            app_book_eventDetails()
        }



    }



    private fun bottomSheetConfirmBooking(data:EventBook.DataBook) {
        // val dialog = BottomSheetDialog(this, R.style.CustomBottomSheet)
        val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
        val mBsRecommendPersonListBinding: BsConfirmBookingBinding =
            DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.bs_confirm_booking, null, false)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(mBsRecommendPersonListBinding.root)

        mBsRecommendPersonListBinding.amount.text="₹ "+fmt(data.booking_amount.toString())
        mBsRecommendPersonListBinding.datestart.text=data.booking_creatdate
        mBsRecommendPersonListBinding.timesatrt.text=data.booking_creattime
        mBsRecommendPersonListBinding.nametv.text=data.booking_username
        mBsRecommendPersonListBinding.emailid.text=data.booking_useremail


        mBsRecommendPersonListBinding.ivClose.setOnClickListener {
            dialog.dismiss()
            val returnIntent = Intent()
            setResult(RESULT_OK, returnIntent)
            finish()
        }
        dialog.show()
    }

    private fun bottomSheetFail(data:EventBook.DataBook) {
        // val dialog = BottomSheetDialog(this, R.style.CustomBottomSheet)
        val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
        val mBsRecommendPersonListBinding: PaymentFaildBottomsheetBinding =
                DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.payment_faild_bottomsheet, null, false)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(mBsRecommendPersonListBinding.root)

        mBsRecommendPersonListBinding.amount.text="₹ "+fmt(data.booking_amount.toString())
        mBsRecommendPersonListBinding.datestart.text=data.booking_creatdate
        mBsRecommendPersonListBinding.timesatrt.text=data.booking_creattime
        mBsRecommendPersonListBinding.nametv.text=data.booking_username
        mBsRecommendPersonListBinding.emailid.text=data.booking_useremail

        mBsRecommendPersonListBinding.ivcancle.setOnClickListener {
            dialog.dismiss()
            val returnIntent = Intent()
            setResult(RESULT_OK, returnIntent)
            finish()
        }

        mBsRecommendPersonListBinding.Retry.setOnClickListener {
            dialog.dismiss()
            val returnIntent = Intent()
            setResult(RESULT_OK, returnIntent)
            finish()
        }
        dialog.show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (Backtype == "activity") {

        } else {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("type", "MyEvents")
            intent.putExtra("position", position)
            startActivity(intent)
        }
    }

    fun onCloseClick(view: View) {
        onBackPressed()
    }


    private fun app_book_eventDetails(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_event_detail_for_boking(eventid)
        call.enqueue(object : Callback<EventBookDetails> {
            override fun onResponse(
                call: Call<EventBookDetails>,
                response: Response<EventBookDetails>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null){
                            binding.linearlayout1.visibility=View.GONE
                            binding.linearlayout.visibility=View.VISIBLE
                            binding.tvContinueBooking.visibility=View.VISIBLE

                            if(event_booked_byuser.equals("Yes")){
                                binding.tvContinueBooking.setBackgroundResource(R.color.disable)
                            }else {
                                binding.tvContinueBooking.setBackgroundResource(R.color.colorPrimary)
                                binding.tvContinueBooking.setOnClickListener {
                                    if (isInternetAvailable(this@EventBookingActivity)) {
                                        if (!response.body()?.data?.get(0)?.event_data?.event_fees.equals("0")){
                                            startPayment(
                                                "Event Book",
                                                event_fees,
                                                readUsingSharedPreference(this@EventBookingActivity, "email").toString(),
                                                readUsingSharedPreference(this@EventBookingActivity, "mobile").toString()
                                            )
                                        }else{
                                            app_user_book_event("0")
                                        }


                                    }

                                }
                            }

                            binding.eventtitle.text=response.body()?.data?.get(0)?.event_data?.event_title
                            binding.eventStartdate.text=response.body()?.data?.get(0)?.event_data?.event_startdate+"\nTo "+response.body()?.data?.get(0)?.event_data?.event_enddate

                            binding.eventcategory.setText(response.body()?.data?.get(0)?.event_data?.event_cat_name)


                            if(!readUsingSharedPreference(this@EventBookingActivity, "membertyype").toString().equals("1")) {
                                binding.fesstotal.text="₹ "+fmt(response.body()?.data?.get(0)?.event_data?.event_fees.toString())

                                event_fees= response.body()?.data?.get(0)?.event_data?.event_fees.toString()
                            }else{
                                binding.fesstotal.text="₹ "+fmt(response.body()?.data?.get(0)?.event_data?.event_guest_fees.toString())
                                event_fees= response.body()?.data?.get(0)?.event_data?.event_guest_fees.toString()
                            }

                            Glide.with(this@EventBookingActivity)
                                .load(response.body()?.data?.get(0)?.event_data?.event_createdby_profile)
                                .centerCrop()
                                .placeholder(R.drawable.ic_profile_edit)
                                .into(binding.ivProfileImg)

                            Glide.with(this@EventBookingActivity)
                                .load(response.body()?.data?.get(0)?.event_data?.event_thumbnil)
                                .into(binding.eventImage)



                            binding.userName.setText(readUsingSharedPreference(this@EventBookingActivity,"fullname"))

                            binding.eveventemail.setText(readUsingSharedPreference(this@EventBookingActivity,"email"))
                            binding.phonenumber.setText(readUsingSharedPreference(this@EventBookingActivity,"mobile"))
                        }

                    }
                }
            }

            override fun onFailure(call: Call<EventBookDetails>, t: Throwable) {
                dismissLoader();
            }
        })
    }

    private fun app_user_book_event(amount: String){
        if (isInternetAvailable(this)) {
            val request = ServiceBuilder.buildService(APIinterface::class.java)
            val sdf = SimpleDateFormat("dd MMM yyyy")
            val currentDate = sdf.format(Date())

            val sdf1 = SimpleDateFormat("hh:mm a")
            val currentDate1 = sdf1.format(Date())

//            displayToast(this,readUsingSharedPreference(this, "userid").toString()+","+
//                binding.userName.text.toString()+","+
//                eventid+","+
//                readUsingSharedPreference(this@EventBookingActivity,"company_name").toString()+","+
//                binding.eveventemail.text.toString()+","+
//                binding.phonenumber.text.toString()+","+
//                amount+","+
//                currentDate+","+
//                currentDate1,
//                binding.eventcategory.text.toString())
            val call = request.app_user_book_event(
                readUsingSharedPreference(this, "userid").toString(),
                binding.userName.text.toString(),
                eventid,
                readUsingSharedPreference(this@EventBookingActivity,"company_name").toString(),
                binding.eveventemail.text.toString(),
                binding.phonenumber.text.toString(),
                amount,
                currentDate,
                currentDate1,
                binding.eventcategory.text.toString()
            )
            showLoaderf(this);
            call.enqueue(object : Callback<EventBook> {
                override fun onResponse(
                    call: Call<EventBook>,
                    response: Response<EventBook>
                ) {
                    dismissLoader();
                    if (response.isSuccessful) {
                        if (response.body()?.status == true) {
                            if (response.body()?.msg!!.contains("Cancel")){
                                bottomSheetFail(response.body()?.data!!)
                                displayToast(this@EventBookingActivity, response.body()?.msg.toString())
                            }else{
                                displayToast(this@EventBookingActivity, response.body()?.msg.toString())
                                bottomSheetConfirmBooking(response.body()?.data!!)
                            }

                        } else {
                            bottomSheetFail(response.body()?.data!!)
                            displayToast(this@EventBookingActivity, response.body()?.msg.toString())
                        }
                    }
                }

                override fun onFailure(call: Call<EventBook>, t: Throwable) {
                    dismissLoader();

                    displayToast(
                        this@EventBookingActivity,
                        resources.getString(R.string.error_something_wrong)
                    )
                }
            })
        }
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
        app_user_book_event(event_fees)
        Toast.makeText(this, "Payment is successful", Toast.LENGTH_SHORT).show()
    }

    override fun onPaymentError(p0: Int, p1: String?) {

        Toast.makeText(this, " Payment Cancel ",Toast.LENGTH_SHORT).show();
    }

}