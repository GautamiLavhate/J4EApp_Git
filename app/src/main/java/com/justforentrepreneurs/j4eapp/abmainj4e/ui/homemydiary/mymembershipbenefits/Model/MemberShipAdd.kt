package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model

import com.google.gson.annotations.SerializedName

data class MemberShipAdd(
        @SerializedName("status")
        var status: Boolean,
        @SerializedName("message")
        var message:String,
        @SerializedName("user_data")
        var user_data:UserdataMember
)

data class UserdataMember(
        @SerializedName("userid")
        var userid:String,
        @SerializedName("first_name")
        var first_name:String,
        @SerializedName("middle_name")
        var middle_name:String,
        @SerializedName("last_name")
        var last_name:String,
        @SerializedName("email")
        var email:String,
        @SerializedName("mobile")
        var mobile:String,
        @SerializedName("designation")
        var designation:String,
        @SerializedName("company_name")
        var company_name:String,
        @SerializedName("company_phone")
        var company_phone:String,
        @SerializedName("company_address")
        var company_address:String,
        @SerializedName("referral_code")
        var referral_code:String
)
