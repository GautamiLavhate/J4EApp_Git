package com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model

import com.google.gson.annotations.SerializedName

data class AllPosts(    @SerializedName("status")
                        val status: Boolean,
                        @SerializedName("msg")
                        val message: String,
                        @SerializedName("data")
                        val data:List<Postdata>,
                        @SerializedName("count_available")
                        val count_available: Int){

    data class Postdata(@SerializedName("post_id")
                        val post_id: String,
                        @SerializedName("post_cat_name")
                        val post_cat_name: String,
                        @SerializedName("post_cat_icon")
                        val post_cat_icon: String,
                        @SerializedName("post_by_user_name")
                        val post_by_user_name: String,
                        @SerializedName("post_by_user_image")
                        val post_by_user_image: String,
                        @SerializedName("post_description")
                        val post_description: String,
                        @SerializedName("post_date")
                        val post_date: String,
                        @SerializedName("post_time")
                        val post_time: String,
                        @SerializedName("post_image")
                        val post_image: String,
                        @SerializedName("post_total_comment")
                        val post_total_comment: String,
                        @SerializedName("post_total_like")
                        val post_total_like: Int,
                        @SerializedName("post_like_given_by_you")
                        val post_like_given_by_you: String,
                        @SerializedName("post_by_user_id")
                        val post_by_user_id: String,
                        var isSelected :Boolean,
                        @SerializedName("is_viewed")
                        val is_viewed: Int,
                        @SerializedName("is_edit")
                        val is_edit: Int,
                        @SerializedName("post_type")
                        val post_type: String,
                        //buddy meet
                        @SerializedName("buddymeet_id")
                        val buddymeet_id: String,
                        @SerializedName("buddymeet_description")
                        val buddymeet_description: String,
                        @SerializedName("buddymeet_location")
                        val buddymeet_location: String,
                        @SerializedName("buddymeet_date")
                        val buddymeet_date: String,
                        @SerializedName("buddymeet_time")
                        val buddymeet_time: String,
                        @SerializedName("buddymeet_day")
                        val buddymeet_day: String,
                        @SerializedName("buddymeet_touserid")
                        val buddymeet_touserid: String,
                        @SerializedName("buddymeet_tousername")
                        val buddymeet_tousername: String,
                        @SerializedName("buddymeet_touserprofile")
                        val buddymeet_touserprofile: String,
                        @SerializedName("buddymeet_withuserid")
                        val buddymeet_withuserid: String,
                        @SerializedName("buddymeet_withusername")
                        val buddymeet_withusername: String,
                        @SerializedName("buddymeet_withuserprofile")
                        val buddymeet_withuserprofile: String,
                        @SerializedName("is_viewed2")
                        val is_viewed2:Int,
                        //requirement
                        @SerializedName("userid")
                        val userid:String,
                        @SerializedName("requirement_id")
                        val requirement_id: String,
                        @SerializedName("requirement_title")
                        val requirement_title: String,
                        @SerializedName("requirement_description")
                        val requirement_description: String,
                        @SerializedName("rerquirement_thumbnail")
                        val rerquirement_thumbnail: String,
                        @SerializedName("created_date")
                        val created_date: String,
                        @SerializedName("created_time")
                        val created_time: String,
                        @SerializedName("full_name")
                        val full_name: String,
                        @SerializedName("email")
                        val email: String,
                        @SerializedName("mobile")
                        val mobile: String,
                        @SerializedName("designation")
                        val designation: String,
                        @SerializedName("company_name")
                        val company_name: String,
                        @SerializedName("company_phone")
                        val company_phone: String,
                        @SerializedName("company_address")
                        val company_address: String,
                        @SerializedName("dob")
                        val dob: String,
                        @SerializedName("profile_pic")
                        val profile_pic: String,
                        //event
                        @SerializedName("event_id")
                        val event_id: String,
                        @SerializedName("event_cat_id")
                        val event_cat_id: String,
                        @SerializedName("event_cat_name")
                        val event_cat_name: String,
                        @SerializedName("event_title")
                        val event_title: String,
                        @SerializedName("event_address")
                        val event_address: String,
                        @SerializedName("event_shortabout")
                        val event_shortabout: String,
                        @SerializedName("event_about")
                        val event_about: String,
                        @SerializedName("event_longitude")
                        val event_longitude: String,
                        @SerializedName("event_latitude")
                        val event_latitude: String,
                        @SerializedName("event_phno")
                        val event_phno: String,
                        @SerializedName("event_date")
                        val event_date: String,
                        @SerializedName("event_startdate")
                        val event_startdate: String,
                        @SerializedName("event_enddate")
                        val event_enddate: String,
                        @SerializedName("event_fees")
                        val event_fees: String,
                        @SerializedName("event_guest_fees")
                        val event_guest_fees: String,
                        @SerializedName("event_thumbnil")
                        val event_thumbnil: String,
                        @SerializedName("event_creatdate")
                        val event_creatdate: String,
                        @SerializedName("event_creattime")
                        val event_creattime: String,
                        @SerializedName("event_organized_by")
                        val event_organized_by: String,
                        @SerializedName("chat_id")
                        val chat_id: String,
                        @SerializedName("event_booked_byuser")
                        val event_booked_byuser: String,
                        @SerializedName("event_type")
                        val event_type: String,
                        @SerializedName("event_publish_status")
                        val event_publish_status: String,
                        @SerializedName("membership_type")
                        val membership_type: String)

}
