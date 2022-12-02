package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.searchalldata

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterSearchdatatypeBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.MyLeadsDetailActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.MyEventsDetailsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrecognition.MyRecognitionActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.searchalldata.model.SearchM
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity

class AdapterSearchTpedata (activity: FragmentActivity?, companyName: MutableList<SearchM.UserData.DataType>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterSearchdatatypeBinding
    private var mData: MutableList<SearchM.UserData.DataType> = companyName
    var mContext: Context? = activity


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.adapter_searchdatatype,
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
        if(!(mData.get(position).title=="" || mData.get(position).title==null)) {
            mViewHolder.mBinding.title.setText(mData.get(position).title.capitalize())
        }else{
            mViewHolder.mBinding.title.setText("")
        }

        //POST / EVENT /  RECOGNITION /  LEAD  /  J4EMEMBER /  BUDDYMEET

        mViewHolder.itemView.setOnClickListener {
            if (mData.get(position).type.equals("POST")) {
                val intent = Intent(mContext, MainActivity::class.java)
                intent.putExtra("hometype", "4")
                intent.putExtra("type", "hometype")
                intent.putExtra("position", "0")
                mContext?.startActivity(intent)

            } else if (mData.get(position).type.equals("BUDDY")) {
           /*     val intent = Intent(mContext, PendingResponsibilitiesActivity::class.java)
                intent.putExtra("type", "1")
                intent.putExtra("search", "search")
                mContext?.startActivity(intent)*/
                val intent = Intent(mContext, ProfileActivity::class.java)
                intent.putExtra("id",mData.get(position).id)
                intent.putExtra("type","MyLead")
                mContext!!.startActivity(intent)

            } else if (mData.get(position).type.equals("RECOGNITION")) {
                val intent = Intent(mContext, MyRecognitionActivity::class.java)
                intent.putExtra("type", "all_recognition")
                intent.putExtra("noti", "serach")
                mContext?.startActivity(intent)

            } else if (mData.get(position).type.equals("EVENT")) {
                val intent = Intent(mContext, MyEventsDetailsActivity::class.java)
                intent.putExtra("type", "upcoming")
                intent.putExtra("Back", "activity")
                intent.putExtra("id", mData.get(position).id)
                mContext!!.startActivity(intent)
            } else if (mData.get(position).type.equals("J4EMEMBER")) {
                val intent = Intent(mContext, ProfileActivity::class.java)
                intent.putExtra("id",mData.get(position).id)
                intent.putExtra("type","MyLead")
                mContext!!.startActivity(intent)

            } else if (mData.get(position).type.equals("LEAD")) {
                val intent = Intent(mContext, MyLeadsDetailActivity::class.java)
                intent.putExtra("type", "MyLead")
                intent.putExtra("id", mData.get(position).id)
                intent.putExtra("own","own")
                intent.putExtra("noti", "serach")
                mContext?.startActivity(intent)
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
            val mBinding: AdapterSearchdatatypeBinding
    ) :
            RecyclerView.ViewHolder(itemView!!)
}