package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model

import com.google.gson.annotations.SerializedName

data class ProfileReview(@SerializedName("status")
                          var status: Boolean,
                          @SerializedName("msg")
                          val message: String,
                          @SerializedName("data")
                          val data :List<ProfileData>,
                          @SerializedName("count_available")
                          val count_available:Int)
data class ProfileData(
                        @SerializedName("average_ratings")
                        val average_ratings: Float,
                        @SerializedName("total_review_count")
                        val total_review_count: Float,
                        @SerializedName("review_star")
                        val review_star: List<Reviewstar>,
                        @SerializedName("all_reviews")
                        val all_reviews: List<Allreviews>,
                        @SerializedName("is_review_exhausted")
                        val is_review_exhausted: Int)
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

