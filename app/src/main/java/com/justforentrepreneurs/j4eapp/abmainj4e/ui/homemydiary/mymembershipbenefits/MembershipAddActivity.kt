package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.databinding.ActivityMembershipAddBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.network.model.AppUserAccDetailModel
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.MemberShipAdd
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.databinding.LayoutMembershipAddeditBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MembershipAddActivity : BaseActivity() {
    private lateinit var binding: LayoutMembershipAddeditBinding
    override fun enablePresence(): Boolean {
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.layout_membership_addedit)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.j4e_membership_card)
        binding.toolbar.tvEdit.text = "Save"

        binding.toolbar.ivBack.setOnClickListener {
           onBackPressed()
        }

        val anim: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        binding.layoutmanager1.startAnimation(anim)

        if (isInternetAvailable(this)) {
            getAppUserAccDetail();
        }

        binding.toolbar.tvEdit.setOnClickListener {
            if (validation()) {
                if (isInternetAvailable(this)) {
                    showLoader(this)
                    val request = ServiceBuilder.buildService(APIinterface::class.java)
                    val call = request.app_user_edit_membership_details(readUsingSharedPreference(this@MembershipAddActivity, "userid").toString(),
                        binding.edtname.text.toString(), binding.edtmiddle.text.toString(), binding.edtlast.text.toString(),
                        binding.email.text.toString(),
                            binding.mobilenumber.text.toString(), binding.designationprofession.text.toString(),
                        binding.companyOrganisation.text.toString(), binding.officephone.text.toString(),
                        binding.address.text.toString(), "",binding.edtWhatspp.text.toString(),"")
                    call.enqueue(object : Callback<MemberShipAdd> {
                        override fun onResponse(
                                call: Call<MemberShipAdd>,
                                response: Response<MemberShipAdd>) {
                            dismissLoader();
                            if (response.isSuccessful) {
                                if (response.body()?.status == true) {
                                   // getAppUserAccDetail();


                                    storeUsingSharedPreference(this@MembershipAddActivity, "mobile", response.body()?.user_data?.mobile)
                                    storeUsingSharedPreference(this@MembershipAddActivity, "companyphone", response.body()?.user_data?.company_phone)
                                    storeUsingSharedPreference(this@MembershipAddActivity, "company_name", response.body()?.user_data?.company_name.toString())
                                    storeUsingSharedPreference(this@MembershipAddActivity, "company_address", response.body()?.user_data?.company_address.toString())
                                    storeUsingSharedPreference(this@MembershipAddActivity, "designation", response.body()?.user_data?.designation.toString())

                                    storeUsingSharedPreference(this@MembershipAddActivity, "firstname", response.body()?.user_data?.first_name.toString())
                                    storeUsingSharedPreference(this@MembershipAddActivity, "meddlename", response.body()?.user_data?.middle_name.toString())
                                    storeUsingSharedPreference(this@MembershipAddActivity, "lastname", response.body()?.user_data?.last_name.toString())
                                    storeUsingSharedPreference(this@MembershipAddActivity, "fullname", response.body()?.user_data?.first_name.toString()+" "+ response.body()?.user_data?.middle_name.toString()+" "+response.body()?.user_data?.last_name.toString())


                                    displayToast(this@MembershipAddActivity, response.body()?.message.toString())
                                    startActivity(Intent(this@MembershipAddActivity, MyMembershipBenefitsActivity::class.java))

                                } else {
                                    displayToast(this@MembershipAddActivity, response.body()?.message.toString())
                                }
                            }
                        }

                        override fun onFailure(call: Call<MemberShipAdd>, t: Throwable) {
                            displayToast(this@MembershipAddActivity, this@MembershipAddActivity.resources.getString(R.string.error_something_wrong))
                        }
                    })
                }
            }


        }


        binding.mobilenumber.setTag( binding.mobilenumber.getKeyListener())
        binding.mobilenumber.keyListener=null

       /* binding.edtname.setTag( binding.edtname.getKeyListener())
        binding.edtname.keyListener=null


        binding.edtlast.setTag( binding.edtlast.getKeyListener())
        binding.edtlast.keyListener=null*/

//        binding.email.setTag( binding.email.getKeyListener())
//        binding.email.keyListener=null



    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MyMembershipBenefitsActivity::class.java))
    }

    fun validation() : Boolean {

        var Temp: Boolean? = true
        if (binding.edtname.text.toString().length == 0) {
            binding.edtname.setError("Field is empty")
            Temp = false
        } else {
            binding.edtname.setError(null)
        }

        if (binding.edtlast.text.toString().length == 0) {
            binding.edtlast.setError("Field is empty")
            Temp = false
        } else {
            binding.edtlast.setError(null)
        }

        if (binding.email.text.toString().length == 0) {
            binding.email.setError("Field is empty")
            Temp = false
        } else {
            binding.email.setError(null)
        }

//        if (binding.designationprofession.text.toString().length == 0) {
//            binding.designationprofession.setError("Field is empty")
//            Temp = false
//        } else {
//            binding.designationprofession.setError(null)
//        }
//
//        if (binding.companyOrganisation.text.toString().length == 0) {
//            binding.companyOrganisation.setError("Field is empty")
//            Temp = false
//        } else {
//            binding.companyOrganisation.setError(null)
//        }

        if (binding.mobilenumber.text.toString().length == 0) {
            binding.mobilenumber.setError("Field is empty")
            Temp = false
        } else {
            binding.mobilenumber.setError(null)
        }

        if (binding.edtWhatspp.text.toString().length == 0) {
            binding.edtWhatspp.setError("Field is empty")
            Temp = false
        } else {
            binding.edtWhatspp.setError(null)
        }
//        if (binding.edtWhatspp.text.toString().length == 0 && binding.edtWhatsppBusiness.text.toString().length == 0){
//            binding.edtWhatspp.setError("Field is empty")
//            binding.edtWhatsppBusiness.setError("Field is empty")
//            Temp = false
//        }else{
//            binding.edtWhatspp.setError(null)
//            binding.edtWhatsppBusiness.setError(null)
//        }
        val enailvalid:String=binding.email.text.toString()

        if (!Patterns.EMAIL_ADDRESS.matcher(enailvalid).matches()) {
            binding.email.setError("Invalid email")
            Temp = false
        } else {
            binding.email.setError(null)
        }

       /* if (binding.officephone.text.toString().length == 0) {
            binding.officephone.setError("Field is empty")
            Temp = false
        } else {
            binding.officephone.setError(null)
        }

        if (binding.address.text.toString().length == 0) {
            binding.address.setError("Field is empty")
            Temp = false
        } else {
            binding.address.setError(null)
        }*/


        return Temp!!
    }

    private fun getAppUserAccDetail() {

        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.getaccountdetals(readUsingSharedPreference(this@MembershipAddActivity, "userid").toString(),readUsingSharedPreference(this@MembershipAddActivity, "userid").toString())
        call.enqueue(object : Callback<AppUserAccDetailModel> {
            override fun onResponse(call: Call<AppUserAccDetailModel>, response: Response<AppUserAccDetailModel>) {
                dismissLoader();
                if (response.isSuccessful){
                    if (response.body()?.status==true) {
                        if (response.body()?.messageData != null) {

                            binding.layoutmanager1.visibility=View.GONE
                            binding.lay.visibility=View.VISIBLE

                            if(!response.body()?.messageData?.companyAddress.equals("null")){
                                binding.address.setText(response.body()?.messageData?.companyAddress)
                            }

                            if(!response.body()?.messageData?.email.equals("null")){
                                binding.email.setText(response.body()?.messageData?.email)
                            }

                            if(!response.body()?.messageData?.designation.equals("null")){
                                binding.designationprofession.setText(response.body()?.messageData?.designation)
                            }

                            if(!response.body()?.messageData?.companyName.equals("null")){
                                binding.companyOrganisation.setText(response.body()?.messageData?.companyName)
                            }

                            if(!response.body()?.messageData?.mobile.equals("null")){
                                binding.mobilenumber.setText(response.body()?.messageData?.mobile)
                            }

                            if(!response.body()?.messageData?.companyPhone.equals("null")){
                                binding.officephone.setText(response.body()?.messageData?.companyPhone)
                            }

                            if(!response.body()?.messageData?.first_name.equals("null")){
                                binding.edtname.setText(response.body()?.messageData?.first_name)
                            }
                            if(!response.body()?.messageData?.middle_name.equals("null")){
                                binding.edtmiddle.setText(response.body()?.messageData?.middle_name)
                            }

                            if(!response.body()?.messageData?.last_name.equals("null")){
                                binding.edtlast.setText(response.body()?.messageData?.last_name)
                            }

                            if (response.body()?.messageData?.whatsapp_no != null){
                                binding.edtWhatspp.setText(response.body()?.messageData?.whatsapp_no)
                            }

//                            if (response.body()?.messageData?.company_whatsapp_no != null){
//                                binding.edtWhatsppBusiness.setText(response.body()?.messageData?.company_whatsapp_no)
//                            }

                            storeUsingSharedPreference(this@MembershipAddActivity, "dob", response.body()?.messageData?.dob)
                            storeUsingSharedPreference(this@MembershipAddActivity, "firstname", response.body()?.messageData?.first_name.toString())
                            storeUsingSharedPreference(this@MembershipAddActivity, "meddlename", response.body()?.messageData?.middle_name.toString())
                            storeUsingSharedPreference(this@MembershipAddActivity, "lastname", response.body()?.messageData?.last_name.toString())
                            storeUsingSharedPreference(this@MembershipAddActivity, "fullname", response.body()?.messageData?.first_name.toString()+" "+ response.body()?.messageData?.middle_name.toString()+" "+response.body()?.messageData?.last_name.toString())
                            storeUsingSharedPreference(this@MembershipAddActivity, "profilepic", response.body()?.messageData?.profilePic.toString())


                        }else{
                            binding.layoutmanager1.visibility=View.GONE
                            binding.lay.visibility=View.VISIBLE
                        }
                    }else{
                        binding.layoutmanager1.visibility=View.GONE
                        binding.lay.visibility=View.VISIBLE
                    }
                }
            }
            override fun onFailure(call: Call<AppUserAccDetailModel>, t: Throwable) {

            }
        })
    }

}