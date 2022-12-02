package com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment.AllEventFragment
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment.AllEventsFragment
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment.UpcomingEventFragment
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.recommended.FragRecommendedBy
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.recommended.FragRecommendedTo
import java.util.ArrayList

class AllEventsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
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
                fragment = UpcomingEventFragment()
            1 ->
                // Games fragment activity
                fragment = AllEventFragment()
        }

        return fragment
    }


    override fun getPageTitle(position: Int): CharSequence? {
        var title = ""
        if (position == 0) {
            title = "Upcoming Events"
        } else if (position == 1) {
            title = "All Events"
        }
        return title
    }
}