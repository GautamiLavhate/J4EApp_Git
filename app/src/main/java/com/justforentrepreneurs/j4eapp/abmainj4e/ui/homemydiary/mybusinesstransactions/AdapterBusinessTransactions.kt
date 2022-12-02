package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mybusinesstransactions

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterBusinessTransactionsBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mybusinesstransactions.model.Businesstransaction
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.readUsingSharedPreference
import java.text.DecimalFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class AdapterBusinessTransactions(activity: FragmentActivity?, companyName: MutableList<Businesstransaction.TransactionInfo>,val OnClickLiner: MyBusinessTransactionsActivity) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterBusinessTransactionsBinding
    private var mData: MutableList<Businesstransaction.TransactionInfo> = companyName
    var mContext: Context? = activity
    var onClick3 = OnClickLiner

    interface OnClick2 {
        fun OnClickpro(position: Int,data:String,is_viewed:Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_business_transactions,
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
        if (mData.get(position).transaction_type.equals("Given")) {
            mBinding.tvAmount.setTextColor(mContext!!.getColor(R.color.orange))

        } else {
            mBinding.tvAmount.setTextColor(mContext!!.getColor(R.color.light_green))

        }

        if (mData.get(position).payment_type.equals("Online")) {
            mBinding.offlinetv.visibility=View.GONE
        } else {
            mBinding.offlinetv.visibility=View.VISIBLE

        }

        mViewHolder.mBinding.Viewdeatiles.setOnClickListener {
            val intent = Intent(mContext, OfflineTransactionDetails::class.java)
            intent.putExtra("transid",mData.get(position).transaction_id)
            intent.putExtra("paymentTy",mData.get(position).payment_type)
            mContext!!.startActivity(intent)
        }

        if(!(mData.get(position).user_name=="" || mData.get(position).user_name==null)) {
            mBinding.fullname.setText(mData.get(position).user_name.capitalize())
        }

        val format4: String = DecimalFormat("#,##,##,##,###.00").format(mData.get(position).transaction_amount?.toDouble()!!)

         mViewHolder.mBinding.tvAmount.setText("₹ "+format4)

         mViewHolder.mBinding.offlinetv.setText(mData.get(position).payment_type)

        val Datesub: String = mData.get(position).transaction_date
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

        mContext?.let {
            Glide.with(it)
                    .load(mData.get(position).user_profile)
                    .centerCrop()
                    .placeholder(R.drawable.ic_profile_edit)
                    .into(mBinding.ivProfileImg)
        }

        if (!mData.get(position).user_id.equals(readUsingSharedPreference(mContext!!,"userid"))){
            if (mData.get(position).is_viewed==0){
                mBinding.ivProfileImg.setBorderColor(mContext?.resources!!.getColor(R.color.red))
            }else{
                mBinding.ivProfileImg.setBorderColor(mContext?.resources!!.getColor(R.color.imaprocessst))
            }
        }

        mViewHolder.mBinding.ivProfileImg.setOnClickListener {
            onClick3.OnClickpro(position, mData.get(position).user_id,mData.get(position).is_viewed)
        }

        mViewHolder.mBinding.fullname.setOnClickListener {
            onClick3.OnClickpro(position, mData.get(position).user_id,mData.get(position).is_viewed)
        }

        mViewHolder.mBinding.date.setOnClickListener {
            onClick3.OnClickpro(position, mData.get(position).user_id,mData.get(position).is_viewed)
        }

        mViewHolder.mBinding.offlinetv.setOnClickListener {
            onClick3.OnClickpro(position, mData.get(position).user_id,mData.get(position).is_viewed)
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
        val mBinding: AdapterBusinessTransactionsBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}