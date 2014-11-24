package com.example.classlab7c.adapters;

import java.text.SimpleDateFormat;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.classlab7c.AppConstants;
import com.example.classlab7c.MainActivity;
import com.example.classlab7c.R;
import com.example.classlab7c.model.Song;
import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class SongAdapter extends ArrayAdapter<Song>{
	protected static final int REQ_START_STANDALONE_PLAYER = 1;
	private SimpleDateFormat df = new SimpleDateFormat("yyyy/mm/dd"); 
	private Context mContext;
	private List<Song> mEntries;
	
	public SongAdapter(Context context,int textViewResourceId, List<Song> entries) { 
		super(context, textViewResourceId, entries);
	    mContext=context;
	    mEntries=entries; 
	}
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		if(view==null){
			 LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		     view = inflater.inflate(R.layout.listview_for_each_song, parent, false);
		}
		final Song song = mEntries.get(position);
		
		TextView textViewTitle = (TextView)view.findViewById(R.id.textViewSongTitle);
		textViewTitle.setText(song.getSongTitle());
		
		TextView textViewDescription = (TextView)view.findViewById(R.id.textViewSongDescription);
		textViewDescription.setText(song.getAlbumTitle());
		
		TextView textViewArtist = (TextView)view.findViewById(R.id.textViewSongArtist);
		textViewArtist.setText(song.getArtistName());
		
		final Context c = this.mContext;
		Button btnPlay = (Button)view.findViewById(R.id.btnPlay);
		btnPlay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
                /*
				int startIndex = 0;
				int startTimeMillis = 0;
				boolean autoplay = true;
				boolean lightboxMode = true;
				
				Intent intent = YouTubeStandalonePlayer.createVideoIntent(
				          (MainActivity)mContext, AppConstants.DEVELOPER_KEY, song.getYoutubeId(), startTimeMillis, autoplay, lightboxMode);
				Toast.makeText(v.getContext(), "Loading Youtube Player: " + song.getYoutubeId(), Toast.LENGTH_LONG).show();
				c.startActivity(intent);
				*/
                Log.d("SONG", "Play Song");
			}
		});

		return view;
	}
}
