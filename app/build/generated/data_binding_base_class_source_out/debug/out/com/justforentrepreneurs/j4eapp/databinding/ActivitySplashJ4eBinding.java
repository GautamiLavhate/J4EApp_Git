// Generated by data binding compiler. Do not edit!
package com.justforentrepreneurs.j4eapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.justforentrepreneurs.j4eapp.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivitySplashJ4eBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivSplashScreen;

  protected ActivitySplashJ4eBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView ivSplashScreen) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivSplashScreen = ivSplashScreen;
  }

  @NonNull
  public static ActivitySplashJ4eBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_splash_j4e, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySplashJ4eBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivitySplashJ4eBinding>inflateInternal(inflater, R.layout.activity_splash_j4e, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySplashJ4eBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_splash_j4e, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySplashJ4eBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivitySplashJ4eBinding>inflateInternal(inflater, R.layout.activity_splash_j4e, null, false, component);
  }

  public static ActivitySplashJ4eBinding bind(@NonNull View view) {
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
  public static ActivitySplashJ4eBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivitySplashJ4eBinding)bind(component, view, R.layout.activity_splash_j4e);
  }
}