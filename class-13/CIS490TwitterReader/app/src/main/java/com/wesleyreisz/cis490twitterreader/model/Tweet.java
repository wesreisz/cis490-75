package com.wesleyreisz.cis490twitterreader.model;

import java.util.Date;

import twitter4j.GeoLocation;

/**
 * Created by wesleyreisz on 12/6/15.
 */
public class Tweet {
    private String author;
    private String content;
    private GeoLocation location;
    private Date createdTime;
    private String authorScreenName;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public GeoLocation getLocation() {
        return location;
    }

    public void setLocation(GeoLocation location) {
        this.location = location;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public void setAuthorScreenName(String authorScreenName) {
        this.authorScreenName = authorScreenName;
    }

    public String getAuthorScreenName() {
        return authorScreenName;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", location=" + location +
                ", createdTime=" + createdTime +
                ", authorScreenName='" + authorScreenName + '\'' +
                '}';
    }
}
