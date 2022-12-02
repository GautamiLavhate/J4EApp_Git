package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myawardrecognition.model

import com.google.gson.annotations.SerializedName


data class MyAward( @SerializedName("status")
                       val status: Boolean,
                       @SerializedName("msg")
                       val message: String,
                       @SerializedName("data")
                       val data: List<DataMyAward>){

        data class DataMyAward( @SerializedName("rewardtitle")
                               val rewardtitle: String,
                               @SerializedName("rewarddescription")
                               val rewarddescription: String,
                               @SerializedName("rewardfrom")
                               val rewardfrom: String,
                               @SerializedName("rewardto")
                               val rewardto: String,
                               @SerializedName("rewardstatus")
                               val rewardstatus: String,
                               @SerializedName("rewardthumbnil")
                               val rewardthumbnil: String)
}