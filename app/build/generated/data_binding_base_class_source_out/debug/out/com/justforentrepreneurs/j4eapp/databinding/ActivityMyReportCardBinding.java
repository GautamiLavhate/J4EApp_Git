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
import com.justforentrepreneurs.j4eapp.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityMyReportCardBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout linearlayout1;

  @NonNull
  public final RecyclerView rvMyReportCard;

  @NonNull
  public final LayToolbarBinding toolbar;

  @NonNull
  public final TextView totalpoints;

  protected ActivityMyReportCardBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout linearlayout1, RecyclerView rvMyReportCard, LayToolbarBinding toolbar,
      TextView totalpoints) {
    super(_bindingComponent, _root, _localFieldCount);
    this.linearlayout1 = linearlayout1;
    this.rvMyReportCard = rvMyReportCard;
    this.toolbar = toolbar;
    this.totalpoints = totalpoints;
  }

  @NonNull
  public static ActivityMyReportCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_my_report_card, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMyReportCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityMyReportCardBinding>inflateInternal(inflater, R.layout.activity_my_report_card, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMyReportCardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_my_report_card, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMyReportCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityMyReportCardBinding>inflateInternal(inflater, R.layout.activity_my_report_card, null, false, component);
  }

  public static ActivityMyReportCardBinding bind(@NonNull View view) {
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
  public static ActivityMyReportCardBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityMyReportCardBinding)bind(component, view, R.layout.activity_my_report_card);
  }
}