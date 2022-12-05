package com.justforentrepreneurs.j4eapp.abmainj4e.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/utils/PrefManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "IS_FIRST_TIME_LAUNCH", "", "PREF_NAME", "PRIVATE_MODE", "", "getPRIVATE_MODE", "()I", "setPRIVATE_MODE", "(I)V", "_context", "get_context", "()Landroid/content/Context;", "set_context", "editor", "Landroid/content/SharedPreferences$Editor;", "getEditor", "()Landroid/content/SharedPreferences$Editor;", "setEditor", "(Landroid/content/SharedPreferences$Editor;)V", "pref", "Landroid/content/SharedPreferences;", "getPref", "()Landroid/content/SharedPreferences;", "setPref", "(Landroid/content/SharedPreferences;)V", "isFirstTimeLaunch", "", "setFirstTimeLaunch", "", "isFirstTime", "app_debug"})
public final class PrefManager {
    private int PRIVATE_MODE = 0;
    private final java.lang.String PREF_NAME = "J4EappV";
    private final java.lang.String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    @org.jetbrains.annotations.Nullable()
    private android.content.Context _context;
    @org.jetbrains.annotations.Nullable()
    private android.content.SharedPreferences pref;
    @org.jetbrains.annotations.Nullable()
    private android.content.SharedPreferences.Editor editor;
    
    public PrefManager(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        super();
    }
    
    public final int getPRIVATE_MODE() {
        return 0;
    }
    
    public final void setPRIVATE_MODE(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.Context get_context() {
        return null;
    }
    
    public final void set_context(@org.jetbrains.annotations.Nullable()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.SharedPreferences getPref() {
        return null;
    }
    
    public final void setPref(@org.jetbrains.annotations.Nullable()
    android.content.SharedPreferences p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.SharedPreferences.Editor getEditor() {
        return null;
    }
    
    public final void setEditor(@org.jetbrains.annotations.Nullable()
    android.content.SharedPreferences.Editor p0) {
    }
    
    public final void setFirstTimeLaunch(boolean isFirstTime) {
    }
    
    public final boolean isFirstTimeLaunch() {
        return false;
    }
}