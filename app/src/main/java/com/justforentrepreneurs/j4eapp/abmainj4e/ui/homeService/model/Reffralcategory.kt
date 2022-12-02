package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model

import com.google.gson.annotations.SerializedName

data class Reffralcategory(@SerializedName("status")
                           var status: Boolean,
                           @SerializedName("msg")
                           val message: String,
                           @SerializedName("data")
                           val data: List<ReffralcategoryData>) {

    data class ReffralcategoryData(
        @SerializedName("id")
        val id: String,
        @SerializedName("title")
        val title: String,
        var isSelected :Boolean
    )
}
