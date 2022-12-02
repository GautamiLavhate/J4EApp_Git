package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.recommended.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterRecommendedByBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.recommended.FragRecommendedBy
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.recommended.model.RecommandByTo
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.readUsingSharedPreference
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.wordFirstCap
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class AdapterRecommendedBy(activity: FragmentActivity?, companyName: MutableList<RecommandByTo.RecommandBydata>,val OnClickLiner:FragRecommendedBy) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterRecommendedByBinding
    private var mData: MutableList<RecommandByTo.RecommandBydata> = companyName
    var mContext: Context? = activity
    var onClick3 = OnClickLiner

    interface OnClick2 {
        fun OnClickpro(position: Int,data:String,is_viewed:Int)
        fun OnClickLead(position: Int,data:String,requser:String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_recommended_by,
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
        if(!(mData.get(position).requirement_title=="" || mData.get(position).requirement_title==null)) {
            mViewHolder.mBinding.requirementtitle.setText(mData.get(position).requirement_title.capitalize())
        }else{
            mViewHolder.mBinding.requirementtitle.setText("")
        }

        if(!(mData.get(position).full_name=="" || mData.get(position).full_name==null)) {
            mViewHolder.mBinding.tvName.setText(wordFirstCap(mData.get(position).full_name))
        }else{
            mViewHolder.mBinding.tvName.setText("")
        }

        if(!(mData.get(position).requirement_description=="" || mData.get(position).requirement_description==null)) {
            mViewHolder.mBinding.requirementdescription.setText(mData.get(position).requirement_description.capitalize())
        }else{
            mViewHolder.mBinding.requirementdescription.setText("")
        }

        if(mData.get(position).count.equals("0")){
            mViewHolder.mBinding.tvNumberCount.visibility=View.GONE
        }else{
            mViewHolder.mBinding.tvNumberCount.setText(mData.get(position).count)
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
            mViewHolder.mBinding.dobet.setText(time)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
//        mViewHolder.mBinding.dobet.setText(mData.get(position).created_time)

        mContext?.let {
            Glide.with(it)
                    .load(mData.get(position).profile_pic)
                    .placeholder(R.drawable.ic_default_user_svg)
                    .into(mBinding.ivProfileImg)
        }

        if (!mData.get(position).userid.equals(readUsingSharedPreference(mContext!!,"userid"))){
            if (mData.get(position).is_viewed==0){
                mBinding.ivProfileImg.setBorderColor(mContext?.resources!!.getColor(R.color.red))
            }else{
                mBinding.ivProfileImg.setBorderColor(mContext?.resources!!.getColor(R.color.imaprocessst))
            }
        }

        mViewHolder.mBinding.ivProfileImg.setOnClickListener {
            onClick3.OnClickpro(position, mData.get(position).userid,mData.get(position).is_viewed)
        }

        mViewHolder.mBinding.tvName.setOnClickListener {
            onClick3.OnClickpro(position, mData.get(position).userid,mData.get(position).is_viewed)
        }

        mViewHolder.itemView.setOnClickListener {
            onClick3.OnClickLead(position,mData.get(position).requirement_id,mData.get(position).userid)
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
        val mBinding: AdapterRecommendedByBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}