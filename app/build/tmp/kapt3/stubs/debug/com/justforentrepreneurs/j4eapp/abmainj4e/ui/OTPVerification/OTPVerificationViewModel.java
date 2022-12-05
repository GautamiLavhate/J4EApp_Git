package com.justforentrepreneurs.j4eapp.abmainj4e.ui.OTPVerification;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0000\u00a2\u0006\u0002\b\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/OTPVerification/OTPVerificationViewModel;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/base/BaseViewModel;", "context", "Landroid/content/Context;", "apiService", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/network/api/ApiService;", "dataManager", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/data/DataManager;", "(Landroid/content/Context;Lcom/justforentrepreneurs/j4eapp/abmainj4e/network/api/ApiService;Lcom/justforentrepreneurs/j4eapp/abmainj4e/data/DataManager;)V", "tag", "", "kotlin.jvm.PlatformType", "validateData", "", "otp", "validateData$app_debug", "app_debug"})
public final class OTPVerificationViewModel extends com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseViewModel {
    private final android.content.Context context = null;
    private final com.justforentrepreneurs.j4eapp.abmainj4e.network.api.ApiService apiService = null;
    private final com.justforentrepreneurs.j4eapp.abmainj4e.data.DataManager dataManager = null;
    private final java.lang.String tag = null;
    
    public OTPVerificationViewModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.abmainj4e.network.api.ApiService apiService, @org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.abmainj4e.data.DataManager dataManager) {
        super();
    }
    
    public final boolean validateData$app_debug(@org.jetbrains.annotations.NotNull()
    java.lang.String otp) {
        return false;
    }
}