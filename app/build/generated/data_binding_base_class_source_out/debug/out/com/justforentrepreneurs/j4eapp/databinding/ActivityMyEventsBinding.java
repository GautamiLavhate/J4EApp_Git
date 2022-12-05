// Generated by data binding compiler. Do not edit!
package com.justforentrepreneurs.j4eapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.tabs.TabLayout;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.abmainj4e.NonSwipeableViewPager;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityMyEventsBinding extends ViewDataBinding {
  @NonNull
  public final TabLayout tabHome;

  @NonNull
  public final LayToolbarBinding toolbar;

  @NonNull
  public final NonSwipeableViewPager vpHome;

  protected ActivityMyEventsBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TabLayout tabHome, LayToolbarBinding toolbar, NonSwipeableViewPager vpHome) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tabHome = tabHome;
    this.toolbar = toolbar;
    this.vpHome = vpHome;
  }

  @NonNull
  public static ActivityMyEventsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_my_events, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMyEventsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityMyEventsBinding>inflateInternal(inflater, R.layout.activity_my_events, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMyEventsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_my_events, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMyEventsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityMyEventsBinding>inflateInternal(inflater, R.layout.activity_my_events, null, false, component);
  }

  public static ActivityMyEventsBinding bind(@NonNull View view) {
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
  public static ActivityMyEventsBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityMyEventsBinding)bind(component, view, R.layout.activity_my_events);
  }
}