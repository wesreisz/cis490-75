package com.wesleyreisz.cis490twitterreader;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.wesleyreisz.cis490twitterreader.fragment.ListTweetsFragment;
import com.wesleyreisz.cis490twitterreader.fragment.NotLoggedInFragment;
import com.wesleyreisz.cis490twitterreader.listener.FragmentTaskCompleteListener;


public class MainActivity extends AppCompatActivity  implements FragmentTaskCompleteListener {
    SharedPreferences sharedPreferences;
    Button btnLogin;
    boolean status = false;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Enabling Strict Mode
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        sharedPreferences = getSharedPreferences(Config.PREF_NAME, 0);
        status = sharedPreferences.getBoolean(Config.KEY_TWITTER_LOGIN, false);

        //hide the action button if not logged in
        fab = (FloatingActionButton) findViewById(R.id.fab);
        if (status) {
            fab.show();
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
            showHome();
        }else{
            fab.hide();
            showNotLoggedIn();
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if (id == R.id.action_logout){
            setStatusInSharedPreferences(false);
            showNotLoggedIn();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTaskComplete(String str) {
        setStatusInSharedPreferences(true);
        fab.show();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, new ListTweetsFragment());
        fragmentTransaction.commit();
    }

    private void setStatusInSharedPreferences(boolean value){
        status = value;

        sharedPreferences = getSharedPreferences(Config.PREF_NAME,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(Config.KEY_TWITTER_LOGIN, value);
        editor.commit();
    }

    private void showHome(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, new ListTweetsFragment());
        fragmentTransaction.commit();
    }

    private void showNotLoggedIn(){
        fab.hide();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, new NotLoggedInFragment());
        fragmentTransaction.commit();


    }
}
