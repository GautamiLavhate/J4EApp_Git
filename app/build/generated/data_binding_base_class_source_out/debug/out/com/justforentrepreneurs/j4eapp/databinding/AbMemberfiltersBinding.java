// Generated by data binding compiler. Do not edit!
package com.justforentrepreneurs.j4eapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.justforentrepreneurs.j4eapp.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class AbMemberfiltersBinding extends ViewDataBinding {
  @NonNull
  public final EditText editlocation;

  @NonNull
  public final LinearLayout llLocation;

  @NonNull
  public final LinearLayout llRank;

  @NonNull
  public final LinearLayout llTypeMembership;

  protected AbMemberfiltersBinding(Object _bindingComponent, View _root, int _localFieldCount,
      EditText editlocation, LinearLayout llLocation, LinearLayout llRank,
      LinearLayout llTypeMembership) {
    super(_bindingComponent, _root, _localFieldCount);
    this.editlocation = editlocation;
    this.llLocation = llLocation;
    this.llRank = llRank;
    this.llTypeMembership = llTypeMembership;
  }

  @NonNull
  public static AbMemberfiltersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.ab_memberfilters, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AbMemberfiltersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AbMemberfiltersBinding>inflateInternal(inflater, R.layout.ab_memberfilters, root, attachToRoot, component);
  }

  @NonNull
  public static AbMemberfiltersBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.ab_memberfilters, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AbMemberfiltersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AbMemberfiltersBinding>inflateInternal(inflater, R.layout.ab_memberfilters, null, false, component);
  }

  public static AbMemberfiltersBinding bind(@NonNull View view) {
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
  public static AbMemberfiltersBinding bind(@NonNull View view, @Nullable Object component) {
    return (AbMemberfiltersBinding)bind(component, view, R.layout.ab_memberfilters);
  }
}
