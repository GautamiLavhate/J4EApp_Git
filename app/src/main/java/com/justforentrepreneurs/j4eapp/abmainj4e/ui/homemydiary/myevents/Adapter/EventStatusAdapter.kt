package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.Adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.ItemEventStatusBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.EventStatusActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.model.EventStatus
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.wordFirstCap

class EventStatusAdapter(activity: FragmentActivity?, companyName: MutableList<EventStatus.EventStatusdata>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: ItemEventStatusBinding
    private var mData: MutableList<EventStatus.EventStatusdata> = companyName
    var mContext: Context? = activity
    private var filterHelper: EventStatusActivity.ContactFiltershareHelper? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.item_event_status,
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
        holder.mBinding.userName.text=mData.get(position).srno+". "+wordFirstCap(mData.get(position).username)
        holder.mBinding.status.text=mData.get(position).statustype
        if (mData.get(position).statustype == "Intrested") {
            holder.mBinding.status.setTextColor(mContext?.getColor(R.color.md_green_light)!!)
        } else if (mData.get(position).statustype == "Attending") {
            holder.mBinding.status.setTextColor(mContext?.getColor(R.color.colorPrimary)!!)
        } else if (mData.get(position).statustype == "May Be") {
            holder.mBinding.status.setTextColor(mContext?.getColor(R.color.colorMayBeStatus)!!)
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
            val mBinding: ItemEventStatusBinding
    ) :
            RecyclerView.ViewHolder(itemView!!)



    private val searchArrayList: MutableList<EventStatus.EventStatusdata> = mData

    // song
    fun setProduct(categoryList: MutableList<EventStatus.EventStatusdata>) {
        this.mData = categoryList
    }

    fun getFilter(): Filter? {
        if (filterHelper == null) {
            filterHelper = EventStatusActivity.ContactFiltershareHelper(searchArrayList, this )
        }
        return filterHelper
    }

    fun refresh() {
        notifyDataSetChanged()
    }
}