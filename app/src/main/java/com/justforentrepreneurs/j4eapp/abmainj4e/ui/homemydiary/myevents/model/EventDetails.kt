package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class EventDetails(@SerializedName("status")
                        var status: Boolean,
                        @SerializedName("msg")
                        var msg: String,
                        @SerializedName("data")
                        var data: List<Alleventsdata>){

    data class Alleventsdata(  @SerializedName("event_data")
                               var event_data: Eventdata,
                               @SerializedName("gallery_data")
                               var gallery_data: List<Gallerydata>,
                               @SerializedName("review_star")
                               var review_star: List<Reviewstar>,
                               @SerializedName("average_ratings")
                               var average_ratings: String,
                               @SerializedName("total_review_count")
                               var total_review_count: String,
                               @SerializedName("all_reviews")
                               var all_reviews: List<Allreviews>,
                               @SerializedName("event_interestedcount")
                               var event_interestedcount: Int,
                               @SerializedName("event_maybecount")
                               var event_maybecount: Int,
                               @SerializedName("event_attendedcount")
                               var event_attendedcount: Int,
                               @SerializedName("event_invitedcount")
                               var event_invitedcount: Int,
                               @SerializedName("event_invited")
                               var event_invited: List<EventInvited>,
                               @SerializedName("event_organizer")
                               var event_organizerma: List<event_organizer>){


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
                              var event_booked_byuser: String,
                              @SerializedName("event_publish_status")
                              var event_publish_status: String,
                              @SerializedName("event_allocated_ticket")
                              var event_allocated_ticket: String)


        @Parcelize
        data class Gallerydata( @SerializedName("event_img_id")
                                var event_img_id: String,
                                @SerializedName("images")
                                var images: String):Parcelable


        data class Reviewstar(@SerializedName("one_star")
                              val one_star: Int,
                              @SerializedName("two_star")
                              val two_star: Int,
                              @SerializedName("three_star")
                              val three_star: Int,
                              @SerializedName("four_star")
                              val four_star: Int,
                              @SerializedName("five_star")
                              val five_star: Int,
                              @SerializedName("total_rate_review")
                              val total_rate_review: Int)


        data class Allreviews(@SerializedName("reviewed_by_id")
                              val reviewed_by_id: String,
                              @SerializedName("reviewed_by")
                              val reviewed_by: String,
                              @SerializedName("review_rate")
                              val review_rate: String,
                              @SerializedName("review_note")
                              val review_note: String,
                              @SerializedName("profile_img")
                              val profile_img: String,
                              @SerializedName("review_date")
                              val review_date: String,
                              @SerializedName("review_time")
                              val review_time: String)

        data class EventInvited( @SerializedName("images")
                              var images: String)

        data class event_organizer( @SerializedName("facebook")
                                var facebook: String,
                                    @SerializedName("linkdin")
                                    var linkdin: String,
                                    @SerializedName("twitter")
                                    var twitter: String,
                                    @SerializedName("organizename")
                                    var organizename: String,
                                    @SerializedName("shortabout")
                                    var shortabout: String,
                                    @SerializedName("address")
                                    var address: String)
    }

}