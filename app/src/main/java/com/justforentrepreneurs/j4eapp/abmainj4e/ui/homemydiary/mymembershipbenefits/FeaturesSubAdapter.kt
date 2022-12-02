package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.LayPalnFeaturesAdapterBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.MembershipFeaturesm

class FeaturesSubAdapter(activity: FragmentActivity?, companyName: MutableList<MembershipFeaturesm>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: LayPalnFeaturesAdapterBinding
    private var mData: MutableList<MembershipFeaturesm> = companyName
    var mContext: Context? = activity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.lay_paln_features_adapter,
                parent,
                false
        )
        return ItemViewHolder(
                mBinding.root,
                mBinding
        )
    }

    @SuppressLint("ResourceType")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mViewHolder = holder as ItemViewHolder
        mViewHolder.mBinding.Animation2d.text= Html.fromHtml(mData.get(position).FeaturesName.toString())



        if (position % 2 == 1) {
            mViewHolder.mBinding.Libackground.setBackgroundColor(Color.parseColor("#FFFFFF"))
        } else {
            mViewHolder.mBinding.Libackground.setBackgroundColor(Color.parseColor("#E7F1F9"))
        }

      //  if(mData )


    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(
            itemView: View?,
            val mBinding: LayPalnFeaturesAdapterBinding
    ) :
            RecyclerView.ViewHolder(itemView!!)
}