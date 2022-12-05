package com.justforentrepreneurs.j4eapp.abmainj4e.network.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0096\u0001\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u00072\b\b\u0001\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\u0010\u001a\u00020\u00072\b\b\u0001\u0010\u0011\u001a\u00020\u00072\b\b\u0001\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u0013H\'J\u001e\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00040\u00032\b\b\u0001\u0010\u0017\u001a\u00020\u0018H\'J\u001e\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00040\u00032\b\b\u0001\u0010\u0017\u001a\u00020\u0018H\'J\u001e\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00040\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u0018H\'JZ\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00040\u00032\b\b\u0001\u0010 \u001a\u00020\u00182\b\b\u0001\u0010!\u001a\u00020\u00182\b\b\u0001\u0010\"\u001a\u00020\u00182\b\b\u0001\u0010#\u001a\u00020\u00182\b\b\u0001\u0010$\u001a\u00020\u00182\b\b\u0001\u0010%\u001a\u00020\u00182\b\b\u0001\u0010&\u001a\u00020\u0018H\'\u00a8\u0006\'"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/network/api/ApiService;", "", "EditProfileAbout", "Lkotlinx/coroutines/Deferred;", "Lretrofit2/Response;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/profile/model/GeneralModel;", "userid", "Lokhttp3/RequestBody;", "company_name", "about_company", "business_entity", "business_type", "business_experties", "working_from", "no_of_employees", "expected_turnover", "target_audiance", "membership_title", "company_profile", "Lokhttp3/MultipartBody$Part;", "company_ppt", "getAppUserAccAbout", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/profile/model/ProfileAboutModel;", "userId", "", "getAppUserAccDetail", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/network/model/AppUserAccDetailModel;", "mobileLogin", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/network/model/LoginRegisterModel;", "mobileNum", "socialLogin", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/OTPVerification/OTPVerifyModel;", "socialId", "socialType", "firstName", "lastName", "email", "device_type", "device_token", "app_debug"})
public abstract interface ApiService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.FormUrlEncoded()
    @retrofit2.http.POST(value = "mobile_signin")
    public abstract kotlinx.coroutines.Deferred<retrofit2.Response<com.justforentrepreneurs.j4eapp.abmainj4e.network.model.LoginRegisterModel>> mobileLogin(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "mobile")
    java.lang.String mobileNum);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "social_login")
    @retrofit2.http.FormUrlEncoded()
    public abstract kotlinx.coroutines.Deferred<retrofit2.Response<com.justforentrepreneurs.j4eapp.abmainj4e.ui.OTPVerification.OTPVerifyModel>> socialLogin(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "socialid")
    java.lang.String socialId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "social_type")
    java.lang.String socialType, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "first_name")
    java.lang.String firstName, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "last_name")
    java.lang.String lastName, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "email")
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "device_type")
    java.lang.String device_type, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "device_token")
    java.lang.String device_token);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.FormUrlEncoded()
    @retrofit2.http.POST(value = "app_user_account_details")
    public abstract kotlinx.coroutines.Deferred<retrofit2.Response<com.justforentrepreneurs.j4eapp.abmainj4e.network.model.AppUserAccDetailModel>> getAppUserAccDetail(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "userid")
    java.lang.String userId);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.FormUrlEncoded()
    @retrofit2.http.POST(value = "app_user_view_profile_about")
    public abstract kotlinx.coroutines.Deferred<retrofit2.Response<com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.ProfileAboutModel>> getAppUserAccAbout(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "userid")
    java.lang.String userId);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "app_user_edit_profile_about")
    @retrofit2.http.Multipart()
    public abstract kotlinx.coroutines.Deferred<retrofit2.Response<com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.GeneralModel>> EditProfileAbout(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "userid")
    okhttp3.RequestBody userid, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "company_name")
    okhttp3.RequestBody company_name, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "about_company")
    okhttp3.RequestBody about_company, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "business_entity")
    okhttp3.RequestBody business_entity, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "business_type")
    okhttp3.RequestBody business_type, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "business_experties")
    okhttp3.RequestBody business_experties, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "working_from")
    okhttp3.RequestBody working_from, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "no_of_employees")
    okhttp3.RequestBody no_of_employees, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "expected_turnover")
    okhttp3.RequestBody expected_turnover, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "target_audiance")
    okhttp3.RequestBody target_audiance, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "membership_title")
    okhttp3.RequestBody membership_title, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part()
    okhttp3.MultipartBody.Part company_profile, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part()
    okhttp3.MultipartBody.Part company_ppt);
}