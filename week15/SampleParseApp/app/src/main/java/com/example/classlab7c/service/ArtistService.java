package com.example.classlab7c.service;

import com.example.classlab7c.AppConstants;

import de.umass.lastfm.Artist;
import de.umass.lastfm.ImageSize;

public class ArtistService {
	private Artist artist=null;
	private ArtistService(String artistName){
		artist = Artist.getInfo(artistName, AppConstants.LAST_FM_API_KEY);
	}
	public static ArtistService getInstance(String artistName){
		return new ArtistService(artistName);
	}
	public String getDescription(){
		return artist.getWikiSummary();
	}
	public String getImage(){
		return artist.getImageURL(ImageSize.SMALL);
	}
}
