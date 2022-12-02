package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.Dataplan
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.MembershipFeaturesm
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.interfacess.OnClickPlan
import com.justforentrepreneurs.j4eapp.databinding.ItemMembershipFeatureBinding

class AdapterSubscribeCount(activity: FragmentActivity?, companyName: MutableList<Dataplan>,
                            val OnClickPosPlan: OnClickPlan
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: ItemMembershipFeatureBinding
    private var mData: MutableList<Dataplan> = companyName
    var mContext: Context? = activity



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.item_membership_feature,
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
        mViewHolder.mBinding.btnUpgrade.text = "Subscribe"
        mViewHolder.mBinding.txtTitle.text=mData.get(position).membership_title
        mViewHolder.mBinding.txtAmount.text="₹ "+mData.get(position).membership_cost

        val layoutManager = LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
        mViewHolder.mBinding.rvFeatureCount.layoutManager = layoutManager

        val mAdapter = AdapterFeatureCountCount(mContext as FragmentActivity?,mData.get(position).membership_features as MutableList<MembershipFeaturesm>)
        mViewHolder.mBinding.rvFeatureCount.adapter = mAdapter


        mViewHolder.mBinding.btnUpgrade.setOnClickListener {
            OnClickPosPlan.onClickPos(position, mData, mData.get(position).membership_cost,mData.get(position).membership_type)
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
        val mBinding: ItemMembershipFeatureBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}