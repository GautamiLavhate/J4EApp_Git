package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mytestimonials

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterMytestimonialsactBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mytestimonials.model.Testimonial
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.readUsingSharedPreference
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class AdapterMyTestimonialsAct(activity: FragmentActivity?, companyName: MutableList<Testimonial.DataTestimonial.Reviewdata>, onClick2:MyTestimonialsActivity) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterMytestimonialsactBinding
    private var mData: MutableList<Testimonial.DataTestimonial.Reviewdata> = companyName
    var mContext: Context? = activity
    var onClick3 = onClick2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_mytestimonialsact,
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
        holder.mBinding.ivName.text=mData.get(position).title
        holder.mBinding.note.text=mData.get(position).review

        holder.mBinding.rating.rating=mData.get(position).rate.toFloat()

        val Datesub: String = mData.get(position).date
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
            holder.mBinding.tvDate.text=mainstr
        } catch (e: ParseException) {
            e.printStackTrace()
        }


        mContext?.let {
            Glide.with(mContext!!)
                    .load(mData.get(position).thumbnil)
                    .centerCrop()
                    .placeholder(R.drawable.ic_profile_edit)
                    .into(holder.mBinding.ivProfileImg)
        }

        if (!mData.get(position).id.equals(readUsingSharedPreference(mContext!!,"userid"))){
            if (mData.get(position).is_viewed==0){
                mBinding.ivProfileImg.setBorderColor(mContext?.resources!!.getColor(R.color.red))
            }else{
                mBinding.ivProfileImg.setBorderColor(mContext?.resources!!.getColor(R.color.imaprocessst))
            }
        }


        holder.mBinding.ivProfileImg.setOnClickListener {
            onClick3.OnClick(position, mData.get(position).id, mData.get(position).type,mData.get(position).is_viewed)
        }

        holder.mBinding.linearlayoutProfileDetail.setOnClickListener {
            onClick3.OnClick(position, mData.get(position).id, mData.get(position).type,mData.get(position).is_viewed)
        }


    }

    interface OnClick2 {
        fun OnClick(position: Int,data:String,type:String,is_viewed:Int)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(
        itemView: View?,
        val mBinding: AdapterMytestimonialsactBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}