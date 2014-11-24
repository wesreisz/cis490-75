package com.example.classlab7c.fragments;

import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.classlab7c.R;
import com.example.classlab7c.adapters.MusicListAdapter;
import com.example.classlab7c.listeners.OnItemSelectedListener;
import com.example.classlab7c.model.MenuItem;
import com.example.classlab7c.service.MockMusicListServiceImpl;

public class ListFragment extends Fragment {
	private static final String TAG = "ListFragment";
	
	private OnItemSelectedListener listener;
	private List<MenuItem>menuItems;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.list_fragment, container, false);
		
		//this is how we will interact with the services
		menuItems = MockMusicListServiceImpl.getInstance(getActivity()).getAllMenuItems();
		
		MusicListAdapter adapter =
				new MusicListAdapter(getActivity(), R.layout.listview_for_each_menuitem, menuItems);
		ListView listViewMusic = (ListView) view.findViewById(R.id.listViewMusic);
		listViewMusic.setAdapter(adapter);
		
		listViewMusic.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(
					AdapterView<?> parent, View view,int position, long id) {
			    String fragmentView = "layout" + (position+1);
			    Log.d(TAG, "opening fragmentview: " + fragmentView);
				updateDetail(fragmentView);
			}
		});
		
		return view;
	}
	
	//NPE is thrown if you attempt to run this before instantiating
	//the listener.
	//fragment activity lifecycle info:
	//  - http://developer.android.com/reference/android/app/Fragment.html
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity); 
		//this ensures that the activity implements the interface we defined.
		if (activity instanceof OnItemSelectedListener) {  
			listener = (OnItemSelectedListener) activity;  
		} else {  
			throw new ClassCastException(
				activity.toString() + " must implemenet MyListFragment.OnItemSelectedListener"
			);  
		} 
	}
	
	// May also be triggered from the Activity  
	public void updateDetail(String s) {          
		listener.onRssItemSelected(s);  
	} 
}
