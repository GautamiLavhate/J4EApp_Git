package com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterCommentListBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.PostGetComments
import com.bumptech.glide.Glide
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class AdapterCommentList(activity: FragmentActivity?, companyName: MutableList<PostGetComments.DataGet.DataGetData>,onClick2: AdapterCommentList.OnClick2) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterCommentListBinding
    private var mData: MutableList<PostGetComments.DataGet.DataGetData> = companyName
    var mContext: Context? = activity
    public var onClick2 = onClick2;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_comment_list,
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
                    .load(mData.get(position).post_cmt_by_user_image)
                    .into(mBinding.ivProfileImg)
        }

        mBinding.msg.text=mData.get(position).post_cmt_message

        val Datesub: String = mData.get(position).post_cmt_date + " " +mData.get(position).post_cmt_time
        val inputPattern = "yyyy-MM-dd HH:mm:ss"
        val outputPattern = "dd MMM yyyy,hh:mm aa"
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

        mBinding.time.text=mainstr

        if(!(mData.get(position).post_cmt_by_user_name=="" || mData.get(position).post_cmt_by_user_name==null)) {
            mViewHolder.mBinding.fullname.setText(mData.get(position).post_cmt_by_user_name.capitalize())
        }else{
            mViewHolder.mBinding.fullname.setText("")
        }

        mViewHolder.mBinding.ivProfileImg.setOnClickListener {
            onClick2.OnClickpro(position,mData.get(position).post_cmt_by_user_id)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    interface OnClick2 {
        fun OnClickpro(position: Int,data:String)
    }


    class ItemViewHolder internal constructor(
        itemView: View?,
        val mBinding: AdapterCommentListBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}