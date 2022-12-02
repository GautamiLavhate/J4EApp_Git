package com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model

import com.google.gson.annotations.SerializedName

data class PostGetComments (    @SerializedName("status")
                                val status: Boolean,
                                @SerializedName("msg")
                                val message: String,
                                @SerializedName("data")
                                val data:List<DataGet>){
        data class DataGet(@SerializedName("Count")
                       val Count: String,
                       @SerializedName("CommentData")
                       val CommentData: List<DataGetData>) {

        data class DataGetData(@SerializedName("post_cmt_id")
                               val post_cmt_id: String,
                               @SerializedName("post_cmt_by_user_name")
                               val post_cmt_by_user_name: String,
                               @SerializedName("post_cmt_by_user_id")
                               val post_cmt_by_user_id: String,
                               @SerializedName("post_cmt_by_user_image")
                               val post_cmt_by_user_image: String,
                               @SerializedName("post_cmt_message")
                               val post_cmt_message: String,
                               @SerializedName("post_cmt_date")
                               val post_cmt_date: String,
                               @SerializedName("post_cmt_time")
                               val post_cmt_time: String)
    }
}