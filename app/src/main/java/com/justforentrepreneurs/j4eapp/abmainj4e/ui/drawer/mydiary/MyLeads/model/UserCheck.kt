package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model

import com.google.gson.annotations.SerializedName

data class UserCheck( @SerializedName("status")
                      val status: Boolean,
                      @SerializedName("msg")
                      val message:String,
                      @SerializedName("data")
                      val Data:List<DataCheck> ){
    data class DataCheck( @SerializedName("Available")
                          val Available:String)
}
