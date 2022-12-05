package com.justforentrepreneurs.j4eapp.abmainj4e.ui.splash;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u0012\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J-\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00042\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0!2\u0006\u0010\"\u001a\u00020#H\u0016\u00a2\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0017H\u0002J\b\u0010&\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\'"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/splash/SplashActivityJ4E;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/base/BaseActivityOP;", "()V", "PERMISSION_REQUEST_CODE", "", "binding", "Lcom/justforentrepreneurs/j4eapp/databinding/ActivitySplashJ4eBinding;", "find", "", "getFind", "()Ljava/lang/String;", "setFind", "(Ljava/lang/String;)V", "param", "getParam", "setParam", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "checkAuth", "", "checkPermissions", "", "checkUserRequestedDontAskAgain", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestPermissions", "showAlertDialog", "app_debug"})
public final class SplashActivityJ4E extends com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivityOP {
    private com.justforentrepreneurs.j4eapp.databinding.ActivitySplashJ4eBinding binding;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri uri;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String param;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String find = "no";
    private final int PERMISSION_REQUEST_CODE = 159;
    private java.util.HashMap _$_findViewCache;
    
    public SplashActivityJ4E() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getUri() {
        return null;
    }
    
    public final void setUri(@org.jetbrains.annotations.Nullable()
    android.net.Uri p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getParam() {
        return null;
    }
    
    public final void setParam(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFind() {
        return null;
    }
    
    public final void setFind(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void checkAuth() {
    }
    
    public final boolean checkPermissions() {
        return false;
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final void requestPermissions() {
    }
    
    private final void showAlertDialog() {
    }
    
    private final void checkUserRequestedDontAskAgain() {
    }
}