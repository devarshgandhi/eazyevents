package com.eazy.events.rest;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.eazy.events.db.DataBaseConnections;
import com.eazy.events.models.Event;
import com.eazy.events.models.User;

/**
 * AALAP bhai request please. aatlu patavo ne.
 * For input pass form. And set the parameter key as in methods.
 * 
 * Users and Events e response ma avse je method ma required hse e. JSON ma hse to object ma thi get kari deje.
 * 
 * api path for each method is: /EazyEventAPI/eazy/events/rest/login
 *  
 * ***/

@Path("/rest")
public class RestService {
	
	DataBaseConnections db = new DataBaseConnections();
    
    @POST
    @Path("/login")
    public Response login(@FormParam("userid") String userId,
    					  @FormParam("password") String password) {
    	try {
			User user = db.validateUser(userId, password);
			if(null == user) {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
			return Response.ok(user, MediaType.APPLICATION_JSON).build();
			
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
    }
    
    @POST
    @Path("/signup")
    public Response signup(@FormParam("userid") String userId,
    					  @FormParam("password") String password, @FormParam("email") String email,
    					  @FormParam("firstname") String firtsName, @FormParam("lastname") String lastName,
    					  @FormParam("phone") String phone, @FormParam("street") String street,
    					  @FormParam("city") String city, @FormParam("state") String state,
    					  @FormParam("zipcode") int zipcode, @FormParam("type") String type) {
    	try {
    		if(db.isUserExists(userId)){
    			return Response.status(Response.Status.CONFLICT).build();
    		}
			if(!db.signupUser(userId, email, password, firtsName, lastName, 
					phone, street, city, state, zipcode, type)) {
				return Response.status(Response.Status.NOT_MODIFIED).build();
			}
			return Response.ok().build();
			
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
    }
    
    //---- Events ----//
    @POST
    @Path("/createevent")
    public Response createEvent(@FormParam("eventname") String eventname, @FormParam("time") String time,
    					  @FormParam("description") String description, @FormParam("street") String street,
    					  @FormParam("city") String city, @FormParam("state") String state,
    					  @FormParam("zipcode") int zipcode, @FormParam("date") String dateString,
    					  @FormParam("maxcapacity") int maxcapacity, @FormParam("organizer") String organizerName) {
    	try {
//    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
//    		LocalDateTime date1 = LocalDateTime.parse(dateString+" "+time, formatter);
//    		//java.util.Date date1 = formatter.parse(dateString +" "+ time);
//    		Date date = new Date(Date.from(date1.atZone(ZoneId.systemDefault()).toInstant()).getTime());
//    		//Date date = Date.valueOf(date1.toString());
    		String date = dateString.trim() +" "+ time.trim();
    		if(db.isEventExists(eventname)){
    			return Response.status(Response.Status.CONFLICT).build();
    		}
    		boolean isEventAdded = db.insertEvent(eventname, description, 
    					street, city, state, zipcode, date, maxcapacity, organizerName);
    		
			if(!isEventAdded) {
				return Response.status(Response.Status.NOT_MODIFIED).build();
			}
			return Response.ok().build();
			
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
    }
    
    @GET
    @Path("/getallevents")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEvents() {
        
        List<Event> events;
        GenericEntity<List<Event>> eventsEntity;
		try {
			events = db.getAllUnfinishedEvents();
			if(events.size() > 0) {
				eventsEntity  = new GenericEntity<List<Event>>(events) {};
	        	return Response.ok(eventsEntity, MediaType.APPLICATION_JSON).build();
	        }
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @DELETE
    @Path("/deleteevent")
    public Response deleteEvent(@FormParam("eventid") String eventId) {
    	try {
    		if(db.deleteEvent(Integer.valueOf(eventId))){
    			return Response.status(Response.Status.OK).build();
    		}
			return Response.status(Response.Status.NOT_MODIFIED).build();
			
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
    }
    
    @POST
    @Path("/geteventscreatedbyuser")
    public Response getEventsCreatedByUser(@FormParam("userid") String userId) {
    	List<Event> events;
		GenericEntity<List<Event>> eventsEntity;
    	try {
    		events = db.getEventsCreatedByUser(userId);
			if(events.size() > 0){
				eventsEntity  = new GenericEntity<List<Event>>(events) {};
	        	return Response.ok(eventsEntity, MediaType.APPLICATION_JSON).build();
			}
    		return Response.status(Response.Status.NOT_FOUND).build();
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
    }
    
    @POST
    @Path("/updateevent")
    public Response updateEvent(@FormParam("eventid") String eventId, @FormParam("eventname") String eventname,
    					  @FormParam("description") String description, @FormParam("street") String street,
    					  @FormParam("city") String city, @FormParam("state") String state,
    					  @FormParam("zipcode") int zipcode, @FormParam("date") String dateString, @FormParam("time") String time,
    					  @FormParam("maxcapacity") int maxcapacity, @FormParam("organizer") String organizerName) {
    	try {
    		String date = dateString + " " + time;
    		boolean isEventUpdated = db.updateEvent(eventname, description, 
    					street, city, state, zipcode, date, maxcapacity, organizerName, eventId);
    		
			if(!isEventUpdated) {
				return Response.status(Response.Status.NOT_MODIFIED).build();
			}
			return Response.ok().build();
			
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
    }
    
    //---- registration ----//
    @POST
    @Path("/registerevent")
    public Response registerEvent(@FormParam("userid") String userId,
    					   @FormParam("eventid") int eventId, 
    					   @FormParam("eventname") String eventName) {
    	try {
    		if(db.isUserRegisteredForEvent(userId, eventId)){
    			return Response.status(Response.Status.CONFLICT).build();
    		}
			if(db.registerEvent(userId, eventId, eventName)){
				return Response.status(Response.Status.OK).build();
			}
			return Response.status(Response.Status.NOT_MODIFIED).build();
			
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
    }
    
    @POST
    @Path("/getregisteredeventsforuser")
    public Response getRegisteredEventsForUser(@FormParam("userid") String userId) {
    	List<Event> events;
		GenericEntity<List<Event>> eventsEntity;
    	try {
    		events = db.getAllEventsForUser(userId);
			if(events.size() > 0){
				eventsEntity  = new GenericEntity<List<Event>>(events) {};
	        	return Response.ok(eventsEntity, MediaType.APPLICATION_JSON).build();
			}
    		return Response.status(Response.Status.NOT_FOUND).build();
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
    }
    
    @POST
    @Path("/getregisteredusersforevent")
    public Response getRegisteredUserForEvent(@FormParam("eventid") String eventId) {
    	List<User> userList;
		GenericEntity<List<User>> usersEntity;
    	try {
    		userList = db.getAllUsersForEvent(Integer.valueOf(eventId));
			if(userList.size() > 0){
				usersEntity  = new GenericEntity<List<User>>(userList) {};
	        	return Response.ok(usersEntity, MediaType.APPLICATION_JSON).build();
			}
    		return Response.ok().build();
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
    }
}
