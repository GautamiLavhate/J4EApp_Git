package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model;

import java.lang.System;

@kotlinx.android.parcel.Parcelize()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0006H\u00c6\u0003J#\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\u000e\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006H\u00d6\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\n\u00a8\u0006\u001b"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/profile/model/Messageview;", "Landroid/os/Parcelable;", "gallery_info", "", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/profile/model/GalleryInfo;", "is_gallery_exhausted", "", "(Ljava/util/List;I)V", "getGallery_info", "()Ljava/util/List;", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class Messageview implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "gallery_info")
    private final java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.GalleryInfo> gallery_info = null;
    @com.google.gson.annotations.SerializedName(value = "is_gallery_exhausted")
    private final int is_gallery_exhausted = 0;
    public static final android.os.Parcelable.Creator<com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.Messageview> CREATOR = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.Messageview copy(@org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.GalleryInfo> gallery_info, int is_gallery_exhausted) {
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
    
    public Messageview(@org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.GalleryInfo> gallery_info, int is_gallery_exhausted) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.GalleryInfo> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.GalleryInfo> getGallery_info() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int is_gallery_exhausted() {
        return 0;
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public static final class Creator implements android.os.Parcelable.Creator<com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.Messageview> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.Messageview createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.Messageview[] newArray(int size) {
            return null;
        }
    }
}