package org.karan.social.messenger.resources.bean;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {
	
	private @QueryParam("Year") int Year;
	private @QueryParam("start") int start;
	private @QueryParam("size") int size;
	
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	

}
