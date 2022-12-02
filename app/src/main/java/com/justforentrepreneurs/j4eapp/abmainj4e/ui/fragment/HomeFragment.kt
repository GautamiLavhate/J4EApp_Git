package com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.*
import android.widget.TextView
import androidx.core.app.NotificationCompat.getColor
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.Adapter.HomePagerAdapter
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.google.android.material.tabs.TabLayout
import com.justforentrepreneurs.j4eapp.BuildConfig
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.CountBubble
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.databinding.UpdateBackgroundBinding
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.lay_bottom_bar.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment(datatype:Int,position:Int) : Fragment(R.layout.fragment_home) {
    lateinit var mainActivity: MainActivity
    var datatype2: Int? = datatype
    var position: Int = position
    var stop: Boolean =false
    var new_ver:String = "4.0.1"




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity = (activity as MainActivity?)!!

        mainActivity.binding.toolbar.ivCreate.visibility = View.VISIBLE
        mainActivity.binding.toolbar.searchhome.visibility = View.VISIBLE
        mainActivity.binding.toolbar.logotoolbar.visibility = View.VISIBLE
        mainActivity.binding.toolbar.tvTitle.visibility = View.GONE
        mainActivity.binding.toolbar.ivaddCreate.visibility = View.GONE



        setupViewPager(datatype2,position)

    }

    private fun setupViewPager(datatype: Int?,position: Int) {
        val viewPagerAdapter = HomePagerAdapter(childFragmentManager,position)
        vpHome.adapter = viewPagerAdapter
        tabHome.setupWithViewPager(vpHome)
        vpHome.currentItem = datatype!!

        tabHome.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            @SuppressLint("ResourceAsColor")
            override fun onTabReselected(p0: TabLayout.Tab?) {
                println("p0>" + p0!!.position)

            }

            @SuppressLint("ResourceAsColor")
            override fun onTabUnselected(p0: TabLayout.Tab?) {
                if(p0!!.position.equals(3)) {
                    tabHome.getTabAt(3)?.customView?.findViewById<TextView>(R.id.text2)?.setText("Posts")
                    val co: Int = R.color.disbalecolou
                    tabHome.getTabAt(3)?.customView?.findViewById<TextView>(R.id.text2)
                        ?.setTextColor(resources.getColor(co))
                }else if(p0!!.position.equals(2)) {
                    tabHome.getTabAt(2)?.customView?.findViewById<TextView>(R.id.text2)?.setText("J4E Members")
                    val co: Int = R.color.disbalecolou
                    tabHome.getTabAt(2)?.customView?.findViewById<TextView>(R.id.text2)
                        ?.setTextColor(resources.getColor(co))
                }else if(p0!!.position.equals(1)) {
                    tabHome.getTabAt(1)?.customView?.findViewById<TextView>(R.id.text2)?.setText("Leads")
                    val co: Int = R.color.disbalecolou
                    tabHome.getTabAt(1)?.customView?.findViewById<TextView>(R.id.text2)
                        ?.setTextColor(resources.getColor(co))
                }
            }




            @SuppressLint("ResourceAsColor")
            override fun onTabSelected(p0: TabLayout.Tab?) {
                println("p0>>>" + p0!!.position)
                mainActivity.currentPosition = p0.position
                if(p0.position.equals(3)){
                    tabHome.getTabAt(3)?.customView?.findViewById<TextView>(R.id.text2)?.setText("Posts")
                    tabHome.getTabAt(3)?.customView?.findViewById<TextView>(R.id.text)?.visibility=View.GONE
                    val co:Int=R.color.white
                    tabHome.getTabAt(3)?.customView?.findViewById<TextView>(R.id.text2)?.setTextColor(resources.getColor(co))
                }else if(p0.position.equals(2)){
                    tabHome.getTabAt(2)?.customView?.findViewById<TextView>(R.id.text2)?.setText("J4E Members")
                    tabHome.getTabAt(2)?.customView?.findViewById<TextView>(R.id.text)?.visibility=View.GONE
                    val co:Int=R.color.white
                    tabHome.getTabAt(2)?.customView?.findViewById<TextView>(R.id.text2)?.setTextColor(resources.getColor(co))
                }else if(p0.position.equals(1)){
                    tabHome.getTabAt(1)?.customView?.findViewById<TextView>(R.id.text2)?.setText("Leads")
                    tabHome.getTabAt(1)?.customView?.findViewById<TextView>(R.id.text)?.visibility=View.GONE
                    val co:Int=R.color.white
                    tabHome.getTabAt(1)?.customView?.findViewById<TextView>(R.id.text2)?.setTextColor(resources.getColor(co))
                }
            }

        })
        changeTabsFont()

        tabHome.getTabAt(3)?.setCustomView(R.layout.home_blagenotification)

        tabHome.getTabAt(2)?.setCustomView(R.layout.home_blagenotification)

        tabHome.getTabAt(1)?.setCustomView(R.layout.home_blagenotification)


        if(readUsingSharedPreference(requireActivity(), "PostCountnew").toString().equals(readUsingSharedPreference(requireActivity(), "PostCountOld").toString())) {
            tabHome.getTabAt(3)?.customView?.findViewById<TextView>(R.id.text)?.visibility=View.GONE
            tabHome.getTabAt(3)?.customView?.findViewById<TextView>(R.id.text2)?.setText("Posts")
            val co: Int = R.color.disbalecolou
            tabHome.getTabAt(3)?.customView?.findViewById<TextView>(R.id.text2)?.setTextColor(resources.getColor(co))

        }else{
            val PostCount:Int=readUsingSharedPreference(requireActivity(), "PostCountnew")?.toInt()!! - readUsingSharedPreference(requireActivity(), "PostCountOld")?.toInt()!!
            tabHome.getTabAt(3)?.customView?.findViewById<TextView>(R.id.text2)?.setText("Posts")
            if(PostCount > 99) {
                tabHome.getTabAt(3)?.customView?.findViewById<TextView>(R.id.text)?.setText("+99")
            }else if(PostCount < 1){
                tabHome.getTabAt(3)?.customView?.findViewById<TextView>(R.id.text)?.visibility=View.GONE
            }else{
                tabHome.getTabAt(3)?.customView?.findViewById<TextView>(R.id.text)?.setText(PostCount.toString())
            }
        }

        if(readUsingSharedPreference(requireActivity(), "BuddyCountnew").toString().equals(readUsingSharedPreference(requireActivity(), "BuddyCountOld").toString())) {
            tabHome.getTabAt(2)?.customView?.findViewById<TextView>(R.id.text)?.visibility=View.GONE
            val co: Int = R.color.disbalecolou
            tabHome.getTabAt(2)?.customView?.findViewById<TextView>(R.id.text2)?.setText("J4E Members")
            tabHome.getTabAt(2)?.customView?.findViewById<TextView>(R.id.text2)?.setTextColor(resources.getColor(co))
        }else{
            tabHome.getTabAt(2)?.customView?.findViewById<TextView>(R.id.text)?.visibility=View.GONE
            val BuudyCount:Int=readUsingSharedPreference(requireActivity(), "BuddyCountnew")?.toInt()!! - readUsingSharedPreference(requireActivity(), "BuddyCountOld")?.toInt()!!
            tabHome.getTabAt(2)?.customView?.findViewById<TextView>(R.id.text2)?.setText("J4E Members")
            if(BuudyCount > 99) {
                tabHome.getTabAt(2)?.customView?.findViewById<TextView>(R.id.text)?.setText("+99")
            }else if(BuudyCount < 1){
                tabHome.getTabAt(2)?.customView?.findViewById<TextView>(R.id.text)?.visibility=View.GONE
            }else{
                tabHome.getTabAt(2)?.customView?.findViewById<TextView>(R.id.text)?.setText(BuudyCount.toString())
            }
        }

        if(readUsingSharedPreference(requireActivity(), "LeadCountnew").toString().equals(readUsingSharedPreference(requireActivity(), "LeadCountOld").toString())) {
            tabHome.getTabAt(1)?.customView?.findViewById<TextView>(R.id.text)?.visibility=View.GONE
            val co: Int = R.color.disbalecolou
            tabHome.getTabAt(1)?.customView?.findViewById<TextView>(R.id.text2)?.setText("Leads")
            tabHome.getTabAt(1)?.customView?.findViewById<TextView>(R.id.text2)?.setTextColor(resources.getColor(co))
        }else{
            val LeadCount:Int=readUsingSharedPreference(requireActivity(), "LeadCountnew")?.toInt()!! - readUsingSharedPreference(requireActivity(), "LeadCountOld")?.toInt()!!
            tabHome.getTabAt(1)?.customView?.findViewById<TextView>(R.id.text2)?.setText("Leads")
            if(LeadCount > 99) {
                tabHome.getTabAt(1)?.customView?.findViewById<TextView>(R.id.text)?.setText("+99")
            }else if(LeadCount < 1){
                tabHome.getTabAt(1)?.customView?.findViewById<TextView>(R.id.text)?.visibility=View.GONE
            }else{
                tabHome.getTabAt(1)?.customView?.findViewById<TextView>(R.id.text)?.setText(LeadCount.toString())
            }
        }


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





}