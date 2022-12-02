package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model

import com.google.gson.annotations.SerializedName

data class CreateRequirement(
        @SerializedName("status")
        var status: Boolean,
        @SerializedName("message")
        val message: String,
        @SerializedName("user_data")
        val user_data: List<Userdata>,
        @SerializedName("error")
        val error: String,
)
data class Userdata(
        @SerializedName("id")
        var id: Boolean,
        @SerializedName("user_id")
        val user_id: String,
        @SerializedName("functional_area_id")
        val functional_area_id: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("description")
        val description: String,
        @SerializedName("address")
        val address: String,
        @SerializedName("created_date")
        val created_date: String,
        @SerializedName("created_time")
        val created_time: String
)