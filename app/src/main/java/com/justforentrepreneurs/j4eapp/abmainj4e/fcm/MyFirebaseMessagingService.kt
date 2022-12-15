package com.justforentrepreneurs.j4eapp.abmainj4e.fcm

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.os.Build
import android.provider.Settings
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.justforentrepreneurs.j4eapp.R
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.drawer.mydiary.MyLeads.MyLeadsDetailActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.home.MainActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.mybusinesstransactions.MyBusinessTransactionsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myconnections.MyConnectionsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.myevents.MyEventsDetailsActivity
import com.justforentrepreneurs.j4eapp.abmainj4e.ui.homemydiary.pendingresponsibilities.PendingResponsibilitiesActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import com.google.firebase.messaging.FirebaseMessaging


class MyFirebaseMessagingService : FirebaseMessagingService() {
    val TAG = "FirebaseMessagingService"
    var tokensd: String? = null
    private val CHANNEL_ID = "1"
    var title: String? = null
    var message:String? = null
    var time:String? = null
    var type:String? = null
    var icon:String? = null
    var date:String? = null
    var id:String? = null


    override fun onNewToken(token: String) {
        super.onNewToken(token)
        val deviceID = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
        tokensd = token

        FirebaseMessaging.getInstance().subscribeToTopic("com.Celebrity");

        Log.d("SUCC1:", token)

    }

    /*@SuppressLint("LongLogTag")
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d(TAG, "Dikirim dari: ${remoteMessage.from}")

        if (remoteMessage.notification != null) {
            showNotification(remoteMessage.notification?.title, remoteMessage.notification?.body)
        }
    }
*/

  /*  override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        Log.d("DMessage1:",remoteMessage.data.toString())

        title = remoteMessage.notification!!.title
        message = remoteMessage.data["Msg"]
        icon = remoteMessage.data["thumbnil"]
        type = remoteMessage.data["type"]
        time = remoteMessage.data["Time"]
        date = remoteMessage.data["Date"]
        id= remoteMessage.data["id"]
        showNotification(title.toString(), message.toString(), type.toString(),id.toString())
    }*/


    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        Log.d("DMessage1:",message.data.toString())

    }

    private fun showNotification(title: String, message: String, type: String,id: String) {
        val df: DateFormat = SimpleDateFormat("dd-MMM-yyyy, HH:mm")
        val date = df.format(Calendar.getInstance().time)


        if (type.equals("Connection")) {
            val intent = Intent(this, MyConnectionsActivity::class.java)
            intent.putExtra("hometype", "0")
            intent.putExtra("type", "notification")
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

            createNotificationChannel()
            val url = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val builder: NotificationCompat.Builder =
                    NotificationCompat.Builder(this, CHANNEL_ID)
                            .setSmallIcon(R.drawable.splash_app_logo)
                            .setContentTitle(title)
                            .setContentText(message)
                            .setAutoCancel(true)
                            .setContentIntent(pendingIntent)
                            .setSound(url)
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
            val managerCompat = NotificationManagerCompat.from(this)
            managerCompat.notify(createUniqueId(), builder.build())


        } else if (type.equals("BuddyMeet")) {
            val intent = Intent(this, PendingResponsibilitiesActivity::class.java)
            intent.putExtra("type", "1")
            intent.putExtra("noti", "notification")
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

            createNotificationChannel()
            val url = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val builder: NotificationCompat.Builder =
                    NotificationCompat.Builder(this, CHANNEL_ID)
                            .setSmallIcon(R.drawable.splash_app_logo)
                            .setContentTitle(title)
                            .setContentText(message)
                            .setAutoCancel(true)
                            .setContentIntent(pendingIntent)
                            .setSound(url)
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
            val managerCompat = NotificationManagerCompat.from(this)
            managerCompat.notify(createUniqueId(), builder.build())

        } else if (type.equals("Followup")) {
            val intent = Intent(this, PendingResponsibilitiesActivity::class.java)
            intent.putExtra("type", "2")
            intent.putExtra("noti", "notification")
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

            createNotificationChannel()
            val url = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val builder: NotificationCompat.Builder =
                    NotificationCompat.Builder(this, CHANNEL_ID)
                            .setSmallIcon(R.drawable.splash_app_logo)
                            .setContentTitle(title)
                            .setContentText(message)
                            .setAutoCancel(true)
                            .setContentIntent(pendingIntent)
                            .setSound(url)
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
            val managerCompat = NotificationManagerCompat.from(this)
            managerCompat.notify(createUniqueId(), builder.build())

        } else if (type.equals("Event")) {
            val intent = Intent(this, MyEventsDetailsActivity::class.java)
            intent.putExtra("type", "upcoming")
            intent.putExtra("Back", "activity")
            intent.putExtra("id", id)
            intent.putExtra("noti", "notification")
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

            createNotificationChannel()
            val url = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val builder: NotificationCompat.Builder =
                    NotificationCompat.Builder(this, CHANNEL_ID)
                            .setSmallIcon(R.drawable.splash_app_logo)
                            .setContentTitle(title)
                            .setContentText(message)
                            .setAutoCancel(true)
                            .setContentIntent(pendingIntent)
                            .setSound(url)
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
            val managerCompat = NotificationManagerCompat.from(this)
            managerCompat.notify(createUniqueId(), builder.build())
        } else if (type.equals("BusinessTransaction")) {
            val intent = Intent(this, MyBusinessTransactionsActivity::class.java)
            intent.putExtra("noti", "notification")
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

            createNotificationChannel()
            val url = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val builder: NotificationCompat.Builder =
                    NotificationCompat.Builder(this, CHANNEL_ID)
                            .setSmallIcon(R.drawable.splash_app_logo)
                            .setContentTitle(title)
                            .setContentText(message)
                            .setAutoCancel(true)
                            .setContentIntent(pendingIntent)
                            .setSound(url)
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
            val managerCompat = NotificationManagerCompat.from(this)
            managerCompat.notify(createUniqueId(), builder.build())

        } else if (type.equals("LeadStatus")) {
            val intent = Intent(this, MyLeadsDetailActivity::class.java)
            intent.putExtra("type", "MyLead")
            intent.putExtra("id", id)
            intent.putExtra("noti", "notification")
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

            createNotificationChannel()
            val url = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val builder: NotificationCompat.Builder =
                    NotificationCompat.Builder(this, CHANNEL_ID)
                            .setSmallIcon(R.drawable.splash_app_logo)
                            .setContentTitle(title)
                            .setContentText(message)
                            .setAutoCancel(true)
                            .setContentIntent(pendingIntent)
                            .setSound(url)
                            .setPriority(NotificationCompat.PRIORITY_HIGH)

            val managerCompat = NotificationManagerCompat.from(this)
            managerCompat.notify(createUniqueId(), builder.build())
        }else{
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

            createNotificationChannel()
            val url = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val builder: NotificationCompat.Builder =
                    NotificationCompat.Builder(this, CHANNEL_ID)
                            .setSmallIcon(R.drawable.splash_app_logo)
                            .setContentTitle(title)
                            .setContentText(message)
                            .setAutoCancel(true)
                            .setContentIntent(pendingIntent)
                            .setSound(url)
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
            val managerCompat = NotificationManagerCompat.from(this)
            managerCompat.notify(createUniqueId(), builder.build())

        }
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        val url = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val audioAttributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_ALARM)
                .build()
            val name: CharSequence = getString(R.string.channel_name)
            val description = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel =
                NotificationChannel(CHANNEL_ID, name, importance)
            channel.enableVibration(true)
            channel.description = description
            channel.setSound(url, audioAttributes)
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager = getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun createUniqueId(): Int {
        return Random().nextInt(1000)
    }
}