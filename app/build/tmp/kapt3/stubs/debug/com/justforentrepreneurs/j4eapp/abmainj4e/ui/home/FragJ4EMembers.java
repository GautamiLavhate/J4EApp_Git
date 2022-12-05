package com.justforentrepreneurs.j4eapp.abmainj4e.ui.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\r\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ \u0010@\u001a\u00020A2\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020DH\u0016J \u0010E\u001a\u00020A2\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020DH\u0016J\u0018\u0010F\u001a\u00020A2\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000bH\u0016J \u0010G\u001a\u00020A2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010H\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\bH\u0016J \u0010J\u001a\u00020A2\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010K\u001a\u00020A2\u0006\u0010L\u001a\u00020\u000bH\u0002J\b\u0010M\u001a\u00020AH\u0002J\b\u0010N\u001a\u00020AH\u0002J\u0018\u0010O\u001a\u00020A2\u0006\u0010C\u001a\u00020D2\u0006\u0010P\u001a\u00020\u000bH\u0002J\u0018\u0010Q\u001a\u00020A2\u0006\u0010C\u001a\u00020D2\u0006\u0010P\u001a\u00020\u000bH\u0002J\u0010\u0010R\u001a\u00020A2\u0006\u0010C\u001a\u00020DH\u0002J\u0018\u0010S\u001a\u00020A2\u0006\u0010C\u001a\u00020D2\u0006\u0010T\u001a\u00020\u000bH\u0002J\u0010\u0010U\u001a\u00020A2\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010V\u001a\u00020A2\u0006\u0010\u0007\u001a\u00020\u000bH\u0002JH\u0010W\u001a\u00020A2\u0006\u0010X\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020\u000b2\u0006\u0010[\u001a\u00020\u000b2\u0006\u0010\\\u001a\u00020\u000b2\u0006\u0010]\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020\u000bH\u0002J.\u0010`\u001a\u00020A2\u0006\u0010B\u001a\u00020\u000b2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020c0b2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020\bH\u0002J\"\u0010g\u001a\u00020A2\u0006\u0010h\u001a\u00020\b2\u0006\u0010i\u001a\u00020\b2\b\u0010H\u001a\u0004\u0018\u00010jH\u0016J&\u0010k\u001a\u00020A2\u0006\u0010f\u001a\u00020\b2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020c0b2\u0006\u0010d\u001a\u00020eH\u0016J&\u0010l\u001a\u0004\u0018\u00010m2\u0006\u0010n\u001a\u00020o2\b\u0010p\u001a\u0004\u0018\u00010q2\b\u0010r\u001a\u0004\u0018\u00010sH\u0016J\b\u0010t\u001a\u00020AH\u0002R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001d\"\u0004\b \u0010\tR\u001a\u0010!\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\tR\u001a\u0010#\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001d\"\u0004\b$\u0010\tR\u001a\u0010%\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001d\"\u0004\b&\u0010\tR\u001a\u0010\'\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010\u000fR\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\r\"\u0004\b4\u0010\u000fR\u000e\u0010\u0007\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u00106\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\r\"\u0004\b8\u0010\u000fR\u000e\u00109\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\r\"\u0004\b<\u0010\u000fR\u001a\u0010=\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\r\"\u0004\b?\u0010\u000f\u00a8\u0006u"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/home/FragJ4EMembers;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/base/BaseFragment;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/j4emembers/interfaces/OnClickLinerJ4e;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/j4emembers/adapters/AdapterJ4EMemPlans$OnClick2;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/j4emembers/adapters/AdapterJ4ECategory$OnClick2;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/j4emembers/adapters/AdapterTurnOverJ4e$OnClick2;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/j4emembers/adapters/AdapterNoofEmpolyee$OnClick2;", "position", "", "(I)V", "AboutId", "", "getAboutId", "()Ljava/lang/String;", "setAboutId", "(Ljava/lang/String;)V", "AboutValue", "getAboutValue", "setAboutValue", "areaid", "getAreaid", "setAreaid", "areanamem", "getAreanamem", "setAreanamem", "binding", "Lcom/justforentrepreneurs/j4eapp/databinding/FragmentFragJ4EMembersBinding;", "count_available", "getCount_available", "()I", "setCount_available", "is_buddy_meet_exhausted", "set_buddy_meet_exhausted", "is_post_exhausted", "set_post_exhausted", "is_referral_exhausted", "set_referral_exhausted", "is_requirement_exhausted", "set_requirement_exhausted", "lstChk", "getLstChk", "setLstChk", "mActivity", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/home/MainActivity;", "getMActivity", "()Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/home/MainActivity;", "setMActivity", "(Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/home/MainActivity;)V", "mContext", "Landroid/content/Context;", "planid", "getPlanid", "setPlanid", "positionI", "rankck", "getRankck", "setRankck", "sharedPrefFile", "turnid", "getTurnid", "setTurnid", "turnidnamem", "getTurnidnamem", "setTurnidnamem", "OnClick", "", "id", "mBsMemberFilterBinding", "Lcom/justforentrepreneurs/j4eapp/databinding/BsMemberFilterBinding;", "OnClickJ4e", "OnClickPlan", "OnClickpro", "data", "is_viewed", "OnEmpClick", "PermissionDialog", "massage", "app_check_permissions", "bottomSheetFilter", "getAllArae", "Keyword", "getAllAraekeyword", "getAllNoofEmpoyee", "getAllPlans", "lack", "getAllTurnOver", "getDataMember", "getDataMemberKey", "keyword", "membershiptype", "min_employee", "max_employee", "business_category", "turn_over", "location", "rank", "getconnection_request_sent", "mdata", "", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/drawer/j4emembers/model/Memberinfo;", "img", "Landroid/widget/ImageView;", "pos", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onClickPos", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "recyclerData", "app_debug"})
public final class FragJ4EMembers extends com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseFragment implements com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.interfaces.OnClickLinerJ4e, com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.adapters.AdapterJ4EMemPlans.OnClick2, com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.adapters.AdapterJ4ECategory.OnClick2, com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.adapters.AdapterTurnOverJ4e.OnClick2, com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.adapters.AdapterNoofEmpolyee.OnClick2 {
    private com.justforentrepreneurs.j4eapp.databinding.FragmentFragJ4EMembersBinding binding;
    private android.content.Context mContext;
    @org.jetbrains.annotations.Nullable()
    private com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity mActivity;
    private final int positionI = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String areaid = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String turnid = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String planid = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String rankck = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String areanamem = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String turnidnamem = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String lstChk = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String AboutId = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String AboutValue = "";
    private java.lang.String position = "";
    private final java.lang.String sharedPrefFile = "J4EMembersActivity";
    private int is_post_exhausted = -1;
    private int is_requirement_exhausted = -1;
    private int is_buddy_meet_exhausted = -1;
    private int count_available = -1;
    private int is_referral_exhausted = -1;
    private java.util.HashMap _$_findViewCache;
    
    public FragJ4EMembers(int position) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity getMActivity() {
        return null;
    }
    
    public final void setMActivity(@org.jetbrains.annotations.Nullable()
    com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAreaid() {
        return null;
    }
    
    public final void setAreaid(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTurnid() {
        return null;
    }
    
    public final void setTurnid(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPlanid() {
        return null;
    }
    
    public final void setPlanid(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRankck() {
        return null;
    }
    
    public final void setRankck(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAreanamem() {
        return null;
    }
    
    public final void setAreanamem(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTurnidnamem() {
        return null;
    }
    
    public final void setTurnidnamem(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLstChk() {
        return null;
    }
    
    public final void setLstChk(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAboutId() {
        return null;
    }
    
    public final void setAboutId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAboutValue() {
        return null;
    }
    
    public final void setAboutValue(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    
    public final int getCount_available() {
        return 0;
    }
    
    public final void setCount_available(int p0) {
    }
    
    public final int is_referral_exhausted() {
        return 0;
    }
    
    public final void set_referral_exhausted(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void app_check_permissions() {
    }
    
    @java.lang.Override()
    public void onClickPos(int pos, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.Memberinfo> mdata, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView img) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    public void OnClickpro(int position, @org.jetbrains.annotations.NotNull()
    java.lang.String data, int is_viewed) {
    }
    
    @java.lang.Override()
    public void OnClick(@org.jetbrains.annotations.NotNull()
    java.lang.String position, @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.databinding.BsMemberFilterBinding mBsMemberFilterBinding) {
    }
    
    @java.lang.Override()
    public void OnEmpClick(@org.jetbrains.annotations.NotNull()
    java.lang.String position, @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.databinding.BsMemberFilterBinding mBsMemberFilterBinding) {
    }
    
    @java.lang.Override()
    public void OnClickJ4e(@org.jetbrains.annotations.NotNull()
    java.lang.String position, @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.databinding.BsMemberFilterBinding mBsMemberFilterBinding) {
    }
    
    @java.lang.Override()
    public void OnClickPlan(@org.jetbrains.annotations.NotNull()
    java.lang.String position, @org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    private final void getAllNoofEmpoyee(com.justforentrepreneurs.j4eapp.databinding.BsMemberFilterBinding mBsMemberFilterBinding) {
    }
    
    private final void getAllPlans(com.justforentrepreneurs.j4eapp.databinding.BsMemberFilterBinding mBsMemberFilterBinding, java.lang.String lack) {
    }
    
    private final void getAllTurnOver(com.justforentrepreneurs.j4eapp.databinding.BsMemberFilterBinding mBsMemberFilterBinding) {
    }
    
    private final void getAllAraekeyword(com.justforentrepreneurs.j4eapp.databinding.BsMemberFilterBinding mBsMemberFilterBinding, java.lang.String Keyword) {
    }
    
    private final void getAllArae(com.justforentrepreneurs.j4eapp.databinding.BsMemberFilterBinding mBsMemberFilterBinding, java.lang.String Keyword) {
    }
    
    private final void getconnection_request_sent(java.lang.String id, java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.Memberinfo> mdata, android.widget.ImageView img, int pos) {
    }
    
    private final void getDataMember(java.lang.String position) {
    }
    
    private final void getDataMemberKey(java.lang.String keyword, java.lang.String membershiptype, java.lang.String min_employee, java.lang.String max_employee, java.lang.String business_category, java.lang.String turn_over, java.lang.String location, java.lang.String rank) {
    }
    
    private final void recyclerData() {
    }
    
    private final void bottomSheetFilter() {
    }
    
    private final void PermissionDialog(java.lang.String massage) {
    }
}