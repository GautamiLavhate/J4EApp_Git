package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.setting

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.databinding.ActivitySettingBinding
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.login.LoginActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
import com.justforentrepreneurs.j4eapp.databinding.ImagedeleteDialogBinding
//import com.justforentrepreneurs.j4eapp.utils.RealmHelper
//import com.justforentrepreneurs.j4eapp.utils.SharedPreferencesManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class SettingActivity : BaseActivity() {

    private lateinit var binding: ActivitySettingBinding

    override fun enablePresence(): Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting)
        binding.lifecycleOwner = this
        binding.toolbar.tvTitle.text = resources.getText(R.string.settings)
    }

    fun onDeleteAccClick(view: View) {
        val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
        val mBsRecommendPersonListBinding: ImagedeleteDialogBinding =
            DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.imagedelete_dialog, null, false)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(mBsRecommendPersonListBinding.root)

        mBsRecommendPersonListBinding.deletetv.setText("Are you sure you want to delete your account?")

        mBsRecommendPersonListBinding.proceed.setText("Delete Account")

        mBsRecommendPersonListBinding.cancle.setOnClickListener {
            dialog.dismiss()

        }

        mBsRecommendPersonListBinding.proceed.setOnClickListener {
            dialog.dismiss()
            onDeleteDialog()
        }
        dialog.show()

    }

    fun onDeleteDialog(){
        if (isInternetAvailable(this)) {
            val request = ServiceBuilder.buildService(APIinterface::class.java)

            val call = request.app_delete_account(readUsingSharedPreference(this, "userid").toString())
            showLoaderf(this)
            call.enqueue(object : Callback<ConnectionDecline> {
                override fun onResponse(
                    call: Call<ConnectionDecline>,
                    response: Response<ConnectionDecline>
                ) {
                    dismissLoader();
                    if (response.isSuccessful) {
                        if (response.body()?.status == true) {
                            displayToast(this@SettingActivity, response.body()?.message.toString())
                            if(readUsingSharedPreference(this@SettingActivity, "signup_source").toString()=="api") {
                                cleareUsingSharedPreference(this@SettingActivity)
                                startActivity(Intent(this@SettingActivity, LoginActivity::class.java))
                                finish()
                                dismissLoader()
                            }else if(readUsingSharedPreference(this@SettingActivity, "signup_source").toString()=="google"){
                                googleSignOut()
                                cleareUsingSharedPreference(this@SettingActivity)
                                startActivity(Intent(this@SettingActivity, LoginActivity::class.java))
                                finish()
                                dismissLoader()
                            }else if(readUsingSharedPreference(this@SettingActivity, "signup_source").toString()=="facebook"){
                                facebookSignOut()
                                cleareUsingSharedPreference(this@SettingActivity)
                                startActivity(Intent(this@SettingActivity, LoginActivity::class.java))
                                finish()
                                dismissLoader()
                            }else if(readUsingSharedPreference(this@SettingActivity, "signup_source").toString()=="linkdin"){
                                // linkedinSignOut()
                                cleareUsingSharedPreference(this@SettingActivity)
                                startActivity(Intent(this@SettingActivity, LoginActivity::class.java))
                                finish()
                                dismissLoader()
                            }else{
                                cleareUsingSharedPreference(this@SettingActivity)
                                startActivity(Intent(this@SettingActivity, LoginActivity::class.java))
                                finish()
                                dismissLoader()
                            }

                            val sharedPreferences: SharedPreferences =getSharedPreferences("FragAllBuddiesBinding", Context.MODE_PRIVATE)
                            val editor = sharedPreferences.edit()
                            editor.clear()
                            editor.apply()

                            val sharedPreferences1: SharedPreferences =getSharedPreferences("J4EMembersActivity", Context.MODE_PRIVATE)
                            val editor1 = sharedPreferences1.edit()
                            editor1.clear()
                            editor1.apply()

                            val sharedPreferences2: SharedPreferences =getSharedPreferences("AllEventsFragment", Context.MODE_PRIVATE)
                            val editor2 = sharedPreferences2.edit()
                            editor2.clear()
                            editor2.apply()

                            val sharedPreferences3: SharedPreferences =getSharedPreferences("MyBusniessActivity", Context.MODE_PRIVATE)
                            val editor3 = sharedPreferences3.edit()
                            editor3.clear()
                            editor3.apply()


                            val sharedPreferences4: SharedPreferences =getSharedPreferences("MyBuddiesActivity", Context.MODE_PRIVATE)
                            val editor4 = sharedPreferences4.edit()
                            editor4.clear()
                            editor4.apply()


//                            SharedPreferencesManager.setUserInfoSaved(false)
//                            SharedPreferencesManager.setTokenSaved(false)
//                            SharedPreferencesManager.setContactSynced(false)
//                            RealmHelper.getInstance().deleteRealm()

                        }
                    }
                }

                override fun onFailure(call: Call<ConnectionDecline>, t: Throwable) {
                    dismissLoader()
                }
            })
        }
    }

    fun onLogoutClick(view: View) {
        if(readUsingSharedPreference(this, "signup_source").toString()=="api") {
            showLoader(this)
            cleareUsingSharedPreference(this)
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            dismissLoader()
        }else if(readUsingSharedPreference(this, "signup_source").toString()=="google"){
            googleSignOut()
            showLoader(this)
            cleareUsingSharedPreference(this)
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            dismissLoader()
        }else if(readUsingSharedPreference(this, "signup_source").toString()=="facebook"){
            facebookSignOut()
            showLoader(this)
            cleareUsingSharedPreference(this)
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            dismissLoader()
        }else if(readUsingSharedPreference(this, "signup_source").toString()=="linkdin"){
           // linkedinSignOut()
            showLoader(this)
            cleareUsingSharedPreference(this)
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            dismissLoader()
        }else{
            showLoader(this)
            cleareUsingSharedPreference(this)
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            dismissLoader()
        }

        val sharedPreferences: SharedPreferences =getSharedPreferences("FragAllBuddiesBinding", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()

        val sharedPreferences1: SharedPreferences =getSharedPreferences("J4EMembersActivity", Context.MODE_PRIVATE)
        val editor1 = sharedPreferences1.edit()
        editor1.clear()
        editor1.apply()

        val sharedPreferences2: SharedPreferences =getSharedPreferences("AllEventsFragment", Context.MODE_PRIVATE)
        val editor2 = sharedPreferences2.edit()
        editor2.clear()
        editor2.apply()

        val sharedPreferences3: SharedPreferences =getSharedPreferences("MyBusniessActivity", Context.MODE_PRIVATE)
        val editor3 = sharedPreferences3.edit()
        editor3.clear()
        editor3.apply()

        val sharedPreferences4: SharedPreferences =getSharedPreferences("MyBuddiesActivity", Context.MODE_PRIVATE)
        val editor4 = sharedPreferences4.edit()
        editor4.clear()
        editor4.apply()


//        SharedPreferencesManager.setUserInfoSaved(false)
//        SharedPreferencesManager.setTokenSaved(false)
//        SharedPreferencesManager.setContactSynced(false)
//        RealmHelper.getInstance().deleteRealm()


    }

}