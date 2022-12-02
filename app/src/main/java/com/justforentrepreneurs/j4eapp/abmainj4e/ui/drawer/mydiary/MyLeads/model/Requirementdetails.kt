package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model

import com.google.gson.annotations.SerializedName


data class Requirementdetails (
        @SerializedName("status")
        val status: Boolean,
        @SerializedName("msg")
        val message:String,
        @SerializedName("recomdation_list")
        val user_data:recomdation_list

)

data class recomdation_list(
        @SerializedName("requirement_info")
        val requirement_info:List<requirement_info>,
        @SerializedName("is_recommendation_exhausted")
        val is_recommendation_exhausted:Int
)

data class requirement_info(
        @SerializedName("userid")
        val userid: String,
        @SerializedName("requirement_id")
        val requirement_id:String,
        @SerializedName("requirement_title")
        val requirement_title:String,
        @SerializedName("requirement_description")
        val requirement_description:String,
        @SerializedName("rerquirement_thumbnail")
        val rerquirement_thumbnail:String,
        @SerializedName("created_date")
        val created_date:String,
        @SerializedName("created_time")
        val created_time:String,
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
        @SerializedName("company_phone")
        val company_phone:String,
        @SerializedName("company_address")
        val company_address:String,
        @SerializedName("dob")
        val dob:String,
        @SerializedName("profile_pic")
        val profile_pic:String,
        @SerializedName("chat_id")
        val chat_id:String,
        @SerializedName("requirement_address")
        val requirement_address:String,
        @SerializedName("membership_type")
        val membership_type:String,
        @SerializedName("referral_type")
        val referral_type:String,
        @SerializedName("refferal_status")
        val refferal_status:List<Refferalstatus>,
        @SerializedName("referal_given_by_full_name")
        val referal_given_by_full_name:String,
        @SerializedName("referal_given_by_id")
        val referal_given_by_id:String,
        @SerializedName("referal_given_by_profile_pic")
        val referal_given_by_profile_pic:String,
        @SerializedName("referal_given_by_functional_area")
        val referal_given_by_functional_area:String,
        @SerializedName("referal_given_by_dob")
        val referal_given_by_dob:String,
        @SerializedName("referal_received_by_full_name")
        val referal_received_by_full_name:String,
        @SerializedName("referal_received_by_id")
        val referal_received_by_id:String,
        @SerializedName("referal_received_by_profile_pic")
        val referal_received_by_profile_pic:String,
        @SerializedName("referal_received_by_functional_area")
        val referal_received_by_functional_area:String,
        @SerializedName("referal_received_by_dob")
        val referal_received_by_dob:String,
        @SerializedName("contact_person_id")
        val contact_person_id:String,
        @SerializedName("contact_person_name")
        val contact_person_name:String,
        @SerializedName("contact_person_pic")
        val contact_person_pic:String,
        @SerializedName("contact_person_functional_area")
        val contact_person_functional_area:String,
        @SerializedName("designations")
        val designations:String,
        @SerializedName("mobilenumber")
        val mobilenumber:String,
        @SerializedName("telphno")
        val telphno:String,
        @SerializedName("emailaddrss")
        val emailaddrss:String,
        @SerializedName("requirement_functional_area")
        val requirement_functional_area:String,
        @SerializedName("whatsapp_no")
        val whatsapp_no:String,
        @SerializedName("company_whatsapp_no")
        val company_whatsapp_no:String,
        @SerializedName("doe_date")
        val doe_date:String,
        @SerializedName("doe_time")
        val doe_time:String

){
        data class Refferalstatus(
                @SerializedName("id")
                val id: String,
                @SerializedName("name")
                val name:String,
                @SerializedName("value")
                val value:String)
}