package com.justforentrepreneurs.j4eapp.abmainj4e.ui.allmembers

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.allmembers.model.AllMemberResponse
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.allmembers.model.MemberInfo
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.allmembers.viewmodel.AllMembersViewModel
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.readUsingSharedPreference
import com.justforentrepreneurs.j4eapp.databinding.ActivityAllMembersBinding

class AllMembersActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAllMembersBinding
    private lateinit var allmemberAdapter:AdapterAllMembers
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_all_members)
        binding.viewModel = ViewModelProviders.of(this).get(AllMembersViewModel::class.java)
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvAllBuddies.layoutManager = layoutManager
        viewAllMemberData(this, readUsingSharedPreference(this,"userid").toString())
    }

    private fun setAdapter(count : Int) {


        val stringArrayList = ArrayList<MemberInfo>()
        allmemberAdapter=AdapterAllMembers(this,count,stringArrayList)
    }

    private fun viewAllMemberData(context: Context, userid: String) {
        val model: AllMembersViewModel =
            ViewModelProviders.of(this).get(AllMembersViewModel::class.java)

        model.viewAllMemberData(context, userid)
            ?.observe(this, Observer<AllMemberResponse> { viewServiceResponse ->
                setAdapter(viewServiceResponse.count_available)
                binding.linearlayout1.visibility = View.GONE
                binding.rvAllBuddies.visibility = View.VISIBLE
                binding.NoLeadInvited.visibility = View.GONE
                allmemberAdapter.setList(viewServiceResponse.data.member_info as ArrayList<MemberInfo>)
                binding.rvAllBuddies.adapter = allmemberAdapter
                //servicesAdapter.notifyDataSetChanged()


            })
//        binding.rvServices.adapter = servicesAdapter
//        servicesAdapter.notifyDataSetChanged()



    }
}