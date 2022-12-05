package com.justforentrepreneurs.j4eapp.abmainj4e.ui.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010.\u001a\u00020/H\u0002J\u0006\u00100\u001a\u00020/J\u000e\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020\u0005J\u000e\u00103\u001a\u00020/2\u0006\u00104\u001a\u000205J\u0010\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020\u0005H\u0002J\u0010\u00108\u001a\u00020/2\u0006\u00107\u001a\u00020\u0005H\u0002J\u0014\u00109\u001a\u00020/2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;J\b\u0010=\u001a\u00020/H\u0002J\b\u0010>\u001a\u00020/H\u0002J\b\u0010?\u001a\u00020/H\u0002J\b\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020/H\u0002J\b\u0010C\u001a\u00020/H\u0002J\u0018\u0010D\u001a\u00020A2\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020\u0005J\b\u0010H\u001a\u00020/H\u0002J\u000e\u0010I\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010J\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010K\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010L\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010M\u001a\u00020/2\u0006\u00104\u001a\u000205J\b\u0010N\u001a\u00020/H\u0016J\u000e\u0010O\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010P\u001a\u00020/2\u0006\u00104\u001a\u000205J\u0012\u0010Q\u001a\u00020/2\b\u0010R\u001a\u0004\u0018\u00010SH\u0014J\u000e\u0010T\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010U\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010V\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010W\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010X\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010Y\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010Z\u001a\u00020/2\u0006\u00104\u001a\u000205J\u001a\u0010[\u001a\u00020A2\u0006\u0010\\\u001a\u00020\u00142\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J\u000e\u0010_\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010`\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010a\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010b\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010c\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010d\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010e\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010f\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010g\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010h\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010i\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010j\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010k\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010l\u001a\u00020/2\u0006\u00104\u001a\u000205J\u0010\u0010m\u001a\u00020A2\u0006\u0010n\u001a\u00020oH\u0016J\u000e\u0010p\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010q\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010r\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010s\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010t\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010u\u001a\u00020/2\u0006\u00104\u001a\u000205J\b\u0010v\u001a\u00020/H\u0014J\u000e\u0010w\u001a\u00020/2\u0006\u00104\u001a\u000205J\b\u0010x\u001a\u00020/H\u0014J\u000e\u0010y\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010z\u001a\u00020/2\u0006\u00104\u001a\u000205J\u000e\u0010{\u001a\u00020/2\u0006\u00104\u001a\u000205J\b\u0010|\u001a\u00020/H\u0002J\u000e\u0010}\u001a\u00020/2\u0006\u0010~\u001a\u00020\u0005J\b\u0010\u007f\u001a\u00020/H\u0002J\t\u0010\u0080\u0001\u001a\u00020/H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018R\u001a\u0010$\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0016\"\u0004\b%\u0010\u0018R\u001a\u0010&\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b\'\u0010\u0018R\u001a\u0010(\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u0018R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0081\u0001"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/home/MainActivity;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/base/BaseActivity;", "Lcom/google/android/material/navigation/NavigationView$OnNavigationItemSelectedListener;", "()V", "addpersmission", "", "backPressedTime", "", "getBackPressedTime", "()J", "setBackPressedTime", "(J)V", "backupFileUri", "binding", "Lcom/justforentrepreneurs/j4eapp/databinding/ActivityMainJ4eBinding;", "getBinding", "()Lcom/justforentrepreneurs/j4eapp/databinding/ActivityMainJ4eBinding;", "setBinding", "(Lcom/justforentrepreneurs/j4eapp/databinding/ActivityMainJ4eBinding;)V", "currentPosition", "", "getCurrentPosition", "()I", "setCurrentPosition", "(I)V", "databaseReference", "Lcom/google/firebase/database/DatabaseReference;", "getDatabaseReference", "()Lcom/google/firebase/database/DatabaseReference;", "setDatabaseReference", "(Lcom/google/firebase/database/DatabaseReference;)V", "dbFileUri", "iconMenu", "Lcom/poup/newpowemenu/PowerMenu;", "is_buddy_meet_exhausted", "set_buddy_meet_exhausted", "is_post_exhausted", "set_post_exhausted", "is_referral_exhausted", "set_referral_exhausted", "is_requirement_exhausted", "set_requirement_exhausted", "onIconMenuItemClickListener", "Lcom/poup/newpowemenu/OnMenuItemClickListener;", "Lcom/poup/newpowemenu/PowerMenuItem;", "pickedPhoto", "ExitDialog", "", "Getdata", "Infodata", "permission", "OnShareClick", "view", "Landroid/view/View;", "PermissionDialog", "massage", "Planexpaireddialog", "abd", "response", "Lretrofit2/Response;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/j4emembers/model/J4EMember;", "app_check_permissions", "app_check_validity", "app_get_notification_count", "enablePresence", "", "getGroupList", "get_payment_key", "loadFragment", "fragment", "Landroidx/fragment/app/Fragment;", "tag", "navDrawer", "onAboutUsClick", "onAllEventsClick", "onAllLeadsClick", "onAllPostsClick", "onAllRecognitionClick", "onBackPressed", "onChatClick", "onConnectionClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateClick", "onDrawerDealsDiscount", "onDrawerMyDiaryClick", "onEventsClick", "onFeedbackClick", "onHomeClick", "onJ4EMembersClick", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onMyBuddiesClick", "onMyBusinessClick", "onMyEventsClick", "onMyGroupClick", "onMyGuestInvitesClick", "onMyLeadsClick", "onMyMembershipClick", "onMyReferralsGivenClick", "onMyReferralsReceivedClick", "onMyReportCardClick", "onMyRequirementsClick", "onMyRewardsClick", "onMyTesimonialsClick", "onNavigationClick", "onNavigationItemSelected", "item", "Landroid/view/MenuItem;", "onNotificationClick", "onPendingResponsibilitiesClick", "onPrivacyPolicy", "onRecognitionClick", "onRecommendedByClick", "onRecommendedToClick", "onResume", "onSettingClick", "onStart", "onTermsAndCondition", "onTopRankingClick", "onViewProfileClick", "requestPermissions", "setBottomIconChange", "sType", "startServices", "syncContacts", "app_debug"})
public final class MainActivity extends com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity implements com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener {
    public com.justforentrepreneurs.j4eapp.databinding.ActivityMainJ4eBinding binding;
    private com.poup.newpowemenu.PowerMenu iconMenu;
    @org.jetbrains.annotations.Nullable()
    private com.google.firebase.database.DatabaseReference databaseReference;
    private java.lang.String pickedPhoto;
    private java.lang.String backupFileUri;
    private java.lang.String dbFileUri;
    private java.lang.String addpersmission = "";
    private int is_post_exhausted = -1;
    private int is_requirement_exhausted = -1;
    private int is_buddy_meet_exhausted = -1;
    private int is_referral_exhausted = -1;
    private int currentPosition = 0;
    private final com.poup.newpowemenu.OnMenuItemClickListener<com.poup.newpowemenu.PowerMenuItem> onIconMenuItemClickListener = null;
    private long backPressedTime = 0L;
    private java.util.HashMap _$_findViewCache;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.justforentrepreneurs.j4eapp.databinding.ActivityMainJ4eBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.databinding.ActivityMainJ4eBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.firebase.database.DatabaseReference getDatabaseReference() {
        return null;
    }
    
    public final void setDatabaseReference(@org.jetbrains.annotations.Nullable()
    com.google.firebase.database.DatabaseReference p0) {
    }
    
    public final int is_post_exhausted() {
        return 0;
    }
    
    public final void set_post_exhausted(int p0) {
    }
    
    public final int is_requirement_exhausted() {
        return 0;
    }
    
    public final void set_requirement_exhausted(int p0) {
    }
    
    public final int is_buddy_meet_exhausted() {
        return 0;
    }
    
    public final void set_buddy_meet_exhausted(int p0) {
    }
    
    public final int is_referral_exhausted() {
        return 0;
    }
    
    public final void set_referral_exhausted(int p0) {
    }
    
    public final int getCurrentPosition() {
        return 0;
    }
    
    public final void setCurrentPosition(int p0) {
    }
    
    @java.lang.Override()
    public boolean enablePresence() {
        return false;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final boolean loadFragment(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.Fragment fragment, @org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
        return false;
    }
    
    private final void navDrawer() {
    }
    
    @java.lang.Override()
    public boolean onNavigationItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    public final void onNavigationClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onCreateClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    public final long getBackPressedTime() {
        return 0L;
    }
    
    public final void setBackPressedTime(long p0) {
    }
    
    @java.lang.Override()
    public boolean onKeyDown(int keyCode, @org.jetbrains.annotations.Nullable()
    android.view.KeyEvent event) {
        return false;
    }
    
    public final void onDrawerMyDiaryClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onDrawerDealsDiscount(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onHomeClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onAllLeadsClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onAllPostsClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onMyRequirementsClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onMyBuddiesClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onMyGuestInvitesClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onMyBusinessClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onMyEventsClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onMyRewardsClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onMyReportCardClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onMyLeadsClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onPendingResponsibilitiesClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onMyTesimonialsClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onMyMembershipClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onRecommendedByClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onRecommendedToClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onRecognitionClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onAllEventsClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onEventsClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onAllRecognitionClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onJ4EMembersClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onFeedbackClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onTermsAndCondition(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onPrivacyPolicy(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void OnShareClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onAboutUsClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onSettingClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onViewProfileClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onConnectionClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onChatClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void setBottomIconChange(@org.jetbrains.annotations.NotNull()
    java.lang.String sType) {
    }
    
    public final void onNotificationClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    public final void onTopRankingClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void abd(@org.jetbrains.annotations.NotNull()
    retrofit2.Response<com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.J4EMember> response) {
    }
    
    public final void onMyGroupClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    private final void requestPermissions() {
    }
    
    public final void Getdata() {
    }
    
    private final void startServices() {
    }
    
    private final void syncContacts() {
    }
    
    private final void app_get_notification_count() {
    }
    
    private final void getGroupList() {
    }
    
    private final void ExitDialog() {
    }
    
    private final void Planexpaireddialog(java.lang.String massage) {
    }
    
    private final void app_check_validity() {
    }
    
    private final void app_check_permissions() {
    }
    
    private final void PermissionDialog(java.lang.String massage) {
    }
    
    private final void get_payment_key() {
    }
    
    public final void onMyReferralsGivenClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void onMyReferralsReceivedClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void Infodata(@org.jetbrains.annotations.NotNull()
    java.lang.String permission) {
    }
}