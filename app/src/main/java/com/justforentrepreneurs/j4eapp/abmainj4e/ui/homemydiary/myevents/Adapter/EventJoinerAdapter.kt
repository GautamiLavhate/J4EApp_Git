package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.Adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.ItemEventJoinerBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.Datauser
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.EventJoinerActivity
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.EventStatusActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.model.EventRegister
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.model.EventStatus
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.wordFirstCap


class EventJoinerAdapter(activity: FragmentActivity?, companyName: MutableList<EventRegister.Datauser>, onClick2: EventJoinerActivity) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: ItemEventJoinerBinding
    private var mData: MutableList<EventRegister.Datauser> = companyName
    var mContext: Context? = activity
    var onClick3 = onClick2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.item_event_joiner,
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
        holder.mBinding.userName.text=(wordFirstCap(mData.get(position).username))
        holder.mBinding.designation.text=mData.get(position).designation

        mContext?.let {
            Glide.with(it)
                .load(mData?.get(position)?.userimage)
                .centerCrop()
                .placeholder(R.drawable.ic_profile_edit)
                .into(mBinding.userImage)
        }

        if(mData.get(position).check_connection=="0") {

            holder.mBinding.imageViewLinLay.visibility=View.VISIBLE

        }else{

            holder.mBinding.imageViewLinLay.visibility=View.GONE

        }

        if(mData.get(position).event_attedance.toString().equals("1")) {
            holder.mBinding.connectedLabel.visibility=View.GONE

        }else if(mData.get(position).event_attedance.toString().equals("2")) {
            holder.mBinding.connectedLabel.visibility=View.VISIBLE
            holder.mBinding.connectedLabel.text="Absent"

        }else{
            holder.mBinding.connectedLabel.visibility=View.GONE

       }

        holder.mBinding.userImage.setOnClickListener {
            onClick3.OnClickpro(position,mData.get(position).userid)
        }

    }

    interface OnClick2 {
        fun OnClick(position: Int,mdata:MutableList<Datauser>,lilayout:LinearLayout)
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
            val mBinding: ItemEventJoinerBinding
    ) :
            RecyclerView.ViewHolder(itemView!!)

}