package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0010B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/j4emembers/model/FilterPlan;", "", "status", "", "message", "", "data", "", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/j4emembers/model/FilterPlan$DataFilter;", "(ZLjava/lang/String;Ljava/util/List;)V", "getData", "()Ljava/util/List;", "getMessage", "()Ljava/lang/String;", "getStatus", "()Z", "DataFilter", "app_debug"})
public final class FilterPlan {
    @com.google.gson.annotations.SerializedName(value = "status")
    private final boolean status = false;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "msg")
    private final java.lang.String message = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "data")
    private final java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.FilterPlan.DataFilter> data = null;
    
    public FilterPlan(boolean status, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.FilterPlan.DataFilter> data) {
        super();
    }
    
    public final boolean getStatus() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.FilterPlan.DataFilter> getData() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/j4emembers/model/FilterPlan$DataFilter;", "", "membership_id", "", "membership_title", "isSelected", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "setSelected", "(Z)V", "getMembership_id", "()Ljava/lang/String;", "getMembership_title", "app_debug"})
    public static final class DataFilter {
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "membership_id")
        private final java.lang.String membership_id = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "membership_title")
        private final java.lang.String membership_title = null;
        private boolean isSelected;
        
        public DataFilter(@org.jetbrains.annotations.NotNull()
        java.lang.String membership_id, @org.jetbrains.annotations.NotNull()
        java.lang.String membership_title, boolean isSelected) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMembership_id() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMembership_title() {
            return null;
        }
        
        public final boolean isSelected() {
            return false;
        }
        
        public final void setSelected(boolean p0) {
        }
    }
}