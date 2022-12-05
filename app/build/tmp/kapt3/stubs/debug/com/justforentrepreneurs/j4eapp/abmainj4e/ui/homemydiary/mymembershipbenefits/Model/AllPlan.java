package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J7\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0005H\u00d6\u0001R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006#"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/mymembershipbenefits/Model/AllPlan;", "", "status", "", "message", "", "data", "", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/mymembershipbenefits/Model/Dataplan;", "cover_image", "(ZLjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCover_image", "()Ljava/lang/String;", "setCover_image", "(Ljava/lang/String;)V", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getMessage", "setMessage", "getStatus", "()Z", "setStatus", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class AllPlan {
    @com.google.gson.annotations.SerializedName(value = "status")
    private boolean status;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "msg")
    private java.lang.String message;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "data")
    private java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.Dataplan> data;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "cover_image")
    private java.lang.String cover_image;
    
    @org.jetbrains.annotations.NotNull()
    public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.AllPlan copy(boolean status, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.Dataplan> data, @org.jetbrains.annotations.NotNull()
    java.lang.String cover_image) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public AllPlan(boolean status, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.Dataplan> data, @org.jetbrains.annotations.NotNull()
    java.lang.String cover_image) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean getStatus() {
        return false;
    }
    
    public final void setStatus(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMessage() {
        return null;
    }
    
    public final void setMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.Dataplan> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.Dataplan> getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.Dataplan> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCover_image() {
        return null;
    }
    
    public final void setCover_image(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
}