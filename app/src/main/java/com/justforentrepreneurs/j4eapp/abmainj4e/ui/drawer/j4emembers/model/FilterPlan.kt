package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model

import com.google.gson.annotations.SerializedName

class FilterPlan (
        @SerializedName("status")
        val status: Boolean,
        @SerializedName("msg")
        val message: String,
        @SerializedName("data")
        val data: List<DataFilter>
){
    class DataFilter (
            @SerializedName("membership_id")
            val membership_id: String,
            @SerializedName("membership_title")
            val membership_title: String,
            var isSelected :Boolean)
}
