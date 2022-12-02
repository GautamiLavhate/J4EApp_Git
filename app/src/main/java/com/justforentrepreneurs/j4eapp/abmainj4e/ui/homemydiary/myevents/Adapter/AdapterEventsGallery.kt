package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.Adapter

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterEventsGalleryBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.model.EventDetails
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.GallerViewEventsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.GallerViewActivity
import java.util.ArrayList

class AdapterEventsGallery(activity: FragmentActivity?, companyName: MutableList<EventDetails.Alleventsdata.Gallerydata>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterEventsGalleryBinding
    private var mData: MutableList<EventDetails.Alleventsdata.Gallerydata> = companyName
    var mContext: Context? = activity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_events_gallery,
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
                .load(mData.get(position).images)
                .into(mBinding.Galleryimg)
        }

        holder.itemView.setOnClickListener {
            val pos:String= position.toString();
            val propertyDetailsIntent = Intent(mContext, GallerViewEventsActivity::class.java)
            propertyDetailsIntent.putParcelableArrayListExtra("Image", mData as ArrayList<out Parcelable>)
            propertyDetailsIntent.putExtra("pos", pos)
            mContext!!.startActivity(propertyDetailsIntent)
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
        val mBinding: AdapterEventsGalleryBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}