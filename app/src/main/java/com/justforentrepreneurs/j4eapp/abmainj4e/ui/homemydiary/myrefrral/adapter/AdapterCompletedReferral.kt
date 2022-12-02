package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrefrral.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrefrral.model.Data
import com.justforentrepreneurs.j4eapp.databinding.ItemReferralBinding
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class AdapterCompletedReferral(activity: FragmentActivity?, companyName: MutableList<Data>, onClick2: OnClick2, Testtype:String) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: ItemReferralBinding
    private var mData: MutableList<Data> = companyName
    var mContext: Context? = activity
    var onClick3 = onClick2
    var Testtype:String = Testtype

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.item_referral,
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

        val sdf = SimpleDateFormat("dd/M")
        val currentDate = sdf.format(Date())
        if (mData.get(position).dob != null){
            if (mData.get(position).dob.toString().contains(currentDate)){
                mViewHolder.mBinding.ivBday.visibility= View.VISIBLE
            }else{
                mViewHolder.mBinding.ivBday.visibility= View.GONE
            }
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

        mViewHolder.mBinding.satatus.setText(mData.get(position).referral_type)

        mViewHolder.mBinding.fuctionalarea.setText(mData.get(position).user_functional_area)

        var time:String=mData.get(position).doe_time
        val Datesub: String = mData.get(position).doe_date
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

        //mViewHolder.mBinding.date.setText(mData.get(position).created_date+" "+"at"+" "+mData.get(position).created_time)

        if(!(mData.get(position).user_name=="" || mData.get(position).user_name==null)) {
            mViewHolder.mBinding.username.setText(mData.get(position).user_name.capitalize())
        }else{
            mViewHolder.mBinding.username.setText("")
        }


        mContext?.let {
            Glide.with(it)
                .load(mData.get(position).avatar)
                .centerCrop()
                .placeholder(R.drawable.ic_default_user_svg)
                .into(mBinding.imagevepro)
        }

        mViewHolder.mBinding.imagevepro.setOnClickListener {
            if(Testtype.equals("given")) {
                onClick3.OnClickpro(position, mData.get(position).referral_for)
            }else{
                onClick3.OnClickpro(position, mData.get(position).user_id)
            }
        }
        mViewHolder.mBinding.linearlayoutimagevepro.setOnClickListener {
            if(Testtype.equals("given")) {
                onClick3.OnClickpro(position, mData.get(position).referral_for)
            }else{
                onClick3.OnClickpro(position, mData.get(position).user_id)
            }
        }



        mViewHolder.itemView.setOnClickListener {

            onClick3.OnClick(position,mData.get(position).id)
        }


    }
    interface OnClick2 {
        fun OnClick(position: Int,data:String)
        fun OnClickpro(position: Int,data:String)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(
        itemView: View?,
        val mBinding: ItemReferralBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}