package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model

import com.google.gson.annotations.SerializedName

data class PlanValidity(
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("message")
    val messageData: MessageData
) {
    data class MessageData(
        @SerializedName("userid")
        val userId: String,
        @SerializedName("mobile")
        val mobile: String,
        @SerializedName("otp")
        val otp: Int,
        @SerializedName("login_type")
        val type: String,
        @SerializedName("message")
        val message: String,
        @SerializedName("result")
        val result: Boolean
    )
}
