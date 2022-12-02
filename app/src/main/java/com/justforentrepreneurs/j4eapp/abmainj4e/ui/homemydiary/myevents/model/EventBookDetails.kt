package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.model

import com.google.gson.annotations.SerializedName

data class EventBookDetails(@SerializedName("status")
                     var status: Boolean,
                            @SerializedName("msg")
                     var msg: String,
                            @SerializedName("data")
                     var data: List<Alleventsdata>){

    data class Alleventsdata(  @SerializedName("event_data")
                               var event_data: Eventdata)

    data class Eventdata( @SerializedName("event_id")
                          var event_id: String,
                          @SerializedName("event_cat_id")
                          var event_cat_id: String,
                          @SerializedName("event_cat_name")
                          var event_cat_name: String,
                          @SerializedName("event_title")
                          var event_title: String,
                          @SerializedName("event_description")
                          var event_description: String,
                          @SerializedName("event_address")
                          var event_address: String,
                          @SerializedName("event_date")
                          var event_date: String,
                          @SerializedName("event_startdate")
                          var event_startdate: String,
                          @SerializedName("event_enddate")
                          var event_enddate: String,
                          @SerializedName("event_fees")
                          var event_fees: String,
                          @SerializedName("event_guest_fees")
                          var event_guest_fees: String,
                          @SerializedName("event_thumbnil")
                          var event_thumbnil: String,
                          @SerializedName("event_creatdate")
                          var event_creatdate: String,
                          @SerializedName("event_creattime")
                          var event_creattime: String,
                          @SerializedName("event_createdby_id")
                          var event_createdby_id: String,
                          @SerializedName("event_createdby_name")
                          var event_createdby_name: String,
                          @SerializedName("event_createdby_profile")
                          var event_createdby_profile: String,
                          @SerializedName("event_createdby_email")
                          var event_createdby_email: String,
                          @SerializedName("event_createdby_phno")
                          var event_createdby_phno: String,
                          @SerializedName("event_createdby_company")
                          var event_createdby_company: String,
                          @SerializedName("event_booked_byuser")
                          var event_booked_byuser: String)
}
