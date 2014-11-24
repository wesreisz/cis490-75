package com.example.classlab7c.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import android.content.Context;
import android.util.Log;

import com.example.classlab7c.model.Artist;
import com.example.classlab7c.model.Event;
import com.example.classlab7c.model.MenuItem;
import com.example.classlab7c.model.Song;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class MusicListServiceImpl implements IMusicService {
	private static IMusicService sPlayList;
	private boolean flushCache=false;
	List<Song>cachedSongs = null;
	List<Artist>cachedArtists = null;
	private Context mAppContext;
	 
	private MusicListServiceImpl(Context c){
		mAppContext = c;
	}
	
	public static IMusicService getInstance(Context c){
		if (sPlayList==null){
			sPlayList = new MusicListServiceImpl(c.getApplicationContext());
		}
		return sPlayList;
	}

	@Override
	public List<MenuItem> getAllMenuItems() {
		return MenuService.getMenuItems();
	}

	@Override
	public List<Song> getAllSongs() {
		clearCache();
		if(cachedSongs==null){
			ParseQuery<ParseObject> query = ParseQuery.getQuery("Song");
			query.whereEqualTo("userName", "wesreisz");
			final List<Song>listOfSongs = new ArrayList<Song>();

			query.findInBackground(new FindCallback<ParseObject>() {
			    @Override
				public void done(List<ParseObject> songs, ParseException e) {
					 if (e == null) {
			            Log.d("List Songs", "Retrieved " + songs.size() + " songs");
			            for (ParseObject s : songs) {
			            	Song song = new Song();
			            	song.setAlbumTitle((String)s.get("songAlbum"));
			            	song.setLastUpdatedDate((Date)s.get("updatedAt"));
			            	song.setSongTitle((String)s.get("songName"));
			            	song.setYoutubeId((String)s.get("songYouTubeId"));
			            	song.setArtistName((String)s.get("songArtistName"));
			            	listOfSongs.add(song);
			            }
					 } else {
			            Log.d("List Songs", "Error: " + e.getMessage());
					 }
				}
			});
			cachedSongs = listOfSongs;
		}else{
			Log.d("List Songs", "Using cached list of songs");
		}
		
		return cachedSongs;
	}

	@Override
	public List<Event> getAllEvents() {
		// get this from last.fm
		return null;
	}

	@Override
	public Artist getArtistNameByIt(int id) {
		// get artist from cache... if null go get it
		return null;
	}

	@Override
	public List<Artist> getAllArtists() {
		clearCache();
		List<Artist>uniqueArtistList = new ArrayList<Artist>();
		if(cachedSongs!=null){
			for(Song song: cachedSongs){
				boolean found = false;
				for(Artist artist : uniqueArtistList){
					if(song.getArtistName().equals(artist.getArtistName())){
						found = true;
					}
				}
				if(!found){
					Artist a = new Artist();
					a.setArtistName(song.getArtistName());
					uniqueArtistList.add(a);
				}
			}
		}
		
		return uniqueArtistList;
	}

	public void setFlushCache(boolean flushCache) {
		this.flushCache = flushCache;
	}
	private void clearCache(){
		if(flushCache){
			cachedSongs = null;
			flushCache=false;
		}
	}
}
