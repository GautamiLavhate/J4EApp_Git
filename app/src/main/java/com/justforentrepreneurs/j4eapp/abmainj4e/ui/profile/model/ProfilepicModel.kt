package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model

import com.google.gson.annotations.SerializedName

data class ProfilepicModel(
        @SerializedName("status")
        var status: Boolean,
        @SerializedName("message")
        val message: String,
        @SerializedName("profile_pic")
        val profile_pic: String
)