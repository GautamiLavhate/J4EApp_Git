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
import com.justforentrepreneurs.j4eapp.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityMembershipAddBinding extends ViewDataBinding {
  @NonNull
  public final EditText address;

  @NonNull
  public final TextView buyPlan;

  @NonNull
  public final EditText companyOrganisation;

  @NonNull
  public final EditText designationprofession;

  @NonNull
  public final EditText edtWhatspp;

  @NonNull
  public final EditText edtWhatsppBusiness;

  @NonNull
  public final EditText edtlast;

  @NonNull
  public final EditText edtmiddle;

  @NonNull
  public final EditText edtname;

  @NonNull
  public final EditText email;

  @NonNull
  public final ImageView imgCorrect;

  @NonNull
  public final ImageView imgIncorrect;

  @NonNull
  public final LinearLayout lay;

  @NonNull
  public final EditText mobilenumber;

  @NonNull
  public final EditText officephone;

  @NonNull
  public final EditText referalcode;

  @NonNull
  public final TextView savemember;

  @NonNull
  public final LayToolbarEditBinding toolbar;

  @NonNull
  public final TextView txtInValid;

  @NonNull
  public final TextView txtValid;

  protected ActivityMembershipAddBinding(Object _bindingComponent, View _root, int _localFieldCount,
      EditText address, TextView buyPlan, EditText companyOrganisation,
      EditText designationprofession, EditText edtWhatspp, EditText edtWhatsppBusiness,
      EditText edtlast, EditText edtmiddle, EditText edtname, EditText email, ImageView imgCorrect,
      ImageView imgIncorrect, LinearLayout lay, EditText mobilenumber, EditText officephone,
      EditText referalcode, TextView savemember, LayToolbarEditBinding toolbar, TextView txtInValid,
      TextView txtValid) {
    super(_bindingComponent, _root, _localFieldCount);
    this.address = address;
    this.buyPlan = buyPlan;
    this.companyOrganisation = companyOrganisation;
    this.designationprofession = designationprofession;
    this.edtWhatspp = edtWhatspp;
    this.edtWhatsppBusiness = edtWhatsppBusiness;
    this.edtlast = edtlast;
    this.edtmiddle = edtmiddle;
    this.edtname = edtname;
    this.email = email;
    this.imgCorrect = imgCorrect;
    this.imgIncorrect = imgIncorrect;
    this.lay = lay;
    this.mobilenumber = mobilenumber;
    this.officephone = officephone;
    this.referalcode = referalcode;
    this.savemember = savemember;
    this.toolbar = toolbar;
    this.txtInValid = txtInValid;
    this.txtValid = txtValid;
  }

  @NonNull
  public static ActivityMembershipAddBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_membership_add, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMembershipAddBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityMembershipAddBinding>inflateInternal(inflater, R.layout.activity_membership_add, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMembershipAddBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_membership_add, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMembershipAddBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityMembershipAddBinding>inflateInternal(inflater, R.layout.activity_membership_add, null, false, component);
  }

  public static ActivityMembershipAddBinding bind(@NonNull View view) {
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
  public static ActivityMembershipAddBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityMembershipAddBinding)bind(component, view, R.layout.activity_membership_add);
  }
}