package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model.requirement_info
import com.justforentrepreneurs.j4eapp.databinding.AdapterReffralstatusdetailsBinding

class AdapterReffStatusDetailsList(activity: FragmentActivity?, companyName: MutableList<requirement_info.Refferalstatus>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterReffralstatusdetailsBinding
    private var mData: MutableList<requirement_info.Refferalstatus> = companyName


    var mContext: Context? = activity




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.adapter_reffralstatusdetails,
                parent,
                false
        )
        return ItemViewHolder(
                mBinding.root,
                mBinding
        )
    }

    interface OnClick2 {
        fun OnClick(id: String)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mViewHolder = holder as ItemViewHolder
         mViewHolder.mBinding.catename.text=mData.get(position).name

        if(mData.get(position).value.equals("Yes")){
            mViewHolder.mBinding.valueicon.setBackgroundResource(R.drawable.ic_checkmark_new)
        }else{
            mViewHolder.mBinding.valueicon.setBackgroundResource(R.drawable.ic_close_new)
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
            val mBinding: AdapterReffralstatusdetailsBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}