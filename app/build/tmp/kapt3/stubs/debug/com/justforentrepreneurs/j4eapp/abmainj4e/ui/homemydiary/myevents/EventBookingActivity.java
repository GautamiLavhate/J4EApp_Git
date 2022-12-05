package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0019H\u0016J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%J\u0012\u0010&\u001a\u00020\u00192\b\u0010\'\u001a\u0004\u0018\u00010(H\u0014J\u001a\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010-\u001a\u00020\u00192\b\u0010*\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR\u001a\u0010\u000f\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\u001a\u0010\u0012\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\u001a\u0010\u0015\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\t\u00a8\u00062"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/myevents/EventBookingActivity;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/base/BaseActivity;", "Lcom/razorpay/PaymentResultListener;", "()V", "Backtype", "", "getBacktype", "()Ljava/lang/String;", "setBacktype", "(Ljava/lang/String;)V", "binding", "Lcom/justforentrepreneurs/j4eapp/databinding/ActivityEventBookingBinding;", "event_booked_byuser", "getEvent_booked_byuser", "setEvent_booked_byuser", "event_fees", "getEvent_fees", "setEvent_fees", "eventid", "getEventid", "setEventid", "position", "getPosition", "setPosition", "app_book_eventDetails", "", "app_user_book_event", "amount", "bottomSheetConfirmBooking", "data", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homemydiary/myevents/model/EventBook$DataBook;", "bottomSheetFail", "enablePresence", "", "onBackPressed", "onCloseClick", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPaymentError", "p0", "", "p1", "onPaymentSuccess", "startPayment", "despiption", "email", "contact", "app_debug"})
public final class EventBookingActivity extends com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity implements com.razorpay.PaymentResultListener {
    private com.justforentrepreneurs.j4eapp.databinding.ActivityEventBookingBinding binding;
    public java.lang.String eventid;
    public java.lang.String event_fees;
    public java.lang.String Backtype;
    public java.lang.String position;
    public java.lang.String event_booked_byuser;
    private java.util.HashMap _$_findViewCache;
    
    public EventBookingActivity() {
        super();
    }
    
    @java.lang.Override()
    public boolean enablePresence() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEventid() {
        return null;
    }
    
    public final void setEventid(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEvent_fees() {
        return null;
    }
    
    public final void setEvent_fees(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBacktype() {
        return null;
    }
    
    public final void setBacktype(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPosition() {
        return null;
    }
    
    public final void setPosition(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEvent_booked_byuser() {
        return null;
    }
    
    public final void setEvent_booked_byuser(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void bottomSheetConfirmBooking(com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.model.EventBook.DataBook data) {
    }
    
    private final void bottomSheetFail(com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.model.EventBook.DataBook data) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    public final void onCloseClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    private final void app_book_eventDetails() {
    }
    
    private final void app_user_book_event(java.lang.String amount) {
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
}