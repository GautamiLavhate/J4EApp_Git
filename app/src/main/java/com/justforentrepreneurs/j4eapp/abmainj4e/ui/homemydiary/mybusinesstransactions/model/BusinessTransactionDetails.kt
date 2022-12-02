package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mybusinesstransactions.model

import com.google.gson.annotations.SerializedName

data class BusinessTransactionDetails(@SerializedName("status")
                                      val status: Boolean,
                                      @SerializedName("msg")
                                      val message: String,
                                      @SerializedName("data")
                                      val data:TransactionInfodata){

    data class TransactionInfodata( @SerializedName("user_name")
                                val user_name: String,
                                @SerializedName("user_profile")
                                val user_profile: String,
                                @SerializedName("transaction_type")
                                val transaction_type: String,
                                @SerializedName("transaction_title")
                                val transaction_title: String,
                                @SerializedName("transaction_remark")
                                val transaction_remark: String,
                                @SerializedName("transaction_amount")
                                val transaction_amount: String,
                                @SerializedName("transaction_date")
                                val transaction_date: String,
                                @SerializedName("transaction_no")
                                val transaction_no: String,
                                @SerializedName("transaction_status")
                                val transaction_status: String) }
