package com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0005\u00a2\u0006\u0002\u0010\u0007J\u0006\u00107\u001a\u000208J\u0006\u00109\u001a\u000208J\b\u0010:\u001a\u000208H\u0002J\b\u0010;\u001a\u000208H\u0002J\u0010\u0010<\u001a\u0002082\u0006\u0010=\u001a\u00020\tH\u0016J\u0018\u0010<\u001a\u0002082\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\tH\u0016J\u0010\u0010@\u001a\u0002082\u0006\u0010=\u001a\u00020\tH\u0016J\u0010\u0010A\u001a\u0002082\u0006\u0010=\u001a\u00020\tH\u0016J\u0018\u0010B\u001a\u0002082\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\tH\u0016J\u0006\u0010C\u001a\u00020DJ\b\u0010E\u001a\u000208H\u0002J\"\u0010F\u001a\u0002082\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010+2\b\u0010J\u001a\u0004\u0018\u00010\u001dJ\u001a\u0010K\u001a\u00020\u00122\b\u0010L\u001a\u0004\u0018\u00010\u001f2\b\u0010M\u001a\u0004\u0018\u00010NJ\b\u0010O\u001a\u00020\tH\u0002J\u0010\u0010P\u001a\u0002082\u0006\u0010Q\u001a\u00020RH\u0002J\u0010\u0010S\u001a\u0002082\u0006\u0010Q\u001a\u00020RH\u0002J\b\u0010T\u001a\u00020DH\u0016J\b\u0010U\u001a\u000208H\u0002J\b\u0010V\u001a\u000208H\u0002J\u0010\u0010W\u001a\u0002082\u0006\u0010?\u001a\u00020\tH\u0002J\"\u0010&\u001a\u0004\u0018\u00010%2\b\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010Z\u001a\u00020\u00122\u0006\u0010[\u001a\u00020\u0012J\u0012\u0010\\\u001a\u0004\u0018\u00010\t2\b\u0010]\u001a\u0004\u0018\u00010+J\u001e\u0010^\u001a\u0004\u0018\u00010\t2\b\u0010G\u001a\u0004\u0018\u00010H2\b\u0010_\u001a\u0004\u0018\u00010+H\u0016J\u001e\u0010`\u001a\u0004\u0018\u00010\t2\b\u0010G\u001a\u0004\u0018\u00010H2\b\u0010_\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010a\u001a\u0004\u0018\u00010Y2\u0006\u0010b\u001a\u00020\tH\u0002J \u0010c\u001a\u0002082\u0006\u0010d\u001a\u00020\t2\u0006\u0010$\u001a\u00020%2\u0006\u0010e\u001a\u00020YH\u0002J\"\u0010f\u001a\u0002082\u0006\u0010g\u001a\u00020\u00122\u0006\u0010h\u001a\u00020\u00122\b\u0010i\u001a\u0004\u0018\u00010jH\u0014J\b\u0010k\u001a\u000208H\u0016J\u0012\u0010l\u001a\u0002082\b\u0010m\u001a\u0004\u0018\u00010nH\u0014J\u000e\u0010o\u001a\u0002082\u0006\u0010p\u001a\u00020qJ-\u0010r\u001a\u0002082\u0006\u0010g\u001a\u00020\u00122\u000e\u0010s\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0t2\u0006\u0010u\u001a\u00020vH\u0016\u00a2\u0006\u0002\u0010wJ\b\u0010x\u001a\u000208H\u0002J\b\u0010y\u001a\u000208H\u0002J\b\u0010z\u001a\u000208H\u0002J\b\u0010{\u001a\u000208H\u0002J\b\u0010|\u001a\u000208H\u0002J\b\u0010}\u001a\u000208H\u0002J\b\u0010~\u001a\u000208H\u0002J\u0019\u0010\u007f\u001a\u0002082\u0006\u0010e\u001a\u00020Y2\u0007\u0010\u0080\u0001\u001a\u00020\tH\u0002J\u0007\u0010\u0081\u0001\u001a\u00020DR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0012X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0012X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000b\"\u0004\b0\u0010\rR\u001a\u00101\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u000b\"\u0004\b3\u0010\rR\u001a\u00104\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u000b\"\u0004\b6\u0010\r\u00a8\u0006\u0082\u0001"}, d2 = {"Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/profile/ProfileAboutUsEditActivity;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/base/BaseActivity;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/profile/adapter/AdapterTurnOver$OnClick2;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/profile/adapter/AdapterNoEmployee$OnClick2;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/profile/adapter/AdapterGender$OnClick;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/profile/adapter/AdapterBusinessType$OnClickBusinessType;", "Lcom/justforentrepreneurs/j4eapp/abmainj4e/ui/profile/adapter/AdapterBusinessEntity$OnClickBusinessEntity;", "()V", "AboutId", "", "getAboutId", "()Ljava/lang/String;", "setAboutId", "(Ljava/lang/String;)V", "AboutValue", "getAboutValue", "setAboutValue", "BUFFER_SIZE", "", "IMAGE_DIRECTORY", "PERMISSION_CODEGallry", "PERMISSION_CODEcamera", "PERMISSION_REQUEST_CODE", "Path", "getPath", "setPath", "binding", "Lcom/justforentrepreneurs/j4eapp/databinding/ActivityProfileAboutUsEditBinding;", "destination", "Ljava/io/File;", "downis", "Ljava/io/InputStream;", "getDownis", "()Ljava/io/InputStream;", "setDownis", "(Ljava/io/InputStream;)V", "downsizedImageBytes", "", "getDownsizedImageBytes", "()[B", "setDownsizedImageBytes", "([B)V", "imageUri3", "Landroid/net/Uri;", "pickImage3", "pickImage4", "pptPath", "getPptPath", "setPptPath", "turnoverid", "getTurnoverid", "setTurnoverid", "turnovervalue", "getTurnovervalue", "setTurnovervalue", "CheckperimmissionGallery", "", "Checkperimmissioncamera", "DeleteDialog", "DeleteDialog1", "OnClick", "gender", "position", "id", "OnClickBusinessEntity", "OnClickBusinessType", "OnEmpClick", "checkPermissions", "", "checkUserRequestedDontAskAgain", "copy", "context", "Landroid/content/Context;", "srcUri", "dstFile", "copystream", "input", "output", "Ljava/io/OutputStream;", "currentDateFormat", "delete_pdf", "dialog", "Landroid/app/Dialog;", "delete_ppt", "enablePresence", "getAllNoofEmpoyee", "getAllTurnOver", "getAppUserAbouts", "fullBitmap", "Landroid/graphics/Bitmap;", "scaleWidth", "scaleHeight", "getFileName", "uri", "getFilePathFromURI", "contentUri", "getFilePathFromURI2", "getImageFileFromSDCard", "filename", "getapp_user_edit_profile_pic", "attachment", "bitmap", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onEditBtnClick", "view", "Landroid/view/View;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestPermissions", "showAlertDialog", "spBusinessEntity", "spBusinessExpertise", "spBusinessType", "spExpectedTurnover", "spedtNoOfEmployee", "storeCameraPhotoInSDCard", "currentDate", "validation", "app_debug"})
public final class ProfileAboutUsEditActivity extends com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity implements com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.adapter.AdapterTurnOver.OnClick2, com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.adapter.AdapterNoEmployee.OnClick2, com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.adapter.AdapterGender.OnClick, com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.adapter.AdapterBusinessType.OnClickBusinessType, com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.adapter.AdapterBusinessEntity.OnClickBusinessEntity {
    private com.justforentrepreneurs.j4eapp.databinding.ActivityProfileAboutUsEditBinding binding;
    private final int pickImage3 = 103;
    private final int pickImage4 = 104;
    private android.net.Uri imageUri3;
    private final int PERMISSION_CODEGallry = 1001;
    private final int PERMISSION_CODEcamera = 1002;
    public byte[] downsizedImageBytes;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String turnoverid = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String turnovervalue = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String AboutId = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String AboutValue = "";
    private java.io.File destination;
    @org.jetbrains.annotations.Nullable()
    private java.io.InputStream downis;
    private final int PERMISSION_REQUEST_CODE = 159;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String Path = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String pptPath = "";
    private final int BUFFER_SIZE = 2048;
    private final java.lang.String IMAGE_DIRECTORY = "";
    private java.util.HashMap _$_findViewCache;
    
    public ProfileAboutUsEditActivity() {
        super();
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTurnoverid() {
        return null;
    }
    
    public final void setTurnoverid(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTurnovervalue() {
        return null;
    }
    
    public final void setTurnovervalue(@org.jetbrains.annotations.NotNull()
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
    public final java.lang.String getPptPath() {
        return null;
    }
    
    public final void setPptPath(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void spBusinessEntity() {
    }
    
    private final void spedtNoOfEmployee() {
    }
    
    private final void spBusinessType() {
    }
    
    private final void spBusinessExpertise() {
    }
    
    private final void spExpectedTurnover() {
    }
    
    public final boolean validation() {
        return false;
    }
    
    public final void onEditBtnClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    private final void getAppUserAbouts(java.lang.String id) {
    }
    
    public final void Checkperimmissioncamera() {
    }
    
    public final void CheckperimmissionGallery() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getFilePathFromURI2(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.net.Uri contentUri) {
        return null;
    }
    
    private final void getapp_user_edit_profile_pic(java.lang.String attachment, byte[] downsizedImageBytes, android.graphics.Bitmap bitmap) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
    public final byte[] getDownsizedImageBytes(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap fullBitmap, int scaleWidth, int scaleHeight) throws java.io.IOException {
        return null;
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final void checkUserRequestedDontAskAgain() {
    }
    
    private final android.graphics.Bitmap getImageFileFromSDCard(java.lang.String filename) {
        return null;
    }
    
    private final java.lang.String currentDateFormat() {
        return null;
    }
    
    private final void storeCameraPhotoInSDCard(android.graphics.Bitmap bitmap, java.lang.String currentDate) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getFilePathFromURI(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.net.Uri contentUri) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFileName(@org.jetbrains.annotations.Nullable()
    android.net.Uri uri) {
        return null;
    }
    
    public final void copy(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.net.Uri srcUri, @org.jetbrains.annotations.Nullable()
    java.io.File dstFile) {
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {java.lang.Exception.class, java.io.IOException.class})
    public final int copystream(@org.jetbrains.annotations.Nullable()
    java.io.InputStream input, @org.jetbrains.annotations.Nullable()
    java.io.OutputStream output) throws java.lang.Exception, java.io.IOException {
        return 0;
    }
    
    @java.lang.Override()
    public void OnClick(@org.jetbrains.annotations.NotNull()
    java.lang.String position, @org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    private final void getAllTurnOver() {
    }
    
    private final void getAllNoofEmpoyee() {
    }
    
    @java.lang.Override()
    public void OnEmpClick(@org.jetbrains.annotations.NotNull()
    java.lang.String position, @org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    @java.lang.Override()
    public void OnClick(@org.jetbrains.annotations.NotNull()
    java.lang.String gender) {
    }
    
    @java.lang.Override()
    public void OnClickBusinessType(@org.jetbrains.annotations.NotNull()
    java.lang.String gender) {
    }
    
    @java.lang.Override()
    public void OnClickBusinessEntity(@org.jetbrains.annotations.NotNull()
    java.lang.String gender) {
    }
    
    private final void showAlertDialog() {
    }
    
    private final void requestPermissions() {
    }
    
    public final boolean checkPermissions() {
        return false;
    }
    
    private final void DeleteDialog() {
    }
    
    private final void DeleteDialog1() {
    }
    
    private final void delete_pdf(android.app.Dialog dialog) {
    }
    
    private final void delete_ppt(android.app.Dialog dialog) {
    }
}