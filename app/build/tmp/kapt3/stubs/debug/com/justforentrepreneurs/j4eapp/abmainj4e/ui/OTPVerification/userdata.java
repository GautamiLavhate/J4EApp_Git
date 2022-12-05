package com.justforentrepreneurs.j4eapp.abmainj4e.ui.OTPVerification;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001OB\u00b5\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u001aJ\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\t\u00107\u001a\u00020\u0003H\u00c6\u0003J\t\u00108\u001a\u00020\u0003H\u00c6\u0003J\t\u00109\u001a\u00020\u0003H\u00c6\u0003J\t\u0010:\u001a\u00020\u0003H\u00c6\u0003J\t\u0010;\u001a\u00020\u0003H\u00c6\u0003J\t\u0010<\u001a\u00020\u0003H\u00c6\u0003J\t\u0010=\u001a\u00020\u0003H\u00c6\u0003J\t\u0010>\u001a\u00020\u0003H\u00c6\u0003J\t\u0010?\u001a\u00020\u0018H\u00c6\u0003J\t\u0010@\u001a\u00020\u0003H\u00c6\u0003J\t\u0010A\u001a\u00020\u0003H\u00c6\u0003J\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\t\u0010C\u001a\u00020\u0003H\u00c6\u0003J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\t\u0010E\u001a\u00020\u0003H\u00c6\u0003J\t\u0010F\u001a\u00020\u0003H\u00c6\u0003J\t\u0010G\u001a\u00020\u0003H\u00c6\u0003J\u00e5\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010L\u001a\u00020MH\u00d6\u0001J\t\u0010N\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0016\u0010\u0016\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001cR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0016\u0010\u0019\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001cR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0016\u0010\u0017\u001a\u00020\u00188\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001cR\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001cR\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001cR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001c\u00a8\u0006P"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/OTPVerification/userdata;", "", "id", "", "email_address", "phone", "type", "membership_type", "first_name", "middle_name", "last_name", "dob", "company", "designation", "company_address", "company_number", "avatar", "business_type", "business_category", "business_entity", "total_experience", "signup_source", "chat_id", "notification_count", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/OTPVerification/userdata$CountBubbleData;", "is_admin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/OTPVerification/userdata$CountBubbleData;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getBusiness_category", "getBusiness_entity", "getBusiness_type", "getChat_id", "getCompany", "getCompany_address", "getCompany_number", "getDesignation", "getDob", "getEmail_address", "getFirst_name", "getId", "getLast_name", "getMembership_type", "getMiddle_name", "getNotification_count", "()Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/OTPVerification/userdata$CountBubbleData;", "getPhone", "getSignup_source", "getTotal_experience", "getType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "CountBubbleData", "app_debug"})
public final class userdata {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "id")
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "email_address")
    private final java.lang.String email_address = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "phone")
    private final java.lang.String phone = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "login_type")
    private final java.lang.String type = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "membership_type")
    private final java.lang.String membership_type = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "first_name")
    private final java.lang.String first_name = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "middle_name")
    private final java.lang.String middle_name = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "last_name")
    private final java.lang.String last_name = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "dob")
    private final java.lang.String dob = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "company")
    private final java.lang.String company = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "designation")
    private final java.lang.String designation = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "company_address")
    private final java.lang.String company_address = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "company_contact")
    private final java.lang.String company_number = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "avatar")
    private final java.lang.String avatar = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "business_type")
    private final java.lang.String business_type = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "business_category")
    private final java.lang.String business_category = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "business_entity")
    private final java.lang.String business_entity = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "total_experience")
    private final java.lang.String total_experience = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "signup_source")
    private final java.lang.String signup_source = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "chat_id")
    private final java.lang.String chat_id = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "notification_count")
    private final com.justforentrepreneurs.j4eapp.abmainj4e.ui.OTPVerification.userdata.CountBubbleData notification_count = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "is_admin")
    private final java.lang.String is_admin = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.OTPVerification.userdata copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String email_address, @org.jetbrains.annotations.NotNull()
    java.lang.String phone, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    java.lang.String membership_type, @org.jetbrains.annotations.NotNull()
    java.lang.String first_name, @org.jetbrains.annotations.NotNull()
    java.lang.String middle_name, @org.jetbrains.annotations.NotNull()
    java.lang.String last_name, @org.jetbrains.annotations.NotNull()
    java.lang.String dob, @org.jetbrains.annotations.NotNull()
    java.lang.String company, @org.jetbrains.annotations.NotNull()
    java.lang.String designation, @org.jetbrains.annotations.NotNull()
    java.lang.String company_address, @org.jetbrains.annotations.NotNull()
    java.lang.String company_number, @org.jetbrains.annotations.NotNull()
    java.lang.String avatar, @org.jetbrains.annotations.NotNull()
    java.lang.String business_type, @org.jetbrains.annotations.NotNull()
    java.lang.String business_category, @org.jetbrains.annotations.NotNull()
    java.lang.String business_entity, @org.jetbrains.annotations.NotNull()
    java.lang.String total_experience, @org.jetbrains.annotations.NotNull()
    java.lang.String signup_source, @org.jetbrains.annotations.NotNull()
    java.lang.String chat_id, @org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.abmainj4e.ui.OTPVerification.userdata.CountBubbleData notification_count, @org.jetbrains.annotations.NotNull()
    java.lang.String is_admin) {
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
    
    public userdata(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String email_address, @org.jetbrains.annotations.NotNull()
    java.lang.String phone, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    java.lang.String membership_type, @org.jetbrains.annotations.NotNull()
    java.lang.String first_name, @org.jetbrains.annotations.NotNull()
    java.lang.String middle_name, @org.jetbrains.annotations.NotNull()
    java.lang.String last_name, @org.jetbrains.annotations.NotNull()
    java.lang.String dob, @org.jetbrains.annotations.NotNull()
    java.lang.String company, @org.jetbrains.annotations.NotNull()
    java.lang.String designation, @org.jetbrains.annotations.NotNull()
    java.lang.String company_address, @org.jetbrains.annotations.NotNull()
    java.lang.String company_number, @org.jetbrains.annotations.NotNull()
    java.lang.String avatar, @org.jetbrains.annotations.NotNull()
    java.lang.String business_type, @org.jetbrains.annotations.NotNull()
    java.lang.String business_category, @org.jetbrains.annotations.NotNull()
    java.lang.String business_entity, @org.jetbrains.annotations.NotNull()
    java.lang.String total_experience, @org.jetbrains.annotations.NotNull()
    java.lang.String signup_source, @org.jetbrains.annotations.NotNull()
    java.lang.String chat_id, @org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.abmainj4e.ui.OTPVerification.userdata.CountBubbleData notification_count, @org.jetbrains.annotations.NotNull()
    java.lang.String is_admin) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmail_address() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPhone() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMembership_type() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirst_name() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMiddle_name() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLast_name() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDob() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompany() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDesignation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompany_address() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompany_number() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAvatar() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBusiness_type() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBusiness_category() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBusiness_entity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTotal_experience() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSignup_source() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getChat_id() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.OTPVerification.userdata.CountBubbleData component21() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.OTPVerification.userdata.CountBubbleData getNotification_count() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component22() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String is_admin() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/OTPVerification/userdata$CountBubbleData;", "", "post_count", "", "event_count", "lead_count", "buddy_count", "notificat_count", "connection_sent_count", "connection_receive_count", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBuddy_count", "()Ljava/lang/String;", "getConnection_receive_count", "getConnection_sent_count", "getEvent_count", "getLead_count", "getNotificat_count", "getPost_count", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class CountBubbleData {
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "post_count")
        private final java.lang.String post_count = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "event_count")
        private final java.lang.String event_count = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "lead_count")
        private final java.lang.String lead_count = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "buddy_count")
        private final java.lang.String buddy_count = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "notificat_count")
        private final java.lang.String notificat_count = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "connection_sent_count")
        private final java.lang.String connection_sent_count = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "connection_receive_count")
        private final java.lang.String connection_receive_count = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.OTPVerification.userdata.CountBubbleData copy(@org.jetbrains.annotations.NotNull()
        java.lang.String post_count, @org.jetbrains.annotations.NotNull()
        java.lang.String event_count, @org.jetbrains.annotations.NotNull()
        java.lang.String lead_count, @org.jetbrains.annotations.NotNull()
        java.lang.String buddy_count, @org.jetbrains.annotations.NotNull()
        java.lang.String notificat_count, @org.jetbrains.annotations.NotNull()
        java.lang.String connection_sent_count, @org.jetbrains.annotations.NotNull()
        java.lang.String connection_receive_count) {
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
        
        public CountBubbleData(@org.jetbrains.annotations.NotNull()
        java.lang.String post_count, @org.jetbrains.annotations.NotNull()
        java.lang.String event_count, @org.jetbrains.annotations.NotNull()
        java.lang.String lead_count, @org.jetbrains.annotations.NotNull()
        java.lang.String buddy_count, @org.jetbrains.annotations.NotNull()
        java.lang.String notificat_count, @org.jetbrains.annotations.NotNull()
        java.lang.String connection_sent_count, @org.jetbrains.annotations.NotNull()
        java.lang.String connection_receive_count) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPost_count() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEvent_count() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getLead_count() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getBuddy_count() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getNotificat_count() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getConnection_sent_count() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component7() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getConnection_receive_count() {
            return null;
        }
    }
}