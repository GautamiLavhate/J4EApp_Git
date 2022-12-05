package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u00108\u001a\u000209J\u0006\u0010:\u001a\u000209J\u0010\u0010;\u001a\u0002092\u0006\u0010<\u001a\u00020\bH\u0016J\u0018\u0010;\u001a\u0002092\u0006\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\rH\u0016J\u0018\u0010>\u001a\u0002092\u0006\u0010<\u001a\u00020\b2\u0006\u0010?\u001a\u00020\rH\u0016JH\u0010@\u001a\u0002092\u0006\u0010A\u001a\u00020\r2\u0006\u0010B\u001a\u00020\r2\u0016\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\r0+j\b\u0012\u0004\u0012\u00020\r`,2\u0016\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\r0+j\b\u0012\u0004\u0012\u00020\r`,H\u0016J \u0010E\u001a\u0002092\u0006\u0010F\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010G\u001a\u00020\rH\u0002J\u0006\u0010H\u001a\u00020IJ\b\u0010J\u001a\u000209H\u0002J\b\u0010K\u001a\u00020\rH\u0002J\b\u0010L\u001a\u00020IH\u0016J\b\u0010M\u001a\u000209H\u0002J\b\u0010N\u001a\u000209H\u0002J\"\u0010!\u001a\u0004\u0018\u00010 2\b\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020\bJ\u0012\u0010S\u001a\u0004\u0018\u00010P2\u0006\u0010T\u001a\u00020\rH\u0002J\"\u0010U\u001a\u0002092\u0006\u0010V\u001a\u00020\b2\u0006\u0010W\u001a\u00020\b2\b\u0010X\u001a\u0004\u0018\u00010YH\u0014J\u0012\u0010Z\u001a\u0002092\b\u0010[\u001a\u0004\u0018\u00010\\H\u0014J\u0006\u0010]\u001a\u000209J-\u0010^\u001a\u0002092\u0006\u0010V\u001a\u00020\b2\u000e\u0010_\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0`2\u0006\u0010a\u001a\u00020bH\u0016\u00a2\u0006\u0002\u0010cJ\b\u0010d\u001a\u000209H\u0002J\b\u0010e\u001a\u000209H\u0002J\u0018\u0010f\u001a\u0002092\u0006\u0010g\u001a\u00020P2\u0006\u0010h\u001a\u00020\rH\u0002J\u0006\u0010i\u001a\u00020IJ\u0006\u0010j\u001a\u00020IR\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u000f\"\u0004\b\'\u0010\u0011R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010*\u001a\u0012\u0012\u0004\u0012\u00020)0+j\b\u0012\u0004\u0012\u00020)`,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011R \u00103\u001a\b\u0012\u0004\u0012\u00020\r0+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010.\"\u0004\b5\u00100R\u000e\u00106\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006k"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/CreateEventsActivity;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/base/BaseActivity;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/adapters/AdapterCategoryEvent$OnClick2;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/adapters/AdapterGallerymultiple$OnClick2;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/adapters/AdapterPermission$OnClick3;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/adapters/AdapterPackage$OnClickPackage;", "()V", "PERMISSION_CODEGallry", "", "PERMISSION_CODEcamera", "PERMISSION_REQUEST_CODE", "PICK_IMAGE_MULTIPLE", "Path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "areaid", "getAreaid", "setAreaid", "binding", "Lcom/justforentrepreneurs/j4eapp/databinding/ActivityCreateEventsBinding;", "destination", "Ljava/io/File;", "downis", "Ljava/io/InputStream;", "getDownis", "()Ljava/io/InputStream;", "setDownis", "(Ljava/io/InputStream;)V", "downsizedImageBytes", "", "getDownsizedImageBytes", "()[B", "setDownsizedImageBytes", "([B)V", "event_permission", "getEvent_permission", "setEvent_permission", "imageUri3", "Landroid/net/Uri;", "imagesUriArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getImagesUriArrayList", "()Ljava/util/ArrayList;", "setImagesUriArrayList", "(Ljava/util/ArrayList;)V", "isPackageSelected", "setPackageSelected", "permission_array", "getPermission_array", "setPermission_array", "pickImage3", "pickImage4", "CheckperimmissionGallery", "", "Checkperimmissioncamera", "OnClick", "position", "id", "OnClick3", "permission_name", "OnClickPackage", "packageName", "packageId", "array", "array_name", "app_create_event", "attachment", "typepubish", "checkPermissions", "", "checkUserRequestedDontAskAgain", "currentDateFormat", "enablePresence", "getAllEvents", "getAllPlans", "fullBitmap", "Landroid/graphics/Bitmap;", "scaleWidth", "scaleHeight", "getImageFileFromSDCard", "filename", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onInitListener", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestPermissions", "showAlertDialog", "storeCameraPhotoInSDCard", "bitmap", "currentDate", "validation", "validationText", "app_debug"})
public final class CreateEventsActivity extends com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity implements com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters.AdapterCategoryEvent.OnClick2, com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters.AdapterGallerymultiple.OnClick2, com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters.AdapterPermission.OnClick3, com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters.AdapterPackage.OnClickPackage {
    private com.justforentrepreneurs.j4eapp.databinding.ActivityCreateEventsBinding binding;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String areaid = "";
    private final int pickImage3 = 103;
    private final int pickImage4 = 104;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String event_permission = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String isPackageSelected = "0";
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
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> permission_array;
    private java.util.HashMap _$_findViewCache;
    
    public CreateEventsActivity() {
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
    public final java.lang.String getEvent_permission() {
        return null;
    }
    
    public final void setEvent_permission(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String isPackageSelected() {
        return null;
    }
    
    public final void setPackageSelected(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    public final java.util.ArrayList<java.lang.String> getPermission_array() {
        return null;
    }
    
    public final void setPermission_array(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void onInitListener() {
    }
    
    private final void getAllPlans() {
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
    
    public final boolean validationText() {
        return false;
    }
    
    @java.lang.Override()
    public void OnClick(@org.jetbrains.annotations.NotNull()
    java.lang.String position, @org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    private final void getAllEvents() {
    }
    
    private final void app_create_event(java.lang.String attachment, byte[] downsizedImageBytes, java.lang.String typepubish) {
    }
    
    @java.lang.Override()
    public void OnClick(int position) {
    }
    
    @java.lang.Override()
    public void OnClick3(int position, @org.jetbrains.annotations.NotNull()
    java.lang.String permission_name) {
    }
    
    @java.lang.Override()
    public void OnClickPackage(@org.jetbrains.annotations.NotNull()
    java.lang.String packageName, @org.jetbrains.annotations.NotNull()
    java.lang.String packageId, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> array, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> array_name) {
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