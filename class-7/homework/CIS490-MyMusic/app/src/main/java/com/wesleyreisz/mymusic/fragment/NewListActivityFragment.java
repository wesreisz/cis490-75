package com.wesleyreisz.mymusic.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.wesleyreisz.mymusic.R;
import com.wesleyreisz.mymusic.model.Song;
import com.wesleyreisz.mymusic.service.MockMusicService;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class NewListActivityFragment extends Fragment {

    public NewListActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_new_list, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listViewSongs);
        List<Song> songs = new MockMusicService().findAll();

        // Create an ArrayAdapter for the ListView
        SongAdapter arrayAdapter = new SongAdapter(getActivity(),
                R.layout.layout_for_each_song,
                songs);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(getActivity(),"Position: " + position, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        return view;
    }
}
