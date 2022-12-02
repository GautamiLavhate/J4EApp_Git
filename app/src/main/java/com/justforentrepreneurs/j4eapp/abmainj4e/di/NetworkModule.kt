package com.justforentrepreneurs.j4eapp.abmainj4e.di

import com.justforentrepreneurs.j4eapp.abmainj4e.network.api.ApiService
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.ApiConstants
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val NetworkModule = module {

    single { createApiService(get()) }

    single { createRetrofit(get(), ApiConstants.BASE_URL) }

    single { createOkHttpClient() }

}

private fun createOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().also {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        it.addInterceptor(loggingInterceptor)
        it.connectTimeout(1, TimeUnit.MINUTES)
        it.readTimeout(1, TimeUnit.MINUTES)
    }.build()
}

private fun createRetrofit(okHttpClient: OkHttpClient, bashUrl: String): Retrofit {
    val gson = GsonBuilder()
        .setLenient()
        .create()
    return Retrofit.Builder()
        .baseUrl(bashUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(CoroutineCallAdapterFactory()).build()
}

fun createApiService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}