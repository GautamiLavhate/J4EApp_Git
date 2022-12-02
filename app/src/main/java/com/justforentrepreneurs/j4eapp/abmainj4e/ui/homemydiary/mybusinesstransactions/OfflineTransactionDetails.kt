package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mybusinesstransactions

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityOfflinetransactiondetailsBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mybusinesstransactions.model.BusinessTransactionDetails
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class OfflineTransactionDetails :BaseActivity(){

     private lateinit var binding: ActivityOfflinetransactiondetailsBinding
    lateinit var transid:String
    lateinit var paymentTy:String
    override fun enablePresence(): Boolean {
        return true
    }

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         binding = DataBindingUtil.setContentView(this, R.layout.activity_offlinetransactiondetails)

         val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
         binding.linearlayout1.startAnimation(anim)

         transid=intent.getStringExtra("transid").toString()
         paymentTy=intent.getStringExtra("paymentTy").toString()

         if(paymentTy.equals("Offline")){
             binding.toolbar.tvTitle.text = "Offline Business Transactions"
         }else{
             binding.toolbar.tvTitle.text = "Online Business Transactions"
         }

         if(isInternetAvailable(this)){
             getbusinesstransaction(transid)
         }


     }

    private fun getbusinesstransaction(transid: String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_all_business_transaction_detail(transid,readUsingSharedPreference(this, "userid").toString())

        call.enqueue(object : Callback<BusinessTransactionDetails> {
            override fun onResponse(
                    call: Call<BusinessTransactionDetails>,
                    response: Response<BusinessTransactionDetails>
            ) {
                dismissLoader()
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data !=null) {
                            binding.linearlayout1.visibility = View.GONE
                            binding.linearlayout.visibility = View.VISIBLE
                            val Datesub: String =response.body()?.data?.transaction_date.toString()
                            val inputPattern = "yyyy-MM-dd"
                            val outputPattern = "dd MMM yyyy"
                            val inputFormat = SimpleDateFormat(inputPattern)
                            val outputFormat = SimpleDateFormat(outputPattern)

                            var date: Date? = null
                            var mainstr: String? = null

                            try {
                                date = inputFormat.parse(Datesub)
                                mainstr = outputFormat.format(date)
                            } catch (e: ParseException) {
                                e.printStackTrace()
                            }

                            binding.dob.text =mainstr


                            if (response.body()?.data?.transaction_type.equals("Given")) {
                                binding.amounttv.setTextColor(getColor(R.color.orange))

                            } else {
                                binding.amounttv.setTextColor(getColor(R.color.light_green))

                            }

                            val format4: String = DecimalFormat("#,##,##,##,###.00").format(response.body()?.data?.transaction_amount?.toDouble()!!)
                            binding.amounttv.text = "₹ " +format4
                            binding.Giventxt.text = response.body()?.data?.transaction_type

                            if(!(response.body()?.data?.user_name=="" || response.body()?.data?.user_name==null)) {
                                binding.fullname.text=response.body()?.data?.user_name.toString().capitalize()
                            }

                            binding.titletv.text = response.body()?.data?.transaction_title
                            binding.transactionremark.text = response.body()?.data?.transaction_remark


                        }
                    }else{
                        binding.linearlayout1.visibility = View.GONE
                        binding.linearlayout.visibility = View.VISIBLE

                    }
                }else{
                    binding.linearlayout1.visibility = View.GONE
                    binding.linearlayout.visibility = View.VISIBLE
                }
            }

            override fun onFailure(call: Call<BusinessTransactionDetails>, t: Throwable) {
                dismissLoader()

            }
        })

    }




}