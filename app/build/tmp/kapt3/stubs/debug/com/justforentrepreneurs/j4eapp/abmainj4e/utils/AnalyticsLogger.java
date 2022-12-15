package com.justforentrepreneurs.j4eapp.abmainj4e.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\nH&J\u001c\u0010\u000b\u001a\u00020\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\nH&J\b\u0010\r\u001a\u00020\u0003H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH&\u00a8\u0006\u0012"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/utils/AnalyticsLogger;", "", "init", "", "context", "Landroid/content/Context;", "logEvent", "eventName", "", "params", "", "loginUser", "userData", "logoutUser", "setCurrentScreen", "activity", "Landroid/app/Activity;", "screenName", "app_debug"})
public abstract interface AnalyticsLogger {
    
    public abstract void init(@org.jetbrains.annotations.NotNull()
    android.content.Context context);
    
    public abstract void loginUser(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> userData);
    
    public abstract void logoutUser();
    
    public abstract void logEvent(@org.jetbrains.annotations.NotNull()
    java.lang.String eventName, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> params);
    
    public abstract void setCurrentScreen(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String screenName);
}