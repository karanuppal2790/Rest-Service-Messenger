package org.karan.social.messenger.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Messages {
	
	private long id;
	private String message;
	private Date datecreated;
	private String author;
	
	private Map<Long, Comments> comments=new HashMap<>();
	
	public Messages(){
		
	}
	
	public Messages(long id, String message,String author) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.datecreated = new Date();
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
	
	@XmlTransient
	public Map<Long, Comments> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comments> comments) {
		this.comments = comments;
	}

}
