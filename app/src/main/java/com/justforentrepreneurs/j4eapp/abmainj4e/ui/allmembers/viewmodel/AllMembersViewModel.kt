package com.justforentrepreneurs.j4eapp.abmainj4e.ui.allmembers.viewmodel

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.applexinfotech.digibizproapp.api.RetrofitInstance
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.allmembers.model.AllMemberResponse
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.readUsingSharedPreference
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllMembersViewModel(application: Application) : AndroidViewModel(application) {
    private var viewAllMemberData: MutableLiveData<AllMemberResponse> ?= null
    fun viewAllMemberData(context: Context?, userid: String): LiveData<AllMemberResponse>? {
        if (viewAllMemberData == null) {
            viewAllMemberData = MutableLiveData<AllMemberResponse>()
            getAllMemberData(context, userid)
        }
        return viewAllMemberData
    }
    private fun getAllMemberData(context: Context?, userid: String) {
        if (context == null) return

        RetrofitInstance.apiInterface?.app_get_all_members_new(userid,"","")
            ?.enqueue(object : Callback<AllMemberResponse> {
                override fun onResponse(
                    @NonNull call: Call<AllMemberResponse>?,
                    @NonNull response: Response<AllMemberResponse>
                ) {
                    if (response.body() != null && response.body()!!.status == true) {
                        viewAllMemberData?.value = response.body()

//                        Toast.makeText(
//                            context,
//                            "Success View Services!",
//                            Toast.LENGTH_SHORT
//                        ).show()
                    } else {
                        Toast.makeText(context, R.string.places_try_again, Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(@NonNull call: Call<AllMemberResponse>?, t: Throwable) {
                    t.printStackTrace()
                }
            })
    }

}