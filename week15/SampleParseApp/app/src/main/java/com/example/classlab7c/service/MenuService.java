package com.example.classlab7c.service;

import java.util.ArrayList;
import java.util.List;

import com.example.classlab7c.model.MenuItem;

public class MenuService {
	private List<MenuItem> menu;
	private MenuService(){
		MenuItem menu0 = new MenuItem("Home", "Homepage");
		menu0.setMenuItemClass("com.example.classlab7c.fragments.HomeFragment");
		MenuItem menu1 = new MenuItem("Songs", "Shows all available songs");
		menu1.setMenuItemClass("com.example.classlab7c.fragments.SongFragment");
		MenuItem menu2 = new MenuItem("Artists", "Shows all available artists");
		menu2.setMenuItemClass("com.example.classlab7c.fragments.ArtistFragment");
		MenuItem menu3 = new MenuItem("Events", "Shows all available events");
		menu3.setMenuItemClass("com.example.classlab7c.fragments.EventFragment");
		
		menu = new ArrayList<MenuItem>();
		menu.add(menu0);
		menu.add(menu1);
		menu.add(menu2);
		menu.add(menu3);
	}
	public static List<MenuItem> getMenuItems(){
		MenuService service = new MenuService();
		return service.menu;
	}
}
