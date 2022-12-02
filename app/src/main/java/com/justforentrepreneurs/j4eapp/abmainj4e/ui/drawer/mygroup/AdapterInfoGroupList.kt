package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mygroup

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterAllBuddiesBinding

class AdapterInfoGroupList(activity: FragmentActivity?, companyName: Array<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterAllBuddiesBinding
    private var mData: Array<String> = companyName
    var mContext: Context? = activity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_all_buddies,
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
//        mViewHolder.mBinding.ivProfileImg.setOnClickListener {
//            mContext!!.startActivity(Intent(mContext, ProfileActivity::class.java))
//        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(
        itemView: View?,
        val mBinding: AdapterAllBuddiesBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}