package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model

import com.google.gson.annotations.SerializedName

data class AllPlan(
        @SerializedName("status")
        var status: Boolean,
        @SerializedName("msg")
        var message:String,
        @SerializedName("data")
        var data:List<Dataplan>,
        @SerializedName("cover_image")
        var cover_image: String
)
data class Dataplan(
        @SerializedName("membership_id")
        var membership_id: String,
        @SerializedName("membership_title")
        var membership_title:String,
        @SerializedName("membership_benifits")
        var membership_benifits:String,
        @SerializedName("membership_cost")
        var membership_cost:String,
        @SerializedName("membership_type")
        var membership_type:String,
        @SerializedName("membership_type_name")
        var membership_type_name:String,
        @SerializedName("membership_duration")
        var membership_duration:String,
        @SerializedName("membership_features")
        var membership_features:List<MembershipFeaturesm>,
        var isSelected :Boolean,
        @SerializedName("membership_seq_no")
        var membership_seq_no: String
)
data class MembershipFeaturesm(
        @SerializedName("FeaturesName")
        var FeaturesName: String,
        @SerializedName("FeaturesDesc")
        var FeaturesDesc: String,
        @SerializedName("FeaturesAvilablity")
        var FeaturesAvilablity:String,
        @SerializedName("FeaturesCount")
        var FeaturesCount:String
)