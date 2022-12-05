// Generated by data binding compiler. Do not edit!
package com.justforentrepreneurs.j4eapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.justforentrepreneurs.j4eapp.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class BsChatbuddylistBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout NoLeadInvited;

  @NonNull
  public final TextView companyName;

  @NonNull
  public final TextView defaultText;

  @NonNull
  public final TextView designation;

  @NonNull
  public final TextView fullname;

  @NonNull
  public final ImageView ivClose;

  @NonNull
  public final LinearLayout linearlayout1;

  @NonNull
  public final RecyclerView rvRecommendPersonList;

  @NonNull
  public final SearchView searchLinLay;

  @NonNull
  public final TextView text;

  protected BsChatbuddylistBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout NoLeadInvited, TextView companyName, TextView defaultText, TextView designation,
      TextView fullname, ImageView ivClose, LinearLayout linearlayout1,
      RecyclerView rvRecommendPersonList, SearchView searchLinLay, TextView text) {
    super(_bindingComponent, _root, _localFieldCount);
    this.NoLeadInvited = NoLeadInvited;
    this.companyName = companyName;
    this.defaultText = defaultText;
    this.designation = designation;
    this.fullname = fullname;
    this.ivClose = ivClose;
    this.linearlayout1 = linearlayout1;
    this.rvRecommendPersonList = rvRecommendPersonList;
    this.searchLinLay = searchLinLay;
    this.text = text;
  }

  @NonNull
  public static BsChatbuddylistBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.bs_chatbuddylist, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static BsChatbuddylistBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<BsChatbuddylistBinding>inflateInternal(inflater, R.layout.bs_chatbuddylist, root, attachToRoot, component);
  }

  @NonNull
  public static BsChatbuddylistBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.bs_chatbuddylist, null, false, component)
   */
  @NonNull
  @Deprecated
  public static BsChatbuddylistBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<BsChatbuddylistBinding>inflateInternal(inflater, R.layout.bs_chatbuddylist, null, false, component);
  }

  public static BsChatbuddylistBinding bind(@NonNull View view) {
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
  public static BsChatbuddylistBinding bind(@NonNull View view, @Nullable Object component) {
    return (BsChatbuddylistBinding)bind(component, view, R.layout.bs_chatbuddylist);
  }
}