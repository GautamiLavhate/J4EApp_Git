package com.justforentrepreneurs.j4eapp.abmainj4e.ui.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J4\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00072\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0014j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u000fJ\u0006\u0010\u0017\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001d\u001a\u00020\u000fH\u0016J\u0012\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u000e\u0010!\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\""}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/login/LoginActivity;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/base/BaseActivityOP;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/listener/AuthListener;", "()V", "binding", "Lcom/justforentrepreneurs/j4eapp/databinding/ActivityLoginBinding;", "token", "", "viewModel", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/login/LoginViewModel;", "getViewModel", "()Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/login/LoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "DeactivateDialog", "", "massage", "authData", "socialType", "loginDataHashMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getPrivacyAndPolicy", "getTermsAndConditionData", "loginWithFacebookClick", "view", "Landroid/view/View;", "loginWithGoogleClick", "loginWithLinkdinClick", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onGetOtpClick", "app_debug"})
public final class LoginActivity extends com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivityOP implements com.justforentrepreneurs.j4eapp.abmainj4e.listener.AuthListener {
    private com.justforentrepreneurs.j4eapp.databinding.ActivityLoginBinding binding;
    private final kotlin.Lazy viewModel$delegate = null;
    private java.lang.String token = "";
    private java.util.HashMap _$_findViewCache;
    
    public LoginActivity() {
        super();
    }
    
    private final com.justforentrepreneurs.j4eapp.abmainj4e.ui.login.LoginViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void onGetOtpClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void loginWithGoogleClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void loginWithFacebookClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void loginWithLinkdinClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void authData(@org.jetbrains.annotations.NotNull()
    java.lang.String socialType, @org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.String> loginDataHashMap) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    private final void DeactivateDialog(java.lang.String massage) {
    }
    
    public final void getTermsAndConditionData() {
    }
    
    public final void getPrivacyAndPolicy() {
    }
}