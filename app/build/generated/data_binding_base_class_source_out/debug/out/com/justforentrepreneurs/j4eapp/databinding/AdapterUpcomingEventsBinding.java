// Generated by data binding compiler. Do not edit!
package com.justforentrepreneurs.j4eapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.justforentrepreneurs.j4eapp.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class AdapterUpcomingEventsBinding extends ViewDataBinding {
  @NonNull
  public final TextView address;

  @NonNull
  public final TextView amount;

  @NonNull
  public final ImageView btpublish;

  @NonNull
  public final TextView datetime;

  @NonNull
  public final RelativeLayout eventDetailsRelLay;

  @NonNull
  public final RelativeLayout eventDetailsRelLay23;

  @NonNull
  public final LinearLayout eventlitext;

  @NonNull
  public final TextView eventtitle;

  @NonNull
  public final TextView eventtype;

  @NonNull
  public final ImageView ivImg;

  @NonNull
  public final ImageView ivshare;

  @NonNull
  public final LinearLayout llContain;

  @NonNull
  public final ImageView map;

  @NonNull
  public final ImageView msgc;

  @NonNull
  public final ImageView orgnaizenumber;

  @NonNull
  public final ImageView tikitbooking;

  protected AdapterUpcomingEventsBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView address, TextView amount, ImageView btpublish, TextView datetime,
      RelativeLayout eventDetailsRelLay, RelativeLayout eventDetailsRelLay23,
      LinearLayout eventlitext, TextView eventtitle, TextView eventtype, ImageView ivImg,
      ImageView ivshare, LinearLayout llContain, ImageView map, ImageView msgc,
      ImageView orgnaizenumber, ImageView tikitbooking) {
    super(_bindingComponent, _root, _localFieldCount);
    this.address = address;
    this.amount = amount;
    this.btpublish = btpublish;
    this.datetime = datetime;
    this.eventDetailsRelLay = eventDetailsRelLay;
    this.eventDetailsRelLay23 = eventDetailsRelLay23;
    this.eventlitext = eventlitext;
    this.eventtitle = eventtitle;
    this.eventtype = eventtype;
    this.ivImg = ivImg;
    this.ivshare = ivshare;
    this.llContain = llContain;
    this.map = map;
    this.msgc = msgc;
    this.orgnaizenumber = orgnaizenumber;
    this.tikitbooking = tikitbooking;
  }

  @NonNull
  public static AdapterUpcomingEventsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.adapter_upcoming_events, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AdapterUpcomingEventsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AdapterUpcomingEventsBinding>inflateInternal(inflater, R.layout.adapter_upcoming_events, root, attachToRoot, component);
  }

  @NonNull
  public static AdapterUpcomingEventsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.adapter_upcoming_events, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AdapterUpcomingEventsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AdapterUpcomingEventsBinding>inflateInternal(inflater, R.layout.adapter_upcoming_events, null, false, component);
  }

  public static AdapterUpcomingEventsBinding bind(@NonNull View view) {
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
  public static AdapterUpcomingEventsBinding bind(@NonNull View view, @Nullable Object component) {
    return (AdapterUpcomingEventsBinding)bind(component, view, R.layout.adapter_upcoming_events);
  }
}