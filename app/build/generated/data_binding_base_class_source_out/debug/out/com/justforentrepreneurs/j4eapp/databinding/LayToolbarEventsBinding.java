// Generated by data binding compiler. Do not edit!
package com.justforentrepreneurs.j4eapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.justforentrepreneurs.j4eapp.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class LayToolbarEventsBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivAttendanceList;

  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final ImageView ivEventStatus;

  @NonNull
  public final ImageView ivMarkAttendance;

  @NonNull
  public final ImageView ivShare;

  @NonNull
  public final ImageView ivedit;

  @NonNull
  public final TextView tvTitle;

  protected LayToolbarEventsBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView ivAttendanceList, ImageView ivBack, ImageView ivEventStatus,
      ImageView ivMarkAttendance, ImageView ivShare, ImageView ivedit, TextView tvTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivAttendanceList = ivAttendanceList;
    this.ivBack = ivBack;
    this.ivEventStatus = ivEventStatus;
    this.ivMarkAttendance = ivMarkAttendance;
    this.ivShare = ivShare;
    this.ivedit = ivedit;
    this.tvTitle = tvTitle;
  }

  @NonNull
  public static LayToolbarEventsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.lay_toolbar_events, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static LayToolbarEventsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<LayToolbarEventsBinding>inflateInternal(inflater, R.layout.lay_toolbar_events, root, attachToRoot, component);
  }

  @NonNull
  public static LayToolbarEventsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.lay_toolbar_events, null, false, component)
   */
  @NonNull
  @Deprecated
  public static LayToolbarEventsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<LayToolbarEventsBinding>inflateInternal(inflater, R.layout.lay_toolbar_events, null, false, component);
  }

  public static LayToolbarEventsBinding bind(@NonNull View view) {
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
  public static LayToolbarEventsBinding bind(@NonNull View view, @Nullable Object component) {
    return (LayToolbarEventsBinding)bind(component, view, R.layout.lay_toolbar_events);
  }
}