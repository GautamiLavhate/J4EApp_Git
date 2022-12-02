package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model

import com.google.gson.annotations.SerializedName

data class MyLeadStatus(
        @SerializedName("status")
        val status: Boolean,
        @SerializedName("msg")
        val message:String,
        @SerializedName("data")
        val data:List<DataLeadSt>){
    data class DataLeadSt( @SerializedName("status_name")
                           val status_name:String,
                           @SerializedName("status_msg")
                           val status_msg:String,
                           @SerializedName("status_date")
                           val status_date:String,
                           @SerializedName("status_time")
                           val status_time:String,
                           @SerializedName("status_day")
                           val status_day:String,
                           @SerializedName("status_catid")
                           val status_catid:String)
}