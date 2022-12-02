package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads

import ak.sh.ay.musicwave.BuildConfig
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyLeadsDetailBinding
import com.justforentrepreneurs.j4eapp.databinding.BsRecommendPersonListBinding
import com.justforentrepreneurs.j4eapp.databinding.RecommdationNoteBmBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.Adapter.AdapterRecommendPersonOthers
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.Adapter.AdapterRecommendPersonlLeadDetails
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model.*
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.Adapter.AdapterReffStatusDetailsList
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrefrral.givan.ReferralGivenActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrefrral.receive.ReferralReceivedActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.GallerViewActivityZoom
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
//import com.justforentrepreneurs.j4eapp.model.realms.User
//import com.justforentrepreneurs.j4eapp.utils.ContactUtils
//import com.justforentrepreneurs.j4eapp.utils.IntentUtils
//import com.justforentrepreneurs.j4eapp.utils.RealmHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class MyLeadsDetailActivity : BaseActivity(),AdapterRecommendPersonlLeadDetails.OnClick2,AdapterRecommendPersonOthers.OnClick2 {
    private lateinit var binding: ActivityMyLeadsDetailBinding
    lateinit var requireid:String
    lateinit var requireUserid:String
    lateinit var OwnRe:String
    lateinit var type:String
    lateinit var position:String
    lateinit var complete:String
    var message:String=""
    var is_recommendation_exhausted:Int = -1
    var count_available:Int = -1
    lateinit var referral_type:String
    override fun enablePresence(): Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_leads_detail)
        binding.lifecycleOwner = this


        binding.toolbar.ivBack.setOnClickListener {
            onBackPressed()
        }

        binding.toolbar.ivShare.setOnClickListener {
            try {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "J4E")
                var shareMessage = "\nLet me recommend you this application\n\n"
                var profileid = "=abc"
                shareMessage =
                    """
                        ${shareMessage}https://play.google.com/store/apps/details?id=${com.justforentrepreneurs.j4eapp.BuildConfig.APPLICATION_ID}
                   
                        
                        """.trimIndent()
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                startActivity(Intent.createChooser(shareIntent, "choose one"))
            } catch (e: Exception) {
                //e.toString();
            }
        }

        position=intent.getStringExtra("position").toString()


        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.leaddeatis1.startAnimation(anim)

        if (intent.getStringExtra("type") == "requirement") {
            type=intent.getStringExtra("type").toString()
            requireid=intent.getStringExtra("id").toString()
            OwnRe=""
            binding.toolbar.tvTitle.text = resources.getText(R.string.my_requirement)
            binding.toolbar.ivLeadStatus.visibility = View.GONE
            binding.tvRecommendedMySelf.visibility = View.GONE
            binding.leadPostBy.visibility = View.GONE

            if(isInternetAvailable(this)) {

                RequirementDetails(requireid,"1")
            }
        } else  if (intent.getStringExtra("type") == "MyLead") {
            type=intent.getStringExtra("type").toString()
            requireid=intent.getStringExtra("id").toString()
            requireUserid=intent.getStringExtra("requireUserid").toString()
            OwnRe=intent.getStringExtra("own").toString()
            complete=intent.getStringExtra("complete").toString()
            binding.toolbar.tvTitle.text = resources.getText(R.string.lead_details)
            binding.llRecommendedSection.visibility = View.VISIBLE
            binding.leadPostBy.visibility = View.VISIBLE
            binding.toolbar.ivLeadStatus.visibility = View.GONE


            if(isInternetAvailable(this)) {
                RequirementDetails(requireid,"0")
            }
        } else if (intent.getStringExtra("type") == "referral"){
            type=intent.getStringExtra("type").toString()
            requireid=intent.getStringExtra("id").toString()
            referral_type=intent.getStringExtra("referral_type").toString()
            OwnRe=intent.getStringExtra("own").toString()
            if (referral_type.equals("given")){
                binding.toolbar.ivLeadStatus.visibility = View.GONE
            }else{
                binding.toolbar.ivLeadStatus.visibility = View.VISIBLE
            }
            binding.toolbar.tvTitle.text = resources.getText(R.string.referral_details)

            if (isInternetAvailable(this)){
                getReferralDetails(requireid)
            }
        }else{
            type=intent.getStringExtra("type").toString()
            requireid=intent.getStringExtra("id").toString()
            requireUserid=intent.getStringExtra("requireUserid").toString()
            OwnRe=intent.getStringExtra("own").toString()
            binding.toolbar.tvTitle.text = resources.getText(R.string.lead_details)
            binding.llRecommendedSection.visibility = View.VISIBLE
            binding.leadPostBy.visibility = View.VISIBLE
            binding.toolbar.ivLeadStatus.visibility = View.GONE

            if(isInternetAvailable(this)) {
                RequirementDetails(requireid,"0")
            }
        }

        onCLickListener()

        recyclerviewRecommendPerson()
    }

    private fun onCLickListener() {
        binding.toolbar.ivLeadStatus.setOnClickListener {
            val intent = Intent(this, MyLeadsStatusListActivity::class.java)
            intent.putExtra("id",requireid)
            intent.putExtra("reconmmend_user",requireUserid)
            intent.putExtra("type","kk")
            intent.putExtra("own",OwnRe)
            intent.putExtra("isFrom","toolbar")
            startActivity(intent)
        }

        binding.tvRecommended.setOnClickListener {
            if(is_recommendation_exhausted==0){
                val intent = Intent(this, RecommendedLeadActivity::class.java)
                intent.putExtra("type", type)
                intent.putExtra("id", requireid)
                startActivityForResult(intent,1001)
            }else{
                PermissionDialog(readUsingSharedPreference(this,"CreatePermissionMsg").toString())
            }

        }

        binding.tvRecommendedMySelf.setOnClickListener {
            if (readUsingSharedPreference(this,"PermissionCreateRecommendation").equals("0")){
                PermissionDialog(readUsingSharedPreference(this,"CreatePermissionMsg").toString())
            }else{
                if (is_recommendation_exhausted==0){
                    bottomSheetRecommendationNote()
                }else{
                    PermissionDialog(readUsingSharedPreference(this,"CreatePermissionMsg").toString())
                }

            }

        }

    }


    private fun bottomSheetRecommendationNote() {
        // val dialog = BottomSheetDialog(this, R.style.CustomBottomSheet)
        val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
        val mBsRecommendPersonListBinding: RecommdationNoteBmBinding =
                DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.recommdation_note_bm, null, false)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(mBsRecommendPersonListBinding.root)
        mBsRecommendPersonListBinding.cancle.setOnClickListener {
            dialog.dismiss()
        }
        mBsRecommendPersonListBinding.Confirm.setOnClickListener {
            if(MyRecomvalidation(mBsRecommendPersonListBinding)) {
                MyLeadsRecomand(mBsRecommendPersonListBinding,dialog)
            }
        }
        dialog.show()
    }

    private fun recyclerviewRecommendPerson(){
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recommendedPersonlist.layoutManager = layoutManager

    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (intent.getStringExtra("type") == "requirement") {
            val returnIntent = Intent()
            returnIntent.putExtra("result", "123")
            setResult(RESULT_OK, returnIntent)
            finish()
        }else if(intent.getStringExtra("type") == "MyLead"){
            if(intent.getStringExtra("noti").toString().equals("notification")){
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("type", "notification")
                startActivity(intent)
            }else if(intent.getStringExtra("noti").toString().equals("serach")){

            }else {
                val returnIntent = Intent()
                returnIntent.putExtra("result", "123")
                setResult(RESULT_OK, returnIntent)
                finish()
            }
        }else if(intent.getStringExtra("back_type") == "ref_given"){
            val intent = Intent(this, ReferralGivenActivity::class.java)
            startActivity(intent)
        }else if(intent.getStringExtra("back_type") == "ref_received"){
            val intent = Intent(this, ReferralReceivedActivity::class.java)
            startActivity(intent)
        }else{
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("hometype", "1")
                intent.putExtra("position", position)
                intent.putExtra("type", "hometype")
                startActivity(intent)

        }
    }

    private fun MyLeadsRecomand(mBsRecommendPersonListBinding: RecommdationNoteBmBinding,dialog:BottomSheetDialog){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val sdf = SimpleDateFormat("dd MMM yyyy")
        val currentDate = sdf.format(Date())


        val sdf1 = SimpleDateFormat("hh:mm a")
        val currentDate1 = sdf1.format(Date())
//        displayToast(this,readUsingSharedPreference(this@MyLeadsDetailActivity, "userid").toString()
//                +","+requireid+","+
//                mBsRecommendPersonListBinding.edtFeedback.text.toString()+","+currentDate+","+currentDate1)
        val call = request.app_recommend_myself(readUsingSharedPreference(this@MyLeadsDetailActivity, "userid").toString(),requireid,mBsRecommendPersonListBinding.edtFeedback.text.toString(),currentDate,currentDate1)

        showLoader(this@MyLeadsDetailActivity);
        call.enqueue(object : Callback<AppRecommendMyself> {
            override fun onResponse(
                    call: Call<AppRecommendMyself>,
                    response: Response<AppRecommendMyself>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        getRecommlist(requireid,"0")
                        dialog.dismiss()
                        displayToast(this@MyLeadsDetailActivity,response.body()?.message.toString())
                    }else{
                        dialog.dismiss()
                        displayToast(this@MyLeadsDetailActivity,response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<AppRecommendMyself>, t: Throwable) {
                dismissLoader();
                displayToast(this@MyLeadsDetailActivity,this@MyLeadsDetailActivity.resources.getString(R.string.error_something_wrong))
            }
        })
    }

    fun MyRecomvalidation(mBsRecommendPersonListBinding: RecommdationNoteBmBinding) : Boolean {

        var Temp: Boolean? = true
        if (mBsRecommendPersonListBinding.edtFeedback.text.toString().length == 0) {
            mBsRecommendPersonListBinding.edtFeedback.setError("Field is empty")
            Temp = false
        } else {
            mBsRecommendPersonListBinding.edtFeedback.setError(null)
        }

        return Temp!!
    }

    //

    private fun RequirementDetails(requireid:String,leadreqheck:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_requirement_details(requireid, readUsingSharedPreference(this,"userid").toString())
       // showLoader(this@MyLeadsDetailActivity);

        call.enqueue(object : Callback<Requirementdetails> {
            override fun onResponse(
                    call: Call<Requirementdetails>,
                    response: Response<Requirementdetails>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    message=response.body()?.message.toString()
                    if (response.body()?.status == true) {
                        if (response.body()?.user_data?.requirement_info != null) {
                            binding.leaddeatis1.visibility=View.GONE
                            binding.leaddeatis.visibility=View.VISIBLE

                            is_recommendation_exhausted= response.body()?.user_data?.is_recommendation_exhausted!!
                            requireUserid=response.body()?.user_data?.requirement_info?.get(0)!!.userid

                            if(!(response.body()?.user_data?.requirement_info?.get(0)!!.requirement_title=="" || response.body()?.user_data?.requirement_info?.get(0)!!.requirement_title==null)) {
                                binding.title.setText(response.body()?.user_data?.requirement_info?.get(0)!!.requirement_title.capitalize())
                            }else{
                                binding.title.setText("")
                            }

                            if(!(response.body()?.user_data?.requirement_info?.get(0)!!.company_name=="" || response.body()?.user_data?.requirement_info?.get(0)!!.company_name==null)) {
                                binding.companyName.setText(response.body()?.user_data?.requirement_info?.get(0)!!.company_name.capitalize())
                                binding.companyName.visibility = View.VISIBLE
                            }else{
                                binding.companyName.visibility = View.GONE
                                binding.companyName.setText("")
                            }

                            if(!(response.body()?.user_data?.requirement_info?.get(0)!!.requirement_address=="" || response.body()?.user_data?.requirement_info?.get(0)!!.requirement_address==null)) {
                                binding.address.setText(response.body()?.user_data?.requirement_info?.get(0)!!.requirement_address.capitalize())
                            }else{
                                binding.address.setText("")
                            }
                            val Datesub: String = response.body()?.user_data?.requirement_info?.get(0)!!.created_date
                            try {
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
                                binding.date.setText(mainstr)
                            } catch (e: ParseException) {
                                e.printStackTrace()
                            }



                            if (response.body()?.user_data?.requirement_info?.get(0)!!.rerquirement_thumbnail.equals("")){
                                binding.imagereqiurment.visibility=View.GONE
                            }else{
                                binding.imagereqiurment.visibility=View.VISIBLE
                                Glide.with(this@MyLeadsDetailActivity)
                                    .load(response.body()?.user_data?.requirement_info?.get(0)!!.rerquirement_thumbnail)
                                    .into(binding.imagereqiurment)
                            }


                            binding.imagereqiurment.setOnClickListener {
                                val propertyDetailsIntent = Intent(this@MyLeadsDetailActivity, GallerViewActivityZoom::class.java)
                                propertyDetailsIntent.putExtra("Url",response.body()?.user_data?.requirement_info?.get(0)!!.rerquirement_thumbnail)
                                startActivity(propertyDetailsIntent)
                            }

                            if(!(response.body()?.user_data?.requirement_info?.get(0)!!.referal_given_by_full_name=="" || response.body()?.user_data?.requirement_info?.get(0)!!.referal_given_by_full_name==null)) {
                                binding.fullname.setText(response.body()?.user_data?.requirement_info?.get(0)!!.referal_given_by_full_name.capitalize())
                            }else{
                                binding.fullname.setText("")
                            }

                            if(!(response.body()?.user_data?.requirement_info?.get(0)!!.referal_given_by_functional_area=="" || response.body()?.user_data?.requirement_info?.get(0)!!.referal_given_by_functional_area==null)) {
                                binding.address1.setText(response.body()?.user_data?.requirement_info?.get(0)!!.referal_given_by_functional_area.capitalize())
                            }else{
                                binding.address1.setText("")
                            }

//                            if(!(response.body()?.user_data!!?.requirement_info?.get(0)!!.designation=="" || response.body()?.user_data?.requirement_info?.get(0)!!.designation==null)) {
//                                binding.address1.setText(response.body()?.user_data?.requirement_info?.get(0)!!.designation.capitalize())
//                            }else{
//                                binding.address1.setText("")
//                            }

                            if(!(response.body()?.user_data?.requirement_info?.get(0)!!.requirement_description=="" || response.body()?.user_data?.requirement_info?.get(0)!!.requirement_description==null)) {
                                binding.description.setText(response.body()?.user_data?.requirement_info?.get(0)!!.requirement_description.capitalize())
                            }else{
                                binding.description.setText("")
                            }


                            Glide.with(this@MyLeadsDetailActivity)
                                    .load(response.body()?.user_data?.requirement_info?.get(0)!!.referal_given_by_profile_pic)
                                    .centerCrop()
                                    .placeholder(R.drawable.ic_default_user_svg)
                                    .into(binding.ivProfileImg)

                            if(!readUsingSharedPreference(this@MyLeadsDetailActivity, "membertyype").toString().equals("1")  && !response.body()?.user_data?.requirement_info?.get(0)!!.membership_type.equals("1") &&
                                !response.body()?.user_data?.requirement_info?.get(0)!!.userid.equals(
                                        readUsingSharedPreference(
                                            this@MyLeadsDetailActivity,
                                            "userid"
                                        ).toString())) {
                                binding.msg.setBackgroundColor(Color.parseColor("#084268"))
                                binding.msg.setOnClickListener {
//                                        if (response.body()?.user_data?.requirement_info?.get(0)!!.chat_id.toString() != null  && !response.body()?.user_data?.requirement_info?.get(0)!!.chat_id.toString().equals("")) {
//
////                                            var user: User = RealmHelper.getInstance()
////                                                .getUser(response.body()?.user_data?.requirement_info?.get(0)!!.chat_id.toString())
////                                            val receiverUid: String = user.getUid()
//
////                                            if (receiverUid.equals(null) && receiverUid.equals("")) {
//////                                                if (isInternetAvailable(this@MyLeadsDetailActivity)) {
//////                                                    ContactUtils.fetchDataCheckexitnumber(
//////                                                        receiverUid
//////                                                    )
////////                                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://api.whatsapp.com/send?phone="+"+91"+binding.conwhatREq.text.toString() + "&text="+"Hello"))
////////                                                    startActivity(intent)
//////                                                    val intent = Intent(
//////                                                        this@MyLeadsDetailActivity,
//////                                                        com.justforentrepreneurs.j4eapp.activities.main.messaging.ChatActivity::class.java
//////                                                    )
//////                                                    intent.putExtra(
//////                                                        IntentUtils.UID,
//////                                                        response.body()?.user_data?.requirement_info?.get(0)!!.chat_id.toString()
//////                                                    )
//////                                                    intent.putExtra("Back", "j4e")
//////                                                    startActivity(intent);
//////
//////                                                }
////
////
////                                            } else {
////
//////                                                val intent = Intent(
//////                                                    this@MyLeadsDetailActivity,
//////                                                    com.justforentrepreneurs.j4eapp.activities.main.messaging.ChatActivity::class.java
//////                                                )
//////                                                intent.putExtra(
//////                                                    IntentUtils.UID,
//////                                                    response.body()?.user_data?.requirement_info?.get(0)!!.chat_id.toString()
//////                                                )
//////                                                intent.putExtra("Back", "j4e")
//////                                                startActivity(intent);
////                                            }
//                                        }else{
//                                            displayToast(this@MyLeadsDetailActivity,"Not able to chat")
//                                        }
//                                    if (response.body()?.user_data?.requirement_info?.get(0)!!.company_whatsapp_no != null && !response.body()?.user_data?.requirement_info?.get(0)!!.company_whatsapp_no.equals("") ){
//                                        val intent = Intent(Intent.ACTION_VIEW,
//                                            Uri.parse("http://api.whatsapp.com/send?phone="+"+91"+response.body()?.user_data?.requirement_info?.get(0)!!.company_whatsapp_no + "&text="+"Hello"))
//                                        startActivity(intent)
//                                    }else
                                    if (response.body()?.user_data?.requirement_info?.get(0)!!.whatsapp_no != null && !response.body()?.user_data?.requirement_info?.get(0)!!.whatsapp_no.equals("") ){
                                        val intent = Intent(Intent.ACTION_VIEW,
                                            Uri.parse("http://api.whatsapp.com/send?phone="+"+91"+response.body()?.user_data?.requirement_info?.get(0)!!.whatsapp_no + "&text="+"Hello"))
                                        startActivity(intent)
                                    }else{
                                        displayToast(this@MyLeadsDetailActivity,"Invalid Whatsapp number!")
                                    }
                                }
                            }else{
                                binding.msg.setBackgroundColor(Color.parseColor("#79A1B4"))
                            }


                            getRecommlist(requireid,leadreqheck)

                            binding.llProfileInfo.setOnClickListener {
                                val intent = Intent(this@MyLeadsDetailActivity, ProfileActivity::class.java)
                                intent.putExtra("id",response.body()?.user_data?.requirement_info?.get(0)!!.referal_given_by_id)
                                intent.putExtra("requirementid",requireid)
                                intent.putExtra("type","MyLead")
                                startActivity(intent)
                            }

                        }else{
                            displayToast(this@MyLeadsDetailActivity,response.body()?.message.toString())
                            binding.leaddeatis1.visibility=View.VISIBLE
                            binding.leaddeatis.visibility=View.GONE
                        }
                    }else{
                        binding.leaddeatis1.visibility=View.VISIBLE
                        binding.leaddeatis.visibility=View.GONE
                        PermissionBackDialog(message)

                    }
                }
            }

            override fun onFailure(call: Call<Requirementdetails>, t: Throwable) {
                dismissLoader();

            }
        })
    }

    private fun getReferralDetails(referral_id:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_requirement_details(requireid, readUsingSharedPreference(this,"userid").toString())
        // showLoader(this@MyLeadsDetailActivity);
        //displayToast(this,requireid+","+readUsingSharedPreference(this,"userid").toString())
        call.enqueue(object : Callback<Requirementdetails> {
            override fun onResponse(
                call: Call<Requirementdetails>,
                response: Response<Requirementdetails>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    message=response.body()?.message.toString()
                    if (response.body()?.status == true) {
                        if (response.body()?.user_data?.requirement_info != null) {
                            binding.leaddeatis1.visibility=View.GONE
                            binding.reffrerdetails.visibility=View.VISIBLE

                            is_recommendation_exhausted= response.body()?.user_data?.is_recommendation_exhausted!!
                            requireUserid=response.body()?.user_data?.requirement_info?.get(0)!!.userid
                            binding.satatus.text=response.body()?.user_data?.requirement_info?.get(0)!!.referral_type
                            binding.requirementtitle.text=response.body()?.user_data?.requirement_info?.get(0)!!.requirement_title
                            var time:String=response.body()?.user_data?.requirement_info?.get(0)!!.doe_time
                            val Datesub: String = response.body()?.user_data?.requirement_info?.get(0)!!.doe_date
                            try {
                                val sdf = SimpleDateFormat("HH:mm:ss")
                                val dateObj: Date = sdf.parse(time)
                                time = SimpleDateFormat("hh:mm aa").format(dateObj)

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
                                binding.reffraldate.text=mainstr+" "+"at"+" "+time
                            } catch (e: ParseException) {
                                e.printStackTrace()
                            }
                            //binding.reffraldate.text=response.body()?.user_data?.requirement_info?.get(0)!!.created_date+" "+"at"+" "+response.body()?.user_data?.requirement_info?.get(0)!!.created_time

                            binding.reffraldescription.text=response.body()?.user_data?.requirement_info?.get(0)!!.requirement_description
                            val layoutManager = LinearLayoutManager(this@MyLeadsDetailActivity, RecyclerView.VERTICAL, false)
                            binding.sattuslist.layoutManager = layoutManager
                            val mAdapter = AdapterReffStatusDetailsList(
                                this@MyLeadsDetailActivity,
                                response.body()?.user_data?.requirement_info?.get(0)!!.refferal_status  as MutableList<requirement_info.Refferalstatus>)
                            binding.sattuslist.adapter = mAdapter
                            binding.reffralfuctionarea.text=response.body()?.user_data?.requirement_info?.get(0)!!.requirement_functional_area
                            Glide.with(this@MyLeadsDetailActivity)
                                .load(response.body()?.user_data?.requirement_info?.get(0)!!.referal_given_by_profile_pic)
                                .centerCrop()
                                .placeholder(R.drawable.ic_default_user_svg)
                                .into(binding.ivProfileImgre)
                            binding.fullnamere.text=response.body()?.user_data?.requirement_info?.get(0)!!.referal_given_by_full_name
                            if (response.body()?.user_data?.requirement_info?.get(0)!!.referal_given_by_functional_area != null || response.body()?.user_data?.requirement_info?.get(0)!!.referal_given_by_functional_area.isNotEmpty()){
                                binding.funre.text=response.body()?.user_data?.requirement_info?.get(0)!!.referal_given_by_functional_area
                            }else{
                                binding.funre.text="N/A"
                            }

                            binding.llProfileInfore.setOnClickListener {
                                val intent = Intent(this@MyLeadsDetailActivity, ProfileActivity::class.java)
                                intent.putExtra("id", response.body()?.user_data?.requirement_info?.get(0)!!.referal_given_by_id)
                                intent.putExtra("requirementid", requireid)
                                intent.putExtra("type", "MyLead")
                                startActivity(intent)
                            }
                            if (binding.satatus.text.equals("My Self")){
                                binding.referralReceivedBy.visibility=View.GONE
                                binding.insidecontact.visibility=View.GONE
                                binding.referralTypeOutside.visibility=View.GONE

                            }else if (binding.satatus.text.equals("Inside")){
                                binding.referralReceivedBy.visibility=View.VISIBLE
                                binding.insidecontact.visibility=View.VISIBLE
                                binding.referralTypeOutside.visibility=View.GONE
                                Glide.with(this@MyLeadsDetailActivity)
                                    .load(response.body()?.user_data?.requirement_info?.get(0)!!.referal_received_by_profile_pic)
                                    .centerCrop()
                                    .placeholder(R.drawable.ic_default_user_svg)
                                    .into(binding.ivProfileImgReceivedBy)
                                binding.fullnameReceivedBy.text=response.body()?.user_data?.requirement_info?.get(0)!!.referal_received_by_full_name
                                if (response.body()?.user_data?.requirement_info?.get(0)!!.referal_received_by_functional_area != null || response.body()?.user_data?.requirement_info?.get(0)!!.referal_received_by_functional_area.isNotEmpty()){
                                    binding.funReceivedBy.text=response.body()?.user_data?.requirement_info?.get(0)!!.referal_received_by_functional_area
                                }else{
                                    binding.funReceivedBy.text="N/A"
                                }

                                binding.llProfileInfoReceivedBy.setOnClickListener {
                                    val intent = Intent(this@MyLeadsDetailActivity, ProfileActivity::class.java)
                                    intent.putExtra("id", response.body()?.user_data?.requirement_info?.get(0)!!.referal_received_by_id)
                                    intent.putExtra("requirementid", requireid)
                                    intent.putExtra("type", "MyLead")
                                    startActivity(intent)
                                }

                                Glide.with(this@MyLeadsDetailActivity)
                                    .load(response.body()?.user_data?.requirement_info?.get(0)!!.contact_person_pic)
                                    .centerCrop()
                                    .placeholder(R.drawable.ic_default_user_svg)
                                    .into(binding.conProfileImg)

                                binding.confullname.text=response.body()?.user_data?.requirement_info?.get(0)!!.contact_person_name
                                if (response.body()?.user_data?.requirement_info?.get(0)!!.contact_person_functional_area != null || response.body()?.user_data?.requirement_info?.get(0)!!.contact_person_functional_area.isNotEmpty()){
                                    binding.confunarea.text=response.body()?.user_data?.requirement_info?.get(0)!!.contact_person_functional_area
                                }else{
                                    binding.confunarea.text="N/A"
                                }

                                binding.conProfileInfo.setOnClickListener {
                                    val intent = Intent(this@MyLeadsDetailActivity, ProfileActivity::class.java)
                                    intent.putExtra("id", response.body()?.user_data?.requirement_info?.get(0)!!.contact_person_id)
                                    intent.putExtra("requirementid", requireid)
                                    intent.putExtra("type", "MyLead")
                                    startActivity(intent)
                                }
                            }else if (binding.satatus.text.equals("Outside")){
                                binding.referralReceivedBy.visibility=View.VISIBLE
                                binding.insidecontact.visibility=View.GONE
                                binding.referralTypeOutside.visibility=View.VISIBLE
                                Glide.with(this@MyLeadsDetailActivity)
                                    .load(response.body()?.user_data?.requirement_info?.get(0)!!.referal_received_by_profile_pic)
                                    .centerCrop()
                                    .placeholder(R.drawable.ic_default_user_svg)
                                    .into(binding.ivProfileImgReceivedBy)
                                binding.fullnameReceivedBy.text=response.body()?.user_data?.requirement_info?.get(0)!!.referal_received_by_full_name
                                if (response.body()?.user_data?.requirement_info?.get(0)!!.referal_received_by_functional_area != null || response.body()?.user_data?.requirement_info?.get(0)!!.referal_received_by_functional_area.isNotEmpty()){
                                    binding.funReceivedBy.text=response.body()?.user_data?.requirement_info?.get(0)!!.referal_received_by_functional_area
                                }else{
                                    binding.funReceivedBy.text="N/A"
                                }

                                binding.llProfileInfoReceivedBy.setOnClickListener {
                                    val intent = Intent(this@MyLeadsDetailActivity, ProfileActivity::class.java)
                                    intent.putExtra("id", response.body()?.user_data?.requirement_info?.get(0)!!.referal_received_by_id)
                                    intent.putExtra("requirementid", requireid)
                                    intent.putExtra("type", "MyLead")
                                    startActivity(intent)
                                }

                                binding.contactname.text=response.body()?.user_data?.requirement_info?.get(0)!!.contact_person_name
                                if (response.body()?.user_data?.requirement_info?.get(0)!!.designations !=null){
                                    if (response.body()?.user_data?.requirement_info?.get(0)!!.designations.equals("")){
                                        binding.condignation.text="N/A"
                                    }else{
                                        binding.condignation.text=response.body()?.user_data?.requirement_info?.get(0)!!.designations
                                    }

                                }else{
                                    binding.condignation.text="N/A"
                                }

                                if (response.body()?.user_data?.requirement_info?.get(0)!!.mobilenumber !=null){
                                    if (response.body()?.user_data?.requirement_info?.get(0)!!.mobilenumber.equals("")){
                                        binding.mobilenumber.text="N/A"
                                    }else {
                                        binding.mobilenumber.text =
                                            response.body()?.user_data?.requirement_info?.get(0)!!.mobilenumber
                                        binding.mobilenumber.setOnClickListener {
                                            val intent = Intent(
                                                Intent.ACTION_DIAL,
                                                Uri.parse("tel:" + binding.mobilenumber.text.toString())
                                            )
                                            startActivity(intent)
                                        }
                                    }
                                }else {
                                    binding.mobilenumber.text="N/A"
                                }

                                if (response.body()?.user_data?.requirement_info?.get(0)!!.telphno !=null){
                                    if (response.body()?.user_data?.requirement_info?.get(0)!!.telphno.equals("")){
                                        binding.telphno.text="N/A"
                                    }else{
                                        binding.telphno.text=response.body()?.user_data?.requirement_info?.get(0)!!.telphno
                                        if (binding.telphno.length()>5){
                                            binding.telphno.setOnClickListener {
                                                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + binding.telphno.text.toString()))
                                                startActivity(intent)
                                            }
                                        }
                                    }

                                } else{
                                    binding.telphno.text="N/A"

                                }

                                if (response.body()?.user_data?.requirement_info?.get(0)!!.emailaddrss !=null){
                                    if (response.body()?.user_data?.requirement_info?.get(0)!!.emailaddrss.equals("")){
                                        binding.emailadd.text="N/A"
                                    }else{
                                        binding.emailadd.text=response.body()?.user_data?.requirement_info?.get(0)!!.emailaddrss
                                        binding.emailadd.setOnClickListener {
                                            var email : String = binding.emailadd.text.toString()
                                            val intent = Intent(Intent.ACTION_SEND)
                                            val recipients = arrayOf(email)
                                            intent.putExtra(Intent.EXTRA_EMAIL, recipients)
                                            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject text here...")
                                            intent.putExtra(Intent.EXTRA_TEXT, "Body of the content here...")
                                            intent.putExtra(Intent.EXTRA_CC, "mailcc@gmail.com")
                                            intent.type = "text/html"
                                            intent.setPackage("com.google.android.gm")
                                            startActivity(Intent.createChooser(intent, "Send mail"))
                                        }
                                    }

                                } else{
                                    binding.emailadd.text="N/A"

                                }


                            }



                        }else{
                            displayToast(this@MyLeadsDetailActivity,response.body()?.message.toString())
                            binding.leaddeatis1.visibility=View.VISIBLE
                            binding.reffrerdetails.visibility=View.GONE
                        }
                    }else{
                        binding.leaddeatis1.visibility=View.VISIBLE
                        binding.reffrerdetails.visibility=View.GONE
                        PermissionBackDialog(message)

                    }
                }
            }

            override fun onFailure(call: Call<Requirementdetails>, t: Throwable) {
                dismissLoader();

            }
        })
    }

    private fun getRecommlist(requireid:String,leadreqheck:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_recommendation_list(readUsingSharedPreference(this, "userid").toString(),requireid)
        displayToast(this,requireid)
       // showLoader(this);
        call.enqueue(object : Callback<RecommandList> {
            override fun onResponse(
                    call: Call<RecommandList>,
                    response: Response<RecommandList>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    count_available=response.body()?.count_available!!
                    if (response.body()?.status == true) {
                        if (response.body()?.user_data != null) {

                            val mAdapter = AdapterRecommendPersonlLeadDetails(this@MyLeadsDetailActivity,response.body()?.user_data as MutableList<UserData>,leadreqheck,requireid,this@MyLeadsDetailActivity)
                            binding.recommendedPersonlist.adapter = mAdapter

                        }else{
                            displayToast(this@MyLeadsDetailActivity,response.body()?.message.toString())
                        }
                    }
                }

                if(leadreqheck.equals("0")){
                    app_user_check_lead(requireid)
                }
            }

            override fun onFailure(call: Call<RecommandList>, t: Throwable) {
                dismissLoader();
                //displayToast(this@MyLeadsDetailActivity,this@MyLeadsDetailActivity.resources.getString(R.string.error_something_wrong))
            }
        })

    }

    private fun app_user_check_lead(requireid:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_user_check_lead(readUsingSharedPreference(this@MyLeadsDetailActivity, "userid").toString(),requireid)
        //showLoader(this);
        call.enqueue(object : Callback<UserCheck> {
            override fun onResponse(
                    call: Call<UserCheck>,
                    response: Response<UserCheck>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.Data?.size != 0) {

                            val Avaliable:String= response.body()?.Data?.get(0)?.Available.toString()

                            if(Avaliable.equals("Yes")){
                                binding.toolbar.ivLeadStatus.visibility=View.VISIBLE

                                binding.tvRecommendedMySelf.visibility=View.GONE
                            }else{
                                binding.toolbar.ivLeadStatus.visibility=View.GONE

                                binding.tvRecommendedMySelf.visibility=View.VISIBLE
                            }


                        }
                    }
                }
            }

            override fun onFailure(call: Call<UserCheck>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1003){
            if (isInternetAvailable(this)) {
              //  RequirementDetails(requireid,"1")
            }
        }else if(requestCode == 1001){
            type=intent.getStringExtra("type").toString()
            requireid=intent.getStringExtra("id").toString()
            if (intent.getStringExtra("type") == "requirement") {
                if (isInternetAvailable(this)) {
                    RequirementDetails(requireid,"1")
                }
            }else{
                if(isInternetAvailable(this)) {
                    RequirementDetails(requireid,"0")
                }
            }

        }
    }

    override fun OnClick(position: Int, data: String, is_viewed: Int) {
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
    override fun OnClick(position: Int, data: String) {
        val intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra("id",data)
        intent.putExtra("type","MyLead")
        startActivity(intent)
    }
    override fun OnClickDialog(position: Int, companyName: MutableList<RecomendedBy>) {
        bottomSheetRecommendPersonOthers(companyName)
    }

    private fun bottomSheetRecommendPersonOthers(companyName: MutableList<RecomendedBy>) {
        val dialog =BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
        val mBsRecommendPersonListBinding =
                DataBindingUtil.inflate<BsRecommendPersonListBinding>(LayoutInflater.from(this), R.layout.bs_recommend_person_list, null, false)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(mBsRecommendPersonListBinding.root)
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mBsRecommendPersonListBinding.rvRecommendPersonList.layoutManager = layoutManager

        val mAdapter = AdapterRecommendPersonOthers(this as FragmentActivity?,companyName,this)
        mBsRecommendPersonListBinding.rvRecommendPersonList.adapter = mAdapter

        mBsRecommendPersonListBinding.ivClose.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun PermissionDialog(massage:String){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mbsAddAccountDialog: PlanexpaireddialogBinding = DataBindingUtil.inflate(LayoutInflater.from(this),R.layout.planexpaireddialog, null, false)
        dialog.setContentView(mbsAddAccountDialog.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        mbsAddAccountDialog.massage.setText(massage)
        dialog.show()
        mbsAddAccountDialog.okbtd.setOnClickListener {
            dialog.dismiss()
        }
        mbsAddAccountDialog.txtUpgrade.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this, MyMembershipBenefitsActivity::class.java))
        }

    }

    private fun PermissionBackDialog(massage:String){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mbsAddAccountDialog: PlanexpaireddialogBinding = DataBindingUtil.inflate(LayoutInflater.from(this),R.layout.planexpaireddialog, null, false)
        dialog.setContentView(mbsAddAccountDialog.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        mbsAddAccountDialog.massage.setText(massage)
        dialog.show()
        mbsAddAccountDialog.okbtd.setOnClickListener {
            dialog.dismiss()
            onBackPressed()
        }
        mbsAddAccountDialog.txtUpgrade.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this, MyMembershipBenefitsActivity::class.java))
        }

    }


}