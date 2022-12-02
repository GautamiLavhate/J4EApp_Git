package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myposts

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
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
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyPostsBinding
import com.justforentrepreneurs.j4eapp.databinding.BsCommentListBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.Adapter.AdapterAllPosts
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.Adapter.AdapterCommentList
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.AllPosts
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.LikePost
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.PostGetComments
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.MyLeadsDetailActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.CreatePostsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.EventStatusActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class MyPostsActivity : BaseActivity(), AdapterAllPosts.OnClick2,AdapterCommentList.OnClick2  {
    private lateinit var binding: ActivityMyPostsBinding
    var count:String=""
    override fun enablePresence(): Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_posts)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.my_post)

        binding.toolbar.ivBack.setOnClickListener {
            onBackPressed()
        }

        recyclerData()
    }

    private fun recyclerData() {
        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvAllPosts.layoutManager = layoutManager
        if (isInternetAvailable(this)) {
            getAllPosts()
        }
    }

    override fun OnClickswap(position: Int) {
        binding.rvAllPosts.getLayoutManager()?.scrollToPosition(position)
    }


    override fun OnClick(position: Int, txt: TextView, companyName: MutableList<AllPosts.Postdata>, postid: String) {
        bottomSheetCommentList(position,txt,companyName,postid)
    }

    override fun OnClickpro(position: Int, data: String, is_viewed: Int) {
        val intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra("id",data)
        intent.putExtra("type","MyLead")
        startActivity(intent)

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
    override fun OnClickLike(position: Int, data: String, img: ImageView, txt: TextView, companyName: MutableList<AllPosts.Postdata>) {
        if(isInternetAvailable(this@MyPostsActivity)){
           getLikeunlikePosts(data, img,txt,companyName,position)
        }
    }

    override fun OnClickPostEdit(post_id: String) {
        val intent = Intent(this, CreatePostsActivity::class.java)
        intent.putExtra("type","edit")
        intent.putExtra("id",post_id)
        startActivity(intent)
    }

    override fun OnClickRequirement(position: Int, data: String,userid:String) {
        val intent = Intent(this, MyLeadsDetailActivity::class.java)
        intent.putExtra("type", "requirement")
        intent.putExtra("id",data)
        startActivity(intent)
    }

    private fun getAllPosts(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_my_posts(readUsingSharedPreference(this, "userid").toString())
        call.enqueue(object : Callback<AllPosts> {
            override fun onResponse(
                call: Call<AllPosts>,
                response: Response<AllPosts>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            binding.linearlayout1.visibility = View.GONE
                            binding.rvAllPosts.visibility= View.VISIBLE
                            binding.NoLeadInvited.visibility= View.GONE
                            val mAdapter = AdapterAllPosts(
                                this@MyPostsActivity,
                                response.body()?.data as MutableList<AllPosts.Postdata>, this@MyPostsActivity,
                                response.body()?.count_available!!
                            )
                            binding.rvAllPosts.adapter = mAdapter
                            (binding.rvAllPosts.adapter as AdapterAllPosts).notifyDataSetChanged()

                        }else{
                            binding.linearlayout1.visibility = View.GONE
                        }
                    }else{
                        binding.linearlayout1.visibility = View.GONE
                        binding.rvAllPosts.visibility= View.GONE
                        binding.NoLeadInvited.visibility= View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<AllPosts>, t: Throwable) {
                dismissLoader();

            }
        })

    }

    private fun getLikeunlikePosts(data: String,img: ImageView, txt: TextView,companyName: MutableList<AllPosts.Postdata>,position: Int){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_user_check_like_status(readUsingSharedPreference(this@MyPostsActivity, "userid").toString(),data)
        showLoader(this@MyPostsActivity)
        call.enqueue(object : Callback<LikePost> {
            override fun onResponse(
                call: Call<LikePost>,
                response: Response<LikePost>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {

                            if (companyName.get(position).isSelected==false) {
                                companyName.get(position).isSelected=true
                                img.setImageResource(R.drawable.ic_like_selected)
                            } else {
                                companyName.get(position).isSelected=false
                                img.setImageResource(R.drawable.ic_like)
                            }
                            txt.text = response.body()?.data?.get(0)?.TotalLike

                            val data = AllPosts.Postdata(companyName.get(position).post_id, companyName.get(position).post_cat_name,
                                companyName.get(position).post_cat_icon,companyName.get(position).post_by_user_name,
                                companyName.get(position).post_by_user_image, companyName.get(position).post_description,
                                companyName.get(position).post_date, companyName.get(position).post_time,
                                companyName.get(position).post_image,companyName.get(position).post_total_comment,
                                response.body()?.data?.get(0)?.TotalLike?.toInt()!!,response.body()?.data?.get(0)?.LikeGiven.toString(),
                                companyName.get(position).post_by_user_id,
                                true,companyName.get(position).is_viewed,companyName.get(position).is_edit,
                                companyName.get(position).post_type,"","","","",
                                "","","","","","","","",
                                companyName.get(position).is_viewed2,"","","",
                                "","","","","",
                                "","","","","","",
                                "","","","","",
                                "","","","",
                                "","","","",
                                "","","","","",
                                "","","","","","","","")
                            companyName.set(position, data)


                            binding.rvAllPosts.adapter?.notifyItemChanged(position)

                            //  displayToast(requireActivity(),response.body()?.message.toString())
                        }
                    }else{
                        displayToast(this@MyPostsActivity,response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<LikePost>, t: Throwable) {
                dismissLoader();

            }
        })

    }

    //comment

    fun bottomSheetCommentList(position: Int,txt: TextView,companyName: MutableList<AllPosts.Postdata>,postid:String) {
        val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
        val mBSRewardListBinding: BsCommentListBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.bs_comment_list, null, false)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(mBSRewardListBinding.root)
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mBSRewardListBinding.rvCommentList.layoutManager = layoutManager
        getPostsComments(mBSRewardListBinding, postid,companyName,position)
        dialog.show()

        mBSRewardListBinding.sendcommet.setOnClickListener {
            SendPostsComments(mBSRewardListBinding, postid,companyName,position)
            dialog.dismiss()
            getAllPosts()
        }

        mBSRewardListBinding.ivClose.setOnClickListener {
            getPostsComments(mBSRewardListBinding, postid,companyName,position)
            dialog.dismiss()
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
                            val data = AllPosts.Postdata(companyName.get(position).post_id, companyName.get(position).post_cat_name,
                                companyName.get(position).post_cat_icon, companyName.get(position).post_by_user_name,
                                companyName.get(position).post_by_user_image, companyName.get(position).post_description,
                                companyName.get(position).post_date, companyName.get(position).post_time,
                                companyName.get(position).post_image, count,companyName.get(position).post_total_like?.toInt()!!,
                                companyName.get(position).post_like_given_by_you.toString(), companyName.get(position).post_by_user_id,
                                true,companyName.get(position).is_viewed,companyName.get(position).is_edit,
                                companyName.get(position).post_type,"","","","",
                                "","","","","","","","",
                                companyName.get(position).is_viewed2,"","","",
                                "","","","","",
                                "","","","","","",
                                "","","","","",
                                "","","","",
                                "","","","",
                                "","","","","",
                                "","","","","","","","")
                            companyName.set(position, data)



                            binding.rvAllPosts.adapter?.notifyItemChanged(position)
                            val mAdapter = AdapterCommentList(
                                    this@MyPostsActivity,
                                    response.body()?.data?.get(0)?.CommentData as MutableList<PostGetComments.DataGet.DataGetData>,this@MyPostsActivity)
                            mBSRewardListBinding.rvCommentList.adapter = mAdapter
                            (mBSRewardListBinding.rvCommentList.adapter as AdapterCommentList).notifyDataSetChanged()

                        }
                    }else{
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

        val sdf1 = SimpleDateFormat("hh:mm a")
        val currenttime1 = sdf1.format(Date())

        val call = request.app_create_posts_comment(readUsingSharedPreference(this, "userid").toString(),postid,mBSRewardListBinding.writeamsg.text.toString(),currentDate,currenttime1)
        showLoader(this)
        call.enqueue(object : Callback<ConnectionDecline> {
            override fun onResponse(
                    call: Call<ConnectionDecline>,
                    response: Response<ConnectionDecline>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        displayToast(this@MyPostsActivity,response.body()?.message.toString())
                        mBSRewardListBinding.writeamsg.setText("")
                        getPostsComments(mBSRewardListBinding, postid,companyName,position)
                    }else{
                        displayToast(this@MyPostsActivity,response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                dismissLoader();

            }
        })

    }

    override fun OnClickpro(position: Int, data: String) {
        val intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra("id",data)
        intent.putExtra("type","MyLead")
        startActivity(intent)
    }
}