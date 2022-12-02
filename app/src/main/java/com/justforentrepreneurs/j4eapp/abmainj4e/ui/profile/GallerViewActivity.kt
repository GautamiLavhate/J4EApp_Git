package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.adapter.ViewPagerAdapterGalleryViewAnimity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.GalleryInfo
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.Messageview
import com.justforentrepreneurs.j4eapp.databinding.ActivityProfileBinding
import com.justforentrepreneurs.j4eapp.databinding.GallaryActivityviewBinding
import org.koin.ext.isInt

class GallerViewActivity : AppCompatActivity() {
    private var galleryArrayList: ArrayList<GalleryInfo>? = null
    var position: String? = null
    private lateinit var binding: GallaryActivityviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.gallary_activityview)
        binding.lifecycleOwner = this

        val intent = intent
        galleryArrayList = intent.getSerializableExtra("Image") as ArrayList<GalleryInfo>
        position = intent.getStringExtra("pos")

        val galleryViewPagerAdapter = ViewPagerAdapterGalleryViewAnimity(galleryArrayList,this)
        binding.viewPager.adapter = galleryViewPagerAdapter
        binding.viewPager.currentItem= position?.toInt()!!


        binding.viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

                if (position ==  binding.viewPager.adapter?.count?.minus(1)) {
                    binding.btnnext.setVisibility(View.INVISIBLE);
                } else {
                    binding.btnnext.setVisibility(View.VISIBLE);
                }

                if (position == 0) {
                    binding.btnprev.setVisibility(View.INVISIBLE);
                } else {
                    binding.btnprev.setVisibility(View.VISIBLE);
                }

            }
            override fun onPageSelected(position: Int) {

                if (position == binding.viewPager.adapter?.count?.minus(1)) {
                    binding.btnnext.setVisibility(View.INVISIBLE);
                } else {
                    binding.btnnext.setVisibility(View.VISIBLE);
                }

                if (position == 0) {
                    binding.btnprev.setVisibility(View.INVISIBLE);
                } else {
                    binding.btnprev.setVisibility(View.VISIBLE);
                }

            }

        })

        binding.btnprev.setOnClickListener{
            binding.viewPager.setCurrentItem(binding.viewPager.currentItem-1, true)
        }

        binding.btnnext.setOnClickListener{
            binding.viewPager.setCurrentItem(binding.viewPager.currentItem+1, true)
        }
    }


    override fun onDestroy() {
        super.onDestroy()

    }

    override fun onResume() {
        super.onResume()

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        checkOrientation(newConfig)
    }

    private fun checkOrientation(newConfig: Configuration) {
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {


            // Your magic here for landscape mode
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {


            // Your magic here for portrait mode
        }
    }


}