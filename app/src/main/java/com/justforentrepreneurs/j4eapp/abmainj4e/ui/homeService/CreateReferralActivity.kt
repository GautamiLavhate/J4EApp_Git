package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.J4EMember
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.Memberinfo
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.Adapter.AdapterLeadStatusCategory
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters.*
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.*
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.dismissLoader
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.displayToast
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.isInternetAvailable
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.readUsingSharedPreference
import com.justforentrepreneurs.j4eapp.databinding.ActivityCreateReferralBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class CreateReferralActivity : AppCompatActivity(),AdapterBuddiesMembers.OnClick2,AdapterFunctionalArea.OnClick2,
    RefrralSingleSlection,AdapterContactPerson.OnClick2{
    private lateinit var binding:ActivityCreateReferralBinding
    var CheckRadion="1"
    var hotReferralRatio:String=""
    var UseridReferralFor:String=""
    var UseridContactInfo:String=""
    var FunctionalAreaId:String=""
    var new1st:String= ""
    var new2st:String=""
    companion object {
        var lstChk: MutableList<Reffralcategory.ReffralcategoryData> = mutableListOf<Reffralcategory.ReffralcategoryData>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_create_referral)
        binding.toolbar.ivBack.setOnClickListener {
            onBackPressed()
        }
        binding.toolbar.tvTitle.text=resources.getString(R.string.create_referral)
        binding.outsideli.visibility= View.GONE
        binding.listkbbflist.visibility= View.GONE
        binding.ContactPersontvt.visibility= View.GONE
        binding.changetext.text="Referral for My Self"

        initListener()

        recyclerData()

        binding.toolbar.ivPublish.setOnClickListener {
            if (validation()){
                if (CheckRadion.equals("1")){
                    create_referral(UseridReferralFor,UseridReferralFor)
                }else if (CheckRadion.equals("2")){
                    create_referral(UseridReferralFor,UseridContactInfo)
                }else if (CheckRadion.equals("3")){
                    create_referral(UseridReferralFor,"")
                }

            }

        }
    }
    private fun initListener(){
        binding.myself.setOnClickListener {
            CheckRadion="1"
            binding.myself.isChecked=true
            binding.inside.isChecked=false
            binding.Outside.isChecked=false
            binding.outsideli.visibility= View.GONE
            binding.listkbbflist.visibility= View.GONE
            binding.ContactPersontvt.visibility= View.GONE
            binding.changetext.text="Referral for My Self"

        }
        binding.inside.setOnClickListener {
            CheckRadion="2"
            binding.myself.isChecked=false
            binding.inside.isChecked=true
            binding.Outside.isChecked=false
            binding.outsideli.visibility= View.GONE
            binding.listkbbflist.visibility= View.VISIBLE
            binding.ContactPersontvt.visibility= View.VISIBLE
            binding.changetext.text="Referral for J4E Member"
        }

        binding.Outside.setOnClickListener {
            CheckRadion="3"
            binding.myself.isChecked=false
            binding.inside.isChecked=false
            binding.Outside.isChecked=true
            binding.outsideli.visibility= View.VISIBLE
            binding.listkbbflist.visibility= View.GONE
            binding.ContactPersontvt.visibility= View.VISIBLE
            binding.changetext.text="Referral for Non J4E Member"
        }

        binding.radio1.setOnClickListener {
            hotReferralRatio="1"
            binding.radio1.isChecked=true
            binding.radio2.isChecked=false
            binding.radio3.isChecked=false
            binding.radio4.isChecked=false
            binding.radio5.isChecked=false
        }

        binding.radio2.setOnClickListener {
            hotReferralRatio="2"
            binding.radio1.isChecked=false
            binding.radio2.isChecked=true
            binding.radio3.isChecked=false
            binding.radio4.isChecked=false
            binding.radio5.isChecked=false
        }

        binding.radio3.setOnClickListener {
            hotReferralRatio="3"
            binding.radio1.isChecked=false
            binding.radio2.isChecked=false
            binding.radio3.isChecked=true
            binding.radio4.isChecked=false
            binding.radio5.isChecked=false
        }

        binding.radio4.setOnClickListener {
            hotReferralRatio="4"
            binding.radio1.isChecked=false
            binding.radio2.isChecked=false
            binding.radio3.isChecked=false
            binding.radio4.isChecked=true
            binding.radio5.isChecked=false
        }

        binding.radio5.setOnClickListener {
            hotReferralRatio="5"
            binding.radio1.isChecked=false
            binding.radio2.isChecked=false
            binding.radio3.isChecked=false
            binding.radio4.isChecked=false
            binding.radio5.isChecked=true
        }
    }

    private fun recyclerData(){
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvCategoryfun.layoutManager = layoutManager
        val layoutManager1 = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvCategoryReferralFor.layoutManager = layoutManager1
        val layoutManager4 = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.reclercateid.layoutManager = layoutManager4
        val layoutManager2 = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvCategoryContact.layoutManager = layoutManager2
        getAllStatusre()
        binding.llCategorySelectionReferralFor.setOnClickListener {
            if (binding.ivDropDownReferralFor.isVisible) {
                binding.ivDropDownReferralFor.visibility = View.GONE
                binding.ivDropUpReferralFor.visibility = View.VISIBLE
                binding.rvCategoryReferralFor.visibility = View.VISIBLE
                getBuddiesList("")
            } else {
                binding.ivDropDownReferralFor.visibility = View.VISIBLE
                binding.ivDropUpReferralFor.visibility = View.GONE
                binding.rvCategoryReferralFor.visibility = View.GONE
            }
        }
        binding.llCategorySelectionfun.setOnClickListener {
            if (binding.ivDropDownfun.isVisible) {
                binding.ivDropDownfun.visibility = View.GONE
                binding.ivDropUpfun.visibility = View.VISIBLE
                binding.rvCategoryfun.visibility = View.VISIBLE
                getAllArae("")
            } else {
                binding.ivDropDownfun.visibility = View.VISIBLE
                binding.ivDropUpfun.visibility = View.GONE
                binding.rvCategoryfun.visibility = View.GONE
            }
        }
        binding.tvCategoryfun.setOnClickListener {
            if (binding.ivDropDownfun.isVisible) {
                binding.ivDropDownfun.visibility = View.GONE
                binding.ivDropUpfun.visibility = View.VISIBLE
                binding.rvCategoryfun.visibility = View.VISIBLE
                getAllArae("")
            } else {
                binding.ivDropDownfun.visibility = View.VISIBLE
                binding.ivDropUpfun.visibility = View.GONE
                binding.rvCategoryfun.visibility = View.GONE
            }
        }
        binding.llCategorySelectionContact.setOnClickListener {
            if (binding.ivDropDownContact.isVisible) {
                binding.ivDropDownContact.visibility = View.GONE
                binding.ivDropUpContact.visibility = View.VISIBLE
                binding.rvCategoryContact.visibility = View.VISIBLE
                if(isInternetAvailable(this)){
                    getBuddiesList1("")
                }
            } else {
                binding.ivDropDownContact.visibility = View.VISIBLE
                binding.ivDropUpContact.visibility = View.GONE
                binding.rvCategoryContact.visibility = View.GONE
            }
        }
        binding.tvCategoryReferralFor.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                if(s.toString().trim().length>0){
                    if (binding.ivDropDownReferralFor.isVisible) {
                        binding.ivDropDownReferralFor.visibility = View.GONE
                        binding.ivDropUpReferralFor.visibility = View.VISIBLE
                        binding.rvCategoryReferralFor.visibility = View.VISIBLE
                    } else {
                        binding.ivDropDownReferralFor.visibility = View.VISIBLE
                        binding.ivDropUpReferralFor.visibility = View.GONE
                        binding.rvCategoryReferralFor.visibility = View.GONE
                    }
                }else{
                    binding.ivDropDownReferralFor.visibility = View.VISIBLE
                    binding.ivDropUpReferralFor.visibility = View.GONE
                    binding.rvCategoryReferralFor.visibility = View.GONE
                }
                if (s == "") {
                    if (isInternetAvailable(this@CreateReferralActivity)) {
                        getBuddiesList("")
                    }
                    binding.crossReffral.visibility=View.GONE
                }
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s == "") {
                    if (isInternetAvailable(this@CreateReferralActivity)) {
                        getBuddiesList("")
                    }
                    binding.crossReffral.visibility=View.GONE
                }
            }

            override fun afterTextChanged(s: Editable) {
                if (isInternetAvailable(this@CreateReferralActivity)) {
                    if (s.length > 0) {
                        binding.rvCategoryReferralFor.setAdapter(null)
                        binding.crossReffral.visibility=View.VISIBLE
                        getBuddiesList(s.toString())
                    } else if (s.length == 0) {
                        binding.rvCategoryReferralFor.setAdapter(null)
                        getBuddiesList("")
                        binding.crossReffral.visibility=View.GONE
                    }
                }
            }
        })
        binding.tvCategoryfun.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                if(s.toString().trim().length>0){
                    if (binding.ivDropDownfun.isVisible) {
                        binding.ivDropDownfun.visibility = View.GONE
                        binding.ivDropUpfun.visibility = View.VISIBLE
                        binding.rvCategoryfun.visibility = View.VISIBLE
                    } else {
                        binding.ivDropDownfun.visibility = View.VISIBLE
                        binding.ivDropUpfun.visibility = View.GONE
                        binding.rvCategoryfun.visibility = View.GONE
                    }
                }else{
                    binding.ivDropDownfun.visibility = View.VISIBLE
                    binding.ivDropUpfun.visibility = View.GONE
                    binding.rvCategoryfun.visibility = View.GONE
                }
                if (s == "") {
                    if (isInternetAvailable(this@CreateReferralActivity)) {
                        getAllArae("")
                    }
                    binding.crossfun.visibility=View.GONE
                }
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if(s.toString().trim().length>0){
                    if (binding.ivDropDownfun.isVisible) {
                        binding.ivDropDownfun.visibility = View.GONE
                        binding.ivDropUpfun.visibility = View.VISIBLE
                        binding.rvCategoryfun.visibility = View.VISIBLE
                    } else {
                        binding.ivDropDownfun.visibility = View.VISIBLE
                        binding.ivDropUpfun.visibility = View.GONE
                        binding.rvCategoryfun.visibility = View.GONE
                    }
                }else{
                    binding.ivDropDownfun.visibility = View.VISIBLE
                    binding.ivDropUpfun.visibility = View.GONE
                    binding.rvCategoryfun.visibility = View.GONE
                }
                if (s == "") {
                    if (isInternetAvailable(this@CreateReferralActivity)) {
                        getAllArae("")
                    }
                    binding.crossfun.visibility=View.GONE
                }
            }

            override fun afterTextChanged(s: Editable) {
                if (isInternetAvailable(this@CreateReferralActivity)) {
                    if (s.length > 0) {
                        binding.rvCategoryfun.setAdapter(null)
                        binding.crossfun.visibility=View.VISIBLE
                        getAllArae(s.toString())
                    } else if (s.length == 0) {
                        binding.rvCategoryfun.setAdapter(null)
                        getAllArae("")
                        binding.crossfun.visibility=View.GONE
                    }
                }
            }
        })
        binding.tvCategoryContact.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                if(s.toString().trim().length>0){
                    if (binding.ivDropDownContact.isVisible) {
                        binding.ivDropDownContact.visibility = View.GONE
                        binding.ivDropUpContact.visibility = View.VISIBLE
                        binding.rvCategoryContact.visibility = View.VISIBLE
                    } else {
                        binding.ivDropDownContact.visibility = View.VISIBLE
                        binding.ivDropUpContact.visibility = View.GONE
                        binding.rvCategoryContact.visibility = View.GONE
                    }
                }else{
                    binding.ivDropDownContact.visibility = View.VISIBLE
                    binding.ivDropUpContact.visibility = View.GONE
                    binding.rvCategoryContact.visibility = View.GONE
                }
                if (s == "") {
                    if (isInternetAvailable(this@CreateReferralActivity)) {
                        getBuddiesList1("")
                    }
                    binding.crossContact.visibility=View.GONE
                }
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if(s.toString().trim().length>0){
                    if (binding.ivDropDownContact.isVisible) {
                        binding.ivDropDownContact.visibility = View.GONE
                        binding.ivDropUpContact.visibility = View.VISIBLE
                        binding.rvCategoryContact.visibility = View.VISIBLE
                    } else {
                        binding.ivDropDownContact.visibility = View.VISIBLE
                        binding.ivDropUpContact.visibility = View.GONE
                        binding.rvCategoryContact.visibility = View.GONE
                    }
                }else{
                    binding.ivDropDownContact.visibility = View.VISIBLE
                    binding.ivDropUpContact.visibility = View.GONE
                    binding.rvCategoryContact.visibility = View.GONE
                }
                if (s == "") {
                    if (isInternetAvailable(this@CreateReferralActivity)) {
                        getBuddiesList1("")
                    }
                    binding.crossContact.visibility=View.GONE
                }
            }

            override fun afterTextChanged(s: Editable) {
                if (isInternetAvailable(this@CreateReferralActivity)) {
                    if (s.length > 0) {
                        binding.rvCategoryContact.setAdapter(null)
                        binding.crossContact.visibility=View.VISIBLE
                        getBuddiesList1(s.toString())
                    } else if (s.length == 0) {
                        binding.rvCategoryContact.setAdapter(null)
                        getBuddiesList1("")
                        binding.crossContact.visibility=View.GONE
                    }
                }
            }
        })


        binding.crossReffral.setOnClickListener {
            binding.tvCategoryReferralFor.setText("")
            UseridReferralFor=""
        }
        binding.crossfun.setOnClickListener {
            binding.tvCategoryfun.setText("")
            FunctionalAreaId=""
        }

        binding.crossContact.setOnClickListener {
            binding.tvCategoryContact.setText("")
            UseridContactInfo=""
        }

        binding.edtTitle.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if(validationText()==false){
                    binding.toolbar.ivPublish.setTextColor(getColor(R.color.greyed))
                } else {
                    binding.toolbar.ivPublish.setTextColor(getColor(R.color.white))
                }

            }
            override fun afterTextChanged(editable: Editable) {

            }
        })

        binding.edtFeedback.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if(validationText()==false){
                    binding.toolbar.ivPublish.setTextColor(getColor(R.color.greyed))
                } else {
                    binding.toolbar.ivPublish.setTextColor(getColor(R.color.white))
                }

            }
            override fun afterTextChanged(editable: Editable) {

            }
        })

        binding.edtname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if(validationText()==false){
                    binding.toolbar.ivPublish.setTextColor(getColor(R.color.greyed))
                } else {
                    binding.toolbar.ivPublish.setTextColor(getColor(R.color.white))
                }

            }
            override fun afterTextChanged(editable: Editable) {

            }
        })

        binding.edtMobileNumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if(validationText()==false){
                    binding.toolbar.ivPublish.setTextColor(getColor(R.color.greyed))
                } else {
                    binding.toolbar.ivPublish.setTextColor(getColor(R.color.white))
                }

            }
            override fun afterTextChanged(editable: Editable) {

            }
        })

        binding.edtLandlineNumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if(validationText()==false){
                    binding.toolbar.ivPublish.setTextColor(getColor(R.color.greyed))
                } else {
                    binding.toolbar.ivPublish.setTextColor(getColor(R.color.white))
                }

            }
            override fun afterTextChanged(editable: Editable) {

            }
        })

        binding.tvCategoryContact.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if(validationText()==false){
                    binding.toolbar.ivPublish.setTextColor(getColor(R.color.greyed))
                } else {
                    binding.toolbar.ivPublish.setTextColor(getColor(R.color.white))
                }

            }
            override fun afterTextChanged(editable: Editable) {

            }
        })
    }
    private fun getBuddiesList(Keyword:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_all_memberskey(readUsingSharedPreference(this, "userid").toString(),"0","0",Keyword)
        //displayToast(this,readUsingSharedPreference(this, "userid").toString()+","+Keyword+","+"0"+","+"0")
        call.enqueue(object : Callback<J4EMember> {
            override fun onResponse(
                call: Call<J4EMember>,
                response: Response<J4EMember>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.member_info?.size != 0) {

                            val mAdapter1 = AdapterBuddiesMembers(
                                this@CreateReferralActivity,
                                response.body()?.data?.member_info as MutableList<Memberinfo>, this@CreateReferralActivity
                            )
                            binding.rvCategoryReferralFor.adapter = mAdapter1

                        }else{

                        }
                    }else{

                    }
                }
            }

            override fun onFailure(call: Call<J4EMember>, t: Throwable) {
                dismissLoader();
            }
        })

    }
    private fun getBuddiesList1(Keyword:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_all_memberskey(readUsingSharedPreference(this, "userid").toString(),"0","0",Keyword)
        call.enqueue(object : Callback<J4EMember> {
            override fun onResponse(
                call: Call<J4EMember>,
                response: Response<J4EMember>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.member_info?.size != 0) {

                            val mAdapter = AdapterContactPerson(
                                this@CreateReferralActivity,
                                response.body()?.data?.member_info as MutableList<Memberinfo>, this@CreateReferralActivity
                            )
                            binding.rvCategoryContact.adapter = mAdapter


                        }else{

                        }
                    }else{
                        getAllArae("")

                    }
                }
            }

            override fun onFailure(call: Call<J4EMember>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    private fun getAllArae(Keyword:String){
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

                            val mAdapter = AdapterFunctionalArea(
                                this@CreateReferralActivity,
                                response.body()?.data as MutableList<FunctionalData>, this@CreateReferralActivity
                            )
                            binding.rvCategoryfun.adapter = mAdapter


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

    private fun getAllStatusre(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_referral_status()
        call.enqueue(object : Callback<Reffralcategory> {
            override fun onResponse(
                call: Call<Reffralcategory>,
                response: Response<Reffralcategory>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {

                            val mAdapter = AdapterReffStatusList(
                                this@CreateReferralActivity,
                                response.body()?.data as MutableList<Reffralcategory.ReffralcategoryData>, this@CreateReferralActivity
                            )
                            binding.reclercateid.adapter = mAdapter


                        } else {

                        }
                    }
                }
            }

            override fun onFailure(call: Call<Reffralcategory>, t: Throwable) {
                dismissLoader();
            }
        })

    }
    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun OnClick(position: String, id: String) {
        binding.tvCategoryReferralFor.setText(position)
        UseridReferralFor=id
        binding.ivDropDownReferralFor.visibility = View.VISIBLE
        binding.ivDropUpReferralFor.visibility = View.GONE
        binding.rvCategoryReferralFor.visibility = View.GONE
        Log.d("position", position.toString());
    }

    override fun OnClickFunctionalArea(position: String, id: String) {
        binding.tvCategoryfun.setText(position)
        FunctionalAreaId=id
        binding.ivDropDownfun.visibility = View.VISIBLE
        binding.ivDropUpfun.visibility = View.GONE
        binding.rvCategoryfun.visibility = View.GONE
        Log.d("position", position.toString());
    }

    override fun addMultiSelection(
        multiModel: MutableList<Reffralcategory.ReffralcategoryData>,
        pos: Int
    ) {
        lstChk.add(multiModel.get(pos))
    }

    override fun removeMultiSelection(
        multiModel: MutableList<Reffralcategory.ReffralcategoryData>,
        id: String,
        pos: Int
    ) {
        try {
            for (j in 0 until lstChk.size) {
                if (lstChk.get(j).id.equals(id)) {
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

    override fun OnClickContactPerson(position: String, id: String) {
        binding.tvCategoryContact.setText(position)
        UseridContactInfo=id
        binding.ivDropDownContact.visibility = View.VISIBLE
        binding.ivDropUpContact.visibility = View.GONE
        binding.rvCategoryContact.visibility = View.GONE
    }

    private fun create_referral(referralforid:String,contactPersonId:String){
        val request = ServiceBuilder.buildService(APIinterface::class.java)

        val sdf = SimpleDateFormat("dd MMM yyyy")
        val currentDate = sdf.format(Date())


        val sdf1 = SimpleDateFormat("hh:mm a")
        val currentDate1 = sdf1.format(Date())

        new1st=""
        new2st=""
        for (i in lstChk.indices) {
            new1st = lstChk.get(i).id
            new2st = new2st + "," + new1st
        }

        val call = request.app_create_referral(
            readUsingSharedPreference(this, "userid").toString(),
            binding.edtTitle.text.toString(),
            binding.edtFeedback.text.toString(),
            currentDate, currentDate1,
            FunctionalAreaId,
            binding.edtAddress.text.toString(),
            binding.edtname.text.toString(),
            binding.edtcomename.text.toString(),
            binding.edtdesignation.text.toString(),
            binding.edtMobileNumber.text.toString(),
            binding.edtStdCode.text.toString(),
            binding.edtLandlineNumber.text.toString(),
            binding.edtemailid.text.toString(),
            binding.wahtasap.text.toString(),
            CheckRadion,
            hotReferralRatio,
            new2st.replaceFirst(",", ""),
            contactPersonId,
            referralforid)
//        displayToast(this,readUsingSharedPreference(this, "userid").toString()+","+
//            binding.edtTitle.text.toString()+","+
//            binding.edtFeedback.text.toString()+","+
//            currentDate+","+ currentDate1+","+
//            FunctionalAreaId+","+
//            binding.edtAddress.text.toString()+","+
//            binding.edtname.text.toString()+","+
//            binding.edtcomename.text.toString()+","+
//            binding.edtdesignation.text.toString()+","+
//            binding.edtMobileNumber.text.toString()+","+
//            binding.edtStdCode.text.toString()+","+
//            binding.edtLandlineNumber.text.toString()+","+
//            binding.edtemailid.text.toString()+","+
//            binding.wahtasap.text.toString()+","+
//            CheckRadion+","+
//            hotReferralRatio+","+
//            new2st.replaceFirst(",", "")+","+
//            contactPersonId+","+
//            contactPersonId)
        call.enqueue(object : Callback<CreateRequirement> {
            override fun onResponse(
                call: Call<CreateRequirement>,
                response: Response<CreateRequirement>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.user_data?.size != 0) {
                                 startActivity(Intent(this@CreateReferralActivity, MainActivity::class.java))
                                 displayToast(this@CreateReferralActivity, response.body()?.message.toString())
                        }
                    } else {
                        displayToast(this@CreateReferralActivity, response.body()?.error.toString())
                    }

                }
            }

            override fun onFailure(call: Call<CreateRequirement>, t: Throwable) {
                dismissLoader()

            }
        })
    }

    fun validation() : Boolean {

        var Temp: Boolean?= true
        if (binding.edtTitle.text.toString().length == 0) {
            binding.edtTitle.setError("Field is empty")
            Temp = false
        } else {
            binding.edtTitle.setError(null)
        }

        if (binding.edtFeedback.text.toString().length == 0) {
            binding.edtFeedback.setError("Field is empty")
            Temp = false
        } else {
            binding.edtFeedback.setError(null)
        }

        if (binding.tvCategoryReferralFor.text.toString().length == 0) {
            binding.tvCategoryReferralFor.setError("Field is empty")
            Temp = false
        } else {
            binding.tvCategoryReferralFor.setError(null)
        }
        if (CheckRadion.equals("2")){
            if (binding.tvCategoryContact.text.toString().length == 0) {
                binding.tvCategoryContact.setError("Field is empty")
                Temp = false
            } else {
                binding.tvCategoryContact.setError(null)
            }
        }
        if(CheckRadion.equals("3")) {

            if (binding.edtname.text.toString().length == 0) {
                binding.edtname.setError("Field is empty")
                Temp = false
            } else {
                binding.edtname.setError(null)
            }

            if (binding.edtMobileNumber.text.toString().length == 0 && binding.edtLandlineNumber.text.toString().length == 0){
                binding.edtMobileNumber.setError("Field is empty")
                binding.edtLandlineNumber.setError("Field is empty")
                Temp = false
            }else{
                binding.edtMobileNumber.setError(null)
                binding.edtLandlineNumber.setError(null)
            }
//            if (binding.edtMobileNumber.text.toString().length == 0) {
//                binding.edtMobileNumber.setError("Field is empty")
//                Temp = false
//
//            } else {
//                binding.edtMobileNumber.setError(null)
//
//            }


//            if (binding.edtLandlineNumber.text.toString().length == 0) {
//                binding.edtLandlineNumber.setError("Field is empty")
//                Temp = false
//            } else {
//                binding.edtLandlineNumber.setError(null)
//            }
        }

        return Temp!!
    }

    fun validationText() : Boolean {

        var Temp: Boolean?= true
        if (binding.edtTitle.text.toString().length == 0) {
            Temp = false
        } else {

        }

        if (binding.edtFeedback.text.toString().length == 0) {
            Temp = false
        } else {

        }

        if (CheckRadion.equals("2")){
            if (binding.tvCategoryContact.text.toString().length == 0) {
                Temp = false
            } else {

            }
        }

        if(CheckRadion.equals("3")) {
            if (binding.edtname.text.toString().length == 0) {
                Temp = false
            } else {

            }

            if (binding.edtMobileNumber.text.toString().length == 0 && binding.edtLandlineNumber.text.toString().length == 0){
                Temp = false
            }else{

            }
        }

        return Temp!!
    }

}