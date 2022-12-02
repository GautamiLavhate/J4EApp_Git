package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model

import com.google.gson.annotations.SerializedName

data class GallaryUpload(
        @SerializedName("status")
        var status: Boolean,
        @SerializedName("message")
        val message: List<MessageUplod>
)

data class MessageUplod(
        @SerializedName("status")
        var status: Boolean,
        @SerializedName("message")
        val message: String
)