package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.FragReceivedConnection
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.FragSentConnection
import java.util.*

class ConnectionPagerAdapter(fm: FragmentManager,fragment:String,position:Int) : FragmentPagerAdapter(fm) {
    private val fragmentst:String=fragment
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
                fragment = FragReceivedConnection(fragment = fragmentst,position)
            1 ->
                // Games fragment activity
                fragment = FragSentConnection(fragment = fragmentst,position)
        }

        return fragment
    }


    override fun getPageTitle(position: Int): CharSequence? {
        var title = ""
        if (position == 0) {
            title = "Received"
        } else if (position == 1) {
            title = "Sent"
        }
        return title
    }
}