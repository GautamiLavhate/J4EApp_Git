package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.ViewpagerProfileAdapterBinding
import com.bumptech.glide.Glide

class AdapterViewPager(activity: FragmentActivity?, companyName: MutableList<String>,
                       onClickCard: onClickCard) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: ViewpagerProfileAdapterBinding
    private var mData: MutableList<String> = companyName
    var mContext: Context? = activity
    var onClick1 = onClickCard

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.viewpager_profile_adapter,
            parent,
            false
        )
        return ItemViewHolder(
            mBinding.root,
            mBinding
        )
    }
    interface onClickCard{
        fun onClick(position: Int)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mViewHolder = holder as ItemViewHolder

        mContext?.let {
            Glide.with(it)
                .load(mData.get(position))
                .into(mViewHolder.mBinding.ivProduct)
        }
        mViewHolder.mBinding.ivProduct.setOnClickListener {
            onClick1.onClick(position)
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
        val mBinding: ViewpagerProfileAdapterBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}