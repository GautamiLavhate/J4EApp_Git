package com.justforentrepreneurs.j4eapp.abmainj4e.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.provider.Settings
import android.text.TextUtils
import android.util.Base64
import android.util.Log
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


object Utils {

    @SuppressLint("HardwareIds")
    fun getDeviceId(mContext: Context): String {
        return Settings.Secure.getString(mContext.contentResolver, Settings.Secure.ANDROID_ID)
    }

    fun singleImagePart(key: String, path: String): MultipartBody.Part? {
        var formData: MultipartBody.Part? = null
        if (!TextUtils.isEmpty(path)) {
            val file = File(path)
            val requestBody = MultipartBody.create(MediaType.parse("image/*"), file)
            formData = MultipartBody.Part.createFormData(key, file.name, requestBody)
        } else {
            val attachmentEmpty = RequestBody.create(MediaType.parse("text/plain"), "")
            formData = MultipartBody.Part.createFormData("attachment", "", attachmentEmpty)
        }
        return formData
    }

    fun printHashKey(pContext: Context) {
        try {
            val info =
                pContext.packageManager.getPackageInfo(pContext.packageName, PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                val md: MessageDigest = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                val hashKey: String = String(Base64.encode(md.digest(), 0))
                Log.i("TAG", "printHashKey() Hash Key: $hashKey")
            }
        } catch (e: NoSuchAlgorithmException) {
            Log.e("TAG", "printHashKey()", e)
        } catch (e: Exception) {
            Log.e("TAG", "printHashKey()", e)
        }
    }

}