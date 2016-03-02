package org.karan.social.messenger.resources;


import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.karan.social.messenger.Service.MessageService;
import org.karan.social.messenger.model.Messages;
import org.karan.social.messenger.resources.bean.MessageFilterBean;

@Path("/messages")
public class messageresource {
	MessageService messageservice=new MessageService();
	
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Messages> getAllMessages(@BeanParam MessageFilterBean filterbean){
		if (filterbean.getYear()>0)
			return messageservice.getAllMessagesforYear(filterbean.getYear());
		else if(filterbean.getStart()>=0 && filterbean.getSize()>0)
			return messageservice.getAllMessagesPaginated(filterbean.getStart(), filterbean.getSize());
		else
			return messageservice.getAllMessages();
	}
	
	@Path("/{messageid}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Messages getMessage(@PathParam("messageid") long messageId)
	{
		return messageservice.getMessage(messageId);
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public Messages addMessages(Messages Message){
		return messageservice.addMessage(Message);
	}
	
	@Path("/{messageid}")
	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	public Messages deleteMessage(@PathParam("messageid") long messageId){
		return messageservice.removeMessage(messageId);
	}
	
	@Path("/{messageid}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@PUT
	public Messages updateMessages(@PathParam("messageid") long messageId, Messages Message){
		Message.setId(messageId);
		return messageservice.updateMessage(Message);
	}
	
	// This is being used as the Sub Resource and here the Comment Resource class is being Returned
	@Path("/{messageid}/comments")
	public CommentsResources CommentsSubResource(){
		return new CommentsResources();
	}
}
