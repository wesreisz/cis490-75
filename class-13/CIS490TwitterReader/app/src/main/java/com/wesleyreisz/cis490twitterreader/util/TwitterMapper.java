package com.wesleyreisz.cis490twitterreader.util;

import com.wesleyreisz.cis490twitterreader.model.Tweet;

/**
 * Created by wesleyreisz on 12/6/15.
 */
public class TwitterMapper {
    public static Tweet mapperTwitterObjectsToTweets(twitter4j.Status responseTweet ){
        Tweet tweet = new Tweet();
        tweet.setLocation(responseTweet.getGeoLocation());
        tweet.setCreatedTime(responseTweet.getCreatedAt());
        tweet.setContent(responseTweet.getText());
        tweet.setAuthor(responseTweet.getUser().getName());
        tweet.setAuthorScreenName(responseTweet.getUser().getScreenName());
        return tweet;

    }
}
