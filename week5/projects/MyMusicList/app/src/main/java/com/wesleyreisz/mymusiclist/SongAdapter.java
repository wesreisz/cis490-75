package com.wesleyreisz.mymusiclist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by wesleyreisz on 10/13/14.
 */
public class SongAdapter extends ArrayAdapter<Song>{
    private SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy (EEE");
    private Context mContext;
    private List<Song>mSongs;

    public SongAdapter(Context context, int textViewResourceId, List<Song> songs) {
        super(context, textViewResourceId, songs);
        this.mContext = context;
        this.mSongs = songs;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_for_each_song, parent, false);
        }

        final Song song = mSongs.get(position);

        TextView textViewTitle = (TextView)convertView.findViewById(R.id.textViewSongTitle);
        textViewTitle.setText(song.getName() + " (" + song.getArtist() + ")");

        TextView textViewAlbum = (TextView)convertView.findViewById(R.id.textViewSongArtist);
        textViewAlbum.setText(song.getAlbum());

        TextView textViewPublishedDate = (TextView)convertView.findViewById(R.id.textViewSongDate);
        textViewPublishedDate.setText(df.format(song.getPublishedDate()));

        return convertView;
    }
}
