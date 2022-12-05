package com.justforentrepreneurs.j4eapp.abmainj4e.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u001eH\u0004J\b\u0010\u001f\u001a\u00020\u001eH\u0004J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\tH\u0004J\b\u0010\"\u001a\u00020\u001eH\u0004J\"\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010\'H\u0014J\u000e\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*J\u0012\u0010+\u001a\u00020\u001e2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\u0012\u0010.\u001a\u00020\u001c2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\u001eH\u0014J\b\u00102\u001a\u00020\u001eH\u0014J\b\u00103\u001a\u00020\u001eH\u0014J\b\u00104\u001a\u00020\u001eH\u0014J\b\u00105\u001a\u00020\u001eH\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/base/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/justforentrepreneurs/j4eapp/Base;", "()V", "apiService", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/network/api/ApiService;", "getApiService", "()Lcom/justforentrepreneurs/j4eapp/abmainj4e/network/api/ApiService;", "authListener", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/listener/AuthListener;", "dataManager", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/data/DataManager;", "getDataManager", "()Lcom/justforentrepreneurs/j4eapp/abmainj4e/data/DataManager;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "facebookCallbackManager", "Lcom/facebook/CallbackManager;", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "googleSignInRequestCode", "", "tag", "", "kotlin.jvm.PlatformType", "enablePresence", "", "facebookSignOut", "", "googleSignOut", "loginWithFacebook", "listener", "loginWithGoogle", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackClick", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "app_debug"})
public abstract class BaseActivity extends androidx.appcompat.app.AppCompatActivity implements com.justforentrepreneurs.j4eapp.Base {
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.disposables.CompositeDisposable disposables = null;
    private final java.lang.String tag = null;
    @org.jetbrains.annotations.NotNull()
    private final com.justforentrepreneurs.j4eapp.abmainj4e.data.DataManager dataManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.justforentrepreneurs.j4eapp.abmainj4e.network.api.ApiService apiService = null;
    private com.justforentrepreneurs.j4eapp.abmainj4e.listener.AuthListener authListener;
    private com.google.android.gms.auth.api.signin.GoogleSignInClient googleSignInClient;
    private final int googleSignInRequestCode = 909;
    private com.facebook.CallbackManager facebookCallbackManager;
    private java.util.HashMap _$_findViewCache;
    
    public BaseActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.disposables.CompositeDisposable getDisposables() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.justforentrepreneurs.j4eapp.abmainj4e.data.DataManager getDataManager() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.justforentrepreneurs.j4eapp.abmainj4e.network.api.ApiService getApiService() {
        return null;
    }
    
    protected final void loginWithGoogle() {
    }
    
    protected final void loginWithFacebook(@org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.abmainj4e.listener.AuthListener listener) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    protected final void googleSignOut() {
    }
    
    protected final void facebookSignOut() {
    }
    
    public final void onBackClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public abstract boolean enablePresence();
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable()
    android.view.Menu menu) {
        return false;
    }
}