package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.model

import com.google.gson.annotations.SerializedName


data class FollowUpmem(@SerializedName("status")
                           val status: Boolean,
                       @SerializedName("msg")
                           val message: String,
                       @SerializedName("data")
                           val data: List<DataLead>){


    data class DataLead( @SerializedName("user_id")
                          val user_id: String,
                          @SerializedName("user_name")
                          val user_name: String)
}
