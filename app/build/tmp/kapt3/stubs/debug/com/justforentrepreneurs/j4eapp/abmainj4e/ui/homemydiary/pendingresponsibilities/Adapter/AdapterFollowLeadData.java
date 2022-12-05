package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.Adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002*+B-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0016J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020 H\u0016J\u0018\u0010&\u001a\u00020\u00022\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020 H\u0016R\u001a\u0010\r\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006,"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/pendingresponsibilities/Adapter/AdapterFollowLeadData;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "activity", "Landroidx/fragment/app/FragmentActivity;", "companyName", "", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/pendingresponsibilities/model/FollowUpLead$DataLead;", "onClick2", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/pendingresponsibilities/Adapter/AdapterFollowLeadData$OnClick2;", "Type", "", "(Landroidx/fragment/app/FragmentActivity;Ljava/util/List;Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/pendingresponsibilities/Adapter/AdapterFollowLeadData$OnClick2;Ljava/lang/String;)V", "Type1", "getType1", "()Ljava/lang/String;", "setType1", "(Ljava/lang/String;)V", "mBinding", "Lcom/justforentrepreneurs/j4eapp/databinding/AdapterLeadStatusCategoryBinding;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mData", "getOnClick2", "()Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/pendingresponsibilities/Adapter/AdapterFollowLeadData$OnClick2;", "setOnClick2", "(Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/pendingresponsibilities/Adapter/AdapterFollowLeadData$OnClick2;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ItemViewHolder", "OnClick2", "app_debug"})
public final class AdapterFollowLeadData extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private com.justforentrepreneurs.j4eapp.databinding.AdapterLeadStatusCategoryBinding mBinding;
    private java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.model.FollowUpLead.DataLead> mData;
    @org.jetbrains.annotations.Nullable()
    private android.content.Context mContext;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String Type1;
    @org.jetbrains.annotations.NotNull()
    private com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.Adapter.AdapterFollowLeadData.OnClick2 onClick2;
    
    public AdapterFollowLeadData(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentActivity activity, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.model.FollowUpLead.DataLead> companyName, @org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.Adapter.AdapterFollowLeadData.OnClick2 onClick2, @org.jetbrains.annotations.NotNull()
    java.lang.String Type) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.Nullable()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getType1() {
        return null;
    }
    
    public final void setType1(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.Adapter.AdapterFollowLeadData.OnClick2 getOnClick2() {
        return null;
    }
    
    public final void setOnClick2(@org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.Adapter.AdapterFollowLeadData.OnClick2 p0) {
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
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/pendingresponsibilities/Adapter/AdapterFollowLeadData$OnClick2;", "", "OnClick", "", "position", "", "id", "type", "app_debug"})
    public static abstract interface OnClick2 {
        
        public abstract void OnClick(@org.jetbrains.annotations.NotNull()
        java.lang.String position, @org.jetbrains.annotations.NotNull()
        java.lang.String id, @org.jetbrains.annotations.NotNull()
        java.lang.String type);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/pendingresponsibilities/Adapter/AdapterFollowLeadData$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "mBinding", "Lcom/justforentrepreneurs/j4eapp/databinding/AdapterLeadStatusCategoryBinding;", "(Landroid/view/View;Lcom/justforentrepreneurs/j4eapp/databinding/AdapterLeadStatusCategoryBinding;)V", "getMBinding", "()Lcom/justforentrepreneurs/j4eapp/databinding/AdapterLeadStatusCategoryBinding;", "app_debug"})
    public static final class ItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.justforentrepreneurs.j4eapp.databinding.AdapterLeadStatusCategoryBinding mBinding = null;
        
        public ItemViewHolder(@org.jetbrains.annotations.Nullable()
        android.view.View itemView, @org.jetbrains.annotations.NotNull()
        com.justforentrepreneurs.j4eapp.databinding.AdapterLeadStatusCategoryBinding mBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.justforentrepreneurs.j4eapp.databinding.AdapterLeadStatusCategoryBinding getMBinding() {
            return null;
        }
    }
}