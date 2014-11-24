package com.example.classlab7c.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.Context;

import com.example.classlab7c.model.Artist;
import com.example.classlab7c.model.Event;
import com.example.classlab7c.model.MenuItem;
import com.example.classlab7c.model.Song;

public class MockMusicListServiceImpl implements IMusicService  {
	private SimpleDateFormat df = new SimpleDateFormat("yyyy/mm/dd"); 
	
	private static IMusicService sPlayList;
	private Context mAppContext;
	
	private List<Song> songs;
	private List<Event> events;
	private List<Artist> artists;
	private List<MenuItem> menu;
	
	//this is called a static initializer block
	{
		try {
			Event t1 = new Event(1, 2, "Jason Mraz North American Tour", df.parse("2014/01/17"),"Louisville, KY");
			Event t2 = new Event(1, 2, "Jason Mraz North American Tour", df.parse("2014/01/23"),"Little Rock, AK");
			Event t3 = new Event(1, 1, "Horseshoe Casino", df.parse("2013/11/5"),"Louisville, KY");
			Event t4 = new Event(1, 1, "Nashville War Memorial", df.parse("2013/11/14"),"Nashville, TN");
			
			Song s1 = new Song(1,"Kryptonite", "The Better Life", df.parse("2000/01/17"),"MSAAKvP105A");
			Song s2 = new Song(2,"Loser", "The Better Life", df.parse("2000/01/17"),"2Ui_Q4qBDJY");
			Song s3 = new Song(3,"I'm Yours", "I'm Yours", df.parse("2008/05/13"),"EkHTsc9PU2A");
			
			List<Song>songList1 = new ArrayList<Song>();
			songList1.add(s1);
			songList1.add(s2);
			
			Artist a1 = new Artist(1,"3 Doors Down", Arrays.asList(s1, s2), Arrays.asList(t3, t4));
			Artist a2 = new Artist(2,"Jason Mraz",Arrays.asList(s3), Arrays.asList(t1, t2));
		
			events = new ArrayList<Event>();
			events.add(t1);
			events.add(t2);
			events.add(t3);
			events.add(t4);
			
			songs = new ArrayList<Song>();
			songs.add(s1);
			songs.add(s2);
			songs.add(s3);
			
			artists = new ArrayList<Artist>();
			artists.add(a1);
			artists.add(a2);
			
			menu = MenuService.getMenuItems();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private MockMusicListServiceImpl(Context c){
		mAppContext = c;
	}
	
	public static IMusicService getInstance(Context c){
		if (sPlayList==null){
			sPlayList = new MockMusicListServiceImpl(c.getApplicationContext());
		}
		return sPlayList;
	}
	
	/* (non-Javadoc)
	 * @see com.example.classlab7c.service.IMusicService#getAllMenuItems()
	 */
	@Override
	public List<MenuItem> getAllMenuItems(){
		return menu;
	}
	/* (non-Javadoc)
	 * @see com.example.classlab7c.service.IMusicService#getAllSongs()
	 */
	@Override
	public List<Song> getAllSongs(){
		return songs;
	}
	/* (non-Javadoc)
	 * @see com.example.classlab7c.service.IMusicService#getAllEvents()
	 */
	@Override
	public List<Event> getAllEvents(){
		return events;
	}
	/* (non-Javadoc)
	 * @see com.example.classlab7c.service.IMusicService#getArtistNameByIt(int)
	 */
	@Override
	public Artist getArtistNameByIt(int id){
		for(Artist artist:artists){
			if(artist.getArtistId()==id){
				return artist;
			}
		}
		return new Artist(0,"",new ArrayList<Song>(),new ArrayList<Event>());
	}

	/* (non-Javadoc)
	 * @see com.example.classlab7c.service.IMusicService#getAllArtists()
	 */
	@Override
	public List<Artist> getAllArtists() {
		return artists;
	}

	@Override
	public void setFlushCache(boolean flushCache) {
		// TODO Auto-generated method stub
		
	}
}
