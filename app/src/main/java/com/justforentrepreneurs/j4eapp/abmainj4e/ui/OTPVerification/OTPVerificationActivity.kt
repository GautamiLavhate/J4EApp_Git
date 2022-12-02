package com.justforentrepreneurs.j4eapp.abmainj4e.ui.OTPVerification

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.core.text.HtmlCompat
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityOtpVerificationBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.network.model.LoginRegisterModel
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.FirstLoginMembershipAddActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.login.LoginActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.database.*
import com.google.firebase.messaging.FirebaseMessaging
import com.justforentrepreneurs.StaticConfig
import com.justforentrepreneurs.j4eapp.Userlist
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivityOP
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.CountBubble
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.login.SmsBroadcastReceiver
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.terms.model.TandCResponse
import com.justforentrepreneurs.j4eapp.databinding.DeactivatedDialogBinding
import com.justforentrepreneurs.j4eapp.databinding.LayoutTandcBottomsheetBinding
//import com.justforentrepreneurs.j4eapp.exceptions.BackupFileMismatchedException
//import com.justforentrepreneurs.j4eapp.model.realms.CurrentUserInfo
//import com.justforentrepreneurs.j4eapp.utils.*
import io.realm.exceptions.RealmMigrationNeededException
import kotlinx.android.synthetic.main.lay_bottom_bar.*
import org.koin.android.viewmodel.ext.android.viewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.util.concurrent.TimeUnit
import java.util.regex.Pattern

class OTPVerificationActivity : BaseActivityOP() {

    private val viewModel by viewModel<OTPVerificationViewModel>()
    lateinit var binding: ActivityOtpVerificationBinding
    private var checkTime = false
    private var token:String=""

    private var pickedPhoto: String? = null
    private var backupFileUri: String? = null
    private var dbFileUri: String? = null

    var databaseReference: DatabaseReference? = null

    private val sharedPrefFile = "ChatDetails"

    private val REQ_USER_CONSENT = 200

    var smsBroadcastReceiver: SmsBroadcastReceiver?= null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_otp_verification)
        binding.lifecycleOwner = this
        binding.tvMobileNumber.setText(readUsingSharedPreference(this, "mobile").toString())


        FirebaseMessaging.getInstance().token
                .addOnCompleteListener(OnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        return@OnCompleteListener
                    }
                    token = task.result

                })

        binding.change.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.edtA.addTextChangedListener(afterTextChanged = {
            if (binding.edtA.text.length == 1)
                binding.edtB.requestFocus()
        })

        binding.edtB.addTextChangedListener(afterTextChanged = {
            if (binding.edtB.text.length == 1)
                binding.edtC.requestFocus()
            else if (binding.edtB.text.isEmpty())
                binding.edtA.requestFocus()
        })
        binding.edtC.addTextChangedListener(afterTextChanged = {
            if (binding.edtC.text.length == 1)
                binding.edtD.requestFocus()
            else if (binding.edtC.text.isEmpty())
                binding.edtB.requestFocus()
        })
        binding.edtD.addTextChangedListener(afterTextChanged = {
            if (binding.edtD.text.isEmpty())
                binding.edtC.requestFocus()
        })

        timer()

        binding.tvResendOtpText.setOnClickListener {
            if(checkTime){
                resendOtp()
                binding.edtA.setText("")
                binding.edtB.setText("")
                binding.edtC.setText("")
                binding.edtD.setText("")
                binding.edtA.requestFocus()
                checkTime = false
                timer()
            }else{
                displayToast(this@OTPVerificationActivity, "Please wait for 2 minutes!")
            }
        }

        startSmartUserConsent()

        binding.tvTermsConditions.setOnClickListener {
            getTermsAndConditionData()
        }
        binding.tvPrivacyPolicy.setOnClickListener {
            getPrivacyAndPolicy()
        }
    }


    fun onLoginClick(view: View) {
        //val otp = binding.edtA.text.toString().trim() + binding.edtB.text.toString().trim() + binding.edtC.text.toString().trim() + binding.edtD.text.toString().trim()
        val otp = binding.otpView.text.toString()
        if (viewModel.validateData(otp)) {
            if (isInternetAvailable(this)) {
                showLoader(this)
                val request = ServiceBuilder.buildService(APIinterface::class.java)
                val call = request.app_user_verify_otp(readUsingSharedPreference(this, "userid").toString(), otp, readUsingSharedPreference(this, "mobile").toString(), "Android", token)
                call.enqueue(object : Callback<OTPVerifyModel> {
                    override fun onResponse(
                            call: Call<OTPVerifyModel>,
                            response: Response<OTPVerifyModel>
                    ) {
                        dismissLoader();
                        if (response.isSuccessful) {
                            if (response.body()?.status == true) {
                                if (response.body()?.data?.size != 0) {
                                    displayToast(
                                            this@OTPVerificationActivity,
                                            response.body()?.msg.toString()
                                    )
                                    dismissLoader()

                                    storeUsingSharedPreference(
                                            this@OTPVerificationActivity,
                                            "userid",
                                            response.body()?.data?.get(0)?.userdata?.id
                                    )
                                    storeUsingSharedPreference(
                                            this@OTPVerificationActivity,
                                            "mobile",
                                            response.body()?.data?.get(0)?.userdata?.phone.toString()
                                    )
                                    storeUsingSharedPreference(
                                            this@OTPVerificationActivity,
                                            "type",
                                            response.body()?.data?.get(0)?.userdata?.type.toString()
                                    )
                                    storeUsingSharedPreference(
                                            this@OTPVerificationActivity,
                                            "companyphone",
                                            response.body()?.data?.get(0)?.userdata?.company_number
                                    )

                                    storeUsingSharedPreference(
                                            this@OTPVerificationActivity,
                                            "dob",
                                            response.body()?.data?.get(0)?.userdata?.dob
                                    )
                                    storeUsingSharedPreference(
                                            this@OTPVerificationActivity,
                                            "fullname",
                                            response.body()?.data?.get(0)?.userdata?.first_name.toString() + " " + response.body()?.data?.get(0)?.userdata?.middle_name.toString() + " " + response.body()?.data?.get(0)?.userdata?.last_name.toString()
                                    )

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "email",
                                        response.body()?.data?.get(0)?.userdata?.email_address.toString()
                                    )

                                    storeUsingSharedPreference(
                                            this@OTPVerificationActivity,
                                            "company_name",
                                            response.body()?.data?.get(0)?.userdata?.company.toString()
                                    )
                                    storeUsingSharedPreference(
                                            this@OTPVerificationActivity,
                                            "company_address",
                                            response.body()?.data?.get(0)?.userdata?.company_address.toString()
                                    )
                                    storeUsingSharedPreference(
                                            this@OTPVerificationActivity,
                                            "designation",
                                            response.body()?.data?.get(0)?.userdata?.designation.toString()
                                    )

                                    storeUsingSharedPreference(
                                            this@OTPVerificationActivity,
                                            "firstname",
                                            response.body()?.data?.get(0)?.userdata?.first_name.toString()
                                    )

                                    storeUsingSharedPreference(
                                            this@OTPVerificationActivity,
                                            "meddlename",
                                            response.body()?.data?.get(0)?.userdata?.middle_name.toString()
                                    )
                                    storeUsingSharedPreference(
                                            this@OTPVerificationActivity,
                                            "lastname",
                                            response.body()?.data?.get(0)?.userdata?.last_name.toString()
                                    )

                                    storeUsingSharedPreference(
                                            this@OTPVerificationActivity,
                                            "profilepic",
                                            "https://applex360.co.in/j4e_new/upload/avatar/" + response.body()?.data?.get(0)?.userdata?.avatar.toString()
                                    )

                                    storeUsingSharedPreference(
                                            this@OTPVerificationActivity,
                                            "total_experience",
                                            response.body()?.data?.get(0)?.userdata?.total_experience
                                    )
                                    storeUsingSharedPreference(
                                            this@OTPVerificationActivity,
                                            "business_category",
                                            response.body()?.data?.get(0)?.userdata?.business_category
                                    )
                                    storeUsingSharedPreference(
                                            this@OTPVerificationActivity,
                                            "business_entity",
                                            response.body()?.data?.get(0)?.userdata?.business_entity
                                    )
                                    storeUsingSharedPreference(
                                            this@OTPVerificationActivity,
                                            "business_type",
                                            response.body()?.data?.get(0)?.userdata?.business_type
                                    )

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "membertyype",
                                        response.body()?.data?.get(0)?.userdata?.membership_type.toString()
                                    )


                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "signup_source", "api"
                                    )


                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "PostCountnew",response.body()?.data?.get(0)?.userdata?.notification_count?.post_count.toString()
                                    )

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "LeadCountnew",response.body()?.data?.get(0)?.userdata?.notification_count?.lead_count.toString()
                                    )

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "BuddyCountnew",response.body()?.data?.get(0)?.userdata?.notification_count?.buddy_count.toString()
                                    )


                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "PostCountOld",response.body()?.data?.get(0)?.userdata?.notification_count?.post_count.toString()
                                    )

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "LeadCountOld",response.body()?.data?.get(0)?.userdata?.notification_count?.lead_count.toString()
                                    )

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "BuddyCountOld",response.body()?.data?.get(0)?.userdata?.notification_count?.buddy_count.toString()
                                    )

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "eventCountOld",response.body()?.data?.get(0)?.userdata?.notification_count?.event_count.toString()
                                    )

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "notificatCountOld",response.body()?.data?.get(0)?.userdata?.notification_count?.notificat_count.toString()
                                    )

                                    val Connection:Int=
                                        response.body()?.data?.get(0)?.userdata?.notification_count?.connection_receive_count?.toInt()!! + response.body()?.data?.get(0)?.userdata?.notification_count?.connection_sent_count?.toInt()!!

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "ConnectionCountOld", Connection.toString())


                                    if (response.body()?.data?.get(0)?.userdata?.membership_type.equals("0")) {
                                        if (response.body()?.data?.get(0)?.userdata?.is_admin.equals("0")){
                                            storeUsingSharedPreference(this@OTPVerificationActivity, "loginStatus", "false")
                                            startActivity(
                                                Intent(
                                                    this@OTPVerificationActivity,
                                                    FirstLoginMembershipAddActivity::class.java
                                                )
                                            )
                                            finishAffinity()
                                        }else{
                                            storeUsingSharedPreference(this@OTPVerificationActivity, "loginStatus", "true")
                                            Getdata()
                                            //SharedPreferencesManager.saveUid(response.body()?.data?.get(0)?.userdata?.chat_id.toString())
                                            storeUsingSharedPreference(this@OTPVerificationActivity, "UidK", response.body()?.data?.get(0)?.userdata?.chat_id)
                                            readUsingSharedPreference(this@OTPVerificationActivity, "UidK")
                                            storeUsingSharedPreference(this@OTPVerificationActivity,"showupdate","yes")
                                            startActivity(Intent(this@OTPVerificationActivity, MainActivity::class.java))
                                            finishAffinity()
                                        }

                                    } else {
                                        storeUsingSharedPreference(this@OTPVerificationActivity, "loginStatus", "true")
                                        Getdata()
                                        //SharedPreferencesManager.saveUid(response.body()?.data?.get(0)?.userdata?.chat_id.toString())
                                        storeUsingSharedPreference(this@OTPVerificationActivity, "UidK", response.body()?.data?.get(0)?.userdata?.chat_id)
                                        readUsingSharedPreference(this@OTPVerificationActivity, "UidK")
                                        storeUsingSharedPreference(this@OTPVerificationActivity,"showupdate","yes")
                                        startActivity(Intent(this@OTPVerificationActivity, MainActivity::class.java))
                                        finishAffinity()
                                    }
                                }

                            } else {
                                dismissLoader();
                                displayToast(this@OTPVerificationActivity, response.body()?.msg.toString())
                            }
                        }
                    }

                    override fun onFailure(call: Call<OTPVerifyModel>, t: Throwable) {
                        dismissLoader();
                        displayToast(this@OTPVerificationActivity, resources.getString(R.string.error_something_wrong))
                    }
                })
            }
        }
    }


//    override fun afterTextChanged(p0: Editable?) {
//        val text: String = p0.toString()
//        when (binding.root) {
//            binding.edtA -> {
//                if (text.length == 1)
//                    binding.edtB.requestFocus()
//            }
//            binding.edtB -> {
//                if (text.length == 1)
//                    binding.edtC.requestFocus()
//                else if (text.isEmpty())
//                    binding.edtA.requestFocus()
//            }
//            binding.edtC -> {
//                if (text.length == 1)
//                    binding.edtD.requestFocus()
//                else if (text.isEmpty())
//                    binding.edtB.requestFocus()
//            }
//            binding.edtD -> {
//                if (text.isEmpty())
//                    binding.edtC.requestFocus()
//            }
//        }
//    }


    private fun timer() {
        object : CountDownTimer(120000, 1000) {
            override fun onTick(l: Long) {
                val text1 = String.format("%d : %d",
                        TimeUnit.MILLISECONDS.toMinutes(l),
                        TimeUnit.MILLISECONDS.toSeconds(l) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)))

                //countdown.setText((l/60000) + ":" + (l % 60000 / 1000));
                binding.tvResendOtpText.setText("Resend code in $text1 seconds.")
                binding.tvResendOtpText.setTextColor(getColor(R.color.textg))
            }

            override fun onFinish() {
                binding.tvResendOtpText.setText("Resend Code")
                binding.tvResendOtpText.setTextColor(getColor(R.color.red))
                checkTime = true
            }
        }.start()
    }

    private fun resendOtp() {
        if (isInternetAvailable(this)) {
            showLoader(this)

            val request = ServiceBuilder.buildService(APIinterface::class.java)
            val call = request.mobile1Login(readUsingSharedPreference(this, "mobile").toString())
            call.enqueue(object : Callback<LoginRegisterModel> {
                override fun onResponse(
                        call: Call<LoginRegisterModel>,
                        response: Response<LoginRegisterModel>
                ) {
                    dismissLoader();
                    if (response.isSuccessful) {
                        if (response.body()?.status == true) {
                            storeUsingSharedPreference(this@OTPVerificationActivity, "userid", response.body()?.messageData?.userId)
                            storeUsingSharedPreference(this@OTPVerificationActivity, "mobile", response.body()?.messageData?.mobile)
                            storeUsingSharedPreference(this@OTPVerificationActivity, "otp", response.body()?.messageData?.otp.toString())
                            storeUsingSharedPreference(this@OTPVerificationActivity, "type", response.body()?.messageData?.type.toString())


                        }else{
                            if (response.body()?.messageData?.message.equals("Deactive Account")){
                                DeactivateDialog("Your account is deactivated. Please contact administrator")
                            }else{
                                displayToast(this@OTPVerificationActivity, response.body()?.messageData?.message.toString())
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<LoginRegisterModel>, t: Throwable) {
                    displayToast(this@OTPVerificationActivity, this@OTPVerificationActivity.resources.getString(R.string.error_something_wrong))
                }
            })
        }
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
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, LoginActivity::class.java))
    }

    fun Getdata() {
        showLoader(this)
        val ownerst: String = "+91"+readUsingSharedPreference(this, "mobile").toString()
        databaseReference = FirebaseDatabase.getInstance().reference
        val query: Query = databaseReference!!.child("users").orderByChild("phone").equalTo(ownerst)
        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    dismissLoader()
                    // dataSnapshot is the "issue" node with all children with id 0
                    for (dataSnapshot1 in dataSnapshot.children) {
                        // do something with the individual "issues"
                        val usersBean: Userlist = dataSnapshot1.getValue(Userlist::class.java)!!
                        StaticConfig.UID = dataSnapshot1.key
                        val hashUser: HashMap<String, String> = dataSnapshot1.value as HashMap<String,String>
                        usersBean.userName = hashUser.get("name")
                        usersBean.photo = hashUser.get("photo")
                        usersBean.phone = hashUser.get("phone")
                        usersBean.thumbImg = hashUser.get("thumbImg")
                        usersBean.status = hashUser.get("status")
                        usersBean.appVer = hashUser.get("ver")
                        StaticConfig.phonenumber = hashUser.get("phone")
//                        SharedPreferencesManager.setAgreedToPrivacyPolicy(true)
//                        SharedPreferencesManager.saveUid(dataSnapshot1.key.toString())
//                        SharedPreferencesManager.saveMyPhoto(hashUser.get("photo") as String)
//                        SharedPreferencesManager.saveMyThumbImg(hashUser.get("thumbImg") as String)
//                        SharedPreferencesManager.saveMyUsername(hashUser.get("name") as String)
//                        SharedPreferencesManager.savePhoneNumber(hashUser.get("phone") as String)
//                        SharedPreferencesManager.saveMyStatus(hashUser.get("status") as String)
//                        SharedPreferencesManager.setAppVersionSaved(true)
//                        SharedPreferencesManager.saveCountryCode("IN")
//                        RealmHelper.getInstance().saveObjectToRealm(
//                            CurrentUserInfo(
//                                StaticConfig.UID,
//                                StaticConfig.phonenumber
//                            )
//                        )


                        storeUsingSharedPreference(
                            this@OTPVerificationActivity,
                            "UidK",dataSnapshot1.key
                        )



                    //    FireConstants.deviceIdRef.child(dataSnapshot1.key.toString()).setValue(DeviceId.id)


                        readUsingSharedPreference(this@OTPVerificationActivity, "UidK")
                        readUsingSharedPreference(this@OTPVerificationActivity, "UidK")


//                        SharedPreferencesManager.setAgreedToPrivacyPolicy(true)
//                        SharedPreferencesManager.setUserInfoSaved(true)
//                        val userName :String = hashUser.get("name")!!
//                         SharedPreferencesManager.saveSetupInfo(userName, pickedPhoto, backupFileUri, dbFileUri)
//                         SharedPreferencesManager.setHasEnteredUsername(true)
                       //  SetupUserActivity.start(this@OTPVerificationActivity, userName, pickedPhoto, backupFileUri, dbFileUri)

                        //  val fetchGroups = groupManager.fetchUserGroups()


//                        try {
//                            //Try to restore backup if it's Below API 29
//                            RealmBackupRestore().restore(false)
//                        } catch (e: IOException) {
//                            e.printStackTrace()
//                        } catch (e: RealmMigrationNeededException) {
//                            e.printStackTrace()
//                        } catch (e: BackupFileMismatchedException) {
//                            e.printStackTrace()
//
//                        }

                        // RealmBackupRestore().backup()


                        //startTheActivity()
                    }
                } else {
                    dismissLoader()
                    displayToast(this@OTPVerificationActivity,"User not found")
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                dismissLoader()
            }
        })
    }

    private fun startSmartUserConsent(){
        val client = SmsRetriever.getClient(this)
        client.startSmsUserConsent(null)
            .addOnSuccessListener {
                //Toast.makeText(this,"Waiting for OTP!",Toast.LENGTH_LONG).show()
            }

            .addOnFailureListener {
                Toast.makeText(this,it.localizedMessage, Toast.LENGTH_LONG).show()
            }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_USER_CONSENT){
            if (resultCode == Activity.RESULT_OK && data != null){
                val message = data.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE)
                getOtpFromMessage(message)
            }else{
                Toast.makeText(this,"Faill", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun getOtpFromMessage(message:String?){
        val otpPatter = Pattern.compile("(|^)\\d{4}")
        val matcher = otpPatter.matcher(message)
        if (matcher.find()){
            binding.otpView.setText(matcher.group(0))
            LoginClick()

        }else{
            Toast.makeText(this,"Try again!", Toast.LENGTH_LONG).show()
        }
    }

    fun LoginClick() {
        val otp = binding.otpView.text.toString()
        if (viewModel.validateData(otp)) {
            if (isInternetAvailable(this)) {
                showLoader(this)
                val request = ServiceBuilder.buildService(APIinterface::class.java)
                val call = request.app_user_verify_otp(readUsingSharedPreference(this, "userid").toString(), otp, readUsingSharedPreference(this, "mobile").toString(), "Android", token)
                call.enqueue(object : Callback<OTPVerifyModel> {
                    override fun onResponse(
                        call: Call<OTPVerifyModel>,
                        response: Response<OTPVerifyModel>
                    ) {
                        dismissLoader();
                        if (response.isSuccessful) {
                            if (response.body()?.status == true) {
                                if (response.body()?.data?.size != 0) {
                                    displayToast(
                                        this@OTPVerificationActivity,
                                        response.body()?.msg.toString()
                                    )
                                    dismissLoader()

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "userid",
                                        response.body()?.data?.get(0)?.userdata?.id
                                    )
                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "mobile",
                                        response.body()?.data?.get(0)?.userdata?.phone.toString()
                                    )
                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "type",
                                        response.body()?.data?.get(0)?.userdata?.type.toString()
                                    )
                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "companyphone",
                                        response.body()?.data?.get(0)?.userdata?.company_number
                                    )

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "dob",
                                        response.body()?.data?.get(0)?.userdata?.dob
                                    )
                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "fullname",
                                        response.body()?.data?.get(0)?.userdata?.first_name.toString() + " " + response.body()?.data?.get(0)?.userdata?.middle_name.toString() + " " + response.body()?.data?.get(0)?.userdata?.last_name.toString()
                                    )

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "email",
                                        response.body()?.data?.get(0)?.userdata?.email_address.toString()
                                    )

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "company_name",
                                        response.body()?.data?.get(0)?.userdata?.company.toString()
                                    )
                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "company_address",
                                        response.body()?.data?.get(0)?.userdata?.company_address.toString()
                                    )
                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "designation",
                                        response.body()?.data?.get(0)?.userdata?.designation.toString()
                                    )

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "firstname",
                                        response.body()?.data?.get(0)?.userdata?.first_name.toString()
                                    )

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "meddlename",
                                        response.body()?.data?.get(0)?.userdata?.middle_name.toString()
                                    )
                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "lastname",
                                        response.body()?.data?.get(0)?.userdata?.last_name.toString()
                                    )

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "profilepic",
                                        "https://applex360.co.in/j4e_new/upload/avatar/" + response.body()?.data?.get(0)?.userdata?.avatar.toString()
                                    )

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "total_experience",
                                        response.body()?.data?.get(0)?.userdata?.total_experience
                                    )
                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "business_category",
                                        response.body()?.data?.get(0)?.userdata?.business_category
                                    )
                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "business_entity",
                                        response.body()?.data?.get(0)?.userdata?.business_entity
                                    )
                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "business_type",
                                        response.body()?.data?.get(0)?.userdata?.business_type
                                    )

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "membertyype",
                                        response.body()?.data?.get(0)?.userdata?.membership_type.toString()
                                    )


                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "signup_source", "api"
                                    )


                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "PostCountnew",response.body()?.data?.get(0)?.userdata?.notification_count?.post_count.toString()
                                    )

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "LeadCountnew",response.body()?.data?.get(0)?.userdata?.notification_count?.lead_count.toString()
                                    )

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "BuddyCountnew",response.body()?.data?.get(0)?.userdata?.notification_count?.buddy_count.toString()
                                    )


                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "PostCountOld",response.body()?.data?.get(0)?.userdata?.notification_count?.post_count.toString()
                                    )

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "LeadCountOld",response.body()?.data?.get(0)?.userdata?.notification_count?.lead_count.toString()
                                    )

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "BuddyCountOld",response.body()?.data?.get(0)?.userdata?.notification_count?.buddy_count.toString()
                                    )

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "eventCountOld",response.body()?.data?.get(0)?.userdata?.notification_count?.event_count.toString()
                                    )

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "notificatCountOld",response.body()?.data?.get(0)?.userdata?.notification_count?.notificat_count.toString()
                                    )

                                    val Connection:Int=
                                        response.body()?.data?.get(0)?.userdata?.notification_count?.connection_receive_count?.toInt()!! + response.body()?.data?.get(0)?.userdata?.notification_count?.connection_sent_count?.toInt()!!

                                    storeUsingSharedPreference(
                                        this@OTPVerificationActivity,
                                        "ConnectionCountOld", Connection.toString())


                                    if (response.body()?.data?.get(0)?.userdata?.membership_type.equals("0")) {
                                        if (response.body()?.data?.get(0)?.userdata?.is_admin.equals("0")){
                                            storeUsingSharedPreference(this@OTPVerificationActivity, "loginStatus", "false")
                                            startActivity(Intent(this@OTPVerificationActivity, FirstLoginMembershipAddActivity::class.java))
                                            finishAffinity()
                                        }else{
                                            storeUsingSharedPreference(this@OTPVerificationActivity, "loginStatus", "true")
                                            Getdata()
                                            //SharedPreferencesManager.saveUid(response.body()?.data?.get(0)?.userdata?.chat_id.toString())
                                            storeUsingSharedPreference(this@OTPVerificationActivity, "UidK", response.body()?.data?.get(0)?.userdata?.chat_id)
                                            readUsingSharedPreference(this@OTPVerificationActivity, "UidK")
                                            storeUsingSharedPreference(this@OTPVerificationActivity,"showupdate","yes")
                                            startActivity(Intent(this@OTPVerificationActivity, MainActivity::class.java))
                                            finishAffinity()
                                        }

                                    } else {
                                        storeUsingSharedPreference(this@OTPVerificationActivity, "loginStatus", "true")
                                        Getdata()
                                        //SharedPreferencesManager.saveUid(response.body()?.data?.get(0)?.userdata?.chat_id.toString())
                                        storeUsingSharedPreference(this@OTPVerificationActivity, "UidK", response.body()?.data?.get(0)?.userdata?.chat_id)
                                        readUsingSharedPreference(this@OTPVerificationActivity, "UidK")
                                        storeUsingSharedPreference(this@OTPVerificationActivity,"showupdate","yes")
                                        startActivity(Intent(this@OTPVerificationActivity, MainActivity::class.java))
                                        finishAffinity()
                                    }
                                }

                            } else {
                                dismissLoader();
                                displayToast(this@OTPVerificationActivity, response.body()?.msg.toString())
                            }
                        }
                    }

                    override fun onFailure(call: Call<OTPVerifyModel>, t: Throwable) {
                        dismissLoader();
                        displayToast(this@OTPVerificationActivity, resources.getString(R.string.error_something_wrong))
                    }
                })
            }
        }
    }

    private fun registerBroadcastReceiver(){
        smsBroadcastReceiver = SmsBroadcastReceiver()
        smsBroadcastReceiver!!.smsBroadcastReceiverListener=object : SmsBroadcastReceiver.SmsBroadcastReceiverListener{
            override fun onSuccess(intent: Intent?) {

                startActivityForResult(intent,REQ_USER_CONSENT)
            }

            override fun onFailure() {

            }

        }

        val intentFilter = IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION)
        registerReceiver(smsBroadcastReceiver,intentFilter)

    }

    override fun onStart() {
        super.onStart()
        registerBroadcastReceiver()
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(smsBroadcastReceiver)
    }

    override fun onResume() {
        super.onResume()
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

