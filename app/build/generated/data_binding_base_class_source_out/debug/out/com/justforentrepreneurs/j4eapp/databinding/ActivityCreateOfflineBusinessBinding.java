// Generated by data binding compiler. Do not edit!
package com.justforentrepreneurs.j4eapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.justforentrepreneurs.j4eapp.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityCreateOfflineBusinessBinding extends ViewDataBinding {
  @NonNull
  public final ImageView crossfun;

  @NonNull
  public final TextView edtDate;

  @NonNull
  public final EditText edtPrice;

  @NonNull
  public final EditText edtRemarks;

  @NonNull
  public final EditText edtServiceName;

  @NonNull
  public final EditText edtTitle;

  @NonNull
  public final ImageView ivDropDown;

  @NonNull
  public final ImageView ivDropUp;

  @NonNull
  public final LinearLayout linearlayout;

  @NonNull
  public final LinearLayout linearlayout1;

  @NonNull
  public final LinearLayout llCategorySelection;

  @NonNull
  public final RadioGroup radioGrp;

  @NonNull
  public final RecyclerView rvCategory;

  @NonNull
  public final LayToolbarLeadStatusPublishBinding toolbar;

  @NonNull
  public final EditText tvCategory;

  protected ActivityCreateOfflineBusinessBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ImageView crossfun, TextView edtDate, EditText edtPrice,
      EditText edtRemarks, EditText edtServiceName, EditText edtTitle, ImageView ivDropDown,
      ImageView ivDropUp, LinearLayout linearlayout, LinearLayout linearlayout1,
      LinearLayout llCategorySelection, RadioGroup radioGrp, RecyclerView rvCategory,
      LayToolbarLeadStatusPublishBinding toolbar, EditText tvCategory) {
    super(_bindingComponent, _root, _localFieldCount);
    this.crossfun = crossfun;
    this.edtDate = edtDate;
    this.edtPrice = edtPrice;
    this.edtRemarks = edtRemarks;
    this.edtServiceName = edtServiceName;
    this.edtTitle = edtTitle;
    this.ivDropDown = ivDropDown;
    this.ivDropUp = ivDropUp;
    this.linearlayout = linearlayout;
    this.linearlayout1 = linearlayout1;
    this.llCategorySelection = llCategorySelection;
    this.radioGrp = radioGrp;
    this.rvCategory = rvCategory;
    this.toolbar = toolbar;
    this.tvCategory = tvCategory;
  }

  @NonNull
  public static ActivityCreateOfflineBusinessBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_create_offline_business, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityCreateOfflineBusinessBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityCreateOfflineBusinessBinding>inflateInternal(inflater, R.layout.activity_create_offline_business, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityCreateOfflineBusinessBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_create_offline_business, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityCreateOfflineBusinessBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityCreateOfflineBusinessBinding>inflateInternal(inflater, R.layout.activity_create_offline_business, null, false, component);
  }

  public static ActivityCreateOfflineBusinessBinding bind(@NonNull View view) {
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
  public static ActivityCreateOfflineBusinessBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityCreateOfflineBusinessBinding)bind(component, view, R.layout.activity_create_offline_business);
  }
}
