package com.wesleyreisz.mymusic.fragment;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wesleyreisz.mymusic.R;
import com.wesleyreisz.mymusic.model.Song;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by wesleyreisz on 10/18/15.
 */
public class SongAdapter extends ArrayAdapter<Song>{
    private SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy (EEE)");
    private Context context;
    private List<Song> songs;
    private int layout2Inflate;

    public SongAdapter(Context context, int resource, List<Song> songs) {
        super(context, resource, songs);
        this.context = context;
        this.layout2Inflate = resource;
        this.songs = songs;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout2Inflate,parent,false);
        }
        final Song song = songs.get(position);
        TextView textViewSongArtist = (TextView) convertView.findViewById(R.id.textViewSongArtist);
        textViewSongArtist.setText(song.getArtistName());
        TextView textViewSongTitle = (TextView) convertView.findViewById(R.id.textViewSongTitle);
        textViewSongTitle.setText(song.getSongTitle());
        TextView textViewSongDate = (TextView) convertView.findViewById(R.id.textViewSongDate);
        textViewSongDate.setText(df.format(song.getSongPublishedDate()));

        return convertView;
    }
}
