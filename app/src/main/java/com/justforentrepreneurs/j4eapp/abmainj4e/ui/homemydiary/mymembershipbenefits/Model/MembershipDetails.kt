package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model


import com.google.gson.annotations.SerializedName

data class MembershipDetails(
        @SerializedName("status")
        var status: Boolean,
        @SerializedName("msg")
        var message:String,
        @SerializedName("data")
        var data:Message2
)

data class Message2(
        @SerializedName("membership_id")
        var membership_id: String,
        @SerializedName("membership_title")
        var membership_title: String,
        @SerializedName("membership_start_date")
        var membership_start_date: String,
        @SerializedName("membership_end_date")
        var membership_end_date: String,
        @SerializedName("membership_benifits")
        var membership_benifits: String,
        @SerializedName("membership_cost")
        var membership_cost: String,
        @SerializedName("membership_renewed")
        var membership_renewed: String,
        @SerializedName("membership_type")
        var membership_type: String,
        @SerializedName("membership_features")
        var membership_features:  List<MembershipFeatureslist>,
        @SerializedName("membership_seq_no")
        var membership_seq_no: String,
        @SerializedName("referral_code")
        var referral_code: String

)

data class MembershipFeatureslist(
        @SerializedName("FeaturesName")
        var FeaturesName: String,
        @SerializedName("FeaturesDesc")
        var FeaturesDesc: String,
        @SerializedName("FeaturesAvilablity")
        var FeaturesAvilablity: String,
        @SerializedName("FeaturesCount")
        var FeaturesCount: String
)