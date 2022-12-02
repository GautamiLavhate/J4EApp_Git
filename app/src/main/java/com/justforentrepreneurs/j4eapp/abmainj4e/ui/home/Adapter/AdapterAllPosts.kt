package com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.Adapter

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.BuildConfig
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterAllPostsBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.AllPosts
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.MyEventsDetailsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.PendingResponsibilitiesActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.fmt
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.readUsingSharedPreference
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class AdapterAllPosts(activity: FragmentActivity?, companyName: MutableList<AllPosts.Postdata>, onClick2: OnClick2,count_available:Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterAllPostsBinding
    private var mData:  MutableList<AllPosts.Postdata> = companyName
    var mContext: Context? = activity
    public var onClick2 = onClick2;
    var count_available1: Int =count_available

    var Clicked=true
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_all_posts,
            parent,
            false
        )
        return ItemViewHolder(
            mBinding.root,
            mBinding
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mViewHolder = holder as ItemViewHolder

        if (mData.get(position).post_type.equals("0")){ //For POST
            mViewHolder.mBinding.linearlayoutPost.visibility=View.VISIBLE
            if (mData.get(position).post_by_user_id.equals(mContext?.let { readUsingSharedPreference(it,"userid") })){
                if (mData.get(position).is_edit==1){
                    mViewHolder.mBinding.ivEditPost.visibility=View.VISIBLE
                }else{
                    mViewHolder.mBinding.ivEditPost.visibility=View.GONE
                }

            }else{
                mViewHolder.mBinding.ivEditPost.visibility=View.GONE
            }

            mViewHolder.mBinding.ivEditPost.setOnClickListener {
                onClick2.OnClickPostEdit(mData.get(position).post_id)
            }
            mViewHolder.mBinding.llComments.setOnClickListener {
                onClick2.OnClick(position,mBinding.posttotalcomment,mData,mData.get(position).post_id)
            }


            if(!(mData.get(position).post_by_user_name=="" || mData.get(position).post_by_user_name==null)) {
                mViewHolder.mBinding.fullname.setText(mData.get(position).post_by_user_name.capitalize())
            }else{
                mViewHolder.mBinding.fullname.setText("")
            }

            var time:String=mData.get(position).post_time
            val Datesub: String = mData.get(position).post_date
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
                mViewHolder.mBinding.datetime.setText(mainstr+" "+"at"+" "+time)
            } catch (e: ParseException) {
                e.printStackTrace()
            }

//        mViewHolder.mBinding.datetime.setText(mData.get(position).post_date+" at "+ mData.get(position).post_time)

            if(!(mData.get(position).post_description=="" || mData.get(position).post_description==null)) {
                mViewHolder.mBinding.description.setText(mData.get(position).post_description.capitalize())
            }else{
                mViewHolder.mBinding.description.setText("")
            }


            if(mData.get(position).post_image.equals("")){
                mBinding.postimg.visibility=View.GONE
            }else {
                mBinding.postimg.visibility=View.VISIBLE
                mContext?.let {
                    Glide.with(it)
                        .load(mData.get(position).post_image)
                        .into(mBinding.postimg)
                }
            }

            mContext?.let {
                Glide.with(it)
                    .load(mData.get(position).post_cat_icon)
                    .into(mBinding.cateimage)
            }

            mContext?.let {
                Glide.with(it)
                    .load(mData.get(position).post_by_user_image)
                    .centerCrop()
                    .into(mBinding.ivProfileImg)
            }

            if (!mData.get(position).post_by_user_id.equals(readUsingSharedPreference(mContext!!,"userid"))){
                if (mData.get(position).is_viewed==0){
                    mBinding.ivProfileImg.setBorderColor(mContext?.resources!!.getColor(R.color.red))
                }else{
                    mBinding.ivProfileImg.setBorderColor(mContext?.resources!!.getColor(R.color.imaprocessst))
                }
            }

            mViewHolder.mBinding.ivProfileImg.setOnClickListener {
                onClick2.OnClickpro(position, mData.get(position).post_by_user_id,mData.get(position).is_viewed)
            }
//            mViewHolder.mBinding.linearlayoutProfileDetail.setOnClickListener {
//                onClick2.OnClickpro(position, mData.get(position).post_by_user_id,mData.get(position).is_viewed)
//            }

            mBinding.posttotalcomment.text=mData.get(position).post_total_comment
            mBinding.totalike.text= mData.get(position).post_total_like.toString()

            if(mData.get(position).post_like_given_by_you.equals("No")){
                mData.get(position).isSelected=false
                mBinding.imagelike.setImageResource(R.drawable.ic_like)
            }else{
                mData.get(position).isSelected=true
                mBinding.imagelike.setImageResource(R.drawable.ic_like_selected)
            }

            mBinding.llLike.setOnClickListener {
                onClick2.OnClickLike(position,mData.get(position).post_id, mBinding.imagelike, mBinding.totalike,mData)
            }

            if(mData.get(position).post_description.length>100){
                mViewHolder.mBinding.collapse.visibility=View.GONE
                mViewHolder.mBinding.othersmore.visibility=View.VISIBLE
            }else{
                mViewHolder.mBinding.collapse.visibility=View.GONE
                mViewHolder.mBinding.othersmore.visibility=View.GONE
            }

            mViewHolder.mBinding.description.maxLines=5

            mViewHolder.mBinding.othersmore.setOnClickListener {
                mViewHolder.mBinding.description.maxLines=Integer.MAX_VALUE
                mViewHolder.mBinding.collapse.visibility=View.VISIBLE
                mViewHolder.mBinding.othersmore.visibility=View.GONE
                // notifyItemChanged(position)
            }

            mViewHolder.mBinding.collapse.setOnClickListener {
                mViewHolder.mBinding.description.maxLines=5
                mViewHolder.mBinding.collapse.visibility=View.GONE
                mViewHolder.mBinding.othersmore.visibility=View.VISIBLE
                onClick2.OnClickswap(position)
            }

            mViewHolder.mBinding.llShare.setOnClickListener {
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
                    mContext?.startActivity(Intent.createChooser(shareIntent, "choose one"))
                } catch (e: Exception) {
                    //e.toString();
                }
            }
        }else if (mData.get(position).post_type.equals("1")){ //For Buddy Meet
            mViewHolder.mBinding.linearlayoutBuddyMeet.visibility=View.VISIBLE
            mViewHolder.mBinding.posttotalcommentBuddyMeet.text=mData.get(position).post_total_comment.toString()
            mViewHolder.mBinding.totalikeBuddyMeet.text=mData.get(position).post_total_like.toString()
            if(mData.get(position).post_like_given_by_you.equals("No")){
                mData.get(position).isSelected=false
                mBinding.imagelikeBuddyMeet.setImageResource(R.drawable.ic_like)
            }else{
                mData.get(position).isSelected=true
                mBinding.imagelikeBuddyMeet.setImageResource(R.drawable.ic_like_selected)
            }

            mBinding.llLikeBuddyMeet.setOnClickListener {
                onClick2.OnClickLike(position,mData.get(position).post_id, mBinding.imagelikeBuddyMeet, mBinding.totalikeBuddyMeet,mData)
            }
            mContext?.let {
                Glide.with(it)
                    .load(mData.get(position).buddymeet_touserprofile)
                    .centerCrop()
                    .placeholder(R.drawable.ic_default_user_svg)
                    .into(mBinding.ivProfileImgBM)
            }

            mContext?.let {
                Glide.with(it)
                    .load(mData.get(position).buddymeet_withuserprofile)
                    .centerCrop()
                    .placeholder(R.drawable.ic_default_user_svg)
                    .into(mBinding.ivProfileImgBM2)
            }

            if (!mData.get(position).buddymeet_touserid.equals(readUsingSharedPreference(mContext!!,"userid"))){
                if (mData.get(position).is_viewed==0){
                    mBinding.ivProfileImgBM.setBorderColor(mContext?.resources!!.getColor(R.color.red))
                }else{
                    mBinding.ivProfileImgBM.setBorderColor(mContext?.resources!!.getColor(R.color.imaprocessst))
                }
            }

            mViewHolder.mBinding.llCommentsBuddyMeet.setOnClickListener {
                onClick2.OnClick(position,mBinding.posttotalcommentBuddyMeet,mData,mData.get(position).post_id)
            }

            if (!mData.get(position).buddymeet_withuserid.equals(readUsingSharedPreference(mContext!!,"userid"))){
                if (mData.get(position).is_viewed2==0){
                    mBinding.ivProfileImgBM2.setBorderColor(mContext?.resources!!.getColor(R.color.red))
                }else{
                    mBinding.ivProfileImgBM2.setBorderColor(mContext?.resources!!.getColor(R.color.imaprocessst))
                }
            }


            mViewHolder.mBinding.llLocation.visibility=View.VISIBLE
            mViewHolder.mBinding.tcLocation.setText(mData.get(position).buddymeet_location)
            if(mData.get(position).buddymeet_description.length>100){

                mViewHolder.mBinding.othersmoreBM.visibility=View.VISIBLE
            }else{
                mViewHolder.mBinding.collapse.visibility=View.GONE
                mViewHolder.mBinding.othersmoreBM.visibility=View.GONE
            }

            mViewHolder.mBinding.ivProfileImgBM.setOnClickListener {
                if (count_available1 == 0){
                    if (mData.get(position).is_viewed==0){
                        PermissionDialog(readUsingSharedPreference(mContext!!,"ViewExhaustedMsg").toString())
                    }else{
                        val intent = Intent(mContext, ProfileActivity::class.java)
                        intent.putExtra("id",mData.get(position).buddymeet_touserid)
                        intent.putExtra("type","MyLead")
                        mContext?.startActivity(intent)
                    }
                }else{
                    val intent = Intent(mContext, ProfileActivity::class.java)
                    intent.putExtra("id",mData.get(position).buddymeet_touserid)
                    intent.putExtra("type","MyLead")
                    mContext?.startActivity(intent)
                }
            }

            mViewHolder.mBinding.ivProfileImgBM2.setOnClickListener {
                if (count_available1 == 0){
                    if (mData.get(position).is_viewed2==0){
                        PermissionDialog(readUsingSharedPreference(mContext!!,"ViewExhaustedMsg").toString())
                    }else{
                        val intent = Intent(mContext, ProfileActivity::class.java)
                        intent.putExtra("id",mData.get(position).buddymeet_withuserid)
                        intent.putExtra("type","MyLead")
                        mContext?.startActivity(intent)
                    }
                }else{
                    val intent = Intent(mContext, ProfileActivity::class.java)
                    intent.putExtra("id",mData.get(position).buddymeet_withuserid)
                    intent.putExtra("type","MyLead")
                    mContext?.startActivity(intent)
                }
            }

            mViewHolder.mBinding.tvDescription.maxLines=1

            mViewHolder.mBinding.othersmoreBM.setOnClickListener {
                mViewHolder.mBinding.tvDescription.maxLines=Integer.MAX_VALUE
                mViewHolder.mBinding.collapseBM.visibility=View.VISIBLE
                mViewHolder.mBinding.othersmoreBM.visibility=View.GONE
            }

            mViewHolder.mBinding.collapseBM.setOnClickListener {
                mViewHolder.mBinding.tvDescription.maxLines=1
                mViewHolder.mBinding.collapseBM.visibility=View.GONE
                mViewHolder.mBinding.othersmoreBM.visibility=View.VISIBLE
            }

            mViewHolder.mBinding.tvDescription.setOnClickListener {
                mViewHolder.mBinding.tvDescription.maxLines=1
                mViewHolder.mBinding.collapseBM.visibility=View.GONE
                mViewHolder.mBinding.othersmoreBM.visibility=View.VISIBLE
            }

            if(!(mData.get(position).buddymeet_tousername=="" || mData.get(position).buddymeet_tousername==null)) {
                mViewHolder.mBinding.name.setText(mData.get(position).buddymeet_tousername.capitalize())
            }else{
                mViewHolder.mBinding.name.setText("")
            }

            if(!(mData.get(position).buddymeet_withusername=="" || mData.get(position).buddymeet_withusername==null)) {
                mViewHolder.mBinding.name2.setText(mData.get(position).buddymeet_withusername.capitalize())
            }else{
                mViewHolder.mBinding.name2.setText("")
            }

            if(!(mData.get(position).buddymeet_description=="" || mData.get(position).buddymeet_description==null)) {
                mViewHolder.mBinding.tvDescription.setText(mData.get(position).buddymeet_description.capitalize())
            }else{
                mViewHolder.mBinding.tvDescription.setText("")
            }

            mViewHolder.mBinding.linearlayoutBonClick.setOnClickListener {
                if (mData.get(position).buddymeet_touserid.equals(readUsingSharedPreference(mContext!!,"userid")) ||
                    mData.get(position).buddymeet_withuserid.equals(readUsingSharedPreference(mContext!!,"userid"))){
                    val intent = Intent(mContext!!, PendingResponsibilitiesActivity::class.java)
                    intent.putExtra("type", "1")
                    intent.putExtra("from","post")
                    mContext!!.startActivity(intent)
                }

            }
            val Datesub: String = mData.get(position).buddymeet_date
            val inputPattern = "yyyy-MM-dd"
            val outputPattern = "dd"
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

            mViewHolder.mBinding.dateshort.setText(mainstr)

            var time:String=mData.get(position).buddymeet_time
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
                mViewHolder.mBinding.time.setText(mainstr+" at "+time)
            } catch (e: ParseException) {
                e.printStackTrace()
            }

            mViewHolder.mBinding.weak.setText(mData.get(position).buddymeet_day)

            mViewHolder.mBinding.llShareBuddyMeet.setOnClickListener {
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
                    mContext?.startActivity(Intent.createChooser(shareIntent, "choose one"))
                } catch (e: Exception) {
                    //e.toString();
                }
            }
        }else if (mData.get(position).post_type.equals("2")){// For requirement
            mViewHolder.mBinding.linearlayoutRequirement.visibility=View.VISIBLE
            mViewHolder.mBinding.posttotalcommentRequirement.text=mData.get(position).post_total_comment.toString()
            mViewHolder.mBinding.totalikeRequirement.text=mData.get(position).post_total_like.toString()

            if(mData.get(position).post_like_given_by_you.equals("No")){
                mData.get(position).isSelected=false
                mBinding.imagelikeRequirement.setImageResource(R.drawable.ic_like)
            }else{
                mData.get(position).isSelected=true
                mBinding.imagelikeRequirement.setImageResource(R.drawable.ic_like_selected)
            }

            mBinding.llLikeRequirement.setOnClickListener {
                onClick2.OnClickLike(position,mData.get(position).post_id, mBinding.imagelikeRequirement, mBinding.totalikeRequirement,mData)
            }

            if (mData.get(position).userid.equals(readUsingSharedPreference(mContext!!,"userid"))){
                mViewHolder.mBinding.txtRequirement.text ="• Requirement •"
            }else{
                mViewHolder.mBinding.txtRequirement.text ="• Lead •"
            }
            if(!(mData.get(position).requirement_title=="" || mData.get(position).requirement_title==null)) {
                mViewHolder.mBinding.title.setText(mData.get(position).requirement_title.capitalize())
            }else{
                mViewHolder.mBinding.title.setText("")
            }

            if(!(mData.get(position).requirement_description=="" || mData.get(position).requirement_description==null)) {
                mViewHolder.mBinding.descriptionReq.setText(mData.get(position).requirement_description.capitalize())
            }else{
                mViewHolder.mBinding.descriptionReq.setText("")
            }

            var time:String=mData.get(position).created_time
            val Datesub: String = mData.get(position).created_date
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
                mViewHolder.mBinding.dobet.setText(mainstr+" "+"at"+" "+time)
            } catch (e: ParseException) {
                e.printStackTrace()
            }


            if (mData.get(position).rerquirement_thumbnail.equals("")){
                mBinding.requirementimg.visibility=View.GONE
            }else{
                mBinding.requirementimg.visibility=View.VISIBLE
                mContext?.let {
                    Glide.with(it)
                        .load(mData.get(position).rerquirement_thumbnail)
                        .into(mBinding.requirementimg)
                }
            }
            mViewHolder.mBinding.llCommentsRequirement.setOnClickListener {
                onClick2.OnClick(position,mBinding.posttotalcommentRequirement,mData,mData.get(position).post_id)
            }

            mViewHolder.itemView.setOnClickListener {

                onClick2.OnClickRequirement(position,mData.get(position).requirement_id,mData.get(position).userid)
            }

            mViewHolder.mBinding.ivShare.setOnClickListener {
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
                    mContext?.startActivity(Intent.createChooser(shareIntent, "choose one"))
                } catch (e: Exception) {
                    //e.toString();
                }
            }

            if(mData.get(position).requirement_description.length>100){
                mViewHolder.mBinding.collapseReq.visibility=View.GONE
                mViewHolder.mBinding.othersmoreReq.visibility=View.VISIBLE
            }else{
                mViewHolder.mBinding.collapseReq.visibility=View.GONE
                mViewHolder.mBinding.othersmoreReq.visibility=View.GONE
            }

            mViewHolder.mBinding.descriptionReq.maxLines=5

            mViewHolder.mBinding.othersmoreReq.setOnClickListener {
                mViewHolder.mBinding.descriptionReq.maxLines=Integer.MAX_VALUE
                mViewHolder.mBinding.collapseReq.visibility=View.VISIBLE
                mViewHolder.mBinding.othersmoreReq.visibility=View.GONE
                // notifyItemChanged(position)
            }

            mViewHolder.mBinding.collapseReq.setOnClickListener {
                mViewHolder.mBinding.descriptionReq.maxLines=5
                mViewHolder.mBinding.collapseReq.visibility=View.GONE
                mViewHolder.mBinding.othersmoreReq.visibility=View.VISIBLE
                onClick2.OnClickswap(position)
            }
            mViewHolder.mBinding.llShareRequirement.setOnClickListener {
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
                    mContext?.startActivity(Intent.createChooser(shareIntent, "choose one"))
                } catch (e: Exception) {
                    //e.toString();
                }
            }

        }else if (mData.get(position).post_type.equals("3")){//For event
            mViewHolder.mBinding.linearlayoutEvent.visibility=View.VISIBLE
            mViewHolder.mBinding.posttotalcommentEvent.text=mData.get(position).post_total_comment.toString()
            mViewHolder.mBinding.totalikeEvent.text=mData.get(position).post_total_like.toString()

            if(mData.get(position).post_like_given_by_you.equals("No")){
                mData.get(position).isSelected=false
                mBinding.imagelikeEvent.setImageResource(R.drawable.ic_like)
            }else{
                mData.get(position).isSelected=true
                mBinding.imagelikeEvent.setImageResource(R.drawable.ic_like_selected)
            }

            mBinding.llLikeEvent.setOnClickListener {
                onClick2.OnClickLike(position,mData.get(position).post_id, mBinding.imagelikeEvent, mBinding.totalikeEvent,mData)
            }

            mContext?.let {
                Glide.with(it)
                    .load(mData.get(position).event_thumbnil)
                    .centerCrop()
                    .into(mBinding.ivImg)
            }

            if(!(mData.get(position).event_title=="" || mData.get(position).event_title==null)) {
                mBinding.eventtitle.setText(mData.get(position).event_title.capitalize())
            }

            mBinding.datetimeEvent.setText(mData.get(position).event_startdate)


            if(!(mData.get(position).event_address=="" || mData.get(position).event_address==null)) {
                mBinding.address.setText(mData.get(position).event_address.capitalize())
            }



            if(!readUsingSharedPreference(mContext!!, "membertyype").toString().equals("1")) {

                mBinding.amount.setText("₹ " + fmt(mData.get(position).event_fees))
            }else{
                mBinding.amount.setText("₹ " + fmt(mData.get(position).event_guest_fees))
            }

            mViewHolder.mBinding.llCommentsEvent.setOnClickListener {
                onClick2.OnClick(position,mBinding.posttotalcommentEvent,mData,mData.get(position).post_id)
            }
            mBinding.eventDetailsRelLay.setOnClickListener(View.OnClickListener {
                val intent = Intent(mContext, MyEventsDetailsActivity::class.java)
                intent.putExtra("type","past")
                intent.putExtra("Back","activity")
                intent.putExtra("id", mData.get(position).event_id)
                mContext!!.startActivity(intent)
            })

            mViewHolder.mBinding.llShareEvent.setOnClickListener {
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
                    mContext?.startActivity(Intent.createChooser(shareIntent, "choose one"))
                } catch (e: Exception) {
                    //e.toString();
                }
            }
        }


    }

    fun updateData(position: Int) {
       notifyItemInserted(position)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }


    override fun getItemCount(): Int {
        return mData.size
    }

    interface OnClick2 {
        fun OnClickswap(position: Int)
        fun OnClick(position: Int,txt:TextView,companyName: MutableList<AllPosts.Postdata>,postid:String)
        fun OnClickpro(position: Int,data:String,is_viewed:Int)
        fun OnClickLike(position: Int,data:String,img:ImageView,txt:TextView,companyName: MutableList<AllPosts.Postdata>)
        fun OnClickPostEdit(post_id:String)
        fun OnClickRequirement(position: Int,data:String,user_id:String)
    }

    class ItemViewHolder internal constructor(itemView: View?, val mBinding: AdapterAllPostsBinding
    ) : RecyclerView.ViewHolder(itemView!!)
    private fun PermissionDialog(massage:String){
        val dialog = Dialog(mContext!!)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mbsAddAccountDialog: PlanexpaireddialogBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.planexpaireddialog, null, false)
        dialog.setContentView(mbsAddAccountDialog.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        mbsAddAccountDialog.massage.setText(massage)

        mbsAddAccountDialog.okbtd.setOnClickListener {
            dialog.dismiss()
        }
        mbsAddAccountDialog.txtUpgrade.setOnClickListener {
            dialog.dismiss()
            mContext?.startActivity(Intent(mContext, MyMembershipBenefitsActivity::class.java))
        }
        dialog.show()
    }
}