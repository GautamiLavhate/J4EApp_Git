package com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model

import com.google.gson.annotations.SerializedName


data class CountBubble( @SerializedName("status")
                     val status: Boolean,
                     @SerializedName("msg")
                     val message: String,
                     @SerializedName("data")
                     val data:CountBubbleData){

    data class CountBubbleData(@SerializedName("post_count")
                            val post_count: String,
                            @SerializedName("event_count")
                            val event_count: String,
                               @SerializedName("lead_count")
                               val lead_count: String,
                               @SerializedName("buddy_count")
                               val buddy_count: String,
                               @SerializedName("notificat_count")
                               val notificat_count: String,
                               @SerializedName("connection_sent_count")
                               val connection_sent_count: String,
                               @SerializedName("connection_receive_count")
                               val connection_receive_count: String,
                               @SerializedName("add_permission")
                               val add_permission: String
    )

}
