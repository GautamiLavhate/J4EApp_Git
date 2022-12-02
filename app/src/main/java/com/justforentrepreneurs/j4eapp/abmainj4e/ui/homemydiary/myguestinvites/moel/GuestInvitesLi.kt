package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myguestinvites.moel

import com.google.gson.annotations.SerializedName

data class GuestInvitesLi( @SerializedName("status")
                           val status: Boolean,
                           @SerializedName("msg")
                           val message: String,
                           @SerializedName("data")
                           val data: List<DataGuest>){
    data class DataGuest( @SerializedName("invite_id")
                               val invite_id: String,
                               @SerializedName("guestname")
                               val guestname: String,
                               @SerializedName("guestemail")
                               val guestemail: String,
                                @SerializedName("guestphno")
                               val guestphno: String,
                               @SerializedName("guestcompany")
                               val guestcompany: String,
                               @SerializedName("guestdesignation")
                               val guestdesignation: String,
                               @SerializedName("eventname")
                               val eventname: String,
                              @SerializedName("status")
                              val status: String,
                              @SerializedName("eventamount")
                              val eventamount: String,
                             @SerializedName("approval_status")
                             val approval_status: String)
}
