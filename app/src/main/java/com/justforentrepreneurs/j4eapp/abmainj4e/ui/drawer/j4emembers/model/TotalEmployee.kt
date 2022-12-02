package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model

import com.google.gson.annotations.SerializedName

data class  TotalEmployee(
        @SerializedName("status")
        val status: Boolean,
        @SerializedName("msg")
        val message: String,
        @SerializedName("data")
        val data:String
)
