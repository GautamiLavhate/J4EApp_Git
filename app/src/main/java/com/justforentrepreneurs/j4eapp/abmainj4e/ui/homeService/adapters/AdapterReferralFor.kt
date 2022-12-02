package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.Memberinfo
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.wordFirstCap
import com.justforentrepreneurs.j4eapp.databinding.AdapterLeadStatusCategoryBinding

class AdapterReferralFor(activity: FragmentActivity?,
                         companyName: MutableList<Memberinfo>,
                         onClick4: OnClick4
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterLeadStatusCategoryBinding
    private var mData: MutableList<Memberinfo> = companyName
    var mContext: Context? = activity
    public var onClick4 = onClick4;

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
        mViewHolder.mBinding.tvCategory.text = (wordFirstCap(mData.get(position).full_name))
        mViewHolder.itemView.setOnClickListener {
            onClick4.OnClickReferralFor(mData[position].full_name,mData[position].id)
        }
    }

    interface OnClick4 {
        fun OnClickReferralFor(position: String, id:String)
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