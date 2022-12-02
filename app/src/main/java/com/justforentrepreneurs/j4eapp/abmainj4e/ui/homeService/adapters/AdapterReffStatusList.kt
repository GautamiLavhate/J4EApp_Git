package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.RefrralSingleSlection
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.Reffralcategory
import com.justforentrepreneurs.j4eapp.databinding.ReffralcheckboxAdapterBinding

class AdapterReffStatusList(activity: FragmentActivity?, companyName: MutableList<Reffralcategory.ReffralcategoryData>,
                            var multiSelection: RefrralSingleSlection
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: ReffralcheckboxAdapterBinding
    private var mData: MutableList<Reffralcategory.ReffralcategoryData> = companyName


    var mContext: Context? = activity

    var selected_position = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.reffralcheckbox_adapter,
            parent,
            false
        )
        return ItemViewHolder(
            mBinding.root,
            mBinding
        )
    }

    interface OnClick2 {
        fun OnClick(id: String)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mViewHolder = holder as ItemViewHolder
        mViewHolder.mBinding.catename.text=mData.get(position).title


        mViewHolder.mBinding.checkBox1.setChecked(mData.get(position).isSelected)

        mViewHolder.mBinding.checkBox1.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked -> //set your object's last status
            // timeslot.setSelected(isChecked);
            if (mData.get(position).isSelected){
                mData.get(position).isSelected=false
                buttonView.isChecked = false
                multiSelection!!.removeMultiSelection(mData,mData.get(position).id,position)
            } else {
                buttonView.isChecked = true
                mData.get(position).isSelected=true
                multiSelection!!.addMultiSelection(mData,position)
            }

        })

        mViewHolder.itemView.setOnClickListener {
            selected_position = position

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
        val mBinding: ReffralcheckboxAdapterBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}