package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model

import com.google.gson.annotations.SerializedName

data class AppRecommendMyself(
        @SerializedName("status")
        val status: Boolean,
        @SerializedName("msg")
        val message:String,
        @SerializedName("data")
        val recom_data:List<RecomData>
)


data class RecomData(
        @SerializedName("id")
        val id:String,
        @SerializedName("userid")
        val userid:String,
        @SerializedName("recomend_by")
        val recomend_by:String,
        @SerializedName("recom_note")
        val recom_note:String,
        @SerializedName("doe")
        val doe:String,
        @SerializedName("requirement_id")
        val requirement_id:String
)