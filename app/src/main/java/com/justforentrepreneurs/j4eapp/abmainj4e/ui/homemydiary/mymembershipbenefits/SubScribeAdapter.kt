package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.LayPlanUpgradeadapterBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.Dataplan
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.MembershipFeaturesm
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.interfacess.OnClickPosPlan
import com.google.android.material.bottomsheet.BottomSheetDialog

class SubScribeAdapter(activity: FragmentActivity?, companyName: MutableList<Dataplan>,val OnClickPosPlan: OnClickPosPlan,dialog: BottomSheetDialog) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: LayPlanUpgradeadapterBinding
    private var mData: MutableList<Dataplan> = companyName
    var mContext: Context? = activity
    val dialog: BottomSheetDialog=dialog

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.lay_plan_upgradeadapter,
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
        mViewHolder.mBinding.plantitle.text=mData.get(position).membership_title
        mViewHolder.mBinding.btnPlanAmount.text=mData.get(position).membership_cost
        mViewHolder.mBinding.btnPlanAmount.text=mData.get(position).membership_cost


        val layoutManager = LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
        mViewHolder.mBinding.recyclerFeatuesPlan.layoutManager = layoutManager

        val mAdapter = FeaturesSubAdapter(mContext as FragmentActivity?,mData.get(position).membership_features as MutableList<MembershipFeaturesm>)
        mViewHolder.mBinding.recyclerFeatuesPlan.adapter = mAdapter

        mViewHolder.mBinding.btnUpgrade.setOnClickListener {
            OnClickPosPlan.onClickPos(position,mData,dialog)
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
            val mBinding: LayPlanUpgradeadapterBinding
    ) :
            RecyclerView.ViewHolder(itemView!!)


}