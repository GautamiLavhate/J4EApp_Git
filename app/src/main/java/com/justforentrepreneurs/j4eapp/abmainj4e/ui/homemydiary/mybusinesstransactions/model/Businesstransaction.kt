package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mybusinesstransactions.model

import com.google.gson.annotations.SerializedName

data class Businesstransaction(   @SerializedName("status")
                                  val status: Boolean,
                                  @SerializedName("msg")
                                  val message: String,
                                  @SerializedName("data")
                                  val data:List<AllData>,
                                  @SerializedName("count_available")
                                  val count_available: Int){

    data class AllData(  @SerializedName("TransactionData")
                         val TransactionData:List<TransactionData>,
                         @SerializedName("TransactionInfo")
                         val TransactionInfo:List<TransactionInfo>)

    data class TransactionData(  @SerializedName("total_amount")
                                 val total_amount: String,
                                 @SerializedName("receive_amount")
                                 val receive_amount: String,
                                 @SerializedName("given_amount")
                                 val given_amount: String)

    data class TransactionInfo( @SerializedName("transaction_id")
                             val transaction_id: String,
                             @SerializedName("user_id")
                             val user_id: String,
                             @SerializedName("user_name")
                             val user_name: String,
                             @SerializedName("user_profile")
                             val user_profile: String,
                             @SerializedName("transaction_type")
                             val transaction_type: String,
                             @SerializedName("transaction_amount")
                             val transaction_amount: String,
                             @SerializedName("transaction_date")
                             val transaction_date: String,
                            @SerializedName("payment_type")
                            val payment_type: String,
                               @SerializedName("is_viewed")
                                val is_viewed: Int)

}
