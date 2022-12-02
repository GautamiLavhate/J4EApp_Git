package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrecognition.model

import com.google.gson.annotations.SerializedName


data class Recognition( @SerializedName("status")
                           val status: Boolean,
                           @SerializedName("msg")
                           val message: String,
                           @SerializedName("data")
                           val data: List<DataReco>){
    data class DataReco( @SerializedName("id")
                          val id: String,
                          @SerializedName("title")
                          val title: String,
                          @SerializedName("description")
                          val description: String,
                          @SerializedName("thumbnail")
                          val thumbnail: String,
                          @SerializedName("created_date")
                          val created_date: String,
                          @SerializedName("created_time")
                          val created_time: String)
}
