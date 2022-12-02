package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities

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
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.Adapter.ResponsibilitiesPagerAdapter
import com.google.android.material.tabs.TabLayout

class PendingResponsibilitiesActivity() : BaseActivity() {
    private lateinit var binding: ActivityMyRequirementsBinding
    lateinit var datatype2:String
    override fun enablePresence(): Boolean {
        return true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_requirements)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.pending_responsibilities)
        datatype2= intent.getStringExtra("type").toString()
        setupViewPager(datatype2.toInt())

        binding.toolbar.ivBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if(intent.getStringExtra("noti").toString().equals("notification")){
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("type", "notification")
            startActivity(intent)
        }else if(intent.getStringExtra("search").toString().equals("search")){

        }else if (intent.getStringExtra("from").toString().equals("post")) {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("hometype", "0")
            intent.putExtra("type", "hometype")
            intent.putExtra("position", "3")
            startActivity(intent)
        }else{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupViewPager(datatype: Int?) {
        val viewPagerAdapter = ResponsibilitiesPagerAdapter(supportFragmentManager)
        binding.vpHome.setAdapter(viewPagerAdapter)
        binding.tabHome.setupWithViewPager(binding.vpHome)
        binding.vpHome.currentItem = datatype!!
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