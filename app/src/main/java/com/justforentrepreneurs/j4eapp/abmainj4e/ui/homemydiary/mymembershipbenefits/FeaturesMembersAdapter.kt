package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits

import android.annotation.SuppressLint
import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.MembershipFeatureslist
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.Utility
import com.justforentrepreneurs.j4eapp.databinding.FeaturesmembersAdapterBinding


class FeaturesMembersAdapter(activity: FragmentActivity?, companyName: MutableList<MembershipFeatureslist>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: FeaturesmembersAdapterBinding
    private var mData: MutableList<MembershipFeatureslist> = companyName
    var mContext: Context? = activity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.featuresmembers_adapter,
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
        mViewHolder.mBinding.webViewTitile.setVerticalScrollBarEnabled(false)
        mViewHolder.mBinding.webViewTitile.setOnLongClickListener(OnLongClickListener { true })
        mViewHolder.mBinding.webViewTitile.setLongClickable(false)
        mViewHolder.mBinding.webViewTitile.setHapticFeedbackEnabled(false)
        //                       String str= HtmlCompat.fromHtml(description, HtmlCompat.FROM_HTML_MODE_LEGACY).toString();
//                       String htmlData = Utility.getJustifyString(str);
        val htmlData: String = Utility.getJustifyString(mData.get(position).FeaturesDesc)
        mViewHolder.mBinding.webViewTitile.loadData(htmlData, "text/html; charset=utf-8", "utf-8")
        mViewHolder.mBinding.featuestxt.text= Html.fromHtml(mData.get(position).FeaturesDesc)

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
            val mBinding: FeaturesmembersAdapterBinding
    ) :
            RecyclerView.ViewHolder(itemView!!)
}