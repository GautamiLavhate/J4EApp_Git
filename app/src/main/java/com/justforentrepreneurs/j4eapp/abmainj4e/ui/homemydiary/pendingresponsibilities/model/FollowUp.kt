package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.model

import com.google.gson.annotations.SerializedName


data class FollowUp(@SerializedName("status")
                           val status: Boolean,
                    @SerializedName("msg")
                           val message: String,
                    @SerializedName("data")
                           val data: DATAA,
                    @SerializedName("count_available")
                           val count_available: Int){

    data class DATAA(
        @SerializedName("followup_info")
        val followup_info: List<UserData>,
        @SerializedName("is_followup_exhausted")
        val is_followup_exhausted: Int
    )
    data class UserData(
            @SerializedName("monthname")
            val monthname: String,
            @SerializedName("followupdata")
            val Data:List<Datafollowup>

    )

    data class Datafollowup(@SerializedName("followup_id")
                            val followup_id: String,
                            @SerializedName("followup_reqid")
                            val followup_reqid: String,
                            @SerializedName("followup_title")
                            val followup_title: String,
                            @SerializedName("followup_description")
                            val followup_description: String,
                            @SerializedName("followup_userid")
                            val followup_userid: String,
                            @SerializedName("followup_date")
                            val followup_date: String,
                            @SerializedName("followup_username")
                            val followup_username: String,
                            @SerializedName("followup_userprofile")
                            val followup_userprofile: String,
                            @SerializedName("followup_day")
                            val followup_day: String,
                            @SerializedName("followup_time")
                            val followup_time: String,
                            @SerializedName("is_viewed")
                            val is_viewed: Int)
}
