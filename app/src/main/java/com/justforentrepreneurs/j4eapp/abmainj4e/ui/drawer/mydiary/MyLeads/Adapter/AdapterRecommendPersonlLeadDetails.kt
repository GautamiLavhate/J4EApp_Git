package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.Adapter

import android.content.Context
import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.RecommendedPersonRvAdapterBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.MyLeadsDetailActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.MyLeadsStatusListActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model.RecomendedBy
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model.UserData
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.readUsingSharedPreference
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.wordFirstCap
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class AdapterRecommendPersonlLeadDetails(activity: FragmentActivity?,companyName: MutableList<UserData>,leadreqheck:String,requiredid:String,onClick2:MyLeadsDetailActivity) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: RecommendedPersonRvAdapterBinding
    private var mData:MutableList<UserData> = companyName
    var mContext: Context? = activity
    var Leadcheck:String=leadreqheck
    var requiredids:String=requiredid
    var onClick3 = onClick2


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.recommended_person_rv_adapter, parent, false)
        return ItemViewHolder(mBinding.root, mBinding)
    }
    interface OnClick2 {
        fun OnClick(position: Int,data:String,is_viewed:Int)
        fun OnClickDialog(position: Int,companyName: MutableList<RecomendedBy>)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mViewHolder = holder as ItemViewHolder
        if(!(mData.get(position).full_name=="" || mData.get(position).full_name==null)) {
            mViewHolder.mBinding.nameTV.setText(wordFirstCap(mData.get(position).full_name))
        }else{
            mViewHolder.mBinding.nameTV.setText("")
        }

        if(!(mData.get(position).recomendation_note=="" || mData.get(position).recomendation_note==null)) {
            mViewHolder.mBinding.tvDescription.setText(mData.get(position).recomendation_note.capitalize())
        }else{
            mViewHolder.mBinding.tvDescription.setText("")
        }

        if(Leadcheck.equals("0")){
            mViewHolder.mBinding.ivLeadStatus.visibility=View.GONE
        }


        val strCurrentDate = mData.get(position).recomendation_date
        var format = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
        val newDate: Date = format.parse(strCurrentDate)

        format = SimpleDateFormat("dd MMM yyyy hh:mm aa")
        val date: String = format.format(newDate)

        mViewHolder.mBinding.dated.setText(date)

//        var time:String=mData.get(position).created_time
//        var Datesub: String = mData.get(position).recomendation_date
//        try {
//            val sdf = SimpleDateFormat("HH:mm")
//            val dateObj: Date = sdf.parse(Datesub)
//            Datesub = SimpleDateFormat("hh:mm aa").format(dateObj)
//
//            val inputPattern = "yyyy-mm-dd"
//            val outputPattern = "dd MMM yyyy"
//            val inputFormat = SimpleDateFormat(inputPattern)
//            val outputFormat = SimpleDateFormat(outputPattern)
//
//            var date: Date? = null
//            var mainstr: String? = null
//
//            try {
//                date = inputFormat.parse(Datesub)
//                mainstr = outputFormat.format(date)
//            } catch (e: ParseException) {
//                e.printStackTrace()
//            }
//            mViewHolder.mBinding.dated.setText(mainstr)
//        } catch (e: ParseException) {
//            e.printStackTrace()
//        }

        mContext?.let {
            Glide.with(it)
                    .load(mData.get(position).profile_pic)
                    .centerCrop()
                    .placeholder(R.drawable.ic_default_user_svg)
                    .into(mBinding.ivRecommandProfileImg)
        }


        if (!mData.get(position).userid.equals(readUsingSharedPreference(mContext!!,"userid"))){
            if (mData.get(position).is_viewed==0){
                mBinding.ivRecommandProfileImg.setBorderColor(mContext?.resources!!.getColor(R.color.red))
            }else{
                mBinding.ivRecommandProfileImg.setBorderColor(mContext?.resources!!.getColor(R.color.imaprocessst))
            }
        }

        if(mData.get(position).recomendation_note.length>100){
            mViewHolder.mBinding.collapse.visibility=View.GONE
            mViewHolder.mBinding.othersmore.visibility=View.VISIBLE
        }else{
            mViewHolder.mBinding.collapse.visibility=View.GONE
            mViewHolder.mBinding.othersmore.visibility=View.GONE
        }

        mViewHolder.mBinding.ivRecommandProfileImg.setOnClickListener {
            onClick3.OnClick(position, mData.get(position).userid,mData.get(position).is_viewed)
        }
        mViewHolder.mBinding.nameTV.setOnClickListener {
            onClick3.OnClick(position, mData.get(position).userid,mData.get(position).is_viewed)
        }
        mViewHolder.mBinding.dated.setOnClickListener {
            onClick3.OnClick(position, mData.get(position).userid,mData.get(position).is_viewed)
        }




        mViewHolder.mBinding.ivLeadStatus.setOnClickListener {
            val intent = Intent(mContext, MyLeadsStatusListActivity::class.java)
            intent.putExtra("id",requiredids)
            intent.putExtra("reconmmend_user",mData.get(position).userid)
            intent.putExtra("type","kk")
            intent.putExtra("isFrom","list")
            mContext?.startActivity(intent)
        }


        mViewHolder.mBinding.tvDescription.maxLines=2


        if(mData.get(position).recomended_by.size>0) {
            val text = "<font color=#70707>"+"Recommended By"+" "+"</font> <font color=#567E98>"+mData.get(position).recomended_by.get(0).recommended_by_user_name.capitalize()+"</font>"

            mViewHolder.mBinding.recommandbyperson.setText(Html.fromHtml(text))
        }else{
            mViewHolder.mBinding.recommandbyperson.setText("Recommended By" + " ")
        }



        if(mData.get(position).recomended_by.size>=2) {
            mViewHolder.mBinding.othersRecommendPersonTV.visibility=View.VISIBLE
            val data:Int=mData.get(position).recomended_by.size-1
            mViewHolder.mBinding.othersRecommendPersonTV.setText("(+"+data+" others)")

            mViewHolder.mBinding.othersRecommendPersonTV.setOnClickListener {
                onClick3.OnClickDialog(position,mData.get(position).recomended_by as MutableList<RecomendedBy>)
            }
        }else{
            mViewHolder.mBinding.othersRecommendPersonTV.visibility=View.GONE
        }


        mViewHolder.mBinding.othersmore.setOnClickListener {
            mViewHolder.mBinding.tvDescription.maxLines=Integer.MAX_VALUE
            mViewHolder.mBinding.collapse.visibility=View.VISIBLE
            mViewHolder.mBinding.othersmore.visibility=View.GONE
        }

        mViewHolder.mBinding.collapse.setOnClickListener {
            mViewHolder.mBinding.tvDescription.maxLines=2
            mViewHolder.mBinding.collapse.visibility=View.GONE
            mViewHolder.mBinding.othersmore.visibility=View.VISIBLE
        }

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(
        itemView: View?,
        val mBinding: RecommendedPersonRvAdapterBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)


}