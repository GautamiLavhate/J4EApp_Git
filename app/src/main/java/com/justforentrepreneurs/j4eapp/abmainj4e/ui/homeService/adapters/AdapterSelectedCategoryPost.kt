package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.PostCategrory
import com.justforentrepreneurs.j4eapp.databinding.AdapterCategorypostBinding

class AdapterSelectedCategoryPost (activity: FragmentActivity?,
                                   companyName: MutableList<PostCategrory.Postdata>,
                                   name: String,onClick3: OnClick3
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private lateinit var mBinding: AdapterCategorypostBinding
    private var mData: MutableList<PostCategrory.Postdata> = companyName
    var mContext: Context? = activity
    var name1:String = name
    var onClick3 = onClick3


    interface OnClick3 {
        fun OnClick(id: String,companyName: MutableList<PostCategrory.Postdata>,position: Int)
    }

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

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mViewHolder = holder as ItemViewHolder
        mViewHolder.mBinding.textcat.text=mData.get(position).cat_name
        mContext?.let {
            Glide.with(it)
                .load(mData.get(position).cat_icon)
                .centerCrop()
                .into(mBinding.ivProfileImg)
        }
        if (mViewHolder.mBinding.textcat.text==name1 ){
            mData.get(position).isSelected=true
            mBinding.crd.background = mContext?.getResources()?.getDrawable(R.drawable.rounded_border_4376b1_rectiange_gray)
        }
        mViewHolder.itemView.setOnClickListener {
            onClick3.OnClick(mData.get(position).cat_id,mData,position)
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