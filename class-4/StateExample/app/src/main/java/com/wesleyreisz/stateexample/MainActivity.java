package com.wesleyreisz.stateexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "LIFECYCLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String name = "WEs";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "The activity is being created.");

        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        String name = "Reisz";
        Log.d(TAG, "The activity is about to become visible.");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "The activity has become visible (it is now \"resumed\").");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Another activity is taking focus (this activity is about to be \"paused\").");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "The activity is no longer visible (it is now \"stopped\")");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "The activity is about to be destroyed.");
    }

}
