package com.wesleyreisz.mymusic.model;

import java.util.Date;

/**
 * Created by wesleyreisz on 10/16/14.
 */
public class Song {
    private int songId;
    private String songTitle;
    private String albumTitle;
    private Date songPublishedDate;
    private Date lastUpdatedDate;
    private String youtubeId;
    private String artistName;

    public Song(){}

    public Song(String songTitle, String artist, String album, Date songPublishedDate) {
        this.songTitle=songTitle;
        this.artistName=artist;
        this.albumTitle=album;
        this.songPublishedDate=songPublishedDate;
    }


    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public Date getSongPublishedDate() {
        return songPublishedDate;
    }

    public void setSongPublishedDate(Date songPublishedDate) {
        this.songPublishedDate = songPublishedDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
