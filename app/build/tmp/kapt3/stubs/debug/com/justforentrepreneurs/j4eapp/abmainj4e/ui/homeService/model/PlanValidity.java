package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/model/PlanValidity;", "", "status", "", "messageData", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/model/PlanValidity$MessageData;", "(ZLcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/model/PlanValidity$MessageData;)V", "getMessageData", "()Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/model/PlanValidity$MessageData;", "getStatus", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "MessageData", "app_debug"})
public final class PlanValidity {
    @com.google.gson.annotations.SerializedName(value = "status")
    private final boolean status = false;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "message")
    private final com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.PlanValidity.MessageData messageData = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.PlanValidity copy(boolean status, @org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.PlanValidity.MessageData messageData) {
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
    
    public PlanValidity(boolean status, @org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.PlanValidity.MessageData messageData) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean getStatus() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.PlanValidity.MessageData component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.PlanValidity.MessageData getMessageData() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\nH\u00c6\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r\u00a8\u0006 "}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/model/PlanValidity$MessageData;", "", "userId", "", "mobile", "otp", "", "type", "message", "result", "", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Z)V", "getMessage", "()Ljava/lang/String;", "getMobile", "getOtp", "()I", "getResult", "()Z", "getType", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
    public static final class MessageData {
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "userid")
        private final java.lang.String userId = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "mobile")
        private final java.lang.String mobile = null;
        @com.google.gson.annotations.SerializedName(value = "otp")
        private final int otp = 0;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "login_type")
        private final java.lang.String type = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "message")
        private final java.lang.String message = null;
        @com.google.gson.annotations.SerializedName(value = "result")
        private final boolean result = false;
        
        @org.jetbrains.annotations.NotNull()
        public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.PlanValidity.MessageData copy(@org.jetbrains.annotations.NotNull()
        java.lang.String userId, @org.jetbrains.annotations.NotNull()
        java.lang.String mobile, int otp, @org.jetbrains.annotations.NotNull()
        java.lang.String type, @org.jetbrains.annotations.NotNull()
        java.lang.String message, boolean result) {
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
        
        public MessageData(@org.jetbrains.annotations.NotNull()
        java.lang.String userId, @org.jetbrains.annotations.NotNull()
        java.lang.String mobile, int otp, @org.jetbrains.annotations.NotNull()
        java.lang.String type, @org.jetbrains.annotations.NotNull()
        java.lang.String message, boolean result) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUserId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMobile() {
            return null;
        }
        
        public final int component3() {
            return 0;
        }
        
        public final int getOtp() {
            return 0;
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
        public final java.lang.String getMessage() {
            return null;
        }
        
        public final boolean component6() {
            return false;
        }
        
        public final boolean getResult() {
            return false;
        }
    }
}