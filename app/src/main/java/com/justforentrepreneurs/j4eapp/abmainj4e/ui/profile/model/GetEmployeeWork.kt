package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model

import com.google.gson.annotations.SerializedName

data class GetEmployeeWork(  @SerializedName("status")
                            var status: Boolean,
                            @SerializedName("msg")
                            val message: String,
                            @SerializedName("data")
                            val data: List<EmployeeWork>) {

    data class EmployeeWork(
        @SerializedName("id")
        val id: String,
        @SerializedName("title")
        val title: String
    )
}