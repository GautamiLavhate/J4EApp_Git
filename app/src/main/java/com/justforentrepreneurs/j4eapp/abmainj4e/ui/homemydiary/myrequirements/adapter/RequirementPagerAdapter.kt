package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrequirements.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrequirements.FragCompletedRequirement
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrequirements.FragPendingRequirement
import java.util.*

class RequirementPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
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
                fragment = FragPendingRequirement()
            1 ->
                // Games fragment activity
                fragment = FragCompletedRequirement()
        }

        return fragment
    }


    override fun getPageTitle(position: Int): CharSequence? {
        var title = ""
        if (position == 0) {
            title = "Pending"
        } else if (position == 1) {
            title = "Completed"
        }
        return title
    }
}