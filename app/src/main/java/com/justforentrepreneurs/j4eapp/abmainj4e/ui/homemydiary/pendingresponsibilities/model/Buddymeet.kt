package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.model

import com.google.gson.annotations.SerializedName


data class Buddymeet(@SerializedName("status")
                           val status: Boolean,
                     @SerializedName("msg")
                           val message: String,
                     @SerializedName("data")
                           val data: DATAA,
                     @SerializedName("count_available")
                           val count_available: Int){

    data class DATAA(
        @SerializedName("buddy_meet_info")
        val buddy_meet_info: List<UserData>,
        @SerializedName("is_buddy_meet_exhausted")
        val is_buddy_meet_exhausted: Int
    )

    data class UserData(
            @SerializedName("monthname")
            val monthname: String,
            @SerializedName("buddymeetdata")
            val Data:List<DataBuddy>

    )
    data class DataBuddy( @SerializedName("buddymeet_id")
                          val buddymeet_id: String,
                          @SerializedName("buddymeet_description")
                          val buddymeet_description: String,
                          @SerializedName("buddymeet_location")
                          val buddymeet_location: String,
                          @SerializedName("buddymeet_date")
                          val buddymeet_date: String,
                          @SerializedName("buddymeet_time")
                          val buddymeet_time: String,
                          @SerializedName("buddymeet_day")
                          val buddymeet_day: String,
                          @SerializedName("buddymeet_userid")
                          val buddymeet_userid: String,
                          @SerializedName("buddymeet_username")
                          val buddymeet_username: String,
                          @SerializedName("buddymeet_userprofile")
                          val buddymeet_userprofile: String,
                          @SerializedName("is_viewed")
                          val is_viewed: Int)
}
