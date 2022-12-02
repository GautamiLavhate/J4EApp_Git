package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.FragPastEvents
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.FragUpcomingEvents
import java.util.*

class MyEventsPagerAdapter(fm: FragmentManager,position:Int) : FragmentPagerAdapter(fm) {
    private val fragmentList: List<Fragment> = ArrayList()
    private val fragmentTitleList: List<String> = ArrayList()
    private val position:Int=position
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
                fragment = FragUpcomingEvents(position)
            1 ->
                // Games fragment activity
                fragment = FragPastEvents()
        }

        return fragment
    }


    override fun getPageTitle(position: Int): CharSequence? {
        var title = ""
        if (position == 0) {
            title = "Upcoming Events"
        } else if (position == 1) {
            title = "Past Events"
        }
        return title
    }
}