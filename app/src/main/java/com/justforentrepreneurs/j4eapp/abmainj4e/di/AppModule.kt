package com.justforentrepreneurs.j4eapp.abmainj4e.di

import com.justforentrepreneurs.j4eapp.abmainj4e.data.DataManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val AppModule = module {

    single { DataManager(androidContext()) }

}