package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myawardrecognition

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterAwardRecognitionBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myawardrecognition.model.MyAward
import com.bumptech.glide.Glide

class AdapterAwardRecognition(activity: FragmentActivity?, companyName: MutableList<MyAward.DataMyAward>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterAwardRecognitionBinding
    private var mData:  MutableList<MyAward.DataMyAward> = companyName
    var mContext: Context? = activity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_award_recognition,
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

        if(mData.get(position).rewardstatus.equals("Experied")){
            mViewHolder.mBinding.status.setTextColor(mContext!!.resources.getColor(R.color.expired))
            mViewHolder.mBinding.name.setTextColor(mContext!!.resources.getColor(R.color.colorPrimary))
        }else   if(mData.get(position).rewardstatus.equals("Pending")){
            mViewHolder.mBinding.status.setTextColor(mContext!!.resources.getColor(R.color.pending))
        }else{
            mViewHolder.mBinding.status.setTextColor(mContext!!.resources.getColor(R.color.availed))
        }



            mViewHolder.mBinding.status.setText(mData.get(position).rewardstatus.capitalize())
        if(!(mData.get(position).rewardtitle=="" || mData.get(position).rewardtitle==null)) {
            mViewHolder.mBinding.name.setText(mData.get(position).rewardtitle.capitalize())
        }else{
            mViewHolder.mBinding.name.setText("")
        }

        if(!(mData.get(position).rewardfrom=="" || mData.get(position).rewardfrom==null)) {
            mViewHolder.mBinding.form.setText(mData.get(position).rewardfrom)
        }else{
            mViewHolder.mBinding.form.setText("")
        }

        if(!(mData.get(position).rewardto=="" || mData.get(position).rewardto==null)) {
            mViewHolder.mBinding.To.setText(mData.get(position).rewardto.capitalize())
        }else{
            mViewHolder.mBinding.To.setText("")
        }

        if(!(mData.get(position).rewarddescription=="" || mData.get(position).rewarddescription==null)) {
            mViewHolder.mBinding.description.setText(mData.get(position).rewarddescription.capitalize())
        }else{
            mViewHolder.mBinding.description.setText("")
        }

        if(!(mData.get(position).rewardtitle=="" || mData.get(position).rewardtitle==null)) {
            mViewHolder.mBinding.title.setText(mData.get(position).rewardtitle.capitalize())
        }else{
            mViewHolder.mBinding.title.setText("")
        }

        if(!(mData.get(position).rewardtitle=="" || mData.get(position).rewardtitle==null)) {
            mViewHolder.mBinding.title.setText(mData.get(position).rewardtitle.capitalize())
        }else{
            mViewHolder.mBinding.title.setText("")
        }

        mContext?.let {
            Glide.with(it)
                    .load(mData.get(position).rewardthumbnil)
                    .into(mBinding.imagethum)
        }



        mViewHolder.mBinding.ivDropDown.setOnClickListener {
            mViewHolder.mBinding.ivDropDown.visibility = View.INVISIBLE
            mViewHolder.mBinding.llnavDrop.visibility = View.VISIBLE
        }
        mViewHolder.mBinding.ivDropUp.setOnClickListener {
            mViewHolder.mBinding.ivDropDown.visibility = View.VISIBLE
            mViewHolder.mBinding.llnavDrop.visibility = View.GONE
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
        val mBinding: AdapterAwardRecognitionBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}