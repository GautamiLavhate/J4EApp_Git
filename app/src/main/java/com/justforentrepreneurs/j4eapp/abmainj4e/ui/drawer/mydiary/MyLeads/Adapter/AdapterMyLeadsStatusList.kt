package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterMyleadstatuslistBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model.MyLeadStatus
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class AdapterMyLeadsStatusList(activity: FragmentActivity?, companyName: MutableList<MyLeadStatus.DataLeadSt>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterMyleadstatuslistBinding
    private var mData:  MutableList<MyLeadStatus.DataLeadSt>  = companyName
    var mContext: Context? = activity


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.adapter_myleadstatuslist, parent, false)
        return ItemViewHolder(mBinding.root, mBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mViewHolder = holder as ItemViewHolder

        //mViewHolder.mBinding.ivDate.text=mData.get(position).status_day+"\n"+mData.get(position).status_time
        mViewHolder.mBinding.status.text=mData.get(position).status_name
        mViewHolder.mBinding.msg.text=mData.get(position).status_msg

        var time:String=mData.get(position).status_time
        try {
            val sdf = SimpleDateFormat("HH:mm")
            val dateObj: Date = sdf.parse(time)
            time = SimpleDateFormat("hh:mm aa").format(dateObj)

            mViewHolder.mBinding.ivDate.setText(mData.get(position).status_day+"\n"+time)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        val Datesub: String = mData.get(position).status_date
        val inputPattern = "dd MMM yyyy"
        val outputPattern = "MMM \ndd"
        val inputFormat = SimpleDateFormat(inputPattern)
        val outputFormat = SimpleDateFormat(outputPattern)

        var date: Date? = null
        var mainstr: String? = null

        try {
            date = inputFormat.parse(Datesub)
            mainstr = outputFormat.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        mViewHolder.mBinding.month.text=mainstr



    }



    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(
            itemView: View?,
            val mBinding: AdapterMyleadstatuslistBinding
    ) :
            RecyclerView.ViewHolder(itemView!!)

}