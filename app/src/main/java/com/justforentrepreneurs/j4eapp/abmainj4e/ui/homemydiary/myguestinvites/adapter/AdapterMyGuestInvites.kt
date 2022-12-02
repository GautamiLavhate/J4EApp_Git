package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myguestinvites.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterMyguestinvitesBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myguestinvites.moel.GuestInvitesLi


class AdapterMyGuestInvites(activity: FragmentActivity?, companyName: MutableList<GuestInvitesLi.DataGuest>,onClick2:OnClick2) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterMyguestinvitesBinding
    private var mData: MutableList<GuestInvitesLi.DataGuest> = companyName
    var mContext: Context? = activity
    public var onClick2 = onClick2;


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.adapter_myguestinvites,
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
        if(!(mData.get(position).guestname=="" || mData.get(position).guestname==null)) {
            mViewHolder.mBinding.name.setText(mData.get(position).guestname.capitalize())
        }else{
            mViewHolder.mBinding.name.setText("")
        }

        if(!(mData.get(position).eventname=="" || mData.get(position).eventname==null)) {
            mViewHolder.mBinding.eventtitle.setText(mData.get(position).eventname.capitalize())
        }else{
            mViewHolder.mBinding.eventtitle.setText("")
        }

        if(!(mData.get(position).guestdesignation=="" || mData.get(position).guestdesignation==null)) {
            mViewHolder.mBinding.designation.setText(mData.get(position).guestdesignation.capitalize())
        }else{
            mViewHolder.mBinding.designation.setText("")
        }

        if(!(mData.get(position).guestemail=="" || mData.get(position).guestemail==null)) {
            mViewHolder.mBinding.email.setText(mData.get(position).guestemail.capitalize())
        }else{
            mViewHolder.mBinding.email.setText("")
        }

        if(!(mData.get(position).guestcompany=="" || mData.get(position).guestcompany==null)) {
            mViewHolder.mBinding.companyName.setText(mData.get(position).guestcompany.capitalize())
        }else{
            mViewHolder.mBinding.companyName.setText("")
        }

        mViewHolder.mBinding.phonenumber.setText(mData.get(position).guestphno)

        holder.mBinding.status.text=mData.get(position).status
        if (mData.get(position).status == "Invited") {
            holder.mBinding.status.setTextColor(mContext?.getColor(R.color.colorPrimary)!!)
        } else if (mData.get(position).status == "Confirmed") {
            holder.mBinding.status.setTextColor(mContext?.getColor(R.color.md_green_light)!!)
        } else if (mData.get(position).status == "Requested") {
            holder.mBinding.status.setTextColor(mContext?.getColor(R.color.colorPrimary)!!)
        } else if (mData.get(position).status == "Approved") {
            holder.mBinding.status.setTextColor(mContext?.getColor(R.color.colorPrimary)!!)
        } else if (mData.get(position).status == "Pending") {
            holder.mBinding.status.setTextColor(mContext?.getColor(R.color.orange)!!)
            holder.mBinding.makepayment.visibility=View.VISIBLE
            holder.mBinding.makepayment.setOnClickListener {
                onClick2.OnClick(mData.get(position).invite_id,mData.get(position).eventamount,position.toString())
            }
        }

    }

    interface OnClick2 {
        fun OnClick(id: String,eventamount:String,position:String)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(
            itemView: View?,
            val mBinding: AdapterMyguestinvitesBinding
    ) :
            RecyclerView.ViewHolder(itemView!!)
}