package org.karan.social.messenger.resources;

import java.util.ArrayList;
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

import org.karan.social.messenger.Service.ProfileService;
import org.karan.social.messenger.model.profiles;

@Path("/profiles")
public class profileresources {
	
	ProfileService profileservice=new ProfileService();
	
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<profiles> getAllprofiles(){
		return profileservice.getAllprofiles();
			}
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profilename}")
	@GET
	public profiles getProfile(@PathParam("profilename") String name){
		return profileservice.getProfile(name);
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public profiles addProfile(profiles profile){
		return profileservice.addProfile(profile);		
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{profilename}")
	@PUT
	public profiles updateProfile(@PathParam("profilename") String profilename, profiles profile)
	{	
		profile.setProfilename(profilename);
		return profileservice.updateProfile(profile);
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profilename}")
	@DELETE
	public profiles removeProfile(@PathParam("profilename") String profilename){
		return profileservice.removeProfile(profilename);
		}
}
