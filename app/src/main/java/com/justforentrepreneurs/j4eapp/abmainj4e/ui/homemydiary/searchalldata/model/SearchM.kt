package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.searchalldata.model

import com.google.gson.annotations.SerializedName

data class SearchM (
        @SerializedName("status")
        val status: Boolean,
        @SerializedName("message")
        val message:String,
        @SerializedName("data")
        val user_data:List<UserData>
){

data class UserData(
        @SerializedName("Category")
        val Category: String,
        @SerializedName("Count")
        val Count:String,
        @SerializedName("Data")
        val Data:List<DataType>

){
        data class DataType(
                @SerializedName("id")
                val id: String,
                @SerializedName("title")
                val title:String,
                @SerializedName("thumbnil")
                val thumbnil:String,
                @SerializedName("creatdate")
                val creatdate:String,
                @SerializedName("creattime")
                val creattime:String,
                @SerializedName("type")
                val type:String

        )
}}



