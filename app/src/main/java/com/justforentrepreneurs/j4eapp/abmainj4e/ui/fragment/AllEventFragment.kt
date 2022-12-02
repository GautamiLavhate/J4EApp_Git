package com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.SingleSlection
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseFragment
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.Eventcategory
import com.justforentrepreneurs.j4eapp.databinding.FragmentAllEventBinding

class AllEventFragment : BaseFragment(), SingleSlection {
    private lateinit var binding:FragmentAllEventBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_all_event, container, false)
        return binding.root
    }

    override fun addMultiSelection(multiModel: MutableList<Eventcategory.Eventdata>, pos: Int) {
        TODO("Not yet implemented")
    }

    override fun removeMultiSelection(
        multiModel: MutableList<Eventcategory.Eventdata>,
        id: String,
        pos: Int
    ) {
        TODO("Not yet implemented")
    }


}