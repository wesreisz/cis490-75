package com.wesleyreisz.mymusic.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.wesleyreisz.mymusic.R;
import com.wesleyreisz.mymusic.model.Song;

import java.text.SimpleDateFormat;

public class SongFragment extends Fragment {
    private OnReloadClick onReloadClick;
    private SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy (EEE)");
    private Song song;
    public SongFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_song, container, false);
        if(song!=null){
            TextView txtViewSongTitle = (TextView)view.findViewById(R.id.txtTitle);
            txtViewSongTitle.setText(song.getSongTitle());
            TextView txtViewArtists = (TextView)view.findViewById(R.id.txtArtist);
            txtViewArtists.setText(song.getArtistName());
            TextView txtViewAlbumName = (TextView) view.findViewById(R.id.txtAlbumName);
            txtViewAlbumName.setText(song.getAlbumTitle());
            TextView txtViewSongDate = (TextView)view.findViewById(R.id.txtPublishedDate);
            if(song.getLastUpdatedDate()!=null){
                txtViewSongDate.setText(df.format(song.getSongPublishedDate()));
            }else{
                txtViewSongDate.setText("Unknown");
            }
            TextView txtYouTubeVideo = (TextView)view.findViewById(R.id.txtYouTubeVideo);
            if(song.getYoutubeId()!=null && song.getYoutubeId().length()>0){
                txtYouTubeVideo.setText(song.getYoutubeId());
            }else{
                txtYouTubeVideo.setText("No Video Found");
            }
        }

        Button btn = (Button)view.findViewById(R.id.btnSongList);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onReloadClick.reload();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        onReloadClick = (OnReloadClick) activity;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public interface OnReloadClick{
        public void reload();
    }
}
