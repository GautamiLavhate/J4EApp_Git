package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model

import com.google.gson.annotations.SerializedName

data class EventInvite(  @SerializedName("status")
                         var status: Boolean,
                         @SerializedName("message")
                         var message:String,
                         @SerializedName("data")
                         var data:EventData){
    data class EventData(
        @SerializedName("verification_need")
        var verification_need:String,
        @SerializedName("Free_allowed")
        var Free_allowed:String,
        @SerializedName("registered")
        var registered:String
    )
}
