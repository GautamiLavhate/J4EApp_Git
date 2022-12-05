package com.justforentrepreneurs.j4eapp.abmainj4e.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/data/DataManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "editor", "Landroid/content/SharedPreferences$Editor;", "sharedPref", "Landroid/content/SharedPreferences;", "clearData", "", "getUserData", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/network/model/LoginRegisterModel;", "isLogin", "", "isSocialLogin", "setIsLogin", "setIsSocialLogin", "setUserData", "response", "app_debug"})
public final class DataManager {
    private final android.content.SharedPreferences sharedPref = null;
    private final android.content.SharedPreferences.Editor editor = null;
    
    public DataManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void setIsLogin(boolean isLogin) {
    }
    
    public final boolean isLogin() {
        return false;
    }
    
    public final void setIsSocialLogin(boolean isSocialLogin) {
    }
    
    public final boolean isSocialLogin() {
        return false;
    }
    
    public final void setUserData(@org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.abmainj4e.network.model.LoginRegisterModel response) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.justforentrepreneurs.j4eapp.abmainj4e.network.model.LoginRegisterModel getUserData() {
        return null;
    }
    
    public final void clearData() {
    }
}