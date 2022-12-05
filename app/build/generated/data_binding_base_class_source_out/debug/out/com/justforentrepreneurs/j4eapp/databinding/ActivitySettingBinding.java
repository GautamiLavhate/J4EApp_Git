// Generated by data binding compiler. Do not edit!
package com.justforentrepreneurs.j4eapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.github.angads25.toggle.widget.LabeledSwitch;
import com.justforentrepreneurs.j4eapp.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivitySettingBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout llLogout;

  @NonNull
  public final LabeledSwitch switch1;

  @NonNull
  public final LabeledSwitch switch2;

  @NonNull
  public final LabeledSwitch switch3;

  @NonNull
  public final LabeledSwitch switch4;

  @NonNull
  public final LabeledSwitch switch5;

  @NonNull
  public final LayToolbarBinding toolbar;

  protected ActivitySettingBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout llLogout, LabeledSwitch switch1, LabeledSwitch switch2, LabeledSwitch switch3,
      LabeledSwitch switch4, LabeledSwitch switch5, LayToolbarBinding toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.llLogout = llLogout;
    this.switch1 = switch1;
    this.switch2 = switch2;
    this.switch3 = switch3;
    this.switch4 = switch4;
    this.switch5 = switch5;
    this.toolbar = toolbar;
  }

  @NonNull
  public static ActivitySettingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_setting, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySettingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivitySettingBinding>inflateInternal(inflater, R.layout.activity_setting, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySettingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_setting, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySettingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivitySettingBinding>inflateInternal(inflater, R.layout.activity_setting, null, false, component);
  }

  public static ActivitySettingBinding bind(@NonNull View view) {
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
  public static ActivitySettingBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivitySettingBinding)bind(component, view, R.layout.activity_setting);
  }
}