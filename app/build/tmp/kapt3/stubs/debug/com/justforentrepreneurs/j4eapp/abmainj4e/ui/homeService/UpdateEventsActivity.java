package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0006\u00108\u001a\u000209J\u0006\u0010:\u001a\u000209J\u0010\u0010;\u001a\u0002092\u0006\u0010<\u001a\u00020\u0006H\u0016J\u0018\u0010;\u001a\u0002092\u0006\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u000bH\u0016J\u0010\u0010>\u001a\u0002092\u0006\u0010?\u001a\u00020\u000bH\u0002J\u0018\u0010@\u001a\u0002092\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000bH\u0002J\u0006\u0010C\u001a\u00020DJ\b\u0010E\u001a\u000209H\u0002J\b\u0010F\u001a\u00020\u000bH\u0002J\b\u0010G\u001a\u00020DH\u0016J\b\u0010H\u001a\u000209H\u0002J\"\u0010\'\u001a\u0004\u0018\u00010&2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010K\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\u0006J\u0010\u0010M\u001a\u0002092\u0006\u0010+\u001a\u00020\u000bH\u0002J\u0012\u0010N\u001a\u0004\u0018\u00010J2\u0006\u0010O\u001a\u00020\u000bH\u0002J\"\u0010P\u001a\u0002092\u0006\u0010Q\u001a\u00020\u00062\u0006\u0010R\u001a\u00020\u00062\b\u0010S\u001a\u0004\u0018\u00010TH\u0014J\u0012\u0010U\u001a\u0002092\b\u0010V\u001a\u0004\u0018\u00010WH\u0014J\u0006\u0010X\u001a\u000209J-\u0010Y\u001a\u0002092\u0006\u0010Q\u001a\u00020\u00062\u000e\u0010Z\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0[2\u0006\u0010\\\u001a\u00020]H\u0016\u00a2\u0006\u0002\u0010^J\b\u0010_\u001a\u000209H\u0002J\b\u0010`\u001a\u000209H\u0002J\u0018\u0010a\u001a\u0002092\u0006\u0010b\u001a\u00020J2\u0006\u0010c\u001a\u00020\u000bH\u0002J\u0006\u0010d\u001a\u00020DR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0018\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u00100\u001a\b\u0012\u0004\u0012\u00020/01X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u000e\u00106\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006e"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/UpdateEventsActivity;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/base/BaseActivity;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/adapters/AdapterCategoryEvent$OnClick2;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/adapters/AdapterGallerymultiple$OnClick2;", "()V", "PERMISSION_CODEGallry", "", "PERMISSION_CODEcamera", "PERMISSION_REQUEST_CODE", "PICK_IMAGE_MULTIPLE", "Path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "areaid", "getAreaid", "setAreaid", "binding", "Lcom/justforentrepreneurs/j4eapp/databinding/ActivityCreateEventsBinding;", "dataimage", "getDataimage", "setDataimage", "dataimage1", "getDataimage1", "()I", "setDataimage1", "(I)V", "destination", "Ljava/io/File;", "downis", "Ljava/io/InputStream;", "getDownis", "()Ljava/io/InputStream;", "setDownis", "(Ljava/io/InputStream;)V", "downsizedImageBytes", "", "getDownsizedImageBytes", "()[B", "setDownsizedImageBytes", "([B)V", "eventid", "getEventid", "setEventid", "imageUri3", "Landroid/net/Uri;", "imagesUriArrayList", "Ljava/util/ArrayList;", "getImagesUriArrayList", "()Ljava/util/ArrayList;", "setImagesUriArrayList", "(Ljava/util/ArrayList;)V", "pickImage3", "pickImage4", "CheckperimmissionGallery", "", "Checkperimmissioncamera", "OnClick", "position", "id", "PermissionDialog", "massage", "app_create_event", "attachment", "typest", "checkPermissions", "", "checkUserRequestedDontAskAgain", "currentDateFormat", "enablePresence", "getAllEvents", "fullBitmap", "Landroid/graphics/Bitmap;", "scaleWidth", "scaleHeight", "getEventsDeatils", "getImageFileFromSDCard", "filename", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onInitListener", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestPermissions", "showAlertDialog", "storeCameraPhotoInSDCard", "bitmap", "currentDate", "validation", "app_debug"})
public final class UpdateEventsActivity extends com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity implements com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters.AdapterCategoryEvent.OnClick2, com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters.AdapterGallerymultiple.OnClick2 {
    private com.justforentrepreneurs.j4eapp.databinding.ActivityCreateEventsBinding binding;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String areaid = "";
    private final int pickImage3 = 103;
    private final int pickImage4 = 104;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String dataimage = "";
    private int dataimage1 = 0;
    private final int PERMISSION_REQUEST_CODE = 159;
    private final int PICK_IMAGE_MULTIPLE = 1005;
    private android.net.Uri imageUri3;
    private final int PERMISSION_CODEGallry = 1001;
    private final int PERMISSION_CODEcamera = 1002;
    public byte[] downsizedImageBytes;
    private java.io.File destination;
    @org.jetbrains.annotations.Nullable()
    private java.io.InputStream downis;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String Path = "";
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<android.net.Uri> imagesUriArrayList;
    public java.lang.String eventid;
    private java.util.HashMap _$_findViewCache;
    
    public UpdateEventsActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAreaid() {
        return null;
    }
    
    public final void setAreaid(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDataimage() {
        return null;
    }
    
    public final void setDataimage(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getDataimage1() {
        return 0;
    }
    
    public final void setDataimage1(int p0) {
    }
    
    @java.lang.Override()
    public boolean enablePresence() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getDownsizedImageBytes() {
        return null;
    }
    
    public final void setDownsizedImageBytes(@org.jetbrains.annotations.NotNull()
    byte[] p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.io.InputStream getDownis() {
        return null;
    }
    
    public final void setDownis(@org.jetbrains.annotations.Nullable()
    java.io.InputStream p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPath() {
        return null;
    }
    
    public final void setPath(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<android.net.Uri> getImagesUriArrayList() {
        return null;
    }
    
    public final void setImagesUriArrayList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<android.net.Uri> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEventid() {
        return null;
    }
    
    public final void setEventid(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void onInitListener() {
    }
    
    public final void Checkperimmissioncamera() {
    }
    
    public final void CheckperimmissionGallery() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final android.graphics.Bitmap getImageFileFromSDCard(java.lang.String filename) {
        return null;
    }
    
    private final java.lang.String currentDateFormat() {
        return null;
    }
    
    private final void storeCameraPhotoInSDCard(android.graphics.Bitmap bitmap, java.lang.String currentDate) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
    public final byte[] getDownsizedImageBytes(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap fullBitmap, int scaleWidth, int scaleHeight) throws java.io.IOException {
        return null;
    }
    
    public final boolean validation() {
        return false;
    }
    
    @java.lang.Override()
    public void OnClick(@org.jetbrains.annotations.NotNull()
    java.lang.String position, @org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    private final void getAllEvents() {
    }
    
    private final void app_create_event(java.lang.String attachment, java.lang.String typest) {
    }
    
    @java.lang.Override()
    public void OnClick(int position) {
    }
    
    private final void getEventsDeatils(java.lang.String eventid) {
    }
    
    private final void PermissionDialog(java.lang.String massage) {
    }
    
    private final void showAlertDialog() {
    }
    
    private final void requestPermissions() {
    }
    
    public final boolean checkPermissions() {
        return false;
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final void checkUserRequestedDontAskAgain() {
    }
}