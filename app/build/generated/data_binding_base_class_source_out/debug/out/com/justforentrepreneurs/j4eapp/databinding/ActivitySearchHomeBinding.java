// Generated by data binding compiler. Do not edit!
package com.justforentrepreneurs.j4eapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.justforentrepreneurs.j4eapp.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivitySearchHomeBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout NoGuestInvited;

  @NonNull
  public final RecyclerView searchrecycler;

  @NonNull
  public final ToolbarSearchBinding toolbar;

  protected ActivitySearchHomeBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout NoGuestInvited, RecyclerView searchrecycler, ToolbarSearchBinding toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.NoGuestInvited = NoGuestInvited;
    this.searchrecycler = searchrecycler;
    this.toolbar = toolbar;
  }

  @NonNull
  public static ActivitySearchHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_search_home, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySearchHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivitySearchHomeBinding>inflateInternal(inflater, R.layout.activity_search_home, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySearchHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_search_home, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySearchHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivitySearchHomeBinding>inflateInternal(inflater, R.layout.activity_search_home, null, false, component);
  }

  public static ActivitySearchHomeBinding bind(@NonNull View view) {
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
  public static ActivitySearchHomeBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivitySearchHomeBinding)bind(component, view, R.layout.activity_search_home);
  }
}