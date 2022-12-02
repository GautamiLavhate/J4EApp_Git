package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.model

import com.google.gson.annotations.SerializedName

data class EventBook(@SerializedName("status")
                     var status: Boolean,
                     @SerializedName("msg")
                     var msg: String,
                     @SerializedName("data")
                     var data: DataBook){

    data class DataBook(  @SerializedName("booking_id")
                          var booking_id: String,
                          @SerializedName("booking_userid")
                          var booking_userid: String,
                          @SerializedName("booking_eventid")
                          var booking_eventid: String,
                          @SerializedName("booking_username")
                          var booking_username: String,
                          @SerializedName("booking_cmpname")
                          var booking_cmpname: String,
                          @SerializedName("booking_category")
                          var booking_category: String,
                          @SerializedName("booking_useremail")
                          var booking_useremail: String,
                          @SerializedName("booking_userphno")
                          var booking_userphno: String,
                          @SerializedName("booking_amount")
                          var booking_amount: String,
                          @SerializedName("booking_creatdate")
                          var booking_creatdate: String,
                          @SerializedName("booking_creattime")
                          var booking_creattime: String,
                          @SerializedName("bookin_status")
                          var bookin_status: String,
                          @SerializedName("bookin_attedance")
                          var bookin_attedance: String)

}
