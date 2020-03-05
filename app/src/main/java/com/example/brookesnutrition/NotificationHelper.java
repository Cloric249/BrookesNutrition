package com.example.brookesnutrition;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.provider.Settings;


import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

public class NotificationHelper extends ContextWrapper {
    private NotificationManager mNotificationManager;
    private final String MY_CHANNEL = "my_channel";
    private final long[] vibrationScheme = new long[]{200, 400};

    /**
     * Registers notification channels, which can be used later by individual notifications.
     *
     * @param context The application context
     */
    public NotificationHelper(Context context) {
        super(context);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            // Create the channel object with the unique ID MY_CHANNEL
            NotificationChannel myChannel =
                    new NotificationChannel(
                            MY_CHANNEL,
                            getResources().getString(R.string.notification_channel_title),
                            NotificationManager.IMPORTANCE_DEFAULT);

            // Configure the channel's initial settings
            myChannel.setLightColor(Color.GREEN);
            myChannel.setVibrationPattern(vibrationScheme);

            // Submit the notification channel object to the notification manager
            getNotificationManager().createNotificationChannel(myChannel);

        }
    }

    /**
     * Build you notification with desired configurations
     *
     */
    public NotificationCompat.Builder getNotificationBuilder(String title, String body, PendingIntent pendingIntent) {

        Bitmap notificationLargeIconBitmap = BitmapFactory.decodeResource(
                getApplicationContext().getResources(),
                R.mipmap.ic_launcher);

        return new NotificationCompat.Builder(getApplicationContext(), MY_CHANNEL)
                .setLargeIcon(notificationLargeIconBitmap)
                .setContentTitle(title)
                .setContentText(body)
                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                .setVibrate(vibrationScheme)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(body))
                .setColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
    }

    public NotificationManager getNotificationManager() {
        if (mNotificationManager == null) {
            mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mNotificationManager;
    }

}