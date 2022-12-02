package com.justforentrepreneurs.j4eapp.abmainj4e.ui.notification


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.ItemNotificationBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.network.model.Datauser
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.MyLeadsDetailActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mybusinesstransactions.MyBusinessTransactionsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.MyConnectionsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.MyEventsDetailsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.PendingResponsibilitiesActivity
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment.NotificationFragment
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myguestinvites.MyGuestInvitesActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.displayToast
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.wordFirstCap
import java.text.DecimalFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class NotificationAdapter(activity: FragmentActivity?, companyName: MutableList<Datauser>,onClick2:NotificationFragment) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: ItemNotificationBinding
    private var mData: MutableList<Datauser> = companyName
    var mContext: Context? = activity
    var onClick3 = onClick2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.item_notification,
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
        mViewHolder.mBinding.notificationText.text=mData.get(position).subject


        val Datesub: String = mData.get(position).created_time

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


        mViewHolder.mBinding.date.text=mainstr
        mContext?.let {
            Glide.with(it)
                    .load(mData.get(position).thumbnil)
                    .into(mBinding.notificationImage)
        }

        if(mData.get(position).type.equals("LeadStatus")){
            mViewHolder.mBinding.leadtitle.text=mData.get(position).subtitle
            mViewHolder.mBinding.leadtitle2.visibility=View.VISIBLE
            mViewHolder.mBinding.udatedbyli.visibility=View.VISIBLE
            mViewHolder.mBinding.Updatedbyname.text=wordFirstCap(mData.get(position).by_user)
            mViewHolder.mBinding.businesswithli.visibility=View.GONE
            mViewHolder.mBinding.transactionacc.visibility=View.GONE
            mViewHolder.mBinding.recommento.visibility=View.GONE
            mViewHolder.mBinding.RecommendedByli.visibility=View.GONE

            if (mData.get(position).note != null){
                if(mData.get(position).note.equals("")||mData.get(position).note.equals(null)){
                    mViewHolder.mBinding.note.visibility=View.GONE
                }else{
                    mViewHolder.mBinding.note.visibility=View.VISIBLE
                    mViewHolder.mBinding.note.text=mData.get(position).note
                }
            }else{
                mViewHolder.mBinding.note.visibility=View.GONE
            }


            mViewHolder.mBinding.reqByli.visibility=View.GONE
            mViewHolder.mBinding.tvconfirm.visibility=View.GONE


            if(mData.get(position).cat_name.equals("Pending")){
                mViewHolder.mBinding.leadtitle2.setTextColor(mContext?.getColor(R.color.pendingst)!!)
            }else  if(mData.get(position).cat_name.equals("Inprogress")){
                mViewHolder.mBinding.leadtitle2.setTextColor(mContext?.getColor(R.color.imaprocessst)!!)
            }else  if(mData.get(position).cat_name.equals("close")){
                mViewHolder.mBinding.leadtitle2.setTextColor(mContext?.getColor(R.color.closest)!!)
            }

            mViewHolder.mBinding.leadtitle2.text=mData.get(position).lead_status



        }else if(mData.get(position).type.equals("BusinessTransaction")) {
            mViewHolder.mBinding.leadtitle.text = mData.get(position).subtitle
            mViewHolder.mBinding.leadtitle2.visibility = View.GONE
            mViewHolder.mBinding.udatedbyli.visibility = View.GONE
            mViewHolder.mBinding.businesswithli.visibility = View.VISIBLE
            mViewHolder.mBinding.transactionacc.visibility = View.VISIBLE
            mViewHolder.mBinding.businesstype.visibility = View.VISIBLE
            mViewHolder.mBinding.Businesswithtx.text = wordFirstCap(mData.get(position).by_user)

            if (mData.get(position).amount.equals("")||mData.get(position).amount.equals(null)) {

            } else{
            val format4: String = DecimalFormat("#,##,##,##,###.00").format(
                mData.get(position).amount.toDouble()!!
            )

            mViewHolder.mBinding.TransactionAmount.text = "₹ " + format4
            }


            mViewHolder.mBinding.recommento.visibility=View.GONE
            mViewHolder.mBinding.RecommendedByli.visibility=View.GONE
            mViewHolder.mBinding.note.visibility=View.GONE
            mViewHolder.mBinding.reqByli.visibility=View.GONE

            if (mData.get(position).business_type == "Received") {
                holder.mBinding.businesstype.setTextColor(mContext?.getColor(R.color.light_green)!!)
            } else if (mData.get(position).business_type == "Given") {
                holder.mBinding.businesstype.setTextColor(mContext?.getColor(R.color.orange)!!)
            }
            mViewHolder.mBinding.businesstype.text=mData.get(position).business_type


            if(mData.get(position).confirm_status.equals("Approved")) {

                mViewHolder.mBinding.tvconfirm.visibility = View.GONE
            }else{
                mViewHolder.mBinding.tvconfirm.visibility = View.VISIBLE
            }

            mViewHolder.mBinding.tvconfirm.setOnClickListener {
                onClick3.OnClick(position,mData.get(position).id,mViewHolder.mBinding.tvconfirm)
            }

        }else if(mData.get(position).type.equals("Connection")|| mData.get(position).type.equals("BuddyMeet") || mData.get(position).type.equals("Followup")
            || mData.get(position).type.equals("Event")){
            mViewHolder.mBinding.leadtitle.visibility=View.GONE
            mViewHolder.mBinding.leadtitle2.visibility=View.GONE
            mViewHolder.mBinding.businesswithli.visibility=View.GONE
            mViewHolder.mBinding.transactionacc.visibility=View.GONE
            mViewHolder.mBinding.Businesswithtx.visibility=View.GONE
            mViewHolder.mBinding.TransactionAmount.visibility=View.GONE
            mViewHolder.mBinding.businesstype.visibility=View.GONE
            mViewHolder.mBinding.recommento.visibility=View.GONE
            mViewHolder.mBinding.udatedbyli.visibility=View.GONE
            mViewHolder.mBinding.RecommendedByli.visibility=View.GONE
            mViewHolder.mBinding.note.visibility=View.GONE
            mViewHolder.mBinding.reqByli.visibility=View.VISIBLE
            mViewHolder.mBinding.Byre.text= wordFirstCap(mData.get(position).by_user)

            mViewHolder.mBinding.tvconfirm.visibility=View.GONE


        }else if(mData.get(position).type.equals("InviteApproval")) {
            mViewHolder.mBinding.leadtitle.text = mData.get(position).subtitle
            mViewHolder.mBinding.leadtitle2.visibility = View.GONE
            mViewHolder.mBinding.udatedbyli.visibility = View.GONE
            mViewHolder.mBinding.businesswithli.visibility = View.VISIBLE
            mViewHolder.mBinding.transactionacc.visibility = View.VISIBLE
            mViewHolder.mBinding.Businesswith.text="Invited By:"
            mViewHolder.mBinding.TransactionAmountst.text="Amount:"
            mViewHolder.mBinding.Businesswithtx.text = wordFirstCap(mData.get(position).by_user)

            if (mData.get(position).amount.equals("")||mData.get(position).amount.equals(null)) {

            } else{
                val format4: String = DecimalFormat("#,##,##,##,###.00").format(
                    mData.get(position).amount.toDouble()!!
                )

                mViewHolder.mBinding.TransactionAmount.text = "₹ " + format4
            }


            mViewHolder.mBinding.recommento.visibility=View.GONE
            mViewHolder.mBinding.RecommendedByli.visibility=View.GONE
            mViewHolder.mBinding.note.visibility=View.GONE
            mViewHolder.mBinding.reqByli.visibility=View.GONE
            mViewHolder.mBinding.businesstype.visibility=View.GONE


            if(mData.get(position).confirm_status.equals("Approved")) {

                mViewHolder.mBinding.tvconfirm.visibility = View.GONE
            }else{
                mViewHolder.mBinding.tvconfirm.visibility = View.VISIBLE
            }

            mViewHolder.mBinding.tvconfirm.setOnClickListener {
                val intent = Intent(mContext, MyGuestInvitesActivity::class.java)
                intent.putExtra("id", mData.get(position).id)
                intent.putExtra("noti", "notification")
                mContext?.startActivity(intent)

            }

        }else{
            mViewHolder.mBinding.tvconfirm.visibility = View.GONE
        }


        mViewHolder.itemView.setOnClickListener {
            if (mData.get(position).type.equals("Connection")) {
                if(mData.get(position).subject.equals("Connection Request Accepted")) {
                    val intent = Intent(mContext, MyConnectionsActivity::class.java)
                    intent.putExtra("hometype", "0")
                    intent.putExtra("type", "notificationSend")
                    mContext?.startActivity(intent)
                }else{
                    val intent = Intent(mContext, MyConnectionsActivity::class.java)
                    intent.putExtra("hometype", "0")
                    intent.putExtra("type", "notification")
                    mContext?.startActivity(intent)
                }

            } else if (mData.get(position).type.equals("BuddyMeet")) {
                val intent = Intent(mContext, PendingResponsibilitiesActivity::class.java)
                intent.putExtra("type", "1")
                intent.putExtra("noti", "notification")
                mContext?.startActivity(intent)

            } else if (mData.get(position).type.equals("Followup")) {
                val intent = Intent(mContext, PendingResponsibilitiesActivity::class.java)
                intent.putExtra("type", "2")
                intent.putExtra("noti", "notification")
                mContext?.startActivity(intent)

            } else if (mData.get(position).type.equals("Event")) {
                val intent = Intent(mContext, MyEventsDetailsActivity::class.java)
                intent.putExtra("type", "upcoming")
                intent.putExtra("Back", "activity")
                intent.putExtra("id", mData.get(position).id)
                intent.putExtra("noti", "notification")
                mContext!!.startActivity(intent)
            } else if (mData.get(position).type.equals("BusinessTransaction")) {
                val intent = Intent(mContext, MyBusinessTransactionsActivity::class.java)
                intent.putExtra("noti", "notification")
                mContext?.startActivity(intent)

            } else if (mData.get(position).type.equals("LeadStatus")) {
                val intent = Intent(mContext, MyLeadsDetailActivity::class.java)
                intent.putExtra("type", "MyLead")
                intent.putExtra("id", mData.get(position).id)
                intent.putExtra("own","own")
                intent.putExtra("noti", "notification")
                mContext?.startActivity(intent)
            }else if(mData.get(position).type.equals("InviteApproval")) {
                val intent = Intent(mContext, MyGuestInvitesActivity::class.java)
                intent.putExtra("id", mData.get(position).id)
                intent.putExtra("noti", "notification")
                mContext?.startActivity(intent)
            }
        }
    }

    interface OnClick2 {
        fun OnClick(position: Int,data:String,Text:TextView)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(
            itemView: View?,
            val mBinding: ItemNotificationBinding
    ) :
            RecyclerView.ViewHolder(itemView!!)
}