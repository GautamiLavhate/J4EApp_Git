package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myreportcard

import android.content.Context
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterMySubReportCardBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myreportcard.Model.MyReportData


class AdapterMySubReportCard(
        activity: Context?,
        companyName: MutableList<MyReportData.Data.RewardDetail.RewardDetailX>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterMySubReportCardBinding
    private var mData:  MutableList<MyReportData.Data.RewardDetail.RewardDetailX> = companyName
    var mContext: Context? = activity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.adapter_my_sub_report_card,
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

        val content = SpannableString(mData.get(position).ActivityDate)
        content.setSpan(UnderlineSpan(), 0, mData.get(position).ActivityDate.length, 0)
        mViewHolder.mBinding.date.text=content
        mViewHolder.mBinding.title.text=mData.get(position).ActivityName
        mViewHolder.mBinding.pointrv.text=mData.get(position).ActivityPoint
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(
            itemView: View?,
            val mBinding: AdapterMySubReportCardBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}