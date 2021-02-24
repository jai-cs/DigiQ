package com.example.digiq;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class DigiQ extends Application {
    public static final String NOTIFICATION_ID = "notification";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannels();
    }

    private void createNotificationChannels() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notification = new NotificationChannel(NOTIFICATION_ID, "Wait Time: ", NotificationManager.IMPORTANCE_HIGH);
            notification.setDescription("You have only 5 Minutes till your Turn");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(notification);
        }

    }
}
