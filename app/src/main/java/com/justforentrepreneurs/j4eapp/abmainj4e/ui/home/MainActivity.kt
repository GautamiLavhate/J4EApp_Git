package com.justforentrepreneurs.j4eapp.abmainj4e.ui.home


import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.PowerManager
import android.provider.Settings
import android.view.*
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.navigation.NavigationView
import com.google.firebase.database.*
import com.justforentrepreneurs.StaticConfig
import com.justforentrepreneurs.j4eapp.BuildConfig
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.Userlist
import com.justforentrepreneurs.j4eapp.abmainj4e.api.APIinterface
import com.justforentrepreneurs.j4eapp.abmainj4e.api.ServiceBuilder
import com.justforentrepreneurs.j4eapp.abmainj4e.base.BaseActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.allmembers.AllMembersActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.aboutus.AboutUsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.J4EMembersActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.j4emembers.model.J4EMember
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.setting.SettingActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.supportfeedback.J4ERatingandReviewActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.toprankings.TopRankingActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.fragment.*
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.model.CountBubble
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.*
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.GroupsList
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homeService.model.PlanValidity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myawardrecognition.MyAwardRecognitionActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mybuddies.MyBuddiesActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mybusinesstransactions.MyBusinessTransactionsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.MyEventsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myguestinvites.MyGuestInvitesActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mylead.MyLeadsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.Model.PaymentDetailsResponse
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mymembershipbenefits.MyMembershipBenefitsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrecognition.MyRecognitionActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrefrral.givan.ReferralGivenActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrefrral.receive.ReferralReceivedActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myreportcard.MyReportCardActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myrequirements.MyRequirementsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mytestimonials.MyTestimonialsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.PendingResponsibilitiesActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.recommended.RecommendedActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.searchalldata.SearchActivityHome
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.login.LoginActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.permissions.PermissionsResponse
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.profile.ProfileActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.terms.PrivacyAndPolicyActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.terms.TermsAndConditionActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.*
//import com.justforentrepreneurs.j4eapp.activities.main.MainViewModel
//import com.justforentrepreneurs.j4eapp.activities.setup.SetupUserUseCase
//import com.justforentrepreneurs.j4eapp.common.ViewModelFactory
import com.justforentrepreneurs.j4eapp.databinding.ActivityMainJ4eBinding
import com.justforentrepreneurs.j4eapp.databinding.BmCreateBinding
import com.justforentrepreneurs.j4eapp.databinding.MainexitDialogBinding
import com.justforentrepreneurs.j4eapp.databinding.PlanexpaireddialogBinding
//import com.justforentrepreneurs.j4eapp.events.ExitUpdateActivityEvent
//import com.justforentrepreneurs.j4eapp.extensions.observeValueEvent
//import com.justforentrepreneurs.j4eapp.job.DailyBackupJob
//import com.justforentrepreneurs.j4eapp.job.SaveTokenJob
//import com.justforentrepreneurs.j4eapp.job.SetLastSeenJob
//import com.justforentrepreneurs.j4eapp.model.constants.PendingGroupTypes
//import com.justforentrepreneurs.j4eapp.model.realms.CurrentUserInfo
//import com.justforentrepreneurs.j4eapp.model.realms.PendingGroupJob
//import com.justforentrepreneurs.j4eapp.model.realms.User
//import com.justforentrepreneurs.j4eapp.services.FCMRegistrationService
//import com.justforentrepreneurs.j4eapp.services.InternetConnectedListener
//import com.justforentrepreneurs.j4eapp.services.NetworkService
//import com.justforentrepreneurs.j4eapp.utils.*
//import com.justforentrepreneurs.j4eapp.utils.network.FireManager
//import com.justforentrepreneurs.j4eapp.utils.network.GroupManager
//import com.justforentrepreneurs.j4eapp.views.dialogs.IgnoreBatteryDialog
//import com.justforentrepreneurs.j4eapp.views.sticker.StickerLoader
import com.poup.newpowemenu.OnMenuItemClickListener
import com.poup.newpowemenu.PowerMenu
import com.poup.newpowemenu.PowerMenuItem
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.drawer_layout.view.*
import kotlinx.android.synthetic.main.lay_bottom_bar.*
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var binding: ActivityMainJ4eBinding
    private var iconMenu: PowerMenu? = null
//    private val groupManager = GroupManager()
    var databaseReference: DatabaseReference? = null

    private var pickedPhoto: String? = null
    private var backupFileUri: String? = null
    private var dbFileUri: String? = null

    private var addpersmission: String? = ""

    //chat

//    private lateinit var viewModel: MainViewModel
//    private var fireListener: FireListener? = null
//    private var ignoreBatteryDialog: IgnoreBatteryDialog? = null


//    private var users: List<User>? = null

    var is_post_exhausted: Int = -1
    var is_requirement_exhausted: Int = -1
    var is_buddy_meet_exhausted: Int = -1
    var is_referral_exhausted: Int = -1

    var currentPosition : Int = 0

//    var uri: Uri? = null
    override fun enablePresence(): Boolean {
        return true
    }

    //chat


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_j4e)
        binding.lifecycleOwner = this
        navDrawer()
        //readUsingSharedPreference(MyApp.context(), "UidK")

//        viewModel = ViewModelProvider(
//            this,
//            ViewModelFactory(this.application)
//        ).get(MainViewModel::class.java)
//        uri = intent.data
//        if (uri != null) {
//
//            val parameters = uri!!.pathSegments
//
//            val param = parameters[parameters.size - 1]
//
//            displayToast(this,param)
//        }

        binding.toolbar.searchhome.setOnClickListener {
            startActivity(Intent(this, SearchActivityHome::class.java))
        }


        if(isInternetAvailable(this)) {
            app_check_permissions()
            app_get_notification_count()
            get_payment_key()

        }


        readUsingSharedPreference(this, "addpersmisson")
        if(readUsingSharedPreference(this@MainActivity, "addpersmisson").toString().equals("1")) {

            //iconMenu = PowerMenuUtils.getIconPowerMenu(this@MainActivity, this@MainActivity, onIconMenuItemClickListener)
            //Infodata(readUsingSharedPreference(this@MainActivity, "addpersmisson").toString())
        } else{
            //iconMenu = PowerMenuUtils.getIconPowerMenu2(this@MainActivity, this@MainActivity, onIconMenuItemClickListener)
            //Infodata(readUsingSharedPreference(this@MainActivity, "addpersmisson").toString())
        }






        if (intent.getStringExtra("type") == "hometype") {
            val datahometype = intent.getStringExtra("hometype")
            val position = intent.getStringExtra("position")
            if(isInternetAvailable(this)) {
                app_get_notification_count()
            }
            loadFragment(HomeFragment(datahometype?.toInt()!!, position?.toInt()!!), "Home")
        }else if (intent.getStringExtra("type") == "ReceivedConnectionfragment") {
            val position = intent.getStringExtra("position")
            setBottomIconChange("1")
            ivConnection_badge.visibility=View.GONE
            loadFragment(MyConnectionsFragment(0,"fragment",position?.toInt()!!), "My Connection")
        }else if (intent.getStringExtra("type") == "SentConnectionfragment") {
            setBottomIconChange("1")
            val position = intent.getStringExtra("position")
            ivConnection_badge.visibility=View.GONE
            loadFragment(MyConnectionsFragment(1,"fragment",position?.toInt()!!), "My Connection")
        }else if (intent.getStringExtra("type") == "MyChat") {
//            val position = intent.getStringExtra("position")
//            setBottomIconChange("2")
//            loadFragment(ChatListFragment(position?.toInt()!!), "MyChat")
        }else{
            loadFragment(HomeFragment(0,0), "Home")
        }

        llHome.setOnClickListener {
            setBottomIconChange("3")
            if(isInternetAvailable(this)) {
                app_get_notification_count()
            }
            storeUsingSharedPreference(this,"showupdate","no")
            loadFragment(HomeFragment(0,0), "Home")
        }

        Glide.with(this)
                .load(readUsingSharedPreference(this@MainActivity, "profilepic").toString())
                .centerCrop()
                .placeholder(R.drawable.ic_profile_edit)
                .into(binding.drawerLayout.ivProfileImg)

        binding.drawerLayout.fullname.setText(readUsingSharedPreference(this@MainActivity, "fullname").toString())


        // chat section

//        fireListener = FireListener()

        startServices()

//        users = RealmHelper.getInstance().listOfUsers




//        if (!SharedPreferencesManager.hasAgreedToPrivacyPolicy()) {
//
//        } else if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
//            try {
//                val pkg = packageName
//                val pm = getSystemService(PowerManager::class.java)
//                if (!pm.isIgnoringBatteryOptimizations(pkg) && !SharedPreferencesManager.isDoNotShowBatteryOptimizationAgain()) {
//                    //showBatteryOptimizationDialog()
//                }
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }

//        viewModel.deleteOldMessagesIfNeeded()
//        viewModel.checkForUpdate().subscribe({ needsUpdate ->
//            if (needsUpdate) {
//
//            } else {
//                EventBus.getDefault().post(ExitUpdateActivityEvent())
//            }
//        }, {
//
//        })
//
//        viewModel.setupE2eIfNeeded()

        //listenForDeviceIdChange()



    }

     fun loadFragment(fragment: Fragment?, tag: String): Boolean {
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.fragment_container, fragment, tag)
                .commit()
            return true
        }
        return false
    }


    private fun navDrawer() {
        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        binding.navView.setNavigationItemSelectedListener(this)
        binding.drawer.layDealsDiscount.root.visibility = GONE
        binding.drawer.layMyDiary.root.visibility = GONE
        binding.drawerLayout.fullname.setText(readUsingSharedPreference(this@MainActivity, "fullname").toString())
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    fun onNavigationClick(view: View) {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START))
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        else
            binding.drawerLayout.openDrawer(GravityCompat.START)
    }


    private val onIconMenuItemClickListener = OnMenuItemClickListener<PowerMenuItem> { position, item ->
        if (readUsingSharedPreference(this, "addpersmisson").toString().equals("1")){
            when (position) {

                0 -> {
                    if (readUsingSharedPreference(this,"PermissionCreateRequirement").equals("0")){
                        PermissionDialog(readUsingSharedPreference(this,"CreatePermissionMsg").toString())
                    }else{
                        if (is_requirement_exhausted==0){
                            startActivity(Intent(this, CreateRequirementActivity::class.java))
                        }else{
                            PermissionDialog(readUsingSharedPreference(this,"CreateExhaustedMsg").toString())
                        }
                    }
                }
                1 -> {
                    startActivity(Intent(this, CreateEventsActivity::class.java))
                }
                2 -> {
                    if (readUsingSharedPreference(this,"PermissionCreatePost").equals("0")){
                        PermissionDialog(readUsingSharedPreference(this,"CreatePermissionMsg").toString())
                    }else{
                        if (is_post_exhausted==0){
                            startActivity(Intent(this, CreatePostsActivity::class.java))
                        }else{
                            PermissionDialog(readUsingSharedPreference(this,"CreateExhaustedMsg").toString())
                        }
                    }
                }
                3 -> {
                    displayToast(this, "Coming Soon..")
                }
                4 -> {
                    if (readUsingSharedPreference(this,"PermissionCreateBuddyMeet").equals("0")){
                        PermissionDialog(readUsingSharedPreference(this,"CreatePermissionMsg").toString())
                    }else{
                        if (is_buddy_meet_exhausted==0){
                            startActivity(Intent(this, CreateBuddyMeetActivity::class.java))
                        }else{
                            PermissionDialog(readUsingSharedPreference(this,"CreateExhaustedMsg").toString())
                        }
                    }
                }
                5 -> {
                    startActivity(Intent(this, CreateOfflineBusinessActivity::class.java))
                }
                6 -> {
                    if (readUsingSharedPreference(this,"PermissionCreateReferral").equals("0")){
                        PermissionDialog(readUsingSharedPreference(this,"CreatePermissionMsg").toString())
                    }else{
                        if (is_referral_exhausted==0){
                            startActivity(Intent(this, CreateReferralActivity::class.java))
                        }else{
                            PermissionDialog(readUsingSharedPreference(this,"CreateExhaustedMsg").toString())
                        }
                    }

                }
            }
        }else{
            when (position) {

                0 -> {
                    if (readUsingSharedPreference(this,"PermissionCreateRequirement").equals("0")){
                        PermissionDialog(readUsingSharedPreference(this,"CreatePermissionMsg").toString())
                    }else{
                        if (is_requirement_exhausted==0){
                            startActivity(Intent(this, CreateRequirementActivity::class.java))
                        }else{
                            PermissionDialog(readUsingSharedPreference(this,"CreateExhaustedMsg").toString())
                        }

                    }
                }
                1 -> {
                    if (readUsingSharedPreference(this,"PermissionCreatePost").equals("0")){
                        PermissionDialog(readUsingSharedPreference(this,"CreatePermissionMsg").toString())
                    }else{
                        if (is_post_exhausted==0){
                            startActivity(Intent(this, CreatePostsActivity::class.java))
                        }else{
                            PermissionDialog(readUsingSharedPreference(this,"CreateExhaustedMsg").toString())
                        }

                    }
                }
                2 -> {
                    displayToast(this, "Coming Soon..")
                }
                3 -> {
                    if (readUsingSharedPreference(this,"PermissionCreateBuddyMeet").equals("0")){
                        PermissionDialog(readUsingSharedPreference(this,"CreatePermissionMsg").toString())
                    }else{
                        if (is_buddy_meet_exhausted==0){
                            startActivity(Intent(this, CreateBuddyMeetActivity::class.java))
                        }else{
                            PermissionDialog(readUsingSharedPreference(this,"CreateExhaustedMsg").toString())
                        }

                    }
                }
                4 -> {
                    startActivity(Intent(this, CreateOfflineBusinessActivity::class.java))
                }
                5 -> {
                    if (readUsingSharedPreference(this,"PermissionCreateReferral").equals("0")){
                        PermissionDialog(readUsingSharedPreference(this,"CreatePermissionMsg").toString())
                    }else{
                        if (is_referral_exhausted==0){
                            startActivity(Intent(this, CreateReferralActivity::class.java))
                        }else{
                            PermissionDialog(readUsingSharedPreference(this,"CreateExhaustedMsg").toString())
                        }
                    }
                }
            }
        }
        iconMenu!!.dismiss()
    }

    fun onCreateClick(view: View) {
//        if (iconMenu!!.isShowing) {
//            iconMenu!!.dismiss()
//            return
//        }
//        iconMenu!!.showAsDropDown(view, -270, 0)
        Infodata(readUsingSharedPreference(this@MainActivity, "addpersmisson").toString())
    }

    override fun onBackPressed() {
//        if (iconMenu!!.isShowing) {
//            iconMenu!!.dismiss()
//        } else {
//            super.onBackPressed()
//        }
        super.onBackPressed()
    }
    var backPressedTime: Long = 0
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            when (supportFragmentManager.findFragmentById(R.id.fragment_container)) {
                is HomeFragment -> {
                  /*  if (backPressedTime + 3000 > System.currentTimeMillis()) {
                        ExitDialog()
                    } else {
                        Toast.makeText(this, "Press back again to leave the app.", Toast.LENGTH_LONG).show()
                    }
                    backPressedTime = System.currentTimeMillis()*/
//                    if (currentPosition == 0) {
//
//                    }
                    ExitDialog()
                }
                else -> {
                    supportFragmentManager.popBackStack()
                }
            }
        }

        return super.onKeyDown(keyCode, event)
    }

    fun onDrawerMyDiaryClick(view: View) {
        if (binding.drawer.layMyDiary.root.visibility == VISIBLE) {
            binding.drawer.layDealsDiscount.root.visibility = GONE
            binding.drawer.layMyDiary.root.visibility = GONE
            binding.drawer.ivDropDownDiary.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.ic_drop_down, null))
            binding.drawer.ivDropDownDeals.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.ic_drop_down, null))
        } else {
            binding.drawer.layDealsDiscount.root.visibility = GONE
            binding.drawer.layMyDiary.root.visibility = VISIBLE
            binding.drawer.ivDropDownDiary.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.ic_drop_up, null))
            binding.drawer.ivDropDownDeals.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.ic_drop_down, null))
        }
    }

    fun onDrawerDealsDiscount(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        displayToast(this, "Coming Soon..")
        if (binding.drawer.layDealsDiscount.root.visibility == VISIBLE) {
            binding.drawer.layDealsDiscount.root.visibility = GONE
            binding.drawer.layMyDiary.root.visibility = GONE
            binding.drawer.ivDropDownDiary.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.ic_drop_down,
                    null
                )
            )
            binding.drawer.ivDropDownDeals.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.ic_drop_down,
                    null
                )
            )
        } else {
            binding.drawer.layDealsDiscount.root.visibility = GONE
            binding.drawer.layMyDiary.root.visibility = GONE
            binding.drawer.ivDropDownDiary.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.ic_drop_down,
                    null
                )
            )
            binding.drawer.ivDropDownDeals.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.ic_drop_up,
                    null
                )
            )
        }
    }

    fun onHomeClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        //binding.vpHome.currentItem = 0
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("hometype", "0")
        intent.putExtra("type", "hometype")
        intent.putExtra("position", "0")
        startActivity(intent)
    }


    fun onAllLeadsClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        //binding.vpHome.currentItem = 1
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("hometype", "1")
        intent.putExtra("type", "hometype")
        intent.putExtra("position", "0")
        startActivity(intent)
    }

    fun onAllPostsClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        //binding.vpHome.currentItem = 3
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("hometype", "3")
        intent.putExtra("type", "hometype")
        intent.putExtra("position", "0")
        startActivity(intent)
    }

    fun onMyRequirementsClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        startActivity(Intent(this, MyRequirementsActivity::class.java))
    }

    fun onMyBuddiesClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        startActivity(Intent(this, MyBuddiesActivity::class.java))
    }

    fun onMyGuestInvitesClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        startActivity(Intent(this, MyGuestInvitesActivity::class.java))
    }

    fun onMyBusinessClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        startActivity(Intent(this, MyBusinessTransactionsActivity::class.java))
    }

    fun onMyEventsClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        startActivity(Intent(this, MyEventsActivity::class.java))
    }

    fun onMyRewardsClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        startActivity(Intent(this, MyAwardRecognitionActivity::class.java))
    }

    fun onMyReportCardClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        startActivity(Intent(this, MyReportCardActivity::class.java))
    }

    fun onMyLeadsClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        val intent = Intent(this, MyLeadsActivity::class.java)
        intent.putExtra("type", "lead")
        startActivity(intent)
    }

    fun onPendingResponsibilitiesClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        val intent = Intent(this, PendingResponsibilitiesActivity::class.java)
        intent.putExtra("type", "0")
        startActivity(intent)
    }

    fun onMyTesimonialsClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        startActivity(Intent(this, MyTestimonialsActivity::class.java))
    }

    fun onMyMembershipClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        startActivity(Intent(this, MyMembershipBenefitsActivity::class.java))
    }

    fun onRecommendedByClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        val intent = Intent(this, RecommendedActivity::class.java)
        intent.putExtra("type", "by")
        startActivity(intent)
    }

    fun onRecommendedToClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        val intent = Intent(this, RecommendedActivity::class.java)
        intent.putExtra("type", "to")
        startActivity(intent)
    }

    fun onRecognitionClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        startActivity(Intent(this, MyRecognitionActivity::class.java))
    }

    fun onAllEventsClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
     /*   val intent = Intent(this, AllEventsActivity::class.java)
        intent.putExtra("ActivityName", "All Events")
        startActivity(intent)*/
        setBottomIconChange("5")
        ivEvent_badge.visibility=View.GONE
        loadFragment(AllEventsFragment(0), "All Events")
    }

    fun onEventsClick(view: View) {
        setBottomIconChange("5")
        ivEvent_badge.visibility=View.GONE
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        /*val intent = Intent(this, AllEventsActivity::class.java)
        intent.putExtra("ActivityName", "Events")
        startActivity(intent)*/
        storeUsingSharedPreference(this,"showupdate","no")
        loadFragment(AllEventsFragment(0), "All Events")
    }

    fun onAllRecognitionClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        val intent = Intent(this, MyRecognitionActivity::class.java)
        intent.putExtra("type", "all_recognition")
        startActivity(intent)
    }

    fun onJ4EMembersClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        val intent = Intent(this, J4EMembersActivity::class.java)
//        val intent = Intent(this, AllMembersActivity::class.java)
        intent.putExtra("position", "0")
        startActivity(intent)
    }

    fun onFeedbackClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        startActivity(Intent(this, J4ERatingandReviewActivity::class.java))
    }

    fun onTermsAndCondition(view: View){
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        startActivity(Intent(this, TermsAndConditionActivity::class.java))
    }

    fun onPrivacyPolicy(view: View){
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        startActivity(Intent(this, PrivacyAndPolicyActivity::class.java))
    }

    fun OnShareClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        try {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "J4E")
            var shareMessage = "\nLet me recommend you this application\n\n"
            shareMessage =
                """
                        ${shareMessage}https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}
                        
                        
                        """.trimIndent()
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
            startActivity(Intent.createChooser(shareIntent, "choose one"))
        } catch (e: Exception) {
            //e.toString();
        }
    }

    fun onAboutUsClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        startActivity(Intent(this, AboutUsActivity::class.java))
    }

    fun onSettingClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        startActivity(Intent(this, SettingActivity::class.java))
    }


    fun onViewProfileClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        startActivity(Intent(this, ProfileActivity::class.java))
    }

    fun onConnectionClick(view: View) {
        setBottomIconChange("1")
        ivConnection_badge.visibility=View.GONE
        storeUsingSharedPreference(this,"showupdate","no")
        loadFragment(MyConnectionsFragment(0,"fragment",0), "My Connection")
        //startActivity(Intent(this, MyConnectionsActivity::class.java))
    }


    fun onChatClick(view: View) {
//        setBottomIconChange("2")
//        storeUsingSharedPreference(this,"showupdate","no")
//        loadFragment(ChatListFragment(0), "MyChat")
        //startActivity(Intent(this, ChatListActivity::class.java))
    }

    fun setBottomIconChange(sType: String) {
        ivConnection.setImageResource(R.drawable.ic_connection_gray)
        ivChat.setImageResource(R.drawable.ic_chat_gray)
        ivHome.setImageResource(R.drawable.ic_home_gray)
        ivNotification.setImageResource(R.drawable.ic_notification_gray)
        ivEvent.setImageResource(R.drawable.ic_events_gray)

        /*ivEvent_badge.visibility=View.GONE
        ivNotification_badge.visibility=View.GONE
        ivConnection_badge.visibility=View.GONE
        ivChat_badge.visibility=View.GONE*/

        when (sType) {
            "1" -> {
                ivConnection.setImageResource(R.drawable.ic_connection_blue)
                 loadFragment(HomeFragment(0,0), "Home")
            }
            "2" -> {
                ivChat.setImageResource(R.drawable.ic_chat_blue)
                loadFragment(HomeFragment(0,0), "Home")
            }
            "3" -> {
                ivHome.setImageResource(R.drawable.ic_home_blue)
                loadFragment(HomeFragment(0,0), "Home")
            }
            "4" -> {
                ivNotification.setImageResource(R.drawable.ic_notification_blue)
                loadFragment(HomeFragment(0,0), "Home")
            }
            "5" -> {
                ivEvent.setImageResource(R.drawable.ic_events_blue)
            }
        }

    }

    fun onNotificationClick(view: View) {
        setBottomIconChange("4")
        ivNotification_badge.visibility=View.GONE
        storeUsingSharedPreference(this,"showupdate","no")
        loadFragment(NotificationFragment(), "Notification")
        //  startActivity(Intent(this, NotificationActivity::class.java))
    }



    override fun onResume() {
        super.onResume()
        //setBottomIconChange("3")
        if (intent.getStringExtra("type") == "hometype") {
            val datahometype = intent.getStringExtra("hometype")
            val position = intent.getStringExtra("position")
            loadFragment( HomeFragment(datahometype?.toInt()!!, position?.toInt()!!), "Home")
        }else if (intent.getStringExtra("type") == "ReceivedConnectionfragment") {
            setBottomIconChange("1")
            val position = intent.getStringExtra("position")
            ivConnection_badge.visibility=View.GONE
            loadFragment(MyConnectionsFragment(0,"fragment",position?.toInt()!!), "My Connection")
        }else if (intent.getStringExtra("type") == "SentConnectionfragment") {
            setBottomIconChange("1")
            val position = intent.getStringExtra("position")
            ivConnection_badge.visibility=View.GONE
            loadFragment(MyConnectionsFragment(1,"fragment",position?.toInt()!!), "My Connection")
        }else if (intent.getStringExtra("type") == "MyEvents") {
            val position = intent.getStringExtra("position")
            setBottomIconChange("5")
            ivEvent_badge.visibility=View.GONE
            loadFragment(AllEventsFragment(position?.toInt()!!), "All Events")
        }else if (intent.getStringExtra("type") == "notification") {
            setBottomIconChange("4")
            ivNotification_badge.visibility=View.GONE
            loadFragment(NotificationFragment(), "Notification")
        }else if (intent.getStringExtra("type") == "MyChat") {
//            val position = intent.getStringExtra("position")
//            setBottomIconChange("2")
//            loadFragment(ChatListFragment(position?.toInt()!!), "MyChat")
        }else{
            loadFragment(HomeFragment(0,0), "Home")
        }

        if(isInternetAvailable(this)) {
            app_get_notification_count()
        }

        //get all unread chats count
//        val chatsCount = RealmHelper.getInstance().unreadChatsCount.toInt()
//        if (chatsCount > 0) {
//            ivChat_badge.visibility=View.VISIBLE
//            ivChat_badge.text = chatsCount.toString()
//        }else{
//            ivChat_badge.visibility=View.GONE
//        }

        app_check_permissions()
    }

    override fun onStart() {
        super.onStart()
        app_check_permissions()
    }

    fun onTopRankingClick(view: View) {
        startActivity(Intent(this, TopRankingActivity::class.java))
    }

    fun abd(response: Response<J4EMember>){

    }
    fun onMyGroupClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        // startActivity(Intent(this, MyGroupActivity::class.java))
        //requestPermissions()

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("type", "MyChat")
        intent.putExtra("position", "1")
        startActivity(intent)
    }

    // chat code

    private fun requestPermissions() {

        Getdata()
    }

//    private val setupUserUseCase: SetupUserUseCase by lazy {
//        SetupUserUseCase()
//    }

    fun Getdata() {
        showLoader(this)
        val ownerst: String = "+91"+readUsingSharedPreference(this, "mobile").toString()
        databaseReference = FirebaseDatabase.getInstance().reference
        val query: Query = databaseReference!!.child("users").orderByChild("phone").equalTo(ownerst)
        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    dismissLoader()
                    // dataSnapshot is the "issue" node with all children with id 0
                    for (dataSnapshot1 in dataSnapshot.children) {
                        // do something with the individual "issues"
                        val usersBean: Userlist = dataSnapshot1.getValue(Userlist::class.java)!!
                        StaticConfig.UID = dataSnapshot1.key
                        val hashUser: HashMap<String, String> = dataSnapshot1.value as HashMap<String,String>
                        usersBean.userName = hashUser.get("name")
                        usersBean.photo = hashUser.get("photo")
                        usersBean.phone = hashUser.get("phone")
                        usersBean.thumbImg = hashUser.get("thumbImg")
                        usersBean.status = hashUser.get("status")
                        usersBean.appVer = hashUser.get("ver")
                        StaticConfig.phonenumber = hashUser.get("phone")

                        storeUsingSharedPreference(this@MainActivity,
                            "UidK",dataSnapshot1.key
                        )

//                        SharedPreferencesManager.setAgreedToPrivacyPolicy(true)
//                        SharedPreferencesManager.saveMyPhoto(hashUser.get("photo") as String)
//                        SharedPreferencesManager.saveMyThumbImg(hashUser.get("thumbImg") as String)
//                        SharedPreferencesManager.saveMyUsername(hashUser.get("name") as String)
//                        SharedPreferencesManager.savePhoneNumber(hashUser.get("phone") as String)
//                        SharedPreferencesManager.saveMyStatus(hashUser.get("status") as String)
//                        SharedPreferencesManager.setAppVersionSaved(true)
//                        SharedPreferencesManager.saveCountryCode("IN")
//                        RealmHelper.getInstance().saveObjectToRealm(
//                            CurrentUserInfo(
//                                StaticConfig.UID,
//                                StaticConfig.phonenumber
//                            )
//                        )
//                        SharedPreferencesManager.setUserInfoSaved(true)
                    }
                } else {
                    dismissLoader()
                    //displayToast(this@MainActivity,"User not found")
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                dismissLoader()
            }
        })
    }

    // chat code

    private fun startServices() {
//        if (!BuildVerUtil.isOreoOrAbove()) {
//            startService(Intent(this, NetworkService::class.java))
//            startService(Intent(this, InternetConnectedListener::class.java))
//            startService(Intent(this, FCMRegistrationService::class.java))
//
//        } else {
//            if (!SharedPreferencesManager.isTokenSaved())
//                SaveTokenJob.schedule(this, null)
//
//            SetLastSeenJob.schedule(this)
//            UnProcessedJobs.process(this)
//        }


        //sync contacts for the first time
//        if (!SharedPreferencesManager.isContactSynced()) {
//            ContactUtils.fetchData()
//            if(isInternetAvailable(this)) {
//                getGroupList()
//            }
//        } else {
//            //sync contacts every day if needed
//            if (SharedPreferencesManager.needsSyncContacts()) {
//                ContactUtils.fetchData()
//                if(isInternetAvailable(this)) {
//                    getGroupList()
//                }
//            }
//        }

        //schedule daily job to backup messages
//        DailyBackupJob.schedule()
//
//        StickerLoader(this).loadStickersIntoFilesDir()

//        if (!SharedPreferencesManager.isDeviceIdSaved()) {
//            Getdata()
//            viewModel.saveDeviceId()
//        }

    }

    private fun syncContacts() {
      /*  disposables.add(ContactUtils.syncContacts().subscribe({

        }, { throwable ->

        }))*/
    }

//    private fun listenForDeviceIdChange() {
//        FireConstants.deviceIdRef.child(FireManager.uid).observeValueEvent()
//            .subscribe { dataSnapshot ->
//                if (dataSnapshot.value != null && (dataSnapshot.value as? String) != DeviceId.id) {
//                   // startLoggedOutActivity()
//                   // FireManager.logout()
//                   // NotificationHelper(this@MainActivity).fireUserLoggedOutNotification()
//                    finish()
//                } else {
//                }
//            }.addTo(disposables)
//    }



//    private fun showBatteryOptimizationDialog() {
//
//        ignoreBatteryDialog = IgnoreBatteryDialog(this, R.style.AlertDialogTheme)
//
//        ignoreBatteryDialog?.setOnDialogClickListener(object :
//            IgnoreBatteryDialog.OnDialogClickListener {
//
//            override fun onCancelClick(checkBoxChecked: Boolean) {
//                SharedPreferencesManager.setDoNotShowBatteryOptimizationAgain(checkBoxChecked)
//            }
//
//            override fun onDismiss(checkBoxChecked: Boolean) {
//                SharedPreferencesManager.setDoNotShowBatteryOptimizationAgain(checkBoxChecked)
//            }
//
//            override fun onOk() {
//                try {
//                    val intent = Intent()
//                    intent.action = Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS
//                    startActivity(intent)
//                } catch (e: Exception) {
//                    Toast.makeText(
//                        this@MainActivity,
//                        "could not open Battery Optimization Settings",
//                        Toast.LENGTH_SHORT
//                    ).show();
//                }
//            }
//        })
//        ignoreBatteryDialog?.show()
//    }


    private fun app_get_notification_count(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_notification_count(readUsingSharedPreference(this, "userid").toString())
        //showLoader(this);
        call.enqueue(object : Callback<CountBubble> {
            override fun onResponse(
                call: Call<CountBubble>,
                response: Response<CountBubble>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {

                            val Connection:Int=
                                response.body()?.data?.connection_receive_count?.toInt()!! + response.body()?.data?.connection_sent_count?.toInt()!!

                            if(Connection.toString()==readUsingSharedPreference(this@MainActivity, "ConnectionCountOld").toString()){
                                    ivConnection_badge.visibility=View.GONE
                                }else{
                                ivConnection_badge.visibility=View.VISIBLE
                                val Connectionc:Int=Connection - readUsingSharedPreference(this@MainActivity, "ConnectionCountOld")?.toInt()!!

                                if(Connectionc > 99){
                                    ivConnection_badge.text = "+99"
                                }else if(Connectionc < 1){
                                    ivConnection_badge.visibility=View.GONE
                                }else {
                                    ivConnection_badge.text = Connectionc.toString().replace("-","")
                                }
                            }

                            if(response.body()?.data?.event_count.toString()==readUsingSharedPreference(this@MainActivity, "eventCountOld").toString()) {
                                ivEvent_badge.visibility=View.GONE
                            }else{
                                ivEvent_badge.visibility=View.VISIBLE
                                val Eventcount:Int=response.body()?.data?.event_count?.toInt()!! - readUsingSharedPreference(this@MainActivity, "eventCountOld")?.toInt()!!
                                if(Eventcount > 99) {
                                    ivEvent_badge.text = "+99"
                                }else if(Eventcount < 1){
                                    ivEvent_badge.visibility=View.GONE
                                }else{
                                    ivEvent_badge.text = Eventcount.toString().replace("-","")
                                }
                            }

//                            val chatsCount = RealmHelper.getInstance().unreadChatsCount.toInt()
//
//                            if (chatsCount > 0) {
//                                ivChat_badge.visibility=View.VISIBLE
//                                ivChat_badge.text = chatsCount.toString()
//                            }else{
//                                ivChat_badge.visibility=View.GONE
//                            }

                            if(response.body()?.data?.notificat_count.toString().equals(readUsingSharedPreference(this@MainActivity, "notificatCountOld").toString())) {
                                ivNotification_badge.visibility=View.GONE
                            }else{
                                ivNotification_badge.visibility=View.VISIBLE
                                val Notificatcount:Int=response.body()?.data?.notificat_count?.toInt()!! - readUsingSharedPreference(this@MainActivity, "notificatCountOld")?.toInt()!!
                                if(Notificatcount > 99) {
                                    ivNotification_badge.text = "+99"
                                }else if(Notificatcount < 1){
                                    ivNotification_badge.visibility=View.GONE
                                }else{
                                    ivNotification_badge.text = Notificatcount.toString().replace("-","")
                                }
                            }

                            storeUsingSharedPreference(
                                this@MainActivity,
                                "PostCountnew",response.body()?.data?.post_count.toString()
                            )

                            storeUsingSharedPreference(
                                this@MainActivity,
                                "LeadCountnew",response.body()?.data?.lead_count.toString()
                            )

                            storeUsingSharedPreference(
                                this@MainActivity,
                                "BuddyCountnew",response.body()?.data?.buddy_count.toString()
                            )

                            storeUsingSharedPreference(
                                this@MainActivity,
                                "addpersmisson",response.body()?.data?.add_permission.toString()
                            )

                            addpersmission=response.body()?.data?.add_permission.toString()

                            readUsingSharedPreference(this@MainActivity, "addpersmisson")

                            if(addpersmission.toString().equals("1")) {

                                //iconMenu = PowerMenuUtils.getIconPowerMenu(this@MainActivity, this@MainActivity, onIconMenuItemClickListener)
                                //Infodata(addpersmission.toString())
                            } else{
                                //iconMenu = PowerMenuUtils.getIconPowerMenu2(this@MainActivity, this@MainActivity, onIconMenuItemClickListener)
                                //Infodata(addpersmission.toString())
                            }

                        }
                    } else {

                    }
                }
                app_check_validity()
            }

            override fun onFailure(call: Call<CountBubble>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    private fun getGroupList(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_groups(readUsingSharedPreference(this, "userid").toString())
      //  showLoader(this);
        call.enqueue(object : Callback<GroupsList> {
            override fun onResponse(
                call: Call<GroupsList>,
                response: Response<GroupsList>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data != null) {
                            for (j in 0 until response.body()?.data!!.size) {
                                val groupId = response.body()?.data?.get(j)?.group_uid
//                                if (!RealmHelper.getInstance().isChatStored(groupId)) {
//                                    val pendingGroupJob = PendingGroupJob(groupId, PendingGroupTypes.CREATION_EVENT, null)
//                                    RealmHelper.getInstance().saveObjectToRealm(pendingGroupJob)
//                                    ServiceHelper.fetchAndCreateGroup(this@MainActivity, groupId)
//                                }
                            }


                        }
                    } else {

                    }
                }
            }

            override fun onFailure(call: Call<GroupsList>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    private fun ExitDialog(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mbsAddAccountDialog: MainexitDialogBinding = DataBindingUtil.inflate(LayoutInflater.from(this),R.layout.mainexit_dialog, null, false)
        dialog.setContentView(mbsAddAccountDialog.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        mbsAddAccountDialog.No.setOnClickListener {
            dialog.dismiss()
        }

        mbsAddAccountDialog.yes.setOnClickListener {
            finishAffinity()

        }


    }

    private fun Planexpaireddialog(massage:String){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mbsAddAccountDialog: PlanexpaireddialogBinding = DataBindingUtil.inflate(LayoutInflater.from(this),R.layout.planexpaireddialog, null, false)
        dialog.setContentView(mbsAddAccountDialog.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        mbsAddAccountDialog.massage.setText(massage)

        mbsAddAccountDialog.okbtd.setOnClickListener {
            if(readUsingSharedPreference(this@MainActivity, "signup_source").toString()=="api") {
                showLoader(this@MainActivity)
                cleareUsingSharedPreference(this@MainActivity)
                startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                finish()
                dismissLoader()
            }else if(readUsingSharedPreference(this@MainActivity, "signup_source").toString()=="google"){
                googleSignOut()
                showLoader(this@MainActivity)
                cleareUsingSharedPreference(this@MainActivity)
                startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                finish()
                dismissLoader()
            }else if(readUsingSharedPreference(this@MainActivity, "signup_source").toString()=="facebook"){
                facebookSignOut()
                showLoader(this@MainActivity)
                cleareUsingSharedPreference(this@MainActivity)
                startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                finish()
                dismissLoader()
            }else if(readUsingSharedPreference(this@MainActivity, "signup_source").toString()=="linkdin"){
                // linkedinSignOut()
                showLoader(this@MainActivity)
                cleareUsingSharedPreference(this@MainActivity)
                startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                finish()
                dismissLoader()
            }else{
                showLoader(this@MainActivity)
                cleareUsingSharedPreference(this@MainActivity)
                startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                finish()
                dismissLoader()
            }

            val sharedPreferences: SharedPreferences =getSharedPreferences("FragAllBuddiesBinding", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()

            val sharedPreferences1: SharedPreferences =getSharedPreferences("J4EMembersActivity", Context.MODE_PRIVATE)
            val editor1 = sharedPreferences1.edit()
            editor1.clear()
            editor1.apply()

            val sharedPreferences2: SharedPreferences =getSharedPreferences("AllEventsFragment", Context.MODE_PRIVATE)
            val editor2 = sharedPreferences2.edit()
            editor2.clear()
            editor2.apply()

            val sharedPreferences3: SharedPreferences =getSharedPreferences("MyBusniessActivity", Context.MODE_PRIVATE)
            val editor3 = sharedPreferences3.edit()
            editor3.clear()
            editor3.apply()

            val sharedPreferences4: SharedPreferences =getSharedPreferences("MyBuddiesActivity", Context.MODE_PRIVATE)
            val editor4 = sharedPreferences4.edit()
            editor4.clear()
            editor4.apply()


//            SharedPreferencesManager.setUserInfoSaved(false)
//            SharedPreferencesManager.setTokenSaved(false)
//            SharedPreferencesManager.setContactSynced(false)
//            RealmHelper.getInstance().deleteRealm()

        }

        dialog.show()
    }

    private fun app_check_validity(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_check_validity(readUsingSharedPreference(this, "mobile").toString())
        //showLoader(this);
        call.enqueue(object : Callback<PlanValidity> {
            override fun onResponse(
                call: Call<PlanValidity>,
                response: Response<PlanValidity>
            ) {
                dismissLoader();
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {

                    } else {
                        if (response.body()?.messageData?.result == false) {

                             Planexpaireddialog(response.body()?.messageData?.message.toString())
                        }

                    }
                }
            }

            override fun onFailure(call: Call<PlanValidity>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    private fun app_check_permissions(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_home_screen_permission(readUsingSharedPreference(this, "userid").toString())
        //showLoader(this);
        call.enqueue(object : Callback<PermissionsResponse> {
            override fun onResponse(
                call: Call<PermissionsResponse>,
                response: Response<PermissionsResponse>
            ) {

                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        if (response.body()?.data?.permissions?.size!=0){
                            for (i in 0 until response.body()?.data?.permissions?.size!!) {
                                is_post_exhausted=response.body()?.data?.is_post_exhausted!!
                                is_requirement_exhausted=response.body()?.data?.is_requirement_exhausted!!
                                is_buddy_meet_exhausted=response.body()?.data?.is_buddy_meet_exhausted!!
                                is_referral_exhausted=response.body()?.data?.is_buddy_meet_exhausted!!
                                storeUsingSharedPreference(this@MainActivity,"ViewPermissionMsg",response.body()?.data?.view_permission_msg)
                                storeUsingSharedPreference(this@MainActivity,"CreatePermissionMsg",response.body()?.data?.create_permission_msg)
                                storeUsingSharedPreference(this@MainActivity,"ViewExhaustedMsg",response.body()?.data?.view_exhausted_msg)
                                storeUsingSharedPreference(this@MainActivity,"CreateExhaustedMsg",response.body()?.data?.create_exhausted_msg)
                                if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("1")){
                                    storeUsingSharedPreference(this@MainActivity,"PermissionCreatePost",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("2")){
                                    storeUsingSharedPreference(this@MainActivity,"PermissionCreateRequirement",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("3")){
                                    storeUsingSharedPreference(this@MainActivity,"PermissionCreateBuddyMeet",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("4")){
                                    storeUsingSharedPreference(this@MainActivity,"PermissionCreateFollowUp",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("5")){
                                    storeUsingSharedPreference(this@MainActivity,"PermissionCreateAddGalleryImage",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("6")){
                                    storeUsingSharedPreference(this@MainActivity,"PermissionConnectionRequest",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("7")){
                                    storeUsingSharedPreference(this@MainActivity,"PermissionCreateRecommendation",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("8")){
                                    storeUsingSharedPreference(this@MainActivity,"PermissionReview",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("9")){
                                    storeUsingSharedPreference(this@MainActivity,"PermissionViewJ4EmemberProfile",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("10")){
                                    storeUsingSharedPreference(this@MainActivity,"PermissionViewLeads",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }else if (response.body()?.data?.permissions?.get(i)?.feature_id.equals("11")){
                                    storeUsingSharedPreference(this@MainActivity,"PermissionCreateReferral",response.body()?.data?.permissions?.get(i)?.is_allowed)
                                }
                            }
                        }else{
                            storeUsingSharedPreference(this@MainActivity,"PermissionCreatePost","0")
                            storeUsingSharedPreference(this@MainActivity,"PermissionCreateRequirement","0")
                            storeUsingSharedPreference(this@MainActivity,"PermissionCreateBuddyMeet","0")
                            storeUsingSharedPreference(this@MainActivity,"PermissionCreateFollowUp","0")
                            storeUsingSharedPreference(this@MainActivity,"PermissionCreateAddGalleryImage","0")
                            storeUsingSharedPreference(this@MainActivity,"PermissionConnectionRequest","0")
                            storeUsingSharedPreference(this@MainActivity,"PermissionCreateRecommendation","0")
                            storeUsingSharedPreference(this@MainActivity,"PermissionReview","0")
                            storeUsingSharedPreference(this@MainActivity,"PermissionViewJ4EmemberProfile","0")
                            storeUsingSharedPreference(this@MainActivity,"PermissionViewLeads","0")
                            storeUsingSharedPreference(this@MainActivity,"PermissionCreateReferral","0")

                        }
                    } else {

                    }
                }
            }

            override fun onFailure(call: Call<PermissionsResponse>, t: Throwable) {
                dismissLoader();
            }
        })

    }

    private fun PermissionDialog(massage:String){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        val mbsAddAccountDialog: PlanexpaireddialogBinding = DataBindingUtil.inflate(LayoutInflater.from(this),R.layout.planexpaireddialog, null, false)
        dialog.setContentView(mbsAddAccountDialog.root)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


        mbsAddAccountDialog.massage.setText(massage)

        mbsAddAccountDialog.okbtd.setOnClickListener {
            dialog.dismiss()
        }
        mbsAddAccountDialog.txtUpgrade.setOnClickListener {
            dialog.dismiss()
            startActivity(Intent(this, MyMembershipBenefitsActivity::class.java))
        }
        dialog.show()
    }

    private fun get_payment_key(){
        val request = ServiceBuilder.buildService(APIinterface::class.java)
        val call = request.app_get_payment_details()
        //showLoader(this);
        call.enqueue(object : Callback<PaymentDetailsResponse> {
            override fun onResponse(
                call: Call<PaymentDetailsResponse>,
                response: Response<PaymentDetailsResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body()?.status == true) {
                        storeUsingSharedPreference(this@MainActivity,"razorpay_key",response.body()?.data?.razorpay_key)
                        storeUsingSharedPreference(this@MainActivity,"razorpay_secret",response.body()?.data?.razorpay_secret)
                    } else {

                    }
                }
            }
            override fun onFailure(call: Call<PaymentDetailsResponse>, t: Throwable) {
                dismissLoader();
            }
        })
    }

    fun onMyReferralsGivenClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        startActivity(Intent(this, ReferralGivenActivity::class.java))
    }
    fun onMyReferralsReceivedClick(view: View) {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        startActivity(Intent(this, ReferralReceivedActivity::class.java))
    }

    fun Infodata(permission:String){
        val dialog = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
        val  mBinding: BmCreateBinding = DataBindingUtil.inflate(
            LayoutInflater.from(this), R.layout.bm_create, null, false)
        dialog.setCancelable(true)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setContentView(mBinding.root)
        dialog.show()
        mBinding.ivcancle.setOnClickListener {
            dialog.dismiss()
        }

        if (permission.equals("1")){
            mBinding.linearlayoutMenu1.visibility=View.VISIBLE
            mBinding.linearlayoutMenu2.visibility=View.GONE
        }else{
            mBinding.linearlayoutMenu2.visibility=View.VISIBLE
            mBinding.linearlayoutMenu1.visibility=View.GONE
        }

        mBinding.linearlayoutCreateReq.setOnClickListener {
            if (readUsingSharedPreference(this,"PermissionCreateRequirement").equals("0")){
                PermissionDialog(readUsingSharedPreference(this,"CreatePermissionMsg").toString())
            }else{
                if (is_requirement_exhausted==0){
                    startActivity(Intent(this, CreateRequirementActivity::class.java))
                }else{
                    PermissionDialog(readUsingSharedPreference(this,"CreateExhaustedMsg").toString())
                }
            }
        }

        mBinding.linearlayoutCreateReq1.setOnClickListener {
            if (readUsingSharedPreference(this,"PermissionCreateRequirement").equals("0")){
                PermissionDialog(readUsingSharedPreference(this,"CreatePermissionMsg").toString())
            }else{
                if (is_requirement_exhausted==0){
                    startActivity(Intent(this, CreateRequirementActivity::class.java))
                }else{
                    PermissionDialog(readUsingSharedPreference(this,"CreateExhaustedMsg").toString())
                }
            }
        }

        mBinding.linearlayoutCreateEvent.setOnClickListener {
            startActivity(Intent(this, CreateEventsActivity::class.java))
        }

        mBinding.linearlayoutCreatePost.setOnClickListener {
            if (readUsingSharedPreference(this,"PermissionCreatePost").equals("0")){
                PermissionDialog(readUsingSharedPreference(this,"CreatePermissionMsg").toString())
            }else{
                if (is_post_exhausted==0){
                    startActivity(Intent(this, CreatePostsActivity::class.java))
                }else{
                    PermissionDialog(readUsingSharedPreference(this,"CreateExhaustedMsg").toString())
                }
            }
        }

        mBinding.linearlayoutCreatePost1.setOnClickListener {
            if (readUsingSharedPreference(this,"PermissionCreatePost").equals("0")){
                PermissionDialog(readUsingSharedPreference(this,"CreatePermissionMsg").toString())
            }else{
                if (is_post_exhausted==0){
                    startActivity(Intent(this, CreatePostsActivity::class.java))
                }else{
                    PermissionDialog(readUsingSharedPreference(this,"CreateExhaustedMsg").toString())
                }
            }
        }

        mBinding.linearlayoutCreateDeal.setOnClickListener {
            displayToast(this, "Coming Soon..")
        }

        mBinding.linearlayoutCreateDeal1.setOnClickListener {
            displayToast(this, "Coming Soon..")
        }

        mBinding.linearlayoutCreateBuddyMeet.setOnClickListener {
            if (readUsingSharedPreference(this,"PermissionCreateBuddyMeet").equals("0")){
                PermissionDialog(readUsingSharedPreference(this,"CreatePermissionMsg").toString())
            }else{
                if (is_buddy_meet_exhausted==0){
                    startActivity(Intent(this, CreateBuddyMeetActivity::class.java))
                }else{
                    PermissionDialog(readUsingSharedPreference(this,"CreateExhaustedMsg").toString())
                }
            }
        }

        mBinding.linearlayoutCreateBuddyMeet1.setOnClickListener {
            if (readUsingSharedPreference(this,"PermissionCreateBuddyMeet").equals("0")){
                PermissionDialog(readUsingSharedPreference(this,"CreatePermissionMsg").toString())
            }else{
                if (is_buddy_meet_exhausted==0){
                    startActivity(Intent(this, CreateBuddyMeetActivity::class.java))
                }else{
                    PermissionDialog(readUsingSharedPreference(this,"CreateExhaustedMsg").toString())
                }
            }
        }

        mBinding.linearlayoutCreateOfflineBusiness.setOnClickListener {
            startActivity(Intent(this, CreateOfflineBusinessActivity::class.java))
        }

        mBinding.linearlayoutCreateOfflineBusiness1.setOnClickListener {
            startActivity(Intent(this, CreateOfflineBusinessActivity::class.java))
        }

        mBinding.linearlayoutCreateReferral.setOnClickListener {
            if (readUsingSharedPreference(this,"PermissionCreateReferral").equals("0")){
                PermissionDialog(readUsingSharedPreference(this,"CreatePermissionMsg").toString())
            }else{
                if (is_referral_exhausted==0){
                    startActivity(Intent(this, CreateReferralActivity::class.java))
                }else{
                    PermissionDialog(readUsingSharedPreference(this,"CreateExhaustedMsg").toString())
                }
            }
        }

        mBinding.linearlayoutCreateReferral1.setOnClickListener {
            if (readUsingSharedPreference(this,"PermissionCreateReferral").equals("0")){
                PermissionDialog(readUsingSharedPreference(this,"CreatePermissionMsg").toString())
            }else{
                if (is_referral_exhausted==0){
                    startActivity(Intent(this, CreateReferralActivity::class.java))
                }else{
                    PermissionDialog(readUsingSharedPreference(this,"CreateExhaustedMsg").toString())
                }
            }
        }
    }


}