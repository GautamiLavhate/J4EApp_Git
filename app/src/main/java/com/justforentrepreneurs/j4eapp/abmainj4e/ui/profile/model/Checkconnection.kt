package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model

import com.google.gson.annotations.SerializedName

data class Checkconnection(
    @SerializedName("status")
    var status: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: Boolean
)
