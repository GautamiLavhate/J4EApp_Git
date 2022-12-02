package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.searchalldata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterSearchdataBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.searchalldata.model.SearchM

class AdapterSearchData (activity: FragmentActivity?, companyName: MutableList<SearchM.UserData>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterSearchdataBinding
    private var mData: MutableList<SearchM.UserData> = companyName
    var mContext: Context? = activity


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.adapter_searchdata,
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
        if(!(mData.get(position).Category=="" || mData.get(position).Category==null)) {
            mViewHolder.mBinding.title.setText(mData.get(position).Category.capitalize()+"("+mData.get(position).Count+")")
        }else{
            mViewHolder.mBinding.title.setText("")
        }

        val layoutManager = LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
        mViewHolder.mBinding.recyclerdata.layoutManager = layoutManager
        val mAdapter = AdapterSearchTpedata(mContext as FragmentActivity?,
                mData.get(position).Data as MutableList<SearchM.UserData.DataType>)
        mViewHolder.mBinding.recyclerdata.adapter = mAdapter

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(
            itemView: View?,
            val mBinding: AdapterSearchdataBinding
    ) :
            RecyclerView.ViewHolder(itemView!!)
}