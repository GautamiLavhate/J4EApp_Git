package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.FunctionalData
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.PostCategrory
import com.justforentrepreneurs.j4eapp.databinding.AdapterLeadStatusCategoryBinding

class AdapterPostCategoriesNew(
    activity: FragmentActivity?,
    companyName: MutableList<PostCategrory.Postdata>,
    onClick2: OnClick2
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterLeadStatusCategoryBinding
    private var mData: MutableList<PostCategrory.Postdata> = companyName
    var mContext: Context? = activity
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
        mViewHolder.mBinding.tvCategory.text = mData.get(position).cat_name
        mViewHolder.itemView.setOnClickListener {
            onClick2.OnClick(mData[position].cat_name,mData[position].cat_id)
        }
    }

    interface OnClick2 {
        fun OnClick(position: String,id:String)
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