package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.Dataplan
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.MembershipFeaturesm

import com.justforentrepreneurs.j4eapp.databinding.ItemMembershipTitleBinding
import com.justforentrepreneurs.j4eapp.databinding.ItemMembershipTitleTitleBinding

class AdapterFeatureCountCount (activity: FragmentActivity?,
                                companyName: MutableList<MembershipFeaturesm>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: ItemMembershipTitleTitleBinding
    private var mData: MutableList<MembershipFeaturesm> = companyName
    var mContext: Context? = activity


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.item_membership_title_title,
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
        if (position % 2 == 1) {
            mViewHolder.mBinding.Libackground.setBackgroundColor(Color.parseColor("#FFFFFF"))
        } else {
            mViewHolder.mBinding.Libackground.setBackgroundColor(Color.parseColor("#E7F1F9"))
        }
        mViewHolder.mBinding.txtTitleTitle.text=mData.get(position).FeaturesName
        if (mData.get(position).FeaturesAvilablity.equals("No")){
            mViewHolder.mBinding.txtTitle.text="X"
            mViewHolder.mBinding.txtTitle.setTextColor(Color.parseColor("#FF0000"))

        }else{
            mViewHolder.mBinding.txtTitle.text=mData.get(position).FeaturesCount
            mViewHolder.mBinding.txtTitle.setTextColor(Color.parseColor("#3E3E3E"))
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
        val mBinding: ItemMembershipTitleTitleBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}