package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterPastEventsBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment.model.Allevents
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.MyEventsDetailsActivity
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.fmt
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.readUsingSharedPreference

class AdapterPastEvents(activity: FragmentActivity?, companyName: MutableList<Allevents.Alleventsdata>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterPastEventsBinding
    private var mData: MutableList<Allevents.Alleventsdata> = companyName
    var mContext: Context? = activity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_past_events,
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
        mContext?.let {
            Glide.with(it)
                    .load(mData.get(position).event_thumbnil)
                    .centerCrop()
                    .into(mBinding.ivImg)
        }

        if(!(mData.get(position).event_title=="" || mData.get(position).event_title==null)) {
            mBinding.eventtitle.setText(mData.get(position).event_title.capitalize())
        }

        mBinding.datetime.setText(mData.get(position).event_startdate)


        if(!(mData.get(position).event_address=="" || mData.get(position).event_address==null)) {
            mBinding.address.setText(mData.get(position).event_address.capitalize())
        }



        if(!readUsingSharedPreference(mContext!!, "membertyype").toString().equals("1")) {

            mBinding.amount.setText("₹ " + fmt(mData.get(position).event_fees))
        }else{
            mBinding.amount.setText("₹ " + fmt(mData.get(position).event_guest_fees))
        }

        mBinding.eventDetailsRelLay.setOnClickListener(View.OnClickListener {
            val intent = Intent(mContext, MyEventsDetailsActivity::class.java)
            intent.putExtra("type","past")
            intent.putExtra("Back","activity")
            intent.putExtra("id", mData.get(position).event_id)
            mContext!!.startActivity(intent)
        })
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class ItemViewHolder constructor(
        itemView: View?,
        val mBinding: AdapterPastEventsBinding
    ) : RecyclerView.ViewHolder(itemView!!) {
        init {

        }
    }
}