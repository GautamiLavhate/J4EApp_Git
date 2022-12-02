package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.model

import com.google.gson.annotations.SerializedName


data class EventStatus(   @SerializedName("status")
                                  val status: Boolean,
                                  @SerializedName("msg")
                                  val message: String,
                                  @SerializedName("data")
                                  val data:List<EventStatusdata>){
    data class EventStatusdata(   @SerializedName("srno")
                              val srno: String,
                              @SerializedName("userid")
                              val userid: String,
                              @SerializedName("username")
                              val username: String,
                              @SerializedName("userimage")
                              val userimage: String,
                              @SerializedName("statustype")
                              val statustype: String) }