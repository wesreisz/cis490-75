package com.wesleyreisz.cis490twitterreader.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wesleyreisz.cis490twitterreader.R;
import com.wesleyreisz.cis490twitterreader.model.Tweet;

import java.util.ArrayList;

/**
 * Created by wesleyreisz on 12/6/15.
 */
public class TweetAdapter extends ArrayAdapter<Tweet> {

        private ArrayList<Tweet> tweets;
        private int item_layout;

        public TweetAdapter(Context context,
                                int textViewResourceId,
                                ArrayList<Tweet> items) {
            super(context, textViewResourceId, items);
            this.tweets = items;
            this.item_layout = textViewResourceId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(item_layout, null);
            }
            Tweet o = tweets.get(position);
            TextView tt = (TextView) v.findViewById(R.id.toptext);
            TextView bt = (TextView) v.findViewById(R.id.bottomtext);
            TextView created = (TextView) v.findViewById(R.id.createdDate);
            if(o.getContent()!=null){
                tt.setText(o.getContent());
            }
            if(o.getAuthor()!=null) {
                bt.setText("@" + o.getAuthorScreenName());
            }
            if(o.getCreatedTime()!=null) {
                created.setText(o.getCreatedTime().toString());
            }

            return v;
        }
    }