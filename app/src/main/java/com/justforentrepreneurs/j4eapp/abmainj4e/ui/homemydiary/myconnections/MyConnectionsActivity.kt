package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyConnectionsBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.OTPVerification.OTPVerificationActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Adapter.ConnectionPagerAdapter
import com.google.android.material.tabs.TabLayout


class MyConnectionsActivity() : BaseActivity() {
    private lateinit var binding: ActivityMyConnectionsBinding

    override fun enablePresence(): Boolean {
        return true
    }

    lateinit var position:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_connections)
        binding.lifecycleOwner = this
        binding.ivBack.visibility=View.GONE
        binding.toolbar.rlRoot.visibility=View.VISIBLE
        binding.toolbar.tvTitle.visibility = View.VISIBLE
        binding.toolbar.tvTitle.text="Connection"
         if (intent.getStringExtra("type") == "ReceivedConnectionactivity") {
             position=intent.getStringExtra("position").toString()
             setupViewPager(0,"activity",position.toInt())
         }else if (intent.getStringExtra("type") == "SentConnectionactivity") {
             position=intent.getStringExtra("position").toString()
             setupViewPager(1,"activity",position.toInt())
         }else if (intent.getStringExtra("type") == "notification") {
             setupViewPager(0,"activity",0)
         }else if (intent.getStringExtra("type") == "notificationSend") {
             setupViewPager(1,"activity",0)
         }else{
             setupViewPager(0,"activity",0)
         }

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
         if (intent.getStringExtra("type") == "notification" || intent.getStringExtra("type") == "notificationSend") {
             val intent = Intent(this, MainActivity::class.java)
             intent.putExtra("type", "notification")
             startActivity(intent)
        }else{
             val intent = Intent(this, MainActivity::class.java)
             startActivity(intent)
        }
    }

    private fun setupViewPager(datatype: Int?,activity:String,position:Int) {
        val viewPagerAdapter = ConnectionPagerAdapter(supportFragmentManager,activity,position)
        binding.vpHome.setAdapter(viewPagerAdapter)
        binding.vpHome.currentItem = datatype!!
        binding.tabHome.setupWithViewPager(binding.vpHome)
        binding.tabHome.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
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
        val font = ResourcesCompat.getFont(this, R.font.notosans_jp_medium)
        val vg = binding.tabHome.getChildAt(0) as ViewGroup
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
        startActivity(Intent(this, OTPVerificationActivity::class.java))
    }

}