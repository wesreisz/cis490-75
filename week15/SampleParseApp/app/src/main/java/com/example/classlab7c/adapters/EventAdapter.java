package com.example.classlab7c.adapters;

import java.text.SimpleDateFormat;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.classlab7c.R;
import com.example.classlab7c.model.Event;
import com.example.classlab7c.service.MockMusicListServiceImpl;

public class EventAdapter extends ArrayAdapter<Event> {
	private SimpleDateFormat df = new SimpleDateFormat("EEE MMM d, ''yy"); 
	private Context mContext;
	private List<Event> mEntries;
	
	public EventAdapter(Context context, int resource, List<Event> events) {
		super(context, resource, events);
		this.mContext = context;
		this.mEntries = events;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		if (view==null){
			LayoutInflater inflater =  (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.listview_for_each_event, parent, false);
		}
		Event event = mEntries.get(position);
		
		TextView title= (TextView)view.findViewById(R.id.textViewEventTitle);
		title.setText(event.getEventName());
		
		TextView artistName = (TextView)view.findViewById(R.id.textViewArtistNameForEvent);
		artistName.setText(MockMusicListServiceImpl.getInstance(getContext()).getArtistNameByIt(event.getArtistId()).getArtistName());//we need to replace this with the actual artist name
		
		TextView eventDate = (TextView)view.findViewById(R.id.textViewDate);
		eventDate.setText(df.format(event.getDate()));
		
		TextView location = (TextView)view.findViewById(R.id.textViewDetails);
		location.setText(event.getLocation());
		
		return view;
	}
	
	
	
}
