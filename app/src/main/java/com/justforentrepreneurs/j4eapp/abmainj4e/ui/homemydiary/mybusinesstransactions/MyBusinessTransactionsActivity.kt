package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mybusinesstransactions

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.RadioGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyBusinessTransactionsBinding
import com.justforentrepreneurs.j4eapp.databinding.FilterBusinessTransactionBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mybusinesstransactions.model.Businesstransaction
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.MyLeadsDetailActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat


class MyBusinessTransactionsActivity : BaseActivity(),AdapterBusinessTransactions.OnClick2 {
    private lateinit var binding: ActivityMyBusinessTransactionsBinding
    private val sharedPrefFile = "MyBusniessActivity"
    var rankck :String=""
    var count_available : Int = -1
    override fun enablePresence(): Boolean {
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_business_transactions)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.my_business_transactions)


        recyclerData()

        binding.toolbar.ivBack.setOnClickListener {
            onBackPressed()
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
        binding.rvMyBusinessTransactions.layoutManager = layoutManager

        if(isInternetAvailable(this)) {
            getbusinesstransaction("", "")
        }

        binding.editsearchname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                if (s == "") {
                    if (isInternetAvailable(this@MyBusinessTransactionsActivity)) {
                        getbusinesstransaction("", "")
                    }
                }
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s == "") {
                    if (isInternetAvailable(this@MyBusinessTransactionsActivity)) {
                        getbusinesstransaction("", "")
                    }
                }
            }

            override fun afterTextChanged(s: Editable) {
                if (isInternetAvailable(this@MyBusinessTransactionsActivity)) {
                    if (s.length > 0) {
                        binding.rvMyBusinessTransactions.setAdapter(null)
                        getbusinesstransaction(s.toString(), "")
                    } else if (s.length == 0) {
                        binding.rvMyBusinessTransactions.setAdapter(null)
                        getbusinesstransaction("", "")
                    }
                }
            }
        })

    }

    private fun getbusinesstransaction(keyword: String, receved: String){
        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)

        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_all_business_transaction(readUsingSharedPreference(this, "userid").toString(), receved, keyword)
        call.enqueue(object : Callback<Businesstransaction> {
            override fun onResponse(
                    call: Call<Businesstransaction>,
                    response: Response<Businesstransaction>
            ) {
                dismissLoader()
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        count_available=response.body()?.count_available!!
                        if (response.body()?.data?.size != 0) {
                            binding.linearlayout1.visibility=View.GONE
                            binding.rvMyBusinessTransactions.visibility=View.VISIBLE



                            if(response.body()?.data?.get(0)?.TransactionData?.get(0)?.total_amount?.length?.toInt()!! > 9){
                                binding.totalamount.textSize= 15F
                            }else{

                            }

                            if(response.body()?.data?.get(0)?.TransactionData?.get(0)?.total_amount?.toDouble()!!.equals(0.0)){
                                binding.totalamount.text = "₹ " + "0.00"
                            }else {

                                val format2: String = DecimalFormat("#,##,##,##,###.00").format(
                                    response.body()?.data?.get(0)?.TransactionData?.get(0)?.total_amount?.toDouble()!!
                                )

                                binding.totalamount.text = "₹ " + format2
                            }

                            if(response.body()?.data?.get(0)?.TransactionData?.get(0)?.receive_amount?.toDouble()!!.equals(0.0)) {

                                binding.busnessreceived.text = "₹ " + "0.00"
                            }else{
                                val format3: String = DecimalFormat("#,##,##,##,###.00").format(
                                    response.body()?.data?.get(0)?.TransactionData?.get(0)?.receive_amount?.toDouble()!!
                                )
                                binding.busnessreceived.text = "₹ " + format3
                            }

                            if(response.body()?.data?.get(0)?.TransactionData?.get(0)?.given_amount?.toDouble()!!.equals(0.0)) {

                                binding.businessgiven.text = "₹ " + "0.00"
                            }else{
                                val format4: String = DecimalFormat("#,##,##,##,###.00").format(
                                    response.body()?.data?.get(0)?.TransactionData?.get(0)?.given_amount?.toDouble()!!
                                )
                                binding.businessgiven.text = "₹ " + format4
                            }

                            if(!(response.body()?.data?.get(0)?.TransactionInfo?.size==0)) {

                                binding.rvMyBusinessTransactions.visibility= View.VISIBLE
                                binding.NoGuestInvited.visibility= View.GONE

                                val mAdapter = AdapterBusinessTransactions(
                                    this@MyBusinessTransactionsActivity,
                                    response.body()?.data?.get(0)?.TransactionInfo as MutableList<Businesstransaction.TransactionInfo>,
                                    this@MyBusinessTransactionsActivity
                                )
                                binding.rvMyBusinessTransactions.adapter = mAdapter
                                binding.rvMyBusinessTransactions.adapter?.notifyDataSetChanged()
                            }else{
                                binding.rvMyBusinessTransactions.visibility= View.GONE
                                binding.NoGuestInvited.visibility= View.VISIBLE
                            }

                        }
                    }else{
                        binding.linearlayout1.visibility=View.GONE
                        binding.rvMyBusinessTransactions.visibility=View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<Businesstransaction>, t: Throwable) {
                dismissLoader()

            }
        })

    }

    fun displayFilter(view: View){
        binding.ivFilter.setImageResource(R.drawable.ic_filter_apply)
        val dialog = BottomSheetDialog(this)
        //dialog.setContentView(R.layout.filter_business_transaction)
        val mBsMemberFilterBinding: FilterBusinessTransactionBinding =
                DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.filter_business_transaction, null, false)
        dialog.setCancelable(true)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setContentView(mBsMemberFilterBinding.root)

        val sharedPreferences: SharedPreferences = getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)


        var Receivedst = sharedPreferences.getString("Received", "")
        var Givenst = sharedPreferences.getString("Given", "")



        mBsMemberFilterBinding.clearAllLabel.setOnClickListener {
            dialog.dismiss()
            binding.ivFilter.setImageResource(R.drawable.ic_filter_outline)
            if(isInternetAvailable(this)) {
                rankck=""
                val editor = sharedPreferences.edit()
                editor.clear()
                editor.apply()
                dialog.dismiss()
                binding.ivFilter.setImageResource(R.drawable.ic_filter_outline)
                getbusinesstransaction("", "")
            }
        }

        if(Receivedst.equals("1")){
            mBsMemberFilterBinding.BusinessReceived.setChecked(true)
        }

        if(Givenst.equals("2")){
            mBsMemberFilterBinding.BusinessGiven.setChecked(true)
        }

        mBsMemberFilterBinding.radioGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when (checkedId) {
                    R.id.BusinessReceived -> {

                        if (isInternetAvailable(this@MyBusinessTransactionsActivity)) {
                            rankck="1"
                            val editor: SharedPreferences.Editor =  sharedPreferences.edit()
                            editor.putString("Received", rankck)
                            editor.putString("Given", rankck)
                            editor.apply()
                            editor.commit()
                            getbusinesstransaction("", "1")
                        }
                        dialog.dismiss()
                        binding.ivFilter.setImageResource(R.drawable.ic_filter_apply)
                    }
                    R.id.BusinessGiven -> {
                        if (isInternetAvailable(this@MyBusinessTransactionsActivity)) {
                            rankck="2"
                            val editor: SharedPreferences.Editor =  sharedPreferences.edit()
                            editor.putString("Received", rankck)
                            editor.putString("Given", rankck)
                            editor.apply()
                            editor.commit()
                            getbusinesstransaction("", "2")
                        }
                        dialog.dismiss()
                        binding.ivFilter.setImageResource(R.drawable.ic_filter_apply)
                    }

                }
            }
        })

        dialog.show()

    }

    override fun OnClickpro(position: Int, data: String, is_viewed: Int) {
        if (count_available==0){
            if (is_viewed==0){
                PermissionDialog(readUsingSharedPreference(this,"ViewExhaustedMsg").toString())
            }else{
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("id",data)
                intent.putExtra("type","MyLead")
                startActivity(intent)
            }
        }else{
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("id",data)
            intent.putExtra("type","MyLead")
            startActivity(intent)
        }

    }

    private fun PermissionDialog(massage:String){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mbsAddAccountDialog: PlanexpaireddialogBinding = DataBindingUtil.inflate(LayoutInflater.from(this),R.layout.planexpaireddialog, null, false)
        dialog.setContentView(mbsAddAccountDialog.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        mbsAddAccountDialog.massage.setText(massage)

        mbsAddAccountDialog.okbtd.setOnClickListener {
            dialog.dismiss()
        }
        mbsAddAccountDialog.txtUpgrade.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this, MyMembershipBenefitsActivity::class.java))
        }
        dialog.show()
    }



}