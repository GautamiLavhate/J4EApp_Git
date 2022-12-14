// Generated by data binding compiler. Do not edit!
package com.justforentrepreneurs.j4eapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.abmainj4e.NonSwipeableViewPager;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityAllEventsBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout Noevents;

  @NonNull
  public final TextView defaultText;

  @NonNull
  public final RecyclerView rvCommon;

  @NonNull
  public final LinearLayout rvevents;

  @NonNull
  public final TabLayout tabHome;

  @NonNull
  public final LayToolbarBinding toolbar;

  @NonNull
  public final NonSwipeableViewPager vpHome;

  protected ActivityAllEventsBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout Noevents, TextView defaultText, RecyclerView rvCommon, LinearLayout rvevents,
      TabLayout tabHome, LayToolbarBinding toolbar, NonSwipeableViewPager vpHome) {
    super(_bindingComponent, _root, _localFieldCount);
    this.Noevents = Noevents;
    this.defaultText = defaultText;
    this.rvCommon = rvCommon;
    this.rvevents = rvevents;
    this.tabHome = tabHome;
    this.toolbar = toolbar;
    this.vpHome = vpHome;
  }

  @NonNull
  public static ActivityAllEventsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_all_events, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityAllEventsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityAllEventsBinding>inflateInternal(inflater, R.layout.activity_all_events, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityAllEventsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_all_events, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityAllEventsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityAllEventsBinding>inflateInternal(inflater, R.layout.activity_all_events, null, false, component);
  }

  public static ActivityAllEventsBinding bind(@NonNull View view) {
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
  public static ActivityAllEventsBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityAllEventsBinding)bind(component, view, R.layout.activity_all_events);
  }
}
