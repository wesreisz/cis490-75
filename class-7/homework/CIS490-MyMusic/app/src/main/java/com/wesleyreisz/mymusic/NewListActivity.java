package com.wesleyreisz.mymusic;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Toast;

import com.wesleyreisz.mymusic.fragment.ListFragment;
import com.wesleyreisz.mymusic.fragment.MyListFragment;
import com.wesleyreisz.mymusic.fragment.NewListActivityFragment;
import com.wesleyreisz.mymusic.fragment.SongFragment;
import com.wesleyreisz.mymusic.model.Song;
import com.wesleyreisz.mymusic.service.MockMusicService;

public class NewListActivity extends Activity implements NewListActivityFragment.OnItemChange, SongFragment.OnReloadClick {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        NewListActivityFragment listFragment = new NewListActivityFragment();
        fragmentTransaction.add(R.id.fragmentContainer, listFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void ItemClicked(int changeToSongPosition, String songTitle) {
        Toast toast = Toast.makeText(this, "Position: " + changeToSongPosition, Toast.LENGTH_SHORT);
        toast.show();

        Song song = new MockMusicService().findOne(songTitle);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SongFragment songFragment = new SongFragment();
        songFragment.setSong(song);
        fragmentTransaction.replace(R.id.fragmentContainer, songFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void reload() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        NewListActivityFragment listFragment = new NewListActivityFragment();
        fragmentTransaction.replace(R.id.fragmentContainer, listFragment);
        fragmentTransaction.commit();
    }
}
