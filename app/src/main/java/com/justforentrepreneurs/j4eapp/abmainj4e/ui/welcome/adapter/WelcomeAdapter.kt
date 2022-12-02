package com.justforentrepreneurs.j4eapp.abmainj4e.ui.welcome.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.welcome.model.Data
import com.justforentrepreneurs.j4eapp.databinding.ItemWelcomeBinding

class WelcomeAdapter(activity: FragmentActivity?,mList1: MutableList<Data>, viewPager2: ViewPager2):
    RecyclerView.Adapter<WelcomeAdapter.ItemViewHolder>(){
    private lateinit var mBinding: ItemWelcomeBinding
    private var mData2:MutableList<Data> = mList1
    var mContext: Context? = activity


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.item_welcome,
            parent,
            false
        )
        return ItemViewHolder(
            mBinding.root,
            mBinding
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val mViewHolder = holder as ItemViewHolder
        mContext?.let {
            Glide.with(it)
                .load(mData2.get(position).screen_image)
                .into(mBinding.imageView)
        }
        mViewHolder.mBinding.tvTitle.setText(mData2.get(position).screen_title)
        mViewHolder.mBinding.tvDescription.setText(mData2.get(position).screen_desc)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
    override fun getItemCount(): Int {
        return mData2.size
    }

    class ItemViewHolder internal constructor(
        itemView: View?,
        val mBinding: ItemWelcomeBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}