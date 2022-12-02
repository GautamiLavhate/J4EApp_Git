package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrecognition

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterMyRecognitionBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrecognition.model.Recognition
import com.bumptech.glide.Glide
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class AdapterMyRecognition(activity: FragmentActivity?, companyName: MutableList<Recognition.DataReco>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterMyRecognitionBinding
    private var mData: MutableList<Recognition.DataReco> = companyName
    var mContext: Context? = activity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_my_recognition,
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
        var time:String=mData.get(position).created_time
        val Datesub: String = mData.get(position).created_date
        try {
            val sdf = SimpleDateFormat("HH:mm:ss")
            val dateObj: Date = sdf.parse(time)
            time = SimpleDateFormat("hh:mm aa").format(dateObj)

            val inputPattern = "yyyy-MM-dd"
            val outputPattern = "dd MMM yyyy"
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
            mViewHolder.mBinding.date.setText(mainstr)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        mContext?.let {
            Glide.with(it)
                    .load(mData.get(position).thumbnail)
                    .into(mBinding.thumbailrec)
        }

        if(!(mData.get(position).title=="" || mData.get(position).title==null)) {
            mViewHolder.mBinding.title.setText(mData.get(position).title.capitalize())
        }else{
            mViewHolder.mBinding.title.setText("")
        }

        if(!(mData.get(position).description=="" || mData.get(position).description==null)) {
            mViewHolder.mBinding.description.setText(mData.get(position).description.capitalize())
        }else{
            mViewHolder.mBinding.description.setText("")
        }

        if(mData.get(position).description.length>100){
            mViewHolder.mBinding.collapse.visibility=View.GONE
            mViewHolder.mBinding.othersmore.visibility=View.VISIBLE
        }else{
            mViewHolder.mBinding.collapse.visibility=View.GONE
            mViewHolder.mBinding.othersmore.visibility=View.GONE
        }

       // mViewHolder.mBinding.date.setText(mData.get(position).created_date)

        mViewHolder.mBinding.description.maxLines=5

        mViewHolder.mBinding.othersmore.setOnClickListener {
            mViewHolder.mBinding.description.maxLines=Integer.MAX_VALUE
            mViewHolder.mBinding.collapse.visibility=View.VISIBLE
            mViewHolder.mBinding.othersmore.visibility=View.GONE
        }

        mViewHolder.mBinding.collapse.setOnClickListener {
            mViewHolder.mBinding.description.maxLines=2
            mViewHolder.mBinding.collapse.visibility=View.GONE
            mViewHolder.mBinding.othersmore.visibility=View.VISIBLE
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
        val mBinding: AdapterMyRecognitionBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}