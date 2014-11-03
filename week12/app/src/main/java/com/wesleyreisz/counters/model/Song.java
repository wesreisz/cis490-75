package com.wesleyreisz.counters.model;

import java.util.Arrays;

/**
 * Created by wesleyreisz on 11/2/14.
 */
public class Song {
    private String title;
    private String[] image;
    private String artist;
    private String releaseDate;
    private String album;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getImage() {
        return image;
    }

    public void setImage(String[] image) {
        this.image = image;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", image=" + Arrays.toString(image) +
                ", artist='" + artist + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", album='" + album + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        if (album != null ? !album.equals(song.album) : song.album != null) return false;
        if (artist != null ? !artist.equals(song.artist) : song.artist != null) return false;
        if (!Arrays.equals(image, song.image)) return false;
        if (releaseDate != null ? !releaseDate.equals(song.releaseDate) : song.releaseDate != null)
            return false;
        if (title != null ? !title.equals(song.title) : song.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (image != null ? Arrays.hashCode(image) : 0);
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (album != null ? album.hashCode() : 0);
        return result;
    }
}
