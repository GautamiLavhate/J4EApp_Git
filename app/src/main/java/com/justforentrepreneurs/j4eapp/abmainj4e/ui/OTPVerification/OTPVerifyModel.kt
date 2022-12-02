package com.justforentrepreneurs.j4eapp.abmainj4e.ui.OTPVerification


import com.google.gson.annotations.SerializedName

data class OTPVerifyModel(
        @SerializedName("status")
        val status: Boolean,
        @SerializedName("msg")
        val msg: String,
        @SerializedName("data")
        val data: List<Datauser>
)

data class Datauser(
        @SerializedName("userdata")
        val userdata: userdata
)


data class userdata(
        @SerializedName("id")
        val id: String,
        @SerializedName("email_address")
        val email_address: String,
        @SerializedName("phone")
        val phone: String,
        @SerializedName("login_type")
        val type: String,
        @SerializedName("membership_type")
        val membership_type: String,
        @SerializedName("first_name")
        val first_name: String,
        @SerializedName("middle_name")
        val middle_name: String,
        @SerializedName("last_name")
        val last_name: String,
        @SerializedName("dob")
        val dob: String,
        @SerializedName("company")
        val company: String,
        @SerializedName("designation")
        val designation: String,
        @SerializedName("company_address")
        val company_address: String,
        @SerializedName("company_contact")
        val company_number: String,
        @SerializedName("avatar")
        val avatar: String,
        @SerializedName("business_type")
        val business_type: String,
        @SerializedName("business_category")
        val business_category: String,
        @SerializedName("business_entity")
        val business_entity: String,
        @SerializedName("total_experience")
        val total_experience: String,
        @SerializedName("signup_source")
        val signup_source: String,
        @SerializedName("chat_id")
        val chat_id: String,
        @SerializedName("notification_count")
        val notification_count: CountBubbleData,
        @SerializedName("is_admin")
        val is_admin: String

){
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
                                   val connection_receive_count: String
        )
}

