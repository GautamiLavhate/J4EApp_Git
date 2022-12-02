package com.justforentrepreneurs.j4eapp.abmainj4e.ui.login

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import androidx.core.text.HtmlCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityLoginBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.listener.AuthListener
import com.justforentrepreneurs.j4eapp.abmainj4e.network.model.LoginRegisterModel
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.OTPVerification.OTPVerificationActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.FirstLoginMembershipAddActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.messaging.FirebaseMessaging
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivityOP
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.terms.model.TandCResponse
import com.justforentrepreneurs.j4eapp.databinding.DeactivatedDialogBinding
import com.justforentrepreneurs.j4eapp.databinding.LayoutTandcBottomsheetBinding
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
import org.koin.android.viewmodel.ext.android.viewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivityOP(), AuthListener {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel by viewModel<LoginViewModel>()
    private var token:String=""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
        Utils.printHashKey(this)

        FirebaseMessaging.getInstance().token
                .addOnCompleteListener(OnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        return@OnCompleteListener
                    }
                    token = task.result
                    //displayToast(this,token)

                })
        binding.tvTermsConditions.setOnClickListener {
            getTermsAndConditionData()
        }
        binding.tvPrivacyPolicy.setOnClickListener {
            getPrivacyAndPolicy()
        }
    }

    fun onGetOtpClick(view: View) {

        if (viewModel.validateData(binding.mobileNumEditText.text.toString().trim())) {
        if (isInternetAvailable(this)) {
            showLoader(this)

            val request = ServiceBuilder.buildService(APIinterface::class.java)
            val call = request.mobile1Login(binding.mobileNumEditText.text.toString().trim())
            call.enqueue(object : Callback<LoginRegisterModel> {
                override fun onResponse(
                        call: Call<LoginRegisterModel>,
                        response: Response<LoginRegisterModel>
                ) {
                    dismissLoader();
                    if (response.isSuccessful) {
                        if (response.body()?.status == true) {
                            storeUsingSharedPreference(this@LoginActivity, "userid", response.body()?.messageData?.userId)
                            storeUsingSharedPreference(this@LoginActivity, "mobile", response.body()?.messageData?.mobile)
                            storeUsingSharedPreference(this@LoginActivity, "otp", response.body()?.messageData?.otp.toString())
                            storeUsingSharedPreference(this@LoginActivity, "type", response.body()?.messageData?.type.toString())

//                            displayToast(this@LoginActivity, response.body()?.messageData?.otp.toString())
                            startActivity(Intent(this@LoginActivity, OTPVerificationActivity::class.java))

                        }else{
                            if (response.body()?.messageData?.message.equals("Deactive Account")){
                                DeactivateDialog("Your account is deactivated. Please contact administrator")
                            }else{
                                displayToast(this@LoginActivity, response.body()?.messageData?.message.toString())
                            }

                        }
                    }
                }

                override fun onFailure(call: Call<LoginRegisterModel>, t: Throwable) {
                    dismissLoader();
                    displayToast(this@LoginActivity, this@LoginActivity.resources.getString(R.string.error_something_wrong))
                }
            })
        }
        }
    }

    fun loginWithGoogleClick(view: View) {
        loginWithGoogle()
    }

    fun loginWithFacebookClick(view: View) {
        loginWithFacebook(this)
    }

    fun loginWithLinkdinClick(view: View){
       loginWithLinkdin(this)
    }

    override fun authData(socialType: String, loginDataHashMap: HashMap<String, String>) {
        if (isInternetAvailable(this)) {
            showLoader(this)
            viewModel.callSocialLoginApi(
                firstName = loginDataHashMap["firstName"].toString(),
                lastName = loginDataHashMap["lastName"].toString(),
                socialId = loginDataHashMap["socialId"].toString(),
                socialType = socialType,
                email = loginDataHashMap["email"].toString(),
                token =token
            )
            viewModel.isSocialLoginCompleted.observe(this, Observer {
                if (it) {
                    if (readUsingSharedPreference(this, "loginStatus").toString().equals("true")) {
                        startActivity(Intent(this, MainActivity::class.java))

                    } else {
                        val intent = Intent(this, FirstLoginMembershipAddActivity::class.java)
                        intent.putExtra("login", "isSocialLogin")
                        startActivity(intent)
                    }
                }
            })
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }


    private fun DeactivateDialog(massage:String){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mbsAddAccountDialog: DeactivatedDialogBinding = DataBindingUtil.inflate(LayoutInflater.from(this),R.layout.deactivated_dialog, null, false)
        dialog.setContentView(mbsAddAccountDialog.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        mbsAddAccountDialog.massage.setText(massage)

        mbsAddAccountDialog.okbtd.setOnClickListener {
            dialog.dismiss()
        }


        dialog.show()
    }

    fun getTermsAndConditionData(){
        val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
        val  mBmOnetooneinfoBinding: LayoutTandcBottomsheetBinding = DataBindingUtil.inflate(
            LayoutInflater.from(this), R.layout.layout_tandc_bottomsheet, null, false)
        dialog.setCancelable(true)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setContentView(mBmOnetooneinfoBinding.root)
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_terms_and_condition()
        call.enqueue(object : retrofit2.Callback<TandCResponse> {
            override fun onResponse(
                call: Call<TandCResponse>,
                response: Response<TandCResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        mBmOnetooneinfoBinding.txtTandCC.text=
                            HtmlCompat.fromHtml(response.body()?.data.toString(),0)
                    }
                }
            }

            override fun onFailure(call: Call<TandCResponse>, t: Throwable) {
                dismissLoader();
            }
        })
        mBmOnetooneinfoBinding.ivcancle.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    fun getPrivacyAndPolicy(){
        val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
        val  mBmOnetooneinfoBinding: LayoutTandcBottomsheetBinding = DataBindingUtil.inflate(
            LayoutInflater.from(this), R.layout.layout_tandc_bottomsheet, null, false)
        dialog.setCancelable(true)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setContentView(mBmOnetooneinfoBinding.root)
        mBmOnetooneinfoBinding.memberdetails.text="Privacy Policy"
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_privacy_policy()
        call.enqueue(object : retrofit2.Callback<TandCResponse> {
            override fun onResponse(
                call: Call<TandCResponse>,
                response: Response<TandCResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        mBmOnetooneinfoBinding.txtTandCC.text=
                            HtmlCompat.fromHtml(response.body()?.data.toString(),0)
                    }
                }
            }

            override fun onFailure(call: Call<TandCResponse>, t: Throwable) {
                dismissLoader();
            }
        })
        mBmOnetooneinfoBinding.ivcancle.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}