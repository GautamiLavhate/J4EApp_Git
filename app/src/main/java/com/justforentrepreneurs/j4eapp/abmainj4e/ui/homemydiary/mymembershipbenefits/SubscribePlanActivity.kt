package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.database.*
import com.justforentrepreneurs.StaticConfig
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.Userlist
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.*
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.adapter.AdapterMembershipTitle
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.adapter.AdapterSubscribeCount
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.interfacess.OnClickPlan
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.databinding.ActivitySubscribePlanBinding
import com.justforentrepreneurs.j4eapp.databinding.ThankYouBottomSheetBinding
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

class SubscribePlanActivity : BaseActivity(), OnClickPlan, PaymentResultListener {
    private lateinit var binding:ActivitySubscribePlanBinding
    private var pickedPhoto: String? = null
    private var backupFileUri: String? = null
    private var dbFileUri: String? = null
    var databaseReference: DatabaseReference? = null
    var first_name:String=""
    var middle_name:String=""
    var last_name:String=""
    var email:String=""
    var mobile:String=""
    var designation:String=""
    var company_name:String=""
    var company_phone:String=""
    var company_address:String=""
    var referral_code:String=""
    var whatsapp:String=""
    var whatsapp_business:String=""
    var posttion:Int = 0
    private lateinit var mData: MutableList<Dataplan>
    var referred_by:String=""

    override fun enablePresence(): Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_subscribe_plan)
        binding.toolbar.tvTitle.text="Membership Details"
        binding.toolbar.backImageView.setOnClickListener {
            onBackPressed()
        }

        first_name=intent.getStringExtra("first_name").toString()
        middle_name=intent.getStringExtra("middle_name").toString()
        last_name=intent.getStringExtra("last_name").toString()
        email=intent.getStringExtra("email").toString()
        mobile=intent.getStringExtra("mobile").toString()
        designation=intent.getStringExtra("designation").toString()
        company_name=intent.getStringExtra("company_name").toString()
        company_phone=intent.getStringExtra("company_phone").toString()
        company_address=intent.getStringExtra("company_address").toString()
        referral_code=intent.getStringExtra("referral_code").toString()
        referred_by=intent.getStringExtra("referred_by").toString()
        whatsapp=intent.getStringExtra("whatsapp").toString()
        whatsapp_business=intent.getStringExtra("whatsapp_business").toString()

//        displayToast(this,referred_by)

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvMembershipTitle.layoutManager = layoutManager
        val layoutManager1 = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.rvMembershipFeature.layoutManager = layoutManager1
        get_payment_key()
        getAllPlans()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, FirstLoginMembershipAddActivity::class.java)
        intent.putExtra("SubScribeBackPress","back")
        startActivity(intent)
    }

    private fun getAllPlans(){
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
                        binding.linearlayout1.visibility= View.GONE
                        binding.linearlayout.visibility= View.VISIBLE
                        Glide.with(this@SubscribePlanActivity)
                            .load(response.body()?.cover_image.toString())
                            .centerCrop()
                            .into(binding.imgAdv)

                        if (response.body()?.data != null) {
                            val mAdapter = AdapterMembershipTitle(this@SubscribePlanActivity,
                                response.body()?.data?.get(0)?.membership_features as MutableList<MembershipFeaturesm>)
                            binding.rvMembershipTitle.adapter = mAdapter

                            val mAdapter1 = AdapterSubscribeCount(this@SubscribePlanActivity,
                                response.body()?.data as MutableList<Dataplan>,this@SubscribePlanActivity)
                            binding.rvMembershipFeature.adapter = mAdapter1

                        }else{

                            displayToast(this@SubscribePlanActivity,response.body()?.message.toString())
                        }
                    }else{
                        binding.linearlayout1.visibility=View.GONE
                        binding.linearlayout.visibility=View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<AllPlan>, t: Throwable) {
                dismissLoader();

            }
        })

    }

    override fun onClickPos(
        pos: Int,
        mdata: MutableList<Dataplan>,
        cost: String,
        membership_type: String
    ) {
        posttion=pos
        mData = mdata

//        displayToast(this,
//
//            mdata.get(pos).membership_title+","+
//                mdata.get(pos).membership_cost+","+
//                readUsingSharedPreference(this, "email").toString()+","+
//                readUsingSharedPreference(this, "mobile").toString()+","+pos)
        if (!cost.equals("0")){
            startPayment(mdata.get(pos).membership_title,mdata.get(pos).membership_cost,readUsingSharedPreference(this, "email").toString(),readUsingSharedPreference(this, "mobile").toString())
        }else{
            if (membership_type.equals("1")){
                guestMember(mdata)
            }
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
            if (!email.isEmpty()){
                prefill.put("email",email)
            }
            prefill.put("contact",contact)

            options.put("prefill",prefill)
            co.open(activity,options)
        }catch (e: Exception){
            Toast.makeText(activity,"Error in payment: "+ e.message,Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }
    override fun onPaymentSuccess(p0: String?) {
        startApiTan(posttion, mData,  p0.toString())
        Toast.makeText(this, "Payment is successful", Toast.LENGTH_SHORT).show()
    }

    override fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(this, " Payment Cancel ",Toast.LENGTH_SHORT).show();
    }

    private fun startApiTan(pos: Int, mdata: MutableList<Dataplan>, p1: String){
        if (isInternetAvailable(this)) {
            showLoader(this)
            val request = ServiceBuilder.buildService(APIinterface::class.java)
            val sdf = SimpleDateFormat("dd-MM-yyyy hh:mm a")
            val currentDate = sdf.format(Date())
            val call = request.app_user_add_membership_details(
                readUsingSharedPreference(this, "userid").toString(),
                first_name,
                middle_name,
                last_name,
                email,
                mobile,
                designation,
                company_name,
                company_phone,
                company_address,
                referral_code,
                "2",
                mdata.get(pos).membership_id,p1,mdata.get(pos).membership_cost,currentDate,
                "online",referred_by,whatsapp,"")
            call.enqueue(object : Callback<MemberShipFirstAdd> {
                override fun onResponse(
                    call: Call<MemberShipFirstAdd>,
                    response: Response<MemberShipFirstAdd>) {
                    dismissLoader();
                    if (response.isSuccessful) {
                        if (response.body()?.status == true) {
                            if (response.body()?.data?.size != 0) {

                                storeUsingSharedPreference(
                                    this@SubscribePlanActivity,
                                    "loginStatus",
                                    "true"
                                )
                                storeUsingSharedPreference(
                                    this@SubscribePlanActivity,
                                    "mobile",
                                    response.body()?.data?.get(0)?.userdata?.mobile
                                )
                                storeUsingSharedPreference(
                                    this@SubscribePlanActivity,
                                    "companyphone",
                                    response.body()?.data?.get(0)?.userdata?.company_phone
                                )
                                storeUsingSharedPreference(
                                    this@SubscribePlanActivity,
                                    "company_name",
                                    response.body()?.data?.get(0)?.userdata?.company_name.toString()
                                )
                                storeUsingSharedPreference(
                                    this@SubscribePlanActivity,
                                    "company_address",
                                    response.body()?.data?.get(0)?.userdata?.company_address.toString()
                                )
                                storeUsingSharedPreference(
                                    this@SubscribePlanActivity,
                                    "designation",
                                    response.body()?.data?.get(0)?.userdata?.designation.toString()
                                )

                                storeUsingSharedPreference(
                                    this@SubscribePlanActivity,
                                    "firstname",
                                    response.body()?.data?.get(0)?.userdata?.first_name.toString()
                                )
                                storeUsingSharedPreference(
                                    this@SubscribePlanActivity,
                                    "meddlename",
                                    response.body()?.data?.get(0)?.userdata?.middle_name.toString()
                                )
                                storeUsingSharedPreference(
                                    this@SubscribePlanActivity,
                                    "lastname",
                                    response.body()?.data?.get(0)?.userdata?.last_name.toString()
                                )
                                storeUsingSharedPreference(
                                    this@SubscribePlanActivity,
                                    "fullname",
                                    response.body()?.data?.get(0)?.userdata?.first_name.toString() + " " + response.body()?.data?.get(0)?.userdata?.middle_name.toString() + " " + response.body()?.data?.get(0)?.userdata?.last_name.toString()
                                )

                                storeUsingSharedPreference(
                                    this@SubscribePlanActivity,
                                    "membertyype",
                                    response.body()?.data?.get(0)?.userdata?.membership_type.toString()
                                )

                                storeUsingSharedPreference(
                                    this@SubscribePlanActivity,
                                    "email",
                                    response.body()?.data?.get(0)?.userdata?.email.toString())
                                //SharedPreferencesManager.saveUid(response.body()?.data?.get(0)?.userdata?.chat_id.toString())
                                storeUsingSharedPreference(
                                    this@SubscribePlanActivity,
                                    "UidK", response.body()?.data?.get(0)?.userdata?.chat_id
                                )

//                                displayToast(
//                                    this@SubscribePlanActivity,
//                                    response.body()?.message.toString()
//                                )
                                val sdf = SimpleDateFormat("dd-MM-yyyy hh:mm a")
                                val currentDate = sdf.format(Date())

                                val sdfTk = SimpleDateFormat("dd-MM-yyyy")
                                val currentDatesdfTk = sdfTk.format(Date())

                                val sdfTktime = SimpleDateFormat("hh:mm a")
                                val currentDatesdfTktime = sdfTktime.format(Date())
                                ThanksBm(mdata.get(pos).membership_cost,currentDatesdfTk,currentDatesdfTktime,readUsingSharedPreference(this@SubscribePlanActivity, "fullname").toString(),
                                    readUsingSharedPreference(this@SubscribePlanActivity, "email").toString())

                                Getdata()



                            }

                        } else {
                            displayToast(this@SubscribePlanActivity, response.body()?.message.toString())
                        }
                    }
                }

                override fun onFailure(call: Call<MemberShipFirstAdd>, t: Throwable) {
                    displayToast(this@SubscribePlanActivity, this@SubscribePlanActivity.resources.getString(R.string.error_something_wrong))
                }
            })
        }
        val request = ServiceBuilder.buildService(APIinterface::class.java)
//        val sdf = SimpleDateFormat("dd-MM-yyyy hh:mm a")
//        val currentDate = sdf.format(Date())
//        displayToast(this,readUsingSharedPreference(this, "userid").toString()+","+
//            first_name+","+
//            middle_name+","+
//            last_name+","+
//            email+","+
//            mobile+","+
//            designation+","+
//            company_name+","+
//            company_phone+","+
//            company_address+","+
//            referral_code+","+
//            "2"+","+
//            mdata.get(pos).membership_id+","+p1+","+mdata.get(pos).membership_cost+","+currentDate+","+"online")
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

                        storeUsingSharedPreference(this@SubscribePlanActivity,
                            "UidK",dataSnapshot1.key)
                        readUsingSharedPreference(this@SubscribePlanActivity, "UidK")
                        readUsingSharedPreference(this@SubscribePlanActivity, "UidK")

//                        FireConstants.deviceIdRef.child(dataSnapshot1.key.toString()).setValue(
//                            DeviceId.id)
//
//                        SharedPreferencesManager.setAgreedToPrivacyPolicy(true)
//                        SharedPreferencesManager.setUserInfoSaved(true)
//                        val userName :String = hashUser.get("name")!!
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
                    displayToast(this@SubscribePlanActivity,"User not found")
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                dismissLoader()
            }
        })
    }

    private fun get_payment_key(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_payment_details()
        //showLoader(this);
        call.enqueue(object : Callback<PaymentDetailsResponse> {
            override fun onResponse(
                call: Call<PaymentDetailsResponse>,
                response: Response<PaymentDetailsResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        storeUsingSharedPreference(this@SubscribePlanActivity,"razorpay_key",response.body()?.data?.razorpay_key)
                        storeUsingSharedPreference(this@SubscribePlanActivity,"razorpay_secret",response.body()?.data?.razorpay_secret)
                    } else {

                    }
                }
            }
            override fun onFailure(call: Call<PaymentDetailsResponse>, t: Throwable) {
                dismissLoader();
            }
        })
    }

    private fun ThanksBm(cost:String,curetdate:String,time:String,name:String,email:String){
        val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
        val mBSRewardListBinding: ThankYouBottomSheetBinding = DataBindingUtil.inflate(
            LayoutInflater.from(this), R.layout.thank_you_bottom_sheet, null, false)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(mBSRewardListBinding.root)

        if (cost != null){
            mBSRewardListBinding.cost.text="₹"+" "+fmt(cost)
        }

        mBSRewardListBinding.curetdate.text=curetdate
        mBSRewardListBinding.time.text=time
        mBSRewardListBinding.name.text=name
        mBSRewardListBinding.email.text=email

        mBSRewardListBinding.ivcancle.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this@SubscribePlanActivity, MainActivity::class.java))
        }

        dialog.show()
    }

    private fun guestMember(mdata: MutableList<Dataplan>){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_user_add_membership_details(
            readUsingSharedPreference(this, "userid").toString(),
            first_name,
            middle_name,
            last_name,
            email,
            mobile,
            designation,
            company_name,
            company_phone,
            company_address,
            referral_code,"1",mdata.get(posttion).membership_id,"","","","",referred_by,whatsapp,"")
        call.enqueue(object : Callback<MemberShipFirstAdd> {
            override fun onResponse(
                call: Call<MemberShipFirstAdd>,
                response: Response<MemberShipFirstAdd>) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.size != 0) {
                            storeUsingSharedPreference(
                                this@SubscribePlanActivity,
                                "loginStatus",
                                "true"
                            )
                            storeUsingSharedPreference(
                                this@SubscribePlanActivity,
                                "mobile",
                                response.body()?.data?.get(0)?.userdata?.mobile
                            )
                            storeUsingSharedPreference(
                                this@SubscribePlanActivity,
                                "companyphone",
                                response.body()?.data?.get(0)?.userdata?.company_phone
                            )
                            storeUsingSharedPreference(
                                this@SubscribePlanActivity,
                                "company_name",
                                response.body()?.data?.get(0)?.userdata?.company_name.toString()
                            )
                            storeUsingSharedPreference(
                                this@SubscribePlanActivity,
                                "company_address",
                                response.body()?.data?.get(0)?.userdata?.company_address.toString()
                            )
                            storeUsingSharedPreference(
                                this@SubscribePlanActivity,
                                "designation",
                                response.body()?.data?.get(0)?.userdata?.designation.toString()
                            )

                            storeUsingSharedPreference(
                                this@SubscribePlanActivity,
                                "firstname",
                                response.body()?.data?.get(0)?.userdata?.first_name.toString()
                            )
                            storeUsingSharedPreference(
                                this@SubscribePlanActivity,
                                "meddlename",
                                response.body()?.data?.get(0)?.userdata?.middle_name.toString()
                            )
                            storeUsingSharedPreference(
                                this@SubscribePlanActivity,
                                "lastname",
                                response.body()?.data?.get(0)?.userdata?.last_name.toString()
                            )
                            storeUsingSharedPreference(
                                this@SubscribePlanActivity,
                                "fullname",
                                response.body()?.data?.get(0)?.userdata?.first_name.toString() + " " + response.body()?.data?.get(0)?.userdata?.middle_name.toString() + " " + response.body()?.data?.get(0)?.userdata?.last_name.toString()
                            )

                            storeUsingSharedPreference(
                                this@SubscribePlanActivity,
                                "membertyype",
                                response.body()?.data?.get(0)?.userdata?.membership_type.toString()
                            )

                            storeUsingSharedPreference(
                                this@SubscribePlanActivity,
                                "email",
                                response.body()?.data?.get(0)?.userdata?.email.toString())


//                            displayToast(
//                                this@SubscribePlanActivity,
//                                response.body()?.message.toString()
//                            )

                            //SharedPreferencesManager.saveUid(response.body()?.data?.get(0)?.userdata?.chat_id.toString())
                            storeUsingSharedPreference(
                                this@SubscribePlanActivity,
                                "UidK", response.body()?.data?.get(0)?.userdata?.chat_id
                            )


                            Getdata()
                            startActivity(
                                Intent(
                                    this@SubscribePlanActivity,
                                    MainActivity::class.java
                                )
                            )
                        }

                    } else {
                        displayToast(this@SubscribePlanActivity, response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<MemberShipFirstAdd>, t: Throwable) {
                displayToast(this@SubscribePlanActivity, this@SubscribePlanActivity.resources.getString(R.string.error_something_wrong))
            }
        })
    }
}