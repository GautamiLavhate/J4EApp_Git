package com.justforentrepreneurs.j4eapp.abmainj4e.network.model

import com.google.gson.annotations.SerializedName

data class NotificationModel(
        @SerializedName("status")
        val status: Boolean,
        @SerializedName("msg")
        val msg: String,
        @SerializedName("data")
        val Data:List<Datauser>
)


data class Datauser( @SerializedName("notify_id")
                     val notify_id: String,
                     @SerializedName("by_user")
                     val by_user: String,
                     @SerializedName("subject")
                     val subject: String,
                     @SerializedName("subtitle")
                     val subtitle: String,
                     @SerializedName("amount")
                     val amount: String,
                     @SerializedName("type")
                     val type: String,
                     @SerializedName("cat_name")
                     val cat_name: String,
                     @SerializedName("lead_status")
                     val lead_status: String,
                     @SerializedName("id")
                     val id: String,
                     @SerializedName("note")
                     val note: String,
                     @SerializedName("business_type")
                     val business_type: String,
                     @SerializedName("thumbnil")
                     val thumbnil: String,
                     @SerializedName("is_read")
                     val is_read: String,
                     @SerializedName("created_time")
                     val created_time: String,
                     @SerializedName("to_user")
                     val to_user: String,
                     @SerializedName("confirm_status")
                     val confirm_status: String)

