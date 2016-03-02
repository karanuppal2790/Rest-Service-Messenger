package org.karan.social.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.karan.social.messenger.Service.CommentsService;
import org.karan.social.messenger.model.Comments;

@Path("/")
public class CommentsResources {
	
	CommentsService commentservice=new CommentsService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comments> getAllComments(@PathParam("messageid") long messageid){
		return commentservice.getAllComments(messageid);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{commentid}")
	public Comments getComment(@PathParam("commentid") long commentid, @PathParam("messageid") long messageid){
		return commentservice.getComment(messageid, commentid);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)		
	public Comments addComment(@PathParam("messageid") long messageid, Comments comment){
		return commentservice.addComment(messageid, comment);
	}
	
	@Path("{commentid}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Comments removeComment(@PathParam("messageid") long messageid,@PathParam("commentid") long commentid){
		return commentservice.removeComment(messageid, commentid);
	}
	
	@PUT
	@Path("{commentid}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Comments updateComment(@PathParam("commentid") long commentid, @PathParam("messageid") long messageid,Comments comment){
	return commentservice.updateComment(messageid, commentid, comment);	
	}
	}
