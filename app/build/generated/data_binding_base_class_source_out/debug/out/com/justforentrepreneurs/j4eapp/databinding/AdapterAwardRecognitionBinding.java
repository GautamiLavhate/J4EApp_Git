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
import com.justforentrepreneurs.j4eapp.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class AdapterAwardRecognitionBinding extends ViewDataBinding {
  @NonNull
  public final TextView To;

  @NonNull
  public final TextView description;

  @NonNull
  public final TextView form;

  @NonNull
  public final ImageView imagethum;

  @NonNull
  public final ImageView ivDropDown;

  @NonNull
  public final ImageView ivDropUp;

  @NonNull
  public final LinearLayout llnavDrop;

  @NonNull
  public final TextView name;

  @NonNull
  public final TextView status;

  @NonNull
  public final TextView title;

  protected AdapterAwardRecognitionBinding(Object _bindingComponent, View _root,
      int _localFieldCount, TextView To, TextView description, TextView form, ImageView imagethum,
      ImageView ivDropDown, ImageView ivDropUp, LinearLayout llnavDrop, TextView name,
      TextView status, TextView title) {
    super(_bindingComponent, _root, _localFieldCount);
    this.To = To;
    this.description = description;
    this.form = form;
    this.imagethum = imagethum;
    this.ivDropDown = ivDropDown;
    this.ivDropUp = ivDropUp;
    this.llnavDrop = llnavDrop;
    this.name = name;
    this.status = status;
    this.title = title;
  }

  @NonNull
  public static AdapterAwardRecognitionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.adapter_award_recognition, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AdapterAwardRecognitionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AdapterAwardRecognitionBinding>inflateInternal(inflater, R.layout.adapter_award_recognition, root, attachToRoot, component);
  }

  @NonNull
  public static AdapterAwardRecognitionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.adapter_award_recognition, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AdapterAwardRecognitionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AdapterAwardRecognitionBinding>inflateInternal(inflater, R.layout.adapter_award_recognition, null, false, component);
  }

  public static AdapterAwardRecognitionBinding bind(@NonNull View view) {
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
  public static AdapterAwardRecognitionBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (AdapterAwardRecognitionBinding)bind(component, view, R.layout.adapter_award_recognition);
  }
}
