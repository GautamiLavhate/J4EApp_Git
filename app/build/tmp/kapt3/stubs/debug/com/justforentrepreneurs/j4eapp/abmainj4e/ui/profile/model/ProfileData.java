package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u000bH\u00c6\u0003JG\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0011R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010\u00a8\u0006 "}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/profile/model/ProfileData;", "", "average_ratings", "", "total_review_count", "review_star", "", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/profile/model/Reviewstar;", "all_reviews", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/profile/model/Allreviews;", "is_review_exhausted", "", "(FFLjava/util/List;Ljava/util/List;I)V", "getAll_reviews", "()Ljava/util/List;", "getAverage_ratings", "()F", "()I", "getReview_star", "getTotal_review_count", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class ProfileData {
    @com.google.gson.annotations.SerializedName(value = "average_ratings")
    private final float average_ratings = 0.0F;
    @com.google.gson.annotations.SerializedName(value = "total_review_count")
    private final float total_review_count = 0.0F;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "review_star")
    private final java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.Reviewstar> review_star = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "all_reviews")
    private final java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.Allreviews> all_reviews = null;
    @com.google.gson.annotations.SerializedName(value = "is_review_exhausted")
    private final int is_review_exhausted = 0;
    
    @org.jetbrains.annotations.NotNull()
    public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.ProfileData copy(float average_ratings, float total_review_count, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.Reviewstar> review_star, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.Allreviews> all_reviews, int is_review_exhausted) {
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
    
    public ProfileData(float average_ratings, float total_review_count, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.Reviewstar> review_star, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.Allreviews> all_reviews, int is_review_exhausted) {
        super();
    }
    
    public final float component1() {
        return 0.0F;
    }
    
    public final float getAverage_ratings() {
        return 0.0F;
    }
    
    public final float component2() {
        return 0.0F;
    }
    
    public final float getTotal_review_count() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.Reviewstar> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.Reviewstar> getReview_star() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.Allreviews> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.Allreviews> getAll_reviews() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int is_review_exhausted() {
        return 0;
    }
}