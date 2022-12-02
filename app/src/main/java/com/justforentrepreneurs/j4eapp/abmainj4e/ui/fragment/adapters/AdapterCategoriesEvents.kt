package com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.SingleSlection
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment.AllEventsFragment
import com.justforentrepreneurs.j4eapp.databinding.CheckboxAdapterBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.Eventcategory

class AdapterCategoriesEvents(activity: FragmentActivity?,
                              companyName: MutableList<Eventcategory.Eventdata>,var multiSelection: SingleSlection) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: CheckboxAdapterBinding
    private var mData: MutableList<Eventcategory.Eventdata> = companyName


    var mContext: Context? = activity

    var selected_position = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.checkbox_adapter,
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
         mViewHolder.mBinding.catename.text=mData.get(position).cat_name


        //if true, your checkbox will be selected, else unselected
        //   engineViewHolder.chk1bhk.setChecked(timeslot.isSelected());
        if (!(AllEventsFragment.lstChk.size == 0)) {
            for (i in 0 until AllEventsFragment.lstChk.size) {
                if (AllEventsFragment.lstChk.get(i).cat_id.equals(mData.get(position).cat_id)) {
                    mViewHolder.mBinding.checkBox1.setChecked(true)
                    mData.get(position).isSelected=true
                }
            }
        }

        mViewHolder.mBinding.checkBox1.setChecked(mData.get(position).isSelected)

        mViewHolder.mBinding.checkBox1.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked -> //set your object's last status
            // timeslot.setSelected(isChecked);
            if (mData.get(position).isSelected){
                mData.get(position).isSelected=false
                buttonView.isChecked = false
                multiSelection!!.removeMultiSelection(mData,mData.get(position).cat_id,position)
            } else {
                buttonView.isChecked = true
                mData.get(position).isSelected=true
                multiSelection!!.addMultiSelection(mData,position)
            }

        })

        mViewHolder.itemView.setOnClickListener {
            selected_position = position
           // onClick2.OnClickFunctionalArea(mData.get(selected_position).cat_id)
          //  notifyDataSetChanged()
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
            val mBinding: CheckboxAdapterBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}