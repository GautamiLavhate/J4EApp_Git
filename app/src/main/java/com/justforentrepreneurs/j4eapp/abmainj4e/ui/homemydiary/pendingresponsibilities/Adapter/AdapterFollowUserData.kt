package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterLeadStatusCategoryBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.model.FollowUpmem


class AdapterFollowUserData(
        activity: FragmentActivity?,
        companyName: MutableList<FollowUpmem.DataLead>,
        onClick2: OnClick2, Type:String
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterLeadStatusCategoryBinding
    private var mData: MutableList<FollowUpmem.DataLead> = companyName
    var mContext: Context? = activity
    var Type1: String = Type
    public var onClick2 = onClick2;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_lead_status_category,
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
        mViewHolder.mBinding.tvCategory.text = mData.get(position).user_name
        mViewHolder.itemView.setOnClickListener {
            onClick2.OnClicklead(mData[position].user_name,mData[position].user_id,Type1)
        }
    }

    interface OnClick2 {
        fun OnClicklead(position: String,id:String,type:String)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(
        itemView: View?,
        val mBinding: AdapterLeadStatusCategoryBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}