// Generated by data binding compiler. Do not edit!
package com.justforentrepreneurs.j4eapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public abstract class FragPendingConnectionBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout NoLeadInvited;

  @NonNull
  public final TextView defaultText;

  @NonNull
  public final ImageView imagevno;

  @NonNull
  public final LinearLayout linearlayout1;

  @NonNull
  public final RecyclerView rvRequirement;

  protected FragPendingConnectionBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout NoLeadInvited, TextView defaultText, ImageView imagevno,
      LinearLayout linearlayout1, RecyclerView rvRequirement) {
    super(_bindingComponent, _root, _localFieldCount);
    this.NoLeadInvited = NoLeadInvited;
    this.defaultText = defaultText;
    this.imagevno = imagevno;
    this.linearlayout1 = linearlayout1;
    this.rvRequirement = rvRequirement;
  }

  @NonNull
  public static FragPendingConnectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.frag_pending_connection, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragPendingConnectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragPendingConnectionBinding>inflateInternal(inflater, R.layout.frag_pending_connection, root, attachToRoot, component);
  }

  @NonNull
  public static FragPendingConnectionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.frag_pending_connection, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragPendingConnectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragPendingConnectionBinding>inflateInternal(inflater, R.layout.frag_pending_connection, null, false, component);
  }

  public static FragPendingConnectionBinding bind(@NonNull View view) {
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
  public static FragPendingConnectionBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragPendingConnectionBinding)bind(component, view, R.layout.frag_pending_connection);
  }
}
