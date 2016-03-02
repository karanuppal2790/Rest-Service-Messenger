package org.karan.social.messenger.model;

import java.util.Date;

public class Comments {

	private long id;
	private String message;
	private Date datecreated;
	private String author;
	
	public Comments(){
		
	}
	
	public Comments(long id, String message, Date datecreated, String author) {
		super();
		this.id = id;
		this.message = message;
		this.datecreated = datecreated;
		this.author = author;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDatecreated() {
		return datecreated;
	}
	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
}
