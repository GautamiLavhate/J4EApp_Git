package com.justforentrepreneurs.j4eapp.abmainj4e.ui.home

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseFragment
import com.justforentrepreneurs.j4eapp.databinding.BsCommentListBinding
import com.justforentrepreneurs.j4eapp.databinding.FragAllPostsBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.Adapter.AdapterAllPosts
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.Adapter.AdapterCommentList
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.*
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.MyLeadsDetailActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.CreatePostsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.permissions.PermissionsResponse
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class FragAllPosts(position:Int) : BaseFragment(), AdapterAllPosts.OnClick2,AdapterCommentList.OnClick2 {

    private lateinit var binding: FragAllPostsBinding
    private var mContext: Context? = null
    var mActivity: MainActivity? = null
    var count:String=""
    private val position:Int=position
    var is_post_exhausted: Int = -1
    var is_requirement_exhausted: Int = -1
    var is_buddy_meet_exhausted: Int = -1
    var is_referral_exhausted: Int = -1
    var count_available: Int = -1
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_all_posts, container, false)
        mContext = activity;
        mActivity = mContext as MainActivity
        recyclerData()
        return binding.root
    }

    private fun recyclerData() {
        val anim: Animation = AnimationUtils.loadAnimation(requireActivity(), android.R.anim.fade_in)
        binding.linearlayout.startAnimation(anim)

        val layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.rvAllPosts.layoutManager = layoutManager

        if(isInternetAvailable(requireActivity())){
            getAllPosts()
            app_check_permissions()
        }

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
    override fun OnClickswap(position: Int) {
        binding.rvAllPosts.getLayoutManager()?.scrollToPosition(position);
    }


    override fun OnClick(position: Int, txt: TextView, companyName: MutableList<AllPosts.Postdata>, postid: String) {
      bottomSheetCommentList(position,txt,companyName,postid)
    }

    override fun OnClickpro(position: Int, data: String, is_viewed: Int) {
        if (count_available == 0){
            if (is_viewed==0){
                PermissionDialog(readUsingSharedPreference(requireContext(),"ViewExhaustedMsg").toString())
            }else{
                val intent = Intent(requireActivity(), ProfileActivity::class.java)
                intent.putExtra("id", data)
                intent.putExtra("type", "AllPost")
                intent.putExtra("position",position.toString())
                startActivity(intent)
            }
        }else{
            val intent = Intent(requireActivity(), ProfileActivity::class.java)
            intent.putExtra("id", data)
            intent.putExtra("type", "AllPost")
            intent.putExtra("position",position.toString())
            startActivity(intent)
        }

    }

    override fun OnClickLike(position: Int, data: String, img: ImageView, txt: TextView, companyName: MutableList<AllPosts.Postdata>) {
         if(isInternetAvailable(requireActivity())){
             getLikeunlikePosts(data, img, txt, companyName, position)
         }
    }

    override fun OnClickPostEdit(post_id: String) {
        val intent = Intent(requireContext(), CreatePostsActivity::class.java)
        intent.putExtra("type","edit")
        intent.putExtra("id",post_id)
        startActivity(intent)
    }

    override fun OnClickRequirement(position: Int, data: String,userid: String) {
        if (userid.equals(readUsingSharedPreference(requireContext(),"userid"))){
            val intent = Intent(requireActivity(), MyLeadsDetailActivity::class.java)
            intent.putExtra("type", "requirement")
            intent.putExtra("id",data)
            startActivity(intent)
        }else{
            val intent = Intent(requireActivity(), MyLeadsDetailActivity::class.java)
            intent.putExtra("type", "MyLead")
            intent.putExtra("id",data)
            startActivity(intent)
        }

    }

    private fun getAllPosts(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_all_posts(readUsingSharedPreference(requireActivity(), "userid").toString())
        //showLoader(requireActivity());
        call.enqueue(object : Callback<AllPosts> {
            override fun onResponse(
                    call: Call<AllPosts>,
                    response: Response<AllPosts>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        count_available=response.body()?.count_available!!
                        if (response.body()?.data != null) {
                            storeUsingSharedPreference(
                                requireActivity(),
                                "PostCountOld", response.body()?.data?.size.toString()
                            )
                            binding.linearlayout.visibility=View.GONE
                            binding.rvAllPosts.visibility = View.VISIBLE
                            binding.NoLeadInvited.visibility = View.GONE
                            val mAdapter = AdapterAllPosts(
                                    activity,
                                    response.body()?.data as MutableList<AllPosts.Postdata>,
                                this@FragAllPosts,count_available
                            )
                            binding.rvAllPosts.adapter = mAdapter
                            binding.rvAllPosts.getLayoutManager()?.scrollToPosition(position);
                            (binding.rvAllPosts.adapter as AdapterAllPosts).notifyDataSetChanged()


                        }
                    } else {
                        binding.rvAllPosts.visibility = View.GONE
                        binding.linearlayout.visibility=View.GONE
                        binding.NoLeadInvited.visibility = View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<AllPosts>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    private fun getLikeunlikePosts(data: String, img: ImageView, txt: TextView, companyName: MutableList<AllPosts.Postdata>, position: Int){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_user_check_like_status(readUsingSharedPreference(requireActivity(), "userid").toString(), data)
        showLoader(requireActivity());
        call.enqueue(object : Callback<LikePost> {
            override fun onResponse(
                    call: Call<LikePost>,
                    response: Response<LikePost>
            ) {
                dismissLoader()
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            if (companyName.get(position).isSelected == false) {
                                companyName.get(position).isSelected = true
                                img.setImageResource(R.drawable.ic_like_selected)
                            } else {
                                companyName.get(position).isSelected = false
                                img.setImageResource(R.drawable.ic_like)
                            }
                            txt.text = response.body()?.data?.get(0)?.TotalLike
                            if (companyName.get(position).post_type.equals("0")){
                                val data = AllPosts.Postdata(companyName.get(position).post_id, companyName.get(position).post_cat_name,
                                    companyName.get(position).post_cat_icon, companyName.get(position).post_by_user_name,
                                    companyName.get(position).post_by_user_image, companyName.get(position).post_description,
                                    companyName.get(position).post_date, companyName.get(position).post_time,
                                    companyName.get(position).post_image,
                                    companyName.get(position).post_total_comment, response.body()?.data?.get(0)?.TotalLike?.toInt()!!,
                                    response.body()?.data?.get(0)?.LikeGiven.toString(), companyName.get(position).post_by_user_id,
                                    true,companyName.get(position).is_viewed,companyName.get(position).is_edit,
                                    companyName.get(position).post_type,"","","",
                                    "","","","",
                                    "","","","","",
                                    companyName.get(position).is_viewed2,"","","",
                                    "","","","","",
                                    "","","","","","",
                                    "","","","","",
                                    "","","","",
                                    "","","","",
                                    "","","","","",
                                    "","","","","","","","")
                                companyName.set(position, data)
                            }else if (companyName.get(position).post_type.equals("1")){
                                val data = AllPosts.Postdata(companyName.get(position).post_id,
                                    "", "", "",
                                    "", "",
                                    "","",
                                    "", companyName.get(position).post_total_comment,
                                    response.body()?.data?.get(0)?.TotalLike?.toInt()!!,
                                    response.body()?.data?.get(0)?.LikeGiven.toString(),
                                    "", true,
                                    companyName.get(position).is_viewed,companyName.get(position).is_edit,
                                    companyName.get(position).post_type,companyName.get(position).buddymeet_id,
                                    companyName.get(position).buddymeet_description,companyName.get(position).buddymeet_location,
                                    companyName.get(position).buddymeet_date,companyName.get(position).buddymeet_time,
                                    companyName.get(position).buddymeet_day,companyName.get(position).buddymeet_touserid,
                                    companyName.get(position).buddymeet_tousername,
                                    companyName.get(position).buddymeet_touserprofile,companyName.get(position).buddymeet_withuserid,
                                    companyName.get(position).buddymeet_withusername,companyName.get(position).buddymeet_withuserprofile,
                                    companyName.get(position).is_viewed2,"","","",
                                    "","","","","",
                                    "","","","","","",
                                    "","","","","",
                                    "","","","",
                                    "","","","",
                                    "","","","","",
                                    "","","",companyName.get(position).chat_id,"",
                                    "","","")
                                companyName.set(position, data)
                            }else if (companyName.get(position).post_type.equals("2")){
                                if(companyName.get(position).dob != null){
                                    val data = AllPosts.Postdata(companyName.get(position).post_id,
                                        "", "", "",
                                        "", "",
                                        "","",
                                        "", companyName.get(position).post_total_comment,
                                        response.body()?.data?.get(0)?.TotalLike?.toInt()!!,
                                        response.body()?.data?.get(0)?.LikeGiven.toString(),
                                        "", true,
                                        companyName.get(position).is_viewed,0,
                                        companyName.get(position).post_type,"",
                                        "","",
                                        "","",
                                        "","",
                                        "",
                                        "","",
                                        "","",
                                        0,companyName.get(position).userid,
                                        companyName.get(position).requirement_id,
                                        companyName.get(position).requirement_title,
                                        companyName.get(position).requirement_description,companyName.get(position).rerquirement_thumbnail,
                                        companyName.get(position).created_date,companyName.get(position).created_time,
                                        companyName.get(position).full_name,
                                        companyName.get(position).email,companyName.get(position).mobile,companyName.get(position).designation,
                                        companyName.get(position).company_name,companyName.get(position).company_phone,
                                        companyName.get(position).company_address,
                                        companyName.get(position).dob,companyName.get(position).profile_pic,"","","",
                                        "","","","",
                                        "","","","",
                                        "","","","","",
                                        "","","","","",
                                        "","","")
                                    companyName.set(position, data)
                                }

                            }else if (companyName.get(position).post_type.equals("3")){
                                val data = AllPosts.Postdata(companyName.get(position).post_id,
                                    "", "", "",
                                    "", "",
                                    "","",
                                    "", companyName.get(position).post_total_comment,
                                    response.body()?.data?.get(0)?.TotalLike?.toInt()!!,
                                    response.body()?.data?.get(0)?.LikeGiven.toString(),
                                    "", true,
                                    0,0,
                                    companyName.get(position).post_type,"",
                                    "","",
                                    "","",
                                    "","",
                                    "",
                                    "","",
                                    "","",
                                    0,"", "", "",
                                    "","",
                                    "","", "",
                                    "","","",
                                    "","", "",
                                    "","",companyName.get(position).event_id,
                                    companyName.get(position).event_cat_id,"",
                                    companyName.get(position).event_title,companyName.get(position).event_address,
                                    companyName.get(position).event_shortabout,companyName.get(position).event_about,
                                    companyName.get(position).event_latitude,companyName.get(position).event_longitude,
                                    companyName.get(position).event_phno,companyName.get(position).event_date,
                                    companyName.get(position).event_startdate,companyName.get(position).event_enddate,
                                    companyName.get(position).event_fees,companyName.get(position).event_guest_fees,
                                    companyName.get(position).event_thumbnil,
                                    companyName.get(position).event_creatdate,companyName.get(position).event_creattime,
                                    companyName.get(position).event_organized_by,companyName.get(position).chat_id,
                                    companyName.get(position).event_booked_byuser,
                                    companyName.get(position).event_type,companyName.get(position).event_publish_status,companyName.get(position).membership_type)
                                companyName.set(position, data)
                            }


                            binding.rvAllPosts.adapter?.notifyItemChanged(position)
                            binding.rvAllPosts.getLayoutManager()?.scrollToPosition(position);

                        }
                    } else {
                        displayToast(requireActivity(), response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<LikePost>, t: Throwable) {
                dismissLoader()
                displayToast(requireActivity(), requireActivity().resources.getString(R.string.error_something_wrong))
            }
        })

    }

    fun bottomSheetCommentList(position: Int,txt: TextView,companyName: MutableList<AllPosts.Postdata>,postid:String) {
        val dialog = BottomSheetDialog(requireActivity(), R.style.CustomBottomSheetDialogTheme)
        val mBSRewardListBinding: BsCommentListBinding = DataBindingUtil.inflate(LayoutInflater.from(requireActivity()), R.layout.bs_comment_list, null, false)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(mBSRewardListBinding.root)
        val layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        mBSRewardListBinding.rvCommentList.layoutManager = layoutManager
        getPostsComments(mBSRewardListBinding, postid,companyName,position)
        dialog.show()
        mBSRewardListBinding.sendcommet.setOnClickListener {
            SendPostsComments(mBSRewardListBinding, postid,companyName,position)
            dialog.dismiss()
            getAllPosts()

        }

        mBSRewardListBinding.ivClose.setOnClickListener {
            dialog.dismiss()
            getPostsComments(mBSRewardListBinding, postid,companyName,position)
            binding.rvAllPosts.getLayoutManager()?.scrollToPosition(position);
        }

    }

    private fun getPostsComments(mBSRewardListBinding: BsCommentListBinding, postid: String,companyName: MutableList<AllPosts.Postdata>,position: Int){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_all_posts_comment(postid)
        call.enqueue(object : Callback<PostGetComments> {
            override fun onResponse(
                    call: Call<PostGetComments>,
                    response: Response<PostGetComments>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            count=""
                            count=response.body()?.data?.get(0)?.Count.toString()
                            mBSRewardListBinding.linearlayout1.visibility=View.GONE
                            mBSRewardListBinding.rvCommentList.visibility=View.VISIBLE
                            if (companyName.get(position).post_type.equals("0")){
                                val data = AllPosts.Postdata(companyName.get(position).post_id, companyName.get(position).post_cat_name,
                                    companyName.get(position).post_cat_icon, companyName.get(position).post_by_user_name,
                                    companyName.get(position).post_by_user_image, companyName.get(position).post_description,
                                    companyName.get(position).post_date, companyName.get(position).post_time,
                                    companyName.get(position).post_image, count,
                                    companyName.get(position).post_total_like?.toInt()!!,
                                    companyName.get(position).post_like_given_by_you.toString(),
                                    companyName.get(position).post_by_user_id, true,
                                    companyName.get(position).is_viewed,companyName.get(position).is_edit,
                                    companyName.get(position).post_type,"","","",
                                    "","","","","",
                                    "","","","",
                                    companyName.get(position).is_viewed2,"","","",
                                    "","","","","",
                                    "","","","","","",
                                    "","","","","",
                                    "","","","",
                                    "","","","",
                                    "","","","","",
                                    "","","","","","","","")
                                companyName.set(position, data)
                            }else if (companyName.get(position).post_type.equals("1")){
                                val data = AllPosts.Postdata(companyName.get(position).post_id,
                                    "", "", "",
                                    "", "",
                                    "","",
                                    "", companyName.get(position).post_total_comment,
                                    companyName.get(position).post_total_like,
                                    companyName.get(position).post_like_given_by_you,
                                    "", true,
                                    companyName.get(position).is_viewed,companyName.get(position).is_edit,
                                    companyName.get(position).post_type,companyName.get(position).buddymeet_id,
                                    companyName.get(position).buddymeet_description,companyName.get(position).buddymeet_location,
                                    companyName.get(position).buddymeet_date,companyName.get(position).buddymeet_time,
                                    companyName.get(position).buddymeet_day,companyName.get(position).buddymeet_touserid,
                                    companyName.get(position).buddymeet_tousername,
                                    companyName.get(position).buddymeet_touserprofile,companyName.get(position).buddymeet_withuserid,
                                    companyName.get(position).buddymeet_withusername,companyName.get(position).buddymeet_withuserprofile,
                                    companyName.get(position).is_viewed2,"","","",
                                    "","","","","",
                                    "","","","","","",
                                    "","","","","",
                                    "","","","",
                                    "","","","",
                                    "","","","","",
                                    "","","",companyName.get(position).chat_id,"",
                                    "","","")
                                companyName.set(position, data)
                            }else if (companyName.get(position).post_type.equals("2")){
                                if(companyName.get(position).dob != null){
                                    val data = AllPosts.Postdata(companyName.get(position).post_id,
                                        "", "", "",
                                        "", "",
                                        "","",
                                        "", companyName.get(position).post_total_comment,
                                        companyName.get(position).post_total_like,
                                        companyName.get(position).post_like_given_by_you,
                                        "", true,
                                        companyName.get(position).is_viewed,0,
                                        companyName.get(position).post_type,"",
                                        "","",
                                        "","",
                                        "","",
                                        "",
                                        "","",
                                        "","",
                                        0,companyName.get(position).userid,
                                        companyName.get(position).requirement_id,
                                        companyName.get(position).requirement_title,
                                        companyName.get(position).requirement_description,companyName.get(position).rerquirement_thumbnail,
                                        companyName.get(position).created_date,companyName.get(position).created_time,
                                        companyName.get(position).full_name,
                                        companyName.get(position).email,companyName.get(position).mobile,companyName.get(position).designation,
                                        companyName.get(position).company_name,companyName.get(position).company_phone,
                                        companyName.get(position).company_address,
                                        companyName.get(position).dob,companyName.get(position).profile_pic,"","","",
                                        "","","","",
                                        "","","","",
                                        "","","","","",
                                        "","","","","",
                                        "","","")
                                    companyName.set(position, data)
                                }

                            }else if (companyName.get(position).post_type.equals("3")){
                                val data = AllPosts.Postdata(companyName.get(position).post_id,
                                    "", "", "",
                                    "", "",
                                    "","",
                                    "", companyName.get(position).post_total_comment,
                                    companyName.get(position).post_total_like,
                                    companyName.get(position).post_like_given_by_you,
                                    "", true,
                                    0,0,
                                    companyName.get(position).post_type,"",
                                    "","",
                                    "","",
                                    "","",
                                    "",
                                    "","",
                                    "","",
                                    0,"", "", "",
                                    "","",
                                    "","", "",
                                    "","","",
                                    "","", "",
                                    "","",companyName.get(position).event_id,
                                    companyName.get(position).event_cat_id,"",
                                    companyName.get(position).event_title,companyName.get(position).event_address,
                                    companyName.get(position).event_shortabout,companyName.get(position).event_about,
                                    companyName.get(position).event_latitude,companyName.get(position).event_longitude,
                                    companyName.get(position).event_phno,companyName.get(position).event_date,
                                    companyName.get(position).event_startdate,companyName.get(position).event_enddate,
                                    companyName.get(position).event_fees,companyName.get(position).event_guest_fees,
                                    companyName.get(position).event_thumbnil,
                                    companyName.get(position).event_creatdate,companyName.get(position).event_creattime,
                                    companyName.get(position).event_organized_by,companyName.get(position).chat_id,
                                    companyName.get(position).event_booked_byuser,
                                    companyName.get(position).event_type,companyName.get(position).event_publish_status,companyName.get(position).membership_type)
                                companyName.set(position, data)
                            }




                            binding.rvAllPosts.adapter?.notifyItemChanged(position)
                            val mAdapter = AdapterCommentList(
                                    requireActivity(),
                                    response.body()?.data?.get(0)?.CommentData as MutableList<PostGetComments.DataGet.DataGetData>, this@FragAllPosts)
                            mBSRewardListBinding.rvCommentList.adapter = mAdapter
                            (mBSRewardListBinding.rvCommentList.adapter as AdapterCommentList).notifyDataSetChanged()

                        }
                    } else {
                        mBSRewardListBinding.linearlayout1.visibility=View.GONE
                        mBSRewardListBinding.rvCommentList.visibility=View.VISIBLE

                    }
                }
            }

            override fun onFailure(call: Call<PostGetComments>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    private fun SendPostsComments(mBSRewardListBinding: BsCommentListBinding, postid: String,companyName: MutableList<AllPosts.Postdata>,position: Int){
        val request = ServiceBuilder.buildService(APIinterface::class.java)

        val sdf = SimpleDateFormat("dd-MM-yyyy")
        val currentDate = sdf.format(Date())

        val sdf1 = SimpleDateFormat("hh:mm aa")
        val currenttime1 = sdf1.format(Date())

        val call = request.app_create_posts_comment(readUsingSharedPreference(requireActivity(), "userid").toString(), postid, mBSRewardListBinding.writeamsg.text.toString(), currentDate, currenttime1)
        showLoader(requireActivity())
        call.enqueue(object : Callback<ConnectionDecline> {
            override fun onResponse(
                    call: Call<ConnectionDecline>,
                    response: Response<ConnectionDecline>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        displayToast(requireActivity(), response.body()?.message.toString())
                        mBSRewardListBinding.writeamsg.setText("")
                        getPostsComments(mBSRewardListBinding, postid,companyName,position)
                    } else {
                        displayToast(requireActivity(), response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    override fun OnClickpro(position: Int, data: String) {
        val intent = Intent(requireActivity(), ProfileActivity::class.java)
        intent.putExtra("id", data)
        intent.putExtra("type", "AllPost")
        intent.putExtra("position",position.toString())
        startActivity(intent)
    }

    private fun PermissionDialog(massage:String){
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mbsAddAccountDialog: PlanexpaireddialogBinding = DataBindingUtil.inflate(LayoutInflater.from(requireContext()),R.layout.planexpaireddialog, null, false)
        dialog.setContentView(mbsAddAccountDialog.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        mbsAddAccountDialog.massage.setText(massage)

        mbsAddAccountDialog.okbtd.setOnClickListener {
            dialog.dismiss()
        }
        mbsAddAccountDialog.txtUpgrade.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(requireContext(), MyMembershipBenefitsActivity::class.java))
        }
        dialog.show()
    }

    override fun onResume() {
        super.onResume()
        getAllPosts()
    }
}