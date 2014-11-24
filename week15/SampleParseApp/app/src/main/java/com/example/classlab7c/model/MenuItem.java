package com.example.classlab7c.model;

public class MenuItem {
	private String menuTitle;
	private String menuDescription;
	private String menuItemClass;
	
	public MenuItem(String menuTitle, String menuDescription) {
		super();
		this.menuTitle = menuTitle;
		this.menuDescription = menuDescription;
	}
	
	public String getMenuItemClass() {
		return menuItemClass;
	}

	public void setMenuItemClass(String menuItemClass) {
		this.menuItemClass = menuItemClass;
	}

	public String getMenuTitle() {
		return menuTitle;
	}
	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}
	public String getMenuDescription() {
		return menuDescription;
	}
	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((menuDescription == null) ? 0 : menuDescription.hashCode());
		result = prime * result
				+ ((menuTitle == null) ? 0 : menuTitle.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (menuDescription == null) {
			if (other.menuDescription != null)
				return false;
		} else if (!menuDescription.equals(other.menuDescription))
			return false;
		if (menuTitle == null) {
			if (other.menuTitle != null)
				return false;
		} else if (!menuTitle.equals(other.menuTitle))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MenuItems [menuTitle=" + menuTitle + ", menuDescription="
				+ menuDescription + "]";
	}
}
