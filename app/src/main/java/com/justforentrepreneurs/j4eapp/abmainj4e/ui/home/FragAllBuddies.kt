package com.justforentrepreneurs.j4eapp.abmainj4e.ui.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseFragment
import com.justforentrepreneurs.j4eapp.databinding.BsMemberFilterBinding
import com.justforentrepreneurs.j4eapp.databinding.FragAllBuddiesBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.adapters.AdapterJ4ECategory
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.adapters.AdapterJ4EMemPlans
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.adapters.AdapterTurnOverJ4e
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.FilterPlan
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.TotalEmployee
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.Adapter.AdapterAllBuddies
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.AllBuddies
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.BuddiesAll
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.FunctionalArea
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.FunctionalData
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.GetTurnOver
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.adapters.AdapterNoofEmpolyee
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.GetEmployeeWork
//import com.justforentrepreneurs.j4eapp.utils.ContactUtils
import com.mohammedalaa.seekbar.DoubleValueSeekBarView
import com.mohammedalaa.seekbar.OnDoubleValueSeekBarChangeListener
import io.reactivex.android.schedulers.AndroidSchedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class FragAllBuddies(position:Int) : BaseFragment(), View.OnClickListener,AdapterJ4EMemPlans.OnClick2,AdapterJ4ECategory.OnClick2,AdapterTurnOverJ4e.OnClick2,AdapterNoofEmpolyee.OnClick2{

    private lateinit var binding: FragAllBuddiesBinding
    var areaid :String=""
    var turnid :String=""
    var planid :String=""
    var rankck :String=""
    var AboutId :String=""
    var AboutValue :String=""

    var areanamem :String=""
    var turnidnamem :String=""
    var lstChk:String=""
    lateinit var mainActivity: MainActivity
    private val sharedPrefFile = "FragAllBuddiesBinding"

    private val position:Int=position
    var count_available: Int = -1

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_all_buddies, container, false)
        recyclerData()
        return binding.root
    }

    private fun recyclerData() {
        val layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.rvAllBuddies.layoutManager = layoutManager
        mainActivity = (activity as MainActivity?)!!
        if (isInternetAvailable(requireActivity())) {
            getAllBuddies()
        }

        binding.icFilter.setOnClickListener {
            bottomSheetFilter()
        }

    }

    override fun onClick(v: View) {
        when (v.id) {

        }
    }

    private fun getAllBuddies(){
        val anim: Animation = AnimationUtils.loadAnimation(requireActivity(), android.R.anim.fade_in)
        binding.relativelayout1.startAnimation(anim)

        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_my_buddies(readUsingSharedPreference(requireActivity(), "userid").toString(),"0","0")
        //showLoader(requireActivity());
        call.enqueue(object : Callback<BuddiesAll> {
            override fun onResponse(
                    call: Call<BuddiesAll>,
                    response: Response<BuddiesAll>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.size != 0) {

                            storeUsingSharedPreference(
                                requireActivity(),
                                "BuddyCountOld", response.body()?.data?.size.toString()
                            )
                            binding.relativelayout.visibility = View.VISIBLE
                            binding.relativelayout1.visibility = View.GONE
                            binding.rvAllBuddies.visibility = View.VISIBLE
                            binding.NoLeadInvited.visibility = View.GONE
                            count_available=response.body()?.count_available!!
                            val mAdapter = AdapterAllBuddies(
                                    activity,
                                    response.body()?.data as MutableList<AllBuddies>, "BuddiesFragment",count_available)
                            binding.rvAllBuddies.adapter = mAdapter
                            binding.rvAllBuddies.getLayoutManager()?.scrollToPosition(position)


                        } else {
                            storeUsingSharedPreference(
                                requireActivity(),
                                "BuddyCountOld", response.body()?.data?.size.toString()
                            )
                            binding.relativelayout.visibility = View.VISIBLE
                            binding.relativelayout1.visibility = View.GONE
                            binding.rvAllBuddies.visibility = View.GONE
                            binding.NoLeadInvited.visibility = View.VISIBLE
                        }
                    }
                }
            }

            override fun onFailure(call: Call<BuddiesAll>, t: Throwable) {
                dismissLoader();
               // displayToast(requireActivity(), resources.getString(R.string.error_something_wrong))
            }
        })

    }

    private fun bottomSheetFilter() {

        val dialog = BottomSheetDialog(requireActivity(), R.style.CustomBottomSheetDialogTheme)
        val mBsMemberFilterBinding: BsMemberFilterBinding =
                DataBindingUtil.inflate(LayoutInflater.from(requireActivity()), R.layout.bs_member_filter, null, false)
        dialog.setCancelable(true)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setContentView(mBsMemberFilterBinding.root)

        val sharedPreferences: SharedPreferences = requireActivity().getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)

        val anim: Animation = AnimationUtils.loadAnimation(requireActivity(), android.R.anim.fade_in)
        mBsMemberFilterBinding.linearlayout1.startAnimation(anim)


        var planidst = sharedPreferences.getString("planid", "")
        var minvaluest = sharedPreferences.getString("minvalue", "")
        var maxvaluest = sharedPreferences.getString("maxvalue", "")
        var areaidst = sharedPreferences.getString("areaid", "")
        var turnidst = sharedPreferences.getString("turnid", "")
        val editlocationsst = sharedPreferences.getString("editlocation", "")
        val rankckst = sharedPreferences.getString("rankck", "")
        val areaname = sharedPreferences.getString("areaname", "")
        val turnidname = sharedPreferences.getString("turnidname", "")
        val NoofempNamest = sharedPreferences.getString("NoofempName", "")


        if(!planidst.equals("")){
           lstChk= planidst.toString()

        }


        if(!minvaluest.equals("")){
            minvaluest=AboutId
            mBsMemberFilterBinding.tvCategory2.text = NoofempNamest
        }

        if(!maxvaluest.equals("")){
            maxvaluest="0"
        }

        if(!areaidst.equals("")){
            areaidst=areaid
            mBsMemberFilterBinding.tvCategory.setText(areaname)
        }

        if(!turnidst.equals("")){
            turnidst=turnid
            mBsMemberFilterBinding.tvCategory1.text = turnidname
        }

        if(!rankckst.equals("")){

            if(rankckst=="1"){
                mBsMemberFilterBinding.top10.isChecked=true
                rankck="1"
            }else if(rankckst=="2"){
                mBsMemberFilterBinding.top100.isChecked=true
                rankck="2"
            }else if(rankckst=="3"){
                mBsMemberFilterBinding.top500.isChecked=true
                rankck="3"
            }else if(rankckst=="4"){
                mBsMemberFilterBinding.top5000.isChecked=true
                rankck="4"
            }

        }


        if(!editlocationsst.equals("")){
            mBsMemberFilterBinding.editlocation.setText(editlocationsst)
        }



        mBsMemberFilterBinding.top10.setOnClickListener {
            mBsMemberFilterBinding.top10.isChecked=true
            mBsMemberFilterBinding.top100.isChecked=false
            mBsMemberFilterBinding.top500.isChecked=false
            mBsMemberFilterBinding.top5000.isChecked=false
            rankck="1"
        }

        mBsMemberFilterBinding.top100.setOnClickListener {
            mBsMemberFilterBinding.top10.isChecked=false
            mBsMemberFilterBinding.top100.isChecked=true
            mBsMemberFilterBinding.top500.isChecked=false
            mBsMemberFilterBinding.top5000.isChecked=false
            rankck="2"
        }

        mBsMemberFilterBinding.top500.setOnClickListener {
            mBsMemberFilterBinding.top10.isChecked=false
            mBsMemberFilterBinding.top100.isChecked=false
            mBsMemberFilterBinding.top500.isChecked=true
            mBsMemberFilterBinding.top5000.isChecked=false
            rankck="3"
        }

        mBsMemberFilterBinding.top5000.setOnClickListener {
            mBsMemberFilterBinding.top10.isChecked=false
            mBsMemberFilterBinding.top100.isChecked=false
            mBsMemberFilterBinding.top500.isChecked=false
            mBsMemberFilterBinding.top5000.isChecked=true
            rankck="4"
        }






        mBsMemberFilterBinding.llCategorySelection.setOnClickListener {
            if (mBsMemberFilterBinding.ivDropDown.isVisible) {
                mBsMemberFilterBinding.ivDropDown.visibility = View.GONE
                mBsMemberFilterBinding.ivDropUp.visibility = View.VISIBLE
                mBsMemberFilterBinding.rvCategory.visibility = View.VISIBLE
            } else {
                mBsMemberFilterBinding.ivDropDown.visibility = View.VISIBLE
                mBsMemberFilterBinding.ivDropUp.visibility = View.GONE
                mBsMemberFilterBinding.rvCategory.visibility = View.GONE
            }
        }

        mBsMemberFilterBinding.tvCategory.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                if (s == "") {
                    if (isInternetAvailable(requireActivity())) {
                        getAllAraekeyword(mBsMemberFilterBinding,"")
                    }
                    mBsMemberFilterBinding.crossfun.visibility=View.GONE
                }
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s == "") {
                    if (isInternetAvailable(requireActivity())) {
                        getAllAraekeyword(mBsMemberFilterBinding,"")
                    }
                    mBsMemberFilterBinding.crossfun.visibility=View.GONE
                }
            }

            override fun afterTextChanged(s: Editable) {
                if (isInternetAvailable(requireActivity())) {
                    if (s.length > 0) {
                        mBsMemberFilterBinding.rvCategory.setAdapter(null)
                        mBsMemberFilterBinding.crossfun.visibility=View.VISIBLE
                        getAllAraekeyword(mBsMemberFilterBinding,s.toString())
                    } else if (s.length == 0) {
                        mBsMemberFilterBinding.rvCategory.setAdapter(null)
                        getAllAraekeyword(mBsMemberFilterBinding,"")
                        mBsMemberFilterBinding.crossfun.visibility=View.GONE
                    }
                }
            }
        })

        mBsMemberFilterBinding.crossfun.setOnClickListener {
            mBsMemberFilterBinding.tvCategory.setText("")
            areaid=""
            areanamem=""
        }

        mBsMemberFilterBinding.llCategorySelection1.setOnClickListener {
            if (mBsMemberFilterBinding.ivDropDown1.isVisible) {
                mBsMemberFilterBinding.ivDropDown1.visibility = View.GONE
                mBsMemberFilterBinding.ivDropUp1.visibility = View.VISIBLE
                mBsMemberFilterBinding.rvCategory1.visibility = View.VISIBLE
            } else {
                mBsMemberFilterBinding.ivDropDown1.visibility = View.VISIBLE
                mBsMemberFilterBinding.ivDropUp1.visibility = View.GONE
                mBsMemberFilterBinding.rvCategory1.visibility = View.GONE
            }
        }

        mBsMemberFilterBinding.llCategorySelection2.setOnClickListener {
            if (mBsMemberFilterBinding.ivDropDown2.isVisible) {
                mBsMemberFilterBinding.ivDropDown2.visibility = View.GONE
                mBsMemberFilterBinding.ivDropUp2.visibility = View.VISIBLE
                mBsMemberFilterBinding.rvCategory2.visibility = View.VISIBLE
            } else {
                mBsMemberFilterBinding.ivDropDown2.visibility = View.VISIBLE
                mBsMemberFilterBinding.ivDropUp2.visibility = View.GONE
                mBsMemberFilterBinding.rvCategory2.visibility = View.GONE
            }
        }

        mBsMemberFilterBinding.clearall.setOnClickListener {
            lstChk=""
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            dialog.dismiss()
            if (isInternetAvailable(requireActivity())) {
                getAllBuddies()
            }
        }

        mBsMemberFilterBinding.clearloctaion.setOnClickListener {
            mBsMemberFilterBinding.editlocation.setText("")
        }

        if(isInternetAvailable(requireActivity())) {
            getAllArae(mBsMemberFilterBinding)
        }
        mBsMemberFilterBinding.ivClose.setOnClickListener {
            lstChk=""
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            dialog.dismiss()
        }
        mBsMemberFilterBinding.tvApplyFilter.setOnClickListener {
            dialog.dismiss()
            if(isInternetAvailable(requireActivity())) {
                val editor: SharedPreferences.Editor =  sharedPreferences.edit()
                editor.putString("planid", planid)
                editor.putString("minvalue", AboutId)
                editor.putString("maxvalue", "0")
                editor.putString("areaid", areaid)
                editor.putString("areaname", areanamem)
                editor.putString("turnidname",turnidnamem)
                editor.putString("turnid", turnid)
                editor.putString("editlocation", mBsMemberFilterBinding.editlocation.text.toString())
                editor.putString("rankck", rankck)
                editor.putString("NoofempName",AboutValue)
                editor.apply()
                editor.commit()
                app_get_my_buddiesFilter("", planid, AboutId, "0", areaid, turnid, mBsMemberFilterBinding.editlocation.text.toString(), rankck)
            }
        }

        dialog.show()
    }

    //filter

    private fun getAllArae(mBsMemberFilterBinding: BsMemberFilterBinding){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_functional_area("")
        call.enqueue(object : Callback<FunctionalArea> {
            override fun onResponse(
                    call: Call<FunctionalArea>,
                    response: Response<FunctionalArea>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            mBsMemberFilterBinding.rvCategory.layoutManager = GridLayoutManager(requireActivity(), 1)
                            val mAdapter = AdapterJ4ECategory(
                                    requireActivity(),
                                    response.body()?.data as MutableList<FunctionalData>, this@FragAllBuddies, mBsMemberFilterBinding)
                            mBsMemberFilterBinding.rvCategory.adapter = mAdapter

                        } else {

                        }
                    }
                    getAllTurnOver(mBsMemberFilterBinding)
                }
            }

            override fun onFailure(call: Call<FunctionalArea>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    private fun getAllAraekeyword(mBsMemberFilterBinding: BsMemberFilterBinding,keyword: String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_functional_area(keyword)
        call.enqueue(object : Callback<FunctionalArea> {
            override fun onResponse(
                call: Call<FunctionalArea>,
                response: Response<FunctionalArea>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            mBsMemberFilterBinding.rvCategory.layoutManager = GridLayoutManager(requireActivity(), 1)
                            val mAdapter = AdapterJ4ECategory(
                                requireActivity(),
                                response.body()?.data as MutableList<FunctionalData>, this@FragAllBuddies, mBsMemberFilterBinding)
                            mBsMemberFilterBinding.rvCategory.adapter = mAdapter

                        } else {

                        }
                    }
                }
            }

            override fun onFailure(call: Call<FunctionalArea>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    override fun OnClick(position: String, id: String, mBsMemberFilterBinding: BsMemberFilterBinding) {
        mBsMemberFilterBinding.tvCategory.setText(position)
        areanamem=position
        areaid=id
        mBsMemberFilterBinding.ivDropDown.visibility = View.VISIBLE
        mBsMemberFilterBinding.ivDropUp.visibility = View.GONE
        mBsMemberFilterBinding.rvCategory.visibility = View.GONE
        Log.d("position", position.toString());
    }

    private fun getAllTurnOver(mBsMemberFilterBinding: BsMemberFilterBinding){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_turnover()
        call.enqueue(object : Callback<GetTurnOver> {
            override fun onResponse(
                    call: Call<GetTurnOver>,
                    response: Response<GetTurnOver>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            mBsMemberFilterBinding.rvCategory1.layoutManager = GridLayoutManager(requireActivity(), 1)
                            val mAdapter = AdapterTurnOverJ4e(
                                    requireActivity(),
                                    response.body()?.data as MutableList<GetTurnOver.DataTurn>,
                                    this@FragAllBuddies, mBsMemberFilterBinding)
                            mBsMemberFilterBinding.rvCategory1.adapter = mAdapter


                        } else {

                        }
                    }

                    getAllPlans(mBsMemberFilterBinding,lstChk)
                }
            }

            override fun onFailure(call: Call<GetTurnOver>, t: Throwable) {
                dismissLoader();
            }
        })

    }


    override fun OnClickJ4e(position: String, id: String, mBsMemberFilterBinding: BsMemberFilterBinding) {
        mBsMemberFilterBinding.tvCategory1.text = position;
        turnidnamem=position
        turnid=id
        mBsMemberFilterBinding.ivDropDown1.visibility = View.VISIBLE
        mBsMemberFilterBinding.ivDropUp1.visibility = View.GONE
        mBsMemberFilterBinding.rvCategory1.visibility = View.GONE
        Log.d("position", position.toString());
    }

    override fun OnClickPlan(position: String, id: String) {
        planid=id
    }

    //plans

    private fun getAllPlans(mBsMemberFilterBinding: BsMemberFilterBinding,lack:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_membership_plan()
        call.enqueue(object : Callback<FilterPlan> {
            override fun onResponse(
                    call: Call<FilterPlan>,
                    response: Response<FilterPlan>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            mBsMemberFilterBinding.recyclerplan.layoutManager = GridLayoutManager(requireActivity(), 2)
                            val mAdapter = AdapterJ4EMemPlans(
                                    requireActivity(),
                                    response.body()?.data as MutableList<FilterPlan.DataFilter>, this@FragAllBuddies,lack)
                            mBsMemberFilterBinding.recyclerplan.adapter = mAdapter

                        }
                    }
                }
                getAllNoofEmpoyee(mBsMemberFilterBinding)
            }

            override fun onFailure(call: Call<FilterPlan>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    private fun getAllNoofEmpoyee(mBsMemberFilterBinding: BsMemberFilterBinding){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_employee_data()
        call.enqueue(object : Callback<GetEmployeeWork> {
            override fun onResponse(
                call: Call<GetEmployeeWork>,
                response: Response<GetEmployeeWork>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            mBsMemberFilterBinding.linearlayout1.visibility=View.GONE
                            mBsMemberFilterBinding.linearlayout.visibility=View.VISIBLE
                            mBsMemberFilterBinding.rvCategory2.layoutManager = GridLayoutManager(requireActivity(), 1)
                            val mAdapter = AdapterNoofEmpolyee(
                                requireActivity(),
                                response.body()?.data as MutableList<GetEmployeeWork.EmployeeWork>,
                                this@FragAllBuddies,mBsMemberFilterBinding
                            )
                            mBsMemberFilterBinding.rvCategory2.adapter = mAdapter


                        } else {
                            mBsMemberFilterBinding.linearlayout1.visibility=View.GONE
                            mBsMemberFilterBinding.linearlayout.visibility=View.VISIBLE
                        }
                    }else{
                        mBsMemberFilterBinding.linearlayout1.visibility=View.GONE
                        mBsMemberFilterBinding.linearlayout.visibility=View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<GetEmployeeWork>, t: Throwable) {
                dismissLoader();

            }
        })

    }

    override fun OnEmpClick(
        position: String,
        id: String,
        mBsMemberFilterBinding: BsMemberFilterBinding
    ) {
        mBsMemberFilterBinding.tvCategory2.text = position;
        AboutValue=position
        AboutId=id
        mBsMemberFilterBinding.ivDropDown2.visibility = View.VISIBLE
        mBsMemberFilterBinding.ivDropUp2.visibility = View.GONE
        mBsMemberFilterBinding.rvCategory2.visibility = View.GONE
        Log.d("position", position.toString());
    }

    private fun app_get_my_buddiesFilter(keyword: String, membershiptype: String, min_employee: String, max_employee: String, business_category: String, turn_over: String, location: String, rank: String){
        val anim: Animation = AnimationUtils.loadAnimation(requireActivity(), android.R.anim.fade_in)
        binding.relativelayout1.startAnimation(anim)

        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_my_buddiesFilter(readUsingSharedPreference(requireActivity(), "userid").toString(), keyword, membershiptype, min_employee, max_employee, business_category, turn_over, location, rank)
        call.enqueue(object : Callback<BuddiesAll> {
            override fun onResponse(
                    call: Call<BuddiesAll>,
                    response: Response<BuddiesAll>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.size != 0) {
                            binding.relativelayout.visibility = View.VISIBLE
                            binding.relativelayout1.visibility = View.GONE
                            binding.rvAllBuddies.visibility = View.VISIBLE
                            binding.NoLeadInvited.visibility = View.GONE
                            val mAdapter = AdapterAllBuddies(
                                    activity,
                                    response.body()?.data as MutableList<AllBuddies>, "BuddiesFragment",count_available)
                            binding.rvAllBuddies.adapter = mAdapter

                        } else {
                            binding.relativelayout.visibility = View.VISIBLE
                            binding.relativelayout1.visibility = View.GONE
                            binding.rvAllBuddies.visibility = View.GONE
                            binding.NoLeadInvited.visibility = View.VISIBLE
                        }
                    }
                }
            }

            override fun onFailure(call: Call<BuddiesAll>, t: Throwable) {
                dismissLoader();

            }
        })

    }

}