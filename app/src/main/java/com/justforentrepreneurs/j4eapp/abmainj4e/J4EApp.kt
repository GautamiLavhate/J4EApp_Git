package com.justforentrepreneurs.j4eapp.abmainj4e

import android.app.Application
import com.justforentrepreneurs.j4eapp.abmainj4e.di.AppModule
import com.justforentrepreneurs.j4eapp.abmainj4e.di.NetworkModule
import com.justforentrepreneurs.j4eapp.abmainj4e.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class J4EApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoinDi()
    }

    private fun startKoinDi() {
        startKoin {
            androidLogger()
            androidContext(this@J4EApp)
            modules(
                listOf(
                    AppModule,
                    NetworkModule,
                    ViewModelModule
                )
            )
        }
    }

}