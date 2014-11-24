package com.example.classlab7c.service;

import java.util.List;

import com.example.classlab7c.model.Artist;
import com.example.classlab7c.model.Event;
import com.example.classlab7c.model.MenuItem;
import com.example.classlab7c.model.Song;

public interface IMusicService {

	public abstract List<MenuItem> getAllMenuItems();

	public abstract List<Song> getAllSongs();

	public abstract List<Event> getAllEvents();

	public abstract Artist getArtistNameByIt(int id);

	public abstract List<Artist> getAllArtists();
	
	public abstract void setFlushCache(boolean flushCache);

}