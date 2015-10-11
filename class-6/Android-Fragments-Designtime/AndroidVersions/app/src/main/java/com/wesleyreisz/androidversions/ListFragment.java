package com.wesleyreisz.androidversions;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFragment extends Fragment {
    ArrayAdapter<String> adapter;
    ListView listView;
    String[] versions;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_list, container, false);

        listView = (ListView)view.findViewById(R.id.listViewItems);
        versions = getResources().getStringArray(R.array.versions);
        adapter = new ArrayAdapter<String>(getActivity(),R.layout.item, R.id.rowItem, versions);
        listView.setAdapter(adapter);

        return view;

    }


}
