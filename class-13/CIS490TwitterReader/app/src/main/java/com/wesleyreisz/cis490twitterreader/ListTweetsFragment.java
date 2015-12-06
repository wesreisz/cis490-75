package com.wesleyreisz.cis490twitterreader;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wesleyreisz.cis490twitterreader.model.Tweet;
import com.wesleyreisz.cis490twitterreader.util.TwitterMapper;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListTweetsFragment extends Fragment {
    List<String> tweets;
    ArrayAdapter<String> adapter;

    public ListTweetsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_tweets, container, false);

        ListView listView = (ListView)view.findViewById(R.id.listViewTweets);
        tweets = new ArrayList<String>();
        tweets.add("test");
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,tweets);
        listView.setAdapter(adapter);

        new GetTweetAsyncTask(getActivity()).execute("from:wesreisz");

        return view;
    }

    public class GetTweetAsyncTask extends AsyncTask<String,Void,List<Tweet>> {
        private Activity activity;

        public GetTweetAsyncTask(Activity activity) {
            this.activity = activity;
        }

        @Override
        protected List<Tweet> doInBackground(String... params) {
            List<Tweet>tweets = new ArrayList<Tweet>();
            try {
                ConfigurationBuilder builder = new ConfigurationBuilder();
                builder.setOAuthConsumerKey(Config.KEY_CONSUMER_KEY);
                builder.setOAuthConsumerSecret(Config.KEY_CONSUMER_SECRET);
                SharedPreferences preferences = activity.getSharedPreferences(Config.PREF_NAME, 0);
                String access_token = preferences.getString(Config.KEY_OAUTH_TOKEN, "");
                String access_token_secret = preferences.getString(Config.KEY_OAUTH_SECRET, "");
                AccessToken accessToken = new AccessToken(access_token, access_token_secret);

                Twitter twitter = new TwitterFactory(builder.build()).getInstance(accessToken);
                Query query = new Query(params[0]);

                try{
                    QueryResult response = twitter.search(query);
                    for (twitter4j.Status responseTweet : response.getTweets()) {
                        Tweet tweet = TwitterMapper.mapperTwitterObjectsToTweets(responseTweet);
                        tweets.add(tweet);
                        Log.d("TAG", "@" + tweet.toString());
                    }
                }catch(Exception e){
                    Log.d("TAG", e.getMessage());
                    e.printStackTrace();
                }

            } catch (Exception e) {
                Log.d("Failed to post!", e.getMessage());
            }
            return tweets;
        }

        @Override
        protected void onPostExecute(List<Tweet> tweetList) {
            super.onPostExecute(tweetList);
            tweets.clear();
            for(Tweet t:tweetList){
                tweets.add(t.toString());
            }

            adapter.notifyDataSetChanged();
        }
    }
}
