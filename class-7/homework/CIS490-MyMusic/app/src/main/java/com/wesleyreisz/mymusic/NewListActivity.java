package com.wesleyreisz.mymusic;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Activity;

import com.wesleyreisz.mymusic.fragment.ListFragment;
import com.wesleyreisz.mymusic.fragment.MyListFragment;
import com.wesleyreisz.mymusic.fragment.NewListActivityFragment;

public class NewListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        NewListActivityFragment listFragment = new NewListActivityFragment();
        fragmentTransaction.add(R.id.fragmentContainer,listFragment);
        fragmentTransaction.commit();
    }

}
