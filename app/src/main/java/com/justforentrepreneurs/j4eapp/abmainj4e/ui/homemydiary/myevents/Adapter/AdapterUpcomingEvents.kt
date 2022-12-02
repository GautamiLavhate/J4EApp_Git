package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.Adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.BuildConfig
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterUpcomingEventsBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment.model.Allevents
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.EventBookingActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.MapsEventsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.MyEventsDetailsActivity
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.fmt
//import com.justforentrepreneurs.j4eapp.model.realms.User
//import com.justforentrepreneurs.j4eapp.utils.ContactUtils
//import com.justforentrepreneurs.j4eapp.utils.IntentUtils
//import com.justforentrepreneurs.j4eapp.utils.RealmHelper

class AdapterUpcomingEvents(activity: FragmentActivity?, companyName: MutableList<Allevents.Alleventsdata>,Backtype:String) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterUpcomingEventsBinding
    private var mData: MutableList<Allevents.Alleventsdata> = companyName
    var mContext: Context? = activity
    var Backtype:String=Backtype
    var SortType:String=""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.adapter_upcoming_events,
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
                    .load(mData.get(position).event_thumbnil)
                    .centerCrop()
                    .into(mBinding.ivImg)
        }

        if(!(mData.get(position).event_title=="" || mData.get(position).event_title==null)) {
            mBinding.eventtitle.setText(mData.get(position).event_title.capitalize())
        }

        if(!mData.get(position).event_type.toString().equals("")){
            mBinding.eventlitext.visibility=View.VISIBLE
            mBinding.eventtype.setText(mData.get(position).event_type)
        }else{
            mBinding.eventlitext.visibility=View.GONE
        }



        mBinding.datetime.setText(mData.get(position).event_startdate)

        if(!(mData.get(position).event_address=="" || mData.get(position).event_address==null)) {
            mBinding.address.setText(mData.get(position).event_address.capitalize())
        }

        if(!readUsingSharedPreference(mContext!!, "membertyype").toString().equals("1")) {

            mBinding.amount.setText("₹ " + fmt(mData.get(position).event_fees))
        }else{
            mBinding.amount.setText("₹ " + fmt(mData.get(position).event_guest_fees))
        }

        if(readUsingSharedPreference(mContext!!, "addpersmisson").toString().equals("1")) {
            mBinding.btpublish.visibility=View.VISIBLE

            if (mData.get(position).event_publish_status.equals("1")) {

                mBinding.btpublish.setImageResource(R.drawable.ab_svg_publish_event)

            }
//            else {
//                mBinding.btpublish.setImageResource(R.drawable.ab_svg_create_event)
//            }
        }else{

            mBinding.btpublish.visibility=View.GONE
        }

        if (mData.get(position).event_organized_by.equals(readUsingSharedPreference(mContext!!,"userid"))){
            mBinding.btpublish.setImageResource(R.drawable.ab_svg_create_event)
        }

        mBinding.orgnaizenumber.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + mData.get(position).event_phno))
            mContext?.startActivity(intent)
        }

        mBinding.tikitbooking.setOnClickListener {
            val intent = Intent(mContext, EventBookingActivity::class.java)
            intent.putExtra("type", "Eventbook")
            intent.putExtra("Back",Backtype)
            intent.putExtra("id",mData.get(position).event_id)
            intent.putExtra("position",position.toString())
            intent.putExtra("event_booked_byuser",mData.get(position).event_booked_byuser)
            mContext?.startActivity(intent)
        }

        mBinding.map.setOnClickListener {
            val intent = Intent(mContext, MapsEventsActivity::class.java)
            intent.putExtra("type", "map")
            intent.putExtra("Back",Backtype)
            intent.putExtra("location", mData.get(position).event_address)
            intent.putExtra("lat",mData.get(position).event_latitude)
            intent.putExtra("long",mData.get(position).event_longitude)
            intent.putExtra("position",position.toString())
            mContext?.startActivity(intent)
        }

        if (mData.get(position).event_sorttype.equals("1")){
            SortType="Upcoming"
        }else if (mData.get(position).event_sorttype.equals("2")){
            SortType="Upcoming"
        }else if (mData.get(position).event_sorttype.equals("3")){
            SortType="past"
        }

        mBinding.eventDetailsRelLay.setOnClickListener(View.OnClickListener {
            val intent = Intent(mContext, MyEventsDetailsActivity::class.java)
            intent.putExtra("type", SortType)
            intent.putExtra("Back",Backtype)
            intent.putExtra("id", mData.get(position).event_id)
            intent.putExtra("position",position.toString())
            mContext!!.startActivity(intent)
        })

        mViewHolder.mBinding.ivshare.setOnClickListener {
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

        if(!readUsingSharedPreference(mContext!!, "membertyype").toString().equals("1") && !mData.get(position).membership_type.equals("1")) {

            mViewHolder.mBinding.msgc.setImageResource(R.drawable.ic_chat_two)

            mViewHolder.mBinding.msgc.setOnClickListener {
                if (mData.get(position).event_organized_by.equals(
                        readUsingSharedPreference(
                            mContext!!,
                            "userid"
                        ).toString()
                    )
                ) {
                    displayToast(mContext!!, "My Event Not Applicable Message")

                } else {

                    val intent = Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://api.whatsapp.com/send?phone="+"+91"+mData.get(position).event_phno + "&text="+"Hello"))
                    mContext!!.startActivity(intent)
                }
            }
        }else{
            mViewHolder.mBinding.msgc.setImageResource(R.drawable.ic_chat_two_disable)
            holder.mBinding.msgc.setOnClickListener {

            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class ItemViewHolder constructor(
            itemView: View?,
            val mBinding: AdapterUpcomingEventsBinding
    ) : RecyclerView.ViewHolder(itemView!!) {
        init {

        }
    }
}