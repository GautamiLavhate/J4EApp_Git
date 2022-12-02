package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.model

import com.google.gson.annotations.SerializedName


data class FollowUpLead(@SerializedName("status")
                           val status: Boolean,
                        @SerializedName("msg")
                           val message: String,
                        @SerializedName("data")
                           val data: List<DataLead>){


    data class DataLead( @SerializedName("requirement_id")
                          val requirement_id: String,
                          @SerializedName("requirement_title")
                          val requirement_title: String)
}
