package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model

import com.google.gson.annotations.SerializedName

data class ConnectionAccept (
    @SerializedName("status")
    var status: Boolean,
    @SerializedName("msg")
    val message: String,
    @SerializedName("data")
    val user_data: Userdata
)

data class Userdata(
        @SerializedName("receiverid")
        val userid: String,
        @SerializedName("senderid")
        val receiverid: String,
        @SerializedName("status")
        val status: Int
)
