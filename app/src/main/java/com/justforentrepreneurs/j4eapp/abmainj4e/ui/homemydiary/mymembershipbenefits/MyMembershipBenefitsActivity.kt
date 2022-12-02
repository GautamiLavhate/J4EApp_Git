package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.*
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.*
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.interfacess.OnClickPosPlan
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.FunctionalData
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class MyMembershipBenefitsActivity : BaseActivity(),OnClickPosPlan , PaymentResultListener {
    private lateinit var binding: ActivityMyMembershipBenefitsBinding
    private var CurrtMemberShip:String=""
    private var CurrtMemberShipCost:String=""
    var Membership_seq_no:String=""

    var memberid:String=""
    var membercost:String=""
    var memberstart:String=""
    var membertitle:String=""

    var memberidd:String=""

    var typePayme:String=""
    var membershiprenewed:String=""

    var posttion:Int = 0
    lateinit var dialogbm: BottomSheetDialog
    lateinit var dialogrenew: BottomSheetDialog
    private lateinit var mData: MutableList<Dataplan>




    override fun enablePresence(): Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_membership_benefits)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.j4e_membership_card)
        binding.toolbar.tvEdit.setOnClickListener {
            startActivity(Intent(this, MembershipAddActivity::class.java))
        }
        binding.toolbar.ivBack.setOnClickListener {
            onBackPressed()
        }

        Checkout.preload(applicationContext)


        if(!(readUsingSharedPreference(this, "fullname")?.equals("0")!! && readUsingSharedPreference(this, "fullname")?.isEmpty()!!)){
            binding.fullnametv.setText(wordFirstCap(readUsingSharedPreference(this, "fullname").toString()))
        }else{
            binding.fullnametv.visibility= View.GONE
        }

        if(!(readUsingSharedPreference(this, "dob")?.equals("0")!! || readUsingSharedPreference(this, "dob")?.isEmpty()!!)){
            binding.dob.setText(readUsingSharedPreference(this, "dob").toString())
        }else{
            binding.dob.visibility= View.GONE
        }

        if(!(readUsingSharedPreference(this, "designation")?.equals("0")!! && readUsingSharedPreference(this, "designation")?.isEmpty()!!)){
            binding.designation.setText(readUsingSharedPreference(this, "designation").toString())
        }else{
            binding.designation.visibility= View.GONE
        }

        if(!(readUsingSharedPreference(this, "mobile")?.equals("0")!! && readUsingSharedPreference(this, "mobile")?.isEmpty()!!)){
            binding.mobilenumber.setText(readUsingSharedPreference(this, "mobile").toString())
        }else{
            binding.mobilenumber.visibility= View.GONE
        }

        Glide.with(this)
                .load(readUsingSharedPreference(this, "profilepic").toString())
                .fitCenter()
                .placeholder(R.drawable.ic_default_user_svg)
                .into(binding.ivProduct)

        if(isInternetAvailable(this)) {
            getapp_user_membership_details();
        }


        binding.Upgrade.setOnClickListener {

            val intent = Intent(this, NewMyMembershipDetailsActivity::class.java)
            intent.putExtra("CurrtMemberShip",CurrtMemberShip)
            intent.putExtra("CurrtMemberShipCost",CurrtMemberShipCost)
            intent.putExtra("Membership_seq_no",Membership_seq_no)
            intent.putExtra("memberid",memberid)
            intent.putExtra("membercost",membercost)
            intent.putExtra("memberstart",memberstart)
            startActivity(intent)

//            val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
//            val mBSRewardListBinding: LayMymebershipupgradebottomshitBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.lay_mymebershipupgradebottomshit, null, false)
//            dialog.setCancelable(false)
//            dialog.setCanceledOnTouchOutside(false)
//            dialog.setContentView(mBSRewardListBinding.root)
//            val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
//            mBSRewardListBinding.linearlayout1.startAnimation(anim)
//            val layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
//            mBSRewardListBinding.recyclerUpgradePlan.layoutManager = layoutManager
//            getAllPlans(mBSRewardListBinding,dialog)
//            mBSRewardListBinding.ivcancle.setOnClickListener {
//                dialog.dismiss()
//            }
//            dialog.show()
        }

        binding.Renew.setOnClickListener {
            val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
            val mBSRewardListBinding: RenewBottomsheetBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.renew_bottomsheet, null, false)
            dialog.setCancelable(false)
            dialog.setCanceledOnTouchOutside(false)
            dialog.setContentView(mBSRewardListBinding.root)
            dialogrenew = dialog
            app_get_current_membership(mBSRewardListBinding)

            mBSRewardListBinding.ivcancle.setOnClickListener {
                dialog.dismiss()
            }

            dialog.show()
        }

        binding.imgCopy.setOnClickListener {
            copyToClipboard(binding.txtReferralCode.text.toString())
            Toast.makeText(this,"Text copied to clipboard!",Toast.LENGTH_SHORT).show()
        }


    }

    private fun ThanksBm(cost:String,curetdate:String,time:String,name:String,email:String){
        val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
        val mBSRewardListBinding: ThankYouBottomSheetBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.thank_you_bottom_sheet, null, false)
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
            getapp_user_membership_details();
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun FaieldBm(){
        val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
        val mBSRewardListBinding: PaymentFaildBottomsheetBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.payment_faild_bottomsheet, null, false)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(mBSRewardListBinding.root)

        mBSRewardListBinding.ivcancle.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun getapp_user_membership_details() {
        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)

        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.getapp_user_membership_details(readUsingSharedPreference(this, "userid").toString())

        call.enqueue(object : Callback<MembershipDetails> {
            override fun onResponse(
                    call: Call<MembershipDetails>,
                    response: Response<MembershipDetails>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            binding.linearlayout1.visibility= View.GONE
                            binding.linearlayout.visibility= View.VISIBLE

                            binding.benefitstv.setText(Html.fromHtml(response.body()?.data?.membership_benifits.toString()))
                            if(response.body()?.data?.membership_cost.toString().equals( "-")){
                                binding.caostmb.setText("₹" + " " + response.body()?.data?.membership_cost.toString())
                            }else  if(response.body()?.data?.membership_cost.toString().equals( "0")){
                                binding.caostmb.setText("₹" + " " + "0.00")
                            }else {
                                if (response.body()?.data?.membership_cost.toString() != null){
                                    binding.caostmb.setText("₹" + " " + fmt(response.body()?.data?.membership_cost.toString()))
                                }

                            }
                            binding.baseicmember.setText(response.body()?.data?.membership_title.toString())
                            binding.Membershiptitle.setText(response.body()?.data?.membership_title.toString())
                            binding.Validdate.setText(response.body()?.data?.membership_end_date.toString())
                            CurrtMemberShip=response.body()?.data?.membership_id.toString()
                            CurrtMemberShipCost=response.body()?.data?.membership_cost.toString()
                            Membership_seq_no=response.body()?.data?.membership_seq_no.toString()
                            binding.txtReferralCode.setText(response.body()?.data?.referral_code.toString())




                            if(response.body()?.data?.membership_type.toString().equals("1")){
                                binding.Renew.visibility=View.GONE

                            }else{
                                binding.Renew.visibility=View.VISIBLE
                            }


                            val layoutManager = LinearLayoutManager(
                                this@MyMembershipBenefitsActivity,
                                RecyclerView.VERTICAL,
                                false
                            )
                            binding.recyclerFeatues.layoutManager = layoutManager


                            val mAdapter = FeaturesMembersAdapter(
                                this@MyMembershipBenefitsActivity as FragmentActivity?,
                                response.body()?.data?.membership_features as MutableList<MembershipFeatureslist>
                            )
                            binding.recyclerFeatues.adapter = mAdapter


                            if(response.body()?.data?.membership_id=="0"){
                                binding.Upgrade.setText("Subscribe")
                            }else{
                                binding.Upgrade.setText("Upgrade")
                            }

                            storeUsingSharedPreference(
                                this@MyMembershipBenefitsActivity,
                                "membertyype",
                                response.body()?.data?.membership_type.toString()
                            )

                        }
                    }else{
                        binding.linearlayout1.visibility= View.GONE
                        binding.linearlayout.visibility= View.VISIBLE
                        displayToast(this@MyMembershipBenefitsActivity,response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<MembershipDetails>, t: Throwable) {
                dismissLoader();
            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
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
                            val mAdapter = UpgradeAdapter(this@MyMembershipBenefitsActivity,
                                response.body()?.data as MutableList<Dataplan>,
                                this@MyMembershipBenefitsActivity,
                                dialog,CurrtMemberShip,CurrtMemberShipCost,Membership_seq_no)
                            mBSRewardListBinding.recyclerUpgradePlan.adapter = mAdapter

                        }else{
                            mBSRewardListBinding.linearlayout1.visibility=View.GONE
                            mBSRewardListBinding.recyclerUpgradePlan.visibility=View.VISIBLE
                            displayToast(this@MyMembershipBenefitsActivity,response.body()?.message.toString())
                        }
                    }else{
                        mBSRewardListBinding.linearlayout1.visibility=View.GONE
                        mBSRewardListBinding.recyclerUpgradePlan.visibility=View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<AllPlan>, t: Throwable) {
                dismissLoader();

            }
        })

    }

    override fun onClickPos(pos: Int, mdata: MutableList<Dataplan>,dialog: BottomSheetDialog) {
        typePayme="Upgrade"
        posttion=pos
        dialogbm=dialog
        mData = mdata

        startPayment(mdata.get(pos).membership_title,mdata.get(pos).membership_cost,readUsingSharedPreference(this, "email").toString(),readUsingSharedPreference(this, "mobile").toString())

    }


    private fun app_get_current_membership(mBSRewardListBinding: RenewBottomsheetBinding) {
        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        mBSRewardListBinding.linearlayout1.startAnimation(anim)
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_current_membership(readUsingSharedPreference(this, "userid").toString())
        call.enqueue(object : Callback<MembershipDetails> {
            override fun onResponse(
                call: Call<MembershipDetails>,
                response: Response<MembershipDetails>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {

                            mBSRewardListBinding.linearlayout.visibility=View.VISIBLE
                            mBSRewardListBinding.linearlayout1.visibility=View.GONE
                            mBSRewardListBinding.totalcharge.text="₹"+" "+ fmt(response.body()?.data?.membership_cost.toString())
                            mBSRewardListBinding.basicmembership.text=response.body()?.data?.membership_title.toString()
                            mBSRewardListBinding.datefinal.text=response.body()?.data?.membership_start_date.toString()+" To "+response.body()?.data?.membership_end_date.toString()
                            mBSRewardListBinding.Payment.text="₹"+" "+ fmt(response.body()?.data?.membership_cost.toString())

                            memberid=response.body()?.data?.membership_id.toString()

                            membershiprenewed=response.body()?.data?.membership_renewed.toString()

                            if(membershiprenewed.equals("Yes")) {
                                mBSRewardListBinding.Renew.setBackgroundResource(R.drawable.bg_disableupgrade)

                            }else{
                                mBSRewardListBinding.Renew.setBackgroundResource(R.drawable.btd_active)
                                mBSRewardListBinding.Renew.setOnClickListener {
                                    typePayme = "Renew"
                                    startPayment(
                                        membertitle,
                                        membercost,
                                        readUsingSharedPreference(this@MyMembershipBenefitsActivity, "email").toString(),
                                        readUsingSharedPreference(this@MyMembershipBenefitsActivity, "mobile").toString()
                                    )
                                }
                            }

                            storeUsingSharedPreference(
                                this@MyMembershipBenefitsActivity,
                                "membertyype",
                                response.body()?.data?.membership_type.toString()
                            )


                            membertitle=response.body()?.data?.membership_title.toString()

                            membercost=response.body()?.data?.membership_cost.toString()

                            memberstart= getNextDate(response.body()?.data?.membership_end_date.toString())!!

                        }
                    }else{
                        mBSRewardListBinding.linearlayout.visibility=View.VISIBLE
                        mBSRewardListBinding.linearlayout1.visibility=View.GONE
                        displayToast(this@MyMembershipBenefitsActivity,response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<MembershipDetails>, t: Throwable) {
                dismissLoader();
            }
        })
    }

    fun getNextDate(curDate: String?): String? {
        val format = SimpleDateFormat("yyyy-MM-dd")
        val date = format.parse(curDate)
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.DAY_OF_YEAR, 1)
        return format.format(calendar.time)
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
        if(typePayme.equals("Upgrade")) {
            startApiTan(posttion, mData, dialogbm, p0.toString())
        }else if(typePayme.equals("Renew")) {
            startApiRenew(dialogrenew,p0.toString())
        }
        Toast.makeText(this, "Payment is successful", Toast.LENGTH_SHORT).show()
    }

    override fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(this, " Payment Cancel ",Toast.LENGTH_SHORT).show();
    }

    private fun startApiTan(pos: Int, mdata: MutableList<Dataplan>,dialog: BottomSheetDialog,p1: String){
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
                            dialog.dismiss()
                            displayToast(this@MyMembershipBenefitsActivity, response.body()?.message.toString())
                            ThanksBm(mdata.get(pos).membership_cost,currentDatesdfTk,currentDatesdfTktime,readUsingSharedPreference(this@MyMembershipBenefitsActivity, "fullname").toString(),readUsingSharedPreference(this@MyMembershipBenefitsActivity, "email").toString())
                        } else {
                            displayToast(this@MyMembershipBenefitsActivity, response.body()?.message.toString())
                        }
                    }
                }

                override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                    dismissLoader()
                    displayToast(this@MyMembershipBenefitsActivity, resources.getString(R.string.error_something_wrong))
                }
            })
        }
    }

    private fun startApiRenew(dialog: BottomSheetDialog,p1: String) {
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
                            dialog.dismiss()
                            displayToast(
                                this@MyMembershipBenefitsActivity,
                                response.body()?.message.toString()
                            )
                            ThanksBm(
                                membercost,
                                currentDatesdfTk,
                                currentDatesdfTktime,
                                readUsingSharedPreference(
                                    this@MyMembershipBenefitsActivity,
                                    "fullname"
                                ).toString(),
                                readUsingSharedPreference(
                                    this@MyMembershipBenefitsActivity,
                                    "email"
                                ).toString()
                            )
                        } else {
                            displayToast(
                                this@MyMembershipBenefitsActivity,
                                response.body()?.message.toString()
                            )
                        }
                    }
                }

                override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                    dismissLoader()
                    displayToast(
                        this@MyMembershipBenefitsActivity,
                        resources.getString(R.string.error_something_wrong)
                    )
                }
            })
        }
    }

    fun Context.copyToClipboard(text: CharSequence){
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("label",text)
        clipboard.setPrimaryClip(clip)
    }


}