package com.example.classlab7c.fragments;

import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.classlab7c.R;
import com.example.classlab7c.adapters.EventAdapter;
import com.example.classlab7c.model.Event;
import com.example.classlab7c.service.IMusicService;
import com.example.classlab7c.service.MockMusicListServiceImpl;

public class EventFragment extends Fragment {
	private static int ADD_BUTTON_POSITION = 0;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view =  inflater.inflate(R.layout.event_layout, container, false);
        /*
		
		IMusicService service = MockMusicListServiceImpl.getInstance(getActivity());
		List<Event>events = service.getAllEvents();
		
		EventAdapter adapter = 
			new EventAdapter(getActivity(), R.layout.listview_for_each_event, events);
		ListView listView = (ListView)view.findViewById(R.id.listViewEvents);
		listView.setAdapter(adapter);
		
		setHasOptionsMenu(true);
		*/
		
		return view;
	}
	
	@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.getItem(ADD_BUTTON_POSITION).setVisible(true);
    }

}
