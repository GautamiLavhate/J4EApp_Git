package com.justforentrepreneurs.j4eapp.abmainj4e.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u001c\u0010\u000f\u001a\u00020\u00062\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/utils/FirebaseAnalyticsLogger;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/utils/AnalyticsLogger;", "()V", "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "init", "", "context", "Landroid/content/Context;", "logEvent", "eventName", "", "params", "", "", "loginUser", "userData", "logoutUser", "setCurrentScreen", "activity", "Landroid/app/Activity;", "screenName", "app_debug"})
public final class FirebaseAnalyticsLogger implements com.justforentrepreneurs.j4eapp.abmainj4e.utils.AnalyticsLogger {
    @org.jetbrains.annotations.NotNull()
    public static final com.justforentrepreneurs.j4eapp.abmainj4e.utils.FirebaseAnalyticsLogger INSTANCE = null;
    private static com.google.firebase.analytics.FirebaseAnalytics firebaseAnalytics;
    
    private FirebaseAnalyticsLogger() {
        super();
    }
    
    @java.lang.Override()
    public void init(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void loginUser(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> userData) {
    }
    
    @java.lang.Override()
    public void logoutUser() {
    }
    
    @java.lang.Override()
    public void logEvent(@org.jetbrains.annotations.NotNull()
    java.lang.String eventName, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> params) {
    }
    
    @java.lang.Override()
    public void setCurrentScreen(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String screenName) {
    }
}