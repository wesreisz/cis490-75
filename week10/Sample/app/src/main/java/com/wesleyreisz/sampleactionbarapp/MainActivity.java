package com.wesleyreisz.sampleactionbarapp;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Toast;

import com.wesleyreisz.sampleactionbarapp.fragment.AddFragment;
import com.wesleyreisz.sampleactionbarapp.fragment.PlaceholderFragment;
import com.wesleyreisz.sampleactionbarapp.fragment.SearchFragment;
import com.wesleyreisz.sampleactionbarapp.fragment.SimpleTextFragment;
import com.wesleyreisz.sampleactionbarapp.fragment.WiiidgetFragment;


public class MainActivity extends Activity implements WiiidgetFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager()
                .beginTransaction()
                .add(R.id.container, new PlaceholderFragment())
                .add(R.id.containerBase, new SimpleTextFragment())
                .commit();
        }
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

        switch (id){
            case R.id.action_add : openAdd(); return true;
            case R.id.action_search : search(); return true;
            case R.id.action_widget : widget(); return true;
            case R.id.action_settings: settings(); return true;
            default : return false;
        }
    }

    private void widget() {
        getFragmentManager()
            .beginTransaction()
            .replace(R.id.container, WiiidgetFragment.newInstance("Tester 1", "Tester 2"))
            .commit();
    }

    private void search() {
        getFragmentManager()
            .beginTransaction()
            .replace(R.id.container, new SearchFragment())
            .commit();
    }

    private void openAdd() {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    private void settings() {
        Toast toast = Toast.makeText(this, "Settings", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onFragmentInteraction(String text) {
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show();
    }
}
