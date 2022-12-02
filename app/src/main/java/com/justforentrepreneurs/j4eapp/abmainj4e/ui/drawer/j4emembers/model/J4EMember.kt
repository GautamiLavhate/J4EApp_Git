package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model


import com.google.gson.annotations.SerializedName

data class J4EMember(
        @SerializedName("status")
        val status: Boolean,
        @SerializedName("msg")
        val message: String,
        @SerializedName("data")
        val data: Datauser,
        @SerializedName("count_available")
        val count_available: Int
)

data class Datauser(

        @SerializedName("member_info")
        val member_info: List<Memberinfo>,
        @SerializedName("is_connection_exhausted")
        val is_connection_exhausted: Int
)
data class Memberinfo(
        @SerializedName("id")
        val id:String,
        @SerializedName("full_name")
        val full_name:String,
        @SerializedName("email")
        val email:String,
        @SerializedName("mobile")
        val mobile:String,
        @SerializedName("designation")
        val designation:String,
        @SerializedName("company_name")
        val company_name:String,
        @SerializedName("company_address")
        val company_address:String,
        @SerializedName("dob")
        val dob:String,
        @SerializedName("profile_pic")
        val profile_pic:String,
        @SerializedName("membership_type")
        val membership_type:String,
        @SerializedName("membership_name")
        val membership_name:String,
        @SerializedName("check_connection")
        val check_connection:String,
        @SerializedName("chat_id")
        val chat_id:String,
        @SerializedName("is_viewed")
        val is_viewed:Int,
        @SerializedName("whatsapp_no")
        val whatsapp_no: String,
        @SerializedName("company_whatsapp_no")
        val company_whatsapp_no:String
)
