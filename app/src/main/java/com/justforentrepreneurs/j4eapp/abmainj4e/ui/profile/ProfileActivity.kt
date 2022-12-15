package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile


//import com.justforentrepreneurs.j4eapp.model.realms.User
//import com.justforentrepreneurs.j4eapp.utils.ContactUtils.fetchDataCheckexitnumber
//import com.justforentrepreneurs.j4eapp.utils.IntentUtils
//import com.justforentrepreneurs.j4eapp.utils.PermissionsUtil
//import com.justforentrepreneurs.j4eapp.utils.RealmHelper

import android.Manifest
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.provider.Settings
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.dhaval2404.imagepicker.ImagePicker.Companion.REQUEST_CODE
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayout
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.network.model.AppUserAccDetailModel
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.J4EMembersActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.MyLeadsDetailActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.supportfeedback.ReviewActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mybuddies.MyBuddiesActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.MyConnectionsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mytestimonials.AdapterMyTestimonials
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.adapter.AdapterGallery
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.adapter.AdapterViewPager
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.*
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.splash.PermissionsUtil
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.databinding.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.*
import java.text.SimpleDateFormat
import java.util.*


class ProfileActivity : BaseActivity(),AdapterMyTestimonials.OnClick2,AdapterGallery.OnClick2,AdapterViewPager.onClickCard {
    override fun enablePresence(): Boolean {
        return true
    }
    private lateinit var binding: ActivityProfileBinding
    var selectionFollow = false
    lateinit var memberid:String
    lateinit var requiremenid:String
    lateinit var type:String
    lateinit var position:String
    var is_gallery_exhausted:Int = -1
    var is_review_exhausted:Int = 0
    var count_available:Int = -1

    private val PERMISSION_REQUEST_CODE = 159

    var imagesUriArrayList: ArrayList<Uri> = arrayListOf<Uri>()

    val imgStringData=ArrayList<String> ()

    var strMembershipType: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        binding.lifecycleOwner = this

        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.profileview1.startAnimation(anim)

        binding.toolbar.ivBack.setOnClickListener {
            onBackPressed()
        }

        if (intent.getStringExtra("type") == "J4EMemberDetails" || intent.getStringExtra("type") == "BuddiesFragment" || intent.getStringExtra("type") == "BuddiesActivity" || intent.getStringExtra("type") == "ReceivedConnectionfragment" || intent.getStringExtra("type") == "SentConnectionfragment"
                || intent.getStringExtra("type") == "ReceivedConnectionactivity" || intent.getStringExtra("type") == "SentConnectionactivity" || intent.getStringExtra("type") == "MyLead"|| intent.getStringExtra("type") == "AllLeadhome"|| intent.getStringExtra("type") == "AllPost") {
          memberid=intent.getStringExtra("id").toString()

            position=intent.getStringExtra("position").toString()
            type=intent.getStringExtra("type").toString()

            if (!selectionFollow) {
                binding.ivStatusFollowing.setImageResource(R.drawable.ic_unfollowing)
            } else {
                binding.ivStatusFollowing.setImageResource(R.drawable.ic_status_unfollow)
            }

            if(memberid.equals(readUsingSharedPreference(this@ProfileActivity, "userid").toString())){
                binding.messageLL.visibility=View.VISIBLE
                binding.llFollowst.visibility=View.VISIBLE
            }else{
                binding.messageLL.visibility=View.VISIBLE
                binding.llFollowst.visibility=View.VISIBLE
            }

            if (isInternetAvailable(this)) {
                getAppUserAccJ4Detail(memberid);
            }

            binding.profileReviews.WriteReview.setOnClickListener {
                if (is_review_exhausted==0){
                    if (strMembershipType.equals("1")){
                        PermissionGuestDialog("Oops!You can't add review for Guest User.")
                    }else{
                        val intent = Intent(this, ReviewActivity::class.java)
                        intent.putExtra("type", "profileReview")
                        intent.putExtra("backType", type)
                        intent.putExtra("id",memberid)
                        startActivityForResult(intent,1003)
                    }

                }else{
                    PermissionDialog(readUsingSharedPreference(this,"CreatePermissionMsg").toString())
                }

            }

        } else if (intent.getStringExtra("type") == "AllLead") {
            memberid=intent.getStringExtra("id").toString()
            requiremenid=intent.getStringExtra("requirementid").toString()


            if(memberid.equals(readUsingSharedPreference(this@ProfileActivity, "userid").toString())){
                binding.messageLL.visibility=View.GONE
                binding.llFollowst.visibility=View.GONE
            }else{
                binding.messageLL.visibility=View.VISIBLE
                binding.llFollowst.visibility=View.VISIBLE
            }


            if (isInternetAvailable(this)) {
                getAppUserAccJ4Detail(memberid);
            }

            binding.profileReviews.WriteReview.setOnClickListener {
                if (is_review_exhausted==0){
                    val intent = Intent(this, ReviewActivity::class.java)
                    intent.putExtra("type", "profileReview")
                    intent.putExtra("id",memberid)
                    startActivityForResult(intent,1003)
                }else{
                    PermissionDialog(readUsingSharedPreference(this,"CreateExhaustedMsg").toString())
                }

            }

        }else {
            binding.llFollowst.visibility=View.VISIBLE
            binding.messageLL.visibility=View.VISIBLE
            binding.profileReviews.WriteReview.visibility=View.GONE
            memberid=readUsingSharedPreference(this@ProfileActivity, "userid").toString()
            if (isInternetAvailable(this)) {
                getAppUserAccDetail(memberid)
            }
        }

        setupViewPager()
        recyclerData()
        recyclerData2()



        recyclerDataViewpager()

        binding.fabAddGalleyImage.setOnClickListener {
            if(checkPermissions()){
                if (readUsingSharedPreference(this,"PermissionCreateAddGalleryImage").equals("0")){
                    PermissionDialog(readUsingSharedPreference(this,"CreatePermissionMsg").toString())
                }else{
                    if (is_gallery_exhausted==0){
                        GallaryDialog()
                    }else if (is_gallery_exhausted==1){
                        PermissionDialog(readUsingSharedPreference(this,"CreateExhaustedMsg").toString())
                    }else{
                        GallaryDialog()
                    }
                }
            }
//            else{
//                showAlertDialog()
//            }

        }

//        binding.llShare.setOnClickListener {
//            try {
//                val shareIntent = Intent(Intent.ACTION_SEND)
//                shareIntent.type = "text/plain"
//                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "J4E")
//                var shareMessage = "\nLet me recommend you this application\n\n"
//                var profileid = "=abc"
//                shareMessage =
//                    """
//                        ${shareMessage}https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}
//
//
//                        """.trimIndent()
//                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
//                startActivity(Intent.createChooser(shareIntent, "choose one"))
//            } catch (e: Exception) {
//                //e.toString();
//            }
//        }

    }

    var tabPosition = 0
    private fun setupViewPager() {

        binding.tabProfile.addTab(binding.tabProfile.newTab().setText("About Us"))
        binding.tabProfile.addTab(binding.tabProfile.newTab().setText("Contact Us"))
        binding.tabProfile.addTab(binding.tabProfile.newTab().setText("Gallery"))
        binding.tabProfile.addTab(binding.tabProfile.newTab().setText("Reviews"))

        if (intent.getStringExtra("typeedit") == "contacts"){



            binding.abprofilleview.root.visibility = View.GONE
            binding.abprofilecontactus.root.visibility = View.GONE
            binding.profileAboutUs.root.visibility = View.GONE
            //     binding.profileContactUs.root.visibility = View.GONE
            binding.profileContactUs.root.visibility = View.VISIBLE
            binding.profileGallery.root.visibility = View.GONE
            binding.profileReviews.root.visibility = View.GONE
            binding.fabAddGalleyImage.visibility = View.GONE
            binding.toolbar.ivEdit.visibility = View.VISIBLE
            tabPosition=1

            binding.tabProfile.getTabAt(1)?.select()

            getAppUserContactsUs(memberid)


        }else {
            tabPosition=0
            if (intent.getStringExtra("type") == "J4EMemberDetails" || intent.getStringExtra("type") == "AllLead" || intent.getStringExtra(
                    "type"
                ) == "BuddiesFragment" || intent.getStringExtra("type") == "BuddiesActivity" || intent.getStringExtra(
                    "type"
                ) == "ReceivedConnectionfragment" || intent.getStringExtra("type") == "SentConnectionfragment"
                || intent.getStringExtra("type") == "ReceivedConnectionactivity" || intent.getStringExtra(
                    "type"
                ) == "SentConnectionactivity" || intent.getStringExtra("type") == "MyLead" || intent.getStringExtra(
                    "type"
                ) == "AllLeadhome" || intent.getStringExtra("type") == "AllPost"
            ) {
                binding.profileAboutUs.root.visibility = View.VISIBLE
                //     binding.profileContactUs.root.visibility = View.GONE
                binding.profileContactUs.root.visibility = View.GONE
                binding.profileGallery.root.visibility = View.GONE
                binding.profileReviews.root.visibility = View.GONE
                binding.fabAddGalleyImage.visibility = View.GONE
                binding.toolbar.ivEdit.visibility = View.GONE
            } else {
                binding.profileAboutUs.root.visibility = View.VISIBLE
                //     binding.profileContactUs.root.visibility = View.GONE
                binding.profileContactUs.root.visibility = View.GONE
                binding.profileGallery.root.visibility = View.GONE
                binding.profileReviews.root.visibility = View.GONE
                binding.fabAddGalleyImage.visibility = View.GONE
                binding.toolbar.ivEdit.visibility = View.VISIBLE
            }
        }

        binding.tabProfile.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
                println("p0>" + p0!!.position)
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                println("p0>>>" + p0!!.position)
                tabPosition = p0.position
                if (p0.position == 0) {
                    if (intent.getStringExtra("type") == "J4EMemberDetails"  ||  intent.getStringExtra("type") == "AllLead" || intent.getStringExtra("type") == "BuddiesFragment" || intent.getStringExtra("type") == "BuddiesActivity"|| intent.getStringExtra("type") == "ReceivedConnectionfragment" || intent.getStringExtra("type") == "SentConnectionfragment"
                            || intent.getStringExtra("type") == "ReceivedConnectionactivity" || intent.getStringExtra("type") == "SentConnectionactivity" || intent.getStringExtra("type") == "MyLead" || intent.getStringExtra("type") == "AllLeadhome"|| intent.getStringExtra("type") == "AllPost") {
                        binding.profileAboutUs.root.visibility = View.VISIBLE
                        binding.profileContactUs.root.visibility = View.GONE
                        binding.profileGallery.root.visibility = View.GONE
                        binding.profileReviews.root.visibility = View.GONE
                        binding.fabAddGalleyImage.visibility = View.GONE
                        binding.toolbar.ivEdit.visibility = View.GONE
                    }else{
                        binding.profileAboutUs.root.visibility = View.VISIBLE
                        binding.profileContactUs.root.visibility = View.GONE
                        binding.profileGallery.root.visibility = View.GONE
                        binding.profileReviews.root.visibility = View.GONE
                        binding.fabAddGalleyImage.visibility = View.GONE
                        binding.toolbar.ivEdit.visibility = View.VISIBLE
                    }
                } else if (p0.position == 1) {

                    getAppUserContactsUs(memberid)
                    if (intent.getStringExtra("type") == "J4EMemberDetails" || intent.getStringExtra("type") == "AllLead" || intent.getStringExtra("type") == "BuddiesFragment" || intent.getStringExtra("type") == "BuddiesActivity"
                            || intent.getStringExtra("type") == "ReceivedConnectionfragment" || intent.getStringExtra("type") == "SentConnectionfragment"
                            || intent.getStringExtra("type") == "ReceivedConnectionactivity" || intent.getStringExtra("type") == "SentConnectionactivity" || intent.getStringExtra("type") == "MyLead" || intent.getStringExtra("type") == "AllLeadhome"|| intent.getStringExtra("type") == "AllPost") {
                        binding.profileAboutUs.root.visibility = View.GONE
                        binding.profileContactUs.root.visibility = View.VISIBLE
                        binding.profileGallery.root.visibility = View.GONE
                        binding.profileReviews.root.visibility = View.GONE
                        binding.fabAddGalleyImage.visibility = View.GONE
                        binding.toolbar.ivEdit.visibility = View.GONE
                    }else{
                        binding.profileAboutUs.root.visibility = View.GONE
                        binding.profileContactUs.root.visibility = View.VISIBLE
                        binding.profileGallery.root.visibility = View.GONE
                        binding.profileReviews.root.visibility = View.GONE
                        binding.fabAddGalleyImage.visibility = View.GONE
                        binding.toolbar.ivEdit.visibility = View.VISIBLE
                    }
                } else if (p0.position == 2) {

                    getAppUsergallry(memberid)

                    if (intent.getStringExtra("type") == "J4EMemberDetails" || intent.getStringExtra("type") == "AllLead" || intent.getStringExtra("type") == "BuddiesFragment" || intent.getStringExtra("type") == "BuddiesActivity" || intent.getStringExtra("type") == "ReceivedConnectionfragment" || intent.getStringExtra("type") == "SentConnectionfragment"
                            || intent.getStringExtra("type") == "ReceivedConnectionactivity" || intent.getStringExtra("type") == "SentConnectionactivity" || intent.getStringExtra("type") == "MyLead" || intent.getStringExtra("type") == "AllLeadhome"|| intent.getStringExtra("type") == "AllPost") {
                        binding.profileAboutUs.root.visibility = View.GONE
                        binding.profileContactUs.root.visibility = View.GONE
                        binding.profileGallery.root.visibility = View.VISIBLE
                        binding.profileReviews.root.visibility = View.GONE
                        binding.fabAddGalleyImage.visibility = View.GONE
                        binding.toolbar.ivEdit.visibility = View.GONE
                    }else{
                        binding.profileAboutUs.root.visibility = View.GONE
                        binding.profileContactUs.root.visibility = View.GONE
                        binding.profileGallery.root.visibility = View.VISIBLE
                        binding.profileReviews.root.visibility = View.GONE
                        binding.fabAddGalleyImage.visibility = View.VISIBLE
                        binding.toolbar.ivEdit.visibility = View.GONE
                    }
                } else if (p0.position == 3) {

                    if (readUsingSharedPreference(this@ProfileActivity,"PermissionReview").equals("0")){
                        PermissionDialog(readUsingSharedPreference(this@ProfileActivity,"ViewPermissionMsg").toString())
                    }else{
                        get_user_rating_review(memberid)
                    }

                    binding.profileAboutUs.root.visibility = View.GONE
                    binding.profileContactUs.root.visibility = View.GONE
                    binding.profileGallery.root.visibility = View.GONE
                    binding.profileReviews.root.visibility = View.VISIBLE
                    binding.fabAddGalleyImage.visibility = View.GONE
                    binding.toolbar.ivEdit.visibility = View.GONE
                }
            }

        })
        changeTabsFont()
    }

    private fun changeTabsFont() {
        val font = ResourcesCompat.getFont(this, R.font.notosans_jp_medium)
        val vg = binding.tabProfile.getChildAt(0) as ViewGroup
        val tabsCount = vg.childCount
        for (j in 0 until tabsCount) {
            val vgTab = vg.getChildAt(j) as ViewGroup
            val tabChildsCount = vgTab.childCount
            for (i in 0 until tabChildsCount) {
                val tabViewChild = vgTab.getChildAt(i)
                if (tabViewChild is TextView) {
                    tabViewChild.setTypeface(font, Typeface.NORMAL)
                    tabViewChild.isAllCaps = false
                }
            }
        }
    }


    //Gallery Modul
    private fun recyclerData() {
        val layoutManager = GridLayoutManager(this, 2)
        binding.profileGallery.rvGallary.layoutManager = layoutManager
    }


    //Reviews Module
    private fun recyclerData2() {
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.profileReviews.rvMyReviews.layoutManager = layoutManager

    }

    private fun recyclerDataViewpager() {
        val layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.profileContactUs.forntviewrv.layoutManager = layoutManager
    }

    fun onFollowClick(view: View) {
        if(!memberid.equals(readUsingSharedPreference(this@ProfileActivity, "userid").toString())) {
            if (selectionFollow == false) {
                if (isInternetAvailable(this)) {
                    if (readUsingSharedPreference(this,"PermissionConnectionRequest").equals("0")){
                        PermissionDialog1(readUsingSharedPreference(this,"CreateExhaustedMsg").toString())
                    }else{
                        getconnection_request_sent(
                            readUsingSharedPreference(
                                this@ProfileActivity,
                                "userid"
                            ).toString(), memberid
                        )
                    }

                }
            } else {

            }
        }
    }

    fun onEditBtnClick(view: View) {
        if (tabPosition == 0) {
            val intent = Intent(this, ProfileAboutUsEditActivity::class.java)
            startActivityForResult(intent, 101)
        } else if (tabPosition == 1) {
            startActivity(Intent(this, ProfileContactUsEditActivity::class.java))
        }
    }

    fun onRewardPointsClick(view: View) {
       /* if(memberid.equals(readUsingSharedPreference(this@ProfileActivity, "userid").toString())) {
            startActivity(Intent(this, MyReportCardActivity::class.java))
        }*/
    }

    fun onRanksClick(view: View) {
      /*  if(memberid.equals(readUsingSharedPreference(this@ProfileActivity, "userid").toString())) {
            val intent = Intent(this, TopRankingActivity::class.java)
            intent.putExtra("type", "pro")
            startActivity(intent)
        }*/
    }

    fun onConnectionClick(view: View) {
      /*  if(memberid.equals(readUsingSharedPreference(this@ProfileActivity, "userid").toString())) {
            startActivity(Intent(this, MyConnectionsActivity()::class.java))
        }*/
    }

    fun onScanMyProfile(view: View) {
       /* if(memberid.equals(readUsingSharedPreference(this@ProfileActivity, "userid").toString())) {
            startActivity(Intent(this, ScanMyProfileActivity::class.java))
        }*/
        displayToast(this, "Coming Soon..")
    }


    private fun getAppUserAccDetail(id:String) {
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.getaccountdetals(id,readUsingSharedPreference(this, "userid").toString())
      //  showLoader(this);
        call.enqueue(object : Callback<AppUserAccDetailModel> {
            override fun onResponse(call: Call<AppUserAccDetailModel>, response: Response<AppUserAccDetailModel>) {
                dismissLoader();
                if (response.isSuccessful){
                    if (response.body()?.status==true) {
                        if (response.body()?.messageData != null) {
                            Glide.with(this@ProfileActivity)
                                .load(response.body()?.messageData?.profilePic)
                                .centerCrop()
                                .placeholder(R.drawable.ic_profile_edit)
                                .into(binding.ivProfileImg)
                            strMembershipType = response.body()?.messageData?.membership_type.toString()
                            binding.ivProfileImg.setOnClickListener {
                                val propertyDetailsIntent = Intent(this@ProfileActivity, GallerViewActivityZoom::class.java)
                                propertyDetailsIntent.putExtra("Url",response.body()?.messageData?.profilePic)
                                startActivity(propertyDetailsIntent)
                            }

                            if(!(response.body()?.messageData?.first_name=="" || response.body()?.messageData?.first_name==null)) {
                                binding.userName.text = wordFirstCap(response.body()?.messageData?.first_name.toString()+" "+ response.body()?.messageData?.middle_name+" "+ response.body()?.messageData?.last_name)
                                binding.toolbar.tvTitle.text =  wordFirstCap(response.body()?.messageData?.first_name.toString()+" "+ response.body()?.messageData?.last_name)
                            }else{
                                binding.userName.text=""
                            }
                            

                            if(!(response.body()?.messageData?.companyName=="" || response.body()?.messageData?.companyName==null)) {
                                binding.companyName.text = response.body()?.messageData?.companyName.toString().capitalize()
                            }else{
                                binding.companyName.text=""
                            }

                            if(!(response.body()?.messageData?.business_entity=="" || response.body()?.messageData?.business_type=="" || response.body()?.messageData?.total_experience=="")) {
                                binding.address.text =  response.body()?.messageData?.business_entity.toString().replace("null","") + ", " +
                                        response.body()?.messageData?.business_type.toString().replace("null","") + ", " +
                                        response.body()?.messageData?.business_category.toString().replace("null","") + ", " +
                                        response.body()?.messageData?.total_experience.toString().replace("null","")
                            }else{
                                binding.address.text =""
                            }

                            if(!(response.body()?.messageData?.first_name=="" || response.body()?.messageData?.first_name==null)) {
                                binding.profileContactUs.fullname1.setText(wordFirstCap(response.body()?.messageData?.first_name.toString()+" "+ response.body()?.messageData?.middle_name+" "+ response.body()?.messageData?.last_name))
                            }else{
                                binding.profileContactUs.fullname1.setText("")
                            }

                            binding.rewardpoint.text=response.body()?.messageData?.reward_point
                            binding.rank.text=response.body()?.messageData?.rank
                            binding.connections.text=response.body()?.messageData?.connection

                            Glide.with(this@ProfileActivity)
                                .load(response.body()?.messageData?.badge_image)
                                .into(binding.baatch)

//                            if(!memberid.equals(readUsingSharedPreference(this@ProfileActivity, "userid").toString())){
//                                binding.messageimg.setImageResource(R.drawable.ic_message_two)
//                            }else{
//                                binding.messageimg.setImageResource(R.drawable.ic_message_two_disable)
//                            }


                            binding.llShare.setOnClickListener {
                                if (response.body()?.messageData?.share_url.equals("")||response.body()?.messageData?.share_url==null){
                                    displayToast(this@ProfileActivity,"Invalid link")
                                }else{
//                                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(response.body()?.messageData?.share_url))
//                                    startActivity(i)
                                    try {
                                        val shareIntent = Intent(Intent.ACTION_SEND)
                                        shareIntent.type = "text/plain"
                                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "J4E")
                                        var shareMessage = "\nLet me share this profile\n\n"+response.body()?.messageData?.share_url
                                        //var shareMessage ="\nLet me share this profile\n\n"+"https://applex360.co.in/j4e_new/api/v1/"+id
                                        shareMessage =
                                            """
                        ${shareMessage}
                        
                        
                        """.trimIndent()
                                        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                                        startActivity(Intent.createChooser(shareIntent, "choose one"))
                                    } catch (e: Exception) {
                                        //e.toString();
                                    }
                                }
                            }

                            storeUsingSharedPreference(this@ProfileActivity, "dob", response.body()?.messageData?.dob)
                            storeUsingSharedPreference(this@ProfileActivity, "fullname", response.body()?.messageData?.first_name+" "+ response.body()?.messageData?.middle_name+" "+ response.body()?.messageData?.last_name)
                            storeUsingSharedPreference(this@ProfileActivity, "profilepic", response.body()?.messageData?.profilePic.toString())
                            storeUsingSharedPreference(this@ProfileActivity, "business_entity", response.body()?.messageData?.business_entity)
                            storeUsingSharedPreference(this@ProfileActivity, "business_type", response.body()?.messageData?.business_type)
                            storeUsingSharedPreference(this@ProfileActivity, "total_experience", response.body()?.messageData?.total_experience)
                            storeUsingSharedPreference(this@ProfileActivity, "business_category", response.body()?.messageData?.business_category)
                            storeUsingSharedPreference(this@ProfileActivity, "flatname", response.body()?.messageData?.first_name+" "+ response.body()?.messageData?.last_name)
                        }
                    }
                    app_check_connection(readUsingSharedPreference(this@ProfileActivity, "userid").toString())

                }
            }
            override fun onFailure(call: Call<AppUserAccDetailModel>, t: Throwable) {
                dismissLoader();
                displayToast(this@ProfileActivity, this@ProfileActivity.resources.getString(R.string.error_something_wrong))
            }
        })
    }

    private fun app_check_connection(viewbyuserid:String) {
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_check_connection(readUsingSharedPreference(this@ProfileActivity, "userid").toString(),viewbyuserid)
        // showLoader(this);
        call.enqueue(object : Callback<Checkconnection> {
            override fun onResponse(
                call: Call<Checkconnection>,
                response: Response<Checkconnection>
            ) {
                //  dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data  == true) {
                            selectionFollow = true
                            binding.ivStatusFollowing.setImageResource(R.drawable.ic_status_unfollow)
                            binding.ivStatusFollowing.setColorFilter(ContextCompat.getColor(this@ProfileActivity, R.color.rating_selection))

                        }else{
                            selectionFollow = false
                            binding.ivStatusFollowing.setImageResource(R.drawable.ic_unfollowing)
                            binding.ivStatusFollowing.setColorFilter(ContextCompat.getColor(this@ProfileActivity, R.color.md_grey_dark))

                        }
                    }else{
                        selectionFollow = false
                        binding.ivStatusFollowing.setImageResource(R.drawable.ic_unfollowing)
                        binding.ivStatusFollowing.setColorFilter(ContextCompat.getColor(this@ProfileActivity, R.color.md_grey_dark))

                    }

                    getAppUserAbouts(viewbyuserid)
                }
            }

            override fun onFailure(call: Call<Checkconnection>, t: Throwable) {
                dismissLoader();
                displayToast(this@ProfileActivity, this@ProfileActivity.resources.getString(R.string.error_something_wrong))
            }
        })
    }

    private fun getAppUserAbouts(id:String) {
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.getuser_view_profile_about(id)
      //  showLoader(this);
        call.enqueue(object : Callback<ProfileAboutModel> {
            override fun onResponse(
                call: Call<ProfileAboutModel>,
                response: Response<ProfileAboutModel>
            ) {
              //  dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.message != null) {

                            binding.profileview1.visibility = View.GONE
                            binding.profileview.visibility = View.VISIBLE

                            if(!(response.body()?.message?.company_name=="" || response.body()?.message?.company_name==null)) {
                                binding.profileAboutUs.tvCompanyName.text = response.body()?.message?.company_name?.capitalize()
                            }else{
                                binding.profileAboutUs.tvCompanyName.text=""
                            }

                            if(!(response.body()?.message?.about_company=="" || response.body()?.message?.about_company==null)) {
                                binding.profileAboutUs.tvAboutCompany.text = response.body()?.message?.about_company?.capitalize()
                            }else{
                                binding.profileAboutUs.tvAboutCompany.text=""
                            }

                            binding.profileAboutUs.tvBusinessEntity.text =
                                response.body()?.message?.business_entity
                            binding.profileAboutUs.tvBusinessType.text =
                                response.body()?.message?.business_type
                            binding.profileAboutUs.tvBusinessExpertise.text =
                                response.body()?.message?.business_expertise
                            binding.profileAboutUs.tvWorkingForm.text =
                                response.body()?.message?.working_from
                            binding.profileAboutUs.tvNoOfEmployee.text =
                                response.body()?.message?.no_of_employees
                            binding.profileAboutUs.tvExpectedTurnOver.text =
                                response.body()?.message?.expected_turnover
                            binding.profileAboutUs.tvTagetAudience.text =
                                response.body()?.message?.target_audiance
                            binding.profileAboutUs.tvTypeofMembership.text =
                                response.body()?.message?.membership_title

                            if(!(response.body()?.message?.company_profile.equals(""))) {
                                binding.profileAboutUs.companybouchaer.visibility=View.VISIBLE
                                binding.profileAboutUs.companybouchaeron.visibility=View.VISIBLE
//                                binding.profileAboutUs.tvFileName.visibility=View.GONE


                                binding.profileAboutUs.ivImgPdf.setOnClickListener {
                                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(response.body()?.message?.company_profile))
                                    startActivity(browserIntent)
                                }
                            }else{
                                binding.profileAboutUs.companybouchaer.visibility=View.GONE
                                binding.profileAboutUs.companybouchaeron.visibility=View.GONE
                            }

                            if (!(response.body()?.message?.company_ppt.equals(""))){
                                binding.profileAboutUs.companybouchaerPpt.visibility=View.VISIBLE
                                binding.profileAboutUs.companybouchaeronPpt.visibility=View.VISIBLE

                                binding.profileAboutUs.ivImgPpt.setOnClickListener {
                                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(response.body()?.message?.company_ppt))
                                    startActivity(browserIntent)
                                }
                            }else{
                                binding.profileAboutUs.companybouchaerPpt.visibility=View.GONE
                                binding.profileAboutUs.companybouchaeronPpt.visibility=View.GONE
                            }

                        }
                    }

                 //   getAppUserContactsUs(id)
                }
            }

            override fun onFailure(call: Call<ProfileAboutModel>, t: Throwable) {
                dismissLoader()
                displayToast(this@ProfileActivity, this@ProfileActivity.resources.getString(R.string.error_something_wrong))
            }
        })
    }

    private fun getAppUserContactsUs(id:String) {
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.getuser_view_profile_contacts(id)
       // showLoader(this);
        call.enqueue(object : Callback<ProfileContactUsModel> {
            override fun onResponse(
                    call: Call<ProfileContactUsModel>,
                    response: Response<ProfileContactUsModel>
            ) {
              //  dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {


                            binding.profileContactUs.linercontactus1.visibility=View.GONE
                            binding.profileContactUs.linercontactus.visibility=View.VISIBLE
                        //    binding.profileContactUs.name.text =   response.body()?.message?.first_name+" "+ response.body()?.message?.lastt_name

                            if(!(response.body()?.data?.company_name=="" || response.body()?.data?.company_name==null)) {
                                binding.profileContactUs.companyName.text  = response.body()?.data?.company_name.toString().capitalize()
                            }else{
                                binding.profileContactUs.companyName.text =""
                            }

                            if(!(response.body()?.data?.designation=="" || response.body()?.data?.designation==null)) {
                                binding.profileContactUs.Designationid.text  = response.body()?.data?.designation.toString().capitalize()
                            }else{
                                binding.profileContactUs.Designationid.text =""
                            }

                            if(!(response.body()?.data?.business_category=="" || response.body()?.data?.business_category==null)) {
                                binding.profileContactUs.businessCategory.text  = response.body()?.data?.business_category.toString().capitalize()
                            }else{
                                binding.profileContactUs.businessCategory.text =""
                            }

                            if(!(response.body()?.data?.company_address=="" || response.body()?.data?.company_address==null)) {
                                binding.profileContactUs.companyAddress.text  = response.body()?.data?.company_address.toString().capitalize()
                            }else{
                                binding.profileContactUs.companyAddress.text =""
                            }


                            binding.profileContactUs.email.text =   response.body()?.data?.email
                            binding.profileContactUs.callcontcts.text =   response.body()?.data?.mobile
                            binding.profileContactUs.companywebside.text =   response.body()?.data?.website
                            binding.profileContactUs.totolyearexperice.text =   response.body()?.data?.total_experience
                            binding.profileContactUs.datec.text =   response.body()?.data?.date_of_birth
                            binding.profileContactUs.gendersp.text =   response.body()?.data?.gender
                            if (response.body()?.data?.whatsapp_no != null){
                                binding.profileContactUs.txtWhatsapp.text =   response.body()?.data?.whatsapp_no
                            }

//                            if (response.body()?.data?.company_whatsapp_no != null){
//                                binding.profileContactUs.txtWhatsappBusiness.text =   response.body()?.data?.company_whatsapp_no
//                            }


                            binding.profileContactUs.txtWhatsapp.setOnClickListener {
                                if ( response.body()?.data?.whatsapp_no != null && ! response.body()?.data?.whatsapp_no.equals("") ){
                                    val intent = Intent(Intent.ACTION_VIEW,
                                        Uri.parse("http://api.whatsapp.com/send?phone="+"+91"+ response.body()?.data?.whatsapp_no + "&text="+"Hello"))
                                    startActivity(intent)
                                }else{
                                    displayToast(this@ProfileActivity,"Invalid Whatsapp number!")
                                }
                            }

                            binding.profileContactUs.email.setOnClickListener {
                                if (!response.body()?.data?.email.equals("")||response.body()?.data?.email ==null){
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + response.body()?.data?.email))
                                    intent.putExtra(Intent.EXTRA_SUBJECT, "email_subject")
                                    intent.putExtra(Intent.EXTRA_TEXT, "email_body")
                                    startActivity(intent)
                                }else{
                                    displayToast(this@ProfileActivity,"Invalid Email !")
                                }
                            }

                            binding.profileContactUs.callcontcts.setOnClickListener {
                                if (!response.body()?.data?.mobile.equals("")||response.body()?.data?.mobile ==null){
                                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + response.body()?.data?.mobile))
                                    startActivity(intent)
                                }else{
                                    displayToast(this@ProfileActivity,"Invalid Contact number !")
                                }
                            }

                            binding.profileContactUs.companywebside.setOnClickListener {
                                if (!response.body()?.data?.website.equals("")||response.body()?.data?.website ==null){
                                    if (response.body()?.data?.website!!.startsWith("http") || response.body()?.data?.website!!.startsWith("https")){
                                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(response.body()?.data?.website))
                                        startActivity(intent)
                                    }else{
                                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://"+response.body()?.data?.website))
                                        startActivity(intent)
                                    }

                                }else{
                                    displayToast(this@ProfileActivity,"Invalid Website !")
                                }

                            }


                            if(response.body()?.data?.company_facebook.equals("")){
                                binding.profileContactUs.facebookimg.visibility=View.GONE
                            }else{
                                binding.profileContactUs.facebookimg.visibility=View.VISIBLE
                            }

                            if(response.body()?.data?.company_linkedin.equals("")){
                                binding.profileContactUs.llLoginLinkedInimg.visibility=View.GONE
                            }else{
                                binding.profileContactUs.llLoginLinkedInimg.visibility=View.VISIBLE
                            }

                            if(response.body()?.data?.company_google.equals("")){
                                binding.profileContactUs.googleimg.visibility=View.GONE
                            }else{
                                binding.profileContactUs.googleimg.visibility=View.VISIBLE
                            }

                            binding.profileContactUs.googleimg.setOnClickListener {
                                val facst=response.body()?.data?.company_google.toString();
                                if(facst.isEmpty()) {
                                    displayToast(this@ProfileActivity, "empty link")
                                }else {
                                    if (facst.startsWith("https") || facst.startsWith("http") ){
                                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(response.body()?.data?.company_google.toString())))
                                    }else{
                                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://"+response.body()?.data?.company_google.toString())))
                                    }

                                }

                            }

                            binding.profileContactUs.facebookimg.setOnClickListener {
                                val facst=response.body()?.data?.company_facebook.toString();
                                if(facst.isEmpty()){
                                    displayToast(this@ProfileActivity, "empty link")
                                }else{
                                    if (facst.startsWith("https") || facst.startsWith("http") ){
                                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse( response.body()?.data?.company_facebook.toString())))
                                    }else{
                                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://"+ response.body()?.data?.company_facebook.toString())))
                                    }
                                }
                            }

                            binding.profileContactUs.llLoginLinkedInimg.setOnClickListener {

                                val facst=response.body()?.data?.company_linkedin.toString();
                                if(facst.isEmpty()) {
                                    displayToast(this@ProfileActivity, "empty link")
                                }else {
                                    if (facst.startsWith("https") || facst.startsWith("http") ){
                                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(response.body()?.data?.company_linkedin.toString())))
                                    }else{
                                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://"+response.body()?.data?.company_linkedin.toString())))
                                    }
                                }
                            }

                            var Gallaryimg: MutableList<String> = mutableListOf<String>()
                            Gallaryimg.clear()

                            if(!(response.body()?.data?.vcard_front.toString().equals("") || response.body()?.data?.vcard_front.toString().equals("https://applex360.co.in/j4e_new/upload/requirements/"))) {
                                Gallaryimg.add(response.body()?.data?.vcard_front.toString())
                            }
                            if(!(response.body()?.data?.vcard_back.toString().equals("") || response.body()?.data?.vcard_back.toString().equals("https://applex360.co.in/j4e_new/upload/requirements/"))) {
                                Gallaryimg.add(response.body()?.data?.vcard_back.toString())
                            }

                            if(Gallaryimg.size.equals(0)){
                                binding.profileContactUs.businesstv.visibility=View.GONE
                                binding.profileContactUs.forntviewrv.visibility=View.GONE
                            }else {
                                if(!(response.body()?.data?.vcard_front.toString().equals(""))) {
                                    imgStringData.add(response.body()?.data?.vcard_front.toString())
                                }
                                if(!(response.body()?.data?.vcard_back.toString().equals(""))) {
                                    imgStringData.add(response.body()?.data?.vcard_back.toString())
                                }
                                binding.profileContactUs.businesstv.visibility=View.VISIBLE
                                binding.profileContactUs.forntviewrv.visibility=View.VISIBLE
                                val mAdapter = AdapterViewPager(
                                        this@ProfileActivity,
                                        Gallaryimg,this@ProfileActivity)

                                binding.profileContactUs.forntviewrv.adapter = mAdapter

                                val pagerSnapHelper = PagerSnapHelper()
                                binding.profileContactUs.forntviewrv.onFlingListener=null
                                pagerSnapHelper.attachToRecyclerView(binding.profileContactUs.forntviewrv)
                                binding.profileContactUs.relatedDetailsindicator.attachToRecyclerView(binding.profileContactUs.forntviewrv, pagerSnapHelper)
                            }


                           // getAppUsergallry(id)


                        }
                    }

                    binding.profileContactUs.linercontactus1.visibility=View.GONE
                    binding.profileContactUs.linercontactus.visibility=View.VISIBLE
                }
            }

            override fun onFailure(call: Call<ProfileContactUsModel>, t: Throwable) {
                dismissLoader();
                displayToast(this@ProfileActivity, this@ProfileActivity.resources.getString(R.string.error_something_wrong))
            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (intent.getStringExtra("type") == "J4EMemberDetails") {
            val intent = Intent(this, J4EMembersActivity::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        }else if (intent.getStringExtra("type") == "AllLead") {
            val intent = Intent(this, MyLeadsDetailActivity::class.java)
            intent.putExtra("type", "AllLead")
            intent.putExtra("id",requiremenid)
            startActivity(intent)
        }else if (intent.getStringExtra("type") == "BuddiesFragment") {
           // startActivity(Intent(this@ProfileActivity, MyBuddiesActivity::class.java))
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("hometype", "2")
            intent.putExtra("type", "hometype")
            intent.putExtra("position", position)
            startActivity(intent)
        }else if (intent.getStringExtra("type") == "BuddiesActivity") {
            startActivity(Intent(this@ProfileActivity, MyBuddiesActivity::class.java))
        }else if (intent.getStringExtra("type") == "ReceivedConnectionfragment") {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("hometype", "0")
            intent.putExtra("type", "ReceivedConnectionfragment")
            intent.putExtra("position", position)
            startActivity(intent)
        }else if (intent.getStringExtra("type") == "SentConnectionfragment") {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("hometype", "1")
            intent.putExtra("type", "SentConnectionfragment")
            intent.putExtra("position", position)
            startActivity(intent)
        }else if (intent.getStringExtra("type") == "ReceivedConnectionactivity") {
            val intent = Intent(this, MyConnectionsActivity::class.java)
            intent.putExtra("hometype", "0")
            intent.putExtra("type", "ReceivedConnectionactivity")
            intent.putExtra("position", position)
            startActivity(intent)
        }else if (intent.getStringExtra("type") == "SentConnectionactivity") {
            val intent = Intent(this, MyConnectionsActivity::class.java)
            intent.putExtra("hometype", "1")
            intent.putExtra("type", "SentConnectionactivity")
            intent.putExtra("position", position)
            startActivity(intent)
        }else if(intent.getStringExtra("type") == "MyLead"){
            val returnIntent = Intent()
            returnIntent.putExtra("result", "123")
            setResult(RESULT_OK, returnIntent)
            finish()
        }else if(intent.getStringExtra("type") == "AllLeadhome"){
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("hometype", "1")
            intent.putExtra("type", "hometype")
            intent.putExtra("position", position)
            startActivity(intent)
        }else if(intent.getStringExtra("type") == "AllPost"){
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("hometype", "3")
            intent.putExtra("type", "hometype")
            intent.putExtra("position", position)
            startActivity(intent)
        }else{
            startActivity(Intent(this@ProfileActivity, MainActivity::class.java))
        }
    }

    private fun getconnection_request_sent(id:String,receiverid:String) {
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.getconnection_request_sent(id,receiverid)
     //   showLoader(this);
        call.enqueue(object : Callback<ConnectionSend> {
            override fun onResponse(
                    call: Call<ConnectionSend>,
                    response: Response<ConnectionSend>
            ) {
              //  dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.user_data != null) {
                            selectionFollow = true
                            binding.ivStatusFollowing.setImageResource(R.drawable.ic_status_unfollow)
                            binding.ivStatusFollowing.setColorFilter(ContextCompat.getColor(this@ProfileActivity, R.color.rating_selection))
                            displayToast(this@ProfileActivity,response.body()?.message.toString())
                        }else{
                            displayToast(this@ProfileActivity,response.body()?.message.toString())
                        }
                    }else{
                        PermissionDialog(response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ConnectionSend>, t: Throwable) {
                dismissLoader();
                displayToast(this@ProfileActivity, this@ProfileActivity.resources.getString(R.string.error_something_wrong))
            }
        })
    }

    //

    private fun getAppUserAccJ4Detail(id:String) {
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.getaccountdetals(id,readUsingSharedPreference(this, "userid").toString())
       // showLoader(this);
        call.enqueue(object : Callback<AppUserAccDetailModel> {
            override fun onResponse(call: Call<AppUserAccDetailModel>, response: Response<AppUserAccDetailModel>) {
               dismissLoader();
                if (response.isSuccessful){
                    if (response.body()?.status==true) {
                        if (response.body()?.messageData != null) {
                            Glide.with(this@ProfileActivity)
                                    .load(response.body()?.messageData?.profilePic)
                                    .centerCrop()
                                    .placeholder(R.drawable.ic_profile_edit)
                                    .into(binding.ivProfileImg)
                            strMembershipType = response.body()?.messageData?.membership_type.toString()
                            binding.ivProfileImg.setOnClickListener {
                                val propertyDetailsIntent = Intent(this@ProfileActivity, GallerViewActivityZoom::class.java)
                                propertyDetailsIntent.putExtra("Url",response.body()?.messageData?.profilePic)
                                startActivity(propertyDetailsIntent)
                            }
                            binding.llShare.setOnClickListener {
                                if (response.body()?.messageData?.share_url.equals("")||response.body()?.messageData?.share_url==null){
                                    displayToast(this@ProfileActivity,"Invalid link")
                                }else{
//                                    val i = Intent(Intent.ACTION_VIEW, Uri.parse(response.body()?.messageData?.share_url))
//                                    startActivity(i)
                                    try {
                                        val shareIntent = Intent(Intent.ACTION_SEND)
                                        shareIntent.type = "text/plain"
                                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "J4E")
                                        var shareMessage = "\nLet me share this profile\n\n"+response.body()?.messageData?.share_url
                                        //var shareMessage ="\nLet me share this profile\n\n"+"https://applex360.co.in/j4e_new/api/"+id
                                        shareMessage =
                                            """
                        ${shareMessage}
                        
                        
                        """.trimIndent()
                                        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                                        startActivity(Intent.createChooser(shareIntent, "choose one"))
                                    } catch (e: Exception) {
                                        //e.toString();
                                    }
                                }
                            }
                            if(!(response.body()?.messageData?.first_name=="" || response.body()?.messageData?.first_name==null)) {
                                binding.userName.text = wordFirstCap(response.body()?.messageData?.first_name.toString()+" "+ response.body()?.messageData?.middle_name+" "+ response.body()?.messageData?.last_name)

                                binding.toolbar.tvTitle.text = wordFirstCap( response.body()?.messageData?.first_name.toString()+" "+ response.body()?.messageData?.last_name)
                            }else{
                                binding.userName.text=""
                            }



                            if(!(response.body()?.messageData?.companyName=="" || response.body()?.messageData?.companyName==null)) {
                                binding.companyName.text = response.body()?.messageData?.companyName
                            }else{
                                binding.companyName.text=""
                            }

                            if(!(response.body()?.messageData?.first_name=="" || response.body()?.messageData?.first_name==null)) {
                                binding.profileContactUs.fullname1.setText(response.body()?.messageData?.first_name.toString().capitalize()+" "+ response.body()?.messageData?.middle_name+" "+ response.body()?.messageData?.last_name)
                            }else{
                                binding.profileContactUs.fullname1.setText("")
                            }


                            if(!(response.body()?.messageData?.business_entity=="" || response.body()?.messageData?.business_type=="" || response.body()?.messageData?.total_experience=="")) {
                                binding.address.text =  response.body()?.messageData?.business_entity.toString().replace("null","") + ", " +
                                        response.body()?.messageData?.business_type.toString().replace("null","") + ", " +
                                        response.body()?.messageData?.business_category.toString().replace("null","") + ", " +
                                        response.body()?.messageData?.total_experience.toString().replace("null","")
                            }else{
                                binding.address.text =""
                            }


                            binding.rewardpoint.text=response.body()?.messageData?.reward_point
                            binding.rank.text=response.body()?.messageData?.rank
                            binding.connections.text=response.body()?.messageData?.connection

                            Glide.with(this@ProfileActivity)
                                .load(response.body()?.messageData?.badge_image)
                                .into(binding.baatch)

                            if (response.body()?.messageData?.whatsapp_no != null && !response.body()?.messageData?.whatsapp_no.equals("") ){
                                binding.messageimg.setImageResource(R.drawable.ic_message_two)
                                //mViewHolder.mBinding.messageid.setImageResource(R.drawable.ic_messagepng)
                            }else{
                                binding.messageimg.setImageResource(R.drawable.ic_message_two_disable)
                                //mViewHolder.mBinding.messageid.setImageResource(R.drawable.ic_buddy_message_disable)
                            }

                            binding.messageLL.setOnClickListener {

                                val intent = Intent(Intent.ACTION_VIEW,
                                    Uri.parse("http://api.whatsapp.com/send?phone="+"+91"+response.body()?.messageData?.whatsapp_no + "&text="+"Hello"))
                                startActivity(intent)
                            }

                        }
                    }else{
                        PermissionBackDialog(response.body()?.message.toString())
                    }

                    app_check_connection(memberid)

                }
            }
            override fun onFailure(call: Call<AppUserAccDetailModel>, t: Throwable) {
                dismissLoader();
                displayToast(this@ProfileActivity, this@ProfileActivity.resources.getString(R.string.error_something_wrong))
            }
        })
    }


    private fun getAppUsergallry(id:String) {
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.view_user_gallery1(id)

        //showLoader(this);
        call.enqueue(object : Callback<ViewGallery> {
            override fun onResponse(
                    call: Call<ViewGallery>, response: Response<ViewGallery>
            ) {
               // dismissLoader();
                if (response.isSuccessful) {
                    binding.profileGallery.liprogallary.visibility=View.GONE

                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            binding.profileGallery.rvGallary.visibility=View.VISIBLE
                            binding.profileGallery.txtNoRecord.visibility=View.GONE
                            is_gallery_exhausted= response.body()?.data?.is_gallery_exhausted!!
                            val mAdapter = AdapterGallery(
                                    this@ProfileActivity,
                                    response.body()?.data?.gallery_info as MutableList<com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.GalleryInfo>,this@ProfileActivity,memberid
                            )
                            binding.profileGallery.rvGallary.adapter = mAdapter

                        }
                    }else{
                        binding.profileGallery.rvGallary.visibility=View.GONE
                        binding.profileGallery.rvGallary.adapter = null
                        binding.profileGallery.txtNoRecord.visibility=View.VISIBLE

                    }
                   // get_user_rating_review(id)
                }
            }

            override fun onFailure(call: Call<ViewGallery>, t: Throwable) {
                dismissLoader()
                binding.profileGallery.liprogallary.visibility=View.GONE
                binding.profileGallery.rvGallary.visibility=View.GONE
                binding.profileGallery.rvGallary.adapter = null
                binding.profileGallery.txtNoRecord.visibility=View.VISIBLE
                //displayToast(this@ProfileActivity, getString(R.string.error_something_wrong))
            }
        })
    }

    //profile Gallary

    private val pickImage3 = 103
    private val pickImage4 = 104
    private var imageUri3: Uri? = null
    private val PERMISSION_CODEGallry = 1001;
    private val PERMISSION_CODEcamera = 1002;
    lateinit var downsizedImageBytes: ByteArray

    private var destination: File? = null
    var downis: InputStream? = null

    var i:Int=0


    private fun GallaryDialog(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mBsRecommendPersonListBinding: AddGallryDialogBinding =
                DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.add_gallry_dialog, null, false)
        dialog.setContentView(mBsRecommendPersonListBinding.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        mBsRecommendPersonListBinding.TakePhoto.setOnClickListener {
            dialog.dismiss()
            Checkperimmissioncamera()
        }

        mBsRecommendPersonListBinding.ChoosefromGallery.setOnClickListener {
            dialog.dismiss()
            CheckperimmissionGallery()
        }

        mBsRecommendPersonListBinding.okbtd.setOnClickListener {
            getAppUsergallry(readUsingSharedPreference(this, "userid").toString())
            dialog.dismiss()
        }
        dialog.show()
    }

    fun Checkperimmissioncamera(){
        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) || (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) || (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED))
                        {
            //Apply for multiple permissions together

            //Apply for multiple permissions together
            ActivityCompat.requestPermissions(this, arrayOf(
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
            ), PERMISSION_CODEcamera)
        }else {
            val gallery = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(gallery, pickImage4)
        }
    }

    fun CheckperimmissionGallery(){
        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
            val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
            requestPermissions(permissions, PERMISSION_CODEGallry)
        } else {
            val intent = Intent()
            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), pickImage3)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage3) {
            Log.e("++data", "" + data?.clipData?.itemCount) // Get count of image here.
            Log.e("++count", "" + data?.clipData?.itemCount)
            if(data?.clipData?.itemCount!=null) {
                if (data.clipData?.itemCount!! > 10) {
                    imagesUriArrayList.clear()
                    displayToast(this, "You can not select more than 10 images")
                } else {
                    imagesUriArrayList.clear()
                    for (i in 0 until data.clipData?.itemCount!!) {
                        imagesUriArrayList.add(data.clipData?.getItemAt(i)?.getUri()!!)
                    }
                }
            }else{
                imagesUriArrayList.clear()
                imagesUriArrayList.add(data?.data!!)
            }

            getapp_user_edit_profile_pic()
        }else if(resultCode == RESULT_OK && requestCode == pickImage4){
            val bitmap = data!!.extras!!["data"] as Bitmap?

            val partFilename: String = currentDateFormat()
            storeCameraPhotoInSDCard(bitmap!!, partFilename)
            val storeFilename = "photo_$partFilename"
            val mBitmap = getImageFileFromSDCard(storeFilename)

            val Path :String= destination?.getAbsolutePath().toString()

            val scaleWidth: Int = bitmap.width/1
            val scaleHeight: Int = bitmap.height/1
            downsizedImageBytes = getDownsizedImageBytes(bitmap, scaleWidth, scaleHeight)!!


            getapp_user_edit_profile_camera(Path,downsizedImageBytes,bitmap)
        }else if(requestCode == 1003){
            get_user_rating_review(memberid)

        }else if(requestCode == 1004){

        }
    }

    //camera


    private fun getImageFileFromSDCard(filename: String): Bitmap? {
        var bitmap: Bitmap? = null
        destination = File(Environment.getExternalStorageDirectory().toString() + "/" + filename)
        try {
            val fis = FileInputStream(destination)
            bitmap = BitmapFactory.decodeStream(fis)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        return bitmap
    }

    private fun currentDateFormat(): String {
        val dateFormat = SimpleDateFormat("yyyyMMdd_HH_mm_ss")
        return dateFormat.format(Date())
    }

    private fun storeCameraPhotoInSDCard(bitmap: Bitmap, currentDate: String) {
        val outputFile = File(Environment.getExternalStorageDirectory(), "photo_$currentDate")
        try {
            val fileOutputStream = FileOutputStream(outputFile)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
            fileOutputStream.flush()
            fileOutputStream.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @Throws(IOException::class)
    fun getDownsizedImageBytes(fullBitmap: Bitmap?, scaleWidth: Int, scaleHeight: Int): ByteArray? {
        val scaledBitmap = Bitmap.createScaledBitmap(fullBitmap!!, scaleWidth, scaleHeight, true)

        // 2. Instantiate the downsized image content as a byte[]
        val baos = ByteArrayOutputStream()
        scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        return baos.toByteArray()
    }

    private fun getapp_user_edit_profile_pic() {
        if (isInternetAvailable(this)) {
            val request = ServiceBuilder.buildService(APIinterface::class.java)

            val userId = RequestBody.create(MediaType.parse("text/plain"), readUsingSharedPreference(this, "userid").toString())
            val gallerytype = RequestBody.create(MediaType.parse("text/plain"), "1")

            val list: MutableList<MultipartBody.Part> = ArrayList()

            if(imagesUriArrayList.size==0){
                val requestBodyimages = MultipartBody.create(MediaType.parse("multipart/form-data"), "")
                list.add(MultipartBody.Part.createFormData("images[]", "", requestBodyimages))
            }else {
                for (i in 0 until imagesUriArrayList.size) {

                    val fullBitmap = MediaStore.Images.Media.getBitmap(contentResolver, imagesUriArrayList.get(i))

                    val scaleWidth: Int = fullBitmap.width / 2
                    val scaleHeight: Int = fullBitmap.height / 2
                    val downsizedImageBytesmulti: ByteArray = getDownsizedImageBytes(fullBitmap, scaleWidth, scaleHeight)!!
                    val Pathmulti: String = imagesUriArrayList.get(i).path.toString()


                    val file = File(Pathmulti)
                    val Filenale: String
                    Filenale = if (file.name.contains(".png")) {
                        file.name
                    } else {
                        file.name + ".png"
                    }

                    val requestBodyimages = MultipartBody.create(MediaType.parse("multipart/form-data"), downsizedImageBytesmulti)
                    list.add(MultipartBody.Part.createFormData("images[]", Filenale, requestBodyimages))

                }
            }

            val call = request.user_gallery_add(userId,gallerytype,list)
            showLoader(this);
            call.enqueue(object : Callback<GallaryUpload> {
                override fun onResponse(
                        call: Call<GallaryUpload>,
                        response: Response<GallaryUpload>
                ) {
                    dismissLoader();
                    if (response.isSuccessful) {
                        if (response.body()?.status == true) {
                                getAppUsergallry(readUsingSharedPreference(this@ProfileActivity, "userid").toString())
                                //displayToast(this@ProfileActivity, response.body()?.message.toString())

                        }else{
                            PermissionDialog(response.body()?.message.toString())
                            displayToast(this@ProfileActivity, "Gallery Image Upload Fail")
                        }

                    }
                }

                override fun onFailure(call: Call<GallaryUpload>, t: Throwable) {
                    dismissLoader()
                    displayToast(this@ProfileActivity, this@ProfileActivity.resources.getString(R.string.error_something_wrong))
                }
            })
        }
    }


    private fun getapp_user_edit_profile_camera(attachment:String,downsizedImageBytes: ByteArray, bitmap:Bitmap) {
        if (isInternetAvailable(this)) {
            val request = ServiceBuilder.buildService(APIinterface::class.java)

            val userId = RequestBody.create(MediaType.parse("text/plain"), readUsingSharedPreference(this, "userid").toString())
            val gallerytype = RequestBody.create(MediaType.parse("text/plain"), "1")

            val list: MutableList<MultipartBody.Part> = ArrayList()

            val file = File(attachment)

            val Filenale: String
            Filenale = if (file.name.contains(".png")) {
                file.name
            } else {
                file.name + ".png"
            }

            val requestBodyimages = MultipartBody.create(MediaType.parse("multipart/form-data"), downsizedImageBytes)
            list.add(MultipartBody.Part.createFormData("images[]", Filenale, requestBodyimages))

            val call = request.user_gallery_add(userId,gallerytype,list)
            showLoader1(this);
            call.enqueue(object : Callback<GallaryUpload> {
                override fun onResponse(
                        call: Call<GallaryUpload>,
                        response: Response<GallaryUpload>
                ) {
                    dismissLoader();
                    if (response.isSuccessful) {
                        if (response.body()?.status == true) {
                                getAppUsergallry(readUsingSharedPreference(this@ProfileActivity, "userid").toString())
                                //displayToast(this@ProfileActivity, response.body()?.message.toString())

                        }else{
                            PermissionDialog(response.body()?.message.toString())
                            displayToast(this@ProfileActivity, "Gallery Image Upload Fail")
                        }

                    }
                }

                override fun onFailure(call: Call<GallaryUpload>, t: Throwable) {
                    dismissLoader()
                    displayToast(this@ProfileActivity, this@ProfileActivity.resources.getString(R.string.error_something_wrong))
                }
            })
        }
    }

    fun get_user_rating_review(id:String) {
        if (isInternetAvailable(this)) {
            val request = ServiceBuilder.buildService(APIinterface::class.java)
            val call = request.get_user_rating_review(id)
            // showLoader(this)
            call.enqueue(object : Callback<ProfileReview> {
                override fun onResponse(
                        call: Call<ProfileReview>,
                        response: Response<ProfileReview>) {
                   // dismissLoader();
                    if (response.isSuccessful) {
                        if (response.body()?.status == true) {
                            count_available=response.body()?.count_available!!
                            if (response.body()?.data != null) {
                                binding.profileReviews.liproReview1.visibility=View.GONE
                                binding.profileReviews.liproReview.visibility=View.VISIBLE
                                is_review_exhausted=response.body()?.data?.get(0)?.is_review_exhausted!!
                                binding.profileReviews.cpbStrength.progress= response.body()?.data?.get(0)?.average_ratings?.toFloat()!!
                                binding.profileReviews.totalratingm.text=response.body()?.data?.get(0)?.average_ratings.toString()+"/ 5"


                                binding.profileReviews.pb1.max= response.body()?.data?.get(0)?.review_star?.get(0)?.total_rate_review!!
                                binding.profileReviews.pb2.max=response.body()?.data?.get(0)?.review_star?.get(0)?.total_rate_review!!
                                binding.profileReviews.pb3.max=response.body()?.data?.get(0)?.review_star?.get(0)?.total_rate_review!!
                                binding.profileReviews.pb4.max=response.body()?.data?.get(0)?.review_star?.get(0)?.total_rate_review!!
                                binding.profileReviews.pb5.max=response.body()?.data?.get(0)?.review_star?.get(0)?.total_rate_review!!

                                binding.profileReviews.pb1.progress=response.body()?.data?.get(0)?.review_star?.get(0)?.one_star?.toInt()!!
                                binding.profileReviews.pb2.progress=response.body()?.data?.get(0)?.review_star?.get(0)?.two_star?.toInt()!!
                                binding.profileReviews.pb3.progress=response.body()?.data?.get(0)?.review_star?.get(0)?.three_star?.toInt()!!
                                binding.profileReviews.pb4.progress=response.body()?.data?.get(0)?.review_star?.get(0)?.four_star?.toInt()!!
                                binding.profileReviews.pb5.progress=response.body()?.data?.get(0)?.review_star?.get(0)?.five_star?.toInt()!!

                                binding.profileReviews.onestar.text=response.body()?.data?.get(0)?.review_star?.get(0)?.one_star?.toString()+"/"+response.body()?.data?.get(0)?.review_star?.get(0)?.total_rate_review?.toInt()!!
                                binding.profileReviews.twostar.text=response.body()?.data?.get(0)?.review_star?.get(0)?.two_star?.toString()+"/"+response.body()?.data?.get(0)?.review_star?.get(0)?.total_rate_review?.toInt()!!
                                binding.profileReviews.threestar.text=response.body()?.data?.get(0)?.review_star?.get(0)?.three_star?.toString()+"/"+response.body()?.data?.get(0)?.review_star?.get(0)?.total_rate_review?.toInt()!!
                                binding.profileReviews.fourstar.text=response.body()?.data?.get(0)?.review_star?.get(0)?.four_star?.toString()+"/"+response.body()?.data?.get(0)?.review_star?.get(0)?.total_rate_review?.toInt()!!
                                binding.profileReviews.fivestar.text=response.body()?.data?.get(0)?.review_star?.get(0)?.five_star?.toString()+"/"+response.body()?.data?.get(0)?.review_star?.get(0)?.total_rate_review?.toInt()!!


                                binding.profileReviews.totalrating.text="Total No of Rating : "+response.body()?.data?.get(0)?.review_star?.get(0)?.total_rate_review?.toInt()!!
                                binding.profileReviews.TotalReview.text="Total no of Review :"+response.body()?.data?.get(0)?.total_review_count?.toInt()!!
                                val mAdapter = AdapterMyTestimonials(
                                        this@ProfileActivity, response.body()?.data?.get(0)?.all_reviews as MutableList,this@ProfileActivity
                                )
                                binding.profileReviews.rvMyReviews.adapter = mAdapter


                            }
                        }else{
                            binding.profileReviews.liproReview1.visibility=View.GONE
                            binding.profileReviews.liproReview.visibility=View.VISIBLE
                            //  displayToast(this@ProfileActivity, response.body()?.message.toString())
                        }
                        app_check_connection(id)

                    }
                }

                override fun onFailure(call: Call<ProfileReview>, t: Throwable) {
                    dismissLoader()
                    displayToast(this@ProfileActivity, this@ProfileActivity.resources.getString(R.string.error_something_wrong))
                }
            })

        }
    }

    override fun OnClick(position: Int, data: String) {
        if (count_available==0){
            PermissionDialog(readUsingSharedPreference(this,"ViewExhaustedMsg").toString())
        }else{
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("id",data)
            intent.putExtra("type","MyLead")
            startActivity(intent)
        }

    }


    override fun OnClickproImage(position: Int, data: String) {
        val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
        val mBsRecommendPersonListBinding: ImagedeleteDialogBinding =
            DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.imagedelete_dialog, null, false)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(mBsRecommendPersonListBinding.root)

        mBsRecommendPersonListBinding.cancle.setOnClickListener {
            dialog.dismiss()

        }

        mBsRecommendPersonListBinding.proceed.setOnClickListener {
            dialog.dismiss()
            Deleteimage(data,position)

        }
        dialog.show()

    }

    fun Deleteimage(imageid:String,position: Int){
        if (isInternetAvailable(this)) {
            val request = ServiceBuilder.buildService(APIinterface::class.java)

            val call = request.user_gallery_delete(readUsingSharedPreference(this, "userid").toString(),imageid)
            showLoaderf(this)
            call.enqueue(object : Callback<ConnectionDecline> {
                override fun onResponse(
                    call: Call<ConnectionDecline>,
                    response: Response<ConnectionDecline>
                ) {
                    dismissLoader();
                    if (response.isSuccessful) {
                        if (response.body()?.status == true) {
                            displayToast(this@ProfileActivity, response.body()?.message.toString())
                            getAppUsergallry(readUsingSharedPreference(this@ProfileActivity, "userid").toString())
                            binding.profileGallery.rvGallary.getLayoutManager()?.scrollToPosition(position)

                        }
                    }
                }

                override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                    dismissLoader()
                }
            })
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

    private fun PermissionGuestDialog(massage:String){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mbsAddAccountDialog: PlanexpaireddialogBinding = DataBindingUtil.inflate(LayoutInflater.from(this),R.layout.planexpaireddialog, null, false)
        dialog.setContentView(mbsAddAccountDialog.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.show()
        mbsAddAccountDialog.massage.setText(massage)
        mbsAddAccountDialog.txtUpgrade.visibility = View.INVISIBLE
        mbsAddAccountDialog.okbtd.text = "Okay"
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
    private fun PermissionDialog1(massage:String){
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

    private fun showAlertDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mBsRecommendPersonListBinding: SplashPermissiondialogBinding =
            DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.splash_permissiondialog, null, false)
        dialog.setContentView(mBsRecommendPersonListBinding.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        mBsRecommendPersonListBinding.goseeting.setOnClickListener {
            val gallery = Intent(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.fromParts("package", getPackageName(), null))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(gallery)

        }

        mBsRecommendPersonListBinding.okbtd.setOnClickListener {
            dialog.dismiss()
        }

        mBsRecommendPersonListBinding.noclosetheapp.setOnClickListener {
            requestPermissions()
        }
    }

    private fun requestPermissions() {

        ActivityCompat.requestPermissions(this, PermissionsUtil.permissions(), PERMISSION_REQUEST_CODE)
    }

    fun checkPermissions(): Boolean {
        var result: Int
        val listPermissionsNeeded: MutableList<String> = ArrayList()
        for (p in PermissionsUtil.permissions()) {
            result = ContextCompat.checkSelfPermission(this, p)
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p)
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, PermissionsUtil.permissions(), PERMISSION_REQUEST_CODE)
            return false
        }
        return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.size > 0) {
            if (requestCode == PERMISSION_REQUEST_CODE) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission granted
                } else {
                    // permission denied
                    checkUserRequestedDontAskAgain()
                }
            }
        }
    }

    private fun checkUserRequestedDontAskAgain() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val rationalFalgREAD =
                shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            val rationalFalgWRITE =
                shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)
            if (!rationalFalgREAD && !rationalFalgWRITE) {
                showAlertDialog()
            }
        }
    }

    override fun onClick(position: Int) {
        val pos:String= position.toString();
        val propertyDetailsIntent = Intent(this, BusinessCardActivity::class.java)
        propertyDetailsIntent.putStringArrayListExtra("Images", imgStringData as ArrayList<String> )
        propertyDetailsIntent.putExtra("position", pos)
        startActivity(propertyDetailsIntent)
    }
}