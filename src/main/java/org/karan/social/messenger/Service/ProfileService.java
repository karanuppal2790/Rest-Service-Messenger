package org.karan.social.messenger.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.karan.social.messenger.database.database;
import org.karan.social.messenger.model.Messages;
import org.karan.social.messenger.model.profiles;

public class ProfileService {
	
	private Map<String,profiles> profiledata=database.getProfiles();
	
	public ProfileService(){
		profiledata.put("karanuppal2790", new profiles(1,"Karan","Uppal","karanuppal2790"));
	}
	
	public List<profiles> getAllprofiles(){
		return new ArrayList<profiles>(profiledata.values());		
	}
	
	public profiles getProfile(String name){
		return profiledata.get(name);
	}
	
	public profiles addProfile(profiles profile){
		profile.setId(profiledata.size()+1);
		profiledata.put(profile.getProfilename(), profile);
		return profile;
	}
	
	public profiles updateProfile(profiles profile){
		profiles profilecheck=profiledata.get(profile.getProfilename());
		if(profilecheck!=null){
			profiledata.put(profile.getProfilename(), profile);
			return profile;
		}
		else
			return null;
	}
	
	public profiles removeProfile(String name){
		return profiledata.remove(name);
	}

}
