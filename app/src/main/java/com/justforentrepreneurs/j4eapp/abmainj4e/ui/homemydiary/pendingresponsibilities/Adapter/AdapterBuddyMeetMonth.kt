package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterBuddymonthBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.model.Buddymeet

class AdapterBuddyMeetMonth(activity: FragmentActivity?, companyName:MutableList<Buddymeet.UserData>,count_available: Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterBuddymonthBinding
    private var mData:MutableList<Buddymeet.UserData> = companyName
    var mContext: Context? = activity
    var count_available1: Int = count_available

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_buddymonth,
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
        mViewHolder.mBinding.month.setText(mData.get(position).monthname)

        val layoutManager = LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
        mViewHolder.mBinding.recyclerdata.layoutManager = layoutManager
        val mAdapter = AdapterBuddyMeet(mContext as FragmentActivity?,
                mData.get(position).Data as MutableList<Buddymeet.DataBuddy>,count_available1)
        mViewHolder.mBinding.recyclerdata.adapter = mAdapter

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(
        itemView: View?,
        val mBinding: AdapterBuddymonthBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}