package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model

import com.google.gson.annotations.SerializedName

data class GetTurnOver( @SerializedName("status")
                        var status: Boolean,
                        @SerializedName("msg")
                        val message: String,
                        @SerializedName("data")
                        val data: List<DataTurn>){

    data class DataTurn(@SerializedName("turn_over_id")
                         val turn_over_id: String,
                         @SerializedName("turn_over_value")
                         val turn_over_value: String)

}
