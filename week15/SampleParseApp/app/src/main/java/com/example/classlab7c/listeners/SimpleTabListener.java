package com.example.classlab7c.listeners;

import android.R;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;

public class SimpleTabListener implements ActionBar.TabListener {
	private Context mContext;
	private String mTabFragmentClassName;
	private Fragment mTabFragment = null;

	public SimpleTabListener(Context c, String tabFragmentClassName){
		this.mContext = c;
		this.mTabFragmentClassName = tabFragmentClassName;
	}
	
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		if (mTabFragment==null){
			mTabFragment = Fragment.instantiate(mContext, mTabFragmentClassName);
			ft.add(R.id.content, mTabFragment); //R.id.content is a constant for the current content
		}else{
			ft.attach(mTabFragment);
		}
	}
	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		//nothing todo 
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		ft.detach(mTabFragment);
	}


}
