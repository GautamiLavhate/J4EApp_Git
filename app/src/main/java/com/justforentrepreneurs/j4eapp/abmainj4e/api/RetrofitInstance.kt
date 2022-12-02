package com.applexinfotech.digibizproapp.api

import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private var mInstance: RetrofitInstance? = null

    // <-- this is the important line!
    var apiInterface: APIinterface? = null
        get() {
            if (field == null) {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                val httpClient = OkHttpClient.Builder()
                httpClient.addInterceptor(logging) // <-- this is the important line!
                field = Retrofit.Builder()
                    .baseUrl("https://applex360.co.in/j4e_new/api/v1/")
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(APIinterface::class.java)
            }
            return field
        }
        private set

    val instance: RetrofitInstance?
        get() {
            if (mInstance == null) {
                mInstance = RetrofitInstance
            }
            return mInstance
        }
}