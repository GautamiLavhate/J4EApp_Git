package com.justforentrepreneurs.j4eapp.abmainj4e.utils

import android.app.Activity
import android.content.Context

interface AnalyticsLogger {
    fun init(context: Context)
    fun loginUser(userData: Map<String, Any>)
    fun logoutUser()
    fun logEvent(eventName: String, params: Map<String, Any>)
    fun setCurrentScreen(activity: Activity, screenName: String)
}