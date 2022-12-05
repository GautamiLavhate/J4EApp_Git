package com.justforentrepreneurs.j4eapp.abmainj4e.ui.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J(\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J \u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0017H\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0002J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\b\u0010(\u001a\u00020\u0015H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0005R\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\n\"\u0004\b\r\u0010\u0005R\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\u0005R\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\u0005R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\u0005R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/home/FragAllLeads;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/base/BaseFragment;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/home/Adapter/AdapterAllLead$OnClick2;", "position", "", "(I)V", "binding", "Lcom/justforentrepreneurs/j4eapp/databinding/FragAllLeadsBinding;", "count_available", "getCount_available", "()I", "setCount_available", "is_buddy_meet_exhausted", "set_buddy_meet_exhausted", "is_post_exhausted", "set_post_exhausted", "is_referral_exhausted", "set_referral_exhausted", "is_requirement_exhausted", "set_requirement_exhausted", "OnClick", "", "data", "", "requser", "is_viewed", "OnClickpro", "viewed", "PermissionDialog", "massage", "app_check_permissions", "getAllLeads", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "recyclerData", "app_debug"})
public final class FragAllLeads extends com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseFragment implements com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.Adapter.AdapterAllLead.OnClick2 {
    private com.justforentrepreneurs.j4eapp.databinding.FragAllLeadsBinding binding;
    private final int position = 0;
    private int count_available = -1;
    private int is_post_exhausted = -1;
    private int is_requirement_exhausted = -1;
    private int is_buddy_meet_exhausted = -1;
    private int is_referral_exhausted = -1;
    private java.util.HashMap _$_findViewCache;
    
    public FragAllLeads(int position) {
        super();
    }
    
    public final int getCount_available() {
        return 0;
    }
    
    public final void setCount_available(int p0) {
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
    
    private final void recyclerData() {
    }
    
    private final void app_check_permissions() {
    }
    
    private final void getAllLeads() {
    }
    
    @java.lang.Override()
    public void OnClick(int position, @org.jetbrains.annotations.NotNull()
    java.lang.String data, @org.jetbrains.annotations.NotNull()
    java.lang.String requser, int is_viewed) {
    }
    
    @java.lang.Override()
    public void OnClickpro(int position, @org.jetbrains.annotations.NotNull()
    java.lang.String data, int viewed) {
    }
    
    private final void PermissionDialog(java.lang.String massage) {
    }
}