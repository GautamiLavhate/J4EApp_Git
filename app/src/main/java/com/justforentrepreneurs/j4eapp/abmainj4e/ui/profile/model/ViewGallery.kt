package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ViewGallery(
        @SerializedName("status")
        var status: Boolean,
        @SerializedName("msg")
        val message: String,
        @SerializedName("data")
        val data: Messageview
):Parcelable

@Parcelize
data class Messageview(
        @SerializedName("gallery_info")
        val gallery_info: List<GalleryInfo>,
        @SerializedName("is_gallery_exhausted")
        val is_gallery_exhausted: Int


): Parcelable

@Parcelize
data class GalleryInfo(
        @SerializedName("userid")
        var userid: String,
        @SerializedName("image_link")
        val image_link: String,
        @SerializedName("imageid")
        val imageid: String
): Parcelable
