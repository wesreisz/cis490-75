package com.wesleyreisz.cis490twitterreader;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListTweetsFragment extends Fragment {

    public ListTweetsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_tweets, container, false);

        ListView listView = (ListView)view.findViewById(R.id.listViewTweets);
        List<String> tweets = new ArrayList<String>();
        tweets.add("Hello, I'm a tweet");
        tweets.add("#l1c4 we are bowling");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,tweets);
        listView.setAdapter(adapter);

        return view;
    }
}
