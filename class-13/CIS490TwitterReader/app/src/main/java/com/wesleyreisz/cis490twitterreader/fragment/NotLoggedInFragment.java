package com.wesleyreisz.cis490twitterreader.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.wesleyreisz.cis490twitterreader.Config;
import com.wesleyreisz.cis490twitterreader.R;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class NotLoggedInFragment extends Fragment {

    //private OnFragmentInteractionListener mListener;

    Button btnLogin;
    Twitter twitter;
    RequestToken requestToken;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_not_logged_in, container, false);

        btnLogin = (Button) view.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ConfigurationBuilder builder = new ConfigurationBuilder();
                builder.setOAuthConsumerKey(Config.KEY_CONSUMER_KEY);
                builder.setOAuthConsumerSecret(Config.KEY_CONSUMER_SECRET);

                final Configuration configuration = builder.build();
                final TwitterFactory factory = new TwitterFactory(configuration);
                twitter = factory.getInstance();

                try {
                    requestToken = twitter.getOAuthRequestToken(Config.KEY_CALLBACK_URL);
                    String authUrl = requestToken.getAuthenticationURL();
                    // Open Fragment Dialog
                    FragmentManager fragmentManager = getFragmentManager();
                    LoginDialogFragment dialogFragment = LoginDialogFragment.getInstance(authUrl);
                    dialogFragment.show(fragmentManager,"appified_tag_priyabrat");

                } catch (TwitterException e) {
                    e.printStackTrace();
                }
            }
        });

        return view;
    }


    /*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }*/
}
