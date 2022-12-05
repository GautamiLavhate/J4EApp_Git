package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B5\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000bH\u0002J\b\u0010%\u001a\u00020\rH\u0016J\u0010\u0010&\u001a\u00020\r2\u0006\u0010\'\u001a\u00020\rH\u0016J\u0018\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010\'\u001a\u00020\rH\u0016J\u0018\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\rH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/myconnections/Adapter/AdapterSentConnection;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "activity", "Landroidx/fragment/app/FragmentActivity;", "companyName", "", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/myconnections/Model/DataReceived;", "OnClicklk", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/OnClickLiner;", "fragment", "", "count_available", "", "(Landroidx/fragment/app/FragmentActivity;Ljava/util/List;Lcom/justforentrepreneurs/j4eapp/abmainj4e/OnClickLiner;Ljava/lang/String;I)V", "getOnClicklk", "()Lcom/justforentrepreneurs/j4eapp/abmainj4e/OnClickLiner;", "setOnClicklk", "(Lcom/justforentrepreneurs/j4eapp/abmainj4e/OnClickLiner;)V", "count_available1", "getCount_available1", "()I", "setCount_available1", "(I)V", "fragmentst", "mBinding", "Lcom/justforentrepreneurs/j4eapp/databinding/AdapterSentConnectionBinding;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mData", "PermissionDialog", "", "massage", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ItemViewHolder", "app_debug"})
public final class AdapterSentConnection extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private com.justforentrepreneurs.j4eapp.abmainj4e.OnClickLiner OnClicklk;
    private com.justforentrepreneurs.j4eapp.databinding.AdapterSentConnectionBinding mBinding;
    private java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.DataReceived> mData;
    @org.jetbrains.annotations.Nullable()
    private android.content.Context mContext;
    private final java.lang.String fragmentst = null;
    private int count_available1;
    
    public AdapterSentConnection(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentActivity activity, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.DataReceived> companyName, @org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.abmainj4e.OnClickLiner OnClicklk, @org.jetbrains.annotations.NotNull()
    java.lang.String fragment, int count_available) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.justforentrepreneurs.j4eapp.abmainj4e.OnClickLiner getOnClicklk() {
        return null;
    }
    
    public final void setOnClicklk(@org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.abmainj4e.OnClickLiner p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.Nullable()
    android.content.Context p0) {
    }
    
    public final int getCount_available1() {
        return 0;
    }
    
    public final void setCount_available1(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    private final void PermissionDialog(java.lang.String massage) {
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/myconnections/Adapter/AdapterSentConnection$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "mBinding", "Lcom/justforentrepreneurs/j4eapp/databinding/AdapterSentConnectionBinding;", "(Landroid/view/View;Lcom/justforentrepreneurs/j4eapp/databinding/AdapterSentConnectionBinding;)V", "getMBinding", "()Lcom/justforentrepreneurs/j4eapp/databinding/AdapterSentConnectionBinding;", "app_debug"})
    public static final class ItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.justforentrepreneurs.j4eapp.databinding.AdapterSentConnectionBinding mBinding = null;
        
        public ItemViewHolder(@org.jetbrains.annotations.Nullable()
        android.view.View itemView, @org.jetbrains.annotations.NotNull()
        com.justforentrepreneurs.j4eapp.databinding.AdapterSentConnectionBinding mBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.justforentrepreneurs.j4eapp.databinding.AdapterSentConnectionBinding getMBinding() {
            return null;
        }
    }
}