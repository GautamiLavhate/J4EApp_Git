package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myreportcard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterMyReportCardBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myreportcard.Model.MyReportData

class AdapterMyReportCard(
    activity: FragmentActivity?,
    companyName: MutableList<MyReportData.Data.RewardDetail>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterMyReportCardBinding
    private var mData:  MutableList<MyReportData.Data.RewardDetail> = companyName
    var mContext: Context? = activity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_my_report_card,
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
        val layoutManager = LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
        mViewHolder.mBinding.rvSubDetails.layoutManager = layoutManager
        val mAdapter = AdapterMySubReportCard(
            mContext,
                mData.get(position).RewardDetail as MutableList<MyReportData.Data.RewardDetail.RewardDetailX>
        )
        mViewHolder.mBinding.rewardtitle.text=mData.get(position).RewardTitle
        mViewHolder.mBinding.ponittotal.text=mData.get(position).RewardPoint
        mViewHolder.mBinding.rvSubDetails.adapter = mAdapter
        val expanded: Boolean = mData.get(position).expanded
        mViewHolder.mBinding.rvSubDetails.visibility = if (expanded) View.VISIBLE else View.GONE
        mViewHolder.mBinding.llMainHeader.setOnClickListener { view ->
            val expanded2: Boolean = mData.get(position).expanded
            mData.get(position).expanded = !expanded2
            notifyItemChanged(position)
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
        val mBinding: AdapterMyReportCardBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}