package com.justforentrepreneurs.j4eapp.abmainj4e.ui.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020$H\u0002J\b\u0010\'\u001a\u00020$H\u0002J\u0010\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020*H\u0016J&\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020$H\u0002J\b\u00103\u001a\u00020$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u00064"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/home/FragMyDiary;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/base/BaseFragment;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/justforentrepreneurs/j4eapp/databinding/FragMyDiaryBinding;", "is_buddy_meet_exhausted", "", "()I", "set_buddy_meet_exhausted", "(I)V", "is_post_exhausted", "set_post_exhausted", "is_referral_exhausted", "set_referral_exhausted", "is_requirement_exhausted", "set_requirement_exhausted", "mainActivity", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/home/MainActivity;", "getMainActivity", "()Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/home/MainActivity;", "setMainActivity", "(Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/home/MainActivity;)V", "new_ver", "", "getNew_ver", "()Ljava/lang/String;", "setNew_ver", "(Ljava/lang/String;)V", "stop", "", "getStop", "()Z", "setStop", "(Z)V", "UpdateDialog", "", "app_check_permissions", "getMydiary", "initListener", "onClick", "v", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStartAnimation", "showUpdateDialog", "app_debug"})
public final class FragMyDiary extends com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseFragment implements android.view.View.OnClickListener {
    private com.justforentrepreneurs.j4eapp.databinding.FragMyDiaryBinding binding;
    public com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity mainActivity;
    private boolean stop = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String new_ver = "";
    private int is_post_exhausted = -1;
    private int is_requirement_exhausted = -1;
    private int is_buddy_meet_exhausted = -1;
    private int is_referral_exhausted = -1;
    private java.util.HashMap _$_findViewCache;
    
    public FragMyDiary() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity getMainActivity() {
        return null;
    }
    
    public final void setMainActivity(@org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity p0) {
    }
    
    public final boolean getStop() {
        return false;
    }
    
    public final void setStop(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNew_ver() {
        return null;
    }
    
    public final void setNew_ver(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int is_post_exhausted() {
        return 0;
    }
    
    public final void set_post_exhausted(int p0) {
    }
    
    public final int is_requirement_exhausted() {
        return 0;
    }
    
    public final void set_requirement_exhausted(int p0) {
    }
    
    public final int is_buddy_meet_exhausted() {
        return 0;
    }
    
    public final void set_buddy_meet_exhausted(int p0) {
    }
    
    public final int is_referral_exhausted() {
        return 0;
    }
    
    public final void set_referral_exhausted(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void initListener() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    private final void getMydiary() {
    }
    
    private final void showUpdateDialog() {
    }
    
    private final void app_check_permissions() {
    }
    
    private final void UpdateDialog() {
    }
    
    private final void onStartAnimation() {
    }
}