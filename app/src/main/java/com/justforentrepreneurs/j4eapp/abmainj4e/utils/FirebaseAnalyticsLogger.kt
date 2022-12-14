package com.justforentrepreneurs.j4eapp.abmainj4e.utils

import android.app.Activity
import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

object FirebaseAnalyticsLogger : AnalyticsLogger {

    private var firebaseAnalytics: FirebaseAnalytics? = null

    override fun init(context: Context) {
        firebaseAnalytics = FirebaseAnalytics.getInstance(context)
    }

    override fun loginUser(userData: Map<String, Any>) {
        firebaseAnalytics?.logEvent("Login", null)
        firebaseAnalytics?.setUserId("${userData["id"]}")
        firebaseAnalytics?.setUserProperty("email", "${userData["email"]}")
    }

    override fun logoutUser() {
        firebaseAnalytics?.logEvent("Logout", null)
        firebaseAnalytics?.setUserId(null)
        firebaseAnalytics?.setUserProperty("email", null)
    }

    override fun logEvent(eventName: String, params: Map<String, Any>) {
        val bundle = Bundle()
        params.forEach {
            bundle.putString(it.key, "${it.value}")
        }
        firebaseAnalytics?.logEvent(eventName, bundle)
    }

    override fun setCurrentScreen(activity: Activity, screenName: String) {
        firebaseAnalytics?.setCurrentScreen(activity, screenName, screenName)
    }
}

fun getAnalyticsLogger(): AnalyticsLogger = FirebaseAnalyticsLogger