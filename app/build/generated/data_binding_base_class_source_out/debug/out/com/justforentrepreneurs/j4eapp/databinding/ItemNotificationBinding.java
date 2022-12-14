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
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.justforentrepreneurs.j4eapp.R;
import com.justforentrepreneurs.j4eapp.abmainj4e.network.model.NotificationModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemNotificationBinding extends ViewDataBinding {
  @NonNull
  public final TextView Businesswith;

  @NonNull
  public final TextView Businesswithtx;

  @NonNull
  public final TextView Byre;

  @NonNull
  public final TextView RecommendedBy;

  @NonNull
  public final LinearLayout RecommendedByli;

  @NonNull
  public final TextView RecommendedBytx;

  @NonNull
  public final TextView RecommendedTo;

  @NonNull
  public final TextView RecommendedTotx;

  @NonNull
  public final TextView TransactionAmount;

  @NonNull
  public final TextView TransactionAmountst;

  @NonNull
  public final TextView Updatedby;

  @NonNull
  public final TextView Updatedbyname;

  @NonNull
  public final TextView businesstype;

  @NonNull
  public final LinearLayout businesswithli;

  @NonNull
  public final TextView date;

  @NonNull
  public final TextView leadtitle;

  @NonNull
  public final TextView leadtitle2;

  @NonNull
  public final TextView note;

  @NonNull
  public final ImageView notificationImage;

  @NonNull
  public final TextView notificationText;

  @NonNull
  public final LinearLayout recommento;

  @NonNull
  public final LinearLayout reqByli;

  @NonNull
  public final LinearLayout transactionacc;

  @NonNull
  public final TextView tvconfirm;

  @NonNull
  public final LinearLayout udatedbyli;

  @Bindable
  protected NotificationModel mItem;

  protected ItemNotificationBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView Businesswith, TextView Businesswithtx, TextView Byre, TextView RecommendedBy,
      LinearLayout RecommendedByli, TextView RecommendedBytx, TextView RecommendedTo,
      TextView RecommendedTotx, TextView TransactionAmount, TextView TransactionAmountst,
      TextView Updatedby, TextView Updatedbyname, TextView businesstype,
      LinearLayout businesswithli, TextView date, TextView leadtitle, TextView leadtitle2,
      TextView note, ImageView notificationImage, TextView notificationText,
      LinearLayout recommento, LinearLayout reqByli, LinearLayout transactionacc,
      TextView tvconfirm, LinearLayout udatedbyli) {
    super(_bindingComponent, _root, _localFieldCount);
    this.Businesswith = Businesswith;
    this.Businesswithtx = Businesswithtx;
    this.Byre = Byre;
    this.RecommendedBy = RecommendedBy;
    this.RecommendedByli = RecommendedByli;
    this.RecommendedBytx = RecommendedBytx;
    this.RecommendedTo = RecommendedTo;
    this.RecommendedTotx = RecommendedTotx;
    this.TransactionAmount = TransactionAmount;
    this.TransactionAmountst = TransactionAmountst;
    this.Updatedby = Updatedby;
    this.Updatedbyname = Updatedbyname;
    this.businesstype = businesstype;
    this.businesswithli = businesswithli;
    this.date = date;
    this.leadtitle = leadtitle;
    this.leadtitle2 = leadtitle2;
    this.note = note;
    this.notificationImage = notificationImage;
    this.notificationText = notificationText;
    this.recommento = recommento;
    this.reqByli = reqByli;
    this.transactionacc = transactionacc;
    this.tvconfirm = tvconfirm;
    this.udatedbyli = udatedbyli;
  }

  public abstract void setItem(@Nullable NotificationModel item);

  @Nullable
  public NotificationModel getItem() {
    return mItem;
  }

  @NonNull
  public static ItemNotificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_notification, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemNotificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemNotificationBinding>inflateInternal(inflater, R.layout.item_notification, root, attachToRoot, component);
  }

  @NonNull
  public static ItemNotificationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_notification, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemNotificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemNotificationBinding>inflateInternal(inflater, R.layout.item_notification, null, false, component);
  }

  public static ItemNotificationBinding bind(@NonNull View view) {
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
  public static ItemNotificationBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemNotificationBinding)bind(component, view, R.layout.item_notification);
  }
}
