// Generated by data binding compiler. Do not edit!
package com.justforentrepreneurs.j4eapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.justforentrepreneurs.j4eapp.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class BmCreateBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivcancle;

  @NonNull
  public final LinearLayout linearlayoutCreateBuddyMeet;

  @NonNull
  public final LinearLayout linearlayoutCreateBuddyMeet1;

  @NonNull
  public final LinearLayout linearlayoutCreateDeal;

  @NonNull
  public final LinearLayout linearlayoutCreateDeal1;

  @NonNull
  public final LinearLayout linearlayoutCreateEvent;

  @NonNull
  public final LinearLayout linearlayoutCreateOfflineBusiness;

  @NonNull
  public final LinearLayout linearlayoutCreateOfflineBusiness1;

  @NonNull
  public final LinearLayout linearlayoutCreatePost;

  @NonNull
  public final LinearLayout linearlayoutCreatePost1;

  @NonNull
  public final LinearLayout linearlayoutCreateReferral;

  @NonNull
  public final LinearLayout linearlayoutCreateReferral1;

  @NonNull
  public final LinearLayout linearlayoutCreateReq;

  @NonNull
  public final LinearLayout linearlayoutCreateReq1;

  @NonNull
  public final LinearLayout linearlayoutMenu1;

  @NonNull
  public final LinearLayout linearlayoutMenu2;

  @NonNull
  public final TextView memberdetails;

  protected BmCreateBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView ivcancle, LinearLayout linearlayoutCreateBuddyMeet,
      LinearLayout linearlayoutCreateBuddyMeet1, LinearLayout linearlayoutCreateDeal,
      LinearLayout linearlayoutCreateDeal1, LinearLayout linearlayoutCreateEvent,
      LinearLayout linearlayoutCreateOfflineBusiness,
      LinearLayout linearlayoutCreateOfflineBusiness1, LinearLayout linearlayoutCreatePost,
      LinearLayout linearlayoutCreatePost1, LinearLayout linearlayoutCreateReferral,
      LinearLayout linearlayoutCreateReferral1, LinearLayout linearlayoutCreateReq,
      LinearLayout linearlayoutCreateReq1, LinearLayout linearlayoutMenu1,
      LinearLayout linearlayoutMenu2, TextView memberdetails) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivcancle = ivcancle;
    this.linearlayoutCreateBuddyMeet = linearlayoutCreateBuddyMeet;
    this.linearlayoutCreateBuddyMeet1 = linearlayoutCreateBuddyMeet1;
    this.linearlayoutCreateDeal = linearlayoutCreateDeal;
    this.linearlayoutCreateDeal1 = linearlayoutCreateDeal1;
    this.linearlayoutCreateEvent = linearlayoutCreateEvent;
    this.linearlayoutCreateOfflineBusiness = linearlayoutCreateOfflineBusiness;
    this.linearlayoutCreateOfflineBusiness1 = linearlayoutCreateOfflineBusiness1;
    this.linearlayoutCreatePost = linearlayoutCreatePost;
    this.linearlayoutCreatePost1 = linearlayoutCreatePost1;
    this.linearlayoutCreateReferral = linearlayoutCreateReferral;
    this.linearlayoutCreateReferral1 = linearlayoutCreateReferral1;
    this.linearlayoutCreateReq = linearlayoutCreateReq;
    this.linearlayoutCreateReq1 = linearlayoutCreateReq1;
    this.linearlayoutMenu1 = linearlayoutMenu1;
    this.linearlayoutMenu2 = linearlayoutMenu2;
    this.memberdetails = memberdetails;
  }

  @NonNull
  public static BmCreateBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.bm_create, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static BmCreateBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<BmCreateBinding>inflateInternal(inflater, R.layout.bm_create, root, attachToRoot, component);
  }

  @NonNull
  public static BmCreateBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.bm_create, null, false, component)
   */
  @NonNull
  @Deprecated
  public static BmCreateBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<BmCreateBinding>inflateInternal(inflater, R.layout.bm_create, null, false, component);
  }

  public static BmCreateBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static BmCreateBinding bind(@NonNull View view, @Nullable Object component) {
    return (BmCreateBinding)bind(component, view, R.layout.bm_create);
  }
}
