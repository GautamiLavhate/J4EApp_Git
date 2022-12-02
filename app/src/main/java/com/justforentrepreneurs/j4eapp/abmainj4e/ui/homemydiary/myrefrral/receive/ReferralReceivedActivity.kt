package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrefrral.receive

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayout
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrefrral.adapter.ReferralPagerAdapter
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrefrral.adapter.ReferralReceivedPagerAdapter
import com.justforentrepreneurs.j4eapp.databinding.ActivityReferralReceivedBinding

class ReferralReceivedActivity : AppCompatActivity() {
    private lateinit var binding:ActivityReferralReceivedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_referral_received)
        binding.lifecycleOwner = this

        binding.toolbar.ivBack.setOnClickListener {
            onBackPressed()
        }

        binding.toolbar.tvTitle.text = resources.getText(R.string.Referralsreceived)
        setupViewPager()
    }
    private fun setupViewPager() {
        val viewPagerAdapter = ReferralReceivedPagerAdapter(supportFragmentManager)
        binding.vpHome.setAdapter(viewPagerAdapter)
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
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}