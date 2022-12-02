package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myreportcard.Model

import com.google.gson.annotations.SerializedName


data class MyReportData(
                            @SerializedName("data")
                            val data: List<Data>,
                          @SerializedName("msg")
                          val msg: String,
                          @SerializedName("status")
                          val status: Boolean){
    data class Data(
            @SerializedName("RewardDetail")
            val RewardDetail1: List<RewardDetail>,
            @SerializedName("TotalReward")
            val TotalReward1: TotalReward
    ){
        data class RewardDetail(
                @SerializedName("RewardDetail")
                val RewardDetail: List<RewardDetailX>,
                @SerializedName("RewardPoint")
                val RewardPoint: String,
                @SerializedName("RewardTitle")
                val RewardTitle: String ,
                var expanded: Boolean = false){
            data class RewardDetailX(
                    @SerializedName("ActivityDate")
                    val ActivityDate: String,
                    @SerializedName("ActivityName")
                    val ActivityName: String,
                    @SerializedName("ActivityPoint")
                    val ActivityPoint: String,
                    @SerializedName("ActivityTime")
                    val ActivityTime: String )
        }

        data class TotalReward(
                @SerializedName("total_point")
                val total_point: String
        )

    }
}
