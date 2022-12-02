package com.justforentrepreneurs.j4eapp.abmainj4e.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.WelcomeSlideABinding
import com.justforentrepreneurs.j4eapp.databinding.WelcomeSlideBBinding

class Intro2Fragment : Fragment() {

    private lateinit var binding: WelcomeSlideBBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.welcome_slide_b, container, false)
        binding.tvTitle.text = "Choose your plan"
        binding.tvDescription.text =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas tempor diam ac enim scelerisque, vel tincidunt velit pharetra. Quisque pulvinar mauris sit amet libero varius blandit. Nulla in orci a odio hendrerit elementum."
        return binding.root
    }
}