package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.Adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002/0B5\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\b\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020%2\u0006\u0010\'\u001a\u00020%H\u0016J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\'\u001a\u00020%H\u0016J\u0018\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020%H\u0016R\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012\u00a8\u00061"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/mydiary/MyLeads/Adapter/AdapterRecommendPersonlLeadDetails;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "activity", "Landroidx/fragment/app/FragmentActivity;", "companyName", "", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/mydiary/MyLeads/model/UserData;", "leadreqheck", "", "requiredid", "onClick2", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/mydiary/MyLeads/MyLeadsDetailActivity;", "(Landroidx/fragment/app/FragmentActivity;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/mydiary/MyLeads/MyLeadsDetailActivity;)V", "Leadcheck", "getLeadcheck", "()Ljava/lang/String;", "setLeadcheck", "(Ljava/lang/String;)V", "mBinding", "Lcom/justforentrepreneurs/j4eapp/databinding/RecommendedPersonRvAdapterBinding;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mData", "onClick3", "getOnClick3", "()Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/mydiary/MyLeads/MyLeadsDetailActivity;", "setOnClick3", "(Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/mydiary/MyLeads/MyLeadsDetailActivity;)V", "requiredids", "getRequiredids", "setRequiredids", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ItemViewHolder", "OnClick2", "app_debug"})
public final class AdapterRecommendPersonlLeadDetails extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private com.justforentrepreneurs.j4eapp.databinding.RecommendedPersonRvAdapterBinding mBinding;
    private java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model.UserData> mData;
    @org.jetbrains.annotations.Nullable()
    private android.content.Context mContext;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String Leadcheck;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String requiredids;
    @org.jetbrains.annotations.NotNull()
    private com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.MyLeadsDetailActivity onClick3;
    
    public AdapterRecommendPersonlLeadDetails(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentActivity activity, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model.UserData> companyName, @org.jetbrains.annotations.NotNull()
    java.lang.String leadreqheck, @org.jetbrains.annotations.NotNull()
    java.lang.String requiredid, @org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.MyLeadsDetailActivity onClick2) {
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
    public final java.lang.String getLeadcheck() {
        return null;
    }
    
    public final void setLeadcheck(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRequiredids() {
        return null;
    }
    
    public final void setRequiredids(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.MyLeadsDetailActivity getOnClick3() {
        return null;
    }
    
    public final void setOnClick3(@org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.MyLeadsDetailActivity p0) {
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u001e\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&\u00a8\u0006\r"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/mydiary/MyLeads/Adapter/AdapterRecommendPersonlLeadDetails$OnClick2;", "", "OnClick", "", "position", "", "data", "", "is_viewed", "OnClickDialog", "companyName", "", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/mydiary/MyLeads/model/RecomendedBy;", "app_debug"})
    public static abstract interface OnClick2 {
        
        public abstract void OnClick(int position, @org.jetbrains.annotations.NotNull()
        java.lang.String data, int is_viewed);
        
        public abstract void OnClickDialog(int position, @org.jetbrains.annotations.NotNull()
        java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model.RecomendedBy> companyName);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/mydiary/MyLeads/Adapter/AdapterRecommendPersonlLeadDetails$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "mBinding", "Lcom/justforentrepreneurs/j4eapp/databinding/RecommendedPersonRvAdapterBinding;", "(Landroid/view/View;Lcom/justforentrepreneurs/j4eapp/databinding/RecommendedPersonRvAdapterBinding;)V", "getMBinding", "()Lcom/justforentrepreneurs/j4eapp/databinding/RecommendedPersonRvAdapterBinding;", "app_debug"})
    public static final class ItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.justforentrepreneurs.j4eapp.databinding.RecommendedPersonRvAdapterBinding mBinding = null;
        
        public ItemViewHolder(@org.jetbrains.annotations.Nullable()
        android.view.View itemView, @org.jetbrains.annotations.NotNull()
        com.justforentrepreneurs.j4eapp.databinding.RecommendedPersonRvAdapterBinding mBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.justforentrepreneurs.j4eapp.databinding.RecommendedPersonRvAdapterBinding getMBinding() {
            return null;
        }
    }
}