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
import com.justforentrepreneurs.j4eapp.databinding.ItemPostCategoryBinding

class AdapterPostCategories(activity: FragmentActivity?,
                            companyName: MutableList<PostCategrory.Postdata>,onClick3: OnClick3,pos:Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: ItemPostCategoryBinding
    private var mData: MutableList<PostCategrory.Postdata> = companyName
    var mContext: Context? = activity

    var selected_position = pos
    public var onClick2 = onClick3

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.item_post_category,
            parent,
            false
        )
        return ItemViewHolder(
            mBinding.root,
            mBinding
        )
    }

    interface OnClick3 {
        fun OnClickPostCategory(id: String)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mViewHolder = holder as ItemViewHolder
        mViewHolder.mBinding.txtPostCategory.text=mData.get(position).cat_name
        mContext?.let {
            Glide.with(it)
                .load(mData.get(position).cat_icon)
                .centerCrop()
                .into(mBinding.ivProfileImg)
        }
        if (selected_position==position){
            mViewHolder.mBinding.txtPostCategory.text=mData.get(position).cat_name+"!!"
            mViewHolder.mBinding.txtPostCategory.isChecked=true
        }else{
            mViewHolder.mBinding.txtPostCategory.text=mData.get(position).cat_name
            mViewHolder.mBinding.txtPostCategory.isChecked=false
        }
        mBinding.txtPostCategory.setOnClickListener {
            selected_position=position
            onClick2.OnClickPostCategory(mData.get(position).cat_id)
            notifyDataSetChanged()
        }



    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(
        itemView: View?,
        val mBinding: ItemPostCategoryBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}