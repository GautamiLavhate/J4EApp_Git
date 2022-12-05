package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myguestinvites;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\u0012\u0010\u001f\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u001a\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010%\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010&\u001a\u00020\u0014H\u0002J(\u0010\'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR\u001a\u0010\u0010\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\n\u00a8\u0006,"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/myguestinvites/MyGuestInvitesActivity;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/base/BaseActivity;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/myguestinvites/adapter/AdapterMyGuestInvites$OnClick2;", "Lcom/razorpay/PaymentResultListener;", "()V", "Eventamount", "", "getEventamount", "()Ljava/lang/String;", "setEventamount", "(Ljava/lang/String;)V", "binding", "Lcom/justforentrepreneurs/j4eapp/databinding/ActivityMyguestinvitesBinding;", "inviteid", "getInviteid", "setInviteid", "positionst", "getPositionst", "setPositionst", "OnClick", "", "id", "eventamount", "position", "app_do_guest_invite_payment", "paymentid", "enablePresence", "", "getMyGuestInvites", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPaymentError", "p0", "p1", "onPaymentSuccess", "recyclerData", "startPayment", "despiption", "amount", "email", "contact", "app_debug"})
public final class MyGuestInvitesActivity extends com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity implements com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myguestinvites.adapter.AdapterMyGuestInvites.OnClick2, com.razorpay.PaymentResultListener {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String Eventamount = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String inviteid = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String positionst = "";
    private com.justforentrepreneurs.j4eapp.databinding.ActivityMyguestinvitesBinding binding;
    private java.util.HashMap _$_findViewCache;
    
    public MyGuestInvitesActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEventamount() {
        return null;
    }
    
    public final void setEventamount(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getInviteid() {
        return null;
    }
    
    public final void setInviteid(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPositionst() {
        return null;
    }
    
    public final void setPositionst(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    public boolean enablePresence() {
        return false;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    private final void recyclerData() {
    }
    
    private final void getMyGuestInvites(int position) {
    }
    
    @java.lang.Override()
    public void OnClick(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String eventamount, @org.jetbrains.annotations.NotNull()
    java.lang.String position) {
    }
    
    private final void startPayment(java.lang.String despiption, java.lang.String amount, java.lang.String email, java.lang.String contact) {
    }
    
    @java.lang.Override()
    public void onPaymentSuccess(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    public void onPaymentError(int p0, @org.jetbrains.annotations.Nullable()
    java.lang.String p1) {
    }
    
    private final void app_do_guest_invite_payment(java.lang.String paymentid) {
    }
}