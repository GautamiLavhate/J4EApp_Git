package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.recommended.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.recommended.FragRecommendedBy
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.recommended.FragRecommendedTo
import java.util.*

class RecommendedPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val fragmentList: List<Fragment> = ArrayList()
    private val fragmentTitleList: List<String> = ArrayList()
    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(index: Int): Fragment {
        println("Index" + index)
        lateinit var fragment: Fragment
        when (index) {
            0 ->
                // Top Rated fragment activity
                fragment = FragRecommendedBy()
            1 ->
                // Games fragment activity
                fragment = FragRecommendedTo()
        }

        return fragment
    }


    override fun getPageTitle(position: Int): CharSequence? {
        var title = ""
        if (position == 0) {
            title = "Recommended By"
        } else if (position == 1) {
            title = "Recommended To"
        }
        return title
    }
}