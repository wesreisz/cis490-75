package com.wesleyreisz.mymusiclist;

import java.util.Date;

/**
 * Created by wesleyreisz on 10/13/14.
 */
public class Song {
    private String name;
    private String artist;
    private String album;
    private Date publishedDate;

    public Song(){}

    public Song(String name, String artist, String album, Date publishedDate) {
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.publishedDate = publishedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        if (!album.equals(song.album)) return false;
        if (!artist.equals(song.artist)) return false;
        if (!name.equals(song.name)) return false;
        if (!publishedDate.equals(song.publishedDate)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + artist.hashCode();
        result = 31 * result + album.hashCode();
        result = 31 * result + publishedDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", publishedDate=" + publishedDate +
                '}';
    }
}
