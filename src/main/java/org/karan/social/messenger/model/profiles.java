package org.karan.social.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class profiles {

	private long id;
	private String firstname;
	private String lastname;
	private String profilename;
	private Date datecreated;
	
	public profiles(){
		
	}
	public profiles(long id, String firstname, String lastname,
			String profilename) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.profilename = profilename;
		this.datecreated = new Date();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getProfilename() {
		return profilename;
	}
	public void setProfilename(String profilename) {
		this.profilename = profilename;
	}
	public Date getDatecreated() {
		return datecreated;
	}
	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}
	
	
	
}
