package com.justforentrepreneurs.j4eapp.abmainj4e.ui.splash

import android.Manifest
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.Window
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivityOP
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.welcome.WelcomeActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.displayToast
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.readUsingSharedPreference
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.storeUsingSharedPreference
import com.justforentrepreneurs.j4eapp.databinding.ActivitySplashJ4eBinding
import com.justforentrepreneurs.j4eapp.databinding.SplashPermissiondialogBinding
import kotlinx.coroutines.*

class SplashActivityJ4E : BaseActivityOP() {
    private lateinit var binding:ActivitySplashJ4eBinding
    var uri: Uri? = null

    var param: String? = null
    var find: String="no"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_splash_j4e)
        Glide.with(this)
            .load(R.drawable.splash_screen_bg_new)
            .into(binding.ivSplashScreen)

        uri = intent.data

        if(checkPermissions()) {
            CoroutineScope(Dispatchers.IO).launch {
                delay(2500)
                withContext(Dispatchers.Main) {
                    checkAuth()
                }
            }
        }

        if (uri != null) {

            val strUri:String = uri.toString()
            val mString = strUri!!.split("?id=").toTypedArray()

            param = mString[1]

            find="yes"

            //displayToast(this,""+mString[1])
        }else{
            find="no"
        }
    }

    private fun checkAuth() {
        if (readUsingSharedPreference(this@SplashActivityJ4E, "loginStatus").toString().equals("true")) {
            if (find.equals("yes")){
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("id",param)
                intent.putExtra("type", "J4EMemberDetails")
                intent.putExtra("position","0")
                startActivity(intent)
            }else{
                storeUsingSharedPreference(this,"showupdate","yes")
                startActivity(Intent(this@SplashActivityJ4E, MainActivity::class.java))
            }

        } else {
            startActivity(Intent(this@SplashActivityJ4E, WelcomeActivity::class.java))
        }
        finish()
    }

    fun checkPermissions(): Boolean {
        var result: Int
        val listPermissionsNeeded: MutableList<String> = ArrayList()
        for (p in PermissionsUtil.permissions()) {
            result = ContextCompat.checkSelfPermission(this, p)
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p)
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, PermissionsUtil.permissions(), PERMISSION_REQUEST_CODE)
            return false
        }
        return true
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (PermissionsUtil.permissionsGranted(grantResults)) {
//            CoroutineScope(Dispatchers.IO).launch {
//                delay(2500)
//                withContext(Dispatchers.Main) {
//
//                    checkAuth()
//                }
//            }
//        } else {
//            showAlertDialog()
//        }
        if (grantResults.size > 0) {
            if (requestCode == PERMISSION_REQUEST_CODE) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission granted

                } else {
                    // permission denied
                    checkUserRequestedDontAskAgain()
                }
            }

            CoroutineScope(Dispatchers.IO).launch {
                delay(2500)
                withContext(Dispatchers.Main) {

                    checkAuth()
                }
            }
        }

    }


    private val PERMISSION_REQUEST_CODE = 159

    private fun requestPermissions() {

        ActivityCompat.requestPermissions(this, PermissionsUtil.permissions(), PERMISSION_REQUEST_CODE)
    }

    private fun showAlertDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mBsRecommendPersonListBinding: SplashPermissiondialogBinding =
            DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.splash_permissiondialog, null, false)
        dialog.setContentView(mBsRecommendPersonListBinding.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        mBsRecommendPersonListBinding.goseeting.setOnClickListener {
            val gallery = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.fromParts("package", getPackageName(), null))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(gallery)

        }

        mBsRecommendPersonListBinding.okbtd.setOnClickListener { finish()
            dialog.dismiss()}

        mBsRecommendPersonListBinding.noclosetheapp.setOnClickListener {
            requestPermissions()
        }


        dialog.show()
    }



    private fun checkUserRequestedDontAskAgain() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val rationalFalgREAD =
                shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            val rationalFalgWRITE =
                shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)
            if (!rationalFalgREAD && !rationalFalgWRITE) {
                showAlertDialog()
            }
        }
    }
}