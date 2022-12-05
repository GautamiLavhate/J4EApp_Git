package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u000fH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u00c6\u0003Js\u0010\'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u00c6\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020\u000fH\u00d6\u0001J\t\u0010,\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012\u00a8\u0006-"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/mydiary/MyLeads/model/UserData;", "", "userid", "", "recomendation_id", "recomendation_note", "full_name", "designation", "company_name", "profile_pic", "recomendation_date", "recomended_by", "", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/mydiary/MyLeads/model/RecomendedBy;", "is_viewed", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;I)V", "getCompany_name", "()Ljava/lang/String;", "getDesignation", "getFull_name", "()I", "getProfile_pic", "getRecomendation_date", "getRecomendation_id", "getRecomendation_note", "getRecomended_by", "()Ljava/util/List;", "getUserid", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class UserData {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "userid")
    private final java.lang.String userid = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "recomendation_id")
    private final java.lang.String recomendation_id = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "recomendation_note")
    private final java.lang.String recomendation_note = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "full_name")
    private final java.lang.String full_name = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "designation")
    private final java.lang.String designation = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "company_name")
    private final java.lang.String company_name = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "profile_pic")
    private final java.lang.String profile_pic = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "recomendation_date")
    private final java.lang.String recomendation_date = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "recomended_by")
    private final java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model.RecomendedBy> recomended_by = null;
    @com.google.gson.annotations.SerializedName(value = "is_viewed")
    private final int is_viewed = 0;
    
    @org.jetbrains.annotations.NotNull()
    public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model.UserData copy(@org.jetbrains.annotations.NotNull()
    java.lang.String userid, @org.jetbrains.annotations.NotNull()
    java.lang.String recomendation_id, @org.jetbrains.annotations.NotNull()
    java.lang.String recomendation_note, @org.jetbrains.annotations.NotNull()
    java.lang.String full_name, @org.jetbrains.annotations.NotNull()
    java.lang.String designation, @org.jetbrains.annotations.NotNull()
    java.lang.String company_name, @org.jetbrains.annotations.NotNull()
    java.lang.String profile_pic, @org.jetbrains.annotations.NotNull()
    java.lang.String recomendation_date, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model.RecomendedBy> recomended_by, int is_viewed) {
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
    
    public UserData(@org.jetbrains.annotations.NotNull()
    java.lang.String userid, @org.jetbrains.annotations.NotNull()
    java.lang.String recomendation_id, @org.jetbrains.annotations.NotNull()
    java.lang.String recomendation_note, @org.jetbrains.annotations.NotNull()
    java.lang.String full_name, @org.jetbrains.annotations.NotNull()
    java.lang.String designation, @org.jetbrains.annotations.NotNull()
    java.lang.String company_name, @org.jetbrains.annotations.NotNull()
    java.lang.String profile_pic, @org.jetbrains.annotations.NotNull()
    java.lang.String recomendation_date, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model.RecomendedBy> recomended_by, int is_viewed) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserid() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRecomendation_id() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRecomendation_note() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFull_name() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDesignation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompany_name() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProfile_pic() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRecomendation_date() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model.RecomendedBy> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model.RecomendedBy> getRecomended_by() {
        return null;
    }
    
    public final int component10() {
        return 0;
    }
    
    public final int is_viewed() {
        return 0;
    }
}