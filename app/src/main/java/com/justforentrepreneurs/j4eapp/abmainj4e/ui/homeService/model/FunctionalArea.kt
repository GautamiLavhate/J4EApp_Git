package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model

import com.google.gson.annotations.SerializedName

data class FunctionalArea(  @SerializedName("status")
                            var status: Boolean,
                            @SerializedName("msg")
                            val message: String,
                            @SerializedName("data")
                            val data: List<FunctionalData>)

data class FunctionalData( @SerializedName("area_id")
                           val area_id: String,
                           @SerializedName("area")
                           val area: String )

