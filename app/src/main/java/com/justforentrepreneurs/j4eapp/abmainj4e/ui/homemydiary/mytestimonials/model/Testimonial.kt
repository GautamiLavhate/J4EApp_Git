package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mytestimonials.model

import com.google.gson.annotations.SerializedName

data class Testimonial( @SerializedName("status")
                    val status: Boolean,
                    @SerializedName("msg")
                    val message: String,
                    @SerializedName("data")
                    val data: List<DataTestimonial>,
                    @SerializedName("count_available")
                    val count_available: Int){

    data class DataTestimonial(@SerializedName("toalcount")
                               val toalcount: String,
                               @SerializedName("reviewdata")
                               val reviewdata:List<Reviewdata>){


    data class Reviewdata( @SerializedName("id")
                            val id: String,
                            @SerializedName("title")
                            val title: String,
                            @SerializedName("thumbnil")
                            val thumbnil: String,
                            @SerializedName("review")
                            val review: String,
                           @SerializedName("rate")
                            val rate: String,
                            @SerializedName("date")
                            val date: String,
                            @SerializedName("time")
                            val time: String,
                            @SerializedName("type")
                            val type: String,
                            @SerializedName("is_viewed")
                            val is_viewed: Int)}
}