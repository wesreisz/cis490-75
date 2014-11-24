package com.example.classlab7c.model;

import java.util.Date;

public class Event {
	private int tourId;
	private int artistId;
	private String eventName;
	private Date date;
	private String location;
	
	public Event(int id, int artistId, String eventName, Date date, String location){
		this.tourId=id;
		this.artistId=artistId;
		this.eventName=eventName;
		this.date=date;
		this.location = location;
	}

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + artistId;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((eventName == null) ? 0 : eventName.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + tourId;
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
		Event other = (Event) obj;
		if (artistId != other.artistId)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (eventName == null) {
			if (other.eventName != null)
				return false;
		} else if (!eventName.equals(other.eventName))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (tourId != other.tourId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [tourId=" + tourId + ", artistId=" + artistId
				+ ", eventName=" + eventName + ", date=" + date + ", location="
				+ location + "]";
	}
	
	
}
