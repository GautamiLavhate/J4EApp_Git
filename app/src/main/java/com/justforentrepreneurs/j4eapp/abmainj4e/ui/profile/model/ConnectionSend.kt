package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model

import com.google.gson.annotations.SerializedName

data class ConnectionSend (
    @SerializedName("status")
    var status: Boolean,
    @SerializedName("msg")
    val message: String,
    @SerializedName("data")
    val user_data: Userdata
)

data class Userdata(
        @SerializedName("userid")
        val userid: String,
        @SerializedName("receiverid")
        val receiverid: String
)
