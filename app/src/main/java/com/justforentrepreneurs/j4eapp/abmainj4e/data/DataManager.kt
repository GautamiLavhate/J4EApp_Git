package com.justforentrepreneurs.j4eapp.abmainj4e.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.justforentrepreneurs.j4eapp.abmainj4e.network.model.LoginRegisterModel
import com.google.gson.Gson

class DataManager(context: Context) {

    private val sharedPref: SharedPreferences = context.getSharedPreferences("AppPref", MODE_PRIVATE)
    private val editor: SharedPreferences.Editor

    init {
        editor = sharedPref.edit()
    }

    fun setIsLogin(isLogin: Boolean) {
        editor.putBoolean("pref_isLogin", isLogin).apply()
    }

    fun isLogin(): Boolean {
        return sharedPref.getBoolean("pref_isLogin", false)
    }

    fun setIsSocialLogin(isSocialLogin: Boolean) {
        editor.putBoolean("pref_isSocialLogin", isSocialLogin).apply()
    }

    fun isSocialLogin(): Boolean {
        return sharedPref.getBoolean("pref_isSocialLogin", false)
    }

    fun setUserData(response: LoginRegisterModel) {
        setIsLogin(true)
        if (response != null) {
            editor.putString("pref_loginData", Gson().toJson(response)).apply()
        }
    }

    fun getUserData(): LoginRegisterModel {
        return Gson().fromJson(sharedPref.getString("pref_loginData", ""), LoginRegisterModel::class.java)!!
    }

    fun clearData(){
        editor.clear();
        editor.commit();
    }

}