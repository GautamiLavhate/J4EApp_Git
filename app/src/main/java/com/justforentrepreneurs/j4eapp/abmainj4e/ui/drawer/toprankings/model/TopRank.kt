package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.toprankings.model

import com.google.gson.annotations.SerializedName

data class TopRank( @SerializedName("status")
                        val status: Boolean,
                        @SerializedName("msg")
                        val message: String,
                        @SerializedName("data")
                        val data: List<DataTopRank>,
                        @SerializedName("count_available")
                        val count_available: Int){
    data class DataTopRank( @SerializedName("id")
                         val id: String,
                         @SerializedName("full_name")
                         val full_name: String,
                         @SerializedName("designation")
                         val designation: String,
                         @SerializedName("company_name")
                         val company_name: String,
                         @SerializedName("company_contact")
                         val company_contact: String,
                         @SerializedName("profile_pic")
                         val profile_pic: String,
                            @SerializedName("total_point")
                            val total_point: String,
                         @SerializedName("is_viewed")
                         val is_viewed: Int)
}