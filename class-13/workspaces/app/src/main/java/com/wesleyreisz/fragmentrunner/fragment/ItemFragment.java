package com.wesleyreisz.fragmentrunner.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wesleyreisz.fragmentrunner.R;


public class ItemFragment extends Fragment {
    private String city;

    public ItemFragment() {
        // Required empty public constructor
    }
    public static ItemFragment createInstance(String city) {
        // Required empty public constructor
        ItemFragment itemFragment = new ItemFragment();
        itemFragment.city = city;
        return itemFragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_item, container, false);
        TextView textView = (TextView)view.findViewById(R.id.textItem);
        textView.setText(city);
        return view;
    }



}
