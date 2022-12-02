package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.BuildConfig
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.supportfeedback.FeedbackEventActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.Adapter.AdapterEventsGallery
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.Adapter.AdapterMyReviewAll
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.model.EventDetails
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.UpdateEventsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.GallerViewActivityZoom
import com.justforentrepreneurs.j4eapp.databinding.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class MyEventsDetailsActivity : BaseActivity(), View.OnClickListener,AdapterMyReviewAll.OnClick2 {
    private lateinit var binding: ActivityMyEventsDetailBinding
    lateinit var eventid: String
    lateinit var eventcatid: String
    lateinit var Backtype:String
    lateinit var position:String
    lateinit var eventcreate: String
    lateinit var event_booked_byuser: String
    lateinit var type: String

    val MILLIS_PER_DAY = 24 * 60 * 60 * 1000L

    override fun enablePresence(): Boolean {
        return true
    }

    val review : MutableList<EventDetails.Alleventsdata.Allreviews> = mutableListOf<EventDetails.Alleventsdata.Allreviews>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_events_detail)
        binding.toolbar.tvTitle.text = resources.getText(R.string.event_detail)


        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)

        position=intent.getStringExtra("position").toString()
        type = intent.getStringExtra("type").toString()
        Backtype = intent.getStringExtra("Back").toString()
        eventid = intent.getStringExtra("id").toString()



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
                        ${shareMessage}https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}
                   
                        
                        """.trimIndent()
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                startActivity(Intent.createChooser(shareIntent, "choose one"))
            } catch (e: Exception) {
                //e.toString();
            }
        }

        binding.lifecycleOwner = this
        initList()
        galleryRecyclerData()
    }

    private fun initList() {
        binding.toolbar.ivEventStatus.setOnClickListener(this)
        binding.toolbar.ivAttendanceList.setOnClickListener(this)
        binding.toolbar.ivMarkAttendance.setOnClickListener(this)

        if(isInternetAvailable(this)) {
            getEventsDeatils(eventid)
        }

        binding.MaybeLi.setOnClickListener {
            if(!(event_booked_byuser.equals("Yes"))) {
                if (isInternetAvailable(this)) {
                    app_event_participation("3")
                }
            }else{
                displayToast(this@MyEventsDetailsActivity,"Allready Registered")
            }
        }

        binding.interestedLi.setOnClickListener {
            if(!(event_booked_byuser.equals("Yes"))) {
                if (isInternetAvailable(this)) {
                    app_event_participation("1")
                }
            }else{
                displayToast(this@MyEventsDetailsActivity,"Allready Registered")
            }
        }


    }


    private fun galleryRecyclerData() {
        val layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.rvGallery.layoutManager = layoutManager

    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            binding.toolbar.ivEventStatus.id -> {
                val intent = Intent(this, EventStatusActivity::class.java)
                intent.putExtra("id",eventid)
                startActivity(intent)
            }
            binding.toolbar.ivAttendanceList.id -> {
                val intent = Intent(this, EventJoinerActivity::class.java)
                intent.putExtra("id",eventid)
                startActivity(intent)
            }

        }
    }

    fun OnInviteClick(view: View) {
        val intent = Intent(this, RecommendedEventsActivity::class.java)
        intent.putExtra("type", "EventReview")
        intent.putExtra("backType", eventcatid)
        intent.putExtra("id",eventid)
        intent.putExtra("eventcreate",eventcreate)
        startActivityForResult(intent,1003)
    }

    override fun onBackPressed() {
        super.onBackPressed()


        if (Backtype == "activity") {

            if(intent.getStringExtra("noti").toString().equals("notification")){
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("type", "notification")
                startActivity(intent)
            }else if(intent.getStringExtra("type").toString().equals("Upcoming")){
                val intent = Intent(this, MyEventsActivity::class.java)
                intent.putExtra("type", "Upcoming")
                intent.putExtra("position", position)
                startActivity(intent)
            }

        } else {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("type", "MyEvents")
            intent.putExtra("position", position)
            startActivity(intent)
        }
    }


    fun onEventReviewClick(view: View) {
        val intent = Intent(this, FeedbackEventActivity::class.java)
        intent.putExtra("type", "EventReview")
        intent.putExtra("backType", eventcatid)
        intent.putExtra("id",eventid)
        startActivityForResult(intent,1003)
    }



    fun seallreview(view: View){
        val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
        val mBSRewardListBinding: ReviewallPopupBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.reviewall_popup, null, false)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(mBSRewardListBinding.root)
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mBSRewardListBinding.recyclerUpgradePlan.layoutManager = layoutManager



        mBSRewardListBinding.memberdetails.setText("Review View All")


        val mAdapter = AdapterMyReviewAll(
                this@MyEventsDetailsActivity, review,this@MyEventsDetailsActivity
        )
        mBSRewardListBinding.recyclerUpgradePlan.adapter = mAdapter

        mBSRewardListBinding.ivcancle.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun getEventsDeatils(eventid:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_event_detail(eventid, readUsingSharedPreference(this, "userid").toString())
        call.enqueue(object : Callback<EventDetails> {
            override fun onResponse(
                    call: Call<EventDetails>,
                    response: Response<EventDetails>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            binding.linearlayout1.visibility = View.GONE
                            binding.linearlayout.visibility = View.VISIBLE


                            if(readUsingSharedPreference(this@MyEventsDetailsActivity, "addpersmisson").toString().equals("1")) {

                                if(response.body()?.data?.get(0)?.event_data?.event_publish_status.toString().equals("2")) {
                                    binding.tvBookTicket.visibility = View.GONE
                                    binding.llBottomContent.visibility = View.GONE
                                    binding.toolbar.ivEventStatus.visibility = View.GONE
                                    binding.toolbar.ivMarkAttendance.visibility = View.GONE
                                    binding.toolbar.ivShare.visibility = View.GONE
                                    binding.tvInvite.visibility = View.GONE
                                    binding.tvEventReviews.visibility = View.GONE
                                    binding.toolbar.ivAttendanceList.visibility = View.GONE
                                    binding.revirecard.visibility = View.GONE
                                    binding.invitedPeopleli.visibility = View.GONE



                                    binding.toolbar.ivedit.visibility = View.VISIBLE
                                    binding.btdPublishev.visibility = View.VISIBLE
                                    binding.toolbar.ivedit.setOnClickListener {
                                        val intent = Intent(this@MyEventsDetailsActivity, UpdateEventsActivity::class.java)
                                        intent.putExtra("id", eventid)
                                        startActivityForResult(intent,1003)
                                    }

                                    binding.btdPublishev.setOnClickListener {



                                        val Datesub: String =response.body()?.data?.get(0)?.event_data?.event_startdate.toString()

                                        val sdf = SimpleDateFormat("EEE,dd MMM yyyy hh:mm a")
                                        val currentDate = sdf.format(Date())

                                        var date: Date= sdf.parse(Datesub)
                                        var date1: Date= sdf.parse(getNextDate(currentDate))


                                       // val moreThanDay = Math.abs(date1.time - date.time) > MILLIS_PER_DAY

                                        if(date.compareTo(date1)==1){
                                            if (isInternetAvailable(this@MyEventsDetailsActivity)) {
                                                app_confirm_event_status(eventid)
                                            }

                                        }else if(date.compareTo(date1)==-1){
                                            GallaryDialog()

                                        }

                                    }

                                }else{
                                    binding.toolbar.ivedit.visibility = View.GONE
                                    binding.btdPublishev.visibility = View.GONE
                                    binding.revirecard.visibility = View.VISIBLE
                                    binding.invitedPeopleli.visibility = View.VISIBLE



                                    if (type.equals("past")) {
                                        binding.tvStatus.text = "Present"
                                        binding.tvBookTicket.visibility = View.GONE
                                        binding.llBottomContent.visibility = View.GONE
                                        binding.toolbar.ivEventStatus.visibility = View.GONE
                                        binding.toolbar.ivMarkAttendance.visibility = View.GONE
                                        binding.toolbar.ivShare.visibility = View.GONE
                                        binding.toolbar.ivAttendanceList.visibility = View.VISIBLE
                                        binding.tvInvite.visibility = View.GONE
                                        binding.tvEventReviews.visibility = View.GONE

                                    }else{
                                        binding.tvBookTicket.visibility = View.VISIBLE
                                        binding.toolbar.ivAttendanceList.visibility = View.VISIBLE
                                        binding.toolbar.ivEventStatus.visibility = View.VISIBLE
                                        binding.toolbar.ivMarkAttendance.visibility = View.GONE
                                        binding.toolbar.ivShare.visibility = View.VISIBLE
                                        binding.llBottomContent.visibility = View.VISIBLE
                                    }
                                }


                            }else{
                                binding.toolbar.ivedit.visibility = View.GONE
                                binding.revirecard.visibility = View.VISIBLE
                                binding.invitedPeopleli.visibility = View.VISIBLE
                                binding.btdPublishev.visibility = View.GONE

                                if (type.equals("past")) {
                                    binding.tvStatus.text = "Present"
                                    binding.tvBookTicket.visibility = View.GONE
                                    binding.llBottomContent.visibility = View.GONE
                                    binding.toolbar.ivEventStatus.visibility = View.GONE
                                    binding.toolbar.ivAttendanceList.visibility = View.VISIBLE
                                    binding.toolbar.ivMarkAttendance.visibility = View.GONE
                                    binding.toolbar.ivShare.visibility = View.GONE
                                    binding.tvInvite.visibility = View.GONE
                                    binding.tvEventReviews.visibility = View.GONE

                                }else{
                                    binding.tvBookTicket.visibility = View.VISIBLE
                                    binding.toolbar.ivEventStatus.visibility = View.VISIBLE
                                    binding.toolbar.ivAttendanceList.visibility = View.VISIBLE
                                    binding.toolbar.ivMarkAttendance.visibility = View.GONE
                                    binding.toolbar.ivShare.visibility = View.VISIBLE
                                    binding.llBottomContent.visibility = View.VISIBLE
                                }
                            }




                            eventcreate= response.body()?.data?.get(0)?.event_data?.event_createdby_id.toString()
                            binding.eventtitle.text=response.body()?.data?.get(0)?.event_data?.event_title
                            binding.eventsdate.text=response.body()?.data?.get(0)?.event_data?.event_startdate+"\n to "+response.body()?.data?.get(0)?.event_data?.event_enddate
                            binding.phonenumber.text=response.body()?.data?.get(0)?.event_data?.event_createdby_phno
                            binding.address.text=response.body()?.data?.get(0)?.event_data?.event_address
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                binding.description.text=Html.fromHtml(response.body()?.data?.get(0)?.event_data?.event_description,Html.FROM_HTML_MODE_COMPACT)
                            }else{
                                binding.description.text=Html.fromHtml(response.body()?.data?.get(0)?.event_data?.event_description)
                            }
                            binding.catname.text=response.body()?.data?.get(0)?.event_data?.event_cat_name

                            binding.memberfree.text=" ₹ " + fmt(response.body()?.data?.get(0)?.event_data?.event_fees!!)
                            binding.GuestFees.text="  ₹ " + fmt(response.body()?.data?.get(0)?.event_data?.event_guest_fees!!)





                            if(response.body()?.data?.get(0)?.event_data?.event_description!!.length > 200){
                                binding.collapse.visibility=View.GONE
                                binding.othersmore.visibility=View.VISIBLE
                            }else {
                                binding.collapse.visibility = View.GONE
                                binding.othersmore.visibility = View.GONE
                            }

                            binding.description.maxLines=4

                            binding.othersmore.setOnClickListener {
                                binding.description.maxLines=Integer.MAX_VALUE
                                binding.collapse.visibility=View.VISIBLE
                                binding.othersmore.visibility=View.GONE
                            }

                            binding.collapse.setOnClickListener {
                                binding.description.maxLines=4
                                binding.collapse.visibility=View.GONE
                                binding.othersmore.visibility=View.VISIBLE
                            }

                          if(response.body()?.data?.get(0)?.event_data?.event_booked_byuser=="Yes"){
                                binding.tvStatus.visibility=View.VISIBLE
                                binding.tvStatus.text="Registered"
                            }else{
                                binding.tvStatus.visibility=View.GONE
                            }

                            binding.invitedPeople.text=response.body()?.data?.get(0)?.event_invitedcount.toString()+" People Invited"

                            binding.tvMaybe.text=response.body()?.data?.get(0)?.event_maybecount.toString()
                            binding.tvAttendingCount.text=response.body()?.data?.get(0)?.event_attendedcount.toString()
                            binding.tvInterestedCount.text=response.body()?.data?.get(0)?.event_interestedcount.toString()

                            Glide.with(this@MyEventsDetailsActivity)
                                    .load(response.body()?.data?.get(0)?.event_data?.event_thumbnil)
                                    .into(binding.eventImage)

                            binding.eventImage.setOnClickListener {
                                val propertyDetailsIntent = Intent(this@MyEventsDetailsActivity, GallerViewActivityZoom::class.java)
                                propertyDetailsIntent.putExtra("Url", response.body()?.data?.get(0)?.event_data?.event_thumbnil)
                                startActivity(propertyDetailsIntent)
                            }


                            if( response.body()?.data?.get(0)?.gallery_data!=null) {
                                binding.rvGallery.visibility=View.VISIBLE
                                binding.Gallerycard.visibility=View.VISIBLE
                                val mAdapter = AdapterEventsGallery(this@MyEventsDetailsActivity,
                                        response.body()?.data?.get(0)?.gallery_data as MutableList<EventDetails.Alleventsdata.Gallerydata>)
                                binding.rvGallery.adapter = mAdapter
                            }else{
                                binding.rvGallery.visibility=View.GONE
                                binding.Gallerycard.visibility=View.GONE
                            }

                            binding.TotalReviewmain.text=response.body()?.data?.get(0)?.average_ratings+"/ 5"

                            eventcatid=response.body()?.data?.get(0)?.event_data?.event_cat_id.toString()


                            binding.pb1.max= response.body()?.data?.get(0)?.review_star?.get(0)?.total_rate_review!!
                            binding.pb2.max=response.body()?.data?.get(0)?.review_star?.get(0)?.total_rate_review!!
                            binding.pb3.max=response.body()?.data?.get(0)?.review_star?.get(0)?.total_rate_review!!
                            binding.pb4.max=response.body()?.data?.get(0)?.review_star?.get(0)?.total_rate_review!!
                            binding.pb5.max=response.body()?.data?.get(0)?.review_star?.get(0)?.total_rate_review!!

                            binding.pb1.progress=response.body()?.data?.get(0)?.review_star?.get(0)?.one_star?.toInt()!!
                            binding.pb2.progress=response.body()?.data?.get(0)?.review_star?.get(0)?.two_star?.toInt()!!
                            binding.pb3.progress=response.body()?.data?.get(0)?.review_star?.get(0)?.three_star?.toInt()!!
                            binding.pb4.progress=response.body()?.data?.get(0)?.review_star?.get(0)?.four_star?.toInt()!!
                            binding.pb5.progress=response.body()?.data?.get(0)?.review_star?.get(0)?.five_star?.toInt()!!

                            binding.onestar.text=response.body()?.data?.get(0)?.review_star?.get(0)?.one_star?.toString()+"/"+response.body()?.data?.get(0)?.review_star?.get(0)?.total_rate_review?.toInt()!!
                            binding.twostar.text=response.body()?.data?.get(0)?.review_star?.get(0)?.two_star?.toString()+"/"+response.body()?.data?.get(0)?.review_star?.get(0)?.total_rate_review?.toInt()!!
                            binding.threestar.text=response.body()?.data?.get(0)?.review_star?.get(0)?.three_star?.toString()+"/"+response.body()?.data?.get(0)?.review_star?.get(0)?.total_rate_review?.toInt()!!
                            binding.fourstar.text=response.body()?.data?.get(0)?.review_star?.get(0)?.four_star?.toString()+"/"+response.body()?.data?.get(0)?.review_star?.get(0)?.total_rate_review?.toInt()!!
                            binding.fivestar.text=response.body()?.data?.get(0)?.review_star?.get(0)?.five_star?.toString()+"/"+response.body()?.data?.get(0)?.review_star?.get(0)?.total_rate_review?.toInt()!!

                            binding.totalrating.text="Total No of Rating : "+response.body()?.data?.get(0)?.review_star?.get(0)?.total_rate_review?.toInt()!!
                            binding.totalrating1.text="Total No of Review : "+response.body()?.data?.get(0)?.total_review_count?.toInt()!!

                            if(response.body()?.data?.get(0)?.all_reviews?.size!=0){
                                binding.reviewLi.visibility=View.VISIBLE
                                binding.seeallrevirews.visibility=View.VISIBLE
                                binding.ivName.text=response.body()?.data?.get(0)?.all_reviews?.get(0)?.reviewed_by
                                binding.note.text=response.body()?.data?.get(0)?.all_reviews?.get(0)?.review_note

                                binding.rating.rating= response.body()?.data?.get(0)?.all_reviews?.get(0)?.review_rate?.toFloat()!!

                                binding.tvDate.text=response.body()?.data?.get(0)?.all_reviews?.get(0)?.review_date

                                    Glide.with(this@MyEventsDetailsActivity)
                                            .load(response.body()?.data?.get(0)?.all_reviews?.get(0)?.profile_img)
                                            .centerCrop()
                                            .placeholder(R.drawable.ic_profile_edit)
                                            .into(binding.ivReviewProfileImg)

                                binding.ivReviewProfileImg.setOnClickListener {
                                    val intent = Intent(this@MyEventsDetailsActivity, ProfileActivity::class.java)
                                    intent.putExtra("id",response.body()?.data?.get(0)?.all_reviews?.get(0)?.reviewed_by_id)
                                    intent.putExtra("type","MyLead")
                                    startActivityForResult(intent,1004)
                                }


                            }else{
                                binding.reviewLi.visibility=View.GONE
                                binding.seeallrevirews.visibility=View.GONE

                            }
                            review.clear()
                            review.addAll(response.body()?.data?.get(0)?.all_reviews as MutableList)

                            Glide.with(this@MyEventsDetailsActivity)
                                    .load(response.body()?.data?.get(0)?.event_data?.event_createdby_profile)
                                    .into(binding.Eventbyimg)

                            binding.nameEventby.text=response.body()?.data?.get(0)?.event_data?.event_createdby_name

                            binding.seemoreEventprofile.setOnClickListener {
                                val intent = Intent(this@MyEventsDetailsActivity, ProfileActivity::class.java)
                                intent.putExtra("id",response.body()?.data?.get(0)?.event_data?.event_createdby_id)
                                intent.putExtra("type","MyLead")
                                startActivityForResult(intent,1004)
                            }

                            if(response.body()?.data?.get(0)?.event_invited?.size!=0){
                                if(response.body()?.data?.get(0)?.event_invited?.size == 1){
                                    binding.ivProfileImg1d.visibility=View.VISIBLE
                                    Glide.with(this@MyEventsDetailsActivity)
                                            .load(response.body()?.data?.get(0)?.event_invited?.get(0)?.images)
                                            .centerCrop()
                                            .placeholder(R.drawable.ic_profile_edit)
                                            .into(binding.ivProfileImg1d)

                                    binding.ivProfileImg2d.visibility=View.GONE
                                    binding.ivProfileImg211.visibility=View.GONE
                                    binding.ivProfileImg21.visibility=View.GONE
                                    binding.ivProfileImg2.visibility=View.GONE
                                }else{

                                }

                                if(response.body()?.data?.get(0)?.event_invited?.size == 2){
                                    binding.ivProfileImg1d.visibility=View.VISIBLE
                                    binding.ivProfileImg2d.visibility=View.VISIBLE
                                    Glide.with(this@MyEventsDetailsActivity)
                                            .load(response.body()?.data?.get(0)?.event_invited?.get(0)?.images)
                                            .centerCrop()
                                            .placeholder(R.drawable.ic_profile_edit)
                                            .into(binding.ivProfileImg1d)

                                    Glide.with(this@MyEventsDetailsActivity)
                                            .load(response.body()?.data?.get(0)?.event_invited?.get(1)?.images)
                                            .centerCrop()
                                            .placeholder(R.drawable.ic_profile_edit)
                                            .into(binding.ivProfileImg2d)

                                    binding.ivProfileImg211.visibility=View.GONE
                                    binding.ivProfileImg21.visibility=View.GONE
                                    binding.ivProfileImg2.visibility=View.GONE


                                }else{

                                }

                                if(response.body()?.data?.get(0)?.event_invited?.size == 3){
                                    binding.ivProfileImg1d.visibility=View.VISIBLE
                                    binding.ivProfileImg2d.visibility=View.VISIBLE
                                    binding.ivProfileImg211.visibility=View.VISIBLE

                                    Glide.with(this@MyEventsDetailsActivity)
                                            .load(response.body()?.data?.get(0)?.event_invited?.get(0)?.images)
                                            .centerCrop()
                                            .placeholder(R.drawable.ic_profile_edit)
                                            .into(binding.ivProfileImg1d)
                                    Glide.with(this@MyEventsDetailsActivity)
                                            .load(response.body()?.data?.get(0)?.event_invited?.get(1)?.images)
                                            .centerCrop()
                                            .placeholder(R.drawable.ic_profile_edit)
                                            .into(binding.ivProfileImg2d)

                                    Glide.with(this@MyEventsDetailsActivity)
                                            .load(response.body()?.data?.get(0)?.event_invited?.get(2)?.images)
                                            .centerCrop()
                                            .placeholder(R.drawable.ic_profile_edit)
                                            .into(binding.ivProfileImg211)


                                    binding.ivProfileImg21.visibility=View.GONE
                                    binding.ivProfileImg2.visibility=View.GONE
                                }else{

                                }

                                if(response.body()?.data?.get(0)?.event_invited?.size == 4){

                                    binding.ivProfileImg1d.visibility=View.VISIBLE
                                    binding.ivProfileImg2d.visibility=View.VISIBLE
                                    binding.ivProfileImg211.visibility=View.VISIBLE
                                    binding.ivProfileImg21.visibility=View.VISIBLE

                                    Glide.with(this@MyEventsDetailsActivity)
                                            .load(response.body()?.data?.get(0)?.event_invited?.get(0)?.images)
                                            .centerCrop()
                                            .placeholder(R.drawable.ic_profile_edit)
                                            .into(binding.ivProfileImg1d)
                                    Glide.with(this@MyEventsDetailsActivity)
                                            .load(response.body()?.data?.get(0)?.event_invited?.get(1)?.images)
                                            .centerCrop()
                                            .placeholder(R.drawable.ic_profile_edit)
                                            .into(binding.ivProfileImg2d)

                                    Glide.with(this@MyEventsDetailsActivity)
                                            .load(response.body()?.data?.get(0)?.event_invited?.get(2)?.images)
                                            .centerCrop()
                                            .placeholder(R.drawable.ic_profile_edit)
                                            .into(binding.ivProfileImg211)
                                    Glide.with(this@MyEventsDetailsActivity)
                                            .load(response.body()?.data?.get(0)?.event_invited?.get(3)?.images)
                                            .centerCrop()
                                            .placeholder(R.drawable.ic_profile_edit)
                                            .into(binding.ivProfileImg21)

                                    binding.ivProfileImg2.visibility=View.GONE
                                }

                                if(response.body()?.data?.get(0)?.event_invited?.size!! >= 5){
                                    binding.ivProfileImg1d.visibility=View.VISIBLE
                                    binding.ivProfileImg2d.visibility=View.VISIBLE
                                    binding.ivProfileImg211.visibility=View.VISIBLE
                                    binding.ivProfileImg21.visibility=View.VISIBLE
                                    binding.ivProfileImg2.visibility=View.VISIBLE
                                    Glide.with(this@MyEventsDetailsActivity)
                                            .load(response.body()?.data?.get(0)?.event_invited?.get(0)?.images)
                                            .centerCrop()
                                            .placeholder(R.drawable.ic_profile_edit)
                                            .into(binding.ivProfileImg1d)
                                    Glide.with(this@MyEventsDetailsActivity)
                                            .load(response.body()?.data?.get(0)?.event_invited?.get(1)?.images)
                                            .centerCrop()
                                            .placeholder(R.drawable.ic_profile_edit)
                                            .into(binding.ivProfileImg2d)

                                    Glide.with(this@MyEventsDetailsActivity)
                                            .load(response.body()?.data?.get(0)?.event_invited?.get(2)?.images)
                                            .centerCrop()
                                            .placeholder(R.drawable.ic_profile_edit)
                                            .into(binding.ivProfileImg211)
                                    Glide.with(this@MyEventsDetailsActivity)
                                            .load(response.body()?.data?.get(0)?.event_invited?.get(3)?.images)
                                            .centerCrop()
                                            .placeholder(R.drawable.ic_profile_edit)
                                            .into(binding.ivProfileImg21)

                                    Glide.with(this@MyEventsDetailsActivity)
                                            .load(response.body()?.data?.get(0)?.event_invited?.get(4)?.images)
                                            .centerCrop()
                                            .placeholder(R.drawable.ic_profile_edit)
                                            .into(binding.ivProfileImg2)

                                }
                            }else{
                                binding.ivProfileImg2d.visibility=View.GONE
                                binding.ivProfileImg211.visibility=View.GONE
                                binding.ivProfileImg21.visibility=View.GONE
                                binding.ivProfileImg2.visibility=View.GONE
                                binding.ivProfileImg1d.visibility=View.GONE
                            }

                            event_booked_byuser= response.body()?.data?.get(0)?.event_data?.event_booked_byuser.toString()

                            binding.tvBookTicket.setOnClickListener {
                                val intent = Intent(this@MyEventsDetailsActivity, EventBookingActivity::class.java)
                                intent.putExtra("type", "Eventbook")
                                intent.putExtra("id",eventid)
                                intent.putExtra("event_booked_byuser",event_booked_byuser)
                                intent.putExtra("Back","activity")
                                startActivityForResult(intent,1003)
                            }

                            binding.tvattaendTicket.setOnClickListener {
                                bottomSheetprocess()
                            }

                            binding.orgnaizename.text=response.body()?.data?.get(0)?.event_organizerma?.get(0)?.organizename.toString()
                            binding.Adresss.text=Html.fromHtml(response.body()?.data?.get(0)?.event_organizerma?.get(0)?.address.toString())
                            binding.ShortDesp.text= Html.fromHtml(response.body()?.data?.get(0)?.event_organizerma?.get(0)?.shortabout.toString())


                            binding.twitter.setOnClickListener {
                                val twst:String=response.body()?.data?.get(0)?.event_organizerma?.get(0)?.twitter.toString()
                                if(twst?.isEmpty()) {
                                    displayToast(this@MyEventsDetailsActivity, "empty link")
                                }else{
                                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(twst)))
                                }
                            }

                            binding.facebookimg.setOnClickListener {
                                val twst:String=response.body()?.data?.get(0)?.event_organizerma?.get(0)?.facebook.toString()
                                if(twst?.isEmpty()) {
                                    displayToast(this@MyEventsDetailsActivity, "empty link")
                                }else{
                                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(twst)))
                                }
                            }

                            binding.llLoginLinkedInimg.setOnClickListener {
                                val twst:String=response.body()?.data?.get(0)?.event_organizerma?.get(0)?.linkdin.toString()
                                if(twst?.isEmpty()) {
                                    displayToast(this@MyEventsDetailsActivity, "empty link")
                                }else{
                                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(twst)))
                                }
                            }






                        }
                    }else{
                        PermissionDialog(response.body()?.msg.toString())
                        binding.linearlayout1.visibility = View.GONE
                        binding.linearlayout.visibility = View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<EventDetails>, t: Throwable) {
                dismissLoader();

            }
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 1003) {
                if (isInternetAvailable(this)) {
                    getEventsDeatils(eventid)
                }

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
            onBackPressed()
        }
        mbsAddAccountDialog.txtUpgrade.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this, MyMembershipBenefitsActivity::class.java))
        }
        dialog.show()
    }


    override fun OnClick(position: Int, data: String) {
        val intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra("id",data)
        intent.putExtra("type","MyLead")
        startActivityForResult(intent,1004)
    }

    //participent

    private fun app_event_participation(type:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val sdf = SimpleDateFormat("dd MMM yyyy")
        val currentDate = sdf.format(Date())

        val sdf1 = SimpleDateFormat("hh:mm a")
        val currentDate1 = sdf1.format(Date())
        val call = request.app_event_participation(readUsingSharedPreference(this, "userid").toString(),type,eventid,currentDate,currentDate1)
        showLoaderf(this);
        call.enqueue(object : Callback<ConnectionDecline> {
            override fun onResponse(
                    call: Call<ConnectionDecline>,
                    response: Response<ConnectionDecline>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        displayToast(this@MyEventsDetailsActivity,response.body()?.message.toString())
                        getEventsDeatils(eventid)
                    }else{
                        displayToast(this@MyEventsDetailsActivity,response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                dismissLoader();

            }
        })
    }

    private fun bottomSheetprocess() {
        val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
        val mBsRecommendPersonListBinding: PlanningEventsDialogBinding =
                DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.planning_events_dialog, null, false)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(mBsRecommendPersonListBinding.root)

        mBsRecommendPersonListBinding.cancle.setOnClickListener {
            dialog.dismiss()

        }

        mBsRecommendPersonListBinding.proceed.setOnClickListener {
            dialog.dismiss()
            val intent = Intent(this@MyEventsDetailsActivity, EventBookingActivity::class.java)
            intent.putExtra("type", "Eventbook")
            intent.putExtra("id",eventid)
            intent.putExtra("event_booked_byuser",event_booked_byuser)
            intent.putExtra("Back","activity")
            startActivityForResult(intent,1003)

        }
        dialog.show()
    }

    private fun app_confirm_event_status(id:String) {
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_confirm_event_status(id)
        showLoaderf(this);
        call.enqueue(object : Callback<ConnectionDecline> {
            override fun onResponse(
                call: Call<ConnectionDecline>,
                response: Response<ConnectionDecline>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        displayToast(this@MyEventsDetailsActivity,response.body()?.message.toString())
                        if(isInternetAvailable(this@MyEventsDetailsActivity)) {
                            getEventsDeatils(eventid)
                        }
                    }else{
                        displayToast(this@MyEventsDetailsActivity,response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                dismissLoader();
            }
        })
    }

    private fun GallaryDialog(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mBsRecommendPersonListBinding: AddGallryDialogBinding =
            DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.add_gallry_dialog, null, false)
        dialog.setContentView(mBsRecommendPersonListBinding.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        mBsRecommendPersonListBinding.ChoosefromGallery.visibility=View.GONE

        mBsRecommendPersonListBinding.TakePhoto.text="Event can be edit 24 hours before event date and time"

        mBsRecommendPersonListBinding.okbtd.text="Ok"


        mBsRecommendPersonListBinding.okbtd.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    fun getNextDate(curDate: String?): String? {
        val format = SimpleDateFormat("EEE,dd MMM yyyy hh:mm a")
        val date = format.parse(curDate)
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.DAY_OF_YEAR, 1)
        return format.format(calendar.time)
    }


}