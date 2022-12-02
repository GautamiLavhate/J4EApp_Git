package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mylead.model

import com.google.gson.annotations.SerializedName

data class MyLeadcomplete (
        @SerializedName("status")
        var status: Boolean,
        @SerializedName("msg")
        val message: String,
        @SerializedName("data")
        val user_data: List<MyRequirementpending>,
        @SerializedName("count_available")
        val count_available: Int
) {

    data class MyRequirementpending(
            @SerializedName("id")
            val id: String,
            @SerializedName("user_id")
            val user_id: String,
            @SerializedName("user_name")
            val user_name: String,
            @SerializedName("user_profile")
            val user_profile: String,
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
            val doe: String,
            @SerializedName("icon")
            val icon: String,
            @SerializedName("is_viewed")
            val is_viewed: Int,
            @SerializedName("is_user_viewed")
            val is_user_viewed: Int
    )

}
