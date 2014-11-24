package com.example.classlab7c.fragments;

import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.classlab7c.R;
import com.example.classlab7c.adapters.ArtistAdapter;
import com.example.classlab7c.model.Artist;
import com.example.classlab7c.service.MusicListServiceImpl;
import com.example.classlab7c.service.MockMusicListServiceImpl;

public class ArtistFragment extends Fragment {
	private static int ADD_BUTTON_POSITION = 0;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.artist_layout, container, false);
	}
	
	@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.getItem(ADD_BUTTON_POSITION).setVisible(true);
    }

}
