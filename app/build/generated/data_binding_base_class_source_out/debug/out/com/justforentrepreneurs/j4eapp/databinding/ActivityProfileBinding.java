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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.justforentrepreneurs.j4eapp.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityProfileBinding extends ViewDataBinding {
  @NonNull
  public final AbProfilecontactusBinding abprofilecontactus;

  @NonNull
  public final AbProfilleviewBinding abprofilleview;

  @NonNull
  public final TextView address;

  @NonNull
  public final ImageView baatch;

  @NonNull
  public final TextView companyName;

  @NonNull
  public final TextView connections;

  @NonNull
  public final FloatingActionButton fabAddGalleyImage;

  @NonNull
  public final CircleImageView ivProfileImg;

  @NonNull
  public final ImageView ivStatusFollowing;

  @NonNull
  public final LinearLayout llFollow;

  @NonNull
  public final LinearLayout llFollowst;

  @NonNull
  public final LinearLayout llProfileInfo;

  @NonNull
  public final LinearLayout llQrCode;

  @NonNull
  public final LinearLayout llRanks;

  @NonNull
  public final LinearLayout llRewardPoint;

  @NonNull
  public final LinearLayout llShare;

  @NonNull
  public final LinearLayout messageLL;

  @NonNull
  public final ImageView messageimg;

  @NonNull
  public final LayProfileAboutUsBinding profileAboutUs;

  @NonNull
  public final LayProfileContactUsBinding profileContactUs;

  @NonNull
  public final LayProfileGalleryBinding profileGallery;

  @NonNull
  public final LayProfileReviewsBinding profileReviews;

  @NonNull
  public final LinearLayout profileview;

  @NonNull
  public final LinearLayout profileview1;

  @NonNull
  public final TextView rank;

  @NonNull
  public final TextView rewardpoint;

  @NonNull
  public final TabLayout tabProfile;

  @NonNull
  public final LayToolbarEditbtnBinding toolbar;

  @NonNull
  public final TextView userName;

  protected ActivityProfileBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AbProfilecontactusBinding abprofilecontactus, AbProfilleviewBinding abprofilleview,
      TextView address, ImageView baatch, TextView companyName, TextView connections,
      FloatingActionButton fabAddGalleyImage, CircleImageView ivProfileImg,
      ImageView ivStatusFollowing, LinearLayout llFollow, LinearLayout llFollowst,
      LinearLayout llProfileInfo, LinearLayout llQrCode, LinearLayout llRanks,
      LinearLayout llRewardPoint, LinearLayout llShare, LinearLayout messageLL,
      ImageView messageimg, LayProfileAboutUsBinding profileAboutUs,
      LayProfileContactUsBinding profileContactUs, LayProfileGalleryBinding profileGallery,
      LayProfileReviewsBinding profileReviews, LinearLayout profileview, LinearLayout profileview1,
      TextView rank, TextView rewardpoint, TabLayout tabProfile, LayToolbarEditbtnBinding toolbar,
      TextView userName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.abprofilecontactus = abprofilecontactus;
    this.abprofilleview = abprofilleview;
    this.address = address;
    this.baatch = baatch;
    this.companyName = companyName;
    this.connections = connections;
    this.fabAddGalleyImage = fabAddGalleyImage;
    this.ivProfileImg = ivProfileImg;
    this.ivStatusFollowing = ivStatusFollowing;
    this.llFollow = llFollow;
    this.llFollowst = llFollowst;
    this.llProfileInfo = llProfileInfo;
    this.llQrCode = llQrCode;
    this.llRanks = llRanks;
    this.llRewardPoint = llRewardPoint;
    this.llShare = llShare;
    this.messageLL = messageLL;
    this.messageimg = messageimg;
    this.profileAboutUs = profileAboutUs;
    this.profileContactUs = profileContactUs;
    this.profileGallery = profileGallery;
    this.profileReviews = profileReviews;
    this.profileview = profileview;
    this.profileview1 = profileview1;
    this.rank = rank;
    this.rewardpoint = rewardpoint;
    this.tabProfile = tabProfile;
    this.toolbar = toolbar;
    this.userName = userName;
  }

  @NonNull
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_profile, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityProfileBinding>inflateInternal(inflater, R.layout.activity_profile, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_profile, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityProfileBinding>inflateInternal(inflater, R.layout.activity_profile, null, false, component);
  }

  public static ActivityProfileBinding bind(@NonNull View view) {
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
  public static ActivityProfileBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityProfileBinding)bind(component, view, R.layout.activity_profile);
  }
}
