package com.justforentrepreneurs.j4eapp.abmainj4e.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\nJ\"\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004J\u001a\u0010\"\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\nJ\"\u0010$\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006&"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/data/StaticDataStore;", "", "()V", "context1", "Landroid/content/Context;", "getContext1", "()Landroid/content/Context;", "setContext1", "(Landroid/content/Context;)V", "mypref", "", "getMypref", "()Ljava/lang/String;", "setMypref", "(Ljava/lang/String;)V", "orderHistoryFlag", "", "getOrderHistoryFlag", "()Z", "setOrderHistoryFlag", "(Z)V", "cleareUsingSharedPreference", "", "context", "cleareUsingSharedPreferenceOne", "name", "endcodeToBase64", "image", "Landroid/graphics/Bitmap;", "compressFormat", "Landroid/graphics/Bitmap$CompressFormat;", "quality", "", "hideSoftKeybord", "readUsingSharedPreference", "key", "storeUsingSharedPreference", "value", "app_debug"})
public final class StaticDataStore {
    private boolean orderHistoryFlag = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mypref = "J4E";
    @org.jetbrains.annotations.Nullable()
    private android.content.Context context1;
    
    public StaticDataStore() {
        super();
    }
    
    public final boolean getOrderHistoryFlag() {
        return false;
    }
    
    public final void setOrderHistoryFlag(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMypref() {
        return null;
    }
    
    public final void setMypref(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.Context getContext1() {
        return null;
    }
    
    public final void setContext1(@org.jetbrains.annotations.Nullable()
    android.content.Context p0) {
    }
    
    public final void storeUsingSharedPreference(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String key, @org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String readUsingSharedPreference(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String key) {
        return null;
    }
    
    public final void cleareUsingSharedPreference(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void cleareUsingSharedPreferenceOne(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String name) {
    }
    
    public final void hideSoftKeybord(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String endcodeToBase64(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap image, @org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap.CompressFormat compressFormat, int quality) {
        return null;
    }
}