package com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Typeface
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.databinding.BsAllEventsFilterBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment.adapters.AdapterCategoriesEvents
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment.model.Allevents
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.Eventcategory
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.Adapter.AdapterUpcomingEvents
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayout
import com.justforentrepreneurs.j4eapp.abmainj4e.SingleSlection
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment.adapters.AllEventsPagerAdapter
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.AllBuddies
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.recommended.adapters.RecommendedPagerAdapter
import kotlinx.android.synthetic.main.activity_all_events.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class AllEventsFragment(position:Int) : Fragment(R.layout.activity_all_events), SingleSlection {
    lateinit var mainActivity: MainActivity
    private val sharedPrefFile = "AllEventsFragment"
    var rankck :String=""
    companion object {
        var lstChk: MutableList<Eventcategory.Eventdata> = mutableListOf<Eventcategory.Eventdata>()
    }
    var new1st:String= ""
    var new2st:String=""
    private val position:Int=position
    var companyName: MutableList<Allevents.Alleventsdata> = mutableListOf<Allevents.Alleventsdata>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.visibility = View.GONE



        mainActivity = (activity as MainActivity?)!!
        mainActivity.binding.toolbar.ivCreate.visibility = View.GONE
        mainActivity.binding.toolbar.searchhome.visibility = View.GONE
        mainActivity.binding.toolbar.logotoolbar.visibility = View.GONE
        mainActivity.binding.toolbar.ivaddCreate.visibility = View.VISIBLE
        mainActivity.binding.toolbar.tvTitle.visibility = View.VISIBLE
        mainActivity.binding.toolbar.tvTitle.text="Upcoming Events"

        mainActivity.binding.toolbar.ivaddCreate.setBackgroundResource(R.drawable.ic_filter_j4e_member_screen)

        //setupViewPager()
        mainActivity.binding.toolbar.ivaddCreate.setOnClickListener {
            val dialog = BottomSheetDialog(requireActivity(), R.style.CustomBottomSheetDialogTheme)
            val mBsMemberFilterBinding: BsAllEventsFilterBinding =
                    DataBindingUtil.inflate(LayoutInflater.from(requireActivity()), R.layout.bs_all_events_filter, null, false)
            dialog.setCancelable(true)
            dialog.setCanceledOnTouchOutside(true)
            dialog.setContentView(mBsMemberFilterBinding.root)
            mBsMemberFilterBinding.llTypeMembership.visibility=View.GONE
            mBsMemberFilterBinding.view.visibility=View.GONE

            val sharedPreferences: SharedPreferences = requireActivity().getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)


            var rankckst = sharedPreferences.getString("type", "")
            val lstChkst = sharedPreferences.getString("CheckCat", "")

         /*   if(!lstChkst.equals("")) {
                val arrayst: String = lstChkst.toString()
                if (arrayst.isEmpty()) {
                } else {
                    val str = arrayst.split(",".toRegex()).toTypedArray()
                    var al: List<String?> = ArrayList()
                    al = Arrays.asList(*str)
                    for (s in al) {
                        val datum: Eventcategory.Eventdata= Eventcategory.Eventdata(s,"",false)
                        lstChk.add(datum)
                    }
                }
            }*/


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
                }

            }


            mBsMemberFilterBinding.top10.setOnClickListener {
                mBsMemberFilterBinding.top10.isChecked=true
                mBsMemberFilterBinding.top100.isChecked=false
                mBsMemberFilterBinding.top500.isChecked=false
                rankck="1"
            }

            mBsMemberFilterBinding.top100.setOnClickListener {
                mBsMemberFilterBinding.top10.isChecked=false
                mBsMemberFilterBinding.top100.isChecked=true
                mBsMemberFilterBinding.top500.isChecked=false
                rankck="2"
            }

            mBsMemberFilterBinding.top500.setOnClickListener {
                mBsMemberFilterBinding.top10.isChecked=false
                mBsMemberFilterBinding.top100.isChecked=false
                mBsMemberFilterBinding.top500.isChecked=true
                rankck="3"
            }

            getAllEventsCat(mBsMemberFilterBinding)

            mBsMemberFilterBinding.ivClose.setOnClickListener {
                lstChk.clear()
                val editor = sharedPreferences.edit()
                editor.clear()
                editor.apply()
                dialog.dismiss()

            }
            mBsMemberFilterBinding.clearall.setOnClickListener {
                lstChk.clear()
                val editor = sharedPreferences.edit()
                editor.clear()
                editor.apply()
                dialog.dismiss()
                if (isInternetAvailable(requireActivity())) {
                    getAllEvents()
                }
            }

            mBsMemberFilterBinding.tvApplyFilter.setOnClickListener {
                dialog.dismiss()
                if(isInternetAvailable(requireActivity())) {
                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                    editor.putString("type", rankck)
                    editor.putString("CheckCat", lstChk.toString())
                    editor.apply()
                    editor.commit()

                        new1st=""
                        new2st=""
                        for (i in lstChk.indices) {
                            new1st =lstChk.get(i).cat_id
                            new2st = new2st + "," + new1st
                        }
                       rvevents.visibility=View.VISIBLE
                       rvCommon.visibility = View.GONE
                      getAllEventskey(rankck, new2st.replaceFirst(",", ""))
                }
            }
            dialog.show()
        }


        recyclerData()

        view.setFocusableInTouchMode(true)
        view.requestFocus()
        view.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                mainActivity.setBottomIconChange("3")
                mainActivity.loadFragment(HomeFragment(0,0), "Home")
                true
            } else false
        })
    }

    private fun recyclerData() {
        val layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
        rvCommon.layoutManager = layoutManager

        if(isInternetAvailable(requireActivity())){
            getAllEvents()
        }
    }

    private fun getAllEvents(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_event_list("2",readUsingSharedPreference(requireActivity(), "userid").toString())

        call.enqueue(object : Callback<Allevents> {
            override fun onResponse(
                    call: Call<Allevents>,
                    response: Response<Allevents>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {

                            storeUsingSharedPreference(
                                requireActivity(),
                                "eventCountOld", response.body()?.data?.size.toString()
                            )

                            rvevents.visibility=View.GONE

                            rvCommon.visibility = View.VISIBLE
                            Noevents.visibility = View.GONE
                            if(readUsingSharedPreference(requireActivity(), "addpersmisson").toString().equals("1")) {
                                companyName.clear()
                                companyName.addAll(response.body()?.data!!)
                            }else{
                                companyName.clear()
                                for (j in 0 until response.body()?.data!!.size) {
                                    if(response.body()?.data?.get(j)?.event_publish_status.toString().equals("2")){

                                    }else{
                                        companyName.add(response.body()?.data?.get(j)!!)
                                    }
                                }
                            }

                            val mAdapter = AdapterUpcomingEvents(
                                requireActivity(),
                                companyName, "Fragment"
                            )
                            rvCommon.adapter = mAdapter
                            rvCommon.getLayoutManager()?.scrollToPosition(position)

                        }
                    } else {
                        rvevents.visibility=View.GONE
                        rvCommon.visibility = View.GONE
                        Noevents.visibility = View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<Allevents>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    private fun getAllEventsCat(mBsMemberFilterBinding: BsAllEventsFilterBinding){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_event_category()

        call.enqueue(object : Callback<Eventcategory> {
            override fun onResponse(
                    call: Call<Eventcategory>,
                    response: Response<Eventcategory>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            mBsMemberFilterBinding.linearlayout1.visibility=View.GONE
                            mBsMemberFilterBinding.linearlayout.visibility=View.VISIBLE
                            val layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
                            mBsMemberFilterBinding.eventcatrecyler.layoutManager = layoutManager
                            val mAdapter = AdapterCategoriesEvents(
                                    requireActivity(),
                                    response.body()?.data as MutableList<Eventcategory.Eventdata>,this@AllEventsFragment)
                            mBsMemberFilterBinding.eventcatrecyler.adapter = mAdapter


                        } else {
                            mBsMemberFilterBinding.linearlayout1.visibility=View.GONE
                            mBsMemberFilterBinding.linearlayout.visibility=View.VISIBLE

                        }
                    }
                }
            }

            override fun onFailure(call: Call<Eventcategory>, t: Throwable) {
                dismissLoader();

            }
        })

    }

    private fun getAllEventskey(type: String, category: String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
//        displayToast(requireContext(),type+","+category)
        val call = request.app_get_event_listfilter("2", category,readUsingSharedPreference(requireActivity(), "userid").toString())
        call.enqueue(object : Callback<Allevents> {
            override fun onResponse(
                    call: Call<Allevents>,
                    response: Response<Allevents>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            rvevents.visibility=View.GONE
                            rvCommon.visibility = View.VISIBLE
                            Noevents.visibility = View.GONE
                            if(readUsingSharedPreference(requireActivity(), "addpersmisson").toString().equals("1")) {
                                companyName.clear()
                                companyName.addAll(response.body()?.data!!)
                            }else{
                                companyName.clear()
                                for (j in 0 until response.body()?.data!!.size) {
                                    if(response.body()?.data?.get(j)?.event_publish_status.toString().equals("2")){

                                    }else{
                                        companyName.add(response.body()?.data?.get(j)!!)
                                    }
                                }
                            }
                            val mAdapter = AdapterUpcomingEvents(requireActivity(),companyName, "Fragment")
                            rvCommon.adapter = mAdapter

                        }
                    } else {
                        rvevents.visibility=View.GONE
                        rvCommon.visibility = View.GONE
                        Noevents.visibility = View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<Allevents>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    override fun addMultiSelection(multiModel: MutableList<Eventcategory.Eventdata>, pos: Int) {
        lstChk.add(multiModel.get(pos))
    }

    override fun removeMultiSelection(
        multiModel: MutableList<Eventcategory.Eventdata>,
        id: String,
        pos: Int
    ) {
        try {
            for (j in 0 until lstChk.size) {
                if (lstChk.get(j).cat_id.equals(id)) {
                    lstChk.removeAt(j)
                }
            }

        } catch (exception: ConcurrentModificationException) {
            // Catch ConcurrentModificationExceptions.
            // Logging.log(exception);
        } catch (throwable: Throwable) {
            // Catch any other Throwables.
            // Logging.log(throwable);
        }
    }


    private fun setupViewPager() {
        val viewPagerAdapter = fragmentManager?.let { AllEventsPagerAdapter(it) }
        vpHome.adapter = viewPagerAdapter
        tabHome.setupWithViewPager(vpHome)
        tabHome.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
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
        val font = ResourcesCompat.getFont(requireContext(), R.font.notosans_jp_medium)
        val vg = tabHome.getChildAt(0) as ViewGroup
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


}