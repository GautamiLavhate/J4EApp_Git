package com.justforentrepreneurs.j4eapp.abmainj4e.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u001a\u0006\u0010\u0013\u001a\u00020\u000f\u001a\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\b\b\u0001\u0010\u0015\u001a\u00020\u0016\u001a\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\t\u001a\"\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0016\u001a\u0010\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\t\u001a\u0010\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\t\u001a\u000e\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0010\u001a\u00020\u0001H\u0007\u001a\u001a\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00012\b\u0010$\u001a\u0004\u0018\u00010\t\u001a\u000e\u0010%\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0010\u0010&\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\'\u001a\"\u0010(\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\b\u0010$\u001a\u0004\u0018\u00010\t2\b\u0010)\u001a\u0004\u0018\u00010\t\u001a\u0010\u0010*\u001a\u0004\u0018\u00010\t2\u0006\u0010+\u001a\u00020\t\"\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\"\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006,"}, d2 = {"context1", "Landroid/content/Context;", "getContext1", "()Landroid/content/Context;", "setContext1", "(Landroid/content/Context;)V", "dialog", "Landroid/app/Dialog;", "mypref", "", "getMypref", "()Ljava/lang/String;", "setMypref", "(Ljava/lang/String;)V", "cleareUsingSharedPreference", "", "context", "cleareUsingSharedPreferenceOne", "name", "dismissLoader", "displayToast", "message", "", "endcodeToBase64", "image", "Landroid/graphics/Bitmap;", "compressFormat", "Landroid/graphics/Bitmap$CompressFormat;", "quality", "fmt", "s", "fmtone", "hideSoftKeybord", "isInternetAvailable", "", "readUsingSharedPreference", "key", "showLoader", "showLoaderf", "Landroidx/fragment/app/FragmentActivity;", "storeUsingSharedPreference", "value", "wordFirstCap", "str", "app_debug"})
public final class AcessDataDirectlyKt {
    private static android.app.Dialog dialog;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String mypref = "J4E";
    @org.jetbrains.annotations.Nullable()
    private static android.content.Context context1;
    
    public static final void displayToast(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public static final void displayToast(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @androidx.annotation.StringRes()
    int message) {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    public static final boolean isInternetAvailable(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public static final void showLoader(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public static final void showLoaderf(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentActivity context) {
    }
    
    public static final void dismissLoader() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getMypref() {
        return null;
    }
    
    public static final void setMypref(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final android.content.Context getContext1() {
        return null;
    }
    
    public static final void setContext1(@org.jetbrains.annotations.Nullable()
    android.content.Context p0) {
    }
    
    public static final void storeUsingSharedPreference(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String key, @org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String readUsingSharedPreference(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String key) {
        return null;
    }
    
    public static final void cleareUsingSharedPreference(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public static final void cleareUsingSharedPreferenceOne(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String name) {
    }
    
    public static final void hideSoftKeybord(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String endcodeToBase64(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap image, @org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap.CompressFormat compressFormat, int quality) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String fmt(@org.jetbrains.annotations.NotNull()
    java.lang.String s) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String fmtone(@org.jetbrains.annotations.NotNull()
    java.lang.String s) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String wordFirstCap(@org.jetbrains.annotations.NotNull()
    java.lang.String str) {
        return null;
    }
}