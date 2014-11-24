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
import com.example.classlab7c.adapters.SongAdapter;
import com.example.classlab7c.model.Song;
import com.example.classlab7c.service.IMusicService;
import com.example.classlab7c.service.MusicListServiceImpl;
import com.example.classlab7c.service.MockMusicListServiceImpl;

public class SongFragment extends Fragment {
	private static int ADD_BUTTON_POSITION = 0;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view =  inflater.inflate(R.layout.song_layout, container, false);
		
		IMusicService service = MusicListServiceImpl.getInstance(getActivity());
		List<Song>songs = service.getAllSongs();
		
		SongAdapter adapter =
				new SongAdapter(getActivity(), R.layout.listview_for_each_song, songs);
		ListView listViewMusic = (ListView) view.findViewById(R.id.listViewSongs);
		listViewMusic.setAdapter(adapter);

		setHasOptionsMenu(true);
		
		return view;
	}
	
	@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.getItem(ADD_BUTTON_POSITION).setVisible(true);
    }
}
