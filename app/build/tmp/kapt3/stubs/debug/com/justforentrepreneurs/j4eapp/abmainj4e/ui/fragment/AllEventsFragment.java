package com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001e\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00072\u0006\u0010$\u001a\u00020\u0004H\u0016J\b\u0010%\u001a\u00020!H\u0002J\b\u0010&\u001a\u00020!H\u0002J\u0010\u0010\'\u001a\u00020!2\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u0014H\u0002J\u001a\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020!H\u0002J&\u00103\u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00072\u0006\u00104\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0004H\u0016J\b\u00105\u001a\u00020!H\u0002R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u000e\u0010\u001f\u001a\u00020\u0014X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/fragment/AllEventsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/SingleSlection;", "position", "", "(I)V", "companyName", "", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/fragment/model/Allevents$Alleventsdata;", "getCompanyName", "()Ljava/util/List;", "setCompanyName", "(Ljava/util/List;)V", "mainActivity", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/home/MainActivity;", "getMainActivity", "()Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/home/MainActivity;", "setMainActivity", "(Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/home/MainActivity;)V", "new1st", "", "getNew1st", "()Ljava/lang/String;", "setNew1st", "(Ljava/lang/String;)V", "new2st", "getNew2st", "setNew2st", "rankck", "getRankck", "setRankck", "sharedPrefFile", "addMultiSelection", "", "multiModel", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/model/Eventcategory$Eventdata;", "pos", "changeTabsFont", "getAllEvents", "getAllEventsCat", "mBsMemberFilterBinding", "Lcom/justforentrepreneurs/j4eapp/databinding/BsAllEventsFilterBinding;", "getAllEventskey", "type", "category", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "recyclerData", "removeMultiSelection", "id", "setupViewPager", "Companion", "app_debug"})
public final class AllEventsFragment extends androidx.fragment.app.Fragment implements com.justforentrepreneurs.j4eapp.abmainj4e.SingleSlection {
    public com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity mainActivity;
    private final java.lang.String sharedPrefFile = "AllEventsFragment";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String rankck = "";
    @org.jetbrains.annotations.NotNull()
    public static final com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment.AllEventsFragment.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.Eventcategory.Eventdata> lstChk;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String new1st = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String new2st = "";
    private final int position = 0;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment.model.Allevents.Alleventsdata> companyName;
    private java.util.HashMap _$_findViewCache;
    
    public AllEventsFragment(int position) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity getMainActivity() {
        return null;
    }
    
    public final void setMainActivity(@org.jetbrains.annotations.NotNull()
    com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRankck() {
        return null;
    }
    
    public final void setRankck(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNew1st() {
        return null;
    }
    
    public final void setNew1st(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNew2st() {
        return null;
    }
    
    public final void setNew2st(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment.model.Allevents.Alleventsdata> getCompanyName() {
        return null;
    }
    
    public final void setCompanyName(@org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment.model.Allevents.Alleventsdata> p0) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void recyclerData() {
    }
    
    private final void getAllEvents() {
    }
    
    private final void getAllEventsCat(com.justforentrepreneurs.j4eapp.databinding.BsAllEventsFilterBinding mBsMemberFilterBinding) {
    }
    
    private final void getAllEventskey(java.lang.String type, java.lang.String category) {
    }
    
    @java.lang.Override()
    public void addMultiSelection(@org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.Eventcategory.Eventdata> multiModel, int pos) {
    }
    
    @java.lang.Override()
    public void removeMultiSelection(@org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.Eventcategory.Eventdata> multiModel, @org.jetbrains.annotations.NotNull()
    java.lang.String id, int pos) {
    }
    
    private final void setupViewPager() {
    }
    
    private final void changeTabsFont() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/fragment/AllEventsFragment$Companion;", "", "()V", "lstChk", "", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/model/Eventcategory$Eventdata;", "getLstChk", "()Ljava/util/List;", "setLstChk", "(Ljava/util/List;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.Eventcategory.Eventdata> getLstChk() {
            return null;
        }
        
        public final void setLstChk(@org.jetbrains.annotations.NotNull()
        java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.Eventcategory.Eventdata> p0) {
        }
    }
}