package com.justforentrepreneurs.j4eapp.abmainj4e.ui.OTPVerification

import android.content.Context
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseViewModel
import com.justforentrepreneurs.j4eapp.abmainj4e.data.DataManager
import com.justforentrepreneurs.j4eapp.abmainj4e.network.api.ApiService
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.displayToast

class OTPVerificationViewModel(
    private val context: Context,
    private val apiService: ApiService,
    private val dataManager: DataManager
) : BaseViewModel() {

    private val tag = OTPVerificationViewModel::class.java.simpleName

    internal fun validateData(otp: String): Boolean {
        return when {
            otp.isBlank() -> {
                displayToast(context, context.getString(R.string.error_empty_otp))
                false
            }
            otp.length < 4 -> {
                displayToast(context, context.getString(R.string.error_invalid_otp))
                return false
            }
            else -> true
        }
    }

}