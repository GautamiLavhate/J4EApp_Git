package com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model

import com.google.gson.annotations.SerializedName

data class BuddiesAll(
        @SerializedName("status")
        val status: Boolean,
        @SerializedName("msg")
        val message: String,
        @SerializedName("data")
        val data: List<AllBuddies>,
        @SerializedName("count_available")
        val count_available: Int
)

data class AllBuddies(
        @SerializedName("id")
        val id:String,
        @SerializedName("userid")
        val userid:String,
        @SerializedName("full_name")
        val full_name:String,
        @SerializedName("email")
        val email:String,
        @SerializedName("mobile")
        val mobile:String,
        @SerializedName("designation")
        val designation:String,
        @SerializedName("company_phone")
        val company_phone:String,
        @SerializedName("company_name")
        val company_name:String,
        @SerializedName("company_address")
        val company_address:String,
        @SerializedName("dob")
        val dob:String,
        @SerializedName("profile_pic")
        val profile_pic:String,
        var isSelected :Boolean,
        @SerializedName("chat_id")
        val chat_id:String,
        @SerializedName("membership_name")
        val membership_name:String,
        @SerializedName("membership_type")
        val membership_type:String,
        @SerializedName("is_viewed")
        val is_viewed:Int,
        @SerializedName("whatsapp_no")
        val whatsapp_no: String,
        @SerializedName("company_whatsapp_no")
        val company_whatsapp_no: String

)

