package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.recommended

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseFragment
import com.justforentrepreneurs.j4eapp.databinding.FilterBottomSheetBinding
import com.justforentrepreneurs.j4eapp.databinding.FragRecommendedToBinding
import com.justforentrepreneurs.j4eapp.databinding.SortBottomSheetBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.MyLeadsDetailActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.recommended.adapters.AdapterRecommendedTo
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.recommended.model.RecommandByTo
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragRecommendedTo : BaseFragment(),AdapterRecommendedTo.OnClick2 {

    private lateinit var binding: FragRecommendedToBinding
    var count_available:Int=-1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_recommended_to, container, false)
        initListener()
        recyclerData()
        return binding.root
    }

    private fun recyclerData() {


        val layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.rvRecommended.layoutManager = layoutManager

        if(isInternetAvailable(requireActivity())){
            app_get_list_recommendations_to("","","")
        }

        binding.editsearchname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                if (s == "") {
                    if (isInternetAvailable(requireActivity())) {
                        app_get_list_recommendations_to("","","")
                    }
                }
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s == "") {
                    if (isInternetAvailable(requireActivity())) {
                        app_get_list_recommendations_to("","","")
                    }
                }
            }

            override fun afterTextChanged(s: Editable) {
                if (isInternetAvailable(requireActivity())) {
                    if (s.length > 0) {
                        binding.rvRecommended.setAdapter(null)
                        app_get_list_recommendations_to(s.toString(),"","")
                    } else if (s.length == 0) {
                        binding.rvRecommended.setAdapter(null)
                        app_get_list_recommendations_to("","","")
                    }
                }
            }
        })
    }

    private fun initListener() {
        var isShow = false

        binding.fabclose.setOnClickListener {
            if (isShow) {
                isShow = false
                binding.fabFilter.visibility = View.GONE
                binding.fabSort.visibility = View.GONE
                binding.searchli.visibility = View.GONE
                binding.fabSearch.visibility = View.GONE
                binding.fabclose.setImageResource(R.drawable.ic_searchpng)
            } else {
                isShow = true
                binding.fabclose.setImageResource(R.drawable.ic_close_recmmonad)
                binding.fabFilter.visibility = View.VISIBLE
                binding.fabSort.visibility = View.VISIBLE
                binding.searchli.visibility = View.GONE
                binding.fabclose.visibility=View.VISIBLE
                binding.fabSearch.visibility = View.VISIBLE
                binding.editsearchname.text.clear()
                //app_get_list_recommendations_to("","","")
                hideKeyboard(binding.fabclose)
            }
        }

        binding.fabSearch.setOnClickListener {
            isShow = false
            binding.searchli.visibility = View.VISIBLE
            binding.fabFilter.visibility = View.GONE
            binding.fabSort.visibility = View.GONE
            binding.fabSearch.visibility = View.GONE
            binding.fabclose.setImageResource(R.drawable.ic_searchpng)

        }

        binding.fabFilter.setOnClickListener {
            isShow = false
            binding.fabFilter.visibility = View.GONE
            binding.fabSort.visibility = View.GONE
            binding.searchli.visibility = View.GONE
            binding.fabSearch.visibility=View.GONE
            binding.fabclose.setImageResource(R.drawable.ic_searchpng)

            filterBottomSheet()
        }
        binding.fabSort.setOnClickListener {
            isShow = false
            binding.fabFilter.visibility = View.GONE
            binding.fabSort.visibility = View.GONE
            binding.searchli.visibility = View.GONE
            binding.fabSearch.visibility=View.GONE
            binding.fabclose.setImageResource(R.drawable.ic_searchpng)
            sortBottomSheet()
        }
    }

    private fun filterBottomSheet() {
        val dialog = BottomSheetDialog(requireActivity())
        val mBsMemberFilterBinding: FilterBottomSheetBinding =
                DataBindingUtil.inflate(LayoutInflater.from(requireActivity()), R.layout.filter_bottom_sheet, null, false)
        dialog.setCancelable(true)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setContentView(mBsMemberFilterBinding.root)

        mBsMemberFilterBinding.clearAllLabel.setOnClickListener {
            dialog.dismiss()
            if(isInternetAvailable(requireActivity())) {

                app_get_list_recommendations_to("", "", "")
            }
        }

        mBsMemberFilterBinding.NameAscending.setOnClickListener {
            dialog.dismiss()
            if(isInternetAvailable(requireActivity())){

                app_get_list_recommendations_to("","1","")
            }
        }

        mBsMemberFilterBinding.NameDescending.setOnClickListener {
            dialog.dismiss()
            if(isInternetAvailable(requireActivity())){
                app_get_list_recommendations_to("","2","")
            }
        }

        mBsMemberFilterBinding.DateAscending.setOnClickListener {
            dialog.dismiss()
            if(isInternetAvailable(requireActivity())){
                app_get_list_recommendations_to("","3","")
            }
        }
        mBsMemberFilterBinding.DateDescending.setOnClickListener {
            dialog.dismiss()
            if(isInternetAvailable(requireActivity())){
                app_get_list_recommendations_to("","4","")
            }
        }

        mBsMemberFilterBinding.CountAscending.setOnClickListener {
            dialog.dismiss()
            if(isInternetAvailable(requireActivity())){

                app_get_list_recommendations_to("","5","")
            }
        }

        mBsMemberFilterBinding.CountDescending.setOnClickListener {
            dialog.dismiss()
            if(isInternetAvailable(requireActivity())){

                app_get_list_recommendations_to("","6","")
            }
        }

        mBsMemberFilterBinding.ivClose.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    private fun sortBottomSheet() {
        val dialog = BottomSheetDialog(requireActivity())
        val mBsMemberFilterBinding: SortBottomSheetBinding =
                DataBindingUtil.inflate(LayoutInflater.from(requireActivity()), R.layout.sort_bottom_sheet, null, false)
        dialog.setCancelable(true)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setContentView(mBsMemberFilterBinding.root)

        mBsMemberFilterBinding.clearAllLabel.setOnClickListener {
            dialog.dismiss()
            if(isInternetAvailable(requireActivity())) {

                app_get_list_recommendations_to("", "", "")
            }
        }

        mBsMemberFilterBinding.SelfRecommended.setOnClickListener {
            dialog.dismiss()
            if(isInternetAvailable(requireActivity())){
                app_get_list_recommendations_to("","","2")
            }
        }

        mBsMemberFilterBinding.MostRecommended.setOnClickListener {
            dialog.dismiss()
            if(isInternetAvailable(requireActivity())){

                app_get_list_recommendations_to("","","1")
            }

        }
        mBsMemberFilterBinding.ivSortClose.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    private fun app_get_list_recommendations_to(keyword : String,sortby : String,filterby : String){
        val anim: Animation = AnimationUtils.loadAnimation(requireActivity(), android.R.anim.fade_in)
        binding.rvRecommendedlist.startAnimation(anim)

        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_list_recommendations_to(readUsingSharedPreference(requireActivity(), "userid").toString(),keyword,sortby,filterby)

        call.enqueue(object : Callback<RecommandByTo> {
            override fun onResponse(
                    call: Call<RecommandByTo>,
                    response: Response<RecommandByTo>
            ) {
                dismissLoader()
                if (response.isSuccessful) {
                    count_available=response.body()?.count_available!!
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.size !=0) {
                            binding.rvRecommendedlist.visibility=View.GONE
                            binding.rvRecommended.visibility= View.VISIBLE
                            binding.NoGuestInvited.visibility= View.GONE
                            val mAdapter = AdapterRecommendedTo(activity, response.body()?.data as MutableList<RecommandByTo.RecommandBydata>,this@FragRecommendedTo)
                            binding.rvRecommended.adapter = mAdapter
                        }
                    }else{
                        binding.rvRecommendedlist.visibility=View.GONE
                        binding.rvRecommended.visibility= View.GONE
                        binding.NoGuestInvited.visibility= View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<RecommandByTo>, t: Throwable) {
                dismissLoader()
                displayToast(requireActivity(), requireActivity().resources.getString(R.string.error_something_wrong))
            }
        })

    }

    override fun OnClickpro(position: Int, data: String, is_viewed: Int) {
        if (count_available==0){
            if (is_viewed==0){
                PermissionDialog(readUsingSharedPreference(requireContext(),"ViewExhaustedMsg").toString())
            }else{
                val intent = Intent(requireActivity(), ProfileActivity::class.java)
                intent.putExtra("id",data)
                intent.putExtra("type","MyLead")
                startActivity(intent)
            }
        }else{
            val intent = Intent(requireActivity(), ProfileActivity::class.java)
            intent.putExtra("id",data)
            intent.putExtra("type","MyLead")
            startActivity(intent)
        }

    }

    override fun OnClickLead(position: Int, data: String,requser: String) {
        val intent = Intent(requireActivity(), MyLeadsDetailActivity::class.java)
        intent.putExtra("type", "MyLead")
        intent.putExtra("id",data)
        intent.putExtra("requireUserid",requser)
        intent.putExtra("own","own")
        startActivity(intent)
    }

    private fun hideKeyboard(view: View) {
        view?.apply {
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
    private fun PermissionDialog(massage:String){
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mbsAddAccountDialog: PlanexpaireddialogBinding = DataBindingUtil.inflate(LayoutInflater.from(requireContext()),R.layout.planexpaireddialog, null, false)
        dialog.setContentView(mbsAddAccountDialog.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        mbsAddAccountDialog.massage.setText(massage)

        mbsAddAccountDialog.okbtd.setOnClickListener {
            dialog.dismiss()
        }
        mbsAddAccountDialog.txtUpgrade.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(requireContext(), MyMembershipBenefitsActivity::class.java))
        }
        dialog.show()
    }
}