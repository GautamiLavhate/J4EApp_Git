// Generated by data binding compiler. Do not edit!
package com.justforentrepreneurs.j4eapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.justforentrepreneurs.j4eapp.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class AdapterMyguestinvitesBinding extends ViewDataBinding {
  @NonNull
  public final TextView companyName;

  @NonNull
  public final TextView designation;

  @NonNull
  public final TextView email;

  @NonNull
  public final TextView eventtitle;

  @NonNull
  public final TextView makepayment;

  @NonNull
  public final TextView name;

  @NonNull
  public final TextView phonenumber;

  @NonNull
  public final TextView status;

  protected AdapterMyguestinvitesBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView companyName, TextView designation, TextView email, TextView eventtitle,
      TextView makepayment, TextView name, TextView phonenumber, TextView status) {
    super(_bindingComponent, _root, _localFieldCount);
    this.companyName = companyName;
    this.designation = designation;
    this.email = email;
    this.eventtitle = eventtitle;
    this.makepayment = makepayment;
    this.name = name;
    this.phonenumber = phonenumber;
    this.status = status;
  }

  @NonNull
  public static AdapterMyguestinvitesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.adapter_myguestinvites, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AdapterMyguestinvitesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AdapterMyguestinvitesBinding>inflateInternal(inflater, R.layout.adapter_myguestinvites, root, attachToRoot, component);
  }

  @NonNull
  public static AdapterMyguestinvitesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.adapter_myguestinvites, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AdapterMyguestinvitesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AdapterMyguestinvitesBinding>inflateInternal(inflater, R.layout.adapter_myguestinvites, null, false, component);
  }

  public static AdapterMyguestinvitesBinding bind(@NonNull View view) {
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
  public static AdapterMyguestinvitesBinding bind(@NonNull View view, @Nullable Object component) {
    return (AdapterMyguestinvitesBinding)bind(component, view, R.layout.adapter_myguestinvites);
  }
}
