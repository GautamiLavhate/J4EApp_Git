package com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.ActiveMultiSelection
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterAllBuddiesBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.AllBuddies
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.RecommendedLeadActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.EventStatusActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.RecommendedEventsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.model.EventStatus
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.wordFirstCap

class AdapterLeadAllBuddies(activity: FragmentActivity?, companyName: MutableList<AllBuddies>, var multiSelection: ActiveMultiSelection?,count_available:Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterAllBuddiesBinding
    private var mData: MutableList<AllBuddies> = companyName
    var mContext: Context? = activity
    private var filterHelper: RecommendedLeadActivity.ContactFiltershareHelper? = null
    private var filterHelperEvent: RecommendedEventsActivity.ContactFiltershareHelper? = null
    var count_available1:Int =count_available

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
        mViewHolder.mBinding.visiblemenu.visibility=View.GONE
        if (mData.get(position).isSelected==true) {
            holder.itemView.background = mContext?.getResources()?.getDrawable(R.color.grayselected)
            holder.mBinding.imageselected.visibility=View.VISIBLE
        } else {
            holder.itemView.background = mContext?.getResources()?.getDrawable(R.drawable.rounded_border_rectangle_white_0dp)
            holder.mBinding.imageselected.visibility=View.GONE
        }

        if(!(mData.get(position).full_name=="" || mData.get(position).full_name==null)) {
            mViewHolder.mBinding.namebudd.setText(wordFirstCap(mData.get(position).full_name))
        }else{
            mViewHolder.mBinding.namebudd.setText("")
        }

        mViewHolder.mBinding.membership.visibility=View.GONE


        if(!(mData.get(position).designation=="" || mData.get(position).designation==null)) {
            mViewHolder.mBinding.designation.setText(mData.get(position).designation.capitalize())
        }else{
            mViewHolder.mBinding.designation.setText("")
        }

        if(!(mData.get(position).company_name=="" || mData.get(position).company_name==null)) {
            mViewHolder.mBinding.companyName.setText(mData.get(position).company_name.capitalize())
        }else{
            mViewHolder.mBinding.companyName.setText("")
        }


        Glide.with(mContext!!)
                .load(mData.get(position).profile_pic)
                .centerCrop()
                .placeholder(R.drawable.ic_default_user_svg)
                .into(mBinding.imagevepro)



        mViewHolder.itemView.setOnClickListener {
            if (mData.get(position).isSelected){
                mData.get(position).isSelected=false
                multiSelection!!.removeMultiSelection(mData.get(position),mData.get(position).id)
            } else {
                mData.get(position).isSelected=true
                multiSelection!!.addMultiSelection(mData.get(position))
            }
            notifyDataSetChanged()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }


    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(
        itemView: View?,
        val mBinding: AdapterAllBuddiesBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)

    private var searchArrayList: MutableList<AllBuddies> = mData

    // song
    fun setProduct(categoryList: MutableList<AllBuddies>) {
        this.mData = categoryList
    }

    fun getFilter(): Filter? {
        if (filterHelper == null) {
            filterHelper = RecommendedLeadActivity.ContactFiltershareHelper(searchArrayList, this )
        }
        return filterHelper
    }

    fun getEventFilter(): Filter? {
        if (filterHelperEvent == null) {
            filterHelperEvent = RecommendedEventsActivity.ContactFiltershareHelper(searchArrayList, this )
        }
        return filterHelperEvent
    }

    fun refresh() {
        notifyDataSetChanged()
    }
}