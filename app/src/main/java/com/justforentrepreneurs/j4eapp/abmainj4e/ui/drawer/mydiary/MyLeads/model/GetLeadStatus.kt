package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model

import com.google.gson.annotations.SerializedName

data class GetLeadStatus (
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("msg")
    val message:String,
    @SerializedName("data")
    val data:List<Leadstatus>){
    data class Leadstatus(@SerializedName("PendingData")
                          val PendingData:List<PendingData>,
                          @SerializedName("InprogressData")
                          val InprogressData:List<InprogressData>,
                          @SerializedName("ClosedData")
                          val ClosedData:List<ClosedData>)
    data class PendingData(@SerializedName("req_status_id")
                             val req_status_id:String,
                             @SerializedName("req_status_name")
                             val req_status_name:String,
                             @SerializedName("req_status_description")
                             val req_status_description:String,
                             @SerializedName("req_status_category_id")
                             val req_status_category_id:String,
                             @SerializedName("req_status_category_name")
                             val req_status_category_name:String)
    data class InprogressData(@SerializedName("req_status_id")
                              val req_status_id:String,
                              @SerializedName("req_status_name")
                              val req_status_name:String,
                              @SerializedName("req_status_description")
                              val req_status_description:String,
                              @SerializedName("req_status_category_id")
                              val req_status_category_id:String,
                              @SerializedName("req_status_category_name")
                              val req_status_category_name:String)
    data class ClosedData(@SerializedName("req_status_id")
                          val req_status_id:String,
                          @SerializedName("req_status_name")
                          val req_status_name:String,
                          @SerializedName("req_status_description")
                          val req_status_description:String,
                          @SerializedName("req_status_category_id")
                          val req_status_category_id:String,
                          @SerializedName("req_status_category_name")
                          val req_status_category_name:String)

}