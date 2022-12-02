package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrequirements

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
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyRequirementsBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.OTPVerification.OTPVerificationActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrequirements.adapter.RequirementPagerAdapter
import com.google.android.material.tabs.TabLayout

class MyRequirementsActivity : BaseActivity() {
    private lateinit var binding: ActivityMyRequirementsBinding
    override fun enablePresence(): Boolean {
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_requirements)
        binding.lifecycleOwner = this

        binding.toolbar.ivBack.setOnClickListener {
            onBackPressed()
        }

        if (intent.getStringExtra("type") != null && intent.getStringExtra("type") == "lead")
            binding.toolbar.tvTitle.text = resources.getText(R.string.my_leads)
        else
            binding.toolbar.tvTitle.text = resources.getText(R.string.my_requirement)
        setupViewPager()
    }

    private fun setupViewPager() {
        val viewPagerAdapter = RequirementPagerAdapter(supportFragmentManager)
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

    fun onGetOtpClick(view: View) {
        startActivity(Intent(this, OTPVerificationActivity::class.java))
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}