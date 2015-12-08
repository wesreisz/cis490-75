package com.wesleyreisz.fragmentrunner.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wesleyreisz.fragmentrunner.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    List<String> places;
    ListFragmentInteractionListener listFragmentInteractionListener;
    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        ListView listView = (ListView)view.findViewById(R.id.listView);

        places = Arrays.asList("Buenos Aires", "Córdoba", "La Plata");

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,places);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String city = places.get(position);
                listFragmentInteractionListener.itemClicked(city);
            }
        });

        return view;
    }

    public interface ListFragmentInteractionListener{
        public void itemClicked(String city);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listFragmentInteractionListener = (ListFragmentInteractionListener) context;
    }
}
