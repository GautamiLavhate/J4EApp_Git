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
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class AbPostsliBinding extends ViewDataBinding {
  @NonNull
  public final ImageView cateimage;

  @NonNull
  public final TextView datetime;

  @NonNull
  public final TextView description;

  @NonNull
  public final TextView fullname;

  @NonNull
  public final ImageView imagelike;

  @NonNull
  public final CircleImageView ivProfileImg;

  @NonNull
  public final LinearLayout llComments;

  @NonNull
  public final LinearLayout llLike;

  @NonNull
  public final LinearLayout llShare;

  @NonNull
  public final ImageView postimg;

  @NonNull
  public final TextView posttotalcomment;

  @NonNull
  public final TextView totalike;

  protected AbPostsliBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView cateimage, TextView datetime, TextView description, TextView fullname,
      ImageView imagelike, CircleImageView ivProfileImg, LinearLayout llComments,
      LinearLayout llLike, LinearLayout llShare, ImageView postimg, TextView posttotalcomment,
      TextView totalike) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cateimage = cateimage;
    this.datetime = datetime;
    this.description = description;
    this.fullname = fullname;
    this.imagelike = imagelike;
    this.ivProfileImg = ivProfileImg;
    this.llComments = llComments;
    this.llLike = llLike;
    this.llShare = llShare;
    this.postimg = postimg;
    this.posttotalcomment = posttotalcomment;
    this.totalike = totalike;
  }

  @NonNull
  public static AbPostsliBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.ab_postsli, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static AbPostsliBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<AbPostsliBinding>inflateInternal(inflater, R.layout.ab_postsli, root, attachToRoot, component);
  }

  @NonNull
  public static AbPostsliBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.ab_postsli, null, false, component)
   */
  @NonNull
  @Deprecated
  public static AbPostsliBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<AbPostsliBinding>inflateInternal(inflater, R.layout.ab_postsli, null, false, component);
  }

  public static AbPostsliBinding bind(@NonNull View view) {
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
  public static AbPostsliBinding bind(@NonNull View view, @Nullable Object component) {
    return (AbPostsliBinding)bind(component, view, R.layout.ab_postsli);
  }
}