// Generated by data binding compiler. Do not edit!
package com.justforentrepreneurs.j4eapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.justforentrepreneurs.j4eapp.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemPostCategoryBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivProfileImg;

  @NonNull
  public final RadioButton txtPostCategory;

  protected ItemPostCategoryBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView ivProfileImg, RadioButton txtPostCategory) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivProfileImg = ivProfileImg;
    this.txtPostCategory = txtPostCategory;
  }

  @NonNull
  public static ItemPostCategoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_post_category, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemPostCategoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemPostCategoryBinding>inflateInternal(inflater, R.layout.item_post_category, root, attachToRoot, component);
  }

  @NonNull
  public static ItemPostCategoryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_post_category, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemPostCategoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemPostCategoryBinding>inflateInternal(inflater, R.layout.item_post_category, null, false, component);
  }

  public static ItemPostCategoryBinding bind(@NonNull View view) {
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
  public static ItemPostCategoryBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemPostCategoryBinding)bind(component, view, R.layout.item_post_category);
  }
}
