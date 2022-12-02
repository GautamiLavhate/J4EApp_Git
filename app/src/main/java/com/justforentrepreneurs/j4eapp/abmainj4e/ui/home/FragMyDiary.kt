package com.justforentrepreneurs.j4eapp.abmainj4e.ui.home

import android.animation.ValueAnimator
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.BuildConfig
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseFragment
import com.justforentrepreneurs.j4eapp.databinding.FragMyDiaryBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.MyDiary
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.VersionResponse
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myawardrecognition.MyAwardRecognitionActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mybuddies.MyBuddiesActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mybusinesstransactions.MyBusinessTransactionsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.MyConnectionsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.MyEventsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myguestinvites.MyGuestInvitesActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mylead.MyLeadsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myposts.MyPostsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrecognition.MyRecognitionActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrefrral.givan.ReferralGivenActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrefrral.receive.ReferralReceivedActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myreportcard.MyReportCardActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrequirements.MyRequirementsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mytestimonials.MyTestimonialsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.PendingResponsibilitiesActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.recommended.RecommendedActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.permissions.PermissionsResponse
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.databinding.NewUpdateDialogBinding
import com.justforentrepreneurs.j4eapp.databinding.UpdateBackgroundBinding
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragMyDiary : BaseFragment(), View.OnClickListener {

    private lateinit var binding: FragMyDiaryBinding
    lateinit var mainActivity: MainActivity
    var stop: Boolean =false
    var new_ver:String = ""
    var is_post_exhausted: Int = -1
    var is_requirement_exhausted: Int = -1
    var is_buddy_meet_exhausted: Int = -1
    var is_referral_exhausted: Int = -1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_my_diary, container, false)
        mainActivity = (activity as MainActivity?)!!
        mainActivity.binding.toolbar.ivCreate.visibility = View.VISIBLE
        mainActivity.binding.toolbar.searchhome.visibility = View.VISIBLE
        mainActivity.binding.toolbar.logotoolbar.visibility = View.VISIBLE
        mainActivity.binding.toolbar.tvTitle.visibility = View.GONE
        initListener()
        //displayToast(requireContext(), readUsingSharedPreference(requireContext(),"userid").toString())
        showUpdateDialog()
        return binding.root
    }

    private fun initListener() {
        binding.llMyEvents.setOnClickListener(this)
        binding.llMyRequirements.setOnClickListener(this)
        binding.llMyConnections.setOnClickListener(this)
        binding.llMyBuddies.setOnClickListener(this)
        binding.llMyBusinessTransactions.setOnClickListener(this)
        binding.llMyTestimonials.setOnClickListener(this)
        binding.llMyAwardRecognition.setOnClickListener(this)
        binding.llMyRecognitions.setOnClickListener(this)
        binding.llMyMembershipBenefits.setOnClickListener(this)
        binding.llShareMyProfile.setOnClickListener(this)
        binding.llRecommendedBy.setOnClickListener(this)
        binding.llRecommendedTo.setOnClickListener(this)
        binding.llMyReportCard.setOnClickListener(this)
        binding.llGuestInvited.setOnClickListener(this)
        binding.llPendingResponsibilities.setOnClickListener(this)
        binding.llMyLeads.setOnClickListener(this)
        binding.llMyPosts.setOnClickListener(this)

        binding.llMyContribution.setOnClickListener(this)
        binding.llReferralGiven.setOnClickListener(this)
        binding.llReferralReceived.setOnClickListener(this)

        val anim: Animation = AnimationUtils.loadAnimation(requireActivity(), android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)

        if(isInternetAvailable(requireActivity())) {
            getMydiary()
            app_check_permissions()
        }

    }

    override fun onClick(v: View) {
        when (v.id) {

            binding.llMyPosts.id -> {
                startActivity(Intent(context, MyPostsActivity::class.java))
            }

            binding.llMyContribution.id -> {
                displayToast(requireActivity(), "Coming Soon..")
            }

            binding.llMyEvents.id -> {
                startActivity(Intent(context, MyEventsActivity::class.java))
            }
            binding.llMyRequirements.id -> {
                startActivity(Intent(context, MyRequirementsActivity::class.java))
            }
            binding.llMyLeads.id -> {
                startActivity(Intent(context, MyLeadsActivity::class.java))
            }
            binding.llMyConnections.id -> {
                startActivity(Intent(context, MyConnectionsActivity()::class.java))
            }
            binding.llMyBuddies.id -> {
                startActivity(Intent(context, MyBuddiesActivity::class.java))
            }
            binding.llMyBusinessTransactions.id -> {
                startActivity(Intent(context, MyBusinessTransactionsActivity::class.java))
            }
            binding.llMyTestimonials.id -> {
                startActivity(Intent(context, MyTestimonialsActivity::class.java))
            }
            binding.llMyAwardRecognition.id -> {
                startActivity(Intent(context, MyAwardRecognitionActivity::class.java))
            }
            binding.llMyRecognitions.id -> {
                startActivity(Intent(context, MyRecognitionActivity::class.java))
            }
            binding.llMyMembershipBenefits.id -> {
                startActivity(Intent(context, MyMembershipBenefitsActivity::class.java))
            }
            binding.llShareMyProfile.id -> {

                try {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "J4E")
                    var shareMessage = "\nLet me recommend you this application\n\n"
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
            binding.llRecommendedBy.id -> {
                val intent = Intent(context, RecommendedActivity::class.java)
                intent.putExtra("type", "by")
                startActivity(intent)
            }
            binding.llRecommendedTo.id -> {
                val intent = Intent(context, RecommendedActivity::class.java)
                intent.putExtra("type", "to")
                startActivity(intent)
            }
            binding.llReferralGiven.id -> {
                startActivity(Intent(context, ReferralGivenActivity::class.java))
            }

            binding.llReferralReceived.id ->{
                startActivity(Intent(context, ReferralReceivedActivity::class.java))
            }
            binding.llMyReportCard.id -> {
                startActivity(Intent(context, MyReportCardActivity::class.java))
            }
            binding.llGuestInvited.id -> {
                //  mainActivity.onCreateClick(mainActivity.binding.toolbar.ivCreate)
                startActivity(Intent(context, MyGuestInvitesActivity::class.java))
            }
            binding.llPendingResponsibilities.id -> {
                val intent = Intent(context, PendingResponsibilitiesActivity::class.java)
                intent.putExtra("type", "0")
                intent.putExtra("search", "search")
                startActivity(intent)
            }
        }
    }


    private fun getMydiary(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_my_diary(
            readUsingSharedPreference(
                requireActivity(),
                "userid"
            ).toString()
        )
       // showLoader(requireActivity());
        call.enqueue(object : Callback<MyDiary> {
            override fun onResponse(
                call: Call<MyDiary>,
                response: Response<MyDiary>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {

                            binding.linearlayout.visibility=View.VISIBLE
                            binding.linearlayout1.visibility=View.GONE
                            binding.interested.text =
                                response.body()?.data?.get(0)?.Eventm?.get(0)?.InterestedEvent
                            binding.attended.text =
                                response.body()?.data?.get(0)?.Eventm?.get(0)?.AttendedEvent


                            binding.connsend.text =
                                response.body()?.data?.get(0)?.Connectionm?.get(0)?.SentConnection
                            binding.connreceived.text =
                                response.body()?.data?.get(0)?.Connectionm?.get(
                                    0
                                )?.ReceiveConnection

                            binding.servedd.text =
                                response.body()?.data?.get(0)?.Requirementm?.get(0)?.Saved
                            binding.open.text =
                                response.body()?.data?.get(0)?.Requirementm?.get(0)?.Open

                            binding.openlead.text =
                                response.body()?.data?.get(0)?.Leadm?.get(0)?.Open
                            binding.colselead.text =
                                response.body()?.data?.get(0)?.Leadm?.get(0)?.Closed

                            binding.openlead.text =
                                response.body()?.data?.get(0)?.Leadm?.get(0)?.Open
                            binding.colselead.text =
                                response.body()?.data?.get(0)?.Leadm?.get(0)?.Closed

                            binding.totalBuddies.text =
                                response.body()?.data?.get(0)?.Buddiesm?.get(0)?.Total

                            binding.totalposts.text =
                                response.body()?.data?.get(0)?.Postm?.get(0)?.Total

                            binding.conversion.text =
                                response.body()?.data?.get(0)?.Contributionm?.get(
                                    0
                                )?.Conversions
                            binding.revenue.text =
                                response.body()?.data?.get(0)?.Contributionm?.get(0)?.Revenue

                            binding.presents.text =
                                response.body()?.data?.get(0)?.J4EMeetsm?.get(0)?.Present
                            binding.absent.text =
                                response.body()?.data?.get(0)?.J4EMeetsm?.get(0)?.Absent


                            binding.recevied.text ="₹" +" "+
                                response.body()?.data?.get(0)?.BusinessTransactionm?.get(
                                    0
                                )?.Received
                            binding.Given.text ="₹" +" "+
                                response.body()?.data?.get(0)?.BusinessTransactionm?.get(
                                    0
                                )?.Given

                            binding.GivenTest.text =
                                response.body()?.data?.get(0)?.Testinomialm?.get(
                                    0
                                )?.Given
                            binding.recievedTest.text =
                                response.body()?.data?.get(0)?.Testinomialm?.get(
                                    0
                                )?.Received

                            binding.timesawards.text =
                                response.body()?.data?.get(0)?.Awardm?.get(0)?.Total

                            binding.recognise.text =
                                response.body()?.data?.get(0)?.Recognitionsm?.get(
                                    0
                                )?.Total

                            binding.membershipreceived.text ="₹" +" "+
                                response.body()?.data?.get(0)?.MembershipBenefits?.get(
                                    0
                                )?.Received
                            binding.membershipsaving.text ="₹" +" "+
                                response.body()?.data?.get(0)?.MembershipBenefits?.get(
                                    0
                                )?.Saving

                            binding.poplerecommdto.text =
                                response.body()?.data?.get(0)?.RecommendedTo?.get(
                                    0
                                )?.Peoples

                            binding.txtReferralGivenPending.text =
                                response.body()?.data?.get(0)?.ReferralGiven?.get(
                                    0
                                )?.Pending

                            binding.txtReferralGivenComplete.text =
                                response.body()?.data?.get(0)?.ReferralGiven?.get(
                                    0
                                )?.Complete

                            binding.txtReferralReceivedPending.text =
                                response.body()?.data?.get(0)?.ReferralReceived?.get(
                                    0
                                )?.Pending

                            binding.txtReferralReceivedCompleted.text =
                                response.body()?.data?.get(0)?.ReferralReceived?.get(
                                    0
                                )?.Complete

                            binding.timesRemommandto.text =
                                response.body()?.data?.get(0)?.RecommendedTo?.get(
                                    0
                                )?.Times

                            binding.poplerecommdBy.text =
                                response.body()?.data?.get(0)?.RecommendedBy?.get(
                                    0
                                )?.Peoples
                            binding.timesby.text =
                                response.body()?.data?.get(0)?.RecommendedBy?.get(0)?.Times

                            binding.pointsre.text =
                                response.body()?.data?.get(0)?.ReportCard?.get(0)?.Total
                            binding.Guestinites.text =
                                response.body()?.data?.get(0)?.GuestInvitedm?.get(
                                    0
                                )?.Total

                            binding.followUp.text =
                                response.body()?.data?.get(0)?.PendingResponsibilitiesm?.get(
                                    0
                                )?.FollowUP
                            binding.BuddyMeet.text =
                                response.body()?.data?.get(0)?.PendingResponsibilitiesm?.get(
                                    0
                                )?.BuddyMeet
                            binding.Leads.text =
                                response.body()?.data?.get(0)?.PendingResponsibilitiesm?.get(
                                    0
                                )?.Leads

                            storeUsingSharedPreference(
                                requireContext(),
                                "PostCountnew",response.body()?.data?.get(0)?.notification_count?.post_count.toString()
                            )

                            storeUsingSharedPreference(
                                requireContext(),
                                "LeadCountnew",response.body()?.data?.get(0)?.notification_count?.lead_count.toString()
                            )

                            storeUsingSharedPreference(
                                requireContext(),
                                "BuddyCountnew",response.body()?.data?.get(0)?.notification_count?.buddy_count.toString()
                            )

                        }
                    }
                }
            }

            override fun onFailure(call: Call<MyDiary>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    private fun showUpdateDialog(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_check_version_maintenance()
        call.enqueue(object : retrofit2.Callback<VersionResponse> {
            override fun onResponse(
                call: Call<VersionResponse>,
                response: Response<VersionResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        val api_version: String=response.body()?.data?.app_version.toString()
                        val api :Int =api_version?.toInt()
                        new_ver=response.body()?.data?.app_version_title.toString()
                        if (!readUsingSharedPreference(requireContext(),"showupdate").toString().equals("no")){
                            if(api > BuildConfig.VERSION_CODE){
                                UpdateDialog()
                            }
                        }
                    }
                }
            }

            override fun onFailure(call: Call<VersionResponse>, t: Throwable) {
                dismissLoader();
            }
        })

    }
    private fun app_check_permissions(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_home_screen_permission(readUsingSharedPreference(requireContext(), "userid").toString())
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
                                is_post_exhausted=response.body()?.data?.is_post_exhausted!!
                                is_requirement_exhausted=response.body()?.data?.is_requirement_exhausted!!
                                is_buddy_meet_exhausted=response.body()?.data?.is_buddy_meet_exhausted!!
                                is_referral_exhausted=response.body()?.data?.is_referral_exhausted!!
                                if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("1")){
                                    storeUsingSharedPreference(requireContext(),"PermissionCreatePost",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("2")){
                                    storeUsingSharedPreference(requireContext(),"PermissionCreateRequirement",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("3")){
                                    storeUsingSharedPreference(requireContext(),"PermissionCreateBuddyMeet",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("4")){
                                    storeUsingSharedPreference(requireContext(),"PermissionCreateFollowUp",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("5")){
                                    storeUsingSharedPreference(requireContext(),"PermissionCreateAddGalleryImage",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("6")){
                                    storeUsingSharedPreference(requireContext(),"PermissionConnectionRequest",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("7")){
                                    storeUsingSharedPreference(requireContext(),"PermissionCreateRecommendation",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("8")){
                                    storeUsingSharedPreference(requireContext(),"PermissionReview",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("9")){
                                    storeUsingSharedPreference(requireContext(),"PermissionViewJ4EmemberProfile",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("10")){
                                    storeUsingSharedPreference(requireContext(),"PermissionViewLeads",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("11")){
                                    storeUsingSharedPreference(requireContext(),"PermissionCreateReferral",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }
                            }
                        }else{
                            storeUsingSharedPreference(requireContext(),"PermissionCreatePost","0")
                            storeUsingSharedPreference(requireContext(),"PermissionCreateRequirement","0")
                            storeUsingSharedPreference(requireContext(),"PermissionCreateBuddyMeet","0")
                            storeUsingSharedPreference(requireContext(),"PermissionCreateFollowUp","0")
                            storeUsingSharedPreference(requireContext(),"PermissionCreateAddGalleryImage","0")
                            storeUsingSharedPreference(requireContext(),"PermissionConnectionRequest","0")
                            storeUsingSharedPreference(requireContext(),"PermissionCreateRecommendation","0")
                            storeUsingSharedPreference(requireContext(),"PermissionReview","0")
                            storeUsingSharedPreference(requireContext(),"PermissionViewJ4EmemberProfile","0")
                            storeUsingSharedPreference(requireContext(),"PermissionViewLeads","0")
                            storeUsingSharedPreference(requireContext(),"PermissionCreateReferral","0")
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
    private fun UpdateDialog(){
        //activity?.getWindow()?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mBsRecommendPersonListBinding: NewUpdateDialogBinding =
            DataBindingUtil.inflate(LayoutInflater.from(requireContext()), R.layout.new_update_dialog, null, false)
        dialog.setContentView(mBsRecommendPersonListBinding.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        mBsRecommendPersonListBinding.txtCurrentVersionName.text=new_ver

        mBsRecommendPersonListBinding.tvUpdate.setOnClickListener {
            dialog.dismiss()
            //onStartAnimation()
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.justforentrepreneurs.j4eapp"))
            startActivity(i)
        }

        //mBsRecommendPersonListBinding.tvNoThanks.setPaintFlags(mBsRecommendPersonListBinding.tvNoThanks.getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)
        mBsRecommendPersonListBinding.tvNoThanks.setOnClickListener {
            storeUsingSharedPreference(requireContext(),"showupdate","no")
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun onStartAnimation(){
        relativelayoutAnimation.visibility=View.VISIBLE
        activity?.getWindow()?.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        val animator = ValueAnimator.ofFloat(0f,-1000f)
        animator.duration=2000
        animator.start()
        animator.addUpdateListener {
            val animatedvalue=it?.animatedValue as Float
            imgRocket1.translationY=animatedvalue

        }
        Handler().postDelayed({
            CoroutineScope(Dispatchers.IO).launch {
                withContext(Dispatchers.Main) {
                    stop=true
                    activity?.getWindow()?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.justforentrepreneurs.j4eapp"))
                    startActivity(i)

                }
            }

        }, 2000) // 3000 is the delayed time in milliseconds.

    }

}