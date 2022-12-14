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

public abstract class LayToolbarMyLeadsBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final ImageView ivLeadStatus;

  @NonNull
  public final ImageView ivShare;

  @NonNull
  public final TextView tvTitle;

  protected LayToolbarMyLeadsBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView ivBack, ImageView ivLeadStatus, ImageView ivShare, TextView tvTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivBack = ivBack;
    this.ivLeadStatus = ivLeadStatus;
    this.ivShare = ivShare;
    this.tvTitle = tvTitle;
  }

  @NonNull
  public static LayToolbarMyLeadsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.lay_toolbar_my_leads, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static LayToolbarMyLeadsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<LayToolbarMyLeadsBinding>inflateInternal(inflater, R.layout.lay_toolbar_my_leads, root, attachToRoot, component);
  }

  @NonNull
  public static LayToolbarMyLeadsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.lay_toolbar_my_leads, null, false, component)
   */
  @NonNull
  @Deprecated
  public static LayToolbarMyLeadsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<LayToolbarMyLeadsBinding>inflateInternal(inflater, R.layout.lay_toolbar_my_leads, null, false, component);
  }

  public static LayToolbarMyLeadsBinding bind(@NonNull View view) {
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
  public static LayToolbarMyLeadsBinding bind(@NonNull View view, @Nullable Object component) {
    return (LayToolbarMyLeadsBinding)bind(component, view, R.layout.lay_toolbar_my_leads);
  }
}
