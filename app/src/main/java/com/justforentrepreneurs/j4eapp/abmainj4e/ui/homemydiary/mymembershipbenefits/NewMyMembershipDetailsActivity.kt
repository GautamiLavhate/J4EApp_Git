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
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.*
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.adapter.AdapterFeatureCount
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.adapter.AdapterMembershipTitle
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.interfacess.OnClickPlan
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.permissions.PermissionsResponse
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.databinding.ActivityNewMyMembershipDetailsBinding
import com.justforentrepreneurs.j4eapp.databinding.ThankYouBottomSheetBinding
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class NewMyMembershipDetailsActivity : BaseActivity(),OnClickPlan,PaymentResultListener {
    private lateinit var binding: ActivityNewMyMembershipDetailsBinding
    var CurrtMemberShip:String=""
    var CurrtMemberShipCost:String=""
    var Membership_seq_no:String=""
    var memberid:String=""
    var membercost:String=""
    var memberstart:String=""
    var typePayme:String=""
    var posttion:Int = 0
    private lateinit var mData: MutableList<Dataplan>
    override fun enablePresence(): Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_new_my_membership_details)
        binding.toolbar.tvTitle.text="Membership Details"

        binding.toolbar.backImageView.setOnClickListener {
            onBackPressed()
        }

        CurrtMemberShip=intent.getStringExtra("CurrtMemberShip").toString()
        CurrtMemberShipCost=intent.getStringExtra("CurrtMemberShipCost").toString()
        Membership_seq_no=intent.getStringExtra("Membership_seq_no").toString()
        memberid=intent.getStringExtra("memberid").toString()
        membercost=intent.getStringExtra("membercost").toString()
        memberstart=intent.getStringExtra("memberstart").toString()

        getAllPlans()
    }
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
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
                        binding.linearlayout1.visibility=View.GONE
                        binding.linearlayout.visibility=View.VISIBLE
                        val layoutManager = LinearLayoutManager(this@NewMyMembershipDetailsActivity, RecyclerView.VERTICAL, false)
                        binding.rvMembershipTitle.layoutManager = layoutManager
                        val layoutManager1 = LinearLayoutManager(this@NewMyMembershipDetailsActivity, RecyclerView.HORIZONTAL, false)
                        binding.rvMembershipFeature.layoutManager = layoutManager1
                        Glide.with(this@NewMyMembershipDetailsActivity)
                            .load(response.body()?.cover_image.toString())
                            .centerCrop()
                            .into(binding.imgAdv)

                        if (response.body()?.data != null) {
                            val mAdapter = AdapterMembershipTitle(this@NewMyMembershipDetailsActivity,
                                response.body()?.data?.get(0)?.membership_features as MutableList<MembershipFeaturesm>)
                            binding.rvMembershipTitle.adapter = mAdapter

                            val mAdapter1 = AdapterFeatureCount(this@NewMyMembershipDetailsActivity,
                                response.body()?.data as MutableList<Dataplan>,
                                CurrtMemberShip,CurrtMemberShipCost,Membership_seq_no,
                                this@NewMyMembershipDetailsActivity)
                            binding.rvMembershipFeature.adapter = mAdapter1

                        }else{

                            displayToast(this@NewMyMembershipDetailsActivity,response.body()?.message.toString())
                        }
                    }else{

                    }
                }else{
                    binding.linearlayout.visibility=View.GONE
                    binding.linearlayout1.visibility=View.VISIBLE
                }
            }

            override fun onFailure(call: Call<AllPlan>, t: Throwable) {
                dismissLoader();

            }
        })

    }

    override fun onPaymentSuccess(p0: String?) {
        if(typePayme.equals("Upgrade")) {
            startApiTan(posttion, mData,  p0.toString())
        }else if(typePayme.equals("Renew")) {
            startApiRenew(p0.toString())
        }
        Toast.makeText(this, "Payment is successful", Toast.LENGTH_SHORT).show()
    }

    override fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(this, " Payment Cancel ",Toast.LENGTH_SHORT).show();
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
            //getapp_user_membership_details();
            dialog.dismiss()
            //getAllPlans()
            startActivity(intent)
        }

        dialog.show()
    }

    private fun startApiTan(pos: Int, mdata: MutableList<Dataplan>,p1: String){
        if (isInternetAvailable(this)) {
            val request = ServiceBuilder.buildService(APIinterface::class.java)
            val sdf = SimpleDateFormat("dd-MM-yyyy hh:mm a")
            val currentDate = sdf.format(Date())

            val sdfTk = SimpleDateFormat("dd-MM-yyyy")
            val currentDatesdfTk = sdfTk.format(Date())

            val sdfTktime = SimpleDateFormat("hh:mm a")
            val currentDatesdfTktime = sdfTktime.format(Date())

            val call = request.app_get_upgrade_membership(readUsingSharedPreference(this, "userid").toString(), mdata.get(pos).membership_id, p1, mdata.get(pos).membership_cost, currentDate, "online")
            showLoaderf(this)
            call.enqueue(object : Callback<ConnectionDecline> {
                override fun onResponse(
                    call: Call<ConnectionDecline>,
                    response: Response<ConnectionDecline>
                ) {
                    dismissLoader();
                    if (response.isSuccessful) {
                        if (response.body()?.status == true) {
                            displayToast(this@NewMyMembershipDetailsActivity, response.body()?.message.toString())
//                            getAllPlans()
                            app_check_permissions()
                            ThanksBm(mdata.get(pos).membership_cost,currentDatesdfTk,currentDatesdfTktime,readUsingSharedPreference(this@NewMyMembershipDetailsActivity, "fullname").toString(),readUsingSharedPreference(this@NewMyMembershipDetailsActivity, "email").toString())
                        } else {
                            displayToast(this@NewMyMembershipDetailsActivity, response.body()?.message.toString())
                        }
                    }
                }

                override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                    dismissLoader()
                    displayToast(this@NewMyMembershipDetailsActivity, resources.getString(R.string.error_something_wrong))
                }
            })
        }
    }

    private fun startApiRenew(p1: String) {
        if (isInternetAvailable(this)) {
            val request = ServiceBuilder.buildService(APIinterface::class.java)
            val sdf = SimpleDateFormat("dd-MM-yyyy hh:mm a")
            val currentDate = sdf.format(Date())

            val sdfTk = SimpleDateFormat("dd-MM-yyyy")
            val currentDatesdfTk = sdfTk.format(Date())

            val sdfTktime = SimpleDateFormat("hh:mm a")
            val currentDatesdfTktime = sdfTktime.format(Date())

            val call = request.app_get_renew_membership(
                readUsingSharedPreference(
                    this,
                    "userid"
                ).toString(), memberid, p1, membercost, currentDate, "online", memberstart
            )
            showLoaderf(this)
            call.enqueue(object : Callback<ConnectionDecline> {
                override fun onResponse(
                    call: Call<ConnectionDecline>,
                    response: Response<ConnectionDecline>
                ) {
                    dismissLoader();
                    if (response.isSuccessful) {
                        if (response.body()?.status == true) {
                            displayToast(
                                this@NewMyMembershipDetailsActivity,
                                response.body()?.message.toString()
                            )
//                            getAllPlans()
                            app_check_permissions()
                            ThanksBm(
                                membercost,
                                currentDatesdfTk,
                                currentDatesdfTktime,
                                readUsingSharedPreference(
                                    this@NewMyMembershipDetailsActivity,
                                    "fullname"
                                ).toString(),
                                readUsingSharedPreference(
                                    this@NewMyMembershipDetailsActivity,
                                    "email"
                                ).toString()
                            )
                        } else {
                            displayToast(
                                this@NewMyMembershipDetailsActivity,
                                response.body()?.message.toString()
                            )
                        }
                    }
                }

                override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                    dismissLoader()
                    displayToast(
                        this@NewMyMembershipDetailsActivity,
                        resources.getString(R.string.error_something_wrong)
                    )
                }
            })
        }
    }

    override fun onClickPos(
        pos: Int,
        mdata: MutableList<Dataplan>,
        cost: String,
        membership_type: String
    ) {
        typePayme="Upgrade"
        posttion=pos
        mData = mdata
        if (!cost.equals("0")){
            startPayment(mdata.get(pos).membership_title,mdata.get(pos).membership_cost,readUsingSharedPreference(this, "email").toString(),readUsingSharedPreference(this, "mobile").toString())
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
            Toast.makeText(activity,"Error in payment: "+ e.message,Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    private fun app_check_permissions(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_home_screen_permission(readUsingSharedPreference(this, "userid").toString())
        //showLoader(this);
        call.enqueue(object : Callback<PermissionsResponse> {
            override fun onResponse(
                call: Call<PermissionsResponse>,
                response: Response<PermissionsResponse>
            ) {

                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.permissions?.size!=0){
                            for (i in 0 until response.body()?.data?.permissions?.size!!) {

                                storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"ViewPermissionMsg",response.body()?.data?.view_permission_msg)
                                storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"CreatePermissionMsg",response.body()?.data?.create_permission_msg)
                                storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"ViewExhaustedMsg",response.body()?.data?.view_exhausted_msg)
                                storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"CreateExhaustedMsg",response.body()?.data?.create_exhausted_msg)
                                if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("1")){
                                    storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"PermissionCreatePost",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("2")){
                                    storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"PermissionCreateRequirement",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("3")){
                                    storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"PermissionCreateBuddyMeet",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("4")){
                                    storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"PermissionCreateFollowUp",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("5")){
                                    storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"PermissionCreateAddGalleryImage",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("6")){
                                    storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"PermissionConnectionRequest",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("7")){
                                    storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"PermissionCreateRecommendation",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("8")){
                                    storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"PermissionReview",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("9")){
                                    storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"PermissionViewJ4EmemberProfile",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("10")){
                                    storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"PermissionViewLeads",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("11")){
                                    storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"PermissionCreateReferral",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }
                            }
                        }else{
                            storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"PermissionCreatePost","0")
                            storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"PermissionCreateRequirement","0")
                            storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"PermissionCreateBuddyMeet","0")
                            storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"PermissionCreateFollowUp","0")
                            storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"PermissionCreateAddGalleryImage","0")
                            storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"PermissionConnectionRequest","0")
                            storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"PermissionCreateRecommendation","0")
                            storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"PermissionReview","0")
                            storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"PermissionViewJ4EmemberProfile","0")
                            storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"PermissionViewLeads","0")
                            storeUsingSharedPreference(this@NewMyMembershipDetailsActivity,"PermissionCreateReferral","0")
                        }
                    } else {

                    }
                }
            }

            override fun onFailure(call: Call<PermissionsResponse>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    override fun onResume() {
        super.onResume()
        getAllPlans()
    }
}