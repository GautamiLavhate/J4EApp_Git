package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model

import com.google.gson.annotations.SerializedName


data class GroupsList(@SerializedName("status")
                         var status: Boolean,
                      @SerializedName("error")
                         val error: String,
                      @SerializedName("data")
                         val data: List<GPdata>) {

    data class GPdata(
            @SerializedName("group_uid")
            val group_uid: String
    )
}
