package com.justforentrepreneurs.j4eapp.abmainj4e.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Bitmap
import android.util.Base64
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.FragmentActivity
import com.justforentrepreneurs.j4eapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.net.InetAddress
import java.text.DecimalFormat

private var dialog: Dialog? = null

fun displayToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun displayToast(context: Context, @StringRes message: Int) {
    Toast.makeText(context, context.resources.getString(message), Toast.LENGTH_SHORT).show()
}


@SuppressLint("MissingPermission")
fun isInternetAvailable(context: Context): Boolean {
    CoroutineScope(Dispatchers.IO).launch {
        try {
            val ipAddress = InetAddress.getByName("google.com")
            !ipAddress.equals("")
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                displayToast(context, context.getString(R.string.error_internet))
            }
            dismissLoader()
            false
        }
    }
    return true

    /*var connectivity : ConnectivityManager? = null
    var info : NetworkInfo? = null

    connectivity = context.getSystemService(Service.CONNECTIVITY_SERVICE)
            as ConnectivityManager

    if ( connectivity != null)
    {
        info = connectivity!!.activeNetworkInfo

        if (info != null)
        {
            if (info!!.state == NetworkInfo.State.CONNECTED)
            {

                return true
            }
        }
        else
        {
            displayToast(context, context.getString(R.string.error_internet))
            return false
        }
    }

    return false*/

}

fun showLoader(context: Context) {
    dismissLoader()
    dialog = Dialog(context).apply {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCancelable(false)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        setContentView(R.layout.dialog_loader)
        show()
    }
}



fun showLoader1(context: Context) {
    dismissLoader()
    dialog = Dialog(context).apply {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCancelable(false)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        setContentView(R.layout.dialog_loader1)
        show()
    }
}

fun showLoaderf(context: FragmentActivity?) {
    dismissLoader()
    dialog = Dialog(context!!).apply {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCancelable(false)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        setContentView(R.layout.dialog_loader)
        show()
    }
}

fun dismissLoader() {
    try {
        if (dialog != null && dialog!!.isShowing) {
            dialog!!.dismiss()
        }
    } catch (e: IllegalArgumentException) {
        // Handle or log or ignore
    } catch (e: java.lang.Exception) {
        // Handle or log or ignore
    } finally {
        dialog = null
    }
//    if (dialog != null && dialog!!.isShowing) {
//        dialog!!.dismiss()
//        dialog = null
//    }
}

var mypref = "J4E"
var context1: Context? = null

fun storeUsingSharedPreference(context: Context, key: String?,
                               value: String?) {
    context1 = context
    val editor = context.getSharedPreferences(mypref,
            Context.MODE_PRIVATE).edit()
    editor.putString(key, value)
    editor.commit()
}

// get data From Shared Preference
fun readUsingSharedPreference(context: Context, key: String?): String? {
    val preference = context.getSharedPreferences(mypref,
            Context.MODE_PRIVATE)
    return preference.getString(key, "0")
}

// Delete all data from Shared Preference
fun cleareUsingSharedPreference(context: Context) {
    val editor = context.getSharedPreferences(mypref,
            Context.MODE_PRIVATE).edit()
    editor.clear()
    editor.commit()
}

// Delete specific data from Shared Preference
fun cleareUsingSharedPreferenceOne(context: Context,
                                   name: String?) {
    if (mypref.contains("mykey")) {
        val editor = context.getSharedPreferences(
                mypref, Context.MODE_PRIVATE).edit()
        editor.remove("user_image")
        editor.commit()
    }
}

fun hideSoftKeybord(context: Context) {
    val view = (context as Activity).currentFocus
    if (view != null) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun endcodeToBase64(image: Bitmap, compressFormat: Bitmap.CompressFormat?, quality: Int): String? {
    val byteArryOS = ByteArrayOutputStream()
    image.compress(compressFormat, quality, byteArryOS)
    return Base64.encodeToString(byteArryOS.toByteArray(), Base64.DEFAULT)
}


fun fmt(s: String): String? {
    val format2: String = DecimalFormat("#,##,##,##,###.00").format(s.toDouble())
    return "$format2"
}

fun fmtone(s: String): String? {
    val format2: String = DecimalFormat("#,##,##,##,###").format(s.toDouble())
    return "$format2"
}

fun wordFirstCap(str: String): String? {
    val words: Array<String> = str.trim { it <= ' ' }.split(" ").toTypedArray()
    val ret = StringBuilder()
    for (i in words.indices) {
        if (words[i].trim { it <= ' ' }.length > 0) {
            ret.append(Character.toUpperCase(words[i].trim { it <= ' ' }[0]))
            ret.append(words[i].trim { it <= ' ' }.substring(1))
            if (i < words.size - 1) {
                ret.append(' ')
            }
        }
    }
    return ret.toString()
}
