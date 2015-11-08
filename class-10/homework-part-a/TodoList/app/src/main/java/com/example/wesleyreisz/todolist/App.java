package com.example.wesleyreisz.todolist;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by wesleyreisz on 11/8/15.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, ApplicationID, ClientKey);
    }
}
