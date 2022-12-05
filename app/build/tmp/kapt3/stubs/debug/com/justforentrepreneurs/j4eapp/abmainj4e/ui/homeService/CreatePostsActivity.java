package com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020/J\b\u00101\u001a\u00020/H\u0002J\u0018\u00102\u001a\u00020/2\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0005H\u0016J\u0010\u00105\u001a\u00020/2\u0006\u00106\u001a\u00020\u0005H\u0002J\u0010\u00107\u001a\u00020/2\u0006\u00108\u001a\u00020\u0005H\u0002J\u0018\u00109\u001a\u00020/2\u0006\u00108\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0005H\u0002J\u0006\u0010;\u001a\u00020<J\b\u0010=\u001a\u00020/H\u0002J\b\u0010>\u001a\u00020\u0005H\u0002J\u0016\u0010?\u001a\u00020/2\u0006\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020BJ\b\u0010C\u001a\u00020<H\u0016J\b\u0010D\u001a\u00020/H\u0002J\"\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u000bJ\u0012\u0010I\u001a\u0004\u0018\u00010F2\u0006\u0010J\u001a\u00020\u0005H\u0002J\u001c\u0010K\u001a\u00020/2\u0006\u0010@\u001a\u00020\u00052\f\u0010L\u001a\b\u0012\u0004\u0012\u00020N0MJ\"\u0010O\u001a\u00020/2\u0006\u0010P\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\u000b2\b\u0010R\u001a\u0004\u0018\u00010SH\u0014J\u0012\u0010T\u001a\u00020/2\b\u0010U\u001a\u0004\u0018\u00010VH\u0014J\u0006\u0010W\u001a\u00020/J-\u0010X\u001a\u00020/2\u0006\u0010P\u001a\u00020\u000b2\u000e\u0010Y\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050Z2\u0006\u0010[\u001a\u00020\\H\u0016\u00a2\u0006\u0002\u0010]J\b\u0010^\u001a\u00020/H\u0002J\b\u0010_\u001a\u00020/H\u0002J\u0018\u0010`\u001a\u00020/2\u0006\u0010a\u001a\u00020F2\u0006\u0010b\u001a\u00020\u0005H\u0002J\u0006\u0010c\u001a\u00020<J\u0006\u0010d\u001a\u00020<R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR\u0010\u0010\'\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\t\u00a8\u0006e"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/CreatePostsActivity;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/base/BaseActivity;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/adapters/AdapterPostCategoriesNew$OnClick2;", "()V", "ID", "", "getID", "()Ljava/lang/String;", "setID", "(Ljava/lang/String;)V", "PERMISSION_CODEGallry", "", "PERMISSION_CODEcamera", "PERMISSION_REQUEST_CODE", "Path", "getPath", "setPath", "TYPE", "getTYPE", "setTYPE", "binding", "Lcom/justforentrepreneurs/j4eapp/databinding/ActivityCreatePostsBinding;", "destination", "Ljava/io/File;", "downis", "Ljava/io/InputStream;", "getDownis", "()Ljava/io/InputStream;", "setDownis", "(Ljava/io/InputStream;)V", "downsizedImageBytes", "", "getDownsizedImageBytes", "()[B", "setDownsizedImageBytes", "([B)V", "editedData", "getEditedData", "setEditedData", "imageUri3", "Landroid/net/Uri;", "pickImage3", "pickImage4", "selectedData", "getSelectedData", "setSelectedData", "CheckperimmissionGallery", "", "Checkperimmissioncamera", "DeleteDialog", "OnClick", "position", "id", "PermissionDialog", "massage", "app_create_Post", "attachment", "app_edit_Post", "POSTID", "checkPermissions", "", "checkUserRequestedDontAskAgain", "currentDateFormat", "delete_image", "post_id", "dialog", "Landroid/app/Dialog;", "enablePresence", "getAllPostCate", "fullBitmap", "Landroid/graphics/Bitmap;", "scaleWidth", "scaleHeight", "getImageFileFromSDCard", "filename", "get_edit_post_detail", "companyName", "", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/homeService/model/PostCategrory$Postdata;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onInitListener", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestPermissions", "showAlertDialog", "storeCameraPhotoInSDCard", "bitmap", "currentDate", "validation", "validationText", "app_debug"})
public final class CreatePostsActivity extends com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity implements com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.adapters.AdapterPostCategoriesNew.OnClick2 {
    private com.justforentrepreneurs.j4eapp.databinding.ActivityCreatePostsBinding binding;
    private final int pickImage3 = 103;
    private final int pickImage4 = 104;
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
    private java.lang.String selectedData = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String editedData = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String ID = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String TYPE = "";
    private final int PERMISSION_REQUEST_CODE = 159;
    private java.util.HashMap _$_findViewCache;
    
    public CreatePostsActivity() {
        super();
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
    public final java.lang.String getSelectedData() {
        return null;
    }
    
    public final void setSelectedData(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEditedData() {
        return null;
    }
    
    public final void setEditedData(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getID() {
        return null;
    }
    
    public final void setID(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTYPE() {
        return null;
    }
    
    public final void setTYPE(@org.jetbrains.annotations.NotNull()
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
    
    public final void onInitListener() {
    }
    
    private final void getAllPostCate() {
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
    
    private final void app_create_Post(java.lang.String attachment) {
    }
    
    private final void app_edit_Post(java.lang.String attachment, java.lang.String POSTID) {
    }
    
    private final void PermissionDialog(java.lang.String massage) {
    }
    
    public final void get_edit_post_detail(@org.jetbrains.annotations.NotNull()
    java.lang.String post_id, @org.jetbrains.annotations.NotNull()
    java.util.List<com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.PostCategrory.Postdata> companyName) {
    }
    
    private final void DeleteDialog() {
    }
    
    public final void delete_image(@org.jetbrains.annotations.NotNull()
    java.lang.String post_id, @org.jetbrains.annotations.NotNull()
    android.app.Dialog dialog) {
    }
    
    private final void showAlertDialog() {
    }
    
    private final void requestPermissions() {
    }
    
    public final boolean checkPermissions() {
        return false;
    }
    
    @java.lang.Override()
    public void OnClick(@org.jetbrains.annotations.NotNull()
    java.lang.String position, @org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    private final void checkUserRequestedDontAskAgain() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
}