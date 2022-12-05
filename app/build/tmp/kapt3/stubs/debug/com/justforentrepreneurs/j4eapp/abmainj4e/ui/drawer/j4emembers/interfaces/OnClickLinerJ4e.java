package com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.interfaces;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J&\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/j4emembers/interfaces/OnClickLinerJ4e;", "", "OnClickpro", "", "position", "", "data", "", "is_viewed", "onClickPos", "pos", "mdata", "", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/j4emembers/model/Memberinfo;", "img", "Landroid/widget/ImageView;", "app_debug"})
public abstract interface OnClickLinerJ4e {
    
    public abstract void onClickPos(int pos, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.Memberinfo> mdata, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView img);
    
    public abstract void OnClickpro(int position, @org.jetbrains.annotations.NotNull()
    java.lang.String data, int is_viewed);
}