package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers

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
import com.justforentrepreneurs.j4eapp.databinding.AdapterJ4eMemberBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.interfaces.OnClickLinerJ4e
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.Datauser
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.Memberinfo
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.displayToast
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.readUsingSharedPreference
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.wordFirstCap
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
//import com.justforentrepreneurs.j4eapp.utils.IntentUtils


class AdapterJ4EMember(activity: FragmentActivity?
                       ,is_connection_exhausted: Int,
                       j4emember: MutableList<Memberinfo>,
                       val OnClickLinerJ4e: OnClickLinerJ4e) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterJ4eMemberBinding
    private var mData: MutableList<Memberinfo> = j4emember
    var mContext: Context? = activity
    var exhausted: Int = is_connection_exhausted

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.adapter_j4e_member,
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
        }

        if(!(mData.get(position).designation==""  || mData.get(position).designation==null)) {
            mViewHolder.mBinding.designation.setText(mData.get(position).designation.capitalize())
        }

        if(!(mData.get(position).company_address=="" || mData.get(position).company_address==null)) {
            mViewHolder.mBinding.address.setText(mData.get(position).company_address.capitalize())
        }

        mViewHolder.mBinding.membership.setText(mData.get(position).membership_name)

        if (mData.get(position).is_viewed==0){
            mViewHolder.mBinding.phonecall.setImageResource(R.drawable.ic_budy_call_disable)
        }else{
            mViewHolder.mBinding.phonecall.setImageResource(R.drawable.ic_call_green)
            mViewHolder.mBinding.phonecall.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + mData.get(position).mobile))
                mContext!!.startActivity(intent)
            }
        }
        if(mData.get(position).check_connection=="No") {
            if (mData.get(position).is_viewed==0){
                mViewHolder.mBinding.connect.setImageResource(R.drawable.ic_connected_disable)
            }else{
                mViewHolder.mBinding.connect.setImageResource(R.drawable.ic_not_connected)
                mViewHolder.mBinding.connect.setOnClickListener {
                    if (exhausted==0){
                        OnClickLinerJ4e.onClickPos(position,mData,mViewHolder.mBinding.connect)
                        notifyDataSetChanged()
                    }else{
                        PermissionDialog(readUsingSharedPreference(mContext!!,"CreatePermissionMsg").toString())
                    }
                }
            }


        }else{
            if (mData.get(position).is_viewed==0){
                mViewHolder.mBinding.connect.setImageResource(R.drawable.ic_coonect_disable)
            }else{
                mViewHolder.mBinding.connect.setImageResource(R.drawable.ic_connect)
            }


        }

        mContext?.let {
            Glide.with(it)
                .load(mData.get(position).profile_pic)
                .centerCrop()
                .placeholder(R.drawable.ic_profile_edit)
                .into(mBinding.imagevepro)
        }

        mViewHolder.mBinding.imagevepro.setOnClickListener {
              OnClickLinerJ4e.OnClickpro(position,mData.get(position).id,mData.get(position).is_viewed)

        }

        mViewHolder.mBinding.linearlayoutProfileDetail.setOnClickListener {
            OnClickLinerJ4e.OnClickpro(position,mData.get(position).id,mData.get(position).is_viewed)
        }

//        if(!readUsingSharedPreference(mContext!!, "membertyype").toString().equals("1") && !mData.get(position).membership_type.equals("1")) {
//
//            if (mData.get(position).is_viewed==0){
//                mViewHolder.mBinding.messageid.setImageResource(R.drawable.ic_buddy_message_disable)
//            }else{
////                if (mData.get(position).company_whatsapp_no != null && !mData.get(position).company_whatsapp_no.equals("") ){
////                    mViewHolder.mBinding.messageid.setImageResource(R.drawable.ic_messagepng)
////                }else
//                if (mData.get(position).whatsapp_no != null && !mData.get(position).whatsapp_no.equals("") ){
//                    mViewHolder.mBinding.messageid.setImageResource(R.drawable.ic_messagepng)
//                }else{
//                    mViewHolder.mBinding.messageid.setImageResource(R.drawable.ic_buddy_message_disable)
//                }
//
//                mViewHolder.mBinding.messageid.setOnClickListener {
//
////                    if (mData.get(position).company_whatsapp_no != null && !mData.get(position).company_whatsapp_no.equals("") ){
////                        val intent = Intent(Intent.ACTION_VIEW,
////                            Uri.parse("http://api.whatsapp.com/send?phone="+"+91"+mData.get(position).company_whatsapp_no + "&text="+"Hello"))
////                        mContext!!.startActivity(intent)
////                    }else
//                    if (mData.get(position).whatsapp_no != null && !mData.get(position).whatsapp_no.equals("") ){
//                        val intent = Intent(Intent.ACTION_VIEW,
//                            Uri.parse("http://api.whatsapp.com/send?phone="+"+91"+mData.get(position).whatsapp_no + "&text="+"Hello"))
//                        mContext!!.startActivity(intent)
//                    }else{
//                        displayToast(mContext!!,"Invalid Whatsapp number!")
//                    }
//                }
//
//            }
//
//
//        }else{
//            if (mData.get(position).is_viewed==0){
//                mViewHolder.mBinding.messageid.setImageResource(R.drawable.ic_buddy_message_disable)
//            }else{
//                mViewHolder.mBinding.messageid.setImageResource(R.drawable.ic_massagepng_disable)
//            }
//
//        }

        if (mData.get(position).is_viewed==0){
            mViewHolder.mBinding.messageid.setImageResource(R.drawable.ic_buddy_message_disable)
        }else{
//                if (mData.get(position).company_whatsapp_no != null && !mData.get(position).company_whatsapp_no.equals("") ){
//                    mViewHolder.mBinding.messageid.setImageResource(R.drawable.ic_messagepng)
//                }else
            if (mData.get(position).whatsapp_no != null && !mData.get(position).whatsapp_no.equals("") ){
                mViewHolder.mBinding.messageid.setImageResource(R.drawable.ic_messagepng)
            }else{
                mViewHolder.mBinding.messageid.setImageResource(R.drawable.ic_buddy_message_disable)
            }

            mViewHolder.mBinding.messageid.setOnClickListener {

//                    if (mData.get(position).company_whatsapp_no != null && !mData.get(position).company_whatsapp_no.equals("") ){
//                        val intent = Intent(Intent.ACTION_VIEW,
//                            Uri.parse("http://api.whatsapp.com/send?phone="+"+91"+mData.get(position).company_whatsapp_no + "&text="+"Hello"))
//                        mContext!!.startActivity(intent)
//                    }else
                if (mData.get(position).whatsapp_no != null && !mData.get(position).whatsapp_no.equals("") ){
                    val intent = Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://api.whatsapp.com/send?phone="+"+91"+mData.get(position).whatsapp_no + "&text="+"Hello"))
                    mContext!!.startActivity(intent)
                }else{
                    displayToast(mContext!!,"Invalid Whatsapp number!")
                }
            }

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
        val mBinding: AdapterJ4eMemberBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)

    private fun PermissionDialog(massage:String){
        val dialog = mContext?.let { Dialog(it) }
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCancelable(false)
        val mbsAddAccountDialog: PlanexpaireddialogBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.planexpaireddialog, null, false)
        dialog?.setContentView(mbsAddAccountDialog.root)
        dialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        mbsAddAccountDialog.massage.setText(massage)

        mbsAddAccountDialog.okbtd.setOnClickListener {
            dialog.dismiss()
        }
        mbsAddAccountDialog.txtUpgrade.setOnClickListener {
            dialog.dismiss()
            mContext?.startActivity(Intent(mContext, MyMembershipBenefitsActivity::class.java))
        }
        dialog.show()
    }
}