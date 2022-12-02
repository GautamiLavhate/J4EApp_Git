package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model

import com.google.gson.annotations.SerializedName

data class ConnectionDecline(
    @SerializedName("status")
    var status: Boolean,
    @SerializedName("msg")
    val message: String
)