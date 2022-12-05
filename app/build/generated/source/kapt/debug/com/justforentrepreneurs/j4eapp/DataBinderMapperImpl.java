package com.justforentrepreneurs.j4eapp;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.justforentrepreneurs.j4eapp.databinding.AbAboutusBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbAwardrecognitionBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbBuddieslayoutBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbCommentsliBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbConnectionliBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbEventBookingBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbEventdetailsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbEventslayoutBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbFollowupliBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbGuestinvitesliBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbJ4emembersBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbLeadsdeatilsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbLeadsliBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbLeadsstatuslistBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbMemberfiltersBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbMembershipbenefitBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbPostsliBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbProfilecontactusBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbProfilleviewBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbRecognizationlayBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbRecommendedbylBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbRequirementsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbSentConnectionBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbTestimonialsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbToprackingstBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbUpgradepopupliBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AbWelcomeBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityAboutUsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityAllEventsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityAllMembersBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityBusinessCardBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityCreateBuddyMeetBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityCreateEventsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityCreateFollowUpBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityCreateGuestinviteBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityCreateOfflineBusinessBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityCreatePostsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityCreateReferralBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityCreateRequirementBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityEventBookingBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityEventJoinerBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityEventStatusBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityFeedbackBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityFeedbackEventBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityJ4eMembersBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityLoginBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityMainJ4eBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityMapsEventsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityMembershipAddBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyAwardRecognitionBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyAwardToprankBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyBuddiesBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyBusinessTransactionsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyConnectionsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyEventsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyEventsDetailBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyGroupBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyLeadsDetailBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyLeadsStatusAddBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyLeadsStatusListBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyMembershipBenefitsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyPostsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyRecognitionAddBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyRecognitionBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyReportCardBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyRequirementsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyTestimonialsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityMyguestinvitesBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityNewMyMembershipDetailsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityNotificationBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityOfflinetransactiondetailsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityOtpVerificationBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityPrivacyAndPolicyBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityProfileAboutUsEditBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityProfileBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityProfileContactUsEditBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityRecommendedBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityRecommendedLeadBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityReferralGivenBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityReferralReceivedBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityReviewprofileBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivitySearchHomeBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivitySettingBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivitySplashJ4eBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivitySubscribePlanBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityTermsAndConditionBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ActivityWelcomeBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterAllBuddiesBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterAllLeadBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterAllPostsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterApplicationsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterAwardRecognitionBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterBuddymonthBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterBusinessTransactionsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterCategorypostBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterChatGroupAdapterBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterChatIndividualBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterCommentListBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterCompletedMyleadBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterCompletedRequirementBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterEventsGalleryBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterGalleryBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterGalleryEventsliBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterJ4eMemberBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterLeadStatusCategoryBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterMyGroupBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterMyRecognitionBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterMyReportCardBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterMySubReportCardBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterMyTestimonialsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterMyguestinvitesBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterMyleadstatuslistBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterMytestimonialsactBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterPastEventsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterPendingRequirementBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterPsBuddyMeetBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterPsLeadsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterReceivedConnectionBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterRecommandexitinglistBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterRecommendPersonBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterRecommendPersonOtherBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterRecommendedByBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterReffralstatusdetailsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterRewardListBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterSearchdataBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterSearchdatatypeBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterSentConnectionBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AdapterUpcomingEventsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.AddGallryDialogBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.BmCreateBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.BsAllEventsFilterBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.BsChatbuddylistBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.BsCommentListBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.BsConfirmBookingBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.BsMemberFilterBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.BsRecommendPersonListBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.BsRewardListBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.CameraGallaryBottomsheetBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.CheckBoxPlanBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.CheckboxAdapterBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.DeactivatedDialogBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.DeleteDialogBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.DeleteDialogPdfBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.DeleteDialogPptBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.DrawerLayoutBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FeaturesmembersAdapterBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FilterBottomSheetBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FilterBusinessTransactionBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FragAllBuddiesBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FragAllLeadsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FragAllPostsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FragMyDiaryBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FragPendingConnecsentBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FragPendingConnectionBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FragPendingEventsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FragPendingMyleadsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FragPendingRequirementBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FragPrBuddyMeetBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FragPrFollowupBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FragRecommendedByBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FragRecommendedToBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FragmentAllEventBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FragmentCompletedReferralBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FragmentCompletedReferralReceivedBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FragmentFragJ4EMembersBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FragmentGroupBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FragmentIndividualBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FragmentPendingReferralBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FragmentPendingReferralReceivedBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FragmentUpcomingEventBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.FullImageDialogBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.GallaryActivityviewBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.GallaryActivityzoomBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ImagedeleteDialogBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ItemEventJoinerBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ItemEventStatusBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ItemMembershipFeatureBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ItemMembershipTitleBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ItemMembershipTitleTitleBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ItemNotificationBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ItemPackageBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ItemPostCategoryBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ItemReferralBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ItemWelcomeBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.LavDealsDiscountsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.LavMyDiaryBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.LayBottomBarBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.LayMymebershipupgradebottomshitBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.LayPalnFeaturesAdapterBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.LayPlanUpgradeadapterBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.LayProfileAboutUsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.LayProfileContactUsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.LayProfileGalleryBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.LayProfileReviewsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.LayToolbarAwardBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.LayToolbarBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.LayToolbarEditBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.LayToolbarEditbtnBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.LayToolbarEventsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.LayToolbarHomeBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.LayToolbarLeadStatusAddBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.LayToolbarLeadStatusPublishBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.LayToolbarMyLeadsBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.LayToolbarMyguestinvitesBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.LayoutMembershipAddeditBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.LayoutTandcBottomsheetBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.MainexitDialogBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.NewUpdateDialogBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.OfflineTransactionDetailsAdapterBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.PaymentFaildBottomsheetBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.PlanningEventsDialogBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.PostInfoBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.RecommandExitListpeopleBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.RecommdationNoteBmBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.RecommendationpeopleBottomsheetBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.RecommendedPersonRvAdapterBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ReffralcheckboxAdapterBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.RenewBottomsheetBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ReviewallPopupBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.SortBottomSheetBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.SplashPermissiondialogBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ThankYouBottomSheetBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ToolbarSearchBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ToolbarSimpleBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ToolbarSingleImageBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.UpdateBackgroundBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.ViewpagerProfileAdapterBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.WelcomeSlideABindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.WelcomeSlideBBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.WelcomeSlideCBindingImpl;
import com.justforentrepreneurs.j4eapp.databinding.WelcomeSlideDBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ABABOUTUS = 1;

  private static final int LAYOUT_ABAWARDRECOGNITION = 2;

  private static final int LAYOUT_ABBUDDIESLAYOUT = 3;

  private static final int LAYOUT_ABCOMMENTSLI = 4;

  private static final int LAYOUT_ABCONNECTIONLI = 5;

  private static final int LAYOUT_ABEVENTBOOKING = 6;

  private static final int LAYOUT_ABEVENTDETAILS = 7;

  private static final int LAYOUT_ABEVENTSLAYOUT = 8;

  private static final int LAYOUT_ABFOLLOWUPLI = 9;

  private static final int LAYOUT_ABGUESTINVITESLI = 10;

  private static final int LAYOUT_ABJ4EMEMBERS = 11;

  private static final int LAYOUT_ABLEADSDEATILS = 12;

  private static final int LAYOUT_ABLEADSLI = 13;

  private static final int LAYOUT_ABLEADSSTATUSLIST = 14;

  private static final int LAYOUT_ABMEMBERFILTERS = 15;

  private static final int LAYOUT_ABMEMBERSHIPBENEFIT = 16;

  private static final int LAYOUT_ABPOSTSLI = 17;

  private static final int LAYOUT_ABPROFILECONTACTUS = 18;

  private static final int LAYOUT_ABPROFILLEVIEW = 19;

  private static final int LAYOUT_ABRECOGNIZATIONLAY = 20;

  private static final int LAYOUT_ABRECOMMENDEDBYL = 21;

  private static final int LAYOUT_ABREQUIREMENTS = 22;

  private static final int LAYOUT_ABSENTCONNECTION = 23;

  private static final int LAYOUT_ABTESTIMONIALS = 24;

  private static final int LAYOUT_ABTOPRACKINGST = 25;

  private static final int LAYOUT_ABUPGRADEPOPUPLI = 26;

  private static final int LAYOUT_ABWELCOME = 27;

  private static final int LAYOUT_ACTIVITYABOUTUS = 28;

  private static final int LAYOUT_ACTIVITYALLEVENTS = 29;

  private static final int LAYOUT_ACTIVITYALLMEMBERS = 30;

  private static final int LAYOUT_ACTIVITYBUSINESSCARD = 31;

  private static final int LAYOUT_ACTIVITYCREATEBUDDYMEET = 32;

  private static final int LAYOUT_ACTIVITYCREATEEVENTS = 33;

  private static final int LAYOUT_ACTIVITYCREATEFOLLOWUP = 34;

  private static final int LAYOUT_ACTIVITYCREATEGUESTINVITE = 35;

  private static final int LAYOUT_ACTIVITYCREATEOFFLINEBUSINESS = 36;

  private static final int LAYOUT_ACTIVITYCREATEPOSTS = 37;

  private static final int LAYOUT_ACTIVITYCREATEREFERRAL = 38;

  private static final int LAYOUT_ACTIVITYCREATEREQUIREMENT = 39;

  private static final int LAYOUT_ACTIVITYEVENTBOOKING = 40;

  private static final int LAYOUT_ACTIVITYEVENTJOINER = 41;

  private static final int LAYOUT_ACTIVITYEVENTSTATUS = 42;

  private static final int LAYOUT_ACTIVITYFEEDBACK = 43;

  private static final int LAYOUT_ACTIVITYFEEDBACKEVENT = 44;

  private static final int LAYOUT_ACTIVITYJ4EMEMBERS = 45;

  private static final int LAYOUT_ACTIVITYLOGIN = 46;

  private static final int LAYOUT_ACTIVITYMAINJ4E = 47;

  private static final int LAYOUT_ACTIVITYMAPSEVENTS = 48;

  private static final int LAYOUT_ACTIVITYMEMBERSHIPADD = 49;

  private static final int LAYOUT_ACTIVITYMYAWARDRECOGNITION = 50;

  private static final int LAYOUT_ACTIVITYMYAWARDTOPRANK = 51;

  private static final int LAYOUT_ACTIVITYMYBUDDIES = 52;

  private static final int LAYOUT_ACTIVITYMYBUSINESSTRANSACTIONS = 53;

  private static final int LAYOUT_ACTIVITYMYCONNECTIONS = 54;

  private static final int LAYOUT_ACTIVITYMYEVENTS = 55;

  private static final int LAYOUT_ACTIVITYMYEVENTSDETAIL = 56;

  private static final int LAYOUT_ACTIVITYMYGROUP = 57;

  private static final int LAYOUT_ACTIVITYMYLEADSDETAIL = 58;

  private static final int LAYOUT_ACTIVITYMYLEADSSTATUSADD = 59;

  private static final int LAYOUT_ACTIVITYMYLEADSSTATUSLIST = 60;

  private static final int LAYOUT_ACTIVITYMYMEMBERSHIPBENEFITS = 61;

  private static final int LAYOUT_ACTIVITYMYPOSTS = 62;

  private static final int LAYOUT_ACTIVITYMYRECOGNITION = 63;

  private static final int LAYOUT_ACTIVITYMYRECOGNITIONADD = 64;

  private static final int LAYOUT_ACTIVITYMYREPORTCARD = 65;

  private static final int LAYOUT_ACTIVITYMYREQUIREMENTS = 66;

  private static final int LAYOUT_ACTIVITYMYTESTIMONIALS = 67;

  private static final int LAYOUT_ACTIVITYMYGUESTINVITES = 68;

  private static final int LAYOUT_ACTIVITYNEWMYMEMBERSHIPDETAILS = 69;

  private static final int LAYOUT_ACTIVITYNOTIFICATION = 70;

  private static final int LAYOUT_ACTIVITYOFFLINETRANSACTIONDETAILS = 71;

  private static final int LAYOUT_ACTIVITYOTPVERIFICATION = 72;

  private static final int LAYOUT_ACTIVITYPRIVACYANDPOLICY = 73;

  private static final int LAYOUT_ACTIVITYPROFILE = 74;

  private static final int LAYOUT_ACTIVITYPROFILEABOUTUSEDIT = 75;

  private static final int LAYOUT_ACTIVITYPROFILECONTACTUSEDIT = 76;

  private static final int LAYOUT_ACTIVITYRECOMMENDED = 77;

  private static final int LAYOUT_ACTIVITYRECOMMENDEDLEAD = 78;

  private static final int LAYOUT_ACTIVITYREFERRALGIVEN = 79;

  private static final int LAYOUT_ACTIVITYREFERRALRECEIVED = 80;

  private static final int LAYOUT_ACTIVITYREVIEWPROFILE = 81;

  private static final int LAYOUT_ACTIVITYSEARCHHOME = 82;

  private static final int LAYOUT_ACTIVITYSETTING = 83;

  private static final int LAYOUT_ACTIVITYSPLASHJ4E = 84;

  private static final int LAYOUT_ACTIVITYSUBSCRIBEPLAN = 85;

  private static final int LAYOUT_ACTIVITYTERMSANDCONDITION = 86;

  private static final int LAYOUT_ACTIVITYWELCOME = 87;

  private static final int LAYOUT_ADAPTERALLBUDDIES = 88;

  private static final int LAYOUT_ADAPTERALLLEAD = 89;

  private static final int LAYOUT_ADAPTERALLPOSTS = 90;

  private static final int LAYOUT_ADAPTERAPPLICATIONS = 91;

  private static final int LAYOUT_ADAPTERAWARDRECOGNITION = 92;

  private static final int LAYOUT_ADAPTERBUDDYMONTH = 93;

  private static final int LAYOUT_ADAPTERBUSINESSTRANSACTIONS = 94;

  private static final int LAYOUT_ADAPTERCATEGORYPOST = 95;

  private static final int LAYOUT_ADAPTERCHATGROUPADAPTER = 96;

  private static final int LAYOUT_ADAPTERCHATINDIVIDUAL = 97;

  private static final int LAYOUT_ADAPTERCOMMENTLIST = 98;

  private static final int LAYOUT_ADAPTERCOMPLETEDMYLEAD = 99;

  private static final int LAYOUT_ADAPTERCOMPLETEDREQUIREMENT = 100;

  private static final int LAYOUT_ADAPTEREVENTSGALLERY = 101;

  private static final int LAYOUT_ADAPTERGALLERY = 102;

  private static final int LAYOUT_ADAPTERGALLERYEVENTSLI = 103;

  private static final int LAYOUT_ADAPTERJ4EMEMBER = 104;

  private static final int LAYOUT_ADAPTERLEADSTATUSCATEGORY = 105;

  private static final int LAYOUT_ADAPTERMYGROUP = 106;

  private static final int LAYOUT_ADAPTERMYRECOGNITION = 107;

  private static final int LAYOUT_ADAPTERMYREPORTCARD = 108;

  private static final int LAYOUT_ADAPTERMYSUBREPORTCARD = 109;

  private static final int LAYOUT_ADAPTERMYTESTIMONIALS = 110;

  private static final int LAYOUT_ADAPTERMYGUESTINVITES = 111;

  private static final int LAYOUT_ADAPTERMYLEADSTATUSLIST = 112;

  private static final int LAYOUT_ADAPTERMYTESTIMONIALSACT = 113;

  private static final int LAYOUT_ADAPTERPASTEVENTS = 114;

  private static final int LAYOUT_ADAPTERPENDINGREQUIREMENT = 115;

  private static final int LAYOUT_ADAPTERPSBUDDYMEET = 116;

  private static final int LAYOUT_ADAPTERPSLEADS = 117;

  private static final int LAYOUT_ADAPTERRECEIVEDCONNECTION = 118;

  private static final int LAYOUT_ADAPTERRECOMMANDEXITINGLIST = 119;

  private static final int LAYOUT_ADAPTERRECOMMENDPERSON = 120;

  private static final int LAYOUT_ADAPTERRECOMMENDPERSONOTHER = 121;

  private static final int LAYOUT_ADAPTERRECOMMENDEDBY = 122;

  private static final int LAYOUT_ADAPTERREFFRALSTATUSDETAILS = 123;

  private static final int LAYOUT_ADAPTERREWARDLIST = 124;

  private static final int LAYOUT_ADAPTERSEARCHDATA = 125;

  private static final int LAYOUT_ADAPTERSEARCHDATATYPE = 126;

  private static final int LAYOUT_ADAPTERSENTCONNECTION = 127;

  private static final int LAYOUT_ADAPTERUPCOMINGEVENTS = 128;

  private static final int LAYOUT_ADDGALLRYDIALOG = 129;

  private static final int LAYOUT_BMCREATE = 130;

  private static final int LAYOUT_BSALLEVENTSFILTER = 131;

  private static final int LAYOUT_BSCHATBUDDYLIST = 132;

  private static final int LAYOUT_BSCOMMENTLIST = 133;

  private static final int LAYOUT_BSCONFIRMBOOKING = 134;

  private static final int LAYOUT_BSMEMBERFILTER = 135;

  private static final int LAYOUT_BSRECOMMENDPERSONLIST = 136;

  private static final int LAYOUT_BSREWARDLIST = 137;

  private static final int LAYOUT_CAMERAGALLARYBOTTOMSHEET = 138;

  private static final int LAYOUT_CHECKBOXPLAN = 139;

  private static final int LAYOUT_CHECKBOXADAPTER = 140;

  private static final int LAYOUT_DEACTIVATEDDIALOG = 141;

  private static final int LAYOUT_DELETEDIALOG = 142;

  private static final int LAYOUT_DELETEDIALOGPDF = 143;

  private static final int LAYOUT_DELETEDIALOGPPT = 144;

  private static final int LAYOUT_DRAWERLAYOUT = 145;

  private static final int LAYOUT_FEATURESMEMBERSADAPTER = 146;

  private static final int LAYOUT_FILTERBOTTOMSHEET = 147;

  private static final int LAYOUT_FILTERBUSINESSTRANSACTION = 148;

  private static final int LAYOUT_FRAGALLBUDDIES = 149;

  private static final int LAYOUT_FRAGALLLEADS = 150;

  private static final int LAYOUT_FRAGALLPOSTS = 151;

  private static final int LAYOUT_FRAGMYDIARY = 152;

  private static final int LAYOUT_FRAGPENDINGCONNECSENT = 153;

  private static final int LAYOUT_FRAGPENDINGCONNECTION = 154;

  private static final int LAYOUT_FRAGPENDINGEVENTS = 155;

  private static final int LAYOUT_FRAGPENDINGMYLEADS = 156;

  private static final int LAYOUT_FRAGPENDINGREQUIREMENT = 157;

  private static final int LAYOUT_FRAGPRBUDDYMEET = 158;

  private static final int LAYOUT_FRAGPRFOLLOWUP = 159;

  private static final int LAYOUT_FRAGRECOMMENDEDBY = 160;

  private static final int LAYOUT_FRAGRECOMMENDEDTO = 161;

  private static final int LAYOUT_FRAGMENTALLEVENT = 162;

  private static final int LAYOUT_FRAGMENTCOMPLETEDREFERRAL = 163;

  private static final int LAYOUT_FRAGMENTCOMPLETEDREFERRALRECEIVED = 164;

  private static final int LAYOUT_FRAGMENTFRAGJ4EMEMBERS = 165;

  private static final int LAYOUT_FRAGMENTGROUP = 166;

  private static final int LAYOUT_FRAGMENTINDIVIDUAL = 167;

  private static final int LAYOUT_FRAGMENTPENDINGREFERRAL = 168;

  private static final int LAYOUT_FRAGMENTPENDINGREFERRALRECEIVED = 169;

  private static final int LAYOUT_FRAGMENTUPCOMINGEVENT = 170;

  private static final int LAYOUT_FULLIMAGEDIALOG = 171;

  private static final int LAYOUT_GALLARYACTIVITYVIEW = 172;

  private static final int LAYOUT_GALLARYACTIVITYZOOM = 173;

  private static final int LAYOUT_IMAGEDELETEDIALOG = 174;

  private static final int LAYOUT_ITEMEVENTJOINER = 175;

  private static final int LAYOUT_ITEMEVENTSTATUS = 176;

  private static final int LAYOUT_ITEMMEMBERSHIPFEATURE = 177;

  private static final int LAYOUT_ITEMMEMBERSHIPTITLE = 178;

  private static final int LAYOUT_ITEMMEMBERSHIPTITLETITLE = 179;

  private static final int LAYOUT_ITEMNOTIFICATION = 180;

  private static final int LAYOUT_ITEMPACKAGE = 181;

  private static final int LAYOUT_ITEMPOSTCATEGORY = 182;

  private static final int LAYOUT_ITEMREFERRAL = 183;

  private static final int LAYOUT_ITEMWELCOME = 184;

  private static final int LAYOUT_LAVDEALSDISCOUNTS = 185;

  private static final int LAYOUT_LAVMYDIARY = 186;

  private static final int LAYOUT_LAYBOTTOMBAR = 187;

  private static final int LAYOUT_LAYMYMEBERSHIPUPGRADEBOTTOMSHIT = 188;

  private static final int LAYOUT_LAYPALNFEATURESADAPTER = 189;

  private static final int LAYOUT_LAYPLANUPGRADEADAPTER = 190;

  private static final int LAYOUT_LAYPROFILEABOUTUS = 191;

  private static final int LAYOUT_LAYPROFILECONTACTUS = 192;

  private static final int LAYOUT_LAYPROFILEGALLERY = 193;

  private static final int LAYOUT_LAYPROFILEREVIEWS = 194;

  private static final int LAYOUT_LAYTOOLBAR = 195;

  private static final int LAYOUT_LAYTOOLBARAWARD = 196;

  private static final int LAYOUT_LAYTOOLBAREDIT = 197;

  private static final int LAYOUT_LAYTOOLBAREDITBTN = 198;

  private static final int LAYOUT_LAYTOOLBAREVENTS = 199;

  private static final int LAYOUT_LAYTOOLBARHOME = 200;

  private static final int LAYOUT_LAYTOOLBARLEADSTATUSADD = 201;

  private static final int LAYOUT_LAYTOOLBARLEADSTATUSPUBLISH = 202;

  private static final int LAYOUT_LAYTOOLBARMYLEADS = 203;

  private static final int LAYOUT_LAYTOOLBARMYGUESTINVITES = 204;

  private static final int LAYOUT_LAYOUTMEMBERSHIPADDEDIT = 205;

  private static final int LAYOUT_LAYOUTTANDCBOTTOMSHEET = 206;

  private static final int LAYOUT_MAINEXITDIALOG = 207;

  private static final int LAYOUT_NEWUPDATEDIALOG = 208;

  private static final int LAYOUT_OFFLINETRANSACTIONDETAILSADAPTER = 209;

  private static final int LAYOUT_PAYMENTFAILDBOTTOMSHEET = 210;

  private static final int LAYOUT_PLANEXPAIREDDIALOG = 211;

  private static final int LAYOUT_PLANNINGEVENTSDIALOG = 212;

  private static final int LAYOUT_POSTINFO = 213;

  private static final int LAYOUT_RECOMMANDEXITLISTPEOPLE = 214;

  private static final int LAYOUT_RECOMMDATIONNOTEBM = 215;

  private static final int LAYOUT_RECOMMENDATIONPEOPLEBOTTOMSHEET = 216;

  private static final int LAYOUT_RECOMMENDEDPERSONRVADAPTER = 217;

  private static final int LAYOUT_REFFRALCHECKBOXADAPTER = 218;

  private static final int LAYOUT_RENEWBOTTOMSHEET = 219;

  private static final int LAYOUT_REVIEWALLPOPUP = 220;

  private static final int LAYOUT_SORTBOTTOMSHEET = 221;

  private static final int LAYOUT_SPLASHPERMISSIONDIALOG = 222;

  private static final int LAYOUT_THANKYOUBOTTOMSHEET = 223;

  private static final int LAYOUT_TOOLBARSEARCH = 224;

  private static final int LAYOUT_TOOLBARSIMPLE = 225;

  private static final int LAYOUT_TOOLBARSINGLEIMAGE = 226;

  private static final int LAYOUT_UPDATEBACKGROUND = 227;

  private static final int LAYOUT_VIEWPAGERPROFILEADAPTER = 228;

  private static final int LAYOUT_WELCOMESLIDEA = 229;

  private static final int LAYOUT_WELCOMESLIDEB = 230;

  private static final int LAYOUT_WELCOMESLIDEC = 231;

  private static final int LAYOUT_WELCOMESLIDED = 232;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(232);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_aboutus, LAYOUT_ABABOUTUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_awardrecognition, LAYOUT_ABAWARDRECOGNITION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_buddieslayout, LAYOUT_ABBUDDIESLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_commentsli, LAYOUT_ABCOMMENTSLI);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_connectionli, LAYOUT_ABCONNECTIONLI);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_event_booking, LAYOUT_ABEVENTBOOKING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_eventdetails, LAYOUT_ABEVENTDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_eventslayout, LAYOUT_ABEVENTSLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_followupli, LAYOUT_ABFOLLOWUPLI);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_guestinvitesli, LAYOUT_ABGUESTINVITESLI);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_j4emembers, LAYOUT_ABJ4EMEMBERS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_leadsdeatils, LAYOUT_ABLEADSDEATILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_leadsli, LAYOUT_ABLEADSLI);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_leadsstatuslist, LAYOUT_ABLEADSSTATUSLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_memberfilters, LAYOUT_ABMEMBERFILTERS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_membershipbenefit, LAYOUT_ABMEMBERSHIPBENEFIT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_postsli, LAYOUT_ABPOSTSLI);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_profilecontactus, LAYOUT_ABPROFILECONTACTUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_profilleview, LAYOUT_ABPROFILLEVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_recognizationlay, LAYOUT_ABRECOGNIZATIONLAY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_recommendedbyl, LAYOUT_ABRECOMMENDEDBYL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_requirements, LAYOUT_ABREQUIREMENTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_sent_connection, LAYOUT_ABSENTCONNECTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_testimonials, LAYOUT_ABTESTIMONIALS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_toprackingst, LAYOUT_ABTOPRACKINGST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_upgradepopupli, LAYOUT_ABUPGRADEPOPUPLI);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.ab_welcome, LAYOUT_ABWELCOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_about_us, LAYOUT_ACTIVITYABOUTUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_all_events, LAYOUT_ACTIVITYALLEVENTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_all_members, LAYOUT_ACTIVITYALLMEMBERS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_business_card, LAYOUT_ACTIVITYBUSINESSCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_create_buddy_meet, LAYOUT_ACTIVITYCREATEBUDDYMEET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_create_events, LAYOUT_ACTIVITYCREATEEVENTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_create_follow_up, LAYOUT_ACTIVITYCREATEFOLLOWUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_create_guestinvite, LAYOUT_ACTIVITYCREATEGUESTINVITE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_create_offline_business, LAYOUT_ACTIVITYCREATEOFFLINEBUSINESS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_create_posts, LAYOUT_ACTIVITYCREATEPOSTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_create_referral, LAYOUT_ACTIVITYCREATEREFERRAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_create_requirement, LAYOUT_ACTIVITYCREATEREQUIREMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_event_booking, LAYOUT_ACTIVITYEVENTBOOKING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_event_joiner, LAYOUT_ACTIVITYEVENTJOINER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_event_status, LAYOUT_ACTIVITYEVENTSTATUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_feedback, LAYOUT_ACTIVITYFEEDBACK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_feedback_event, LAYOUT_ACTIVITYFEEDBACKEVENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_j4e_members, LAYOUT_ACTIVITYJ4EMEMBERS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_main_j4e, LAYOUT_ACTIVITYMAINJ4E);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_maps_events, LAYOUT_ACTIVITYMAPSEVENTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_membership_add, LAYOUT_ACTIVITYMEMBERSHIPADD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_my_award_recognition, LAYOUT_ACTIVITYMYAWARDRECOGNITION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_my_award_toprank, LAYOUT_ACTIVITYMYAWARDTOPRANK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_my_buddies, LAYOUT_ACTIVITYMYBUDDIES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_my_business_transactions, LAYOUT_ACTIVITYMYBUSINESSTRANSACTIONS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_my_connections, LAYOUT_ACTIVITYMYCONNECTIONS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_my_events, LAYOUT_ACTIVITYMYEVENTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_my_events_detail, LAYOUT_ACTIVITYMYEVENTSDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_my_group, LAYOUT_ACTIVITYMYGROUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_my_leads_detail, LAYOUT_ACTIVITYMYLEADSDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_my_leads_status_add, LAYOUT_ACTIVITYMYLEADSSTATUSADD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_my_leads_status_list, LAYOUT_ACTIVITYMYLEADSSTATUSLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_my_membership_benefits, LAYOUT_ACTIVITYMYMEMBERSHIPBENEFITS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_my_posts, LAYOUT_ACTIVITYMYPOSTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_my_recognition, LAYOUT_ACTIVITYMYRECOGNITION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_my_recognition_add, LAYOUT_ACTIVITYMYRECOGNITIONADD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_my_report_card, LAYOUT_ACTIVITYMYREPORTCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_my_requirements, LAYOUT_ACTIVITYMYREQUIREMENTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_my_testimonials, LAYOUT_ACTIVITYMYTESTIMONIALS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_myguestinvites, LAYOUT_ACTIVITYMYGUESTINVITES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_new_my_membership_details, LAYOUT_ACTIVITYNEWMYMEMBERSHIPDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_notification, LAYOUT_ACTIVITYNOTIFICATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_offlinetransactiondetails, LAYOUT_ACTIVITYOFFLINETRANSACTIONDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_otp_verification, LAYOUT_ACTIVITYOTPVERIFICATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_privacy_and_policy, LAYOUT_ACTIVITYPRIVACYANDPOLICY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_profile, LAYOUT_ACTIVITYPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_profile_about_us_edit, LAYOUT_ACTIVITYPROFILEABOUTUSEDIT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_profile_contact_us_edit, LAYOUT_ACTIVITYPROFILECONTACTUSEDIT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_recommended, LAYOUT_ACTIVITYRECOMMENDED);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_recommended_lead, LAYOUT_ACTIVITYRECOMMENDEDLEAD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_referral_given, LAYOUT_ACTIVITYREFERRALGIVEN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_referral_received, LAYOUT_ACTIVITYREFERRALRECEIVED);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_reviewprofile, LAYOUT_ACTIVITYREVIEWPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_search_home, LAYOUT_ACTIVITYSEARCHHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_setting, LAYOUT_ACTIVITYSETTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_splash_j4e, LAYOUT_ACTIVITYSPLASHJ4E);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_subscribe_plan, LAYOUT_ACTIVITYSUBSCRIBEPLAN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_terms_and_condition, LAYOUT_ACTIVITYTERMSANDCONDITION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.activity_welcome, LAYOUT_ACTIVITYWELCOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_all_buddies, LAYOUT_ADAPTERALLBUDDIES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_all_lead, LAYOUT_ADAPTERALLLEAD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_all_posts, LAYOUT_ADAPTERALLPOSTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_applications, LAYOUT_ADAPTERAPPLICATIONS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_award_recognition, LAYOUT_ADAPTERAWARDRECOGNITION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_buddymonth, LAYOUT_ADAPTERBUDDYMONTH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_business_transactions, LAYOUT_ADAPTERBUSINESSTRANSACTIONS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_categorypost, LAYOUT_ADAPTERCATEGORYPOST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_chat_group_adapter, LAYOUT_ADAPTERCHATGROUPADAPTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_chat_individual, LAYOUT_ADAPTERCHATINDIVIDUAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_comment_list, LAYOUT_ADAPTERCOMMENTLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_completed_mylead, LAYOUT_ADAPTERCOMPLETEDMYLEAD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_completed_requirement, LAYOUT_ADAPTERCOMPLETEDREQUIREMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_events_gallery, LAYOUT_ADAPTEREVENTSGALLERY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_gallery, LAYOUT_ADAPTERGALLERY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_gallery_eventsli, LAYOUT_ADAPTERGALLERYEVENTSLI);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_j4e_member, LAYOUT_ADAPTERJ4EMEMBER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_lead_status_category, LAYOUT_ADAPTERLEADSTATUSCATEGORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_my_group, LAYOUT_ADAPTERMYGROUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_my_recognition, LAYOUT_ADAPTERMYRECOGNITION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_my_report_card, LAYOUT_ADAPTERMYREPORTCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_my_sub_report_card, LAYOUT_ADAPTERMYSUBREPORTCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_my_testimonials, LAYOUT_ADAPTERMYTESTIMONIALS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_myguestinvites, LAYOUT_ADAPTERMYGUESTINVITES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_myleadstatuslist, LAYOUT_ADAPTERMYLEADSTATUSLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_mytestimonialsact, LAYOUT_ADAPTERMYTESTIMONIALSACT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_past_events, LAYOUT_ADAPTERPASTEVENTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_pending_requirement, LAYOUT_ADAPTERPENDINGREQUIREMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_ps_buddy_meet, LAYOUT_ADAPTERPSBUDDYMEET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_ps_leads, LAYOUT_ADAPTERPSLEADS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_received_connection, LAYOUT_ADAPTERRECEIVEDCONNECTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_recommandexitinglist, LAYOUT_ADAPTERRECOMMANDEXITINGLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_recommend_person, LAYOUT_ADAPTERRECOMMENDPERSON);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_recommend_person_other, LAYOUT_ADAPTERRECOMMENDPERSONOTHER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_recommended_by, LAYOUT_ADAPTERRECOMMENDEDBY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_reffralstatusdetails, LAYOUT_ADAPTERREFFRALSTATUSDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_reward_list, LAYOUT_ADAPTERREWARDLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_searchdata, LAYOUT_ADAPTERSEARCHDATA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_searchdatatype, LAYOUT_ADAPTERSEARCHDATATYPE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_sent_connection, LAYOUT_ADAPTERSENTCONNECTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.adapter_upcoming_events, LAYOUT_ADAPTERUPCOMINGEVENTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.add_gallry_dialog, LAYOUT_ADDGALLRYDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.bm_create, LAYOUT_BMCREATE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.bs_all_events_filter, LAYOUT_BSALLEVENTSFILTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.bs_chatbuddylist, LAYOUT_BSCHATBUDDYLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.bs_comment_list, LAYOUT_BSCOMMENTLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.bs_confirm_booking, LAYOUT_BSCONFIRMBOOKING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.bs_member_filter, LAYOUT_BSMEMBERFILTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.bs_recommend_person_list, LAYOUT_BSRECOMMENDPERSONLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.bs_reward_list, LAYOUT_BSREWARDLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.camera_gallary_bottomsheet, LAYOUT_CAMERAGALLARYBOTTOMSHEET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.check_box_plan, LAYOUT_CHECKBOXPLAN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.checkbox_adapter, LAYOUT_CHECKBOXADAPTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.deactivated_dialog, LAYOUT_DEACTIVATEDDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.delete_dialog, LAYOUT_DELETEDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.delete_dialog_pdf, LAYOUT_DELETEDIALOGPDF);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.delete_dialog_ppt, LAYOUT_DELETEDIALOGPPT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.drawer_layout, LAYOUT_DRAWERLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.featuresmembers_adapter, LAYOUT_FEATURESMEMBERSADAPTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.filter_bottom_sheet, LAYOUT_FILTERBOTTOMSHEET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.filter_business_transaction, LAYOUT_FILTERBUSINESSTRANSACTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.frag_all_buddies, LAYOUT_FRAGALLBUDDIES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.frag_all_leads, LAYOUT_FRAGALLLEADS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.frag_all_posts, LAYOUT_FRAGALLPOSTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.frag_my_diary, LAYOUT_FRAGMYDIARY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.frag_pending_connecsent, LAYOUT_FRAGPENDINGCONNECSENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.frag_pending_connection, LAYOUT_FRAGPENDINGCONNECTION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.frag_pending_events, LAYOUT_FRAGPENDINGEVENTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.frag_pending_myleads, LAYOUT_FRAGPENDINGMYLEADS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.frag_pending_requirement, LAYOUT_FRAGPENDINGREQUIREMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.frag_pr_buddy_meet, LAYOUT_FRAGPRBUDDYMEET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.frag_pr_followup, LAYOUT_FRAGPRFOLLOWUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.frag_recommended_by, LAYOUT_FRAGRECOMMENDEDBY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.frag_recommended_to, LAYOUT_FRAGRECOMMENDEDTO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.fragment_all_event, LAYOUT_FRAGMENTALLEVENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.fragment_completed_referral, LAYOUT_FRAGMENTCOMPLETEDREFERRAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.fragment_completed_referral_received, LAYOUT_FRAGMENTCOMPLETEDREFERRALRECEIVED);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.fragment_frag_j4_e_members, LAYOUT_FRAGMENTFRAGJ4EMEMBERS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.fragment_group, LAYOUT_FRAGMENTGROUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.fragment_individual, LAYOUT_FRAGMENTINDIVIDUAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.fragment_pending_referral, LAYOUT_FRAGMENTPENDINGREFERRAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.fragment_pending_referral_received, LAYOUT_FRAGMENTPENDINGREFERRALRECEIVED);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.fragment_upcoming_event, LAYOUT_FRAGMENTUPCOMINGEVENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.full_image_dialog, LAYOUT_FULLIMAGEDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.gallary_activityview, LAYOUT_GALLARYACTIVITYVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.gallary_activityzoom, LAYOUT_GALLARYACTIVITYZOOM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.imagedelete_dialog, LAYOUT_IMAGEDELETEDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.item_event_joiner, LAYOUT_ITEMEVENTJOINER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.item_event_status, LAYOUT_ITEMEVENTSTATUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.item_membership_feature, LAYOUT_ITEMMEMBERSHIPFEATURE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.item_membership_title, LAYOUT_ITEMMEMBERSHIPTITLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.item_membership_title_title, LAYOUT_ITEMMEMBERSHIPTITLETITLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.item_notification, LAYOUT_ITEMNOTIFICATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.item_package, LAYOUT_ITEMPACKAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.item_post_category, LAYOUT_ITEMPOSTCATEGORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.item_referral, LAYOUT_ITEMREFERRAL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.item_welcome, LAYOUT_ITEMWELCOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.lav_deals_discounts, LAYOUT_LAVDEALSDISCOUNTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.lav_my_diary, LAYOUT_LAVMYDIARY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.lay_bottom_bar, LAYOUT_LAYBOTTOMBAR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.lay_mymebershipupgradebottomshit, LAYOUT_LAYMYMEBERSHIPUPGRADEBOTTOMSHIT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.lay_paln_features_adapter, LAYOUT_LAYPALNFEATURESADAPTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.lay_plan_upgradeadapter, LAYOUT_LAYPLANUPGRADEADAPTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.lay_profile_about_us, LAYOUT_LAYPROFILEABOUTUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.lay_profile_contact_us, LAYOUT_LAYPROFILECONTACTUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.lay_profile_gallery, LAYOUT_LAYPROFILEGALLERY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.lay_profile_reviews, LAYOUT_LAYPROFILEREVIEWS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar, LAYOUT_LAYTOOLBAR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_award, LAYOUT_LAYTOOLBARAWARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_edit, LAYOUT_LAYTOOLBAREDIT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_editbtn, LAYOUT_LAYTOOLBAREDITBTN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_events, LAYOUT_LAYTOOLBAREVENTS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_home, LAYOUT_LAYTOOLBARHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_lead_status_add, LAYOUT_LAYTOOLBARLEADSTATUSADD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_lead_status_publish, LAYOUT_LAYTOOLBARLEADSTATUSPUBLISH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_my_leads, LAYOUT_LAYTOOLBARMYLEADS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_myguestinvites, LAYOUT_LAYTOOLBARMYGUESTINVITES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.layout_membership_addedit, LAYOUT_LAYOUTMEMBERSHIPADDEDIT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.layout_tandc_bottomsheet, LAYOUT_LAYOUTTANDCBOTTOMSHEET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.mainexit_dialog, LAYOUT_MAINEXITDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.new_update_dialog, LAYOUT_NEWUPDATEDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.offline_transaction_details_adapter, LAYOUT_OFFLINETRANSACTIONDETAILSADAPTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.payment_faild_bottomsheet, LAYOUT_PAYMENTFAILDBOTTOMSHEET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.planexpaireddialog, LAYOUT_PLANEXPAIREDDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.planning_events_dialog, LAYOUT_PLANNINGEVENTSDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.post_info, LAYOUT_POSTINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.recommand_exit_listpeople, LAYOUT_RECOMMANDEXITLISTPEOPLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.recommdation_note_bm, LAYOUT_RECOMMDATIONNOTEBM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.recommendationpeople_bottomsheet, LAYOUT_RECOMMENDATIONPEOPLEBOTTOMSHEET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.recommended_person_rv_adapter, LAYOUT_RECOMMENDEDPERSONRVADAPTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.reffralcheckbox_adapter, LAYOUT_REFFRALCHECKBOXADAPTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.renew_bottomsheet, LAYOUT_RENEWBOTTOMSHEET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.reviewall_popup, LAYOUT_REVIEWALLPOPUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.sort_bottom_sheet, LAYOUT_SORTBOTTOMSHEET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.splash_permissiondialog, LAYOUT_SPLASHPERMISSIONDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.thank_you_bottom_sheet, LAYOUT_THANKYOUBOTTOMSHEET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.toolbar_search, LAYOUT_TOOLBARSEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.toolbar_simple, LAYOUT_TOOLBARSIMPLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.toolbar_single_image, LAYOUT_TOOLBARSINGLEIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.update_background, LAYOUT_UPDATEBACKGROUND);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.viewpager_profile_adapter, LAYOUT_VIEWPAGERPROFILEADAPTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.welcome_slide_a, LAYOUT_WELCOMESLIDEA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.welcome_slide_b, LAYOUT_WELCOMESLIDEB);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.welcome_slide_c, LAYOUT_WELCOMESLIDEC);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.justforentrepreneurs.j4eapp.R.layout.welcome_slide_d, LAYOUT_WELCOMESLIDED);
  }

  private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ABABOUTUS: {
        if ("layout/ab_aboutus_0".equals(tag)) {
          return new AbAboutusBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_aboutus is invalid. Received: " + tag);
      }
      case  LAYOUT_ABAWARDRECOGNITION: {
        if ("layout/ab_awardrecognition_0".equals(tag)) {
          return new AbAwardrecognitionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_awardrecognition is invalid. Received: " + tag);
      }
      case  LAYOUT_ABBUDDIESLAYOUT: {
        if ("layout/ab_buddieslayout_0".equals(tag)) {
          return new AbBuddieslayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_buddieslayout is invalid. Received: " + tag);
      }
      case  LAYOUT_ABCOMMENTSLI: {
        if ("layout/ab_commentsli_0".equals(tag)) {
          return new AbCommentsliBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_commentsli is invalid. Received: " + tag);
      }
      case  LAYOUT_ABCONNECTIONLI: {
        if ("layout/ab_connectionli_0".equals(tag)) {
          return new AbConnectionliBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_connectionli is invalid. Received: " + tag);
      }
      case  LAYOUT_ABEVENTBOOKING: {
        if ("layout/ab_event_booking_0".equals(tag)) {
          return new AbEventBookingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_event_booking is invalid. Received: " + tag);
      }
      case  LAYOUT_ABEVENTDETAILS: {
        if ("layout/ab_eventdetails_0".equals(tag)) {
          return new AbEventdetailsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_eventdetails is invalid. Received: " + tag);
      }
      case  LAYOUT_ABEVENTSLAYOUT: {
        if ("layout/ab_eventslayout_0".equals(tag)) {
          return new AbEventslayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_eventslayout is invalid. Received: " + tag);
      }
      case  LAYOUT_ABFOLLOWUPLI: {
        if ("layout/ab_followupli_0".equals(tag)) {
          return new AbFollowupliBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_followupli is invalid. Received: " + tag);
      }
      case  LAYOUT_ABGUESTINVITESLI: {
        if ("layout/ab_guestinvitesli_0".equals(tag)) {
          return new AbGuestinvitesliBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_guestinvitesli is invalid. Received: " + tag);
      }
      case  LAYOUT_ABJ4EMEMBERS: {
        if ("layout/ab_j4emembers_0".equals(tag)) {
          return new AbJ4emembersBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_j4emembers is invalid. Received: " + tag);
      }
      case  LAYOUT_ABLEADSDEATILS: {
        if ("layout/ab_leadsdeatils_0".equals(tag)) {
          return new AbLeadsdeatilsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_leadsdeatils is invalid. Received: " + tag);
      }
      case  LAYOUT_ABLEADSLI: {
        if ("layout/ab_leadsli_0".equals(tag)) {
          return new AbLeadsliBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_leadsli is invalid. Received: " + tag);
      }
      case  LAYOUT_ABLEADSSTATUSLIST: {
        if ("layout/ab_leadsstatuslist_0".equals(tag)) {
          return new AbLeadsstatuslistBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_leadsstatuslist is invalid. Received: " + tag);
      }
      case  LAYOUT_ABMEMBERFILTERS: {
        if ("layout/ab_memberfilters_0".equals(tag)) {
          return new AbMemberfiltersBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_memberfilters is invalid. Received: " + tag);
      }
      case  LAYOUT_ABMEMBERSHIPBENEFIT: {
        if ("layout/ab_membershipbenefit_0".equals(tag)) {
          return new AbMembershipbenefitBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_membershipbenefit is invalid. Received: " + tag);
      }
      case  LAYOUT_ABPOSTSLI: {
        if ("layout/ab_postsli_0".equals(tag)) {
          return new AbPostsliBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_postsli is invalid. Received: " + tag);
      }
      case  LAYOUT_ABPROFILECONTACTUS: {
        if ("layout/ab_profilecontactus_0".equals(tag)) {
          return new AbProfilecontactusBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_profilecontactus is invalid. Received: " + tag);
      }
      case  LAYOUT_ABPROFILLEVIEW: {
        if ("layout/ab_profilleview_0".equals(tag)) {
          return new AbProfilleviewBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_profilleview is invalid. Received: " + tag);
      }
      case  LAYOUT_ABRECOGNIZATIONLAY: {
        if ("layout/ab_recognizationlay_0".equals(tag)) {
          return new AbRecognizationlayBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_recognizationlay is invalid. Received: " + tag);
      }
      case  LAYOUT_ABRECOMMENDEDBYL: {
        if ("layout/ab_recommendedbyl_0".equals(tag)) {
          return new AbRecommendedbylBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_recommendedbyl is invalid. Received: " + tag);
      }
      case  LAYOUT_ABREQUIREMENTS: {
        if ("layout/ab_requirements_0".equals(tag)) {
          return new AbRequirementsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_requirements is invalid. Received: " + tag);
      }
      case  LAYOUT_ABSENTCONNECTION: {
        if ("layout/ab_sent_connection_0".equals(tag)) {
          return new AbSentConnectionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_sent_connection is invalid. Received: " + tag);
      }
      case  LAYOUT_ABTESTIMONIALS: {
        if ("layout/ab_testimonials_0".equals(tag)) {
          return new AbTestimonialsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_testimonials is invalid. Received: " + tag);
      }
      case  LAYOUT_ABTOPRACKINGST: {
        if ("layout/ab_toprackingst_0".equals(tag)) {
          return new AbToprackingstBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_toprackingst is invalid. Received: " + tag);
      }
      case  LAYOUT_ABUPGRADEPOPUPLI: {
        if ("layout/ab_upgradepopupli_0".equals(tag)) {
          return new AbUpgradepopupliBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_upgradepopupli is invalid. Received: " + tag);
      }
      case  LAYOUT_ABWELCOME: {
        if ("layout/ab_welcome_0".equals(tag)) {
          return new AbWelcomeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for ab_welcome is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYABOUTUS: {
        if ("layout/activity_about_us_0".equals(tag)) {
          return new ActivityAboutUsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_about_us is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYALLEVENTS: {
        if ("layout/activity_all_events_0".equals(tag)) {
          return new ActivityAllEventsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_all_events is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYALLMEMBERS: {
        if ("layout/activity_all_members_0".equals(tag)) {
          return new ActivityAllMembersBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_all_members is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYBUSINESSCARD: {
        if ("layout/activity_business_card_0".equals(tag)) {
          return new ActivityBusinessCardBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_business_card is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCREATEBUDDYMEET: {
        if ("layout/activity_create_buddy_meet_0".equals(tag)) {
          return new ActivityCreateBuddyMeetBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_create_buddy_meet is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCREATEEVENTS: {
        if ("layout/activity_create_events_0".equals(tag)) {
          return new ActivityCreateEventsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_create_events is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCREATEFOLLOWUP: {
        if ("layout/activity_create_follow_up_0".equals(tag)) {
          return new ActivityCreateFollowUpBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_create_follow_up is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCREATEGUESTINVITE: {
        if ("layout/activity_create_guestinvite_0".equals(tag)) {
          return new ActivityCreateGuestinviteBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_create_guestinvite is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCREATEOFFLINEBUSINESS: {
        if ("layout/activity_create_offline_business_0".equals(tag)) {
          return new ActivityCreateOfflineBusinessBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_create_offline_business is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCREATEPOSTS: {
        if ("layout/activity_create_posts_0".equals(tag)) {
          return new ActivityCreatePostsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_create_posts is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCREATEREFERRAL: {
        if ("layout/activity_create_referral_0".equals(tag)) {
          return new ActivityCreateReferralBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_create_referral is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCREATEREQUIREMENT: {
        if ("layout/activity_create_requirement_0".equals(tag)) {
          return new ActivityCreateRequirementBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_create_requirement is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYEVENTBOOKING: {
        if ("layout/activity_event_booking_0".equals(tag)) {
          return new ActivityEventBookingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_event_booking is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYEVENTJOINER: {
        if ("layout/activity_event_joiner_0".equals(tag)) {
          return new ActivityEventJoinerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_event_joiner is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYEVENTSTATUS: {
        if ("layout/activity_event_status_0".equals(tag)) {
          return new ActivityEventStatusBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_event_status is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYFEEDBACK: {
        if ("layout/activity_feedback_0".equals(tag)) {
          return new ActivityFeedbackBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_feedback is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYFEEDBACKEVENT: {
        if ("layout/activity_feedback_event_0".equals(tag)) {
          return new ActivityFeedbackEventBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_feedback_event is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYJ4EMEMBERS: {
        if ("layout/activity_j4e_members_0".equals(tag)) {
          return new ActivityJ4eMembersBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_j4e_members is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYLOGIN: {
        if ("layout/activity_login_0".equals(tag)) {
          return new ActivityLoginBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMAINJ4E: {
        if ("layout/activity_main_j4e_0".equals(tag)) {
          return new ActivityMainJ4eBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_main_j4e is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMAPSEVENTS: {
        if ("layout/activity_maps_events_0".equals(tag)) {
          return new ActivityMapsEventsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_maps_events is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMEMBERSHIPADD: {
        if ("layout/activity_membership_add_0".equals(tag)) {
          return new ActivityMembershipAddBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_membership_add is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYAWARDRECOGNITION: {
        if ("layout/activity_my_award_recognition_0".equals(tag)) {
          return new ActivityMyAwardRecognitionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_award_recognition is invalid. Received: " + tag);
      }
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ACTIVITYMYAWARDTOPRANK: {
        if ("layout/activity_my_award_toprank_0".equals(tag)) {
          return new ActivityMyAwardToprankBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_award_toprank is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYBUDDIES: {
        if ("layout/activity_my_buddies_0".equals(tag)) {
          return new ActivityMyBuddiesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_buddies is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYBUSINESSTRANSACTIONS: {
        if ("layout/activity_my_business_transactions_0".equals(tag)) {
          return new ActivityMyBusinessTransactionsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_business_transactions is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYCONNECTIONS: {
        if ("layout/activity_my_connections_0".equals(tag)) {
          return new ActivityMyConnectionsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_connections is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYEVENTS: {
        if ("layout/activity_my_events_0".equals(tag)) {
          return new ActivityMyEventsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_events is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYEVENTSDETAIL: {
        if ("layout/activity_my_events_detail_0".equals(tag)) {
          return new ActivityMyEventsDetailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_events_detail is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYGROUP: {
        if ("layout/activity_my_group_0".equals(tag)) {
          return new ActivityMyGroupBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_group is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYLEADSDETAIL: {
        if ("layout/activity_my_leads_detail_0".equals(tag)) {
          return new ActivityMyLeadsDetailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_leads_detail is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYLEADSSTATUSADD: {
        if ("layout/activity_my_leads_status_add_0".equals(tag)) {
          return new ActivityMyLeadsStatusAddBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_leads_status_add is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYLEADSSTATUSLIST: {
        if ("layout/activity_my_leads_status_list_0".equals(tag)) {
          return new ActivityMyLeadsStatusListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_leads_status_list is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYMEMBERSHIPBENEFITS: {
        if ("layout/activity_my_membership_benefits_0".equals(tag)) {
          return new ActivityMyMembershipBenefitsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_membership_benefits is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYPOSTS: {
        if ("layout/activity_my_posts_0".equals(tag)) {
          return new ActivityMyPostsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_posts is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYRECOGNITION: {
        if ("layout/activity_my_recognition_0".equals(tag)) {
          return new ActivityMyRecognitionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_recognition is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYRECOGNITIONADD: {
        if ("layout/activity_my_recognition_add_0".equals(tag)) {
          return new ActivityMyRecognitionAddBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_recognition_add is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYREPORTCARD: {
        if ("layout/activity_my_report_card_0".equals(tag)) {
          return new ActivityMyReportCardBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_report_card is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYREQUIREMENTS: {
        if ("layout/activity_my_requirements_0".equals(tag)) {
          return new ActivityMyRequirementsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_requirements is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYTESTIMONIALS: {
        if ("layout/activity_my_testimonials_0".equals(tag)) {
          return new ActivityMyTestimonialsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_my_testimonials is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYMYGUESTINVITES: {
        if ("layout/activity_myguestinvites_0".equals(tag)) {
          return new ActivityMyguestinvitesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_myguestinvites is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYNEWMYMEMBERSHIPDETAILS: {
        if ("layout/activity_new_my_membership_details_0".equals(tag)) {
          return new ActivityNewMyMembershipDetailsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_new_my_membership_details is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYNOTIFICATION: {
        if ("layout/activity_notification_0".equals(tag)) {
          return new ActivityNotificationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_notification is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYOFFLINETRANSACTIONDETAILS: {
        if ("layout/activity_offlinetransactiondetails_0".equals(tag)) {
          return new ActivityOfflinetransactiondetailsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_offlinetransactiondetails is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYOTPVERIFICATION: {
        if ("layout/activity_otp_verification_0".equals(tag)) {
          return new ActivityOtpVerificationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_otp_verification is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPRIVACYANDPOLICY: {
        if ("layout/activity_privacy_and_policy_0".equals(tag)) {
          return new ActivityPrivacyAndPolicyBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_privacy_and_policy is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPROFILE: {
        if ("layout/activity_profile_0".equals(tag)) {
          return new ActivityProfileBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_profile is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPROFILEABOUTUSEDIT: {
        if ("layout/activity_profile_about_us_edit_0".equals(tag)) {
          return new ActivityProfileAboutUsEditBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_profile_about_us_edit is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPROFILECONTACTUSEDIT: {
        if ("layout/activity_profile_contact_us_edit_0".equals(tag)) {
          return new ActivityProfileContactUsEditBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_profile_contact_us_edit is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYRECOMMENDED: {
        if ("layout/activity_recommended_0".equals(tag)) {
          return new ActivityRecommendedBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_recommended is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYRECOMMENDEDLEAD: {
        if ("layout/activity_recommended_lead_0".equals(tag)) {
          return new ActivityRecommendedLeadBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_recommended_lead is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYREFERRALGIVEN: {
        if ("layout/activity_referral_given_0".equals(tag)) {
          return new ActivityReferralGivenBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_referral_given is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYREFERRALRECEIVED: {
        if ("layout/activity_referral_received_0".equals(tag)) {
          return new ActivityReferralReceivedBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_referral_received is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYREVIEWPROFILE: {
        if ("layout/activity_reviewprofile_0".equals(tag)) {
          return new ActivityReviewprofileBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_reviewprofile is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSEARCHHOME: {
        if ("layout/activity_search_home_0".equals(tag)) {
          return new ActivitySearchHomeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_search_home is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSETTING: {
        if ("layout/activity_setting_0".equals(tag)) {
          return new ActivitySettingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_setting is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSPLASHJ4E: {
        if ("layout/activity_splash_j4e_0".equals(tag)) {
          return new ActivitySplashJ4eBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_splash_j4e is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSUBSCRIBEPLAN: {
        if ("layout/activity_subscribe_plan_0".equals(tag)) {
          return new ActivitySubscribePlanBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_subscribe_plan is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYTERMSANDCONDITION: {
        if ("layout/activity_terms_and_condition_0".equals(tag)) {
          return new ActivityTermsAndConditionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_terms_and_condition is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYWELCOME: {
        if ("layout/activity_welcome_0".equals(tag)) {
          return new ActivityWelcomeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_welcome is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERALLBUDDIES: {
        if ("layout/adapter_all_buddies_0".equals(tag)) {
          return new AdapterAllBuddiesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_all_buddies is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERALLLEAD: {
        if ("layout/adapter_all_lead_0".equals(tag)) {
          return new AdapterAllLeadBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_all_lead is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERALLPOSTS: {
        if ("layout/adapter_all_posts_0".equals(tag)) {
          return new AdapterAllPostsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_all_posts is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERAPPLICATIONS: {
        if ("layout/adapter_applications_0".equals(tag)) {
          return new AdapterApplicationsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_applications is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERAWARDRECOGNITION: {
        if ("layout/adapter_award_recognition_0".equals(tag)) {
          return new AdapterAwardRecognitionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_award_recognition is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERBUDDYMONTH: {
        if ("layout/adapter_buddymonth_0".equals(tag)) {
          return new AdapterBuddymonthBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_buddymonth is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERBUSINESSTRANSACTIONS: {
        if ("layout/adapter_business_transactions_0".equals(tag)) {
          return new AdapterBusinessTransactionsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_business_transactions is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERCATEGORYPOST: {
        if ("layout/adapter_categorypost_0".equals(tag)) {
          return new AdapterCategorypostBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_categorypost is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERCHATGROUPADAPTER: {
        if ("layout/adapter_chat_group_adapter_0".equals(tag)) {
          return new AdapterChatGroupAdapterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_chat_group_adapter is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERCHATINDIVIDUAL: {
        if ("layout/adapter_chat_individual_0".equals(tag)) {
          return new AdapterChatIndividualBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_chat_individual is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERCOMMENTLIST: {
        if ("layout/adapter_comment_list_0".equals(tag)) {
          return new AdapterCommentListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_comment_list is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERCOMPLETEDMYLEAD: {
        if ("layout/adapter_completed_mylead_0".equals(tag)) {
          return new AdapterCompletedMyleadBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_completed_mylead is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERCOMPLETEDREQUIREMENT: {
        if ("layout/adapter_completed_requirement_0".equals(tag)) {
          return new AdapterCompletedRequirementBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_completed_requirement is invalid. Received: " + tag);
      }
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding2(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ADAPTEREVENTSGALLERY: {
        if ("layout/adapter_events_gallery_0".equals(tag)) {
          return new AdapterEventsGalleryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_events_gallery is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERGALLERY: {
        if ("layout/adapter_gallery_0".equals(tag)) {
          return new AdapterGalleryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_gallery is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERGALLERYEVENTSLI: {
        if ("layout/adapter_gallery_eventsli_0".equals(tag)) {
          return new AdapterGalleryEventsliBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_gallery_eventsli is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERJ4EMEMBER: {
        if ("layout/adapter_j4e_member_0".equals(tag)) {
          return new AdapterJ4eMemberBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_j4e_member is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERLEADSTATUSCATEGORY: {
        if ("layout/adapter_lead_status_category_0".equals(tag)) {
          return new AdapterLeadStatusCategoryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_lead_status_category is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERMYGROUP: {
        if ("layout/adapter_my_group_0".equals(tag)) {
          return new AdapterMyGroupBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_my_group is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERMYRECOGNITION: {
        if ("layout/adapter_my_recognition_0".equals(tag)) {
          return new AdapterMyRecognitionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_my_recognition is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERMYREPORTCARD: {
        if ("layout/adapter_my_report_card_0".equals(tag)) {
          return new AdapterMyReportCardBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_my_report_card is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERMYSUBREPORTCARD: {
        if ("layout/adapter_my_sub_report_card_0".equals(tag)) {
          return new AdapterMySubReportCardBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_my_sub_report_card is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERMYTESTIMONIALS: {
        if ("layout/adapter_my_testimonials_0".equals(tag)) {
          return new AdapterMyTestimonialsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_my_testimonials is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERMYGUESTINVITES: {
        if ("layout/adapter_myguestinvites_0".equals(tag)) {
          return new AdapterMyguestinvitesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_myguestinvites is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERMYLEADSTATUSLIST: {
        if ("layout/adapter_myleadstatuslist_0".equals(tag)) {
          return new AdapterMyleadstatuslistBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_myleadstatuslist is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERMYTESTIMONIALSACT: {
        if ("layout/adapter_mytestimonialsact_0".equals(tag)) {
          return new AdapterMytestimonialsactBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_mytestimonialsact is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERPASTEVENTS: {
        if ("layout/adapter_past_events_0".equals(tag)) {
          return new AdapterPastEventsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_past_events is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERPENDINGREQUIREMENT: {
        if ("layout/adapter_pending_requirement_0".equals(tag)) {
          return new AdapterPendingRequirementBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_pending_requirement is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERPSBUDDYMEET: {
        if ("layout/adapter_ps_buddy_meet_0".equals(tag)) {
          return new AdapterPsBuddyMeetBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_ps_buddy_meet is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERPSLEADS: {
        if ("layout/adapter_ps_leads_0".equals(tag)) {
          return new AdapterPsLeadsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_ps_leads is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERRECEIVEDCONNECTION: {
        if ("layout/adapter_received_connection_0".equals(tag)) {
          return new AdapterReceivedConnectionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_received_connection is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERRECOMMANDEXITINGLIST: {
        if ("layout/adapter_recommandexitinglist_0".equals(tag)) {
          return new AdapterRecommandexitinglistBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_recommandexitinglist is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERRECOMMENDPERSON: {
        if ("layout/adapter_recommend_person_0".equals(tag)) {
          return new AdapterRecommendPersonBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_recommend_person is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERRECOMMENDPERSONOTHER: {
        if ("layout/adapter_recommend_person_other_0".equals(tag)) {
          return new AdapterRecommendPersonOtherBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_recommend_person_other is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERRECOMMENDEDBY: {
        if ("layout/adapter_recommended_by_0".equals(tag)) {
          return new AdapterRecommendedByBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_recommended_by is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERREFFRALSTATUSDETAILS: {
        if ("layout/adapter_reffralstatusdetails_0".equals(tag)) {
          return new AdapterReffralstatusdetailsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_reffralstatusdetails is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERREWARDLIST: {
        if ("layout/adapter_reward_list_0".equals(tag)) {
          return new AdapterRewardListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_reward_list is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERSEARCHDATA: {
        if ("layout/adapter_searchdata_0".equals(tag)) {
          return new AdapterSearchdataBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_searchdata is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERSEARCHDATATYPE: {
        if ("layout/adapter_searchdatatype_0".equals(tag)) {
          return new AdapterSearchdatatypeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_searchdatatype is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERSENTCONNECTION: {
        if ("layout/adapter_sent_connection_0".equals(tag)) {
          return new AdapterSentConnectionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_sent_connection is invalid. Received: " + tag);
      }
      case  LAYOUT_ADAPTERUPCOMINGEVENTS: {
        if ("layout/adapter_upcoming_events_0".equals(tag)) {
          return new AdapterUpcomingEventsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for adapter_upcoming_events is invalid. Received: " + tag);
      }
      case  LAYOUT_ADDGALLRYDIALOG: {
        if ("layout/add_gallry_dialog_0".equals(tag)) {
          return new AddGallryDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for add_gallry_dialog is invalid. Received: " + tag);
      }
      case  LAYOUT_BMCREATE: {
        if ("layout/bm_create_0".equals(tag)) {
          return new BmCreateBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for bm_create is invalid. Received: " + tag);
      }
      case  LAYOUT_BSALLEVENTSFILTER: {
        if ("layout/bs_all_events_filter_0".equals(tag)) {
          return new BsAllEventsFilterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for bs_all_events_filter is invalid. Received: " + tag);
      }
      case  LAYOUT_BSCHATBUDDYLIST: {
        if ("layout/bs_chatbuddylist_0".equals(tag)) {
          return new BsChatbuddylistBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for bs_chatbuddylist is invalid. Received: " + tag);
      }
      case  LAYOUT_BSCOMMENTLIST: {
        if ("layout/bs_comment_list_0".equals(tag)) {
          return new BsCommentListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for bs_comment_list is invalid. Received: " + tag);
      }
      case  LAYOUT_BSCONFIRMBOOKING: {
        if ("layout/bs_confirm_booking_0".equals(tag)) {
          return new BsConfirmBookingBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for bs_confirm_booking is invalid. Received: " + tag);
      }
      case  LAYOUT_BSMEMBERFILTER: {
        if ("layout/bs_member_filter_0".equals(tag)) {
          return new BsMemberFilterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for bs_member_filter is invalid. Received: " + tag);
      }
      case  LAYOUT_BSRECOMMENDPERSONLIST: {
        if ("layout/bs_recommend_person_list_0".equals(tag)) {
          return new BsRecommendPersonListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for bs_recommend_person_list is invalid. Received: " + tag);
      }
      case  LAYOUT_BSREWARDLIST: {
        if ("layout/bs_reward_list_0".equals(tag)) {
          return new BsRewardListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for bs_reward_list is invalid. Received: " + tag);
      }
      case  LAYOUT_CAMERAGALLARYBOTTOMSHEET: {
        if ("layout/camera_gallary_bottomsheet_0".equals(tag)) {
          return new CameraGallaryBottomsheetBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for camera_gallary_bottomsheet is invalid. Received: " + tag);
      }
      case  LAYOUT_CHECKBOXPLAN: {
        if ("layout/check_box_plan_0".equals(tag)) {
          return new CheckBoxPlanBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for check_box_plan is invalid. Received: " + tag);
      }
      case  LAYOUT_CHECKBOXADAPTER: {
        if ("layout/checkbox_adapter_0".equals(tag)) {
          return new CheckboxAdapterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for checkbox_adapter is invalid. Received: " + tag);
      }
      case  LAYOUT_DEACTIVATEDDIALOG: {
        if ("layout/deactivated_dialog_0".equals(tag)) {
          return new DeactivatedDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for deactivated_dialog is invalid. Received: " + tag);
      }
      case  LAYOUT_DELETEDIALOG: {
        if ("layout/delete_dialog_0".equals(tag)) {
          return new DeleteDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for delete_dialog is invalid. Received: " + tag);
      }
      case  LAYOUT_DELETEDIALOGPDF: {
        if ("layout/delete_dialog_pdf_0".equals(tag)) {
          return new DeleteDialogPdfBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for delete_dialog_pdf is invalid. Received: " + tag);
      }
      case  LAYOUT_DELETEDIALOGPPT: {
        if ("layout/delete_dialog_ppt_0".equals(tag)) {
          return new DeleteDialogPptBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for delete_dialog_ppt is invalid. Received: " + tag);
      }
      case  LAYOUT_DRAWERLAYOUT: {
        if ("layout/drawer_layout_0".equals(tag)) {
          return new DrawerLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for drawer_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_FEATURESMEMBERSADAPTER: {
        if ("layout/featuresmembers_adapter_0".equals(tag)) {
          return new FeaturesmembersAdapterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for featuresmembers_adapter is invalid. Received: " + tag);
      }
      case  LAYOUT_FILTERBOTTOMSHEET: {
        if ("layout/filter_bottom_sheet_0".equals(tag)) {
          return new FilterBottomSheetBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for filter_bottom_sheet is invalid. Received: " + tag);
      }
      case  LAYOUT_FILTERBUSINESSTRANSACTION: {
        if ("layout/filter_business_transaction_0".equals(tag)) {
          return new FilterBusinessTransactionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for filter_business_transaction is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGALLBUDDIES: {
        if ("layout/frag_all_buddies_0".equals(tag)) {
          return new FragAllBuddiesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for frag_all_buddies is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGALLLEADS: {
        if ("layout/frag_all_leads_0".equals(tag)) {
          return new FragAllLeadsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for frag_all_leads is invalid. Received: " + tag);
      }
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding3(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_FRAGALLPOSTS: {
        if ("layout/frag_all_posts_0".equals(tag)) {
          return new FragAllPostsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for frag_all_posts is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMYDIARY: {
        if ("layout/frag_my_diary_0".equals(tag)) {
          return new FragMyDiaryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for frag_my_diary is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGPENDINGCONNECSENT: {
        if ("layout/frag_pending_connecsent_0".equals(tag)) {
          return new FragPendingConnecsentBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for frag_pending_connecsent is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGPENDINGCONNECTION: {
        if ("layout/frag_pending_connection_0".equals(tag)) {
          return new FragPendingConnectionBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for frag_pending_connection is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGPENDINGEVENTS: {
        if ("layout/frag_pending_events_0".equals(tag)) {
          return new FragPendingEventsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for frag_pending_events is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGPENDINGMYLEADS: {
        if ("layout/frag_pending_myleads_0".equals(tag)) {
          return new FragPendingMyleadsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for frag_pending_myleads is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGPENDINGREQUIREMENT: {
        if ("layout/frag_pending_requirement_0".equals(tag)) {
          return new FragPendingRequirementBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for frag_pending_requirement is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGPRBUDDYMEET: {
        if ("layout/frag_pr_buddy_meet_0".equals(tag)) {
          return new FragPrBuddyMeetBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for frag_pr_buddy_meet is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGPRFOLLOWUP: {
        if ("layout/frag_pr_followup_0".equals(tag)) {
          return new FragPrFollowupBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for frag_pr_followup is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGRECOMMENDEDBY: {
        if ("layout/frag_recommended_by_0".equals(tag)) {
          return new FragRecommendedByBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for frag_recommended_by is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGRECOMMENDEDTO: {
        if ("layout/frag_recommended_to_0".equals(tag)) {
          return new FragRecommendedToBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for frag_recommended_to is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTALLEVENT: {
        if ("layout/fragment_all_event_0".equals(tag)) {
          return new FragmentAllEventBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_all_event is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCOMPLETEDREFERRAL: {
        if ("layout/fragment_completed_referral_0".equals(tag)) {
          return new FragmentCompletedReferralBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_completed_referral is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCOMPLETEDREFERRALRECEIVED: {
        if ("layout/fragment_completed_referral_received_0".equals(tag)) {
          return new FragmentCompletedReferralReceivedBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_completed_referral_received is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTFRAGJ4EMEMBERS: {
        if ("layout/fragment_frag_j4_e_members_0".equals(tag)) {
          return new FragmentFragJ4EMembersBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_frag_j4_e_members is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTGROUP: {
        if ("layout/fragment_group_0".equals(tag)) {
          return new FragmentGroupBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_group is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTINDIVIDUAL: {
        if ("layout/fragment_individual_0".equals(tag)) {
          return new FragmentIndividualBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_individual is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPENDINGREFERRAL: {
        if ("layout/fragment_pending_referral_0".equals(tag)) {
          return new FragmentPendingReferralBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_pending_referral is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTPENDINGREFERRALRECEIVED: {
        if ("layout/fragment_pending_referral_received_0".equals(tag)) {
          return new FragmentPendingReferralReceivedBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_pending_referral_received is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTUPCOMINGEVENT: {
        if ("layout/fragment_upcoming_event_0".equals(tag)) {
          return new FragmentUpcomingEventBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_upcoming_event is invalid. Received: " + tag);
      }
      case  LAYOUT_FULLIMAGEDIALOG: {
        if ("layout/full_image_dialog_0".equals(tag)) {
          return new FullImageDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for full_image_dialog is invalid. Received: " + tag);
      }
      case  LAYOUT_GALLARYACTIVITYVIEW: {
        if ("layout/gallary_activityview_0".equals(tag)) {
          return new GallaryActivityviewBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for gallary_activityview is invalid. Received: " + tag);
      }
      case  LAYOUT_GALLARYACTIVITYZOOM: {
        if ("layout/gallary_activityzoom_0".equals(tag)) {
          return new GallaryActivityzoomBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for gallary_activityzoom is invalid. Received: " + tag);
      }
      case  LAYOUT_IMAGEDELETEDIALOG: {
        if ("layout/imagedelete_dialog_0".equals(tag)) {
          return new ImagedeleteDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for imagedelete_dialog is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMEVENTJOINER: {
        if ("layout/item_event_joiner_0".equals(tag)) {
          return new ItemEventJoinerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_event_joiner is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMEVENTSTATUS: {
        if ("layout/item_event_status_0".equals(tag)) {
          return new ItemEventStatusBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_event_status is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMEMBERSHIPFEATURE: {
        if ("layout/item_membership_feature_0".equals(tag)) {
          return new ItemMembershipFeatureBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_membership_feature is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMEMBERSHIPTITLE: {
        if ("layout/item_membership_title_0".equals(tag)) {
          return new ItemMembershipTitleBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_membership_title is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMMEMBERSHIPTITLETITLE: {
        if ("layout/item_membership_title_title_0".equals(tag)) {
          return new ItemMembershipTitleTitleBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_membership_title_title is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMNOTIFICATION: {
        if ("layout/item_notification_0".equals(tag)) {
          return new ItemNotificationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_notification is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPACKAGE: {
        if ("layout/item_package_0".equals(tag)) {
          return new ItemPackageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_package is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPOSTCATEGORY: {
        if ("layout/item_post_category_0".equals(tag)) {
          return new ItemPostCategoryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_post_category is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMREFERRAL: {
        if ("layout/item_referral_0".equals(tag)) {
          return new ItemReferralBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_referral is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMWELCOME: {
        if ("layout/item_welcome_0".equals(tag)) {
          return new ItemWelcomeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_welcome is invalid. Received: " + tag);
      }
      case  LAYOUT_LAVDEALSDISCOUNTS: {
        if ("layout/lav_deals_discounts_0".equals(tag)) {
          return new LavDealsDiscountsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for lav_deals_discounts is invalid. Received: " + tag);
      }
      case  LAYOUT_LAVMYDIARY: {
        if ("layout/lav_my_diary_0".equals(tag)) {
          return new LavMyDiaryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for lav_my_diary is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYBOTTOMBAR: {
        if ("layout/lay_bottom_bar_0".equals(tag)) {
          return new LayBottomBarBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for lay_bottom_bar is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYMYMEBERSHIPUPGRADEBOTTOMSHIT: {
        if ("layout/lay_mymebershipupgradebottomshit_0".equals(tag)) {
          return new LayMymebershipupgradebottomshitBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for lay_mymebershipupgradebottomshit is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYPALNFEATURESADAPTER: {
        if ("layout/lay_paln_features_adapter_0".equals(tag)) {
          return new LayPalnFeaturesAdapterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for lay_paln_features_adapter is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYPLANUPGRADEADAPTER: {
        if ("layout/lay_plan_upgradeadapter_0".equals(tag)) {
          return new LayPlanUpgradeadapterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for lay_plan_upgradeadapter is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYPROFILEABOUTUS: {
        if ("layout/lay_profile_about_us_0".equals(tag)) {
          return new LayProfileAboutUsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for lay_profile_about_us is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYPROFILECONTACTUS: {
        if ("layout/lay_profile_contact_us_0".equals(tag)) {
          return new LayProfileContactUsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for lay_profile_contact_us is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYPROFILEGALLERY: {
        if ("layout/lay_profile_gallery_0".equals(tag)) {
          return new LayProfileGalleryBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for lay_profile_gallery is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYPROFILEREVIEWS: {
        if ("layout/lay_profile_reviews_0".equals(tag)) {
          return new LayProfileReviewsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for lay_profile_reviews is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYTOOLBAR: {
        if ("layout/lay_toolbar_0".equals(tag)) {
          return new LayToolbarBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for lay_toolbar is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYTOOLBARAWARD: {
        if ("layout/lay_toolbar_award_0".equals(tag)) {
          return new LayToolbarAwardBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for lay_toolbar_award is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYTOOLBAREDIT: {
        if ("layout/lay_toolbar_edit_0".equals(tag)) {
          return new LayToolbarEditBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for lay_toolbar_edit is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYTOOLBAREDITBTN: {
        if ("layout/lay_toolbar_editbtn_0".equals(tag)) {
          return new LayToolbarEditbtnBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for lay_toolbar_editbtn is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYTOOLBAREVENTS: {
        if ("layout/lay_toolbar_events_0".equals(tag)) {
          return new LayToolbarEventsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for lay_toolbar_events is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYTOOLBARHOME: {
        if ("layout/lay_toolbar_home_0".equals(tag)) {
          return new LayToolbarHomeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for lay_toolbar_home is invalid. Received: " + tag);
      }
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding4(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_LAYTOOLBARLEADSTATUSADD: {
        if ("layout/lay_toolbar_lead_status_add_0".equals(tag)) {
          return new LayToolbarLeadStatusAddBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for lay_toolbar_lead_status_add is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYTOOLBARLEADSTATUSPUBLISH: {
        if ("layout/lay_toolbar_lead_status_publish_0".equals(tag)) {
          return new LayToolbarLeadStatusPublishBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for lay_toolbar_lead_status_publish is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYTOOLBARMYLEADS: {
        if ("layout/lay_toolbar_my_leads_0".equals(tag)) {
          return new LayToolbarMyLeadsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for lay_toolbar_my_leads is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYTOOLBARMYGUESTINVITES: {
        if ("layout/lay_toolbar_myguestinvites_0".equals(tag)) {
          return new LayToolbarMyguestinvitesBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for lay_toolbar_myguestinvites is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYOUTMEMBERSHIPADDEDIT: {
        if ("layout/layout_membership_addedit_0".equals(tag)) {
          return new LayoutMembershipAddeditBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for layout_membership_addedit is invalid. Received: " + tag);
      }
      case  LAYOUT_LAYOUTTANDCBOTTOMSHEET: {
        if ("layout/layout_tandc_bottomsheet_0".equals(tag)) {
          return new LayoutTandcBottomsheetBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for layout_tandc_bottomsheet is invalid. Received: " + tag);
      }
      case  LAYOUT_MAINEXITDIALOG: {
        if ("layout/mainexit_dialog_0".equals(tag)) {
          return new MainexitDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for mainexit_dialog is invalid. Received: " + tag);
      }
      case  LAYOUT_NEWUPDATEDIALOG: {
        if ("layout/new_update_dialog_0".equals(tag)) {
          return new NewUpdateDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for new_update_dialog is invalid. Received: " + tag);
      }
      case  LAYOUT_OFFLINETRANSACTIONDETAILSADAPTER: {
        if ("layout/offline_transaction_details_adapter_0".equals(tag)) {
          return new OfflineTransactionDetailsAdapterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for offline_transaction_details_adapter is invalid. Received: " + tag);
      }
      case  LAYOUT_PAYMENTFAILDBOTTOMSHEET: {
        if ("layout/payment_faild_bottomsheet_0".equals(tag)) {
          return new PaymentFaildBottomsheetBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for payment_faild_bottomsheet is invalid. Received: " + tag);
      }
      case  LAYOUT_PLANEXPAIREDDIALOG: {
        if ("layout/planexpaireddialog_0".equals(tag)) {
          return new PlanexpaireddialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for planexpaireddialog is invalid. Received: " + tag);
      }
      case  LAYOUT_PLANNINGEVENTSDIALOG: {
        if ("layout/planning_events_dialog_0".equals(tag)) {
          return new PlanningEventsDialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for planning_events_dialog is invalid. Received: " + tag);
      }
      case  LAYOUT_POSTINFO: {
        if ("layout/post_info_0".equals(tag)) {
          return new PostInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for post_info is invalid. Received: " + tag);
      }
      case  LAYOUT_RECOMMANDEXITLISTPEOPLE: {
        if ("layout/recommand_exit_listpeople_0".equals(tag)) {
          return new RecommandExitListpeopleBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for recommand_exit_listpeople is invalid. Received: " + tag);
      }
      case  LAYOUT_RECOMMDATIONNOTEBM: {
        if ("layout/recommdation_note_bm_0".equals(tag)) {
          return new RecommdationNoteBmBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for recommdation_note_bm is invalid. Received: " + tag);
      }
      case  LAYOUT_RECOMMENDATIONPEOPLEBOTTOMSHEET: {
        if ("layout/recommendationpeople_bottomsheet_0".equals(tag)) {
          return new RecommendationpeopleBottomsheetBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for recommendationpeople_bottomsheet is invalid. Received: " + tag);
      }
      case  LAYOUT_RECOMMENDEDPERSONRVADAPTER: {
        if ("layout/recommended_person_rv_adapter_0".equals(tag)) {
          return new RecommendedPersonRvAdapterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for recommended_person_rv_adapter is invalid. Received: " + tag);
      }
      case  LAYOUT_REFFRALCHECKBOXADAPTER: {
        if ("layout/reffralcheckbox_adapter_0".equals(tag)) {
          return new ReffralcheckboxAdapterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for reffralcheckbox_adapter is invalid. Received: " + tag);
      }
      case  LAYOUT_RENEWBOTTOMSHEET: {
        if ("layout/renew_bottomsheet_0".equals(tag)) {
          return new RenewBottomsheetBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for renew_bottomsheet is invalid. Received: " + tag);
      }
      case  LAYOUT_REVIEWALLPOPUP: {
        if ("layout/reviewall_popup_0".equals(tag)) {
          return new ReviewallPopupBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for reviewall_popup is invalid. Received: " + tag);
      }
      case  LAYOUT_SORTBOTTOMSHEET: {
        if ("layout/sort_bottom_sheet_0".equals(tag)) {
          return new SortBottomSheetBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for sort_bottom_sheet is invalid. Received: " + tag);
      }
      case  LAYOUT_SPLASHPERMISSIONDIALOG: {
        if ("layout/splash_permissiondialog_0".equals(tag)) {
          return new SplashPermissiondialogBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for splash_permissiondialog is invalid. Received: " + tag);
      }
      case  LAYOUT_THANKYOUBOTTOMSHEET: {
        if ("layout/thank_you_bottom_sheet_0".equals(tag)) {
          return new ThankYouBottomSheetBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for thank_you_bottom_sheet is invalid. Received: " + tag);
      }
      case  LAYOUT_TOOLBARSEARCH: {
        if ("layout/toolbar_search_0".equals(tag)) {
          return new ToolbarSearchBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for toolbar_search is invalid. Received: " + tag);
      }
      case  LAYOUT_TOOLBARSIMPLE: {
        if ("layout/toolbar_simple_0".equals(tag)) {
          return new ToolbarSimpleBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for toolbar_simple is invalid. Received: " + tag);
      }
      case  LAYOUT_TOOLBARSINGLEIMAGE: {
        if ("layout/toolbar_single_image_0".equals(tag)) {
          return new ToolbarSingleImageBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for toolbar_single_image is invalid. Received: " + tag);
      }
      case  LAYOUT_UPDATEBACKGROUND: {
        if ("layout/update_background_0".equals(tag)) {
          return new UpdateBackgroundBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for update_background is invalid. Received: " + tag);
      }
      case  LAYOUT_VIEWPAGERPROFILEADAPTER: {
        if ("layout/viewpager_profile_adapter_0".equals(tag)) {
          return new ViewpagerProfileAdapterBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for viewpager_profile_adapter is invalid. Received: " + tag);
      }
      case  LAYOUT_WELCOMESLIDEA: {
        if ("layout/welcome_slide_a_0".equals(tag)) {
          return new WelcomeSlideABindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for welcome_slide_a is invalid. Received: " + tag);
      }
      case  LAYOUT_WELCOMESLIDEB: {
        if ("layout/welcome_slide_b_0".equals(tag)) {
          return new WelcomeSlideBBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for welcome_slide_b is invalid. Received: " + tag);
      }
      case  LAYOUT_WELCOMESLIDEC: {
        if ("layout/welcome_slide_c_0".equals(tag)) {
          return new WelcomeSlideCBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for welcome_slide_c is invalid. Received: " + tag);
      }
      case  LAYOUT_WELCOMESLIDED: {
        if ("layout/welcome_slide_d_0".equals(tag)) {
          return new WelcomeSlideDBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for welcome_slide_d is invalid. Received: " + tag);
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      // find which method will have it. -1 is necessary becausefirst id starts with 1;
      int methodIndex = (localizedLayoutId - 1) / 50;
      switch(methodIndex) {
        case 0: {
          return internalGetViewDataBinding0(component, view, localizedLayoutId, tag);
        }
        case 1: {
          return internalGetViewDataBinding1(component, view, localizedLayoutId, tag);
        }
        case 2: {
          return internalGetViewDataBinding2(component, view, localizedLayoutId, tag);
        }
        case 3: {
          return internalGetViewDataBinding3(component, view, localizedLayoutId, tag);
        }
        case 4: {
          return internalGetViewDataBinding4(component, view, localizedLayoutId, tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(3);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "item");
      sKeys.put(2, "viewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(232);

    static {
      sKeys.put("layout/ab_aboutus_0", com.justforentrepreneurs.j4eapp.R.layout.ab_aboutus);
      sKeys.put("layout/ab_awardrecognition_0", com.justforentrepreneurs.j4eapp.R.layout.ab_awardrecognition);
      sKeys.put("layout/ab_buddieslayout_0", com.justforentrepreneurs.j4eapp.R.layout.ab_buddieslayout);
      sKeys.put("layout/ab_commentsli_0", com.justforentrepreneurs.j4eapp.R.layout.ab_commentsli);
      sKeys.put("layout/ab_connectionli_0", com.justforentrepreneurs.j4eapp.R.layout.ab_connectionli);
      sKeys.put("layout/ab_event_booking_0", com.justforentrepreneurs.j4eapp.R.layout.ab_event_booking);
      sKeys.put("layout/ab_eventdetails_0", com.justforentrepreneurs.j4eapp.R.layout.ab_eventdetails);
      sKeys.put("layout/ab_eventslayout_0", com.justforentrepreneurs.j4eapp.R.layout.ab_eventslayout);
      sKeys.put("layout/ab_followupli_0", com.justforentrepreneurs.j4eapp.R.layout.ab_followupli);
      sKeys.put("layout/ab_guestinvitesli_0", com.justforentrepreneurs.j4eapp.R.layout.ab_guestinvitesli);
      sKeys.put("layout/ab_j4emembers_0", com.justforentrepreneurs.j4eapp.R.layout.ab_j4emembers);
      sKeys.put("layout/ab_leadsdeatils_0", com.justforentrepreneurs.j4eapp.R.layout.ab_leadsdeatils);
      sKeys.put("layout/ab_leadsli_0", com.justforentrepreneurs.j4eapp.R.layout.ab_leadsli);
      sKeys.put("layout/ab_leadsstatuslist_0", com.justforentrepreneurs.j4eapp.R.layout.ab_leadsstatuslist);
      sKeys.put("layout/ab_memberfilters_0", com.justforentrepreneurs.j4eapp.R.layout.ab_memberfilters);
      sKeys.put("layout/ab_membershipbenefit_0", com.justforentrepreneurs.j4eapp.R.layout.ab_membershipbenefit);
      sKeys.put("layout/ab_postsli_0", com.justforentrepreneurs.j4eapp.R.layout.ab_postsli);
      sKeys.put("layout/ab_profilecontactus_0", com.justforentrepreneurs.j4eapp.R.layout.ab_profilecontactus);
      sKeys.put("layout/ab_profilleview_0", com.justforentrepreneurs.j4eapp.R.layout.ab_profilleview);
      sKeys.put("layout/ab_recognizationlay_0", com.justforentrepreneurs.j4eapp.R.layout.ab_recognizationlay);
      sKeys.put("layout/ab_recommendedbyl_0", com.justforentrepreneurs.j4eapp.R.layout.ab_recommendedbyl);
      sKeys.put("layout/ab_requirements_0", com.justforentrepreneurs.j4eapp.R.layout.ab_requirements);
      sKeys.put("layout/ab_sent_connection_0", com.justforentrepreneurs.j4eapp.R.layout.ab_sent_connection);
      sKeys.put("layout/ab_testimonials_0", com.justforentrepreneurs.j4eapp.R.layout.ab_testimonials);
      sKeys.put("layout/ab_toprackingst_0", com.justforentrepreneurs.j4eapp.R.layout.ab_toprackingst);
      sKeys.put("layout/ab_upgradepopupli_0", com.justforentrepreneurs.j4eapp.R.layout.ab_upgradepopupli);
      sKeys.put("layout/ab_welcome_0", com.justforentrepreneurs.j4eapp.R.layout.ab_welcome);
      sKeys.put("layout/activity_about_us_0", com.justforentrepreneurs.j4eapp.R.layout.activity_about_us);
      sKeys.put("layout/activity_all_events_0", com.justforentrepreneurs.j4eapp.R.layout.activity_all_events);
      sKeys.put("layout/activity_all_members_0", com.justforentrepreneurs.j4eapp.R.layout.activity_all_members);
      sKeys.put("layout/activity_business_card_0", com.justforentrepreneurs.j4eapp.R.layout.activity_business_card);
      sKeys.put("layout/activity_create_buddy_meet_0", com.justforentrepreneurs.j4eapp.R.layout.activity_create_buddy_meet);
      sKeys.put("layout/activity_create_events_0", com.justforentrepreneurs.j4eapp.R.layout.activity_create_events);
      sKeys.put("layout/activity_create_follow_up_0", com.justforentrepreneurs.j4eapp.R.layout.activity_create_follow_up);
      sKeys.put("layout/activity_create_guestinvite_0", com.justforentrepreneurs.j4eapp.R.layout.activity_create_guestinvite);
      sKeys.put("layout/activity_create_offline_business_0", com.justforentrepreneurs.j4eapp.R.layout.activity_create_offline_business);
      sKeys.put("layout/activity_create_posts_0", com.justforentrepreneurs.j4eapp.R.layout.activity_create_posts);
      sKeys.put("layout/activity_create_referral_0", com.justforentrepreneurs.j4eapp.R.layout.activity_create_referral);
      sKeys.put("layout/activity_create_requirement_0", com.justforentrepreneurs.j4eapp.R.layout.activity_create_requirement);
      sKeys.put("layout/activity_event_booking_0", com.justforentrepreneurs.j4eapp.R.layout.activity_event_booking);
      sKeys.put("layout/activity_event_joiner_0", com.justforentrepreneurs.j4eapp.R.layout.activity_event_joiner);
      sKeys.put("layout/activity_event_status_0", com.justforentrepreneurs.j4eapp.R.layout.activity_event_status);
      sKeys.put("layout/activity_feedback_0", com.justforentrepreneurs.j4eapp.R.layout.activity_feedback);
      sKeys.put("layout/activity_feedback_event_0", com.justforentrepreneurs.j4eapp.R.layout.activity_feedback_event);
      sKeys.put("layout/activity_j4e_members_0", com.justforentrepreneurs.j4eapp.R.layout.activity_j4e_members);
      sKeys.put("layout/activity_login_0", com.justforentrepreneurs.j4eapp.R.layout.activity_login);
      sKeys.put("layout/activity_main_j4e_0", com.justforentrepreneurs.j4eapp.R.layout.activity_main_j4e);
      sKeys.put("layout/activity_maps_events_0", com.justforentrepreneurs.j4eapp.R.layout.activity_maps_events);
      sKeys.put("layout/activity_membership_add_0", com.justforentrepreneurs.j4eapp.R.layout.activity_membership_add);
      sKeys.put("layout/activity_my_award_recognition_0", com.justforentrepreneurs.j4eapp.R.layout.activity_my_award_recognition);
      sKeys.put("layout/activity_my_award_toprank_0", com.justforentrepreneurs.j4eapp.R.layout.activity_my_award_toprank);
      sKeys.put("layout/activity_my_buddies_0", com.justforentrepreneurs.j4eapp.R.layout.activity_my_buddies);
      sKeys.put("layout/activity_my_business_transactions_0", com.justforentrepreneurs.j4eapp.R.layout.activity_my_business_transactions);
      sKeys.put("layout/activity_my_connections_0", com.justforentrepreneurs.j4eapp.R.layout.activity_my_connections);
      sKeys.put("layout/activity_my_events_0", com.justforentrepreneurs.j4eapp.R.layout.activity_my_events);
      sKeys.put("layout/activity_my_events_detail_0", com.justforentrepreneurs.j4eapp.R.layout.activity_my_events_detail);
      sKeys.put("layout/activity_my_group_0", com.justforentrepreneurs.j4eapp.R.layout.activity_my_group);
      sKeys.put("layout/activity_my_leads_detail_0", com.justforentrepreneurs.j4eapp.R.layout.activity_my_leads_detail);
      sKeys.put("layout/activity_my_leads_status_add_0", com.justforentrepreneurs.j4eapp.R.layout.activity_my_leads_status_add);
      sKeys.put("layout/activity_my_leads_status_list_0", com.justforentrepreneurs.j4eapp.R.layout.activity_my_leads_status_list);
      sKeys.put("layout/activity_my_membership_benefits_0", com.justforentrepreneurs.j4eapp.R.layout.activity_my_membership_benefits);
      sKeys.put("layout/activity_my_posts_0", com.justforentrepreneurs.j4eapp.R.layout.activity_my_posts);
      sKeys.put("layout/activity_my_recognition_0", com.justforentrepreneurs.j4eapp.R.layout.activity_my_recognition);
      sKeys.put("layout/activity_my_recognition_add_0", com.justforentrepreneurs.j4eapp.R.layout.activity_my_recognition_add);
      sKeys.put("layout/activity_my_report_card_0", com.justforentrepreneurs.j4eapp.R.layout.activity_my_report_card);
      sKeys.put("layout/activity_my_requirements_0", com.justforentrepreneurs.j4eapp.R.layout.activity_my_requirements);
      sKeys.put("layout/activity_my_testimonials_0", com.justforentrepreneurs.j4eapp.R.layout.activity_my_testimonials);
      sKeys.put("layout/activity_myguestinvites_0", com.justforentrepreneurs.j4eapp.R.layout.activity_myguestinvites);
      sKeys.put("layout/activity_new_my_membership_details_0", com.justforentrepreneurs.j4eapp.R.layout.activity_new_my_membership_details);
      sKeys.put("layout/activity_notification_0", com.justforentrepreneurs.j4eapp.R.layout.activity_notification);
      sKeys.put("layout/activity_offlinetransactiondetails_0", com.justforentrepreneurs.j4eapp.R.layout.activity_offlinetransactiondetails);
      sKeys.put("layout/activity_otp_verification_0", com.justforentrepreneurs.j4eapp.R.layout.activity_otp_verification);
      sKeys.put("layout/activity_privacy_and_policy_0", com.justforentrepreneurs.j4eapp.R.layout.activity_privacy_and_policy);
      sKeys.put("layout/activity_profile_0", com.justforentrepreneurs.j4eapp.R.layout.activity_profile);
      sKeys.put("layout/activity_profile_about_us_edit_0", com.justforentrepreneurs.j4eapp.R.layout.activity_profile_about_us_edit);
      sKeys.put("layout/activity_profile_contact_us_edit_0", com.justforentrepreneurs.j4eapp.R.layout.activity_profile_contact_us_edit);
      sKeys.put("layout/activity_recommended_0", com.justforentrepreneurs.j4eapp.R.layout.activity_recommended);
      sKeys.put("layout/activity_recommended_lead_0", com.justforentrepreneurs.j4eapp.R.layout.activity_recommended_lead);
      sKeys.put("layout/activity_referral_given_0", com.justforentrepreneurs.j4eapp.R.layout.activity_referral_given);
      sKeys.put("layout/activity_referral_received_0", com.justforentrepreneurs.j4eapp.R.layout.activity_referral_received);
      sKeys.put("layout/activity_reviewprofile_0", com.justforentrepreneurs.j4eapp.R.layout.activity_reviewprofile);
      sKeys.put("layout/activity_search_home_0", com.justforentrepreneurs.j4eapp.R.layout.activity_search_home);
      sKeys.put("layout/activity_setting_0", com.justforentrepreneurs.j4eapp.R.layout.activity_setting);
      sKeys.put("layout/activity_splash_j4e_0", com.justforentrepreneurs.j4eapp.R.layout.activity_splash_j4e);
      sKeys.put("layout/activity_subscribe_plan_0", com.justforentrepreneurs.j4eapp.R.layout.activity_subscribe_plan);
      sKeys.put("layout/activity_terms_and_condition_0", com.justforentrepreneurs.j4eapp.R.layout.activity_terms_and_condition);
      sKeys.put("layout/activity_welcome_0", com.justforentrepreneurs.j4eapp.R.layout.activity_welcome);
      sKeys.put("layout/adapter_all_buddies_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_all_buddies);
      sKeys.put("layout/adapter_all_lead_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_all_lead);
      sKeys.put("layout/adapter_all_posts_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_all_posts);
      sKeys.put("layout/adapter_applications_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_applications);
      sKeys.put("layout/adapter_award_recognition_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_award_recognition);
      sKeys.put("layout/adapter_buddymonth_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_buddymonth);
      sKeys.put("layout/adapter_business_transactions_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_business_transactions);
      sKeys.put("layout/adapter_categorypost_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_categorypost);
      sKeys.put("layout/adapter_chat_group_adapter_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_chat_group_adapter);
      sKeys.put("layout/adapter_chat_individual_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_chat_individual);
      sKeys.put("layout/adapter_comment_list_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_comment_list);
      sKeys.put("layout/adapter_completed_mylead_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_completed_mylead);
      sKeys.put("layout/adapter_completed_requirement_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_completed_requirement);
      sKeys.put("layout/adapter_events_gallery_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_events_gallery);
      sKeys.put("layout/adapter_gallery_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_gallery);
      sKeys.put("layout/adapter_gallery_eventsli_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_gallery_eventsli);
      sKeys.put("layout/adapter_j4e_member_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_j4e_member);
      sKeys.put("layout/adapter_lead_status_category_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_lead_status_category);
      sKeys.put("layout/adapter_my_group_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_my_group);
      sKeys.put("layout/adapter_my_recognition_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_my_recognition);
      sKeys.put("layout/adapter_my_report_card_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_my_report_card);
      sKeys.put("layout/adapter_my_sub_report_card_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_my_sub_report_card);
      sKeys.put("layout/adapter_my_testimonials_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_my_testimonials);
      sKeys.put("layout/adapter_myguestinvites_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_myguestinvites);
      sKeys.put("layout/adapter_myleadstatuslist_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_myleadstatuslist);
      sKeys.put("layout/adapter_mytestimonialsact_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_mytestimonialsact);
      sKeys.put("layout/adapter_past_events_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_past_events);
      sKeys.put("layout/adapter_pending_requirement_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_pending_requirement);
      sKeys.put("layout/adapter_ps_buddy_meet_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_ps_buddy_meet);
      sKeys.put("layout/adapter_ps_leads_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_ps_leads);
      sKeys.put("layout/adapter_received_connection_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_received_connection);
      sKeys.put("layout/adapter_recommandexitinglist_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_recommandexitinglist);
      sKeys.put("layout/adapter_recommend_person_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_recommend_person);
      sKeys.put("layout/adapter_recommend_person_other_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_recommend_person_other);
      sKeys.put("layout/adapter_recommended_by_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_recommended_by);
      sKeys.put("layout/adapter_reffralstatusdetails_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_reffralstatusdetails);
      sKeys.put("layout/adapter_reward_list_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_reward_list);
      sKeys.put("layout/adapter_searchdata_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_searchdata);
      sKeys.put("layout/adapter_searchdatatype_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_searchdatatype);
      sKeys.put("layout/adapter_sent_connection_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_sent_connection);
      sKeys.put("layout/adapter_upcoming_events_0", com.justforentrepreneurs.j4eapp.R.layout.adapter_upcoming_events);
      sKeys.put("layout/add_gallry_dialog_0", com.justforentrepreneurs.j4eapp.R.layout.add_gallry_dialog);
      sKeys.put("layout/bm_create_0", com.justforentrepreneurs.j4eapp.R.layout.bm_create);
      sKeys.put("layout/bs_all_events_filter_0", com.justforentrepreneurs.j4eapp.R.layout.bs_all_events_filter);
      sKeys.put("layout/bs_chatbuddylist_0", com.justforentrepreneurs.j4eapp.R.layout.bs_chatbuddylist);
      sKeys.put("layout/bs_comment_list_0", com.justforentrepreneurs.j4eapp.R.layout.bs_comment_list);
      sKeys.put("layout/bs_confirm_booking_0", com.justforentrepreneurs.j4eapp.R.layout.bs_confirm_booking);
      sKeys.put("layout/bs_member_filter_0", com.justforentrepreneurs.j4eapp.R.layout.bs_member_filter);
      sKeys.put("layout/bs_recommend_person_list_0", com.justforentrepreneurs.j4eapp.R.layout.bs_recommend_person_list);
      sKeys.put("layout/bs_reward_list_0", com.justforentrepreneurs.j4eapp.R.layout.bs_reward_list);
      sKeys.put("layout/camera_gallary_bottomsheet_0", com.justforentrepreneurs.j4eapp.R.layout.camera_gallary_bottomsheet);
      sKeys.put("layout/check_box_plan_0", com.justforentrepreneurs.j4eapp.R.layout.check_box_plan);
      sKeys.put("layout/checkbox_adapter_0", com.justforentrepreneurs.j4eapp.R.layout.checkbox_adapter);
      sKeys.put("layout/deactivated_dialog_0", com.justforentrepreneurs.j4eapp.R.layout.deactivated_dialog);
      sKeys.put("layout/delete_dialog_0", com.justforentrepreneurs.j4eapp.R.layout.delete_dialog);
      sKeys.put("layout/delete_dialog_pdf_0", com.justforentrepreneurs.j4eapp.R.layout.delete_dialog_pdf);
      sKeys.put("layout/delete_dialog_ppt_0", com.justforentrepreneurs.j4eapp.R.layout.delete_dialog_ppt);
      sKeys.put("layout/drawer_layout_0", com.justforentrepreneurs.j4eapp.R.layout.drawer_layout);
      sKeys.put("layout/featuresmembers_adapter_0", com.justforentrepreneurs.j4eapp.R.layout.featuresmembers_adapter);
      sKeys.put("layout/filter_bottom_sheet_0", com.justforentrepreneurs.j4eapp.R.layout.filter_bottom_sheet);
      sKeys.put("layout/filter_business_transaction_0", com.justforentrepreneurs.j4eapp.R.layout.filter_business_transaction);
      sKeys.put("layout/frag_all_buddies_0", com.justforentrepreneurs.j4eapp.R.layout.frag_all_buddies);
      sKeys.put("layout/frag_all_leads_0", com.justforentrepreneurs.j4eapp.R.layout.frag_all_leads);
      sKeys.put("layout/frag_all_posts_0", com.justforentrepreneurs.j4eapp.R.layout.frag_all_posts);
      sKeys.put("layout/frag_my_diary_0", com.justforentrepreneurs.j4eapp.R.layout.frag_my_diary);
      sKeys.put("layout/frag_pending_connecsent_0", com.justforentrepreneurs.j4eapp.R.layout.frag_pending_connecsent);
      sKeys.put("layout/frag_pending_connection_0", com.justforentrepreneurs.j4eapp.R.layout.frag_pending_connection);
      sKeys.put("layout/frag_pending_events_0", com.justforentrepreneurs.j4eapp.R.layout.frag_pending_events);
      sKeys.put("layout/frag_pending_myleads_0", com.justforentrepreneurs.j4eapp.R.layout.frag_pending_myleads);
      sKeys.put("layout/frag_pending_requirement_0", com.justforentrepreneurs.j4eapp.R.layout.frag_pending_requirement);
      sKeys.put("layout/frag_pr_buddy_meet_0", com.justforentrepreneurs.j4eapp.R.layout.frag_pr_buddy_meet);
      sKeys.put("layout/frag_pr_followup_0", com.justforentrepreneurs.j4eapp.R.layout.frag_pr_followup);
      sKeys.put("layout/frag_recommended_by_0", com.justforentrepreneurs.j4eapp.R.layout.frag_recommended_by);
      sKeys.put("layout/frag_recommended_to_0", com.justforentrepreneurs.j4eapp.R.layout.frag_recommended_to);
      sKeys.put("layout/fragment_all_event_0", com.justforentrepreneurs.j4eapp.R.layout.fragment_all_event);
      sKeys.put("layout/fragment_completed_referral_0", com.justforentrepreneurs.j4eapp.R.layout.fragment_completed_referral);
      sKeys.put("layout/fragment_completed_referral_received_0", com.justforentrepreneurs.j4eapp.R.layout.fragment_completed_referral_received);
      sKeys.put("layout/fragment_frag_j4_e_members_0", com.justforentrepreneurs.j4eapp.R.layout.fragment_frag_j4_e_members);
      sKeys.put("layout/fragment_group_0", com.justforentrepreneurs.j4eapp.R.layout.fragment_group);
      sKeys.put("layout/fragment_individual_0", com.justforentrepreneurs.j4eapp.R.layout.fragment_individual);
      sKeys.put("layout/fragment_pending_referral_0", com.justforentrepreneurs.j4eapp.R.layout.fragment_pending_referral);
      sKeys.put("layout/fragment_pending_referral_received_0", com.justforentrepreneurs.j4eapp.R.layout.fragment_pending_referral_received);
      sKeys.put("layout/fragment_upcoming_event_0", com.justforentrepreneurs.j4eapp.R.layout.fragment_upcoming_event);
      sKeys.put("layout/full_image_dialog_0", com.justforentrepreneurs.j4eapp.R.layout.full_image_dialog);
      sKeys.put("layout/gallary_activityview_0", com.justforentrepreneurs.j4eapp.R.layout.gallary_activityview);
      sKeys.put("layout/gallary_activityzoom_0", com.justforentrepreneurs.j4eapp.R.layout.gallary_activityzoom);
      sKeys.put("layout/imagedelete_dialog_0", com.justforentrepreneurs.j4eapp.R.layout.imagedelete_dialog);
      sKeys.put("layout/item_event_joiner_0", com.justforentrepreneurs.j4eapp.R.layout.item_event_joiner);
      sKeys.put("layout/item_event_status_0", com.justforentrepreneurs.j4eapp.R.layout.item_event_status);
      sKeys.put("layout/item_membership_feature_0", com.justforentrepreneurs.j4eapp.R.layout.item_membership_feature);
      sKeys.put("layout/item_membership_title_0", com.justforentrepreneurs.j4eapp.R.layout.item_membership_title);
      sKeys.put("layout/item_membership_title_title_0", com.justforentrepreneurs.j4eapp.R.layout.item_membership_title_title);
      sKeys.put("layout/item_notification_0", com.justforentrepreneurs.j4eapp.R.layout.item_notification);
      sKeys.put("layout/item_package_0", com.justforentrepreneurs.j4eapp.R.layout.item_package);
      sKeys.put("layout/item_post_category_0", com.justforentrepreneurs.j4eapp.R.layout.item_post_category);
      sKeys.put("layout/item_referral_0", com.justforentrepreneurs.j4eapp.R.layout.item_referral);
      sKeys.put("layout/item_welcome_0", com.justforentrepreneurs.j4eapp.R.layout.item_welcome);
      sKeys.put("layout/lav_deals_discounts_0", com.justforentrepreneurs.j4eapp.R.layout.lav_deals_discounts);
      sKeys.put("layout/lav_my_diary_0", com.justforentrepreneurs.j4eapp.R.layout.lav_my_diary);
      sKeys.put("layout/lay_bottom_bar_0", com.justforentrepreneurs.j4eapp.R.layout.lay_bottom_bar);
      sKeys.put("layout/lay_mymebershipupgradebottomshit_0", com.justforentrepreneurs.j4eapp.R.layout.lay_mymebershipupgradebottomshit);
      sKeys.put("layout/lay_paln_features_adapter_0", com.justforentrepreneurs.j4eapp.R.layout.lay_paln_features_adapter);
      sKeys.put("layout/lay_plan_upgradeadapter_0", com.justforentrepreneurs.j4eapp.R.layout.lay_plan_upgradeadapter);
      sKeys.put("layout/lay_profile_about_us_0", com.justforentrepreneurs.j4eapp.R.layout.lay_profile_about_us);
      sKeys.put("layout/lay_profile_contact_us_0", com.justforentrepreneurs.j4eapp.R.layout.lay_profile_contact_us);
      sKeys.put("layout/lay_profile_gallery_0", com.justforentrepreneurs.j4eapp.R.layout.lay_profile_gallery);
      sKeys.put("layout/lay_profile_reviews_0", com.justforentrepreneurs.j4eapp.R.layout.lay_profile_reviews);
      sKeys.put("layout/lay_toolbar_0", com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar);
      sKeys.put("layout/lay_toolbar_award_0", com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_award);
      sKeys.put("layout/lay_toolbar_edit_0", com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_edit);
      sKeys.put("layout/lay_toolbar_editbtn_0", com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_editbtn);
      sKeys.put("layout/lay_toolbar_events_0", com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_events);
      sKeys.put("layout/lay_toolbar_home_0", com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_home);
      sKeys.put("layout/lay_toolbar_lead_status_add_0", com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_lead_status_add);
      sKeys.put("layout/lay_toolbar_lead_status_publish_0", com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_lead_status_publish);
      sKeys.put("layout/lay_toolbar_my_leads_0", com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_my_leads);
      sKeys.put("layout/lay_toolbar_myguestinvites_0", com.justforentrepreneurs.j4eapp.R.layout.lay_toolbar_myguestinvites);
      sKeys.put("layout/layout_membership_addedit_0", com.justforentrepreneurs.j4eapp.R.layout.layout_membership_addedit);
      sKeys.put("layout/layout_tandc_bottomsheet_0", com.justforentrepreneurs.j4eapp.R.layout.layout_tandc_bottomsheet);
      sKeys.put("layout/mainexit_dialog_0", com.justforentrepreneurs.j4eapp.R.layout.mainexit_dialog);
      sKeys.put("layout/new_update_dialog_0", com.justforentrepreneurs.j4eapp.R.layout.new_update_dialog);
      sKeys.put("layout/offline_transaction_details_adapter_0", com.justforentrepreneurs.j4eapp.R.layout.offline_transaction_details_adapter);
      sKeys.put("layout/payment_faild_bottomsheet_0", com.justforentrepreneurs.j4eapp.R.layout.payment_faild_bottomsheet);
      sKeys.put("layout/planexpaireddialog_0", com.justforentrepreneurs.j4eapp.R.layout.planexpaireddialog);
      sKeys.put("layout/planning_events_dialog_0", com.justforentrepreneurs.j4eapp.R.layout.planning_events_dialog);
      sKeys.put("layout/post_info_0", com.justforentrepreneurs.j4eapp.R.layout.post_info);
      sKeys.put("layout/recommand_exit_listpeople_0", com.justforentrepreneurs.j4eapp.R.layout.recommand_exit_listpeople);
      sKeys.put("layout/recommdation_note_bm_0", com.justforentrepreneurs.j4eapp.R.layout.recommdation_note_bm);
      sKeys.put("layout/recommendationpeople_bottomsheet_0", com.justforentrepreneurs.j4eapp.R.layout.recommendationpeople_bottomsheet);
      sKeys.put("layout/recommended_person_rv_adapter_0", com.justforentrepreneurs.j4eapp.R.layout.recommended_person_rv_adapter);
      sKeys.put("layout/reffralcheckbox_adapter_0", com.justforentrepreneurs.j4eapp.R.layout.reffralcheckbox_adapter);
      sKeys.put("layout/renew_bottomsheet_0", com.justforentrepreneurs.j4eapp.R.layout.renew_bottomsheet);
      sKeys.put("layout/reviewall_popup_0", com.justforentrepreneurs.j4eapp.R.layout.reviewall_popup);
      sKeys.put("layout/sort_bottom_sheet_0", com.justforentrepreneurs.j4eapp.R.layout.sort_bottom_sheet);
      sKeys.put("layout/splash_permissiondialog_0", com.justforentrepreneurs.j4eapp.R.layout.splash_permissiondialog);
      sKeys.put("layout/thank_you_bottom_sheet_0", com.justforentrepreneurs.j4eapp.R.layout.thank_you_bottom_sheet);
      sKeys.put("layout/toolbar_search_0", com.justforentrepreneurs.j4eapp.R.layout.toolbar_search);
      sKeys.put("layout/toolbar_simple_0", com.justforentrepreneurs.j4eapp.R.layout.toolbar_simple);
      sKeys.put("layout/toolbar_single_image_0", com.justforentrepreneurs.j4eapp.R.layout.toolbar_single_image);
      sKeys.put("layout/update_background_0", com.justforentrepreneurs.j4eapp.R.layout.update_background);
      sKeys.put("layout/viewpager_profile_adapter_0", com.justforentrepreneurs.j4eapp.R.layout.viewpager_profile_adapter);
      sKeys.put("layout/welcome_slide_a_0", com.justforentrepreneurs.j4eapp.R.layout.welcome_slide_a);
      sKeys.put("layout/welcome_slide_b_0", com.justforentrepreneurs.j4eapp.R.layout.welcome_slide_b);
      sKeys.put("layout/welcome_slide_c_0", com.justforentrepreneurs.j4eapp.R.layout.welcome_slide_c);
      sKeys.put("layout/welcome_slide_d_0", com.justforentrepreneurs.j4eapp.R.layout.welcome_slide_d);
    }
  }
}
