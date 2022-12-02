package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.AdapterRecommendPersonBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.AllBuddies
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.displayToast
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.wordFirstCap

class AdapterRecommendPerson(activity: FragmentActivity?, companyName: MutableList<AllBuddies>, confirm:Button) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: AdapterRecommendPersonBinding
    private var mData:  MutableList<AllBuddies>  = companyName
    var mContext: Context? = activity
    val confirm:Button=confirm

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.adapter_recommend_person, parent, false)
        return ItemViewHolder(mBinding.root, mBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mViewHolder = holder as ItemViewHolder

        mViewHolder.mBinding.fullname.setText(wordFirstCap(mData.get(position).full_name))

        mViewHolder.mBinding.remove.setOnClickListener {
            mData.removeAt(position)
            notifyDataSetChanged()
            mContext?.let { it1 -> displayToast(it1, "remove user")
                if (mData.size != 0) {

                } else {
                    confirm.background=mContext?.getResources()?.getDrawable(R.drawable.disable_btd)
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
        val mBinding: AdapterRecommendPersonBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}