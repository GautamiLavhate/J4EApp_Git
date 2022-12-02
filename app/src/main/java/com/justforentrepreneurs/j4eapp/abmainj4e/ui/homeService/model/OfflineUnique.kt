package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model

import com.google.gson.annotations.SerializedName

data class OfflineUnique(@SerializedName("status")
                    var status: Boolean,
                    @SerializedName("msg")
                    val message: String,
                    @SerializedName("data")
                         val data: String)