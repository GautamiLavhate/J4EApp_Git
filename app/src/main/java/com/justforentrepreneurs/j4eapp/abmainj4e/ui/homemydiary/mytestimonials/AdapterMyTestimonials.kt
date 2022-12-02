package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mytestimonials

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterMyTestimonialsBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.Allreviews
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.wordFirstCap
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class AdapterMyTestimonials(activity: FragmentActivity?, companyName: MutableList<Allreviews>,onClick2:ProfileActivity) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterMyTestimonialsBinding
    private var mData: MutableList<Allreviews> = companyName
    var mContext: Context? = activity
    var onClick3 = onClick2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_my_testimonials,
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
        holder.mBinding.ivName.text= wordFirstCap(mData.get(position).reviewed_by)
        holder.mBinding.note.text=mData.get(position).review_note

        holder.mBinding.rating.rating=mData.get(position).review_rate.toFloat()

        val Datesub: String = mData.get(position).review_date
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
//        holder.mBinding.tvDate.text=mData.get(position).review_date

        mContext?.let {
            Glide.with(mContext!!)
                    .load(mData.get(position).profile_img)
                    .centerCrop()
                    .placeholder(R.drawable.ic_profile_edit)
                    .into(holder.mBinding.ivProfileImg)
        }

        holder.mBinding.ivProfileImg.setOnClickListener {
            onClick3.OnClick(position,mData.get(position).reviewed_by_id)
        }
        holder.mBinding.linearlayoutProfileDetail.setOnClickListener {
            onClick3.OnClick(position,mData.get(position).reviewed_by_id)
        }


    }

    interface OnClick2 {
        fun OnClick(position: Int,data:String)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(
        itemView: View?,
        val mBinding: AdapterMyTestimonialsBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}