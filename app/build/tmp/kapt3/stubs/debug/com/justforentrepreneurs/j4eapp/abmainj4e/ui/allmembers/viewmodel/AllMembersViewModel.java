package com.justforentrepreneurs.j4eapp.abmainj4e.ui.allmembers.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rR\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/allmembers/viewmodel/AllMembersViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "viewAllMemberData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/allmembers/model/AllMemberResponse;", "getAllMemberData", "", "context", "Landroid/content/Context;", "userid", "", "Landroidx/lifecycle/LiveData;", "app_debug"})
public final class AllMembersViewModel extends androidx.lifecycle.AndroidViewModel {
    private androidx.lifecycle.MutableLiveData<com.justforentrepreneurs.j4eapp.abmainj4e.ui.allmembers.model.AllMemberResponse> viewAllMemberData;
    
    public AllMembersViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LiveData<com.justforentrepreneurs.j4eapp.abmainj4e.ui.allmembers.model.AllMemberResponse> viewAllMemberData(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String userid) {
        return null;
    }
    
    private final void getAllMemberData(android.content.Context context, java.lang.String userid) {
    }
}