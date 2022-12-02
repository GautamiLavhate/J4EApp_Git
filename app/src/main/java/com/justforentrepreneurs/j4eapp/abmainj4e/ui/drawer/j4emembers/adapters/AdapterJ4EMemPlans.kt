package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.CheckBoxPlanBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.FilterPlan



class AdapterJ4EMemPlans(
        activity: FragmentActivity?,
        companyName: MutableList<FilterPlan.DataFilter>, onClick2:OnClick2,lacheck:String) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: CheckBoxPlanBinding
    private var mData: MutableList<FilterPlan.DataFilter> = companyName
    var mContext: Context? = activity
    public var onClick2 = onClick2;
    private var lastChecked: RadioButton? = null
    private var lastCheckedPos = 1
    private var lacheck :String=lacheck



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.check_box_plan,
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
        mViewHolder.mBinding.radiobtd.text = mData.get(position).membership_title
        holder.mBinding.radiobtd.setChecked(mData.get(position).isSelected)
        holder.mBinding.radiobtd.setTag(position)

        //for default check in first item

        if(lacheck==mData.get(position).membership_id){
            lastChecked = holder.mBinding.radiobtd
            lastChecked!!.setChecked(true)
            lastCheckedPos=position
            mData.get(lastCheckedPos).isSelected=true

        }else{

        }


      /*  //for default check in first item
        if (lastCheckedPos == 0 && mData.get(0).isSelected &&  holder.mBinding.radiobtd.isChecked()) {
            lastChecked = holder.mBinding.radiobtd
            lastCheckedPos = 0
        }*/

        holder.mBinding.radiobtd.setOnClickListener(View.OnClickListener { v ->
            val cb = v as RadioButton
            val clickedPos = (cb.tag as Int).toInt()
            if (cb.isChecked) {
                if (lastChecked != null) {
                    lastChecked!!.setChecked(false)

                    mData.get(lastCheckedPos).isSelected=false
                }
                lastChecked = cb
                lastCheckedPos = clickedPos
            } else {
                lastChecked = null
                lastCheckedPos=0
            }
            mData.get(clickedPos).isSelected=cb.isChecked
            onClick2.OnClickPlan(mData[position].membership_title,mData[position].membership_id)
        })



    }

    interface OnClick2 {
        fun OnClickPlan(position: String,id:String)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ItemViewHolder internal constructor(
            itemView: View?,
            val mBinding: CheckBoxPlanBinding
    ) :
            RecyclerView.ViewHolder(itemView!!)

}