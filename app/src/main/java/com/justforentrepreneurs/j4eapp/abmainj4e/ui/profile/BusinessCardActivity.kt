package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.adapter.AdapterBusinessCard
import com.justforentrepreneurs.j4eapp.databinding.ActivityBusinessCardBinding
import java.util.ArrayList

class BusinessCardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBusinessCardBinding
    var imgData= ArrayList<String>()
    var position: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_business_card)
        val intent = intent
        imgData = intent.getStringArrayListExtra("Images") as ArrayList<String>
        position = intent.getStringExtra("position")

        val adapterViewPager = AdapterBusinessCard(this,imgData)
        binding.container.adapter=adapterViewPager
        binding.container.currentItem=position?.toInt()!!
    }
}