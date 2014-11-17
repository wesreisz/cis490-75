package com.wesleyreisz.myapplication;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Created by wesleyreisz on 11/16/14.
 */
public class MyService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("TEST","Started Service");

        new Thread(new CounterRunnable()).start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d("TEST","Stopped Service");
        super.onDestroy();
    }

    private class CounterRunnable implements Runnable{
        @Override
        public void run() {
            int count = 0;

            //get access to the system service that manages notifications
            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            while(count<=5){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("TEST"," Message: " + ++count);
            }

            //build up your notification. btw, this is a builder pattern
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(getApplicationContext());

            mBuilder.setSmallIcon(android.R.drawable.ic_dialog_alert);
            mBuilder.setContentTitle("Notification " + count);
            mBuilder.setContentText(" " + count);

            //send it
            notificationManager.notify(
                count,
                mBuilder.build()
            );
        }
    }
}
