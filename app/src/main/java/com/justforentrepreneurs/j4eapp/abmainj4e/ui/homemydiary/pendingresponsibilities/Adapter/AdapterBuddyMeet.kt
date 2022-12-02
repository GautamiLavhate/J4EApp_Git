package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.Adapter

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterPsBuddyMeetBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.model.Buddymeet
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.readUsingSharedPreference
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class AdapterBuddyMeet(activity: FragmentActivity?, companyName:MutableList<Buddymeet.DataBuddy>,count_available: Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterPsBuddyMeetBinding
    private var mData:MutableList<Buddymeet.DataBuddy> = companyName
    var mContext: Context? = activity
    var count_available1: Int = count_available

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_ps_buddy_meet,
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
                    .load(mData.get(position).buddymeet_userprofile)
                    .centerCrop()
                    .placeholder(R.drawable.ic_default_user_svg)
                    .into(mBinding.ivProfileImg)
        }
        if (!mData.get(position).buddymeet_id.equals(readUsingSharedPreference(mContext!!,"userid"))){
            if (mData.get(position).is_viewed==0){
                mBinding.ivProfileImg.setBorderColor(mContext?.resources!!.getColor(R.color.red))
            }else{
                mBinding.ivProfileImg.setBorderColor(mContext?.resources!!.getColor(R.color.imaprocessst))
            }
        }

        mViewHolder.mBinding.llLocation.visibility=View.VISIBLE
        mViewHolder.mBinding.tcLocation.setText(mData.get(position).buddymeet_location)
        if(mData.get(position).buddymeet_description.length>100){

            mViewHolder.mBinding.othersmore.visibility=View.VISIBLE
        }else{
            mViewHolder.mBinding.collapse.visibility=View.GONE
            mViewHolder.mBinding.othersmore.visibility=View.GONE
        }



        mViewHolder.mBinding.ivProfileImg.setOnClickListener {
            if (count_available1 == 0){
                if (mData.get(position).is_viewed==0){
                    PermissionDialog(readUsingSharedPreference(mContext!!,"ViewExhaustedMsg").toString())
                }else{
                    val intent = Intent(mContext, ProfileActivity::class.java)
                    intent.putExtra("id",mData.get(position).buddymeet_userid)
                    intent.putExtra("type","MyLead")
                    mContext?.startActivity(intent)
                }
            }else{
                val intent = Intent(mContext, ProfileActivity::class.java)
                intent.putExtra("id",mData.get(position).buddymeet_userid)
                intent.putExtra("type","MyLead")
                mContext?.startActivity(intent)
            }

        }

        mViewHolder.mBinding.linearlayoutProfileDetail.setOnClickListener {
            if (count_available1 == 0){
                if (mData.get(position).is_viewed==0){
                    PermissionDialog(readUsingSharedPreference(mContext!!,"ViewExhaustedMsg").toString())
                }else{
                    val intent = Intent(mContext, ProfileActivity::class.java)
                    intent.putExtra("id",mData.get(position).buddymeet_userid)
                    intent.putExtra("type","MyLead")
                    mContext?.startActivity(intent)
                }
            }else{
                val intent = Intent(mContext, ProfileActivity::class.java)
                intent.putExtra("id",mData.get(position).buddymeet_userid)
                intent.putExtra("type","MyLead")
                mContext?.startActivity(intent)
            }
        }

        mViewHolder.mBinding.tvDescription.maxLines=1

        mViewHolder.mBinding.othersmore.setOnClickListener {
            mViewHolder.mBinding.tvDescription.maxLines=Integer.MAX_VALUE
            mViewHolder.mBinding.collapse.visibility=View.VISIBLE
            mViewHolder.mBinding.othersmore.visibility=View.GONE
        }

        mViewHolder.mBinding.collapse.setOnClickListener {
            mViewHolder.mBinding.tvDescription.maxLines=1
            mViewHolder.mBinding.collapse.visibility=View.GONE
            mViewHolder.mBinding.othersmore.visibility=View.VISIBLE
        }

        if(!(mData.get(position).buddymeet_username=="" || mData.get(position).buddymeet_username==null)) {
            mViewHolder.mBinding.name.setText(mData.get(position).buddymeet_username.capitalize())
        }else{
            mViewHolder.mBinding.name.setText("")
        }

        if(!(mData.get(position).buddymeet_description=="" || mData.get(position).buddymeet_description==null)) {
            mViewHolder.mBinding.tvDescription.setText(mData.get(position).buddymeet_description.capitalize())
        }else{
            mViewHolder.mBinding.tvDescription.setText("")
        }

        val Datesub: String = mData.get(position).buddymeet_date
        val inputPattern = "yyyy-MM-dd"
        val outputPattern = "dd"
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

        mViewHolder.mBinding.dateshort.setText(mainstr)

        var time:String=mData.get(position).buddymeet_time
        try {
            val sdf = SimpleDateFormat("HH:mm")
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
            mViewHolder.mBinding.time.setText(time)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

//        mViewHolder.mBinding.time.setText(mData.get(position).buddymeet_time)
        mViewHolder.mBinding.weak.setText(mData.get(position).buddymeet_day)


    }
    private fun PermissionDialog(massage:String){
        val dialog = mContext?.let { Dialog(it) }
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCancelable(false)
        val mbsAddAccountDialog: PlanexpaireddialogBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.planexpaireddialog, null, false)
        dialog?.setContentView(mbsAddAccountDialog.root)
        dialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        mbsAddAccountDialog.massage.setText(massage)

        mbsAddAccountDialog.okbtd.setOnClickListener {
            dialog?.dismiss()
        }
        mbsAddAccountDialog.txtUpgrade.setOnClickListener {
            dialog.dismiss()
            mContext?.startActivity(Intent(mContext, MyMembershipBenefitsActivity::class.java))
        }
        dialog.show()
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(
        itemView: View?,
        val mBinding: AdapterPsBuddyMeetBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}