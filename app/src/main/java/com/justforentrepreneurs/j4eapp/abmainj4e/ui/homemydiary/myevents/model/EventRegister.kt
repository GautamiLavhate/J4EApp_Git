package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.model

import com.google.gson.annotations.SerializedName

data class EventRegister(
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("msg")
    val message: String,
    @SerializedName("data")
    val data: List<Datauser>
) {

    data class Datauser(
        @SerializedName("registerid")
        val registerid: String,
        @SerializedName("eventid")
        val eventid: String,
        @SerializedName("userid")
        val userid: String,
        @SerializedName("username")
        val username: String,
        @SerializedName("userimage")
        val userimage: String,
        @SerializedName("designation")
        val designation: String,
        @SerializedName("check_connection")
        val check_connection: String,
        @SerializedName("event_attedance")
        val event_attedance: String

    )

}