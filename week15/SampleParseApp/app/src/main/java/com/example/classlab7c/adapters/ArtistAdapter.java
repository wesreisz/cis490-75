package com.example.classlab7c.adapters;

import java.util.List;

import android.content.Context;
import android.os.AsyncTask;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.classlab7c.R;
import com.example.classlab7c.model.Artist;
import com.example.classlab7c.service.ArtistService;

import de.umass.lastfm.Caller;

public class ArtistAdapter extends ArrayAdapter<Artist> {
	private Context mContext;
	private List<Artist> mEntries;
	private View currentView;

	public ArtistAdapter(Context context, int resource, List<Artist> artists) {
		super(context, resource, artists);
		this.mContext = context;
		this.mEntries = artists;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		if (view==null){
			LayoutInflater inflater =  (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.listview_for_each_artist, parent, false);
		}
		Artist artist = mEntries.get(position);
		new ArtistInfo().execute(artist);
		currentView = view;
		return view;
	}
	
	private class ArtistInfo extends AsyncTask<Artist, Void, Artist>{

		@Override
		protected Artist doInBackground(Artist... params) {
			Caller.getInstance().setCache(null);
			Artist artist = (Artist)params[0];
			Log.d("artist", "getting artist: " + artist.getArtistName());
			ArtistService service = ArtistService.getInstance(artist.getArtistName());
			String wikiDescription = service.getDescription();
			artist.setArtistWiki(wikiDescription);
			return artist;
		}

		@Override
		protected void onPostExecute(Artist artist) {
			//super.onPostExecute(artist);
			TextView textName = (TextView)currentView.findViewById(R.id.textViewArtistName);
			textName.setText(artist.getArtistName());
			
			TextView textDescription = (TextView)currentView.findViewById(R.id.textViewArtistDescription);
			textDescription.setText(Html.fromHtml(artist.getArtistWiki()));
	
		}	
	}
}
