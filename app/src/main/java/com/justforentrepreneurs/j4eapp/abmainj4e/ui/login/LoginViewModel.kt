package com.justforentrepreneurs.j4eapp.abmainj4e.ui.login

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseViewModel
import com.justforentrepreneurs.j4eapp.abmainj4e.data.DataManager
import com.justforentrepreneurs.j4eapp.abmainj4e.network.api.ApiService
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.dismissLoader
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.displayToast
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.storeUsingSharedPreference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(
    private val context: Context,
    private val apiService: ApiService,
    private val dataManager: DataManager
) : BaseViewModel() {

    private val tag = LoginViewModel::class.java.simpleName
    internal var isLoginCompleted: MutableLiveData<Boolean> = MutableLiveData()
    internal var isSocialLoginCompleted: MutableLiveData<Boolean> = MutableLiveData()

    internal fun validateData(mobileNum: String): Boolean {
        return when {
            mobileNum.isBlank() -> {
                displayToast(context, context.getString(R.string.error_empty_mobile_num))
                false
            }
            mobileNum.length < 10 -> {
                displayToast(context, context.getString(R.string.error_invalid_mobile_num))
                return false
            }
            else -> true
        }
    }


    fun callSocialLoginApi(
        firstName: String,
        lastName: String,
        socialId: String,
        socialType: String,
        email: String,
        token: String
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val requestApi = apiService.socialLogin(socialId, socialType, firstName, lastName, email,"Android",token)
            try {
                val response = requestApi.await()
                if (response.code() == 200) {
                    withContext(Dispatchers.Main) {
                        displayToast(context, response.body()?.msg.toString())
                    }

                    dismissLoader()

                    storeUsingSharedPreference(
                        context,
                        "userid",
                        response.body()?.data?.get(0)?.userdata?.id
                    )
                    storeUsingSharedPreference(
                        context,
                        "mobile",
                        response.body()?.data?.get(0)?.userdata?.phone.toString()
                    )
                    storeUsingSharedPreference(
                        context,
                        "type",
                        response.body()?.data?.get(0)?.userdata?.type.toString()
                    )
                    storeUsingSharedPreference(
                        context,
                        "companyphone",
                        response.body()?.data?.get(0)?.userdata?.company_number
                    )

                    storeUsingSharedPreference(
                        context,
                        "dob",
                        response.body()?.data?.get(0)?.userdata?.dob
                    )
                    storeUsingSharedPreference(
                        context,
                        "fullname",
                        response.body()?.data?.get(0)?.userdata?.first_name.toString() + " " + response.body()?.data?.get(0)?.userdata?.middle_name.toString() + " " + response.body()?.data?.get(0)?.userdata?.last_name.toString()
                    )
                    storeUsingSharedPreference(
                        context,
                        "company_name",
                        response.body()?.data?.get(0)?.userdata?.company.toString()
                    )
                    storeUsingSharedPreference(
                        context,
                        "company_address",
                        response.body()?.data?.get(0)?.userdata?.company_address.toString()
                    )
                    storeUsingSharedPreference(
                        context,
                        "designation",
                        response.body()?.data?.get(0)?.userdata?.designation.toString()
                    )

                    storeUsingSharedPreference(
                        context,
                        "firstname",
                        response.body()?.data?.get(0)?.userdata?.first_name.toString()
                    )
                    storeUsingSharedPreference(
                        context,
                        "meddlename",
                        response.body()?.data?.get(0)?.userdata?.middle_name.toString()
                    )
                    storeUsingSharedPreference(
                        context,
                        "lastname",
                        response.body()?.data?.get(0)?.userdata?.last_name.toString()
                    )

                    storeUsingSharedPreference(
                        context,
                        "profilepic",
                        "https://applex360.co.in/j4e_new/upload/avatar/" + response.body()?.data?.get(0)?.userdata?.avatar.toString()
                    )

                    storeUsingSharedPreference(
                        context,
                        "membertyype",
                        response.body()?.data?.get(0)?.userdata?.membership_type.toString()
                    )

                    storeUsingSharedPreference(
                        context,
                        "total_experience",
                        response.body()?.data?.get(0)?.userdata?.total_experience
                    )
                    storeUsingSharedPreference(
                        context,
                        "business_category",
                        response.body()?.data?.get(0)?.userdata?.business_category
                    )
                    storeUsingSharedPreference(
                        context,
                        "business_entity",
                        response.body()?.data?.get(0)?.userdata?.business_entity
                    )
                    storeUsingSharedPreference(
                        context,
                        "business_type",
                        response.body()?.data?.get(0)?.userdata?.business_type
                    )

                    storeUsingSharedPreference(
                        context,
                        "email",
                        response.body()?.data?.get(0)?.userdata?.email_address.toString()
                    )


                    storeUsingSharedPreference(
                        context,
                        "PostCountnew",response.body()?.data?.get(0)?.userdata?.notification_count?.post_count.toString()
                    )

                    storeUsingSharedPreference(
                        context,
                        "LeadCountnew",response.body()?.data?.get(0)?.userdata?.notification_count?.lead_count.toString()
                    )

                    storeUsingSharedPreference(
                        context,
                        "BuddyCountnew",response.body()?.data?.get(0)?.userdata?.notification_count?.buddy_count.toString()
                    )


                    storeUsingSharedPreference(
                        context,
                        "PostCountOld",response.body()?.data?.get(0)?.userdata?.notification_count?.post_count.toString()
                    )

                    storeUsingSharedPreference(
                        context,
                        "LeadCountOld",response.body()?.data?.get(0)?.userdata?.notification_count?.lead_count.toString()
                    )

                    storeUsingSharedPreference(
                        context,
                        "BuddyCountOld",response.body()?.data?.get(0)?.userdata?.notification_count?.buddy_count.toString()
                    )

                    storeUsingSharedPreference(
                        context,
                        "eventCountOld",response.body()?.data?.get(0)?.userdata?.notification_count?.event_count.toString()
                    )

                    storeUsingSharedPreference(
                        context,
                        "notificatCountOld",response.body()?.data?.get(0)?.userdata?.notification_count?.notificat_count.toString()
                    )

                    val Connection:Int=
                        response.body()?.data?.get(0)?.userdata?.notification_count?.connection_receive_count?.toInt()!! + response.body()?.data?.get(0)?.userdata?.notification_count?.connection_sent_count?.toInt()!!

                    storeUsingSharedPreference(
                        context,
                        "ConnectionCountOld", Connection.toString()
                    )



                    if (response.body()?.data?.get(0)?.userdata?.membership_type == "0") {
                        storeUsingSharedPreference(
                            context,
                            "loginStatus",
                            "false"
                        )

                    } else {
                        storeUsingSharedPreference(
                            context,
                            "loginStatus",
                            "true"
                        )

                    }

                    isSocialLoginCompleted.postValue(true)
                } else {
                    withContext(Dispatchers.Main) {
                        displayToast(context, context.resources.getString(R.string.error_something_wrong))
                    }
                }
                dismissLoader()
            } catch (e: Exception) {
                dismissLoader()
                Log.e(tag, e.message.toString())
            }
        }
    }


}