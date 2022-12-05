package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B=\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010\'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0016J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010(\u001a\u00020&H\u0016J\u0018\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020&H\u0016R\u001a\u0010\u000f\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/mymembershipbenefits/adapter/AdapterFeatureCount;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "activity", "Landroidx/fragment/app/FragmentActivity;", "companyName", "", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/mymembershipbenefits/Model/Dataplan;", "CurrtMemberShip", "", "CurrtMemberShipCost", "Membership_seq_no", "OnClickPosPlan", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/mymembershipbenefits/interfacess/OnClickPlan;", "(Landroidx/fragment/app/FragmentActivity;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/mymembershipbenefits/interfacess/OnClickPlan;)V", "CurrentMembership_seq_no", "getCurrentMembership_seq_no", "()Ljava/lang/String;", "setCurrentMembership_seq_no", "(Ljava/lang/String;)V", "CurrtMemberShipCost1", "getCurrtMemberShipCost1", "setCurrtMemberShipCost1", "CurrtMemberShiped", "getCurrtMemberShiped", "setCurrtMemberShiped", "getOnClickPosPlan", "()Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/mymembershipbenefits/interfacess/OnClickPlan;", "mBinding", "Lcom/justforentrepreneurs/j4eapp/databinding/ItemMembershipFeatureBinding;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mData", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ItemViewHolder", "app_debug"})
public final class AdapterFeatureCount extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.interfacess.OnClickPlan OnClickPosPlan = null;
    private com.justforentrepreneurs.j4eapp.databinding.ItemMembershipFeatureBinding mBinding;
    private java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.Dataplan> mData;
    @org.jetbrains.annotations.Nullable()
    private android.content.Context mContext;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String CurrtMemberShiped;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String CurrtMemberShipCost1;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String CurrentMembership_seq_no;
    
    public AdapterFeatureCount(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentActivity activity, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.Dataplan> companyName, @org.jetbrains.annotations.NotNull()
    java.lang.String CurrtMemberShip, @org.jetbrains.annotations.NotNull()
    java.lang.String CurrtMemberShipCost, @org.jetbrains.annotations.NotNull()
    java.lang.String Membership_seq_no, @org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.interfacess.OnClickPlan OnClickPosPlan) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.interfacess.OnClickPlan getOnClickPosPlan() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.Nullable()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrtMemberShiped() {
        return null;
    }
    
    public final void setCurrtMemberShiped(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrtMemberShipCost1() {
        return null;
    }
    
    public final void setCurrtMemberShipCost1(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentMembership_seq_no() {
        return null;
    }
    
    public final void setCurrentMembership_seq_no(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/mymembershipbenefits/adapter/AdapterFeatureCount$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "mBinding", "Lcom/justforentrepreneurs/j4eapp/databinding/ItemMembershipFeatureBinding;", "(Landroid/view/View;Lcom/justforentrepreneurs/j4eapp/databinding/ItemMembershipFeatureBinding;)V", "getMBinding", "()Lcom/justforentrepreneurs/j4eapp/databinding/ItemMembershipFeatureBinding;", "app_debug"})
    public static final class ItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.justforentrepreneurs.j4eapp.databinding.ItemMembershipFeatureBinding mBinding = null;
        
        public ItemViewHolder(@org.jetbrains.annotations.Nullable()
        android.view.View itemView, @org.jetbrains.annotations.NotNull()
        com.justforentrepreneurs.j4eapp.databinding.ItemMembershipFeatureBinding mBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.justforentrepreneurs.j4eapp.databinding.ItemMembershipFeatureBinding getMBinding() {
            return null;
        }
    }
}