package com.justforentrepreneurs.j4eapp.abmainj4e.ui.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/login/SmsBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "smsBroadcastReceiverListener", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/login/SmsBroadcastReceiver$SmsBroadcastReceiverListener;", "getSmsBroadcastReceiverListener", "()Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/login/SmsBroadcastReceiver$SmsBroadcastReceiverListener;", "setSmsBroadcastReceiverListener", "(Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/login/SmsBroadcastReceiver$SmsBroadcastReceiverListener;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "SmsBroadcastReceiverListener", "app_debug"})
public final class SmsBroadcastReceiver extends android.content.BroadcastReceiver {
    @org.jetbrains.annotations.Nullable()
    private com.justforentrepreneurs.j4eapp.abmainj4e.ui.login.SmsBroadcastReceiver.SmsBroadcastReceiverListener smsBroadcastReceiverListener;
    
    public SmsBroadcastReceiver() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.login.SmsBroadcastReceiver.SmsBroadcastReceiverListener getSmsBroadcastReceiverListener() {
        return null;
    }
    
    public final void setSmsBroadcastReceiverListener(@org.jetbrains.annotations.Nullable()
    com.justforentrepreneurs.j4eapp.abmainj4e.ui.login.SmsBroadcastReceiver.SmsBroadcastReceiverListener p0) {
    }
    
    @java.lang.Override()
    public void onReceive(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/login/SmsBroadcastReceiver$SmsBroadcastReceiverListener;", "", "onFailure", "", "onSuccess", "intent", "Landroid/content/Intent;", "app_debug"})
    public static abstract interface SmsBroadcastReceiverListener {
        
        public abstract void onSuccess(@org.jetbrains.annotations.Nullable()
        android.content.Intent intent);
        
        public abstract void onFailure();
    }
}