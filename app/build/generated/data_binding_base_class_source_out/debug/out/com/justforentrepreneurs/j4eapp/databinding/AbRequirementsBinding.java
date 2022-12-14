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

public abstract class AbRequirementsBinding extends ViewDataBinding {
  @NonNull
  public final TextView description;

  @NonNull
  public final TextView dobet;

  @NonNull
  public final ImageView ivShare;

  @NonNull
  public final ImageView requirementimg;

  @NonNull
  public final TextView title;

  protected AbRequirementsBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView description, TextView dobet, ImageView ivShare, ImageView requirementimg,
      TextView title) {
    super(_bindingComponent, _root, _localFieldCount);
    this.description = description;
    this.dobet = dobet;
    this.ivShare = ivShare;
    this.requirementimg = requirementimg;
    this.title = title;
  }

  @NonNull
  public static AbRequirementsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.ab_requirements, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AbRequirementsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AbRequirementsBinding>inflateInternal(inflater, R.layout.ab_requirements, root, attachToRoot, component);
  }

  @NonNull
  public static AbRequirementsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.ab_requirements, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AbRequirementsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AbRequirementsBinding>inflateInternal(inflater, R.layout.ab_requirements, null, false, component);
  }

  public static AbRequirementsBinding bind(@NonNull View view) {
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
  public static AbRequirementsBinding bind(@NonNull View view, @Nullable Object component) {
    return (AbRequirementsBinding)bind(component, view, R.layout.ab_requirements);
  }
}
