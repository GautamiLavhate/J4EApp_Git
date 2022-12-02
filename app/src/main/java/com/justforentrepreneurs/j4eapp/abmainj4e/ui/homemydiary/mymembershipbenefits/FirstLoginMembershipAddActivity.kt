package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.database.*
import com.justforentrepreneurs.StaticConfig
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.Userlist
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivityOP
import com.justforentrepreneurs.j4eapp.abmainj4e.network.model.AppUserAccDetailModel
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.AllPlan
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.Dataplan
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.MemberShipFirstAdd
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.ReferralCodeResponse
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.interfacess.OnClickPosPlan
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.databinding.ActivityMembershipAddBinding
import com.justforentrepreneurs.j4eapp.databinding.LayMymebershipupgradebottomshitBinding
//import com.justforentrepreneurs.j4eapp.exceptions.BackupFileMismatchedException
//import com.justforentrepreneurs.j4eapp.model.realms.CurrentUserInfo
//import com.justforentrepreneurs.j4eapp.utils.*
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import io.realm.exceptions.RealmMigrationNeededException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class FirstLoginMembershipAddActivity : BaseActivityOP(),OnClickPosPlan ,PaymentResultListener {
    private lateinit var binding: ActivityMembershipAddBinding
    private val emailPattern:String="[a-zA-Z0-9._-]+@[a-z]+\\\\.+[a-z]+"


    private var pickedPhoto: String? = null
    private var backupFileUri: String? = null
    private var dbFileUri: String? = null

    var posttion:Int = 0
    lateinit var dialogbm: BottomSheetDialog
    private lateinit var mData: MutableList<Dataplan>

    var referred_by: String="0"

    var databaseReference: DatabaseReference? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_membership_add)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.j4e_membership_card)
        binding.toolbar.tvEdit.text = ""
        binding.toolbar.ivBack.visibility= View.GONE
        var myStr = intent.getStringExtra("SubScribeBackPress")
        if (myStr.equals("back")){
            onBackPressData()
        }
        if (intent.getStringExtra("login") == "isSocialLogin"){
            binding.edtname.setText(readUsingSharedPreference(this@FirstLoginMembershipAddActivity, "firstname").toString())
            binding.edtlast.setText(readUsingSharedPreference(this@FirstLoginMembershipAddActivity, "lastname").toString())
            binding.email.setText(readUsingSharedPreference(this@FirstLoginMembershipAddActivity, "email").toString().replace("null",""))
        }else{
            binding.mobilenumber.setText(readUsingSharedPreference(this@FirstLoginMembershipAddActivity, "mobile").toString())
            binding.mobilenumber.setTag( binding.mobilenumber.getKeyListener())
            binding.mobilenumber.keyListener=null
        }

        Checkout.preload(applicationContext)


        binding.referalcode.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if(binding.referalcode.text.length == 10){
                    app_check_referral_code(binding.referalcode.text.toString())
                }

            }
            override fun afterTextChanged(editable: Editable) {
                if (binding.referalcode.text.length < 10){
                    binding.referalcode.setError("Enter valid number")
                }else if (binding.referalcode.text.length == 10){
                    app_check_referral_code(binding.referalcode.text.toString())
                }

            }
        })



        binding.savemember.setOnClickListener {
            if (validation()) {
                if (isInternetAvailable(this)) {
                    showLoader(this)
                    val request = ServiceBuilder.buildService(APIinterface::class.java)
                    val call = request.app_user_add_membership_details(readUsingSharedPreference(this@FirstLoginMembershipAddActivity, "userid").toString(), binding.edtname.text.toString(), binding.edtmiddle.text.toString(), binding.edtlast.text.toString(), binding.email.text.toString(),
                            binding.mobilenumber.text.toString(), binding.designationprofession.text.toString(), binding.companyOrganisation.text.toString(), binding.officephone.text.toString(), binding.address.text.toString(), binding.referalcode.text.toString(),"1",""
                        ,"","","","",referred_by,binding.edtWhatspp.text.toString(),"")
                    call.enqueue(object : Callback<MemberShipFirstAdd> {
                        override fun onResponse(
                                call: Call<MemberShipFirstAdd>,
                                response: Response<MemberShipFirstAdd>) {
                            dismissLoader();
                            if (response.isSuccessful) {
                                if (response.body()?.status == true) {
                                    if (response.body()?.data?.size != 0) {

                                        storeUsingSharedPreference(
                                            this@FirstLoginMembershipAddActivity,
                                            "loginStatus",
                                            "true"
                                        )
                                        storeUsingSharedPreference(
                                            this@FirstLoginMembershipAddActivity,
                                            "mobile",
                                            response.body()?.data?.get(0)?.userdata?.mobile
                                        )
                                        storeUsingSharedPreference(
                                            this@FirstLoginMembershipAddActivity,
                                            "companyphone",
                                            response.body()?.data?.get(0)?.userdata?.company_phone
                                        )
                                        storeUsingSharedPreference(
                                            this@FirstLoginMembershipAddActivity,
                                            "company_name",
                                            response.body()?.data?.get(0)?.userdata?.company_name.toString()
                                        )
                                        storeUsingSharedPreference(
                                            this@FirstLoginMembershipAddActivity,
                                            "company_address",
                                            response.body()?.data?.get(0)?.userdata?.company_address.toString()
                                        )
                                        storeUsingSharedPreference(
                                            this@FirstLoginMembershipAddActivity,
                                            "designation",
                                            response.body()?.data?.get(0)?.userdata?.designation.toString()
                                        )

                                        storeUsingSharedPreference(
                                            this@FirstLoginMembershipAddActivity,
                                            "firstname",
                                            response.body()?.data?.get(0)?.userdata?.first_name.toString()
                                        )
                                        storeUsingSharedPreference(
                                            this@FirstLoginMembershipAddActivity,
                                            "meddlename",
                                            response.body()?.data?.get(0)?.userdata?.middle_name.toString()
                                        )
                                        storeUsingSharedPreference(
                                            this@FirstLoginMembershipAddActivity,
                                            "lastname",
                                            response.body()?.data?.get(0)?.userdata?.last_name.toString()
                                        )
                                        storeUsingSharedPreference(
                                            this@FirstLoginMembershipAddActivity,
                                            "fullname",
                                            response.body()?.data?.get(0)?.userdata?.first_name.toString() + " " + response.body()?.data?.get(0)?.userdata?.middle_name.toString() + " " + response.body()?.data?.get(0)?.userdata?.last_name.toString()
                                        )

                                        storeUsingSharedPreference(
                                            this@FirstLoginMembershipAddActivity,
                                            "membertyype",
                                            response.body()?.data?.get(0)?.userdata?.membership_type.toString()
                                        )

                                        storeUsingSharedPreference(
                                            this@FirstLoginMembershipAddActivity,
                                            "email",
                                            response.body()?.data?.get(0)?.userdata?.email.toString())


                                        displayToast(
                                            this@FirstLoginMembershipAddActivity,
                                            response.body()?.message.toString()
                                        )

                                        //SharedPreferencesManager.saveUid(response.body()?.data?.get(0)?.userdata?.chat_id.toString())
                                        storeUsingSharedPreference(
                                            this@FirstLoginMembershipAddActivity,
                                            "UidK", response.body()?.data?.get(0)?.userdata?.chat_id
                                        )



                                        Getdata()
                                        startActivity(
                                            Intent(
                                                this@FirstLoginMembershipAddActivity,
                                                MainActivity::class.java
                                            )
                                        )
                                    }

                                } else {
                                    displayToast(this@FirstLoginMembershipAddActivity, response.body()?.message.toString())
                                }
                            }
                        }

                        override fun onFailure(call: Call<MemberShipFirstAdd>, t: Throwable) {
                            displayToast(this@FirstLoginMembershipAddActivity, this@FirstLoginMembershipAddActivity.resources.getString(R.string.error_something_wrong))
                        }
                    })
                }
            }


        }

        binding.buyPlan.setOnClickListener {
            if (validation()) {
                storeUsingSharedPreference(
                    this,
                    "mobile",
                    binding.mobilenumber.text.toString()
                )
                storeUsingSharedPreference(
                    this,
                    "companyphone",
                    binding.officephone.text.toString()
                )
                storeUsingSharedPreference(
                    this,
                    "company_name",
                    binding.companyOrganisation.text.toString()
                )
                storeUsingSharedPreference(
                    this,
                    "company_address",
                    binding.address.text.toString()
                )
                storeUsingSharedPreference(
                    this,
                    "designation",
                    binding.designationprofession.text.toString()
                )

                storeUsingSharedPreference(
                    this,
                    "firstname",
                    binding.edtname.text.toString()
                )
                storeUsingSharedPreference(
                    this,
                    "meddlename",
                    binding.edtmiddle.text.toString()
                )
                storeUsingSharedPreference(
                    this,
                    "lastname",
                    binding.edtlast.text.toString()
                )

                storeUsingSharedPreference(
                    this,
                    "email",
                    binding.email.text.toString())
                val intent = Intent(this, SubscribePlanActivity::class.java)
                intent.putExtra("first_name",binding.edtname.text.toString())
                intent.putExtra("middle_name",binding.edtmiddle.text.toString())
                intent.putExtra("last_name",binding.edtlast.text.toString())
                intent.putExtra("email",binding.email.text.toString())
                intent.putExtra("mobile",binding.mobilenumber.text.toString())
                intent.putExtra("designation",binding.designationprofession.text.toString())
                intent.putExtra("company_name",binding.companyOrganisation.text.toString())
                intent.putExtra("company_phone",binding.officephone.text.toString())
                intent.putExtra("company_address",binding.address.text.toString())
                intent.putExtra("referral_code",binding.referalcode.text.toString())
                intent.putExtra("referred_by",referred_by)
                intent.putExtra("whatsapp",binding.edtWhatspp.text.toString())
                intent.putExtra("whatsapp_business","")
                startActivity(intent)

//                val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
//                val mBSRewardListBinding: LayMymebershipupgradebottomshitBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.lay_mymebershipupgradebottomshit, null, false)
//                dialog.setCancelable(false)
//                dialog.setCanceledOnTouchOutside(false)
//                dialog.setContentView(mBSRewardListBinding.root)
//
//                val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
//                mBSRewardListBinding.linearlayout1.startAnimation(anim)
//
//                val layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
//                mBSRewardListBinding.recyclerUpgradePlan.layoutManager = layoutManager
//
//                getAllPlans(mBSRewardListBinding,dialog)
//
//                mBSRewardListBinding.ivcancle.setOnClickListener {
//                    dialog.dismiss()
//                }
//                dialog.show()
            }
        }

    }

    override fun onBackPressed() {

    }

    fun validation() : Boolean {

        var Temp: Boolean? = true
        if (binding.edtname.text.toString().length == 0) {
            binding.edtname.setError("Field is empty")
            Temp = false
        } else {
            binding.edtname.setError(null)
        }

        if (binding.edtlast.text.toString().length == 0) {
            binding.edtlast.setError("Field is empty")
            Temp = false
        } else {
            binding.edtlast.setError(null)
        }

        if (binding.email.text.toString().length == 0) {
            binding.email.setError("Field is empty")
            Temp = false
        } else {
            binding.email.setError(null)
        }

        val enailvalid:String=binding.email.text.toString()

        if (!Patterns.EMAIL_ADDRESS.matcher(enailvalid).matches()) {
            binding.email.setError("Invalid email")
            Temp = false
        } else {
            binding.email.setError(null)
        }

//        if (binding.designationprofession.text.toString().length == 0) {
//            binding.designationprofession.setError("Field is empty")
//            Temp = false
//        } else {
//            binding.designationprofession.setError(null)
//        }

//        if (binding.companyOrganisation.text.toString().length == 0) {
//            binding.companyOrganisation.setError("Field is empty")
//            Temp = false
//        } else {
//            binding.companyOrganisation.setError(null)
//        }

//        if (binding.edtWhatspp.text.toString().length == 0 && binding.edtWhatsppBusiness.text.toString().length == 0){
//            binding.edtWhatspp.setError("Field is empty")
//            binding.edtWhatsppBusiness.setError("Field is empty")
//            Temp = false
//        }else{
//            binding.edtWhatspp.setError(null)
//            binding.edtWhatsppBusiness.setError(null)
//        }

        if (binding.edtWhatspp.text.toString().length == 0) {
            binding.edtWhatspp.setError("Field is empty")
            Temp = false
        } else {
            binding.edtWhatspp.setError(null)
        }

        if (binding.mobilenumber.text.toString().length == 0) {
            binding.mobilenumber.setError("Field is empty")
            Temp = false
        } else {
            binding.mobilenumber.setError(null)
        }

        /*if (binding.officephone.text.toString().length == 0) {
            binding.officephone.setError("Field is empty")
            Temp = false
        } else {
            binding.officephone.setError(null)
        }

        if (binding.address.text.toString().length == 0) {
            binding.address.setError("Field is empty")
            Temp = false
        } else {
            binding.address.setError(null)
        }*/


        return Temp!!
    }

    private fun getAppUserAccDetail() {
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.getaccountdetals(readUsingSharedPreference(this@FirstLoginMembershipAddActivity, "userid").toString(),"")
        showLoader(this);
        call.enqueue(object : Callback<AppUserAccDetailModel> {
            override fun onResponse(call: Call<AppUserAccDetailModel>, response: Response<AppUserAccDetailModel>) {
                dismissLoader();
                if (response.isSuccessful){
                    if (response.body()?.status==true) {
                        if (response.body()?.messageData != null) {

                            if(!response.body()?.messageData?.companyAddress.equals("null")){
                                binding.address.setText(response.body()?.messageData?.companyAddress)
                            }

                            if(!response.body()?.messageData?.email.equals("null")){
                                binding.email.setText(response.body()?.messageData?.email)
                            }

                            if(!response.body()?.messageData?.designation.equals("null")){
                                binding.designationprofession.setText(response.body()?.messageData?.designation)
                            }

                            if(!response.body()?.messageData?.companyName.equals("null")){
                                binding.companyOrganisation.setText(response.body()?.messageData?.companyName)
                            }

                            if(!response.body()?.messageData?.mobile.equals("null")){
                                binding.mobilenumber.setText(response.body()?.messageData?.mobile)
                            }

                            if(!response.body()?.messageData?.companyPhone.equals("null")){
                                binding.officephone.setText(response.body()?.messageData?.companyPhone)
                            }

                            if(!response.body()?.messageData?.first_name.equals("null")){
                                binding.edtname.setText(response.body()?.messageData?.first_name)
                            }
                            if(!response.body()?.messageData?.middle_name.equals("null")){
                                binding.edtmiddle.setText(response.body()?.messageData?.middle_name)
                            }

                            if(!response.body()?.messageData?.last_name.equals("null")){
                                binding.edtlast.setText(response.body()?.messageData?.last_name)
                            }

                            storeUsingSharedPreference(this@FirstLoginMembershipAddActivity, "dob", response.body()?.messageData?.dob)
                            storeUsingSharedPreference(this@FirstLoginMembershipAddActivity, "firstname", response.body()?.messageData?.first_name.toString())
                            storeUsingSharedPreference(this@FirstLoginMembershipAddActivity, "meddlename", response.body()?.messageData?.middle_name.toString())
                            storeUsingSharedPreference(this@FirstLoginMembershipAddActivity, "lastname", response.body()?.messageData?.last_name.toString())
                            storeUsingSharedPreference(this@FirstLoginMembershipAddActivity, "fullname", response.body()?.messageData?.first_name.toString()+" "+ response.body()?.messageData?.middle_name.toString()+" "+response.body()?.messageData?.last_name.toString())
                            storeUsingSharedPreference(this@FirstLoginMembershipAddActivity, "profilepic", response.body()?.messageData?.profilePic.toString())


                        }
                    }
                }
            }
            override fun onFailure(call: Call<AppUserAccDetailModel>, t: Throwable) {
                displayToast(this@FirstLoginMembershipAddActivity, this@FirstLoginMembershipAddActivity.resources.getString(R.string.error_something_wrong))
            }
        })
    }

    private fun getAllPlans(mBSRewardListBinding:LayMymebershipupgradebottomshitBinding,dialog: BottomSheetDialog){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_all_plan()
        call.enqueue(object : Callback<AllPlan> {
            override fun onResponse(
                    call: Call<AllPlan>,
                    response: Response<AllPlan>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            mBSRewardListBinding.linearlayout1.visibility=View.GONE
                            mBSRewardListBinding.recyclerUpgradePlan.visibility=View.VISIBLE
                            val mAdapter = SubScribeAdapter(this@FirstLoginMembershipAddActivity,response.body()?.data as MutableList<Dataplan>,this@FirstLoginMembershipAddActivity,dialog)
                            mBSRewardListBinding.recyclerUpgradePlan.adapter = mAdapter

                        }else{
                            mBSRewardListBinding.linearlayout1.visibility=View.GONE
                            mBSRewardListBinding.recyclerUpgradePlan.visibility=View.VISIBLE
                        }
                    }
                }
            }

            override fun onFailure(call: Call<AllPlan>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    override fun onClickPos(pos: Int, mdata: MutableList<Dataplan>,dialog: BottomSheetDialog) {
        posttion=pos
        dialogbm=dialog
        mData = mdata
//        displayToast(this,mdata.get(pos).membership_title+","+
//                mdata.get(pos).membership_cost+","+
//                readUsingSharedPreference(this, "email").toString()+","+
//                readUsingSharedPreference(this, "mobile").toString())
        //startPayment(mdata.get(pos).membership_title,mdata.get(pos).membership_cost,readUsingSharedPreference(this, "email").toString(),readUsingSharedPreference(this, "mobile").toString())
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

                        storeUsingSharedPreference(this@FirstLoginMembershipAddActivity,
                            "UidK",dataSnapshot1.key)
                        readUsingSharedPreference(this@FirstLoginMembershipAddActivity, "UidK")
                        readUsingSharedPreference(this@FirstLoginMembershipAddActivity, "UidK")

//                        FireConstants.deviceIdRef.child(dataSnapshot1.key.toString()).setValue(
//                            DeviceId.id)
//
//                        SharedPreferencesManager.setAgreedToPrivacyPolicy(true)
//                        SharedPreferencesManager.setUserInfoSaved(true)
                        val userName :String = hashUser.get("name")!!
//                        SharedPreferencesManager.saveSetupInfo(userName, pickedPhoto, backupFileUri, dbFileUri)
//                        SharedPreferencesManager.setHasEnteredUsername(true)



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
                    displayToast(this@FirstLoginMembershipAddActivity,"User not found")
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                dismissLoader()
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
            Toast.makeText(activity,"Error in payment: "+ e.message,Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    override fun onPaymentSuccess(p0: String?) {

        startApiTan(posttion, mData, dialogbm, p0.toString())
        Toast.makeText(this, "Payment is successful", Toast.LENGTH_SHORT).show()
    }

    override fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(this, " Payment Cancel ",Toast.LENGTH_SHORT).show();
    }

    private fun startApiTan(pos: Int, mdata: MutableList<Dataplan>,dialog: BottomSheetDialog,p1: String){
        if (isInternetAvailable(this)) {
            showLoader(this)
            val request = ServiceBuilder.buildService(APIinterface::class.java)
            val sdf = SimpleDateFormat("dd-MM-yyyy hh:mm a")
            val currentDate = sdf.format(Date())
            val call = request.app_user_add_membership_details(readUsingSharedPreference(this@FirstLoginMembershipAddActivity, "userid").toString(), binding.edtname.text.toString(), binding.edtmiddle.text.toString(), binding.edtlast.text.toString(), binding.email.text.toString(),
                binding.mobilenumber.text.toString(), binding.designationprofession.text.toString(), binding.companyOrganisation.text.toString(), binding.officephone.text.toString(),
                binding.address.text.toString(), binding.referalcode.text.toString(),"2",
                mdata.get(pos).membership_id,p1,mdata.get(pos).membership_cost,currentDate,"online",referred_by,binding.edtWhatspp.text.toString(),"")
            call.enqueue(object : Callback<MemberShipFirstAdd> {
                override fun onResponse(
                    call: Call<MemberShipFirstAdd>,
                    response: Response<MemberShipFirstAdd>) {
                    dismissLoader();
                    if (response.isSuccessful) {
                        if (response.body()?.status == true) {
                            if (response.body()?.data?.size != 0) {
                                dialog.dismiss()

                                storeUsingSharedPreference(
                                    this@FirstLoginMembershipAddActivity,
                                    "loginStatus",
                                    "true"
                                )
                                storeUsingSharedPreference(
                                    this@FirstLoginMembershipAddActivity,
                                    "mobile",
                                    response.body()?.data?.get(0)?.userdata?.mobile
                                )
                                storeUsingSharedPreference(
                                    this@FirstLoginMembershipAddActivity,
                                    "companyphone",
                                    response.body()?.data?.get(0)?.userdata?.company_phone
                                )
                                storeUsingSharedPreference(
                                    this@FirstLoginMembershipAddActivity,
                                    "company_name",
                                    response.body()?.data?.get(0)?.userdata?.company_name.toString()
                                )
                                storeUsingSharedPreference(
                                    this@FirstLoginMembershipAddActivity,
                                    "company_address",
                                    response.body()?.data?.get(0)?.userdata?.company_address.toString()
                                )
                                storeUsingSharedPreference(
                                    this@FirstLoginMembershipAddActivity,
                                    "designation",
                                    response.body()?.data?.get(0)?.userdata?.designation.toString()
                                )

                                storeUsingSharedPreference(
                                    this@FirstLoginMembershipAddActivity,
                                    "firstname",
                                    response.body()?.data?.get(0)?.userdata?.first_name.toString()
                                )
                                storeUsingSharedPreference(
                                    this@FirstLoginMembershipAddActivity,
                                    "meddlename",
                                    response.body()?.data?.get(0)?.userdata?.middle_name.toString()
                                )
                                storeUsingSharedPreference(
                                    this@FirstLoginMembershipAddActivity,
                                    "lastname",
                                    response.body()?.data?.get(0)?.userdata?.last_name.toString()
                                )
                                storeUsingSharedPreference(
                                    this@FirstLoginMembershipAddActivity,
                                    "fullname",
                                    response.body()?.data?.get(0)?.userdata?.first_name.toString() + " " + response.body()?.data?.get(0)?.userdata?.middle_name.toString() + " " + response.body()?.data?.get(0)?.userdata?.last_name.toString()
                                )

                                storeUsingSharedPreference(
                                    this@FirstLoginMembershipAddActivity,
                                    "membertyype",
                                    response.body()?.data?.get(0)?.userdata?.membership_type.toString()
                                )

                                storeUsingSharedPreference(
                                    this@FirstLoginMembershipAddActivity,
                                    "email",
                                    response.body()?.data?.get(0)?.userdata?.email.toString())
                                //SharedPreferencesManager.saveUid(response.body()?.data?.get(0)?.userdata?.chat_id.toString())
                                storeUsingSharedPreference(
                                    this@FirstLoginMembershipAddActivity,
                                    "UidK", response.body()?.data?.get(0)?.userdata?.chat_id
                                )

                                displayToast(
                                    this@FirstLoginMembershipAddActivity,
                                    response.body()?.message.toString()
                                )

                                Getdata()


                                startActivity(

                                    Intent(
                                        this@FirstLoginMembershipAddActivity,
                                        MainActivity::class.java
                                    )
                                )
                            }

                        } else {
                            displayToast(this@FirstLoginMembershipAddActivity, response.body()?.message.toString())
                        }
                    }
                }

                override fun onFailure(call: Call<MemberShipFirstAdd>, t: Throwable) {
                    displayToast(this@FirstLoginMembershipAddActivity, this@FirstLoginMembershipAddActivity.resources.getString(R.string.error_something_wrong))
                }
            })
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === 1) {
            if (resultCode === RESULT_OK) {
                var myStr = data?.getStringExtra("SubScribeBackPress")
                if (myStr.equals("back")){
                    onBackPressData()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        var myStr = intent.getStringExtra("SubScribeBackPress")
        if (myStr.equals("back")){
            onBackPressData()
        }
    }

    private fun onBackPressData(){
        binding.edtname.setText(readUsingSharedPreference(this,"firstname"))
        binding.edtmiddle.setText(readUsingSharedPreference(this,"meddlename"))
        binding.edtlast.setText(readUsingSharedPreference(this,"lastname"))
        binding.email.setText(readUsingSharedPreference(this,"email"))
        binding.designationprofession.setText(readUsingSharedPreference(this,"designation"))
        binding.companyOrganisation.setText(readUsingSharedPreference(this,"company_name"))
        binding.mobilenumber.setText(readUsingSharedPreference(this,"mobile"))
        binding.officephone.setText(readUsingSharedPreference(this,"companyphone"))
        binding.address.setText(readUsingSharedPreference(this,"company_address"))
    }

    private fun app_check_referral_code(code:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_check_referral_code(code)
        call.enqueue(object : Callback<ReferralCodeResponse> {
            override fun onResponse(
                call: Call<ReferralCodeResponse>,
                response: Response<ReferralCodeResponse>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        binding.imgCorrect.visibility=View.VISIBLE
                        binding.txtValid.visibility=View.VISIBLE
                        binding.txtInValid.visibility=View.GONE
                        binding.imgIncorrect.visibility=View.GONE
                        referred_by=response.body()?.data?.userid.toString()
                    }else{
                        displayToast(this@FirstLoginMembershipAddActivity,response.body()?.msg.toString())
                        binding.imgIncorrect.visibility=View.VISIBLE
                        binding.imgCorrect.visibility=View.GONE
                        binding.txtValid.visibility=View.GONE
                        binding.txtInValid.visibility=View.VISIBLE
                        referred_by="0"
                    }
                }
            }

            override fun onFailure(call: Call<ReferralCodeResponse>, t: Throwable) {
                dismissLoader();
                binding.imgIncorrect.visibility=View.VISIBLE
                binding.imgCorrect.visibility=View.GONE
                binding.txtValid.visibility=View.GONE
                binding.txtInValid.visibility=View.VISIBLE
                referred_by="0"
            }
        })
    }
}