package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrequirements.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.BuildConfig
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrequirements.FragPendingRequirement
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrequirements.model.MyRequirementpending
import com.justforentrepreneurs.j4eapp.databinding.AdapterPendingRequirementBinding
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class AdapterPendingRequirement(activity: FragmentActivity?, companyName: MutableList<MyRequirementpending>,onClick2: FragPendingRequirement) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterPendingRequirementBinding
    private var mData: MutableList<MyRequirementpending> = companyName
    var mContext: Context? = activity
    var onClick3 = onClick2
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_pending_requirement,
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

        var time:String=mData.get(position).created_time
        val Datesub: String = mData.get(position).created_date

        var DateAndTime :String = mData.get(position).created_date+" "+mData.get(position).created_time
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
            mViewHolder.mBinding.dobet.setText(mainstr+" "+"at"+" "+time)

        } catch (e: ParseException) {
            e.printStackTrace()
        }


        if (mData.get(position).thumbnil.equals("")){
            mBinding.requirementimg.visibility=View.GONE
        }else{
            mBinding.requirementimg.visibility=View.VISIBLE
            mContext?.let {
                Glide.with(it)
                    .load(mData.get(position).thumbnil)
                    .into(mBinding.requirementimg)
            }
        }


        mViewHolder.itemView.setOnClickListener {

            onClick3.OnClick(position,mData.get(position).id)
        }

        mViewHolder.mBinding.ivShare.setOnClickListener {
            try {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "J4E")
                var shareMessage = "\nLet me recommend you this application\n\n"
                var profileid = "=abc"
                shareMessage =
                    """
                        ${shareMessage}https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}
                   
                        
                        """.trimIndent()
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                mContext?.startActivity(Intent.createChooser(shareIntent, "choose one"))
            } catch (e: Exception) {
                //e.toString();
            }
        }

    }
    interface OnClick2 {
        fun OnClick(position: Int,data:String)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(
        itemView: View?,
        val mBinding: AdapterPendingRequirementBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}