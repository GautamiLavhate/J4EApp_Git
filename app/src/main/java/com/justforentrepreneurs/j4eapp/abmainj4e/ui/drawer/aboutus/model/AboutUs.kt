package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.aboutus.model

import com.google.gson.annotations.SerializedName

data class AboutUs( @SerializedName("status")
                    val status: Boolean,
                    @SerializedName("msg")
                    val message: String,
                    @SerializedName("data")
                    val data: List<Dataabout>){

    data class Dataabout( @SerializedName("vision")
                            val vision: String,
                            @SerializedName("mission")
                            val mission: String,
                            @SerializedName("aboutus")
                            val aboutus: String,
                            @SerializedName("achievement")
                            val achievement: String,
                            @SerializedName("contactnumber")
                            val contactnumber: String,
                            @SerializedName("whatsappnumber")
                            val whatsappnumber: String,
                            @SerializedName("email")
                            val email: String,
                          @SerializedName("website")
                          val website: String,
                          @SerializedName("address")
                          val address: String,
                          @SerializedName("longitude")
                          val longitude: String,
                          @SerializedName("latitude")
                          val latitude: String)


}
