package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterRecommendPersonOtherBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.MyLeadsDetailActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model.RecomendedBy
import com.bumptech.glide.Glide

class AdapterRecommendPersonOthers(activity: FragmentActivity?, companyName: MutableList<RecomendedBy>,onClick2: MyLeadsDetailActivity) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterRecommendPersonOtherBinding
    private var mData: MutableList<RecomendedBy> = companyName
    var mContext: Context? = activity
    var onClick3 = onClick2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.adapter_recommend_person_other, parent, false)
        return ItemViewHolder(mBinding.root, mBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mViewHolder = holder as ItemViewHolder


        if(!(mData.get(position).recomendation_note=="" || mData.get(position).recomendation_note==null)) {
            mViewHolder.mBinding.tvDescription.setText(mData.get(position).recomendation_note.capitalize())
        }else{
            mViewHolder.mBinding.tvDescription.setText("")
        }

        if(!(mData.get(position).recommended_by_user_name=="" || mData.get(position).recommended_by_user_name==null)) {
            mViewHolder.mBinding.fullname.setText(mData.get(position).recommended_by_user_name.capitalize())
        }else{
            mViewHolder.mBinding.fullname.setText("")
        }

        if(!(mData.get(position).recommended_by_user_designation=="" || mData.get(position).recommended_by_user_designation==null)) {
            mViewHolder.mBinding.designation.setText(mData.get(position).recommended_by_user_designation.capitalize())
        }else{
            mViewHolder.mBinding.designation.setText("")
        }

        if(!(mData.get(position).recommended_by_user_company=="" || mData.get(position).recommended_by_user_company==null)) {
            mViewHolder.mBinding.companyName.setText(mData.get(position).recommended_by_user_company.capitalize())
        }else{
            mViewHolder.mBinding.companyName.setText("")
        }


        mContext?.let {
            Glide.with(it)
                    .load(mData.get(position).recommended_by_user_profile_pic)
                    .centerCrop()
                    .placeholder(R.drawable.ic_default_user_svg)
                    .into(mBinding.ivProfileImg)
        }

        mViewHolder.mBinding.ivProfileImg.setOnClickListener {
            onClick3.OnClick(position, mData.get(position).recommended_user_id,)
        }

    }

    interface OnClick2 {
        fun OnClick(position: Int,data:String)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(
        itemView: View?,
        val mBinding: AdapterRecommendPersonOtherBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}