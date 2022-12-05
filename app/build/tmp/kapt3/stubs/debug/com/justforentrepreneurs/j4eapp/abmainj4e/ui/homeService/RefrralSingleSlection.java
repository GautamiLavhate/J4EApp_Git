package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&J&\u0010\t\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\f"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/RefrralSingleSlection;", "", "addMultiSelection", "", "multiModel", "", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/model/Reffralcategory$ReffralcategoryData;", "pos", "", "removeMultiSelection", "id", "", "app_debug"})
public abstract interface RefrralSingleSlection {
    
    public abstract void addMultiSelection(@org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.Reffralcategory.ReffralcategoryData> multiModel, int pos);
    
    public abstract void removeMultiSelection(@org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.Reffralcategory.ReffralcategoryData> multiModel, @org.jetbrains.annotations.NotNull()
    java.lang.String id, int pos);
}