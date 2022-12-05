package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.recommended;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J \u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010\u001a\u001a\u00020\rH\u0002J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\rH\u0002J&\u0010\u001f\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\rH\u0002J\b\u0010\'\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006("}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/recommended/FragRecommendedBy;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/base/BaseFragment;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/recommended/adapters/AdapterRecommendedBy$OnClick2;", "()V", "binding", "Lcom/justforentrepreneurs/j4eapp/databinding/FragRecommendedByBinding;", "count_available", "", "getCount_available", "()I", "setCount_available", "(I)V", "OnClickLead", "", "position", "data", "", "requser", "OnClickpro", "is_viewed", "PermissionDialog", "massage", "app_get_list_recommendations_by", "keyword", "sortby", "filterby", "filterBottomSheet", "hideKeyboard", "view", "Landroid/view/View;", "initListener", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "recyclerData", "sortBottomSheet", "app_debug"})
public final class FragRecommendedBy extends com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseFragment implements com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.recommended.adapters.AdapterRecommendedBy.OnClick2 {
    private com.justforentrepreneurs.j4eapp.databinding.FragRecommendedByBinding binding;
    private int count_available = -1;
    private java.util.HashMap _$_findViewCache;
    
    public FragRecommendedBy() {
        super();
    }
    
    public final int getCount_available() {
        return 0;
    }
    
    public final void setCount_available(int p0) {
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
    
    private final void app_get_list_recommendations_by(java.lang.String keyword, java.lang.String sortby, java.lang.String filterby) {
    }
    
    private final void initListener() {
    }
    
    private final void filterBottomSheet() {
    }
    
    private final void sortBottomSheet() {
    }
    
    @java.lang.Override()
    public void OnClickpro(int position, @org.jetbrains.annotations.NotNull()
    java.lang.String data, int is_viewed) {
    }
    
    @java.lang.Override()
    public void OnClickLead(int position, @org.jetbrains.annotations.NotNull()
    java.lang.String data, @org.jetbrains.annotations.NotNull()
    java.lang.String requser) {
    }
    
    private final void hideKeyboard(android.view.View view) {
    }
    
    private final void PermissionDialog(java.lang.String massage) {
    }
}