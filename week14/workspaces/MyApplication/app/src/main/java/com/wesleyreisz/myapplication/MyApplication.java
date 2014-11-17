package com.wesleyreisz.myapplication;

import android.app.Application;

/**
 * Created by wesleyreisz on 11/16/14.
 */
public class MyApplication extends Application {
    private static MyApplication myApplication;
    private String message;

    public static MyApplication getInstance(){
        return MyApplication.myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
