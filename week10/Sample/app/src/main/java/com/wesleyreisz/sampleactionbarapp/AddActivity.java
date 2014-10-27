package com.wesleyreisz.sampleactionbarapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.wesleyreisz.sampleactionbarapp.fragment.AddFragment;
import com.wesleyreisz.sampleactionbarapp.fragment.PlaceholderFragment;
import com.wesleyreisz.sampleactionbarapp.fragment.SimpleTextFragment;


public class AddActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        if (savedInstanceState == null) {
            getFragmentManager()
                .beginTransaction()
                .add(R.id.container_add, new AddFragment())
                .commit();
        }

        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
