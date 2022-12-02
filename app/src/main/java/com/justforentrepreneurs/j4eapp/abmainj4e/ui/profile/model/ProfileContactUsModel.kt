package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model

import com.google.gson.annotations.SerializedName

data class ProfileContactUsModel(
    @SerializedName("status")
    var status: Boolean,
    @SerializedName("msg")
    val message: String,
    @SerializedName("data")
    var data: Message2
)

data class Message2(
    @SerializedName("email")
    val email: String,
    @SerializedName("mobile")
    val mobile: String,
    @SerializedName("company_name")
    val company_name: String,
    @SerializedName("designation")
    val designation: String,
    @SerializedName("total_experience")
    val total_experience: String,
    @SerializedName("business_category_name")
    val business_category: String,
    @SerializedName("business_category_id")
    val business_category_id: String,
    @SerializedName("website")
    val website: String,
    @SerializedName("company_address")
    val company_address: String,
    @SerializedName("countryid")
    val countryid: String,
    @SerializedName("stateid")
    val stateid: String,
    @SerializedName("cityid")
    val cityid: String,
    @SerializedName("pin_code")
    val pin_code: String,
    @SerializedName("established_on")
    val established_on: String,
    @SerializedName("vcard_front")
    val vcard_front: String,
    @SerializedName("vcard_back")
    val vcard_back: String,
    @SerializedName("company_facebook")
    val company_facebook: String,
    @SerializedName("company_linkedin")
    val company_linkedin: String,
    @SerializedName("company_instagram")
    val company_instagram: String,
    @SerializedName("company_twitter")
    val company_twitter: String,
    @SerializedName("company_youtube")
    val company_youtube: String,
    @SerializedName("company_skype")
    val company_skype: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("company_google")
    val company_google: String,
    @SerializedName("date_of_birth")
    val date_of_birth: String,
    @SerializedName("whatsapp_no")
    val whatsapp_no: String,
    @SerializedName("company_whatsapp_no")
    val company_whatsapp_no:String
)
