package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.adapters.AdapterJ4EMemPlans
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.FilterPlan
import com.justforentrepreneurs.j4eapp.databinding.CheckBoxPlanBinding
import com.justforentrepreneurs.j4eapp.databinding.ItemPackageBinding

class AdapterPackage(
    activity: FragmentActivity?,
    companyName: MutableList<FilterPlan.DataFilter>,
    onClick: OnClickPackage):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var mBinding: ItemPackageBinding
    private var mData: MutableList<FilterPlan.DataFilter> = companyName
    var mContext: Context? = activity
    var onClickPack=onClick
    var package_array= ArrayList<String>()
    var package_name_array = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.item_package,
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
        mViewHolder.mBinding.radiobtd.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                package_array.add(mData.get(position).membership_id)
                package_name_array.add(mData.get(position).membership_title)
            }else{
                package_array.remove(mData.get(position).membership_id)
                package_name_array.remove(mData.get(position).membership_title)
            }
            onClickPack.OnClickPackage(mData.get(position).membership_title,mData.get(position).membership_id,package_array,package_name_array)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return mData.size
    }
    interface OnClickPackage {
        fun OnClickPackage(packageName: String,packageId:String,package_array:ArrayList<String>,package_name_array:ArrayList<String>)
    }
    class ItemViewHolder internal constructor(
        itemView: View?,
        val mBinding: ItemPackageBinding
    ) :
        RecyclerView.ViewHolder(itemView!!)
}