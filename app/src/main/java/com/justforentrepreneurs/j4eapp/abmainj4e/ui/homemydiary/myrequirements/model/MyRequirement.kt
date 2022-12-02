package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrequirements.model

import com.google.gson.annotations.SerializedName

data class MyRequirement (
    @SerializedName("status")
    var status: Boolean,
    @SerializedName("msg")
    val message: String,
    @SerializedName("data")
    val user_data: List<MyRequirementpending>
)

data class MyRequirementpending(
        @SerializedName("id")
        val id: String,
        @SerializedName("user_id")
        val user_id: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("description")
        val description: String,
        @SerializedName("thumbnil")
        val thumbnil: String,
        @SerializedName("created_date")
        val created_date: String,
        @SerializedName("created_time")
        val created_time: String,
        @SerializedName("status")
        val status: String,
        @SerializedName("doe")
        val doe: String
)
