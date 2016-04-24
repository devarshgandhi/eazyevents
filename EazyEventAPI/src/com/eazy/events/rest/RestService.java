package com.eazy.events.rest;

import java.sql.Date;
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

@Path("/rest")
public class RestService {
	
	DataBaseConnections db = new DataBaseConnections();
    
//    @GET
//    @Path("/getName")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<User> getAllUsers() throws Exception{
//        
//        List<User> users = new ArrayList<>();
//        User m = new User();
//        m.setFirstName("Abhi");
//        m.setLastName("Shah");
//        users.add(m);
//        
//        System.out.println("getAllUsers(): found "+users.size()+" message(s) on DB");
//        
//        return users; //do not use Response object because this causes issues when generating XML automatically
//    }
    
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
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
    }
    
    //---- Events ----//
    @POST
    @Path("/createevent")
    public Response createEvent(@FormParam("eventname") String eventname,
    					  @FormParam("description") String description, @FormParam("street") String street,
    					  @FormParam("city") String city, @FormParam("state") String state,
    					  @FormParam("zipcode") int zipcode, @FormParam("date") Date date,
    					  @FormParam("maxcapacity") int maxcapacity, @FormParam("organizer") String organizerName) {
    	try {
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
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @DELETE
    @Path("/deleteevent")
    public Response deleteEvent(@FormParam("eventid") int eventId) {
    	try {
    		if(db.deleteEvent(eventId)){
    			return Response.status(Response.Status.OK).build();
    		}
			return Response.status(Response.Status.NOT_MODIFIED).build();
			
    	} catch (SQLException e) {
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
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
    }
    
    @POST
    @Path("/updateevent")
    public Response createEvent(@FormParam("eventid") String eventId, @FormParam("eventname") String eventname,
    					  @FormParam("description") String description, @FormParam("street") String street,
    					  @FormParam("city") String city, @FormParam("state") String state,
    					  @FormParam("zipcode") int zipcode, @FormParam("date") Date date,
    					  @FormParam("maxcapacity") int maxcapacity, @FormParam("organizer") String organizerName) {
    	try {
    		boolean isEventUpdated = db.updateEvent(eventname, description, 
    					street, city, state, zipcode, date, maxcapacity, organizerName, eventId);
    		
			if(!isEventUpdated) {
				return Response.status(Response.Status.NOT_MODIFIED).build();
			}
			return Response.ok().build();
			
    	} catch (SQLException e) {
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
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
    }
}
