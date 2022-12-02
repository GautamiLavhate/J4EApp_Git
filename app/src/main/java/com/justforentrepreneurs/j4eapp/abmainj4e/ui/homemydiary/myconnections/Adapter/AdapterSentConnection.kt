package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Adapter

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
import com.justforentrepreneurs.j4eapp.abmainj4e.OnClickLiner
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterSentConnectionBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.DataReceived
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.readUsingSharedPreference
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.wordFirstCap
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding

class AdapterSentConnection(activity: FragmentActivity?, companyName: MutableList<DataReceived>, var OnClicklk: OnClickLiner,
                            fragment:String,count_available:Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterSentConnectionBinding
    private var mData: MutableList<DataReceived> = companyName
    var mContext: Context? = activity
    private val fragmentst:String=fragment
    var count_available1: Int =count_available

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_sent_connection,
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

        if(!(mData.get(position).full_name=="" || mData.get(position).full_name==null)) {
            mViewHolder.mBinding.memname.setText(wordFirstCap(mData.get(position).full_name))
        }else{
            mViewHolder.mBinding.memname.setText("")
        }

        if(!(mData.get(position).designation=="" || mData.get(position).designation==null)) {
            mViewHolder.mBinding.designation.setText(mData.get(position).designation.capitalize())
        }else{
            mViewHolder.mBinding.designation.setText("")
        }

        if(!(mData.get(position).company_name=="" || mData.get(position).company_name==null)) {
            mViewHolder.mBinding.companyName.setText(mData.get(position).company_name.capitalize())
        }else{
            mViewHolder.mBinding.companyName.setText("")
        }


        mContext?.let {
            Glide.with(it)
                    .load(mData.get(position).profile_pic)
                    .centerCrop()
                    .placeholder(R.drawable.ic_profile_edit)
                    .into(mBinding.ivProfileImg)
        }
        if (!mData.get(position).userid.equals(readUsingSharedPreference(mContext!!,"userid"))){
            if (mData.get(position).is_viewed==0){
                mBinding.ivProfileImg.setBorderColor(mContext?.resources!!.getColor(R.color.red))
            }else{
                mBinding.ivProfileImg.setBorderColor(mContext?.resources!!.getColor(R.color.imaprocessst))
            }
        }

        mViewHolder.mBinding.ivProfileImg.setOnClickListener {
            if (count_available1==0){
                if (mData.get(position).is_viewed==0){
                    PermissionDialog(readUsingSharedPreference(mContext!!,"ViewExhaustedMsg").toString())
                }else{
                    mContext?.startActivity(Intent(mContext, ProfileActivity::class.java))
                    val intent = Intent(mContext, ProfileActivity::class.java)
                    intent.putExtra("id",mData.get(position).userid)
                    intent.putExtra("type", "SentConnection"+fragmentst)
                    intent.putExtra("position",position.toString())
                    mContext?.startActivity(intent)
                }
            }else{
                mContext?.startActivity(Intent(mContext, ProfileActivity::class.java))
                val intent = Intent(mContext, ProfileActivity::class.java)
                intent.putExtra("id",mData.get(position).userid)
                intent.putExtra("type", "SentConnection"+fragmentst)
                intent.putExtra("position",position.toString())
                mContext?.startActivity(intent)
            }

        }
        mViewHolder.mBinding.linearlayoutProfileDetail.setOnClickListener {
            if (count_available1==0){
                if (mData.get(position).is_viewed==0){
                    PermissionDialog(readUsingSharedPreference(mContext!!,"ViewExhaustedMsg").toString())
                }else{
                    mContext?.startActivity(Intent(mContext, ProfileActivity::class.java))
                    val intent = Intent(mContext, ProfileActivity::class.java)
                    intent.putExtra("id",mData.get(position).userid)
                    intent.putExtra("type", "SentConnection"+fragmentst)
                    intent.putExtra("position",position.toString())
                    mContext?.startActivity(intent)
                }
            }else{
                mContext?.startActivity(Intent(mContext, ProfileActivity::class.java))
                val intent = Intent(mContext, ProfileActivity::class.java)
                intent.putExtra("id",mData.get(position).userid)
                intent.putExtra("type", "SentConnection"+fragmentst)
                intent.putExtra("position",position.toString())
                mContext?.startActivity(intent)
            }

        }

        if(mData.get(position).connection_status=="0") {
            mViewHolder.mBinding.tvStatus.text = "  Pending  "
            mViewHolder.mBinding.tvStatus.setTextColor(mContext!!.resources.getColor(R.color.md_grey_dark))
            mViewHolder.mBinding.fabClose.visibility = View.VISIBLE
            mViewHolder.mBinding.fabAccept.visibility = View.GONE

            mViewHolder.mBinding.fabAccept.setOnClickListener {
                OnClicklk.onClickPos(position, "1", mViewHolder.mBinding.fabAccept, mData)
            }
        } else if (mData.get(position).connection_status=="1") {
            mViewHolder.mBinding.tvStatus.text = "Connected"
            mViewHolder.mBinding.tvStatus.setTextColor(mContext!!.resources.getColor(R.color.md_green_light))
            mViewHolder.mBinding.fabClose.visibility = View.GONE
            mViewHolder.mBinding.fabAccept.visibility = View.VISIBLE
        }else {
            mViewHolder.mBinding.tvStatus.text = "Pending"
            mViewHolder.mBinding.tvStatus.setTextColor(mContext!!.resources.getColor(R.color.md_grey_dark))
            mViewHolder.mBinding.fabClose.visibility = View.VISIBLE
            mViewHolder.mBinding.fabAccept.visibility = View.GONE
        }

        mViewHolder.mBinding.fabClose.setOnClickListener {
            OnClicklk.onClickDcline(position,mData)
            //mData.removeAt(position)
            notifyDataSetChanged()
        }
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
        val mBinding: AdapterSentConnectionBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}