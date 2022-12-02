package com.justforentrepreneurs.j4eapp.abmainj4e.ui.home

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseFragment
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.AdapterJ4EMember
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.adapters.AdapterJ4ECategory
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.adapters.AdapterJ4EMemPlans
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.adapters.AdapterNoofEmpolyee
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.adapters.AdapterTurnOverJ4e
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.interfaces.OnClickLinerJ4e
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.Datauser
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.FilterPlan
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.J4EMember
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.Memberinfo
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.FunctionalArea
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.FunctionalData
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.permissions.PermissionsResponse
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.ConnectionSend
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.GetEmployeeWork
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.GetTurnOver
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.databinding.BsMemberFilterBinding
import com.justforentrepreneurs.j4eapp.databinding.FragmentFragJ4EMembersBinding
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
//import com.justforentrepreneurs.j4eapp.utils.ContactUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FragJ4EMembers(position:Int) : BaseFragment(), OnClickLinerJ4e, AdapterJ4EMemPlans.OnClick2,
    AdapterJ4ECategory.OnClick2, AdapterTurnOverJ4e.OnClick2,
    AdapterNoofEmpolyee.OnClick2 {
    private lateinit var binding:FragmentFragJ4EMembersBinding
    private var mContext: Context? = null
    var mActivity: MainActivity? = null
    private val positionI:Int=position
    var areaid :String=""
    var turnid :String=""
    var planid :String=""
    var rankck :String=""
    var areanamem :String=""
    var turnidnamem :String=""
    var lstChk:String=""
    var AboutId :String=""
    var AboutValue :String=""
    private var position:String=""
    private val sharedPrefFile = "J4EMembersActivity"
    var is_post_exhausted: Int = -1
    var is_requirement_exhausted: Int = -1
    var is_buddy_meet_exhausted: Int = -1
    var count_available: Int = -1
    var is_referral_exhausted: Int = -1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_frag_j4_e_members, container, false)
        mContext = activity;
        mActivity = mContext as MainActivity
        recyclerData()
        binding.ivFilter.setOnClickListener {
            bottomSheetFilter()
        }

        if (isInternetAvailable(requireContext())) {
            //ContactUtils.fetchData()
//            if (readUsingSharedPreference(requireContext(),"PermissionViewJ4EmemberProfile").equals("0")){
//                PermissionDialog("You don't have permission to View J4E Member List.")
//            }else{
//                getDataMember(position)
//            }
            getDataMember(position)
            app_check_permissions()

        }

        binding.editsearchname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                if (s == "") {
                    if (isInternetAvailable(requireContext())) {
                        getDataMemberKey("", "", "", "", "", "", "","")
                    }
                }
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s == "") {
                    if (isInternetAvailable(requireContext())) {
                        getDataMemberKey("", "", "", "", "", "", "","")
                    }
                }
            }

            override fun afterTextChanged(s: Editable) {
                if (isInternetAvailable(requireContext())) {
                    if (s.length > 0) {
                        binding.rvAllBuddies.setAdapter(null)
                        getDataMemberKey(s.toString(), "", "", "", "", "", "","")
                    } else if (s.length == 0) {
                        binding.rvAllBuddies.setAdapter(null)
                        getDataMemberKey("", "", "", "", "", "", "","")
                    }
                }
            }
        })
        return binding.root
    }

    private fun app_check_permissions(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_home_screen_permission(readUsingSharedPreference(requireContext(), "userid").toString())
        //showLoader(this);
        call.enqueue(object : Callback<PermissionsResponse> {
            override fun onResponse(
                call: Call<PermissionsResponse>,
                response: Response<PermissionsResponse>
            ) {

                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.permissions?.size!=0){
                            for (i in 0 until response.body()?.data?.permissions?.size!!) {
                                is_post_exhausted=response.body()?.data?.is_post_exhausted!!
                                is_requirement_exhausted=response.body()?.data?.is_requirement_exhausted!!
                                is_buddy_meet_exhausted=response.body()?.data?.is_buddy_meet_exhausted!!
                                is_referral_exhausted=response.body()?.data?.is_referral_exhausted!!
                                if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("1")){
                                    storeUsingSharedPreference(requireContext(),"PermissionCreatePost",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("2")){
                                    storeUsingSharedPreference(requireContext(),"PermissionCreateRequirement",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("3")){
                                    storeUsingSharedPreference(requireContext(),"PermissionCreateBuddyMeet",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("4")){
                                    storeUsingSharedPreference(requireContext(),"PermissionCreateFollowUp",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("5")){
                                    storeUsingSharedPreference(requireContext(),"PermissionCreateAddGalleryImage",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("6")){
                                    storeUsingSharedPreference(requireContext(),"PermissionConnectionRequest",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("7")){
                                    storeUsingSharedPreference(requireContext(),"PermissionCreateRecommendation",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("8")){
                                    storeUsingSharedPreference(requireContext(),"PermissionReview",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("9")){
                                    storeUsingSharedPreference(requireContext(),"PermissionViewJ4EmemberProfile",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("10")){
                                    storeUsingSharedPreference(requireContext(),"PermissionViewLeads",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("11")){
                                    storeUsingSharedPreference(requireContext(),"PermissionCreateReferral",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }
                            }
                        }else{
                            storeUsingSharedPreference(requireContext(),"PermissionCreatePost","0")
                            storeUsingSharedPreference(requireContext(),"PermissionCreateRequirement","0")
                            storeUsingSharedPreference(requireContext(),"PermissionCreateBuddyMeet","0")
                            storeUsingSharedPreference(requireContext(),"PermissionCreateFollowUp","0")
                            storeUsingSharedPreference(requireContext(),"PermissionCreateAddGalleryImage","0")
                            storeUsingSharedPreference(requireContext(),"PermissionConnectionRequest","0")
                            storeUsingSharedPreference(requireContext(),"PermissionCreateRecommendation","0")
                            storeUsingSharedPreference(requireContext(),"PermissionReview","0")
                            storeUsingSharedPreference(requireContext(),"PermissionViewJ4EmemberProfile","0")
                            storeUsingSharedPreference(requireContext(),"PermissionViewLeads","0")
                            storeUsingSharedPreference(requireContext(),"PermissionCreateReferral","0")
                        }
                    } else {

                    }
                }
            }

            override fun onFailure(call: Call<PermissionsResponse>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    override fun onClickPos(pos: Int, mdata: MutableList<Memberinfo>, img: ImageView) {
        if (isInternetAvailable(requireContext())) {
            if (readUsingSharedPreference(requireContext(),"PermissionConnectionRequest").equals("0")){
                PermissionDialog(readUsingSharedPreference(requireContext(),"CreatePermissionMsg").toString())
            }else{
                getconnection_request_sent(readUsingSharedPreference(requireContext(), "userid").toString(), mdata, img, pos)
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1003) {
            if (readUsingSharedPreference(requireContext(),"PermissionViewJ4EmemberProfile").equals("0")){
                PermissionDialog(readUsingSharedPreference(requireContext(),"ViewPermissionMsg").toString())
            }else{
                getDataMember(position)
            }
        }
    }

    override fun OnClickpro(position: Int, data: String,is_viewed: Int) {
        if (count_available == 0){
            if (is_viewed==0){
                PermissionDialog(readUsingSharedPreference(requireContext(),"ViewExhaustedMsg").toString())
            }else{
                val intent = Intent(requireContext(), ProfileActivity::class.java)
                intent.putExtra("id",data)
                intent.putExtra("position",position.toString())
                intent.putExtra("type", "J4EMemberDetails")
                startActivityForResult(intent,1003)
            }
        }else{
            val intent = Intent(requireContext(), ProfileActivity::class.java)
            intent.putExtra("id",data)
            intent.putExtra("position",position.toString())
            intent.putExtra("type", "J4EMemberDetails")
            startActivityForResult(intent,1003)
        }

    }

    override fun OnClick(
        position: String,
        id: String,
        mBsMemberFilterBinding: BsMemberFilterBinding
    ) {
        mBsMemberFilterBinding.tvCategory.setText(position)
        areaid=id
        areanamem=position
        mBsMemberFilterBinding.ivDropDown.visibility = View.VISIBLE
        mBsMemberFilterBinding.ivDropUp.visibility = View.GONE
        mBsMemberFilterBinding.rvCategory.visibility = View.GONE
        Log.d("position", position.toString())
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

    override fun OnClickJ4e(
        position: String,
        id: String,
        mBsMemberFilterBinding: BsMemberFilterBinding
    ) {
        mBsMemberFilterBinding.tvCategory1.text = position;
        turnid=id
        turnidnamem=position
        mBsMemberFilterBinding.ivDropDown1.visibility = View.VISIBLE
        mBsMemberFilterBinding.ivDropUp1.visibility = View.GONE
        mBsMemberFilterBinding.rvCategory1.visibility = View.GONE
        Log.d("position", position.toString());
    }
    override fun OnClickPlan(position: String, id: String) {
        planid=id
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
                            mBsMemberFilterBinding.rvCategory2.layoutManager = GridLayoutManager(requireContext(), 1)
                            val mAdapter = AdapterNoofEmpolyee(
                                requireActivity(),
                                response.body()?.data as MutableList<GetEmployeeWork.EmployeeWork>,
                                this@FragJ4EMembers,mBsMemberFilterBinding
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
                            mBsMemberFilterBinding.recyclerplan.layoutManager = GridLayoutManager(requireContext(), 2)
                            val mAdapter = AdapterJ4EMemPlans(
                                requireActivity(),
                                response.body()?.data as MutableList<FilterPlan.DataFilter>, this@FragJ4EMembers,lack)
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
                            mBsMemberFilterBinding.rvCategory1.layoutManager = GridLayoutManager(requireContext(), 1)
                            val mAdapter = AdapterTurnOverJ4e(
                                requireActivity(),
                                response.body()?.data as MutableList<GetTurnOver.DataTurn>,
                                this@FragJ4EMembers, mBsMemberFilterBinding)
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

    private fun getAllAraekeyword(mBsMemberFilterBinding: BsMemberFilterBinding,Keyword:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_functional_area(Keyword)
        call.enqueue(object : Callback<FunctionalArea> {
            override fun onResponse(
                call: Call<FunctionalArea>,
                response: Response<FunctionalArea>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            mBsMemberFilterBinding.rvCategory.layoutManager = GridLayoutManager(requireContext(), 1)
                            val mAdapter = AdapterJ4ECategory(
                                requireActivity(),
                                response.body()?.data as MutableList<FunctionalData>, this@FragJ4EMembers, mBsMemberFilterBinding)
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

    private fun getAllArae(mBsMemberFilterBinding: BsMemberFilterBinding,Keyword:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_functional_area(Keyword)
        call.enqueue(object : Callback<FunctionalArea> {
            override fun onResponse(
                call: Call<FunctionalArea>,
                response: Response<FunctionalArea>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            mBsMemberFilterBinding.rvCategory.layoutManager = GridLayoutManager(requireContext(), 1)
                            val mAdapter = AdapterJ4ECategory(
                                requireActivity(),
                                response.body()?.data as MutableList<FunctionalData>, this@FragJ4EMembers, mBsMemberFilterBinding)
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

    private fun getconnection_request_sent(id: String, mdata: MutableList<Memberinfo>, img: ImageView, pos: Int) {
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.getconnection_request_sent(id, mdata.get(pos).id)
        showLoader(requireContext());
        call.enqueue(object : Callback<ConnectionSend> {
            override fun onResponse(
                call: Call<ConnectionSend>,
                response: Response<ConnectionSend>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.user_data != null) {
                            img.setImageResource(R.drawable.ic_connect)

                            displayToast(requireContext(), response.body()?.message.toString())

                        } else {
                            displayToast(requireContext(), response.body()?.message.toString())
                        }
                    }else{
                        PermissionDialog(response.body()?.message.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ConnectionSend>, t: Throwable) {
                dismissLoader();
                displayToast(requireContext(), requireContext().resources.getString(R.string.error_something_wrong))
            }
        })
    }

    private fun getDataMember(position:String){
        val anim: Animation = AnimationUtils.loadAnimation(requireContext(), android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_all_members(readUsingSharedPreference(requireContext(), "userid").toString(),"0","0")
        call.enqueue(object : Callback<J4EMember> {
            override fun onResponse(
                call: Call<J4EMember>,
                response: Response<J4EMember>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.member_info?.size != 0) {
                            binding.linearlayout1.visibility = View.GONE
                            binding.rvAllBuddies.visibility = View.VISIBLE
                            binding.NoLeadInvited.visibility = View.GONE
                            count_available=response.body()?.count_available!!
                            val mAdapter = AdapterJ4EMember(
                                requireActivity(), response.body()?.data?.is_connection_exhausted!!,response.body()?.data?.member_info as MutableList<Memberinfo>, this@FragJ4EMembers)
                            binding.rvAllBuddies.adapter = mAdapter
                            //binding.rvAllBuddies.getLayoutManager()?.scrollToPosition(position.toInt());
                            binding.rvAllBuddies.getLayoutManager()?.scrollToPosition(positionI)
                        }
                    } else {
                        binding.linearlayout1.visibility = View.GONE
                        binding.rvAllBuddies.visibility = View.GONE
                        binding.NoLeadInvited.visibility = View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<J4EMember>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    private fun getDataMemberKey(keyword: String, membershiptype: String, min_employee: String, max_employee: String, business_category: String, turn_over: String, location: String, rank: String){
        val anim: Animation = AnimationUtils.loadAnimation(requireContext(), android.R.anim.fade_in)
        binding.linearlayout1.startAnimation(anim)

        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_all_membersKeyword(readUsingSharedPreference(requireContext(), "userid").toString(), keyword, membershiptype, min_employee, max_employee, business_category, turn_over, location,rank)
        call.enqueue(object : Callback<J4EMember> {
            override fun onResponse(
                call: Call<J4EMember>,
                response: Response<J4EMember>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.member_info?.size != 0) {

                            binding.linearlayout1.visibility = View.GONE
                            binding.rvAllBuddies.visibility = View.VISIBLE
                            binding.NoLeadInvited.visibility = View.GONE

                            val mAdapter = AdapterJ4EMember(
                                requireActivity(), response.body()?.data?.is_connection_exhausted!!,response.body()?.data?.member_info as MutableList<Memberinfo>, this@FragJ4EMembers)
                            binding.rvAllBuddies.adapter = mAdapter

                        }
                    } else {
                        binding.linearlayout1.visibility = View.GONE
                        binding.rvAllBuddies.visibility = View.GONE
                        binding.NoLeadInvited.visibility = View.VISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<J4EMember>, t: Throwable) {
                dismissLoader();
                binding.linearlayout1.visibility = View.GONE
                binding.rvAllBuddies.visibility = View.GONE
                binding.NoLeadInvited.visibility = View.VISIBLE
            }
        })

    }

    private fun recyclerData() {
        val layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.rvAllBuddies.layoutManager = layoutManager
    }

    private fun bottomSheetFilter() {

        val dialog = BottomSheetDialog(requireContext(), R.style.CustomBottomSheetDialogTheme)
        val mBsMemberFilterBinding: BsMemberFilterBinding =
            DataBindingUtil.inflate(LayoutInflater.from(requireContext()), R.layout.bs_member_filter, null, false)
        dialog.setCancelable(true)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setContentView(mBsMemberFilterBinding.root)
        //dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED

        val anim: Animation = AnimationUtils.loadAnimation(requireContext(), android.R.anim.fade_in)
        mBsMemberFilterBinding.linearlayout1.startAnimation(anim)

        val sharedPreferences: SharedPreferences = requireContext().getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)


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


        if(!areaidst.equals("")){
            areaidst=areaid
            mBsMemberFilterBinding.tvCategory.setText(areaname)
        }

        if(!turnidst.equals("")){
            turnidst=turnid
            mBsMemberFilterBinding.tvCategory1.text = turnidname
        }


        if(!minvaluest.equals("")){
            minvaluest=AboutId
            mBsMemberFilterBinding.tvCategory2.text = NoofempNamest
        }

        if(!maxvaluest.equals("")){
            maxvaluest="0"
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
                    if (isInternetAvailable(requireContext())) {
                        getAllAraekeyword(mBsMemberFilterBinding,"")
                    }
                    mBsMemberFilterBinding.crossfun.visibility=View.GONE
                }
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s == "") {
                    if (isInternetAvailable(requireContext())) {
                        getAllAraekeyword(mBsMemberFilterBinding,"")
                    }
                    mBsMemberFilterBinding.crossfun.visibility=View.GONE
                }
            }

            override fun afterTextChanged(s: Editable) {
                if (isInternetAvailable(requireContext())) {
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

        mBsMemberFilterBinding.clearloctaion.setOnClickListener {
            mBsMemberFilterBinding.editlocation.setText("")
        }

        mBsMemberFilterBinding.clearall.setOnClickListener {
            dialog.dismiss()
            lstChk=""
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.commit()
            editor.apply()
            dialog.dismiss()
            if (isInternetAvailable(requireContext())) {
                if (readUsingSharedPreference(requireContext(),"PermissionViewJ4EmemberProfile").equals("0")){
                    PermissionDialog(readUsingSharedPreference(requireContext(),"ViewPermissionMsg").toString())
                }else{
                    getDataMember("0")
                }
            }
        }

        if(isInternetAvailable(requireContext())) {
            getAllArae(mBsMemberFilterBinding,"")
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
            if(isInternetAvailable(requireContext())) {
                val editor: SharedPreferences.Editor =  sharedPreferences.edit()
                editor.putString("planid", planid)
                editor.putString("minvalue",AboutId )
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

                getDataMemberKey("", planid, AboutId, "0", areaid, turnid, mBsMemberFilterBinding.editlocation.text.toString(),rankck)
            }
        }
        dialog.show()
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