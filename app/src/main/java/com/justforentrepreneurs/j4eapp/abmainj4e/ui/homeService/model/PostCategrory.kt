package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model

import com.google.gson.annotations.SerializedName

data class PostCategrory(@SerializedName("status")
                        var status: Boolean,
                        @SerializedName("msg")
                        val message: String,
                        @SerializedName("data")
                        val data: List<Postdata>) {

    data class Postdata(
        @SerializedName("cat_id")
        val cat_id: String,
        @SerializedName("cat_name")
        val cat_name: String,
        @SerializedName("cat_icon")
        val cat_icon: String,
        var isSelected :Boolean
    )
}
