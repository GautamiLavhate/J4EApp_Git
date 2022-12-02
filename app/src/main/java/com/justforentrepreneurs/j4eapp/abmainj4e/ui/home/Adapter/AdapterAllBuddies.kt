package com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.Adapter

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterAllBuddiesBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.AllBuddies
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.displayToast
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.isInternetAvailable
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.readUsingSharedPreference
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.wordFirstCap
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
//import com.justforentrepreneurs.j4eapp.model.realms.User
//import com.justforentrepreneurs.j4eapp.utils.ContactUtils
//import com.justforentrepreneurs.j4eapp.utils.IntentUtils
//import com.justforentrepreneurs.j4eapp.utils.RealmHelper

class AdapterAllBuddies(activity: FragmentActivity?, companyName: MutableList<AllBuddies>,Type :String,count_available:Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterAllBuddiesBinding
    private var mData: MutableList<AllBuddies> = companyName
    var mContext: Context? = activity
    val type:String=Type
    var count_available1:Int =count_available

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_all_buddies,
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
            mViewHolder.mBinding.namebudd.setText(wordFirstCap(mData.get(position).full_name))
        }else{
            mViewHolder.mBinding.namebudd.setText("")
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

        mViewHolder.mBinding.membership.setText(mData.get(position).membership_name)

        mContext?.let {
            Glide.with(it)
                    .load(mData.get(position).profile_pic)
                    .centerCrop()
                    .placeholder(R.drawable.ic_default_user_svg)
                    .into(mBinding.imagevepro)
        }



        mViewHolder.itemView.setOnClickListener {
            if (count_available1==0){
                if (mData.get(position).is_viewed==0){
                    PermissionDialog(readUsingSharedPreference(mContext!!,"ViewExhaustedMsg").toString())
                }else{
                    val intent = Intent(mContext, ProfileActivity::class.java)
                    intent.putExtra("id",mData.get(position).userid)
                    intent.putExtra("type", type)
                    intent.putExtra("position",position.toString())
                    mContext?.startActivity(intent)
                }
            }else{
                val intent = Intent(mContext, ProfileActivity::class.java)
                intent.putExtra("id",mData.get(position).userid)
                intent.putExtra("type", type)
                intent.putExtra("position",position.toString())
                mContext?.startActivity(intent)
            }

        }

        mViewHolder.mBinding.phonecall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + mData.get(position).mobile))
            mContext!!.startActivity(intent)
        }


//        if(!readUsingSharedPreference(mContext!!, "membertyype").toString().equals("1") && !mData.get(position).membership_type.equals("1")) {
//
//
//
//        }else{
//
//
//        }
        if (mData.get(position).whatsapp_no != null && !mData.get(position).whatsapp_no.equals("") ){
            mViewHolder.mBinding.msg.setImageResource(R.drawable.ic_messagepng)
        }else{
            mViewHolder.mBinding.msg.setImageResource(R.drawable.ic_massagepng_disable)
        }
        holder.mBinding.msg.setOnClickListener {

            if (mData.get(position).whatsapp_no != null && !mData.get(position).whatsapp_no.equals("") ){
                val intent = Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://api.whatsapp.com/send?phone="+"+91"+mData.get(position).whatsapp_no + "&text="+"Hello"))
                mContext!!.startActivity(intent)
            }else{
                displayToast(mContext!!,"Invalid Whatsapp number!")
            }



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
        val mBinding: AdapterAllBuddiesBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}