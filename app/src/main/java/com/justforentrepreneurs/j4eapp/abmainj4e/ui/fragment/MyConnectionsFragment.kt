package com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.OTPVerification.OTPVerificationActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Adapter.ConnectionPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_my_connections.*
import kotlinx.android.synthetic.main.activity_my_connections.tabHome
import kotlinx.android.synthetic.main.activity_my_connections.vpHome


class MyConnectionsFragment(datatype:Int,fragment:String,position:Int) : Fragment(R.layout.activity_my_connections) {
    lateinit var mainActivity: MainActivity
    var datatype2: Int? = datatype
    val fragment:String=fragment
    var position: Int = position


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity = (activity as MainActivity?)!!
        ivBack.visibility = View.GONE
        toolbar.visibility = View.GONE

        mainActivity.binding.toolbar.ivCreate.visibility = View.GONE
        mainActivity.binding.toolbar.searchhome.visibility = View.GONE
        mainActivity.binding.toolbar.logotoolbar.visibility = View.GONE
        mainActivity.binding.toolbar.ivaddCreate.visibility = View.GONE
        mainActivity.binding.toolbar.tvTitle.visibility = View.VISIBLE
        mainActivity.binding.toolbar.tvTitle.text="Connection"

        setupViewPager(datatype2,fragment,position)

        view.setFocusableInTouchMode(true)
        view.requestFocus()
        view.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                mainActivity.setBottomIconChange("3")
                mainActivity.loadFragment(HomeFragment(0,0),"Home")
                true
            } else false
        })

    }

    private fun setupViewPager(datatype: Int?,fragment:String,position:Int) {
        val viewPagerAdapter = ConnectionPagerAdapter(childFragmentManager,fragment,position)
        vpHome.adapter = viewPagerAdapter
        vpHome.currentItem = datatype!!
        tabHome.setupWithViewPager(vpHome)
        tabHome.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
                println("p0>" + p0!!.position)

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                println("p0>>>" + p0!!.position)
            }

        })
        changeTabsFont()
    }

    private fun changeTabsFont() {
        val font = ResourcesCompat.getFont(requireActivity(), R.font.notosans_jp_medium)
        val vg = tabHome.getChildAt(0) as ViewGroup
        val tabsCount = vg.childCount
        for (j in 0 until tabsCount) {
            val vgTab = vg.getChildAt(j) as ViewGroup
            val tabChildsCount = vgTab.childCount
            for (i in 0 until tabChildsCount) {
                val tabViewChild = vgTab.getChildAt(i)
                if (tabViewChild is TextView) {
                    tabViewChild.setTypeface(font, Typeface.NORMAL)
                    tabViewChild.isAllCaps = false
                }
            }
        }
    }

    fun onGetOtpClick(view: View) {
        startActivity(Intent(requireActivity(), OTPVerificationActivity::class.java))
    }

}