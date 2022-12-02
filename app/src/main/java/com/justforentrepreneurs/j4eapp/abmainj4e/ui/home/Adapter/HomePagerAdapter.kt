package com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.*
import java.util.*

class HomePagerAdapter(fm: FragmentManager,position:Int) : FragmentPagerAdapter(fm) {
    private val fragmentList: List<Fragment> = ArrayList()
    private val fragmentTitleList: List<String> = ArrayList()
    private val position:Int=position
    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getItem(index: Int): Fragment {
        println("Index" + index)
        lateinit var fragment: Fragment
        when (index) {
            0 ->
                fragment = FragMyDiary()
            1 ->
                fragment = FragAllLeads(position)
            2 ->
                fragment = FragJ4EMembers(position)
            3 ->
                fragment = FragAllPosts(position)
        }

        return fragment
    }


    override fun getPageTitle(position: Int): CharSequence? {
        var title = ""
        if (position == 0) {
            title = "My Diary"
        } else if (position == 1) {
            title = "Leads"
        } else if (position == 2) {
            title = "J4E Members"
        } else if (position == 3) {
            title = "Posts"
        }
        return title
    }
}