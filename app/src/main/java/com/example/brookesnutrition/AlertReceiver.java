package com.example.brookesnutrition;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlertReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                databaseHelper DB = new databaseHelper(context);
                try {
                    FireMessage f = new FireMessage("Calories Consumed Today: ", DB.getTotalCalories());
                    f.sendToToken(MyFirebaseMessagingService.getToken(context));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        thread3.start();
    }
}
