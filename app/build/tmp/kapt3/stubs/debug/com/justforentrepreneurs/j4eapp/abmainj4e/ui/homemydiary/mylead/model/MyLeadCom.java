package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mylead.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001fB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\nH\u00c6\u0003J7\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\nH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006 "}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/mylead/model/MyLeadCom;", "", "status", "", "message", "", "user_data", "", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/mylead/model/MyLeadCom$MyRequirementpending;", "count_available", "", "(ZLjava/lang/String;Ljava/util/List;I)V", "getCount_available", "()I", "getMessage", "()Ljava/lang/String;", "getStatus", "()Z", "setStatus", "(Z)V", "getUser_data", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "MyRequirementpending", "app_debug"})
public final class MyLeadCom {
    @com.google.gson.annotations.SerializedName(value = "status")
    private boolean status;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "msg")
    private final java.lang.String message = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "data")
    private final java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mylead.model.MyLeadCom.MyRequirementpending> user_data = null;
    @com.google.gson.annotations.SerializedName(value = "count_available")
    private final int count_available = 0;
    
    @org.jetbrains.annotations.NotNull()
    public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mylead.model.MyLeadCom copy(boolean status, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mylead.model.MyLeadCom.MyRequirementpending> user_data, int count_available) {
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
    
    public MyLeadCom(boolean status, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mylead.model.MyLeadCom.MyRequirementpending> user_data, int count_available) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mylead.model.MyLeadCom.MyRequirementpending> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mylead.model.MyLeadCom.MyRequirementpending> getUser_data() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getCount_available() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u000fH\u00c6\u0003J\t\u0010#\u001a\u00020\u000fH\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\u008b\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u00c6\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00100\u001a\u00020\u000fH\u00d6\u0001J\t\u00101\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0016\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0018R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0018R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013\u00a8\u00062"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/mylead/model/MyLeadCom$MyRequirementpending;", "", "id", "", "user_id", "user_name", "user_profile", "title", "description", "thumbnil", "created_date", "created_time", "status", "doe", "is_viewed", "", "is_user_viewed", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getCreated_date", "()Ljava/lang/String;", "getCreated_time", "getDescription", "getDoe", "getId", "()I", "getStatus", "getThumbnil", "getTitle", "getUser_id", "getUser_name", "getUser_profile", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
    public static final class MyRequirementpending {
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "id")
        private final java.lang.String id = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "user_id")
        private final java.lang.String user_id = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "user_name")
        private final java.lang.String user_name = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "user_profile")
        private final java.lang.String user_profile = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "title")
        private final java.lang.String title = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "description")
        private final java.lang.String description = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "thumbnil")
        private final java.lang.String thumbnil = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "created_date")
        private final java.lang.String created_date = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "created_time")
        private final java.lang.String created_time = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "status")
        private final java.lang.String status = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "doe")
        private final java.lang.String doe = null;
        @com.google.gson.annotations.SerializedName(value = "is_viewed")
        private final int is_viewed = 0;
        @com.google.gson.annotations.SerializedName(value = "is_user_viewed")
        private final int is_user_viewed = 0;
        
        @org.jetbrains.annotations.NotNull()
        public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mylead.model.MyLeadCom.MyRequirementpending copy(@org.jetbrains.annotations.NotNull()
        java.lang.String id, @org.jetbrains.annotations.NotNull()
        java.lang.String user_id, @org.jetbrains.annotations.NotNull()
        java.lang.String user_name, @org.jetbrains.annotations.NotNull()
        java.lang.String user_profile, @org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String description, @org.jetbrains.annotations.NotNull()
        java.lang.String thumbnil, @org.jetbrains.annotations.NotNull()
        java.lang.String created_date, @org.jetbrains.annotations.NotNull()
        java.lang.String created_time, @org.jetbrains.annotations.NotNull()
        java.lang.String status, @org.jetbrains.annotations.NotNull()
        java.lang.String doe, int is_viewed, int is_user_viewed) {
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
        
        public MyRequirementpending(@org.jetbrains.annotations.NotNull()
        java.lang.String id, @org.jetbrains.annotations.NotNull()
        java.lang.String user_id, @org.jetbrains.annotations.NotNull()
        java.lang.String user_name, @org.jetbrains.annotations.NotNull()
        java.lang.String user_profile, @org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String description, @org.jetbrains.annotations.NotNull()
        java.lang.String thumbnil, @org.jetbrains.annotations.NotNull()
        java.lang.String created_date, @org.jetbrains.annotations.NotNull()
        java.lang.String created_time, @org.jetbrains.annotations.NotNull()
        java.lang.String status, @org.jetbrains.annotations.NotNull()
        java.lang.String doe, int is_viewed, int is_user_viewed) {
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
        public final java.lang.String getUser_id() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUser_name() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUser_profile() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDescription() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component7() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getThumbnil() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component8() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCreated_date() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component9() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCreated_time() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component10() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getStatus() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component11() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDoe() {
            return null;
        }
        
        public final int component12() {
            return 0;
        }
        
        public final int is_viewed() {
            return 0;
        }
        
        public final int component13() {
            return 0;
        }
        
        public final int is_user_viewed() {
            return 0;
        }
    }
}