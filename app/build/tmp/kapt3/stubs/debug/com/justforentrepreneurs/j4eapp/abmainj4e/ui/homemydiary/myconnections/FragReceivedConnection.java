package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J \u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J.\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J\b\u0010 \u001a\u00020\u0014H\u0002J\u001e\u0010!\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J.\u0010\"\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\u0014H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e\u00a8\u0006-"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/myconnections/FragReceivedConnection;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/base/BaseFragment;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/OnClickLiner;", "fragment", "", "position", "", "(Ljava/lang/String;I)V", "binding", "Lcom/justforentrepreneurs/j4eapp/databinding/FragPendingConnectionBinding;", "count_available", "getCount_available", "()I", "setCount_available", "(I)V", "fragmentst", "recedata", "getRecedata", "setRecedata", "getRececidMember", "", "getSendMember", "getconnection_request_accept", "id", "senderid", "btd", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "getgetconnection_request_decline", "mdata", "", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/myconnections/Model/DataReceived;", "pos", "initListener", "onClickDcline", "onClickPos", "value", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "recyclerData", "app_debug"})
public final class FragReceivedConnection extends com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseFragment implements com.justforentrepreneurs.j4eapp.abmainj4e.OnClickLiner {
    private com.justforentrepreneurs.j4eapp.databinding.FragPendingConnectionBinding binding;
    private final java.lang.String fragmentst = null;
    private int recedata = 0;
    private final int position = 0;
    private int count_available = -1;
    private java.util.HashMap _$_findViewCache;
    
    public FragReceivedConnection(@org.jetbrains.annotations.NotNull()
    java.lang.String fragment, int position) {
        super();
    }
    
    public final int getRecedata() {
        return 0;
    }
    
    public final void setRecedata(int p0) {
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
    
    private final void getRececidMember() {
    }
    
    private final void initListener() {
    }
    
    @java.lang.Override()
    public void onClickPos(int pos, @org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    com.google.android.material.floatingactionbutton.FloatingActionButton btd, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.DataReceived> mdata) {
    }
    
    @java.lang.Override()
    public void onClickDcline(int pos, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.DataReceived> mdata) {
    }
    
    private final void getconnection_request_accept(java.lang.String id, java.lang.String senderid, com.google.android.material.floatingactionbutton.FloatingActionButton btd) {
    }
    
    private final void getgetconnection_request_decline(java.lang.String id, java.lang.String senderid, java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.DataReceived> mdata, int pos) {
    }
    
    private final void getSendMember() {
    }
}