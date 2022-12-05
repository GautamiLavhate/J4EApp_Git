package com.justforentrepreneurs.j4eapp.abmainj4e.ui.allmembers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B3\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\u0018\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0006H\u0016J\u001e\u0010&\u001a\u00020\u001a2\u0016\u0010\'\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nR\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006)"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/allmembers/AdapterAllMembers;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "activity", "Landroidx/fragment/app/FragmentActivity;", "is_connection_exhausted", "", "linksList", "Ljava/util/ArrayList;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/allmembers/model/MemberInfo;", "Lkotlin/collections/ArrayList;", "(Landroidx/fragment/app/FragmentActivity;ILjava/util/ArrayList;)V", "exhausted", "getExhausted", "()I", "setExhausted", "(I)V", "mBinding", "Lcom/justforentrepreneurs/j4eapp/databinding/AdapterJ4eMemberBinding;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "PermissionDialog", "", "massage", "", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setList", "postdetail", "ItemViewHolder", "app_debug"})
public final class AdapterAllMembers extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private java.util.ArrayList<com.justforentrepreneurs.j4eapp.abmainj4e.ui.allmembers.model.MemberInfo> linksList;
    private com.justforentrepreneurs.j4eapp.databinding.AdapterJ4eMemberBinding mBinding;
    @org.jetbrains.annotations.Nullable()
    private android.content.Context mContext;
    private int exhausted;
    
    public AdapterAllMembers(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentActivity activity, int is_connection_exhausted, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.justforentrepreneurs.j4eapp.abmainj4e.ui.allmembers.model.MemberInfo> linksList) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.Nullable()
    android.content.Context p0) {
    }
    
    public final int getExhausted() {
        return 0;
    }
    
    public final void setExhausted(int p0) {
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.justforentrepreneurs.j4eapp.abmainj4e.ui.allmembers.model.MemberInfo> postdetail) {
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
    
    private final void PermissionDialog(java.lang.String massage) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/allmembers/AdapterAllMembers$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "mBinding", "Lcom/justforentrepreneurs/j4eapp/databinding/AdapterJ4eMemberBinding;", "(Landroid/view/View;Lcom/justforentrepreneurs/j4eapp/databinding/AdapterJ4eMemberBinding;)V", "getMBinding", "()Lcom/justforentrepreneurs/j4eapp/databinding/AdapterJ4eMemberBinding;", "app_debug"})
    public static final class ItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.justforentrepreneurs.j4eapp.databinding.AdapterJ4eMemberBinding mBinding = null;
        
        public ItemViewHolder(@org.jetbrains.annotations.Nullable()
        android.view.View itemView, @org.jetbrains.annotations.NotNull()
        com.justforentrepreneurs.j4eapp.databinding.AdapterJ4eMemberBinding mBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.justforentrepreneurs.j4eapp.databinding.AdapterJ4eMemberBinding getMBinding() {
            return null;
        }
    }
}