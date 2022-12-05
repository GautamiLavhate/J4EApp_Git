package com.justforentrepreneurs.j4eapp.abmainj4e.listener;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\bH&\u00a8\u0006\t"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/listener/AuthListener;", "", "authData", "", "socialType", "", "loginDataHashMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "app_debug"})
public abstract interface AuthListener {
    
    public abstract void authData(@org.jetbrains.annotations.NotNull()
    java.lang.String socialType, @org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.String> loginDataHashMap);
}