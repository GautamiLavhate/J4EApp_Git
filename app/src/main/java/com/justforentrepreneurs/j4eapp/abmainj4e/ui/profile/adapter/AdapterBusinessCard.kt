package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ScaleGestureDetector
import android.view.View
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.BusinessCardActivity
import kotlinx.android.synthetic.main.layout_item_view_pager.view.*

class AdapterBusinessCard(activity: BusinessCardActivity?, image_url: MutableList<String>):
    PagerAdapter() {
    private var inflater: LayoutInflater? = null
    private var mData2: MutableList<String> = image_url
    var mContext: Context? = activity
    private lateinit var scaleGestureDetector: ScaleGestureDetector
    private var scaleFactor = 1.0f

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return mData2.size
    }

    override fun instantiateItem(container: View, position: Int): Any {
        inflater = mContext?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater!!.inflate(R.layout.layout_item_view_pager, null)
        Glide.with(mContext!!)
            .load(mData2.get(position).toString())
            .into(view.img_slider)
        val vp = container as ViewPager
        vp.addView(view, 0)
        return view
    }

    override fun destroyItem(container: View, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)
    }


}