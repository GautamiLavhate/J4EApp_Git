package com.justforentrepreneurs.j4eapp.abmainj4e.data

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.util.Base64
import android.view.inputmethod.InputMethodManager
import java.io.ByteArrayOutputStream

class StaticDataStore {
    var orderHistoryFlag = false

    // SharedPreference name used in Project
    var mypref = "J4E"
    var context1: Context? = null

    // Store data in Shared Preference
    fun storeUsingSharedPreference(context: Context, key: String?,
                                   value: String?) {
        context1 = context
        val editor = context.getSharedPreferences(mypref,
                Context.MODE_PRIVATE).edit()
        editor.putString(key, value)
        editor.commit()
    }

    // get data From Shared Preference
    fun readUsingSharedPreference(context: Context, key: String?): String? {
        val preference = context.getSharedPreferences(mypref,
                Context.MODE_PRIVATE)
        return preference.getString(key, "0")
    }

    // Delete all data from Shared Preference
    fun cleareUsingSharedPreference(context: Context) {
        val editor = context.getSharedPreferences(mypref,
                Context.MODE_PRIVATE).edit()
        editor.clear()
        editor.commit()
    }

    // Delete specific data from Shared Preference
    fun cleareUsingSharedPreferenceOne(context: Context,
                                       name: String?) {
        if (mypref.contains("mykey")) {
            val editor = context.getSharedPreferences(
                    mypref, Context.MODE_PRIVATE).edit()
            editor.remove("user_image")
            editor.commit()
        }
    }

    fun hideSoftKeybord(context: Context) {
        val view = (context as Activity).currentFocus
        if (view != null) {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun endcodeToBase64(image: Bitmap, compressFormat: CompressFormat?, quality: Int): String? {
        val byteArryOS = ByteArrayOutputStream()
        image.compress(compressFormat, quality, byteArryOS)
        return Base64.encodeToString(byteArryOS.toByteArray(), Base64.DEFAULT)
    }
}