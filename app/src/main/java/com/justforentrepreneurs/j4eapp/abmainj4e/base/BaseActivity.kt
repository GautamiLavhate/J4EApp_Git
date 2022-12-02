package com.justforentrepreneurs.j4eapp.abmainj4e.base

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.justforentrepreneurs.j4eapp.abmainj4e.data.DataManager
import com.justforentrepreneurs.j4eapp.abmainj4e.listener.AuthListener
import com.justforentrepreneurs.j4eapp.abmainj4e.network.api.ApiService
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.storeUsingSharedPreference
import com.facebook.*
import com.facebook.internal.CallbackManagerImpl
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.justforentrepreneurs.j4eapp.Base
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.readUsingSharedPreference
//import com.justforentrepreneurs.j4eapp.extensions.observeChildEvent
//import com.justforentrepreneurs.j4eapp.extensions.setValueRx
//import com.justforentrepreneurs.j4eapp.extensions.toMap
//import com.justforentrepreneurs.j4eapp.model.constants.DBConstants
//import com.justforentrepreneurs.j4eapp.utils.*
//import com.justforentrepreneurs.j4eapp.utils.MyApp.Companion.context
//import com.justforentrepreneurs.j4eapp.utils.enc.DecryptionHelper
//import com.justforentrepreneurs.j4eapp.utils.enc.MessageDecryptor
//import com.justforentrepreneurs.j4eapp.utils.network.FireManager
//import com.justforentrepreneurs.j4eapp.utils.update.UpdateChecker
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.lay_bottom_bar.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONException
import org.koin.android.ext.android.get


abstract class BaseActivity : AppCompatActivity(), Base {

    override val disposables = CompositeDisposable()

    private val tag = BaseActivity::class.java.simpleName
    protected val dataManager: DataManager = get()
    protected val apiService: ApiService = get()
    private lateinit var authListener: AuthListener
    private lateinit var googleSignInClient: GoogleSignInClient
    private val googleSignInRequestCode = 909
    private lateinit var facebookCallbackManager: CallbackManager

    protected fun loginWithGoogle() {
        val googleSignInOption = GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()



        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOption)
        val googleSignInIntent = googleSignInClient.signInIntent
        startActivityForResult(googleSignInIntent, googleSignInRequestCode)
    }

    protected fun loginWithFacebook(listener: AuthListener) {
        FacebookSdk.sdkInitialize(applicationContext)
        facebookCallbackManager = CallbackManager.Factory.create()
        facebookCallbackManager = CallbackManager.Factory.create()
        LoginManager.getInstance().logInWithReadPermissions(this, listOf("public_profile", "email"))
        LoginManager.getInstance().registerCallback(facebookCallbackManager, object :
            FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                val request =
                    GraphRequest.newMeRequest(loginResult.accessToken) { `object`, response ->
                        try {
                            val hashMap: HashMap<String, String> = HashMap<String, String>()
                            authListener = listener
                            hashMap["firstName"] =
                                `object`.getString("name").split("\\s".toRegex())[0].trim()
                            hashMap["lastName"] =
                                `object`.getString("name").split("\\s".toRegex())[1].trim()
                            try {
                                hashMap["email"] = `object`.getString("email")
                            } catch (e: JSONException) {
                                e.printStackTrace()
                            }
                            hashMap["socialId"] = `object`.getString("id").toString()
                            hashMap["photoUrl"] =
                                `object`.getJSONObject("picture").getJSONObject("data")
                                    .getString("url")
                            authListener.authData("facebook", hashMap)
                            storeUsingSharedPreference(
                                this@BaseActivity,
                                "signup_source","facebook"
                            )
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                val parameters = Bundle()
                parameters.putString("fields", "name,email,id,picture.type(large)")
                request.parameters = parameters
                request.executeAsync()
            }

            override fun onCancel() {
                Log.d(tag, "Facebook onCancel.")
            }

            override fun onError(error: FacebookException) {
                Log.d(tag, "Facebook onError ${error.message}")
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == googleSignInRequestCode ) {
            try {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                val googleSignInAccount = task.getResult(ApiException::class.java)
                val hashMap: HashMap<String, String> = HashMap<String, String>()
                authListener = this as AuthListener
                hashMap["firstName"] =
                    googleSignInAccount?.displayName!!.split("\\s".toRegex())[0].trim()
                hashMap["lastName"] =
                    googleSignInAccount.displayName!!.split("\\s".toRegex())[1].trim()
                hashMap["email"] = googleSignInAccount.email.toString()
                hashMap["socialId"] = googleSignInAccount.id.toString()
                hashMap["photoUrl"] = googleSignInAccount.photoUrl.toString()
                authListener.authData("google", hashMap)
                storeUsingSharedPreference(
                    this@BaseActivity,
                    "signup_source","google"
                )
            } catch (apiException: ApiException) {
                Log.d(tag, "Google sign in failed ${apiException.message}")
            }

        } else if (requestCode == CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode() && resultCode == Activity.RESULT_OK) {
            facebookCallbackManager.onActivityResult(requestCode, resultCode, data)
        }
    }

    protected fun googleSignOut() {
        val googleSignInOption = GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()



        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOption)
        googleSignInClient.signOut().addOnCompleteListener(OnCompleteListener {
            Log.d(tag, "Google Sign out Successfully")
        })

    }

    protected fun facebookSignOut() {
        if (AccessToken.getCurrentAccessToken() != null) {
            GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/me/permissions/",
                null,
                HttpMethod.DELETE,
                GraphRequest.Callback {
                    AccessToken.setCurrentAccessToken(null)
                    LoginManager.getInstance().logOut()
                    Log.d(tag, "Facebook Sign out Successfully")
                }).executeAsync()
        }
    }

    fun onBackClick(view: View) {
        finish()
    }

    // chat

    abstract fun enablePresence(): Boolean
//    private var presenceUtil: PresenceUtil? = null
//    val fireManager = FireManager()
//    private lateinit var newMessageHandler: NewMessageHandler
//
//    private var logoutReceiver: BroadcastReceiver? = null
//
//
//
//    private var needsUpdate = false
//
//    private val decryptionHelper: DecryptionHelper by lazy {
//        DecryptionHelper()
//    }
//
//    private val messageDecryptor: MessageDecryptor by lazy {
//        MessageDecryptor(decryptionHelper)
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        needsUpdate = UpdateChecker(this).needsUpdate()
//        if (!needsUpdate) {
//
//            if (enablePresence())
//                if (readUsingSharedPreference(context(), "loginStatus").toString() == "true") {
//                    presenceUtil = PresenceUtil()
//                }
//
//            newMessageHandler = NewMessageHandler(this, fireManager, messageDecryptor, disposables)
//            //if user is coming from an old version, then delete the already received messages from his db
//            if (SharedPreferencesManager.isDeletedUnfetchedMessage()) {
//                attachNewMessageListener()
//                attachDeletedMessageListener()
//                attachNewGroupListener()
//            }
//        }

        /*logoutReceiver = object : BroadcastReceiver() {
            override fun onReceive(p0: Context?, p1: Intent?) {
                //startLoggedOutActivity()
            }
        }*/
    }


    override fun onStart() {
        super.onStart()
//        if (needsUpdate) {
//
//        }

    }


    override fun onStop() {
        super.onStop()

       /* logoutReceiver?.let {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(it)
        }*/
    }



//    private fun attachNewGroupListener() {
//        FireConstants.newGroups.child(FireManager.uid).observeChildEvent().subscribe({ snap ->
//            val dataSnapshot = snap.value
//
//            if (dataSnapshot.value != null) {
//                (dataSnapshot.child(DBConstants.GROUP_ID).value as? String)?.let { groupId ->
//                    newMessageHandler.handleNewGroup(dataSnapshot.toMap())
//
//                    deleteNewGroupEvent(groupId).subscribe().addTo(disposables)
//
//                }
//            }
//
//
//        }, { error -> }).addTo(disposables)
//    }

//    private fun attachDeletedMessageListener() {
//        FireConstants.deletedMessages.child(FireManager.uid).observeChildEvent().subscribe({ snap ->
//            val dataSnapshot = snap.value
//
//            if (dataSnapshot.value != null) {
//                (dataSnapshot.child(DBConstants.MESSAGE_ID).value as? String)?.let { messageId ->
//                    newMessageHandler.handleDeletedMessage(dataSnapshot.toMap())
//
//                    deleteDeletedMessage(messageId).subscribe().addTo(disposables)
//
//                }
//            }
//
//
//        }, { error -> }).addTo(disposables)
//    }


//    private fun attachNewMessageListener() {
//        FireConstants.userMessages.child(FireManager.uid).observeChildEvent().subscribe({ snap ->
//            val dataSnapshot = snap.value
//            if (dataSnapshot.value != null) {
//                (dataSnapshot.child(DBConstants.MESSAGE_ID).value as? String)?.let { messageId ->
//                    val phone = dataSnapshot.child(DBConstants.PHONE).value as? String ?: ""
//                    val USERNAME = dataSnapshot.child(DBConstants.USERNAME).value as? String ?: ""
//                    val message = MessageMapper.mapToMessage(dataSnapshot)
//                    lifecycleScope.launch(Dispatchers.Main) {
//                        try {
//                            newMessageHandler.handleNewMessage(phone, message,USERNAME)
//
//                            val chatsCount = RealmHelper.getInstance().unreadChatsCount.toInt()
//                            if (chatsCount > 0) {
//                                ivChat_badge.visibility=View.VISIBLE
//                                ivChat_badge.text = chatsCount.toString()
//                            }else{
//                                ivChat_badge.visibility=View.GONE
//                            }
//
//                            deleteMessage(messageId).subscribe().addTo(disposables)
//                        } catch (e: Exception) {
//                            e.printStackTrace()
//                        }
//                    }
//
//                }
//
//            }
//        }, { error -> }).addTo(disposables)
//    }


//    private fun deleteMessage(messageId: String): Completable {
//        return FireConstants.userMessages.child(FireManager.uid).child(messageId).setValueRx(null)
//    }

//    private fun deleteDeletedMessage(messageId: String): Completable {
//        return FireConstants.deletedMessages.child(FireManager.uid).child(messageId)
//            .setValueRx(null)
//    }

//    private fun deleteNewGroupEvent(groupId: String): Completable {
//        return FireConstants.newGroups.child(FireManager.uid).child(groupId).setValueRx(null)
//    }

//    private fun deleteNewCall(callId: String): Completable {
//        return FireConstants.userCalls.child(FireManager.uid).child(callId).setValueRx(null)
//    }


    override fun onResume() {
        super.onResume()
        if (enablePresence()) {
//            presenceUtil?.onResume()
//            MyApp.baseActivityResumed()
        }

//        (this.application as? MyApp)?.let { application ->
//
//        }

    }


    override fun onPause() {
        super.onPause()
        if (enablePresence()) {
//            presenceUtil?.onPause()
//            MyApp.baseActivityPaused()
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
//        presenceUtil?.onDestroy()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }


}