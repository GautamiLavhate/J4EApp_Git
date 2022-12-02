package com.justforentrepreneurs.j4eapp.abmainj4e.utils

import android.content.Context
import android.content.SharedPreferences

class PrefManager(context: Context?) {
    var PRIVATE_MODE = 0
    private  val PREF_NAME = "J4EappV"
    private  val IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch"
    var _context: Context? = context
    var pref: SharedPreferences? =_context!!.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
    var editor: SharedPreferences.Editor? =  pref!!.edit()


    fun setFirstTimeLaunch(isFirstTime: Boolean) {
        editor!!.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime)
        editor!!.commit()
    }

    fun isFirstTimeLaunch(): Boolean {
        return pref!!.getBoolean(IS_FIRST_TIME_LAUNCH, true)
    }
}