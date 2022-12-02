package com.justforentrepreneurs.j4eapp.abmainj4e.ui.welcome

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityWelcomeBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.login.LoginActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.welcome.adapter.WelcomeAdapter
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.welcome.model.Data
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.welcome.model.WelcomeResponse
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.PrefManager
import retrofit2.Call
import retrofit2.Response

class WelcomeActivity : BaseActivity() {
    override fun enablePresence(): Boolean {
        return true
    }
    private lateinit var binding: ActivityWelcomeBinding
    private val fragmentList = ArrayList<Fragment>()
    private var prefManager: PrefManager? = null
    var totalCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome)
        binding.lifecycleOwner = this
        val adapter = IntroSliderAdapter(this)
        binding.vpIntroSlider.adapter = adapter
        prefManager=PrefManager(this)

        getWelcomeData()

        if (!prefManager!!.isFirstTimeLaunch()) {
            launchHomeScreen()
            finish()
        }

        registerListeners()

//        fragmentList.addAll(
//            listOf(
//                Intro1Fragment(), Intro2Fragment(), Intro3Fragment(), Intro4Fragment()
//            )
//        )
//        adapter.setFragmentList(fragmentList)
//
//        binding.indicatorLayout.setIndicatorCount(adapter.itemCount)
//        binding.indicatorLayout.selectCurrentPosition(0)
//        registerListeners()
    }


    private fun launchHomeScreen() {
        prefManager?.setFirstTimeLaunch(false)
        val intent = Intent(this, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
        finish()
    }

    private fun registerListeners() {
        binding.vpIntroSlider.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                binding.indicatorLayout.selectCurrentPosition(position)

//                if (position < fragmentList.lastIndex) {
//                    binding.tagSkip.visibility = View.VISIBLE
//                } else {
//                    binding.tagSkip.visibility = View.GONE
//                }
            }
        })

        binding.tvSkip.setOnClickListener {
            launchHomeScreen()
        }

        binding.ivNext.setOnClickListener {
//            val position = binding.vpIntroSlider.currentItem
//
//            if (position < fragmentList.lastIndex) {
//                binding.vpIntroSlider.currentItem = position + 1
//            } else {
//                launchHomeScreen()
//            }
            val position = binding.vpIntroSlider.currentItem
            val finalTotalCount = totalCount - 1

            if(position == totalCount){

                launchHomeScreen()
            }else{
                if (position < finalTotalCount) {
                    binding.vpIntroSlider.currentItem = position + 1
                } else {
                    launchHomeScreen()
                }
            }
        }
    }

    private fun getWelcomeData(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_intro_screen()
        call.enqueue(object : retrofit2.Callback<WelcomeResponse> {
            override fun onResponse(
                call: Call<WelcomeResponse>,
                response: Response<WelcomeResponse>
            ) {
                binding.linearlayout1.visibility = View.GONE
                binding.rlMain.visibility = View.VISIBLE
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            val mAdapter = WelcomeAdapter(this@WelcomeActivity,
                                response.body()?.data as MutableList<Data>, binding.vpIntroSlider)
                            binding.vpIntroSlider.adapter = mAdapter
                            binding.indicatorLayout.setIndicatorCount(mAdapter.itemCount)
                            totalCount = mAdapter.itemCount
                        }
                    }
                }
            }

            override fun onFailure(call: Call<WelcomeResponse>, t: Throwable) {

            }
        })



    }
}