package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model

import com.google.gson.annotations.SerializedName

data class ProfileAboutModel(
    @SerializedName("status")
    var status: Boolean,
    @SerializedName("msg")
    var msg: String,
    @SerializedName("data")
    var message: Message
)

data class Message(
    @SerializedName("about_company")
    val about_company: String,
    @SerializedName("company_name")
    val company_name: String,
    @SerializedName("business_entity")
    val business_entity: String,
    @SerializedName("business_type")
    val business_type: String,
    @SerializedName("business_expertise")
    val business_expertise: String,
    @SerializedName("working_from")
    val working_from: String,
    @SerializedName("no_of_employees")
    val no_of_employees: String,
    @SerializedName("no_of_employees_id")
    val no_of_employees_id: String,
    @SerializedName("expected_turnover_value")
    val expected_turnover: String,
    @SerializedName("expected_turnover_id")
    val expected_turnover_id: String,
    @SerializedName("target_audiance")
    val target_audiance: String,
    @SerializedName("membership_title")
    val membership_title: String,
    @SerializedName("company_profile")
    val company_profile: String,
    @SerializedName("company_ppt")
    val company_ppt: String
)
