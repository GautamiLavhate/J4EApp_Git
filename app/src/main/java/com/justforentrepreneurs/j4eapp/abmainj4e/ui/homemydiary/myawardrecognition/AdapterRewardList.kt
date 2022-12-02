package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myawardrecognition

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterRewardListBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.toprankings.TopRankingActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.toprankings.model.TopRank
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.wordFirstCap

class AdapterRewardList(activity: FragmentActivity?, companyName: MutableList<TopRank.DataTopRank>, onClick2:TopRankingActivity) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterRewardListBinding
    private var mData: MutableList<TopRank.DataTopRank> = companyName
    var mContext: Context? = activity
    var onClick3 = onClick2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_reward_list,
            parent,
            false
        )
        return ItemViewHolder(
            mBinding.root,
            mBinding
        )
    }

    interface OnClick2 {
        fun OnClickpro(position: Int,data:String,is_viewed:Int)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mViewHolder = holder as ItemViewHolder

        mContext?.let {
            Glide.with(it)
                    .load(mData.get(position).profile_pic)
                    .into(mBinding.ivProfileImg)
        }

        if(!(mData.get(position).full_name=="" || mData.get(position).full_name==null)) {
            mViewHolder.mBinding.name.setText(wordFirstCap(mData.get(position).full_name))
        }else{
            mViewHolder.mBinding.name.setText("")
        }

        if(!(mData.get(position).designation=="" || mData.get(position).designation==null)) {
            mViewHolder.mBinding.designation.setText(mData.get(position).designation.capitalize())
        }else{
            mViewHolder.mBinding.designation.setText("")
        }

        if(!(mData.get(position).designation=="" || mData.get(position).designation==null)) {
            mViewHolder.mBinding.designation.setText(mData.get(position).designation.capitalize())
        }else{
            mViewHolder.mBinding.designation.setText("")
        }

        mViewHolder.mBinding.points.setText(mData.get(position).total_point)

        mViewHolder.mBinding.ivProfileImg.setOnClickListener {
            onClick3.OnClickpro(position, mData.get(position).id,mData.get(position).is_viewed)
        }

        mViewHolder.mBinding.linearlayoutProfileDetail.setOnClickListener {
            onClick3.OnClickpro(position, mData.get(position).id,mData.get(position).is_viewed)
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
        val mBinding: AdapterRewardListBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}