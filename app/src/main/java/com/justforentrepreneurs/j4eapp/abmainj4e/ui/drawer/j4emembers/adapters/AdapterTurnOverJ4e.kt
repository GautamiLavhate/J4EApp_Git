package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterLeadStatusCategoryBinding
import com.justforentrepreneurs.j4eapp.databinding.BsMemberFilterBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.GetTurnOver

class AdapterTurnOverJ4e (
    activity: FragmentActivity?,
    companyName: MutableList<GetTurnOver.DataTurn>,
    onClick2: OnClick2,mBsMemberFilterBinding: BsMemberFilterBinding) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterLeadStatusCategoryBinding
    private var mData: MutableList<GetTurnOver.DataTurn> = companyName
    var mContext: Context? = activity
    public var onClick2 = onClick2;
    val mBsMemberFilterBinding: BsMemberFilterBinding=mBsMemberFilterBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_lead_status_category,
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
        mViewHolder.mBinding.tvCategory.text = mData.get(position).turn_over_value
        mViewHolder.itemView.setOnClickListener {
            onClick2.OnClickJ4e(mData[position].turn_over_value,mData[position].turn_over_id,mBsMemberFilterBinding)
        }
    }

    interface OnClick2 {
        fun OnClickJ4e(position: String,id:String,mBsMemberFilterBinding: BsMemberFilterBinding)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(
        itemView: View?,
        val mBinding: AdapterLeadStatusCategoryBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)

}