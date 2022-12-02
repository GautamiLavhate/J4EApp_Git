package com.justforentrepreneurs.j4eapp.abmainj4e.network.model

import com.google.gson.annotations.SerializedName

data class AppUserAccDetailModel(
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("msg")
    val message: String,
    @SerializedName("data")
    val messageData: MessageData
) {
    data class MessageData(

        @SerializedName("userid")
        val userId: String,
        @SerializedName("first_name")
        val first_name: String,
        @SerializedName("middle_name")
        val middle_name: String,
        @SerializedName("last_name")
        val last_name: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("mobile")
        val mobile: String,
        @SerializedName("designation")
        val designation: String,
        @SerializedName("company_name")
        val companyName: String,
        @SerializedName("company_phone")
        val companyPhone: String,
        @SerializedName("company_address")
        val companyAddress: String,
        @SerializedName("dob")
        val dob: String,
        @SerializedName("profile_pic")
        val profilePic: String,
        @SerializedName("referral_code")
        val referralCode: String,
        @SerializedName("business_type")
        val business_type: String,
        @SerializedName("business_category_name")
        val business_category: String,
        @SerializedName("business_entity")
        val business_entity: String,
        @SerializedName("total_experience")
        val total_experience: String,
        @SerializedName("account_create")
        val account_create: String,
        @SerializedName("reward_point")
        val reward_point: String,
        @SerializedName("rank")
        val rank: String,
        @SerializedName("badge")
        val badge: String,
        @SerializedName("connection")
        val connection: String,
        @SerializedName("chat_id")
        val chat_id: String,
        @SerializedName("badge_title")
        val badge_title: String,
        @SerializedName("badge_image")
        val badge_image: String,
        @SerializedName("membership_type")
        val membership_type: String,
        @SerializedName("share_url")
        val share_url: String,
        @SerializedName("whatsapp_no")
        val whatsapp_no:String,
        @SerializedName("company_whatsapp_no")
        val company_whatsapp_no:String

    )
}