package org.karan.social.messenger.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.karan.social.messenger.database.database;
import org.karan.social.messenger.model.Comments;
import org.karan.social.messenger.model.Messages;

public class CommentsService {

	private Map<Long,Messages> messagedata=database.getMessages();
	
	public List<Comments> getAllComments(long messageid){
	Messages message =messagedata.get(messageid);
	return new ArrayList<Comments>(message.getComments().values());		
	}
	
	public Comments getComment(long messageid, long commentid){
		Messages message =messagedata.get(messageid);
		return message.getComments().get(commentid);		
	}
	
	public Comments addComment(long messageid, Comments comment){
		Messages message=messagedata.get(messageid);
		comment.setId(message.getComments().size() + 1);
		message.getComments().put(comment.getId(), comment);
		return comment;		
	}
	
	public Comments updateComment(long messageid, long commentid, Comments comment){
		Messages message=messagedata.get(messageid);
		long id=message.getComments().get(commentid).getId();
		message.getComments().put(id, comment);
		return comment;
	}
	
	public Comments removeComment(long messageid, long commentid){
		Messages message=messagedata.get(messageid);
		long id=message.getComments().get(commentid).getId();
		return message.getComments().remove(id);
	}
}
