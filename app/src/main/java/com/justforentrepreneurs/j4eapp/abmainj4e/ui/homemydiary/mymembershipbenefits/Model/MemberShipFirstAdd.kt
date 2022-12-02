package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model

import com.google.gson.annotations.SerializedName

data class MemberShipFirstAdd(
        @SerializedName("status")
        var status: Boolean,
        @SerializedName("msg")
        var message:String,
        @SerializedName("data")
        val data: List<Datauser>
)

data class Datauser(
        @SerializedName("userdata")
        var userdata:UserData
)


data class UserData(
        @SerializedName("id")
        var userid:String,
        @SerializedName("first_name")
        var first_name:String,
        @SerializedName("middle_name")
        var middle_name:String,
        @SerializedName("last_name")
        var last_name:String,
        @SerializedName("email_address")
        var email:String,
        @SerializedName("phone")
        var mobile:String,
        @SerializedName("designation")
        var designation:String,
        @SerializedName("company")
        var company_name:String,
        @SerializedName("company_contact")
        var company_phone:String,
        @SerializedName("company_address")
        var company_address:String,
        @SerializedName("referral_code")
        var referral_code:String,
        @SerializedName("firebase_uid")
        var chat_id:String,
        @SerializedName("membership_type")
        var membership_type:String
)
