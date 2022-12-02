package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.recommended.model

import com.google.gson.annotations.SerializedName

data class RecommandByTo (
        @SerializedName("status")
        var status: Boolean,
        @SerializedName("msg")
        val message: String,
        @SerializedName("data")
        val data: List<RecommandBydata>,
        @SerializedName("count_available")
        val count_available: Int){

data class RecommandBydata(
        @SerializedName("userid")
        val userid: String,
        @SerializedName("requirement_id")
        val requirement_id: String,
        @SerializedName("requirement_title")
        val requirement_title: String,
        @SerializedName("requirement_description")
        val requirement_description: String,
        @SerializedName("rerquirement_thumbnail")
        val thumbnil: String,
        @SerializedName("created_date")
        val created_date: String,
        @SerializedName("created_time")
        val created_time: String,
        @SerializedName("full_name")
        val full_name: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("mobile")
        val mobile: String,
        @SerializedName("designation")
        val designation: String,
        @SerializedName("count")
        val count: String,
        @SerializedName("company_name")
        val company_name: String,
        @SerializedName("company_phone")
        val company_phone: String,
        @SerializedName("profile_pic")
        val profile_pic: String,
        @SerializedName("is_viewed")
        val is_viewed: Int)
}