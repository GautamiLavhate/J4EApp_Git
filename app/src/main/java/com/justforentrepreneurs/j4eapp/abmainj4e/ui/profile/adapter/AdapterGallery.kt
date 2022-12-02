package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.adapter


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
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.GallerViewActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.GalleryInfo
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.readUsingSharedPreference
import java.util.ArrayList


class AdapterGallery(activity: FragmentActivity?, companyName: MutableList<GalleryInfo>, onClick2: ProfileActivity, memberid:String) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterGalleryBinding
    private var mData: MutableList<GalleryInfo> = companyName

    var mContext: Context? = activity
    var memberid: String = memberid
    var onClick3 = onClick2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_gallery,
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
                .load(mData.get(position).image_link)
                .into(mViewHolder.mBinding.ivProduct)
        }

        if(readUsingSharedPreference(mContext!!, "userid").toString().equals(memberid)){
            mViewHolder.mBinding.btDelete.visibility=View.VISIBLE
        }else{
            mViewHolder.mBinding.btDelete.visibility=View.GONE
        }

        mViewHolder.mBinding.btDelete.setOnClickListener {
            onClick3.OnClickproImage(position,mData.get(position).imageid)
        }

        mViewHolder.itemView.setOnClickListener {
            val pos:String= position.toString();
            val propertyDetailsIntent = Intent(mContext, GallerViewActivity::class.java)
            propertyDetailsIntent.putParcelableArrayListExtra("Image", mData as ArrayList<out Parcelable> )
            propertyDetailsIntent.putExtra("pos", pos)
            mContext!!.startActivity(propertyDetailsIntent)
        }
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
        val mBinding: AdapterGalleryBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}