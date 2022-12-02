package com.justforentrepreneurs.j4eapp.abmainj4e.di

import com.justforentrepreneurs.j4eapp.abmainj4e.ui.OTPVerification.OTPVerificationViewModel
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.login.LoginViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {

    viewModel { LoginViewModel(androidContext(), get(), get()) }
    viewModel { OTPVerificationViewModel(androidContext(), get(), get()) }

}
