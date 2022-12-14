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
import androidx.recyclerview.widget.RecyclerView;
import com.justforentrepreneurs.j4eapp.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ReviewallPopupBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivcancle;

  @NonNull
  public final TextView memberdetails;

  @NonNull
  public final RecyclerView recyclerUpgradePlan;

  protected ReviewallPopupBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView ivcancle, TextView memberdetails, RecyclerView recyclerUpgradePlan) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivcancle = ivcancle;
    this.memberdetails = memberdetails;
    this.recyclerUpgradePlan = recyclerUpgradePlan;
  }

  @NonNull
  public static ReviewallPopupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.reviewall_popup, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ReviewallPopupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ReviewallPopupBinding>inflateInternal(inflater, R.layout.reviewall_popup, root, attachToRoot, component);
  }

  @NonNull
  public static ReviewallPopupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.reviewall_popup, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ReviewallPopupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ReviewallPopupBinding>inflateInternal(inflater, R.layout.reviewall_popup, null, false, component);
  }

  public static ReviewallPopupBinding bind(@NonNull View view) {
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
  public static ReviewallPopupBinding bind(@NonNull View view, @Nullable Object component) {
    return (ReviewallPopupBinding)bind(component, view, R.layout.reviewall_popup);
  }
}
