package org.karan.social.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.karan.social.messenger.model.Messages;
import org.karan.social.messenger.model.profiles;

public class database {
	
	private static Map<Long, Messages> messages=new HashMap<>();
	private static Map<String, profiles> profiles=new HashMap<>();
	
	public static Map<Long, Messages> getMessages(){
		return messages;
	}
	
	public static Map<String, profiles> getProfiles(){
		return profiles;
	}

}
