package com.wesleyreisz.fragmentrunner;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.wesleyreisz.fragmentrunner.fragment.ItemFragment;
import com.wesleyreisz.fragmentrunner.fragment.ListFragment;

public class MainActivity extends AppCompatActivity implements ListFragment.ListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer,new ListFragment());
        fragmentTransaction.commit();

    }

    @Override
    public void itemClicked(String city) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, ItemFragment.createInstance(city));
        fragmentTransaction.commit();
    }
}
