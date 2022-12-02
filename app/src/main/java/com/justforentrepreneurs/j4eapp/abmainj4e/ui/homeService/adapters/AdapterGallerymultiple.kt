package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters


import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterGalleryEventsliBinding
import com.justforentrepreneurs.j4eapp.databinding.BsMemberFilterBinding


class AdapterGallerymultiple(activity: FragmentActivity?, companyName: ArrayList<Uri>, onClick2: OnClick2) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterGalleryEventsliBinding
    private var mData: ArrayList<Uri> = companyName
    var mContext: Context? = activity
    public var onClick2 = onClick2

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


        val selectedImage: Uri = mData.get(position)

        val fullBitmap = MediaStore.Images.Media.getBitmap(mContext?.contentResolver, selectedImage)

        mBinding.ivProduct.setImageBitmap(fullBitmap)

        mBinding.btDelete.setOnClickListener {
            onClick2.OnClick(position)
            notifyDataSetChanged()
        }

    }
    interface OnClick2 {
        fun OnClick(position: Int,)
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