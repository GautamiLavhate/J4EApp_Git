// Generated by data binding compiler. Do not edit!
package com.justforentrepreneurs.j4eapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.justforentrepreneurs.j4eapp.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityCreateRequirementBinding extends ViewDataBinding {
  @NonNull
  public final ImageView addimage;

  @NonNull
  public final ImageView crossfun;

  @NonNull
  public final EditText edtAddress;

  @NonNull
  public final EditText edtFeedback;

  @NonNull
  public final EditText edtTitle;

  @NonNull
  public final ImageView ivDropDown;

  @NonNull
  public final ImageView ivDropUp;

  @NonNull
  public final LinearLayout layoutmanager;

  @NonNull
  public final LinearLayout layoutmanager1;

  @NonNull
  public final LinearLayout llCategorySelection;

  @NonNull
  public final RecyclerView rvCategory;

  @NonNull
  public final LayToolbarLeadStatusPublishBinding toolbar;

  @NonNull
  public final EditText tvCategory;

  protected ActivityCreateRequirementBinding(Object _bindingComponent, View _root,
      int _localFieldCount, ImageView addimage, ImageView crossfun, EditText edtAddress,
      EditText edtFeedback, EditText edtTitle, ImageView ivDropDown, ImageView ivDropUp,
      LinearLayout layoutmanager, LinearLayout layoutmanager1, LinearLayout llCategorySelection,
      RecyclerView rvCategory, LayToolbarLeadStatusPublishBinding toolbar, EditText tvCategory) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addimage = addimage;
    this.crossfun = crossfun;
    this.edtAddress = edtAddress;
    this.edtFeedback = edtFeedback;
    this.edtTitle = edtTitle;
    this.ivDropDown = ivDropDown;
    this.ivDropUp = ivDropUp;
    this.layoutmanager = layoutmanager;
    this.layoutmanager1 = layoutmanager1;
    this.llCategorySelection = llCategorySelection;
    this.rvCategory = rvCategory;
    this.toolbar = toolbar;
    this.tvCategory = tvCategory;
  }

  @NonNull
  public static ActivityCreateRequirementBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_create_requirement, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityCreateRequirementBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityCreateRequirementBinding>inflateInternal(inflater, R.layout.activity_create_requirement, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityCreateRequirementBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_create_requirement, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityCreateRequirementBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityCreateRequirementBinding>inflateInternal(inflater, R.layout.activity_create_requirement, null, false, component);
  }

  public static ActivityCreateRequirementBinding bind(@NonNull View view) {
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
  public static ActivityCreateRequirementBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityCreateRequirementBinding)bind(component, view, R.layout.activity_create_requirement);
  }
}