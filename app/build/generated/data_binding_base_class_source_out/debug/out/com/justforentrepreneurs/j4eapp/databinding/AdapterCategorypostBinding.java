// Generated by data binding compiler. Do not edit!
package com.justforentrepreneurs.j4eapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.justforentrepreneurs.j4eapp.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class AdapterCategorypostBinding extends ViewDataBinding {
  @NonNull
  public final CardView crd;

  @NonNull
  public final ImageView ivProfileImg;

  @NonNull
  public final TextView textcat;

  protected AdapterCategorypostBinding(Object _bindingComponent, View _root, int _localFieldCount,
      CardView crd, ImageView ivProfileImg, TextView textcat) {
    super(_bindingComponent, _root, _localFieldCount);
    this.crd = crd;
    this.ivProfileImg = ivProfileImg;
    this.textcat = textcat;
  }

  @NonNull
  public static AdapterCategorypostBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.adapter_categorypost, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AdapterCategorypostBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AdapterCategorypostBinding>inflateInternal(inflater, R.layout.adapter_categorypost, root, attachToRoot, component);
  }

  @NonNull
  public static AdapterCategorypostBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.adapter_categorypost, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AdapterCategorypostBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AdapterCategorypostBinding>inflateInternal(inflater, R.layout.adapter_categorypost, null, false, component);
  }

  public static AdapterCategorypostBinding bind(@NonNull View view) {
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
  public static AdapterCategorypostBinding bind(@NonNull View view, @Nullable Object component) {
    return (AdapterCategorypostBinding)bind(component, view, R.layout.adapter_categorypost);
  }
}
