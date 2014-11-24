package com.wesleyreisz.sampleapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;


public class SharedPreferenceActivity extends Activity {
    private boolean mSilentMode = true;
    public static final String PREFS_NAME = "com.wesleyreisz.sampleapp.MyPrefsFile";
    public static final String TAG = "SILENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        // Restore preferences
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        boolean silent = settings.getBoolean("silentMode", false);
        setSilent(silent);

        ToggleButton toggleButton = (ToggleButton)findViewById(R.id.togglebutton);
        toggleButton.setChecked(mSilentMode);

        Log.d(TAG, "Loading mSilentMode: " + mSilentMode);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Starting mSilentMode: " + mSilentMode);

        TextView textViewValue = (TextView)findViewById(R.id.textViewValue);
        textViewValue.setText(String.valueOf(mSilentMode));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("silentMode", mSilentMode);

        // Commit the edits!
        editor.commit();

        Log.d(TAG, "Calling Stop and persisting mSilentMode: " + mSilentMode);
    }

    public void onToggleClicked(View view) {
        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            setSilent(true);
        } else {
            setSilent(false);
        }
        Log.d(TAG, "Setting Mode to: " + mSilentMode);
    }

    public void setSilent(boolean silent) {
        this.mSilentMode = silent;
    }
}
