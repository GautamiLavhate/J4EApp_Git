package com.justforentrepreneurs.j4eapp.abmainj4e.ui.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ6\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0014J\u0015\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0014H\u0000\u00a2\u0006\u0002\b R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/login/LoginViewModel;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/base/BaseViewModel;", "context", "Landroid/content/Context;", "apiService", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/network/api/ApiService;", "dataManager", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/data/DataManager;", "(Landroid/content/Context;Lcom/justforentrepreneurs/j4eapp/abmainj4e/network/api/ApiService;Lcom/justforentrepreneurs/j4eapp/abmainj4e/data/DataManager;)V", "isLoginCompleted", "Landroidx/lifecycle/MutableLiveData;", "", "isLoginCompleted$app_debug", "()Landroidx/lifecycle/MutableLiveData;", "setLoginCompleted$app_debug", "(Landroidx/lifecycle/MutableLiveData;)V", "isSocialLoginCompleted", "isSocialLoginCompleted$app_debug", "setSocialLoginCompleted$app_debug", "tag", "", "kotlin.jvm.PlatformType", "callSocialLoginApi", "", "firstName", "lastName", "socialId", "socialType", "email", "token", "validateData", "mobileNum", "validateData$app_debug", "app_debug"})
public final class LoginViewModel extends com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseViewModel {
    private final android.content.Context context = null;
    private final com.justforentrepreneurs.j4eapp.abmainj4e.network.api.ApiService apiService = null;
    private final com.justforentrepreneurs.j4eapp.abmainj4e.data.DataManager dataManager = null;
    private final java.lang.String tag = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> isLoginCompleted;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> isSocialLoginCompleted;
    
    public LoginViewModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.abmainj4e.network.api.ApiService apiService, @org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.abmainj4e.data.DataManager dataManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isLoginCompleted$app_debug() {
        return null;
    }
    
    public final void setLoginCompleted$app_debug(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isSocialLoginCompleted$app_debug() {
        return null;
    }
    
    public final void setSocialLoginCompleted$app_debug(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    public final boolean validateData$app_debug(@org.jetbrains.annotations.NotNull()
    java.lang.String mobileNum) {
        return false;
    }
    
    public final void callSocialLoginApi(@org.jetbrains.annotations.NotNull()
    java.lang.String firstName, @org.jetbrains.annotations.NotNull()
    java.lang.String lastName, @org.jetbrains.annotations.NotNull()
    java.lang.String socialId, @org.jetbrains.annotations.NotNull()
    java.lang.String socialType, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String token) {
    }
}