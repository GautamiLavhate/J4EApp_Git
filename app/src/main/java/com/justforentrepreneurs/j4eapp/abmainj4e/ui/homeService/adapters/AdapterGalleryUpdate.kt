package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters


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
import com.justforentrepreneurs.j4eapp.databinding.AdapterGalleryBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.Messageview
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.model.EventDetails
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.GallerViewActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.readUsingSharedPreference
import com.justforentrepreneurs.j4eapp.databinding.AdapterGalleryEventsliBinding
import java.util.ArrayList


class AdapterGalleryUpdate(activity: FragmentActivity?, companyName: MutableList<EventDetails.Alleventsdata.Gallerydata>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterGalleryEventsliBinding
    private var mData: MutableList<EventDetails.Alleventsdata.Gallerydata> = companyName

    var mContext: Context? = activity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_gallery_eventsli,
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
                .centerCrop()
                .into(mViewHolder.mBinding.ivProduct)
        }
        mViewHolder.mBinding.btDelete.visibility=View.GONE

    }

    interface OnClick2 {
        fun OnClickproImage(position: Int,data:String)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(
        itemView: View?,
        val mBinding: AdapterGalleryEventsliBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}