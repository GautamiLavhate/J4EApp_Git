package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u0018\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/profile/adapter/AdapterBusinessCard;", "Landroidx/viewpager/widget/PagerAdapter;", "activity", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/profile/BusinessCardActivity;", "image_url", "", "", "(Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/profile/BusinessCardActivity;Ljava/util/List;)V", "inflater", "Landroid/view/LayoutInflater;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mData2", "scaleFactor", "", "scaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "destroyItem", "", "container", "Landroid/view/View;", "position", "", "object", "", "getCount", "instantiateItem", "isViewFromObject", "", "view", "app_debug"})
public final class AdapterBusinessCard extends androidx.viewpager.widget.PagerAdapter {
    private android.view.LayoutInflater inflater;
    private java.util.List<java.lang.String> mData2;
    @org.jetbrains.annotations.Nullable()
    private android.content.Context mContext;
    private android.view.ScaleGestureDetector scaleGestureDetector;
    private float scaleFactor = 1.0F;
    
    public AdapterBusinessCard(@org.jetbrains.annotations.Nullable()
    com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.BusinessCardActivity activity, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> image_url) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.Nullable()
    android.content.Context p0) {
    }
    
    @java.lang.Override()
    public boolean isViewFromObject(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    java.lang.Object object) {
        return false;
    }
    
    @java.lang.Override()
    public int getCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.Object instantiateItem(@org.jetbrains.annotations.NotNull()
    android.view.View container, int position) {
        return null;
    }
    
    @java.lang.Override()
    public void destroyItem(@org.jetbrains.annotations.NotNull()
    android.view.View container, int position, @org.jetbrains.annotations.NotNull()
    java.lang.Object object) {
    }
}