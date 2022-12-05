// Generated by data binding compiler. Do not edit!
package com.justforentrepreneurs.j4eapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.justforentrepreneurs.j4eapp.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class AdapterMytestimonialsactBinding extends ViewDataBinding {
  @NonNull
  public final TextView ivName;

  @NonNull
  public final CircleImageView ivProfileImg;

  @NonNull
  public final LinearLayout linearlayoutProfileDetail;

  @NonNull
  public final TextView note;

  @NonNull
  public final RatingBar rating;

  @NonNull
  public final TextView tvDate;

  protected AdapterMytestimonialsactBinding(Object _bindingComponent, View _root,
      int _localFieldCount, TextView ivName, CircleImageView ivProfileImg,
      LinearLayout linearlayoutProfileDetail, TextView note, RatingBar rating, TextView tvDate) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivName = ivName;
    this.ivProfileImg = ivProfileImg;
    this.linearlayoutProfileDetail = linearlayoutProfileDetail;
    this.note = note;
    this.rating = rating;
    this.tvDate = tvDate;
  }

  @NonNull
  public static AdapterMytestimonialsactBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.adapter_mytestimonialsact, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AdapterMytestimonialsactBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AdapterMytestimonialsactBinding>inflateInternal(inflater, R.layout.adapter_mytestimonialsact, root, attachToRoot, component);
  }

  @NonNull
  public static AdapterMytestimonialsactBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.adapter_mytestimonialsact, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AdapterMytestimonialsactBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AdapterMytestimonialsactBinding>inflateInternal(inflater, R.layout.adapter_mytestimonialsact, null, false, component);
  }

  public static AdapterMytestimonialsactBinding bind(@NonNull View view) {
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
  public static AdapterMytestimonialsactBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (AdapterMytestimonialsactBinding)bind(component, view, R.layout.adapter_mytestimonialsact);
  }
}