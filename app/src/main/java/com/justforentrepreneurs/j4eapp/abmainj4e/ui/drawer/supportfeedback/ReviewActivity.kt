package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.supportfeedback

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.Window
import androidx.databinding.DataBindingUtil
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.databinding.ActivityReviewprofileBinding
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


class ReviewActivity : BaseActivity() {
    private lateinit var binding: ActivityReviewprofileBinding
    lateinit var memberid:String
    override fun enablePresence(): Boolean {
        return true
    }
    lateinit var type:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_reviewprofile)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.review)

        if (intent.getStringExtra("type") == "profileReview" ){
            memberid=intent.getStringExtra("id").toString()
            type=intent.getStringExtra("backType").toString()
        }

        binding.edtFeedback.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                var i : Int =s.toString().length
                var count :Int =140 - i

                binding.txtCounter.setText(count.toString() + "/140")
            }
            override fun afterTextChanged(s: Editable) {
                var i : Int =s.toString().length
                var count :Int =140 - i

                binding.txtCounter.setText(count.toString() + "/140")
            }
        })
        binding.tvSubmit.setOnClickListener {
            if(validation()) {
                if (isInternetAvailable(this)) {
                    val request = ServiceBuilder.buildService(APIinterface::class.java)
                    val sdf = SimpleDateFormat("dd MMM yyyy")
                    val currentDate = sdf.format(Date())

                    val sdf1 = SimpleDateFormat("hh:mm a")
                    val currenttime1 = sdf1.format(Date())

                    val call = request.user_ratings_reviews(memberid, readUsingSharedPreference(this, "userid").toString(), binding.rating.rating.toString(), binding.edtFeedback.text.toString(), currentDate, currenttime1)
                    showLoaderf(this)
                    call.enqueue(object : Callback<ConnectionDecline> {
                        override fun onResponse(
                                call: Call<ConnectionDecline>,
                                response: Response<ConnectionDecline>
                        ) {
                            dismissLoader();
                            if (response.isSuccessful) {
                                if (response.body()?.status == true) {
                                    displayToast(this@ReviewActivity, response.body()?.message.toString())
                                     val returnIntent = Intent()
                                     returnIntent.putExtra("result", "123")
                                     setResult(RESULT_OK, returnIntent)
                                     finish()

                                } else {
                                    PermissionBackDialog(response.body()?.message.toString())
                                    displayToast(this@ReviewActivity, response.body()?.message.toString())
                                }
                            }
                        }

                        override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                            dismissLoader()
                            displayToast(this@ReviewActivity, resources.getString(R.string.error_something_wrong))
                        }
                    })
                }
            }
        }

        binding.tvCancel.setOnClickListener {
            onBackPressed()
        }

        binding.toolbar.ivBack.setOnClickListener {
            onBackPressed()
        }
    }

    fun validation() : Boolean {

        var Temp: Boolean?= true

        if (binding.rating.rating.toString().equals("0.0")) {
            displayToast(this, "Add Rating")
            Temp = false
        }

        return Temp!!
    }

    override fun onBackPressed() {
        super.onBackPressed()
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

    private fun PermissionBackDialog(massage:String){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mbsAddAccountDialog: PlanexpaireddialogBinding = DataBindingUtil.inflate(LayoutInflater.from(this),R.layout.planexpaireddialog, null, false)
        dialog.setContentView(mbsAddAccountDialog.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        mbsAddAccountDialog.massage.setText(massage)

        mbsAddAccountDialog.okbtd.setOnClickListener {
            dialog.dismiss()
            onBackPressed()
        }
        mbsAddAccountDialog.txtUpgrade.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this, MyMembershipBenefitsActivity::class.java))
        }
        dialog.show()
    }

}