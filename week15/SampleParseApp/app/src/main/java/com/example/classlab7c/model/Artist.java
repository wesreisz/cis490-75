package com.example.classlab7c.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.classlab7c.service.ArtistService;

public class Artist {
	private int artistId;
	private String artistName;
	private String artistWiki;
	private String imageUrl;
	private List<Song> songsList;
	private List<Event> toursList;
	private Date lastModifiedDate;
	
	public Artist(int id, String name, List<Song>songs, List<Event>tours){
		this.artistId=id;
		this.artistName=name;
		this.songsList = new ArrayList<Song>();
		for(Song song:songs){
			songsList.add(song);
		}
		this.toursList = new ArrayList<Event>();
		for(Event tour:tours){
			toursList.add(tour);
		}
	}

	
	public Artist() {
	}

	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public String getArtistWiki() {
		return artistWiki;
	}


	public void setArtistWiki(String artistWiki) {
		this.artistWiki = artistWiki;
	}


	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public List<Song> getSongs() {
		return songsList;
		//return ArtistService.getInstance(artistName).getSongs();
	}

	public void setSongs(List<Song> songs) {
		this.songsList = songs;
	}

	public List<Event> getTours() {
		return toursList;
	}

	public void setTours(List<Event> tours) {
		this.toursList = tours;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + artistId;
		result = prime * result
				+ ((artistName == null) ? 0 : artistName.hashCode());
		result = prime
				* result
				+ ((lastModifiedDate == null) ? 0 : lastModifiedDate.hashCode());
		result = prime * result + ((songsList == null) ? 0 : songsList.hashCode());
		result = prime * result + ((toursList == null) ? 0 : toursList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artist other = (Artist) obj;
		if (artistId != other.artistId)
			return false;
		if (artistName == null) {
			if (other.artistName != null)
				return false;
		} else if (!artistName.equals(other.artistName))
			return false;
		if (lastModifiedDate == null) {
			if (other.lastModifiedDate != null)
				return false;
		} else if (!lastModifiedDate.equals(other.lastModifiedDate))
			return false;
		if (songsList == null) {
			if (other.songsList != null)
				return false;
		} else if (!songsList.equals(other.songsList))
			return false;
		if (toursList == null) {
			if (other.toursList != null)
				return false;
		} else if (!toursList.equals(other.toursList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", artistName=" + artistName
				+ ", songs=" + songsList + ", tours=" + toursList
				+ ", lastModifiedDate=" + lastModifiedDate + "]";
	}
	
	
	
}
