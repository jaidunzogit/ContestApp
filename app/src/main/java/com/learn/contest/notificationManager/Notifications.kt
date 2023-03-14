package com.learn.contest.notificationManager

import android.Manifest
import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_DEFAULT
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.learn.contest.R

class Notifications(val context: Activity) {

    private val channelCode = "channel_code"
    private val notificationId = 1

    fun createNotificationchannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val name = "test_channel"
            val descriptionText = "This is my test Channel"

            val importance = IMPORTANCE_DEFAULT

            val channel = NotificationChannel(channelCode, name, importance).apply {
                description = descriptionText
            }

            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)


        }

    }

    fun createNotification(nc: String, lnc: String) {

        val builder = NotificationCompat.Builder(context, channelCode)
            .setSmallIcon(R.mipmap.ic_launcher_round).setContentTitle("Regarding Coding Contest")
            .setContentText(nc).setStyle(
                NotificationCompat.BigTextStyle().bigText(lnc)
            ).setPriority(NotificationCompat.PRIORITY_DEFAULT).setAutoCancel(true)

        with(NotificationManagerCompat.from(context)) {
            if (ActivityCompat.checkSelfPermission(
                    context, Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            notify(notificationId, builder.build())
        }
    }
}