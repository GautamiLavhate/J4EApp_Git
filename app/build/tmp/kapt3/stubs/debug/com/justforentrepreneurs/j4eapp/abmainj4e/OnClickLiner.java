package com.justforentrepreneurs.j4eapp.abmainj4e;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J.\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&\u00a8\u0006\u000e"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/OnClickLiner;", "", "onClickDcline", "", "pos", "", "mdata", "", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/myconnections/Model/DataReceived;", "onClickPos", "value", "", "btd", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "app_debug"})
public abstract interface OnClickLiner {
    
    public abstract void onClickPos(int pos, @org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    com.google.android.material.floatingactionbutton.FloatingActionButton btd, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.DataReceived> mdata);
    
    public abstract void onClickDcline(int pos, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.DataReceived> mdata);
}