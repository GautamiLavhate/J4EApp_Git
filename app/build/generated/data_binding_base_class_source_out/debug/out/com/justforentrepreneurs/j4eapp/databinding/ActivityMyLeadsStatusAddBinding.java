// Generated by data binding compiler. Do not edit!
package com.justforentrepreneurs.j4eapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
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

public abstract class ActivityMyLeadsStatusAddBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout Radioli;

  @NonNull
  public final EditText amount;

  @NonNull
  public final EditText edtFeedback;

  @NonNull
  public final EditText edtlocation;

  @NonNull
  public final EditText enterdate;

  @NonNull
  public final ImageView ivDropDown;

  @NonNull
  public final ImageView ivDropUp;

  @NonNull
  public final LinearLayout linearlayout;

  @NonNull
  public final LinearLayout llCategorySelection;

  @NonNull
  public final TextView noteTextview;

  @NonNull
  public final LinearLayout paymentselectedli;

  @NonNull
  public final RadioButton radioF;

  @NonNull
  public final RadioGroup radioGrp;

  @NonNull
  public final RadioButton radioM;

  @NonNull
  public final TextView radiotext;

  @NonNull
  public final RecyclerView rvCategory;

  @NonNull
  public final LayToolbarLeadStatusPublishBinding toolbar;

  @NonNull
  public final TextView tvCategory;

  protected ActivityMyLeadsStatusAddBinding(Object _bindingComponent, View _root,
      int _localFieldCount, LinearLayout Radioli, EditText amount, EditText edtFeedback,
      EditText edtlocation, EditText enterdate, ImageView ivDropDown, ImageView ivDropUp,
      LinearLayout linearlayout, LinearLayout llCategorySelection, TextView noteTextview,
      LinearLayout paymentselectedli, RadioButton radioF, RadioGroup radioGrp, RadioButton radioM,
      TextView radiotext, RecyclerView rvCategory, LayToolbarLeadStatusPublishBinding toolbar,
      TextView tvCategory) {
    super(_bindingComponent, _root, _localFieldCount);
    this.Radioli = Radioli;
    this.amount = amount;
    this.edtFeedback = edtFeedback;
    this.edtlocation = edtlocation;
    this.enterdate = enterdate;
    this.ivDropDown = ivDropDown;
    this.ivDropUp = ivDropUp;
    this.linearlayout = linearlayout;
    this.llCategorySelection = llCategorySelection;
    this.noteTextview = noteTextview;
    this.paymentselectedli = paymentselectedli;
    this.radioF = radioF;
    this.radioGrp = radioGrp;
    this.radioM = radioM;
    this.radiotext = radiotext;
    this.rvCategory = rvCategory;
    this.toolbar = toolbar;
    this.tvCategory = tvCategory;
  }

  @NonNull
  public static ActivityMyLeadsStatusAddBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_my_leads_status_add, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMyLeadsStatusAddBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityMyLeadsStatusAddBinding>inflateInternal(inflater, R.layout.activity_my_leads_status_add, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMyLeadsStatusAddBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_my_leads_status_add, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMyLeadsStatusAddBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityMyLeadsStatusAddBinding>inflateInternal(inflater, R.layout.activity_my_leads_status_add, null, false, component);
  }

  public static ActivityMyLeadsStatusAddBinding bind(@NonNull View view) {
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
  public static ActivityMyLeadsStatusAddBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityMyLeadsStatusAddBinding)bind(component, view, R.layout.activity_my_leads_status_add);
  }
}
