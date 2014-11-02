package com.wesleyreisz.sampleactionbarapp;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import com.wesleyreisz.sampleactionbarapp.fragment.AddFragment;
import com.wesleyreisz.sampleactionbarapp.fragment.AnnnnnnotherFragment;
import com.wesleyreisz.sampleactionbarapp.fragment.PlaceholderFragment;
import com.wesleyreisz.sampleactionbarapp.fragment.SearchFragment;
import com.wesleyreisz.sampleactionbarapp.fragment.SimpleTextFragment;
import com.wesleyreisz.sampleactionbarapp.fragment.WiiidgetFragment;
import com.wesleyreisz.sampleactionbarapp.listener.MyTabListener;


public class MainTabActivity extends Activity implements
        WiiidgetFragment.OnFragmentInteractionListener,
        AnnnnnnotherFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab);

        ActionBar actionbar = getActionBar();
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab2 = actionbar.newTab().setText(R.string.tab2);
        tab2.setTabListener(new MyTabListener(new SearchFragment()));

        ActionBar.Tab tab3 = actionbar.newTab().setText(R.string.tab3);
        tab3.setTabListener(new MyTabListener(WiiidgetFragment.newInstance("Tester", "Hiyas")));

        ActionBar.Tab tab4 = actionbar.newTab().setText(R.string.tab4);
        tab4.setTabListener(new MyTabListener(new SimpleTextFragment()));


        actionbar.addTab(tab2);
        actionbar.addTab(tab3);
        actionbar.addTab(tab4);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_tab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Log.d("SAMPLE", "Clicked");

        int id = item.getItemId();

        switch (id){
            case R.id.action_settings: return true;
            case R.id.action_add: add(); return true;
            default: return false;
        }

    }

    private void add() {
        Log.d("SAMPLE", "Search");
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFragmentInteraction(String txt) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main_tab, container, false);
            return rootView;
        }
    }
}
