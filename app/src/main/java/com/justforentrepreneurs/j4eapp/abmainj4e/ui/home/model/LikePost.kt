package com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model

import com.google.gson.annotations.SerializedName

data class LikePost( @SerializedName("status")
                     val status: Boolean,
                     @SerializedName("msg")
                     val message: String,
                     @SerializedName("data")
                     val data:List<LikePostData>){

    data class LikePostData(@SerializedName("LikeGiven")
                            val LikeGiven: String,
                            @SerializedName("TotalLike")
                            val TotalLike: String)

                     }
