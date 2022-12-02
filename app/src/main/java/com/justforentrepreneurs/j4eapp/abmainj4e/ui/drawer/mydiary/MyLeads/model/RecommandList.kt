package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model

import com.google.gson.annotations.SerializedName

data class RecommandList (
        @SerializedName("status")
        val status: Boolean,
        @SerializedName("message")
        val message:String,
        @SerializedName("recomdation_list")
        val user_data:List<UserData>,
        @SerializedName("count_available")
        val count_available: Int

)

data class UserData(
        @SerializedName("userid")
        val userid: String,
        @SerializedName("recomendation_id")
        val recomendation_id:String,
        @SerializedName("recomendation_note")
        val recomendation_note:String,
        @SerializedName("full_name")
        val full_name:String,
        @SerializedName("designation")
        val designation:String,
        @SerializedName("company_name")
        val company_name:String,
        @SerializedName("profile_pic")
        val profile_pic:String,
        @SerializedName("recomendation_date")
        val recomendation_date:String,
        @SerializedName("recomended_by")
        val recomended_by:List<RecomendedBy>,
        @SerializedName("is_viewed")
        val is_viewed:Int

)

data class RecomendedBy(
        @SerializedName("recommended_user_id")
        val recommended_user_id: String,
        @SerializedName("recomendation_note")
        val recomendation_note:String,
        @SerializedName("recommended_by_user_fullname")
        val recommended_by_user_name:String,
        @SerializedName("recommended_by_user_designation")
        val recommended_by_user_designation:String,
        @SerializedName("recommended_by_user_company")
        val recommended_by_user_company:String,
        @SerializedName("recomendation_date")
        val recomendation_date:String,
        @SerializedName("recommended_by_user_profile_pic")
        val recommended_by_user_profile_pic:String
)

