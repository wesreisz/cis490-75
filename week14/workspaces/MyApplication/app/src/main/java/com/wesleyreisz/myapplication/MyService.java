package com.wesleyreisz.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
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

        int count = 0;
        while(count<=10){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("TEST"," Message: " + ++count);
        }

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d("TEST","Stopped Service");
        super.onDestroy();
    }
}
