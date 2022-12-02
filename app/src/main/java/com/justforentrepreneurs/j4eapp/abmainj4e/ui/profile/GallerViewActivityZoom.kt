package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.GallaryActivityzoomBinding


class GallerViewActivityZoom : AppCompatActivity() {
    var position: String? = null
    private lateinit var binding: GallaryActivityzoomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.gallary_activityzoom)
        binding.lifecycleOwner = this

        val intent = intent
        position = intent.getStringExtra("Url")

        Glide.with(this)
            .load(position)
            .into(binding.imageView2)

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