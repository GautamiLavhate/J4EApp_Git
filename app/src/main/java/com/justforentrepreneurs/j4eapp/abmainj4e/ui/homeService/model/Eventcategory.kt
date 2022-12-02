package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model

import com.google.gson.annotations.SerializedName


data class Eventcategory(@SerializedName("status")
                         var status: Boolean,
                         @SerializedName("msg")
                         val message: String,
                         @SerializedName("data")
                         val data: List<Eventdata>) {

    data class Eventdata(
            @SerializedName("event_cat_id")
            val cat_id: String,
            @SerializedName("event_cat_name")
            val cat_name: String,
            var isSelected :Boolean
    )
}
