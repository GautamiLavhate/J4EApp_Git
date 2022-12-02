package com.justforentrepreneurs.j4eapp.abmainj4e.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity
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
//import com.justforentrepreneurs.j4eapp.utils.*
import org.json.JSONException
import org.koin.android.ext.android.get
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Dialog
import android.net.Uri
import android.os.Build
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.applex.linkedinsigninexample.model.LinkedInEmailModel
import com.applex.linkedinsigninexample.model.LinkedInProfileModel
import com.justforentrepreneurs.j4eapp.abmainj4e.utils.LinkedInConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import org.json.JSONObject
import org.json.JSONTokener
import java.io.OutputStreamWriter
import java.net.URL
import java.util.concurrent.TimeUnit
import javax.net.ssl.HttpsURLConnection


abstract class BaseActivityOP : AppCompatActivity(){



    private val tag = BaseActivityOP::class.java.simpleName
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
                                this@BaseActivityOP,
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
                    this@BaseActivityOP,
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


    lateinit var linkedinAuthURLFull: String
    lateinit var linkedIndialog: Dialog
    lateinit var linkedinCode: String


    var id = ""
    var firstName = ""
    var lastName = ""
    var email = ""
    var profilePicURL = ""
    var accessToken = ""


    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        prettyPrint = true
        encodeDefaults = true
        classDiscriminator = "#class"
    }

    protected fun linkedinSignOut() {
        val cookieManager: CookieManager = CookieManager.getInstance()
        cookieManager.flush()
        cookieManager.removeAllCookies(null)
        val webView = WebView(this)
        webView.clearCache(true)
        webView.clearFormData()
        webView.clearHistory()
        webView.clearSslPreferences()
    }

    protected fun loginWithLinkdin(listener: AuthListener) {
        val state = "linkedin" + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())

        linkedinAuthURLFull = LinkedInConstants.AUTHURL + "?response_type=code&client_id=" + LinkedInConstants.CLIENT_ID + "&scope=" + LinkedInConstants.SCOPE + "&state=" + state + "&redirect_uri=" + LinkedInConstants.REDIRECT_URI
        authListener = listener
        setupLinkedinWebviewDialog(linkedinAuthURLFull)

    }

    @SuppressLint("SetJavaScriptEnabled")
    fun setupLinkedinWebviewDialog(url: String) {
        linkedIndialog = Dialog(this)
        val webView = WebView(this)
        webView.isVerticalScrollBarEnabled = false
        webView.isHorizontalScrollBarEnabled = false
        webView.webViewClient = LinkedInWebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)
        linkedIndialog.setContentView(webView)
        linkedIndialog.show()
    }

    @Suppress("OverridingDeprecatedMember")
    inner class LinkedInWebViewClient : WebViewClient() {

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            if (request?.url.toString().startsWith(LinkedInConstants.REDIRECT_URI)) {
                handleUrl(request?.url.toString())

                // Close the dialog after getting the authorization code
                if (request?.url.toString().contains("?code=")) {
                    linkedIndialog.dismiss()
                }
                return true
            }
            return false
        }

        // For API 19 and below
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            if (url.startsWith(LinkedInConstants.REDIRECT_URI)) {
                handleUrl(url)

                // Close the dialog after getting the authorization code
                if (url.contains("?code=")) {
                    linkedIndialog.dismiss()
                }
                return true
            }
            return false
        }

        // Check webview url for access token code or error
        private fun handleUrl(url: String) {
            val uri = Uri.parse(url)

            if (url.contains("code")) {
                linkedinCode = uri.getQueryParameter("code") ?: ""
                linkedInRequestForAccessToken()
            } else if (url.contains("error")) {
                val error = uri.getQueryParameter("error") ?: ""
                Log.e("Error: ", error)
            }
        }
    }


    fun linkedInRequestForAccessToken() {
        GlobalScope.launch(Dispatchers.Default) {
            val grantType = "authorization_code"
            val postParams =
                "grant_type=" + grantType + "&code=" + linkedinCode + "&redirect_uri=" + LinkedInConstants.REDIRECT_URI + "&client_id=" + LinkedInConstants.CLIENT_ID + "&client_secret=" + LinkedInConstants.CLIENT_SECRET
            val url = URL(LinkedInConstants.TOKENURL)
            val httpsURLConnection = withContext(Dispatchers.IO) {url.openConnection() as HttpsURLConnection }
            httpsURLConnection.requestMethod = "POST"
            httpsURLConnection.setRequestProperty(
                "Content-Type",
                "application/x-www-form-urlencoded"
            )
            httpsURLConnection.doInput = true
            httpsURLConnection.doOutput = true
            val outputStreamWriter = OutputStreamWriter(httpsURLConnection.outputStream)
            withContext(Dispatchers.IO) {
                outputStreamWriter.write(postParams)
                outputStreamWriter.flush()
            }
            val response = httpsURLConnection.inputStream.bufferedReader()
                .use { it.readText() }  // defaults to UTF-8
            val jsonObject = JSONTokener(response).nextValue() as JSONObject

            val accessToken = jsonObject.getString("access_token") //The access token
            Log.d("accessToken is: ", accessToken)

            val expiresIn = jsonObject.getInt("expires_in") //When the access token expires
            Log.d("expires in: ", expiresIn.toString())


            withContext(Dispatchers.Main) {
                // Get user's id, first name, last name, profile pic url
                fetchlinkedInUserProfile(accessToken)
            }
        }
    }

    fun fetchlinkedInUserProfile(token: String) {
        GlobalScope.launch(Dispatchers.Default) {
            val tokenURLFull =
                "https://api.linkedin.com/v2/me?projection=(id,firstName,lastName,profilePicture(displayImage~:playableStreams))&oauth2_access_token=$token"
            val url = URL(tokenURLFull)
            val httpsURLConnection = withContext(Dispatchers.IO) {url.openConnection() as HttpsURLConnection }
            httpsURLConnection.requestMethod = "GET"
            httpsURLConnection.doInput = true
            httpsURLConnection.doOutput = false
            val response = httpsURLConnection.inputStream.bufferedReader()
                .use { it.readText() }  // defaults to UTF-8

            val linkedInProfileModel: LinkedInProfileModel = json.decodeFromJsonElement(json.parseToJsonElement(response))

            withContext(Dispatchers.Main) {
                Log.d("LinkedIn Access Token: ", token)
                accessToken = token

                // LinkedIn Id
                val linkedinId = linkedInProfileModel.id
                Log.d("LinkedIn Id: ", linkedinId)
                id = linkedinId

                // LinkedIn First Name
                val linkedinFirstName = linkedInProfileModel.firstName.localized.enUS
                Log.d("LinkedIn First Name: ", linkedinFirstName)
                firstName = linkedinFirstName

                // LinkedIn Last Name
                val linkedinLastName = linkedInProfileModel.lastName.localized.enUS
                Log.d("LinkedIn Last Name: ", linkedinLastName)
                lastName = linkedinLastName

                // LinkedIn Profile Picture URL
                /*
                     Change row of the 'elements' array to get diffrent size of the profile pic
                     elements[0] = 100x100
                     elements[1] = 200x200
                     elements[2] = 400x400
                     elements[3] = 800x800
                */

                val linkedinProfilePic =
                    linkedInProfileModel.profilePicture.displayImage.elements.get(2)
                        .identifiers.get(0).identifier
                Log.d("LinkedIn Profile URL: ", linkedinProfilePic)
                profilePicURL = linkedinProfilePic

                // Get user's email address
                fetchLinkedInEmailAddress(token)
            }
        }
    }


    fun fetchLinkedInEmailAddress(token: String) {
        val tokenURLFull =
            "https://api.linkedin.com/v2/emailAddress?q=members&projection=(elements*(handle~))&oauth2_access_token=$token"

        GlobalScope.launch(Dispatchers.Default) {
            val url = URL(tokenURLFull)
            val httpsURLConnection = withContext(Dispatchers.IO) {url.openConnection() as HttpsURLConnection }
            httpsURLConnection.requestMethod = "GET"
            httpsURLConnection.doInput = true
            httpsURLConnection.doOutput = false
            val response = httpsURLConnection.inputStream.bufferedReader()
                .use { it.readText() }  // defaults to UTF-8
            val linkedInProfileModel =
                Json.decodeFromString(LinkedInEmailModel.serializer(), response)
            withContext(Dispatchers.Main) {
                // LinkedIn Email
                val linkedinEmail = linkedInProfileModel.elements.get(0).elementHandle.emailAddress
                Log.d("LinkedIn Email: ", linkedinEmail)
                email = linkedinEmail
                val hashMap: HashMap<String, String> = HashMap<String, String>()
                hashMap["firstName"] =firstName
                hashMap["lastName"] = lastName
                hashMap["email"] = email
                hashMap["socialId"] = id
                hashMap["photoUrl"] = profilePicURL
                authListener.authData("linkdin", hashMap)
                storeUsingSharedPreference(this@BaseActivityOP,
                    "signup_source","linkdin"
                )
            }
        }
    }

    fun onBackClick(view: View) {
        finish()
    }

}