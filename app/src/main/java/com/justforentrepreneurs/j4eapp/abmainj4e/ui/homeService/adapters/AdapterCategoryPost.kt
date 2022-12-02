package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterCategorypostBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.PostCategrory
import com.bumptech.glide.Glide

class AdapterCategoryPost (activity: FragmentActivity?,
                           companyName: MutableList<PostCategrory.Postdata>,onClick2:OnClick2,pos:Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterCategorypostBinding
    private var mData: MutableList<PostCategrory.Postdata> = companyName
    var mContext: Context? = activity

    var selected_position = pos
    var onClick2 = onClick2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_categorypost,
            parent,
            false
        )
        return ItemViewHolder(
            mBinding.root,
            mBinding
        )
    }

    interface OnClick2 {
        fun OnClick(id: String)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mViewHolder = holder as ItemViewHolder
         mViewHolder.mBinding.textcat.text=mData.get(position).cat_name
        mContext?.let {
            Glide.with(it)
                .load(mData.get(position).cat_icon)
                .centerCrop()
                .into(mBinding.ivProfileImg)
        }


        if (position == selected_position){
            mData.get(position).isSelected=true
            mBinding.crd.background = mContext?.getResources()?.getDrawable(R.drawable.rounded_border_4376b1_rectiange_gray)

        } else {
            mData.get(position).isSelected=false
            mBinding.crd.background = mContext?.getResources()?.getDrawable(R.drawable.rounded_border_4376b1_rectangle_white_0dp)
        }


        mViewHolder.itemView.setOnClickListener {
            selected_position = position
            onClick2.OnClick(mData.get(selected_position).cat_id)
            notifyDataSetChanged()
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
        val mBinding: AdapterCategorypostBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}