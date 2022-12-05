// Generated by data binding compiler. Do not edit!
package com.justforentrepreneurs.j4eapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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

public abstract class ActivityMyBusinessTransactionsBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout NoGuestInvited;

  @NonNull
  public final TextView businessgiven;

  @NonNull
  public final TextView busnessreceived;

  @NonNull
  public final TextView defaultText;

  @NonNull
  public final EditText editsearchname;

  @NonNull
  public final ImageView ivFilter;

  @NonNull
  public final LinearLayout linearlayout1;

  @NonNull
  public final RecyclerView rvMyBusinessTransactions;

  @NonNull
  public final LayToolbarBinding toolbar;

  @NonNull
  public final TextView totalamount;

  protected ActivityMyBusinessTransactionsBinding(Object _bindingComponent, View _root,
      int _localFieldCount, LinearLayout NoGuestInvited, TextView businessgiven,
      TextView busnessreceived, TextView defaultText, EditText editsearchname, ImageView ivFilter,
      LinearLayout linearlayout1, RecyclerView rvMyBusinessTransactions, LayToolbarBinding toolbar,
      TextView totalamount) {
    super(_bindingComponent, _root, _localFieldCount);
    this.NoGuestInvited = NoGuestInvited;
    this.businessgiven = businessgiven;
    this.busnessreceived = busnessreceived;
    this.defaultText = defaultText;
    this.editsearchname = editsearchname;
    this.ivFilter = ivFilter;
    this.linearlayout1 = linearlayout1;
    this.rvMyBusinessTransactions = rvMyBusinessTransactions;
    this.toolbar = toolbar;
    this.totalamount = totalamount;
  }

  @NonNull
  public static ActivityMyBusinessTransactionsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_my_business_transactions, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMyBusinessTransactionsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityMyBusinessTransactionsBinding>inflateInternal(inflater, R.layout.activity_my_business_transactions, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMyBusinessTransactionsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_my_business_transactions, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMyBusinessTransactionsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityMyBusinessTransactionsBinding>inflateInternal(inflater, R.layout.activity_my_business_transactions, null, false, component);
  }

  public static ActivityMyBusinessTransactionsBinding bind(@NonNull View view) {
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
  public static ActivityMyBusinessTransactionsBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityMyBusinessTransactionsBinding)bind(component, view, R.layout.activity_my_business_transactions);
  }
}