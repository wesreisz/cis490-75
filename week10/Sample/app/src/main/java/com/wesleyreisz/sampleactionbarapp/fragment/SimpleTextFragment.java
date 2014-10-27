package com.wesleyreisz.sampleactionbarapp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wesleyreisz.sampleactionbarapp.R;

/**
 * Created by wesleyreisz on 10/26/14.
 */
public class SimpleTextFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_simple, container, false);
        return rootView;
    }
}
