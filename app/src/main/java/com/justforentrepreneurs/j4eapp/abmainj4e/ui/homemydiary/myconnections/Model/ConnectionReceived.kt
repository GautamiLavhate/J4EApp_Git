package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model

import com.google.gson.annotations.SerializedName

data class ConnectionReceived (
        @SerializedName("status")
        var status: Boolean,
        @SerializedName("msg")
        val message: String,
        @SerializedName("data")
        val data: List<DataReceived>,
        @SerializedName("count_available")
        val count_available: Int
)

data class DataReceived(
        @SerializedName("userid")
        val userid: String,
        @SerializedName("full_name")
        val full_name: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("mobile")
        val mobile: String,
        @SerializedName("designation")
        val designation: String,
        @SerializedName("company_name")
        val company_name: String,
        @SerializedName("company_phone")
        val company_phone: String,
        @SerializedName("company_address")
        val company_address: String,
        @SerializedName("dob")
        val dob: String,
        @SerializedName("profile_pic")
        val profile_pic: String,
        @SerializedName("connection_status")
        val connection_status: String,
        @SerializedName("is_viewed")
        val is_viewed: Int
)
