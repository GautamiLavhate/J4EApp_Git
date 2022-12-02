package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model

import com.google.gson.annotations.SerializedName

data class MyRecommadPeo(
        @SerializedName("status")
        val status: Boolean,
        @SerializedName("msg")
        val message:String,
        @SerializedName("data")
        val data:List<DataLeadSt>){
    data class DataLeadSt( @SerializedName("AlreadyExist")
                           val alreadyExist:List<AlreadyExist>,
                           @SerializedName("Created")
                           val created:List<Created>){

        data class AlreadyExist( @SerializedName("id")
                               val id:String,
                               @SerializedName("name")
                               val name:String)

        data class Created(  @SerializedName("id")
                             val id:String,
                             @SerializedName("name")
                             val name:String)

    }
}