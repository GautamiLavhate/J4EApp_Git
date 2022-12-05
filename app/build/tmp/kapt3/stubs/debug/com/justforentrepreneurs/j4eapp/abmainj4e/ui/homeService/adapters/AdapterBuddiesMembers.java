package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002#$B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006%"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/adapters/AdapterBuddiesMembers;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "activity", "Landroidx/fragment/app/FragmentActivity;", "companyName", "", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/j4emembers/model/Memberinfo;", "onClick2", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/adapters/AdapterBuddiesMembers$OnClick2;", "(Landroidx/fragment/app/FragmentActivity;Ljava/util/List;Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/adapters/AdapterBuddiesMembers$OnClick2;)V", "mBinding", "Lcom/justforentrepreneurs/j4eapp/databinding/AdapterLeadStatusCategoryBinding;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mData", "getOnClick2", "()Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/adapters/AdapterBuddiesMembers$OnClick2;", "setOnClick2", "(Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/adapters/AdapterBuddiesMembers$OnClick2;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ItemViewHolder", "OnClick2", "app_debug"})
public final class AdapterBuddiesMembers extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private com.justforentrepreneurs.j4eapp.databinding.AdapterLeadStatusCategoryBinding mBinding;
    private java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.Memberinfo> mData;
    @org.jetbrains.annotations.Nullable()
    private android.content.Context mContext;
    @org.jetbrains.annotations.NotNull()
    private com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters.AdapterBuddiesMembers.OnClick2 onClick2;
    
    public AdapterBuddiesMembers(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentActivity activity, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.Memberinfo> companyName, @org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters.AdapterBuddiesMembers.OnClick2 onClick2) {
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
    public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters.AdapterBuddiesMembers.OnClick2 getOnClick2() {
        return null;
    }
    
    public final void setOnClick2(@org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters.AdapterBuddiesMembers.OnClick2 p0) {
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/adapters/AdapterBuddiesMembers$OnClick2;", "", "OnClick", "", "position", "", "id", "app_debug"})
    public static abstract interface OnClick2 {
        
        public abstract void OnClick(@org.jetbrains.annotations.NotNull()
        java.lang.String position, @org.jetbrains.annotations.NotNull()
        java.lang.String id);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/adapters/AdapterBuddiesMembers$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "mBinding", "Lcom/justforentrepreneurs/j4eapp/databinding/AdapterLeadStatusCategoryBinding;", "(Landroid/view/View;Lcom/justforentrepreneurs/j4eapp/databinding/AdapterLeadStatusCategoryBinding;)V", "getMBinding", "()Lcom/justforentrepreneurs/j4eapp/databinding/AdapterLeadStatusCategoryBinding;", "app_debug"})
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