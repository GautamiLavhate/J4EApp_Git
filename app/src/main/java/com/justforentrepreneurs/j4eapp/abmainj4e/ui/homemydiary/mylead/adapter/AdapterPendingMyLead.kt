package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mylead.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.BuildConfig
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterCompletedMyleadBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mylead.FragPendingMyLeads
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mylead.model.MyLeadCom
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.readUsingSharedPreference
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class AdapterPendingMyLead(activity: FragmentActivity?, companyName: MutableList<MyLeadCom.MyRequirementpending>, onClick2: FragPendingMyLeads) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterCompletedMyleadBinding
    private var mData: MutableList<MyLeadCom.MyRequirementpending> = companyName
    var mContext: Context? = activity
    var onClick3 = onClick2;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.adapter_completed_mylead, parent, false)
        return ItemViewHolder(mBinding.root, mBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mViewHolder = holder as ItemViewHolder

        if(!(mData.get(position).user_name=="" || mData.get(position).user_name==null)) {
            mViewHolder.mBinding.fullname.setText(mData.get(position).user_name.capitalize())
        }else{
            mViewHolder.mBinding.fullname.setText("")
        }

        if(!(mData.get(position).created_date=="" || mData.get(position).created_date==null)) {
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
                mViewHolder.mBinding.date.setText(mainstr+" "+"at"+" "+time)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            //mViewHolder.mBinding.date.setText(mData.get(position).created_date+" at "+mData.get(position).created_time)
        }else{
            mViewHolder.mBinding.date.setText("")
        }

        if(!(mData.get(position).description=="" || mData.get(position).description==null)) {
            mViewHolder.mBinding.description.setText(mData.get(position).description.capitalize())
        }else{
            mViewHolder.mBinding.description.setText("")
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



        mContext?.let {
            Glide.with(it)
                    .load(mData.get(position).user_profile)
                    .centerCrop()
                    .into(mBinding.ivProfileImg)
        }
        if (!mData.get(position).user_id.equals(readUsingSharedPreference(mContext!!,"userid"))){
            if (mData.get(position).is_user_viewed==0){
                mBinding.ivProfileImg.setBorderColor(mContext?.resources!!.getColor(R.color.red))
            }else{
                mBinding.ivProfileImg.setBorderColor(mContext?.resources!!.getColor(R.color.imaprocessst))
            }
        }

        mViewHolder.mBinding.tvView.setOnClickListener {

            onClick3.OnClick(position,mData.get(position).id,mData.get(position).user_id,mData.get(position).is_viewed)

        }
        mViewHolder.mBinding.ivProfileImg.setOnClickListener {
            onClick3.OnClickpro(position, mData.get(position).user_id,mData.get(position).is_user_viewed)
        }
        mViewHolder.mBinding.linearlayoutProfileDetail.setOnClickListener {
            onClick3.OnClickpro(position, mData.get(position).user_id,mData.get(position).is_user_viewed)
        }

        mViewHolder.mBinding.ivStatus.setOnClickListener {
            try {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "J4E")
                var shareMessage = "\nLet me recommend you this application\n\n"
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
        fun OnClick(position: Int,data:String,requser:String,viewed:Int)
        fun OnClickpro(position: Int,data:String,is_viewed:Int)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(itemView: View?, val mBinding: AdapterCompletedMyleadBinding) : RecyclerView.ViewHolder(itemView!!)

}