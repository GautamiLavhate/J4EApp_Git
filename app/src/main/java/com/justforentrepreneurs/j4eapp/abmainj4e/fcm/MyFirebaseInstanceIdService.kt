package com.justforentrepreneurs.j4eapp.abmainj4e.fcm

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyFirebaseInstanceIdService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

}
