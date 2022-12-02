package com.justforentrepreneurs.j4eapp.abmainj4e.network.api

import com.justforentrepreneurs.j4eapp.abmainj4e.network.model.AppUserAccDetailModel
import com.justforentrepreneurs.j4eapp.abmainj4e.network.model.LoginRegisterModel
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.OTPVerification.OTPVerifyModel
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.GeneralModel
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.ProfileAboutModel
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.ApiConstants
import kotlinx.coroutines.Deferred
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("mobile_signin")
    @FormUrlEncoded
    fun mobileLogin(
        @Field(ApiConstants.mobile) mobileNum: String
    ): Deferred<Response<LoginRegisterModel>>

    @FormUrlEncoded
    @POST("social_login")
    fun socialLogin(
        @Field(ApiConstants.socialid) socialId: String,
        @Field(ApiConstants.social_type) socialType: String,
        @Field(ApiConstants.first_name) firstName: String,
        @Field(ApiConstants.last_name) lastName: String,
        @Field(ApiConstants.email) email: String,
        @Field("device_type") device_type: String,
        @Field("device_token") device_token: String
    ): Deferred<Response<OTPVerifyModel>>

    @POST("app_user_account_details")
    @FormUrlEncoded
    fun getAppUserAccDetail(
        @Field(ApiConstants.userid) userId: String
    ): Deferred<Response<AppUserAccDetailModel>>

    @POST("app_user_view_profile_about")
    @FormUrlEncoded
    fun getAppUserAccAbout(
        @Field(ApiConstants.userid) userId: String
    ): Deferred<Response<ProfileAboutModel>>

//    @Headers("Content-Type: multipart/form-data")
//    @POST("app_user_edit_profile_about")
//    @Multipart
//    fun EditProfileAbout(
//        @Part(ApiConstants.userid) userid: String,
//        @Part(ApiConstants.company_name) company_name: String,
//        @Part("about_company") about_company: String,
//        @Part("business_entity") business_entity: String,
//        @Part("business_type") business_type: String,
//        @Part("business_experties") business_experties: String,
//        @Part("working_from") working_from: String,
//        @Part("no_of_employees") no_of_employees: String,
//        @Part("expected_turnover") expected_turnover: String,
//        @Part("target_audiance") target_audiance: String,
//        @Part("membership_title") membership_title: String
////        @Part company_profile: MultipartBody.Part,
////        @Part company_ppt: MultipartBody.Part
//    ): Deferred<Response<GeneralModel>>
    @Multipart
    @POST("app_user_edit_profile_about")
    fun EditProfileAbout(
    @Part(ApiConstants.userid) userid: RequestBody,
    @Part(ApiConstants.company_name) company_name: RequestBody,
    @Part("about_company") about_company: RequestBody,
    @Part("business_entity") business_entity: RequestBody,
    @Part("business_type") business_type: RequestBody,
    @Part("business_experties") business_experties: RequestBody,
    @Part("working_from") working_from: RequestBody,
    @Part("no_of_employees") no_of_employees: RequestBody,
    @Part("expected_turnover") expected_turnover: RequestBody,
    @Part("target_audiance") target_audiance: RequestBody,
    @Part("membership_title") membership_title: RequestBody,
    @Part company_profile: MultipartBody.Part,
    @Part company_ppt: MultipartBody.Part
    ): Deferred<Response<GeneralModel>>
}