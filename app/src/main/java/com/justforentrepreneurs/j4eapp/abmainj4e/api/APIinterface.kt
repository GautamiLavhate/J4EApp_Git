package com.justforentrepreneurs.j4eapp.abmainj4e.api


import com.justforentrepreneurs.j4eapp.abmainj4e.network.model.AppUserAccDetailModel
import com.justforentrepreneurs.j4eapp.abmainj4e.network.model.LoginRegisterModel
import com.justforentrepreneurs.j4eapp.abmainj4e.network.model.NotificationModel
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.OTPVerification.OTPVerifyModel
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.allmembers.model.AllMemberResponse
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.aboutus.model.AboutUs
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.FilterPlan
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.J4EMember
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.TotalEmployee
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.model.*
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.toprankings.model.TopRank
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment.model.Allevents
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.*
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.*
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myawardrecognition.model.MyAward
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mybusinesstransactions.model.BusinessTransactionDetails
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mybusinesstransactions.model.Businesstransaction
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionAccept
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionDecline
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.Model.ConnectionReceived
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.model.*
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myguestinvites.moel.GuestInvitesLi
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mylead.model.MyLeadCom
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mylead.model.MyLeadcomplete
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.*
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrecognition.model.Recognition
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrefrral.model.ReferralResponse
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myreportcard.Model.MyReportData
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrequirements.model.MyRequirement
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrequirements.model.MyRequirementcom
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mytestimonials.model.Testimonial
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.model.Buddymeet
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.model.FollowUp
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.model.FollowUpLead
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.model.FollowUpmem
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.recommended.model.RecommandByTo
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.searchalldata.model.SearchM
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.permissions.PermissionsResponse
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.demo_model.ViewGalleryResponse
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.model.*
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.terms.model.TandCResponse
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.welcome.model.WelcomeResponse
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.ApiConstants
//import com.justforentrepreneurs.j4eapp.activities.main.messaging.Participant
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface APIinterface {

    @FormUrlEncoded
    @POST("app_user_account_details")
    fun getaccountdetals(@Field("userid") userid: String,@Field("from_userid") from_userid:String): Call<AppUserAccDetailModel>

    @FormUrlEncoded
    @POST("app_user_view_profile_about")
    fun getuser_view_profile_about(@Field(ApiConstants.userid) userid: String): Call<ProfileAboutModel>


    @FormUrlEncoded
    @POST("app_user_view_profile_contact")
    fun getuser_view_profile_contacts(@Field(ApiConstants.userid) userid: String): Call<ProfileContactUsModel>

    @FormUrlEncoded
    @POST("mobile_signin")
    fun mobile1Login(@Field(ApiConstants.mobile) userid: String): Call<LoginRegisterModel>


    @Multipart
    @POST("app_user_edit_profile_pic")
    fun app_user_edit_profile_pic(@Part(ApiConstants.userid) userid: RequestBody, @Part profile_pic: MultipartBody.Part): Call<ProfilepicModel>

    @FormUrlEncoded
    @POST("app_user_verify_otp")
    fun app_user_verify_otp(@Field(ApiConstants.userid) userid: String,
                            @Field(ApiConstants.otp) otp: String,
                            @Field("mobile") mobile: String,
                            @Field("device_type") device_type: String,
                            @Field("device_token") device_token: String): Call<OTPVerifyModel>

    @Multipart
    @POST("app_user_edit_profile_about")
    fun EditProfileAboutus(@Part(ApiConstants.userid) userid: RequestBody,
                           @Part(ApiConstants.company_name) company_name: RequestBody,
                           @Part("about_company") about_company: RequestBody,
                           @Part("business_entity") business_entity: RequestBody,
                           @Part("business_type") business_type: RequestBody,
                           @Part("business_experties") business_experties: RequestBody,
                           @Part("working_from") working_from: RequestBody,
                           @Part("no_of_employees") no_of_employees: RequestBody,
                           @Part("expected_turnover") expected_turnover: RequestBody,
                           @Part("target_audiance") target_audiance: RequestBody,
                           @Part company_profile: MultipartBody.Part,
                           @Part company_ppt: MultipartBody.Part): Call<ConnectionDecline>


    @Multipart
    @POST("app_user_edit_profile_contact")
    fun EditProfilecontactus(@Part(ApiConstants.userid) userid: RequestBody,
                             @Part("email") email: RequestBody,
                             @Part("mobile") mobile: RequestBody,
                             @Part("company") company: RequestBody,
                             @Part("designation") designation: RequestBody,
                             @Part("total_experience") total_experience: RequestBody,
                             @Part("business_category") business_category: RequestBody,
                             @Part("website") website: RequestBody,
                             @Part("company_address") company_address: RequestBody,
                             @Part vcard_front: MultipartBody.Part,
                             @Part vcard_back: MultipartBody.Part,
                             @Part("company_facebook") company_facebook: RequestBody,
                             @Part("company_linkedin") company_linkedin: RequestBody,
                             @Part("company_instagram") company_instagram: RequestBody,
                             @Part("company_twitter") company_twitter: RequestBody,
                             @Part("company_youtube") company_youtube: RequestBody,
                             @Part("company_skype") company_skype: RequestBody,
                             @Part("gender") Gender: RequestBody,
                             @Part("company_google") Company_google: RequestBody,
                             @Part("date_of_birth") date_of_birth: RequestBody,
                             @Part("whatsapp_no") whatsapp_no:RequestBody,
                             @Part("company_whatsapp_no") company_whatsapp_no:RequestBody
    ): Call<GeneralModel>

    @FormUrlEncoded
    @POST("app_user_edit_membership_details")
    fun app_user_edit_membership_details(@Field(ApiConstants.userid) userid: String,
                                         @Field("first_name") first_name: String,
                                         @Field("middle_name") middle_name: String,
                                         @Field("last_name") last_name: String,
                                         @Field("email") email: String,
                                         @Field("mobile") mobile: String,
                                         @Field("designation") designation: String,
                                         @Field("company_name") company_name: String,
                                         @Field("company_phone") company_phone: String,
                                         @Field("company_address") company_address: String,
                                         @Field("referral_code") referral_code: String,
                                         @Field("whatsapp_no") whatsapp_no:String,
                                         @Field("company_whatsapp_no") company_whatsapp_no:String): Call<MemberShipAdd>

    @FormUrlEncoded
    @POST("app_user_membership_details")
    fun getapp_user_membership_details(@Field(ApiConstants.userid) userid: String): Call<MembershipDetails>


    @FormUrlEncoded
    @POST("app_get_current_membership")
    fun app_get_current_membership(@Field(ApiConstants.userid) userid: String): Call<MembershipDetails>

    //..

    @FormUrlEncoded
    @POST("app_connection_request_sent_list")
    fun getconnection_request_sent_list(@Field(ApiConstants.userid) userid: String): Call<ConnectionReceived>

    @FormUrlEncoded
    @POST("app_connection_request_received_list")
    fun getconnection_request_receive_list(@Field(ApiConstants.userid) userid: String): Call<ConnectionReceived>

    @FormUrlEncoded
    @POST("connection_request_sent")
    fun getconnection_request_sent(@Field(ApiConstants.userid) userid: String,
                                   @Field("receiverid") receiverid: String): Call<ConnectionSend>

    @FormUrlEncoded
    @POST("connection_request_accept")
    fun getconnection_request_accept(@Field("receiverid") userid: String, @Field("senderid") senderid: String): Call<ConnectionAccept>

    @FormUrlEncoded
    @POST("connection_request_decline")
    fun getconnection_request_decline(@Field("receiverid") userid: String, @Field("senderid") senderid: String): Call<ConnectionDecline>

    @FormUrlEncoded
    @POST("app_get_my_buddies")
    fun app_get_my_buddies(@Field(ApiConstants.userid) userid: String,@Field("min_employee") min_employee: String,
                           @Field("max_employee") max_employee: String): Call<BuddiesAll>

    @FormUrlEncoded
    @POST("app_get_my_buddies")
    fun app_get_my_buddieskeword(@Field(ApiConstants.userid) userid: String, @Field("keyword") keyword: String,@Field("min_employee") min_employee: String,
                                 @Field("max_employee") max_employee: String): Call<BuddiesAll>

    @FormUrlEncoded
    @POST("app_get_my_buddies")
    fun app_get_my_buddiesFilter(@Field(ApiConstants.userid) userid: String,
                                 @Field("keyword") keyword: String,
                                 @Field("membershiptype") membershiptype: String,
                                 @Field("min_employee") min_employee: String,
                                 @Field("max_employee") max_employee: String,
                                 @Field("business_category") business_category: String,
                                 @Field("turn_over") turn_over: String,
                                 @Field("location") location: String,
                                 @Field("rank") rank: String): Call<BuddiesAll>


    @FormUrlEncoded
    @POST("app_get_my_buddies_with_membership_type")
    fun app_get_my_buddies_with_membership_type(@Field(ApiConstants.userid) userid: String,@Field("keyword") keyword: String): Call<BuddiesAll>

    @FormUrlEncoded
    @POST("app_get_all_members")
    fun app_get_all_members(@Field(ApiConstants.userid) userid: String,@Field("min_employee") min_employee: String,
                            @Field("max_employee") max_employee: String): Call<J4EMember>

    @FormUrlEncoded
    @POST("app_get_all_members")
    fun app_get_all_memberskey(@Field(ApiConstants.userid) userid: String,@Field("min_employee") min_employee: String,
                            @Field("max_employee") max_employee: String,  @Field("keyword") keyword: String): Call<J4EMember>

    @FormUrlEncoded
    @POST("app_get_all_members")
    fun app_get_all_membersKeyword(@Field(ApiConstants.userid) userid: String,
                                   @Field("keyword") keyword: String,
                                   @Field("membershiptype") membershiptype: String,
                                   @Field("min_employee") min_employee: String,
                                   @Field("max_employee") max_employee: String,
                                   @Field("business_category") business_category: String,
                                   @Field("turn_over") turn_over: String,
                                   @Field("location") location: String,
                                   @Field("rank") rank: String): Call<J4EMember>

    @Multipart
    @POST("app_create_requirement")
    fun app_create_requirement(@Part(ApiConstants.userid) userid: RequestBody,
                               @Part("requirement_title") requirement_title: RequestBody,
                               @Part("requirement_description") requirement_description: RequestBody,
                               @Part("created_date") created_date: RequestBody,
                               @Part("created_time") created_time: RequestBody,
                               @Part("functional_area_id") functional_area_id: RequestBody,
                               @Part("address") address: RequestBody,
                               @Part profile_pic: MultipartBody.Part): Call<CreateRequirement>

   /* @FormUrlEncoded
    @POST("app_get_my_requirements")
    fun app_get_my_requirements(@Field(ApiConstants.userid) userid : String): Call<MyRequirement>*/


    @FormUrlEncoded
    @POST("app_get_pending_requirements")
    fun app_get_my_requirements(@Field(ApiConstants.userid) userid: String): Call<MyRequirement>

    @FormUrlEncoded
    @POST("app_get_complete_requirements")
    fun app_get_complete_requirements(@Field(ApiConstants.userid) userid: String): Call<MyRequirementcom>

    @FormUrlEncoded
    @POST("app_get_pending_leads")
    fun app_get_pending_leads(@Field(ApiConstants.userid) userid: String): Call<MyLeadCom>

    @FormUrlEncoded
    @POST("app_get_complete_leads")
    fun app_get_complete_leads(@Field(ApiConstants.userid) userid: String): Call<MyLeadcomplete>

    @FormUrlEncoded
    @POST("app_get_all_leads")
    fun app_get_all_leads(@Field(ApiConstants.userid) userid: String): Call<LeadsAll>

    @FormUrlEncoded
    @POST("app_recommend_myself")
    fun app_recommend_myself(@Field(ApiConstants.userid) userid: String,
                             @Field("requirement_id") requirement_id: String,
                             @Field("recommendation_note") recommendation_note: String,
                             @Field("created_date") created_date: String,
                             @Field("created_time") created_time: String): Call<AppRecommendMyself>


    @FormUrlEncoded
    @POST("app_get_recommendation_list")
    fun app_get_recommendation_list(@Field(ApiConstants.userid) userid: String,
                                    @Field("requirement_id") requirement_id: String): Call<RecommandList>

    @FormUrlEncoded
    @POST("app_get_requirement_details")
    fun app_get_requirement_details(@Field("requirement_id") requirement_id: String,
                                    @Field("userid") userid: String): Call<Requirementdetails>


    @FormUrlEncoded
    @POST("app_recommend_buddies")
    fun app_recommend_buddies(@Field("userid") userid: String,
                              @Field("userids") userids: String,
                              @Field("recommendation_note") recommendation_note: String,
                              @Field("requirement_id") requirement_id: String,
                              @Field("creatdate") creatdate: String,
                              @Field("creattime") creattime: String): Call<MyRecommadPeo>


    @FormUrlEncoded
    @POST("view_user_gallery")
    fun view_user_gallery1(@Field("userid") userid: String): Call<ViewGallery>

    @Multipart
    @POST("user_gallery_add")
    fun user_gallery_add(@Part(ApiConstants.userid) userid: RequestBody,
                         @Part("gallerytype") gallerytype: RequestBody,
                         @Part images: List<MultipartBody.Part>): Call<GallaryUpload>

    @FormUrlEncoded
    @POST("app_user_add_membership_details")
    fun app_user_add_membership_details(@Field(ApiConstants.userid) userid: String,
                                        @Field("first_name") first_name: String,
                                        @Field("middle_name") middle_name: String,
                                        @Field("last_name") last_name: String,
                                        @Field("email") email: String,
                                        @Field("mobile") mobile: String,
                                        @Field("designation") designation: String,
                                        @Field("company_name") company_name: String,
                                        @Field("company_phone") company_phone: String,
                                        @Field("company_address") company_address: String,
                                        @Field("referral_code") referral_code: String,
                                        @Field("membership_type") membership_type: String,
                                        @Field("packages_id") packages_id: String,
                                        @Field("transactionid") transactionid: String,
                                        @Field("transationamount") transationamount: String,
                                        @Field("transationdatetime") transationdatetime: String,
                                        @Field("transationpaymenttype") transationpaymenttype: String,
                                        @Field("referred_by") referred_by:String,
                                        @Field("whatsapp_no") whatsapp_no:String,
                                        @Field("company_whatsapp_no") company_whatsapp_no:String): Call<MemberShipFirstAdd>


    @GET("app_get_all_plan")
    fun app_get_all_plan(): Call<AllPlan>

    @GET("app_get_membership_plan")
    fun app_get_membership_plan(): Call<FilterPlan>

    @FormUrlEncoded
    @POST("app_get_upgrade_membership")
    fun app_get_upgrade_membership(@Field("userid") userid: String, @Field("membership_id") membership_id: String,
                                   @Field("transactionid") transactionid: String, @Field("transationamount") transationamount: String,
                                   @Field("transationdatetime") transationdatetime: String, @Field("transationpaymenttype") transationpaymenttype: String): Call<ConnectionDecline>



    @FormUrlEncoded
    @POST("get_user_rating_review")
    fun get_user_rating_review(@Field("userid") userid: String): Call<ProfileReview>

    @FormUrlEncoded
    @POST("user_ratings_reviews")
    fun user_ratings_reviews(@Field("userid") userid: String, @Field("reviewed_by") reviewed_by: String,
                             @Field("ratings") ratings: String, @Field("review_note") review_note: String,
                             @Field("date") date: String, @Field("time") time: String): Call<ConnectionDecline>

    @FormUrlEncoded
    @POST("app_get_functional_area")
    fun app_get_functional_area(@Field("keyword") keyword: String): Call<FunctionalArea>

    @GET("app_get_lead_status")
    fun app_get_lead_status(): Call<GetLeadStatus>

    @GET("app_get_turnover")
    fun app_get_turnover(): Call<GetTurnOver>

    @GET("app_get_total_employee")
    fun app_get_total_employee(): Call<TotalEmployee>

    @GET("app_get_employee_data")
    fun app_get_employee_data(): Call<GetEmployeeWork>


    @FormUrlEncoded
    @POST("app_get_user_notification")
    fun app_get_user_notification(@Field("userid") userid: String): Call<NotificationModel>

    @FormUrlEncoded
    @POST("app_get_user_lead_status")
    fun app_get_user_lead_status(@Field("userid") userid: String, @Field("requirementsid") requirementsid: String): Call<MyLeadStatus>



    @FormUrlEncoded
    @POST("app_user_check_lead")
    fun app_user_check_lead(@Field("userid") userid: String, @Field("requirementid") requirementsid: String): Call<UserCheck>

    @FormUrlEncoded
    @POST("app_user_add_lead_status")
    fun app_user_add_lead_status(@Field("userid") userid: String,
                                 @Field("requirementsid") requirementsid: String,
                                 @Field("statusid") statusid: String,
                                 @Field("msg") msg: String,
                                 @Field("date") date: String,
                                 @Field("time") time: String,
                                 @Field("catid") catid: String,
                                 @Field("amount") amount: String,
                                 @Field("addedby") addedby: String,
                                 @Field("creatdate") creatdate: String,
                                 @Field("creattime") creattime: String,
                                 @Field("answer") answer: String): Call<ConnectionDecline>


    @Multipart
    @POST("app_create_posts")
    fun app_create_posts(@Part(ApiConstants.userid) userid: RequestBody,
                         @Part("catid") catid: RequestBody,
                         @Part("post_description") post_description: RequestBody,
                         @Part("created_date") created_date: RequestBody,
                         @Part("created_time") created_time: RequestBody,
                         @Part postthumbail: MultipartBody.Part): Call<ConnectionDecline>

    @GET("app_get_post_category")
    fun app_get_post_category(): Call<PostCategrory>

    @FormUrlEncoded
    @POST("app_get_all_posts")
    fun app_get_all_posts(@Field("userid") userid: String): Call<AllPosts>

    @FormUrlEncoded
    @POST("app_get_my_posts")
    fun app_get_my_posts(@Field("userid") userid: String): Call<AllPosts>

    @FormUrlEncoded
    @POST("app_get_like_unlike_posts")
    fun app_user_check_like_status(@Field("userid") userid: String, @Field("postid") postid: String): Call<LikePost>


    @FormUrlEncoded
    @POST("app_create_offline_business_transaction")
    fun app_create_offline_business_transaction(@Field("userid") userid: String,
                                                @Field("type") type: String,
                                                @Field("businesswith") businesswith: String,
                                                @Field("title") title: String,
                                                @Field("created_date") created_date: String,
                                                @Field("amount") amount: String,
                                                @Field("remark") remark: String,
                                                @Field("uniqueid") uniqueid: String): Call<ConnectionDecline>

    @GET("app_get_offline_business_transaction_id")
    fun app_get_offline_business_transaction_id(): Call<OfflineUnique>

    @FormUrlEncoded
    @POST("app_get_all_business_transaction")
    fun app_get_all_business_transaction(@Field("userid") userid: String,
                                         @Field("type") type: String,
                                         @Field("keyword") keyword: String): Call<Businesstransaction>

    @FormUrlEncoded
    @POST("app_get_all_business_transaction_detail")
    fun app_get_all_business_transaction_detail(@Field("transaction_id") transaction_id: String,@Field("userid") userid: String): Call<BusinessTransactionDetails>

    @FormUrlEncoded
    @POST("app_get_list_recommendations_by")
    fun app_get_list_recommendations_by(@Field("userid") userid: String,
                                        @Field("keyword") keyword: String,
                                        @Field("sortby") sortby: String,
                                        @Field("filterby") filterby: String): Call<RecommandByTo>

    @FormUrlEncoded
    @POST("app_get_list_recommendations_to")
    fun app_get_list_recommendations_to(@Field("userid") userid: String,
                                        @Field("keyword") keyword: String,
                                        @Field("sortby") sortby: String,
                                        @Field("filterby") filterby: String): Call<RecommandByTo>


    @FormUrlEncoded
    @POST("app_get_all_posts_comment")
    fun app_get_all_posts_comment(@Field("postid") postid: String): Call<PostGetComments>


    @FormUrlEncoded
    @POST("app_create_posts_comment")
    fun app_create_posts_comment(@Field("userid") userid: String,
                                 @Field("postid") postid: String,
                                 @Field("message") message: String,
                                 @Field("created_date") created_date: String,
                                 @Field("created_time") created_time: String): Call<ConnectionDecline>

    @Multipart
    @POST("app_create_event")
    fun app_create_event(@Part(ApiConstants.userid) userid: RequestBody,
                         @Part("event_title") event_title: RequestBody,
                         @Part("event_description") event_description: RequestBody,
                         @Part("venue") venue: RequestBody,
                         @Part event_thumbnail: MultipartBody.Part,
                         @Part("start_datetime") start_datetime: RequestBody,
                         @Part("end_datetime") end_datetime: RequestBody,
                         @Part("entry_fees") entry_fees: RequestBody,
                         @Part("max_ticket") max_ticket: RequestBody,
                         @Part("created_date") created_date: RequestBody,
                         @Part("created_time") created_time: RequestBody,
                         @Part("cat_id") cat_id: RequestBody,
                         @Part("event_guestfees") event_guestfees: RequestBody,
                         @Part("created_type") created_type: RequestBody,
                         @Part images: List<MultipartBody.Part>,
                         @Part("event_permission") event_permission : RequestBody): Call<ConnectionDecline>


    @Multipart
    @POST("app_update_event")
    fun app_update_event(@Part(ApiConstants.userid) userid: RequestBody,
                         @Part("event_id") event_id: RequestBody,
                         @Part("event_title") event_title: RequestBody,
                         @Part("event_description") event_description: RequestBody,
                         @Part("venue") venue: RequestBody,
                         @Part event_thumbnail: MultipartBody.Part,
                         @Part("start_datetime") start_datetime: RequestBody,
                         @Part("end_datetime") end_datetime: RequestBody,
                         @Part("entry_fees") entry_fees: RequestBody,
                         @Part("max_ticket") max_ticket: RequestBody,
                         @Part("created_date") created_date: RequestBody,
                         @Part("created_time") created_time: RequestBody,
                         @Part("cat_id") cat_id: RequestBody,
                         @Part("event_guestfees") event_guestfees: RequestBody,
                         @Part("created_type") created_type: RequestBody,
                         @Part images: List<MultipartBody.Part>): Call<ConnectionDecline>


    @Multipart
    @POST("app_update_event")
    fun app_update_eventup(@Part(ApiConstants.userid) userid: RequestBody,
                         @Part("event_id") event_id: RequestBody,
                         @Part("event_title") event_title: RequestBody,
                         @Part("event_description") event_description: RequestBody,
                         @Part("venue") venue: RequestBody,
                         @Part event_thumbnail: MultipartBody.Part,
                         @Part("start_datetime") start_datetime: RequestBody,
                         @Part("end_datetime") end_datetime: RequestBody,
                         @Part("entry_fees") entry_fees: RequestBody,
                         @Part("max_ticket") max_ticket: RequestBody,
                         @Part("created_date") created_date: RequestBody,
                         @Part("created_time") created_time: RequestBody,
                         @Part("cat_id") cat_id: RequestBody,
                         @Part("event_guestfees") event_guestfees: RequestBody,
                         @Part("created_type") created_type: RequestBody): Call<ConnectionDecline>

    @GET("app_get_event_category")
    fun app_get_event_category(): Call<Eventcategory>

    @FormUrlEncoded
    @POST("app_get_event_list")
    fun app_get_event_list(@Field("type") postid: String,@Field("userid") userid: String): Call<Allevents>

    @FormUrlEncoded
    @POST("app_get_event_list")
    fun app_get_event_listkey(@Field("type") postid: String,@Field("userid") userid: String,@Field("keyword") keyword: String): Call<Allevents>

    @FormUrlEncoded
    @POST("app_get_event_list")
    fun app_get_event_listfilter(@Field("type") postid: String,
                                 @Field("category") category: String,@Field("userid") userid: String): Call<Allevents>

    @FormUrlEncoded
    @POST("app_get_event_detail")
    fun app_get_event_detail(@Field("eventid") eventid: String,
                             @Field("userid") userid: String): Call<EventDetails>


    @FormUrlEncoded
    @POST("app_check_connection")
    fun app_check_connection(@Field("userid") userid: String,
                             @Field("viewbyuserid") viewbyuserid: String): Call<Checkconnection>

    @FormUrlEncoded
    @POST("app_add_event_ratings_reviews")
    fun app_add_event_ratings_reviews(@Field("userid") userid: String, @Field("eventid") eventid: String,
                             @Field("ratings") ratings: String, @Field("review_note") review_note: String,
                             @Field("date") date: String, @Field("time") time: String, @Field("event_catid") event_catid: String): Call<ConnectionDecline>

    @FormUrlEncoded
    @POST("app_event_invite_byuser")
    fun app_event_invite_byuser(@Field("touserid") touserids: String,
                              @Field("byuserid") byuserid: String,
                              @Field("eventid") eventid: String,
                              @Field("created_date") created_date: String,
                              @Field("created_time") created_time: String): Call<ConnectionDecline>

    @FormUrlEncoded
    @POST("app_event_participation")
    fun app_event_participation(@Field("userid") userid: String,
                                @Field("type") type: String,
                                @Field("eventid") eventid: String,
                                @Field("created_date") created_date: String,
                                @Field("created_time") created_time: String): Call<ConnectionDecline>

    @FormUrlEncoded
    @POST("app_event_attending_status_list")
    fun app_event_attending_status_list(@Field("eventid") eventid: String): Call<EventStatus>

    @FormUrlEncoded
    @POST("app_event_detail_for_boking")
    fun app_event_detail_for_boking(@Field("eventid") eventid: String): Call<EventBookDetails>

    @FormUrlEncoded
    @POST("app_user_book_event")
    fun app_user_book_event(@Field("userid") userid: String,
                            @Field("username") username: String,
                            @Field("eventid") eventid: String,
                            @Field("companyname") companyname: String,
                            @Field("useremail") useremail: String,
                            @Field("userphno") userphno: String,
                            @Field("amount") amount: String,
                            @Field("created_date") created_date: String,
                            @Field("created_time") created_time: String,
                            @Field("categoryname") categoryname: String): Call<EventBook>

    @FormUrlEncoded
    @POST("app_create_guest_invite_event")
    fun app_create_guest_invite_event(@Field("userid") userid: String,
                            @Field("eventid") eventid: String,
                            @Field("guestname") guestname: String,
                            @Field("mobilenumber") mobilenumber: String,
                            @Field("emailid") emailid: String,
                            @Field("companyname") companyname: String,
                            @Field("designation") designation: String,
                            @Field("created_date") created_date: String,
                            @Field("created_time") created_time: String,
                              @Field("payment") payment: String,
                              @Field("payment_by") payment_by: String,
                              @Field("payment_amount") payment_amount: String,
                              @Field("payment_id") payment_id: String,
                              @Field("verification_need") verification_need: String,
                              @Field("status") status: String,
                              @Field("payment_datetime") payment_datetime: String): Call<ConnectionDecline>

    @FormUrlEncoded
    @POST("app_get_guest_invite_event_list")
    fun app_get_guest_invite_event_list(@Field("userid") userid: String):Call<GuestInvitesLi>

    @FormUrlEncoded
    @POST("app_get_my_report_card")
    fun app_get_my_report_card(@Field("userid") userid: String):Call<MyReportData>

    @FormUrlEncoded
    @POST("app_get_my_diary")
    fun app_get_my_diary(@Field("userid") userid: String):Call<MyDiary>

    @Multipart
    @POST("app_create_recognition")
    fun app_create_recognition(@Part(ApiConstants.userid) userid: RequestBody,
                         @Part("title") title: RequestBody,
                         @Part("description") description: RequestBody,
                         @Part("created_date") created_date: RequestBody,
                         @Part("created_time") created_time: RequestBody,
                         @Part recognition_thumbnail: MultipartBody.Part): Call<ConnectionDecline>

    @FormUrlEncoded
    @POST("app_get_recognition")
    fun app_get_recognition(@Field("userid") userid: String,@Field("type") type: String):Call<Recognition>

    @FormUrlEncoded
    @POST("app_get_toprank_list")
    fun app_get_toprank_list(@Field("userid") userid: String):Call<TopRank>

    @GET("app_get_aboutus")
    fun app_get_aboutus(): Call<AboutUs>

    @FormUrlEncoded
    @POST("app_get_testimonial")
    fun app_get_testimonial(@Field("userid") userid: String):Call<Testimonial>

    @FormUrlEncoded
    @POST("app_get_award_recognition")
    fun app_get_award_recognition(@Field("userid") userid: String):Call<MyAward>

    @FormUrlEncoded
    @POST("app_create_fallowup")
    fun app_create_fallowup(@Field("type") type: String,
                            @Field("byuserid") byuserid: String,
                            @Field("touserid") touserid: String,
                            @Field("description") description: String,
                            @Field("date") date: String,
                            @Field("created_date") created_date: String,
                            @Field("created_time") created_time: String,
                            @Field("requirementid") requirementid: String,
                            @Field("time") time: String): Call<ConnectionDecline>

    @FormUrlEncoded
    @POST("app_create_buddy_meet")
    fun app_create_buddy_meet(@Field("userid") userid: String,
                            @Field("buddiesid") buddiesid: String,
                            @Field("description") description: String,
                            @Field("location") location: String,
                            @Field("date") date: String,
                            @Field("created_date") created_date: String,
                            @Field("created_time") created_time: String,
                              @Field("time") time: String): Call<ConnectionDecline>

    @FormUrlEncoded
    @POST("app_get_fallowup_list")
    fun app_get_fallowup_list(@Field("userid") userid: String):Call<FollowUp>

    @FormUrlEncoded
    @POST("app_buddy_meet_list")
    fun app_buddy_meet_list(@Field("userid") userid: String):Call<Buddymeet>

    @FormUrlEncoded
    @POST("app_get_fallowup_lead_data")
    fun app_get_fallowup_lead_data(@Field("userid") userid: String,@Field("type") type: String,@Field("keyword") keyword: String):Call<FollowUpLead>


    @FormUrlEncoded
    @POST("app_get_fallowup_lead_userdata")
    fun app_get_fallowup_lead_userdata(@Field("requirementid") requirementid: String,@Field("type") type: String):Call<FollowUpmem>

    @FormUrlEncoded
    @POST("app_add_j4e_ratings_reviews")
    fun app_add_j4e_ratings_reviews(@Field("userid") userid: String,
                             @Field("ratings") ratings: String, @Field("review_note") review_note: String,
                             @Field("date") date: String, @Field("time") time: String): Call<ConnectionDecline>

    @FormUrlEncoded
    @POST("app_get_search_data")
    fun app_get_search_data(@Field("userid") userid: String,@Field("keyword") keyword: String):Call<SearchM>

    @FormUrlEncoded
    @POST("app_get_groups")
    fun app_get_groups(@Field("userid") userid: String):Call<GroupsList>

//    @FormUrlEncoded
//    @POST("app_get_group_participants")
//    fun app_get_group_participants(@Field("userid") userid: String,@Field("group_uid") group_uid: String,@Field("keyword") keyword: String):Call<Participant>


    @FormUrlEncoded
    @POST("app_get_renew_membership")
    fun app_get_renew_membership(@Field("userid") userid: String, @Field("membership_id") membership_id: String,
                                   @Field("transactionid") transactionid: String, @Field("transationamount") transationamount: String,
                                   @Field("transationdatetime") transationdatetime: String, @Field("transationpaymenttype") transationpaymenttype: String,
        @Field("startdate") startdate: String): Call<ConnectionDecline>


    @FormUrlEncoded
    @POST("app_get_notification_count")
    fun app_get_notification_count(@Field("userid") userid: String):Call<CountBubble>

    @FormUrlEncoded
    @POST("app_delete_account")
    fun app_delete_account(@Field("userid") userid: String):Call<ConnectionDecline>


    @FormUrlEncoded
    @POST("user_gallery_delete")
    fun user_gallery_delete(@Field("userid") userid: String,@Field("imageid") imageid: String):Call<ConnectionDecline>


    @FormUrlEncoded
    @POST("app_confirm_business_transaction")
    fun app_confirm_business_transaction(@Field("id") id: String):Call<ConnectionDecline>

    @FormUrlEncoded
    @POST("app_event_register_list")
    fun app_event_register_list(@Field(ApiConstants.userid) userid: String,@Field("eventid") eventid: String,@Field("keyword") keyword: String): Call<EventRegister>

    @FormUrlEncoded
    @POST("app_confirm_event_status")
    fun app_confirm_event_status(@Field("eventid") eventid: String):Call<ConnectionDecline>

    @FormUrlEncoded
    @POST("app_check_event_invite")
    fun app_check_event_invite(@Field("invite_mobilenumber") invite_mobilenumber: String,
                               @Field("event_id") event_id: String):Call<EventInvite>


    @FormUrlEncoded
    @POST("app_do_guest_invite_payment")
    fun app_do_guest_invite_payment(@Field("userid") userid: String,
                                 @Field("invite_id") invite_id: String,
                                 @Field("payment_id") payment_id: String,
                                 @Field("status") status: String,
                                 @Field("payment_amount") payment_amount: String,
                                 @Field("payment_datetime") payment_datetime: String):Call<ConnectionDecline>

    @FormUrlEncoded
    @POST("app_check_validity")
    fun app_check_validity(@Field("mobile") mobile: String):Call<PlanValidity>


    @FormUrlEncoded
    @POST("app_get_home_details")
    fun app_get_home_screen_permission(@Field("userid") userid: String):Call<PermissionsResponse>

    @GET("app_get_terms_conditions")
    fun app_get_terms_and_condition():Call<TandCResponse>

    @GET("app_get_privacy_policy")
    fun app_get_privacy_policy():Call<TandCResponse>

    @GET("app_get_intro_screen")
    fun app_get_intro_screen():Call<WelcomeResponse>

    @GET("app_check_version_maintenance")
    fun app_check_version_maintenance():Call<VersionResponse>

    @GET("app_get_payment_details")
    fun app_get_payment_details(): Call<PaymentDetailsResponse>

    @FormUrlEncoded
    @POST("app_edit_posts")
    fun app_get_edit_post_detail(@Field("post_id") post_id:String):Call<EditPostResponse>

    @Multipart
    @POST("app_update_posts")
    fun app_edit_posts(@Part(ApiConstants.userid) userid: RequestBody,
                         @Part("catid") catid: RequestBody,
                         @Part("post_description") post_description: RequestBody,
                         @Part postthumbail: MultipartBody.Part,
                         @Part("post_id") post_id: RequestBody ):Call<EditPostResponse>

    @FormUrlEncoded
    @POST("app_delete_post_image")
    fun delete_post_image(@Field("post_id") post_id:String):Call<EditPostResponse>

    @FormUrlEncoded
    @POST("app_check_referral_code")
    fun app_check_referral_code(@Field("referral_code") referral_code:String):Call<ReferralCodeResponse>

    @GET("app_get_referral_status")
    fun app_get_referral_status(): Call<Reffralcategory>

    @FormUrlEncoded
    @POST("app_create_referral")
    fun app_create_referral(@Field(ApiConstants.userid) userid: String,
                            @Field("requirement_title") requirement_title: String,
                            @Field("requirement_description") requirement_description: String,
                            @Field("created_date") created_date: String,
                            @Field("created_time") created_time: String,
                            @Field("functional_area_id") functional_area_id: String,
                            @Field("address") address: String,
                            @Field("username") username: String,
                            @Field("cmpname") cmpname: String,
                            @Field("desgn") desgn: String,
                            @Field("mobileno") mobileno: String,
                            @Field("stdcode") stdcode: String,
                            @Field("phno") phno: String,
                            @Field("email") email: String,
                            @Field("whatsappno") whatsappno: String,
                            @Field("type") type: String,
                            @Field("hotrank") hotrank: String,
                            @Field("referral_status") referral_status: String,
                            @Field("contact_person_id") contact_person_id: String,
                            @Field("referral_for") referral_for: String): Call<CreateRequirement>

    @FormUrlEncoded
    @POST("app_get_pending_referral")
    fun app_get_pending_referral(@Field(ApiConstants.userid) userid: String): Call<ReferralResponse>

    @FormUrlEncoded
    @POST("app_get_complete_referral")
    fun app_get_complete_referral(@Field(ApiConstants.userid) userid: String): Call<ReferralResponse>

    @FormUrlEncoded
    @POST("app_get_pending_referral_received")
    fun app_get_pending_referral_received(@Field(ApiConstants.userid) userid: String): Call<ReferralResponse>

    @FormUrlEncoded
    @POST("app_get_complete_referral_received")
    fun app_get_complete_referral_received(@Field(ApiConstants.userid) userid: String): Call<ReferralResponse>

    @FormUrlEncoded
    @POST("app_get_all_members")
    fun app_get_all_members_new(@Field(ApiConstants.userid) userid: String,@Field("min_employee") min_employee: String,
                            @Field("max_employee") max_employee: String): Call<AllMemberResponse>

    @FormUrlEncoded
    @POST("app_user_delete_vcard_front")
    fun app_user_delete_vcard_front(@Field(ApiConstants.userid) userid: String): Call<DeleteImageResponse>

    @FormUrlEncoded
    @POST("app_user_delete_vcard_back")
    fun app_user_delete_vcard_back(@Field(ApiConstants.userid) userid: String): Call<DeleteImageResponse>

    @FormUrlEncoded
    @POST("app_user_delete_company_profile")
    fun app_user_delete_company_profile(@Field(ApiConstants.userid) userid: String): Call<DeleteImageResponse>

    @FormUrlEncoded
    @POST("app_user_delete_company_ppt")
    fun app_user_delete_company_ppt(@Field(ApiConstants.userid) userid: String): Call<DeleteImageResponse>

}