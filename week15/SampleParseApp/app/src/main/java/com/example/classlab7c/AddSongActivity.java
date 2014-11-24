package com.example.classlab7c;

import java.util.Date;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.classlab7c.service.IMusicService;
import com.example.classlab7c.service.MusicListServiceImpl;
import com.example.classlab7c.utils.SecurityUtils;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class AddSongActivity extends Activity {

    private static final String TAG = "SONG";

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_add_song);
		setupActionBar();
		setFullTitle();
		
		Parse.initialize(this,
				SecurityUtils.APP_ID,
				SecurityUtils.APP_SECRET
			);
		
		ParseAnalytics.trackAppOpened(getIntent());
	}

	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void addSongToBackend(View v){
		showToast("Adding Song");
		
		EditText songName = (EditText)findViewById(R.id.song_title);
		EditText songAlbum = (EditText)findViewById(R.id.song_album);
		EditText songArtistName = (EditText)findViewById(R.id.song_artist_name);
		EditText songYouTubeId = (EditText)findViewById(R.id.song_youtube_id);
		
		ParseObject addSongObject = new ParseObject("Song");
		addSongObject.put("songName", songName.getText().toString());
		addSongObject.put("songAlbum", songAlbum.getText().toString());
		addSongObject.put("songArtistName", songArtistName.getText().toString());
		addSongObject.put("userName", "wesreisz");
		addSongObject.put("songYouTubeId", songYouTubeId.getText().toString());
		addSongObject.saveInBackground(new SaveCallback() {
           @Override
           public void done(ParseException e) {
               IMusicService service = MusicListServiceImpl.getInstance(AddSongActivity.this);
               service.setFlushCache(true);
               Log.d(TAG, "Flushed cache");
           }
        });

        finish();
	}
	
	private void showToast(String message) {
    	Toast t = Toast.makeText(this, message, Toast.LENGTH_SHORT);
    	t.show();
    }

	private void setFullTitle(){
    	ActionBar actionBar = getActionBar();
    	actionBar.setSubtitle("Super kewl subtitle");
    	actionBar.show();
    }

}
