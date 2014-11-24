package com.example.classlab7c.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.classlab7c.R;
import com.example.classlab7c.model.MenuItem;

public class MusicListAdapter extends ArrayAdapter<MenuItem>{
	private List<MenuItem> mEntries;
	private Context mContext;
	
	public MusicListAdapter(Context context,int textViewResourceId, List<MenuItem> entries) { 
		super(context, textViewResourceId, entries);
	    mContext=context;
	    mEntries=entries;      
    }

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		if(view==null){
			 LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		     view = inflater.inflate(R.layout.listview_for_each_menuitem, parent, false);
		}
		MenuItem menuItem = mEntries.get(position);
		
		TextView textViewTitle = (TextView)view.findViewById(R.id.textViewTitle);
		textViewTitle.setText(menuItem.getMenuTitle());
		TextView textViewDescription = (TextView)view.findViewById(R.id.textViewDescription);
		textViewDescription.setText(menuItem.getMenuDescription());
		
		return view;
	}
}
