package com.justforentrepreneurs.j4eapp.abmainj4e.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private val client = OkHttpClient.Builder().cache(null).build()


    private val retrofit = Retrofit.Builder()
            //.baseUrl("https://applex360.co.in/j4e_new/api/v1/")
            .baseUrl("https://just4entrepreneurs.com/admin/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}