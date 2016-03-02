package org.karan.social.messenger.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.karan.social.messenger.database.database;
import org.karan.social.messenger.model.Messages;

public class MessageService {
	
	private Map<Long,Messages> messagedata=database.getMessages();
	
	
	/*public MessageService() {
		Messages Message=new Messages();
		Message.setId(1);
		Message.setAuthor("Karan");
		Message.setDatecreated(new Date());
		Message.setMessage("Hello Karan Uppal");
		messagedata.put((long) 1,Message);
		Messages Message2=new Messages();
		Message2.setId(2);
		Message2.setAuthor("Shivi");
		Message2.setDatecreated(new Date());
		Message2.setMessage("Hello Shivi Uppal");
		messagedata.put((long) 2,Message2);
		
	}
*/
	public List<Messages> getAllMessages(){
		return new ArrayList<Messages>(messagedata.values());
		}
	
	public List<Messages> getAllMessagesforYear(int Year){
		List<Messages> list=new ArrayList<Messages>();
		Calendar cal= Calendar.getInstance();
		for(Messages message : messagedata.values()){
			cal.setTime(message.getDatecreated());
			if(cal.get(Calendar.YEAR)==Year)
				list.add(message);
		}		
		return list;
		}
	
	public List<Messages> getAllMessagesPaginated(int start, int size){
		List<Messages> messagelist = new ArrayList<Messages>(messagedata.values());
		if((start+size)>messagelist.size())
			return null;
		else
		return messagelist.subList(start, start + size);
	}
	
	public Messages getMessage(long id){
		return messagedata.get(id);		
	}
	
	public Messages addMessage(Messages Message){
		Message.setId(messagedata.size() +1);
		messagedata.put(Message.getId(), Message);
		return Message;
	}
	 public Messages updateMessage(Messages Message){
		 if(Message.getId()<=0){
			 return null;
		 }
		 else
		 {
		 messagedata.put(Message.getId(), Message);
		 return Message;
		 }
	}
	
	 public Messages removeMessage(long id){
		 return messagedata.remove(id); // returns the value that was removed
	 }
	

}
	