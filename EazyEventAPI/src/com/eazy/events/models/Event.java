package com.eazy.events.models;

import java.sql.Time;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Event {
	
	private String eventid;
	private String name;
	private String description;
	private String street;
	private String city;
	private String state;
	private int zipcode;
	private Date date;
	private int maxcapacity;
	private int registeredusers;
	private boolean isfinished;
	private String organizer;
	private String time;
	
	public Event() {}
	
	public Event(String eventId, String name, String description, String street, String city, String state, int zipcode,
			Date date, int maxcapacity, int registeredusers, boolean isFinished, String organizer, Time time) {
		super();
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.eventid = eventId;
		this.name = name;
		this.description = description;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.date = date;
		this.time = String.valueOf(time.toString());
		this.maxcapacity = maxcapacity;
		this.registeredusers = registeredusers;
		this.isfinished = isFinished;
		this.organizer = organizer;
	}	
	public String getEventid() {
		return eventid;
	}
	public void setEventid(String eventid) {
		this.eventid = eventid;
	}
	public boolean isIsfinished() {
		return isfinished;
	}
	public void setIsfinished(boolean isfinished) {
		this.isfinished = isfinished;
	}
	public String getTime() {
		return String.valueOf(time);
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getMaxcapacity() {
		return maxcapacity;
	}
	public void setMaxcapacity(int maxcapacity) {
		this.maxcapacity = maxcapacity;
	}
	public int getRegisteredusers() {
		return registeredusers;
	}
	public void setRegisteredusers(int registeredusers) {
		this.registeredusers = registeredusers;
	}
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
}
