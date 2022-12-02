package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model.MyRecommadPeo
import com.justforentrepreneurs.j4eapp.databinding.AdapterRecommendPersonBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.AllBuddies
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.displayToast
import com.justforentrepreneurs.j4eapp.databinding.AdapterRecommandexitinglistBinding

class AdapterRecommendExitList(activity: FragmentActivity?, companyName: MutableList<MyRecommadPeo.DataLeadSt.AlreadyExist>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterRecommandexitinglistBinding
    private var mData:  MutableList<MyRecommadPeo.DataLeadSt.AlreadyExist>  = companyName
    var mContext: Context? = activity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.adapter_recommandexitinglist, parent, false)
        return ItemViewHolder(mBinding.root, mBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mViewHolder = holder as ItemViewHolder

        mViewHolder.mBinding.fullname.setText(mData.get(position).name)

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(
        itemView: View?,
        val mBinding: AdapterRecommandexitinglistBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}