package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrefrral.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrefrral.fragment.CompletedReferralFragment
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrefrral.fragment.CompletedReferralReceivedFragment
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrefrral.fragment.PendingReferralFragment
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrefrral.fragment.PendingReferralReceivedFragment

class ReferralReceivedPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
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
                fragment =  PendingReferralReceivedFragment()
            1 ->
                // Games fragment activity
                fragment =  CompletedReferralReceivedFragment()
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