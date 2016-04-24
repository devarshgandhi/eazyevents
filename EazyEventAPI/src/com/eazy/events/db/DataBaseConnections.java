package com.eazy.events.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eazy.events.models.Event;
import com.eazy.events.models.User;

public class DataBaseConnections {

	Connection con = null;
	ResultSet rs;
	PreparedStatement ps;
	
	public DataBaseConnections() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost/sys", "root", "password");
			if (!con.isClosed())
				System.out.println("Successfully Connected!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public static void main(String args[]) throws SQLException{
//			Connection con1 = null;
//			ResultSet rs1;
//			PreparedStatement ps1;
//			try {
//				Class.forName("com.mysql.jdbc.Driver").newInstance();
//				con1 = DriverManager.getConnection("jdbc:mysql://localhost/sys", "root", "password");
//				if (!con1.isClosed())
//					System.out.println("Successfully Connected from main!!!");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//			String query = "select * from user where email = 'a@a.com' and password = 'abc'";
//			ps1= con1.prepareStatement(query);
//			rs1= ps1.executeQuery();
//			
//			if(rs1.next()) {
//				System.out.println(rs1);
//			}
//		}

	//-------- Users --------// 
	/**
	 * 
	 */
	public User validateUser(String userId, String password) throws SQLException {
		String query = "select * from user where id = ? and password = ?";
		ps = con.prepareStatement(query);
		ps.setString(1, userId);
		ps.setString(2, password);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			return new User(rs.getString("id"), rs.getString("email"), rs.getString("firstname"),
							rs.getString("lastname"), rs.getString("phone"), rs.getString("street"),
							rs.getString("city"), rs.getString("state"), rs.getInt("zipcode"),
							rs.getString("type"));
		}
		return null;
	}
	
	/**
	 * 
	 */
	public boolean isUserExists(String userId) throws SQLException {
		String query = "select email from user where id = ?";
		ps = con.prepareStatement(query);
		ps.setString(1, userId);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * 
	 */
	public void getAllUsers() throws SQLException {
		String query = "select * from user";
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs);
		}
	}
	
	/**
	 * 
	 */
	public boolean signupUser(String userId, String email, String password,
						   String firtsName, String lastName, String phone, 
						   String street, String city, String state, int zipcode,
						   String type) throws SQLException {
		int rowCount = 0;
		String query = "INSERT INTO user (id, email, password, firstname, lastname, phone, "
				+ "street, city, state, zipcode, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);";
		ps = con.prepareStatement(query);
		ps.setString(1, userId);
		ps.setString(2, email);
		ps.setString(3, password);
		ps.setString(4, firtsName);
		ps.setString(5, lastName);
		ps.setString(6, phone.toString());
		ps.setString(7, street);
		ps.setString(8, city);
		ps.setString(9, state);
		ps.setInt(10, zipcode);
		ps.setString(11, type);
		
		rowCount = ps.executeUpdate();
		
		if(rowCount > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 */
	private User getUser(String userId) throws SQLException {
		String query = "select * from user where id = ?";
		ps = con.prepareStatement(query);
		ps.setString(1, userId);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			return new User(rs.getString("id"), rs.getString("email"), rs.getString("firstname"),
					rs.getString("lastname"), rs.getString("phone"), rs.getString("street"),
					rs.getString("city"), rs.getString("state"), rs.getInt("zipcode"),
					rs.getString("type"));
		}
		return null;
	}
	
	
	//------- Events ------------//
	
	private Event getEvent(int eventId) throws SQLException {
		String query = "select * from event where id = ?";
		ps = con.prepareStatement(query);
		ps.setInt(1, eventId);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			return new Event(rs.getString("id"), rs.getString("name"), rs.getString("description"),
					rs.getString("street"), rs.getString("city"), rs.getString("state"), rs.getInt("zipcode"),
					new Date(rs.getDate("date").getTime()), rs.getInt("maxcapacity"), rs.getInt("registeredusers"), 
					Boolean.valueOf(rs.getString("isfinished")), rs.getString("organizer"), rs.getTime("date"));
		}
		return null;
	}
	
	/**
	 * 
	 */
	public boolean isEventExists(String eventname) throws SQLException {
		String query = "select id from user where name = ?";
		ps = con.prepareStatement(query);
		ps.setString(1, eventname);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 */
	public List<Event> getAllUnfinishedEvents() throws SQLException {
		List<Event> eventList = new ArrayList<>();
		String query = "select * from event where isfinished = false";
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			eventList.add(new Event(rs.getString("id"), rs.getString("name"), rs.getString("description"),
					rs.getString("street"), rs.getString("city"), rs.getString("state"), rs.getInt("zipcode"),
					rs.getTimestamp("date"), rs.getInt("maxcapacity"), rs.getInt("registeredusers"), 
					Boolean.valueOf(rs.getString("isfinished")), rs.getString("organizer"), rs.getTime("date")));
		}
		return eventList;
	}
	
	/**
	 * 
	 */
	public void getAllFinishedEvents() throws SQLException {
		String query = "select * from event where isfinished = true";
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs);
		}
	}
	
	/**
	 * 
	 */
	public boolean insertEvent(String name, String description, String street, String city,
							  String state, int zipcode, Date date, int maxcapacity,
							  String organizerName) throws SQLException {
		int rowCount = 0;
		String query = "INSERT INTO event (name, description, street, city, state, zipcode,"
				+ "date, maxcapacity, registeredusers, isfinished, organizer) "
				+ "VALUES (?,?,?,?,?,?,?,?,0,false,?)";
		ps = con.prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2, description);
		ps.setString(3, street);
		ps.setString(4, city);
		ps.setString(5, state);
		ps.setInt(6, zipcode);
		ps.setDate(7, date);
		ps.setInt(8, maxcapacity);
		ps.setString(11, organizerName);
		rowCount = ps.executeUpdate();
		
		if(rowCount > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 */
	public boolean updateEvent(String name, String description, String street, String city,
							  String state, int zipcode, Date date, int maxcapacity,
							  String organizerName, String id) throws SQLException {
		int isRowUpdated = 0;
		String query = "UPDATE event SET name=?, description=?, street=?, city=?, state=?,"
				+ " zipcode=?, date=?, maxcapacity=?, organizer=? where id=?";
		ps = con.prepareStatement(query);
		ps.setString(1, name);
		ps.setString(2, description);
		ps.setString(3, street);
		ps.setString(4, city);
		ps.setString(5, state);
		ps.setInt(6, zipcode);
		ps.setDate(7, date);
		ps.setInt(8, maxcapacity);
		ps.setString(9, organizerName);
		ps.setString(12, id);
		isRowUpdated = ps.executeUpdate();
				
		if(isRowUpdated > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 */
	public boolean deleteEvent(int eventId) throws SQLException {
		int isDeletedFromEvent = 0;
		String query = "DELETE from event where id = ?";
		ps = con.prepareStatement(query);
		ps.setInt(1, eventId);
		isDeletedFromEvent = ps.executeUpdate();
		
		if(isDeletedFromEvent > 0) {
			int isDeletedFromRegistered = 0;
			query = "DELETE from registeredevents where eventid = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, eventId);
			isDeletedFromRegistered = ps.executeUpdate();
			
			if(isDeletedFromRegistered > 0) {
				String userid = rs.getString("userid");
				query = "select email from user where id = ?";
				ps = con.prepareStatement(query);
				ps.setString(1, userid);
				rs = ps.executeQuery();
				while(rs.next()) {
					//TODO: send email to user
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 */
	public List<Event> getEventsCreatedByUser(String userId) throws SQLException {
		List<Event> eventList = new ArrayList<>();
		String query = "select * from event where organizer = ?";
		ps = con.prepareStatement(query);
		ps.setString(1, userId);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			eventList.add(new Event(rs.getString("id"), rs.getString("name"), rs.getString("description"),
					rs.getString("street"), rs.getString("city"), rs.getString("state"), rs.getInt("zipcode"),
					rs.getDate("date"), rs.getInt("maxcapacity"), rs.getInt("registeredusers"), 
					Boolean.valueOf(rs.getString("isfinished")), rs.getString("organizer"), rs.getTime("date")));
		}
		return eventList;
	}
	
	//------- registration of events ----------//
	
	/**
	 * 
	 */
	public boolean registerEvent(String userId, int eventId, String eventName) throws SQLException {
		int isRegisterCount = 0;
		String query = "INSERT INTO registeredevents (eventid, eventname, userid) "
				+ "VALUES (?,?,?)";
		ps = con.prepareStatement(query);
		ps.setInt(1, eventId);
		ps.setString(2, eventName);
		ps.setString(3, userId);
		isRegisterCount = ps.executeUpdate();
		
		if(isRegisterCount > 0) {
			query = "select registeredusers from event where id = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, eventId);
			rs = ps.executeQuery();
			if(rs.next()) {
				query = "UPDATE event SET registeredusers=? where id=?";
				ps = con.prepareStatement(query);
				ps.setInt(1, rs.getInt("registeredusers") + 1);
				ps.setInt(2, eventId);
				ps.executeUpdate();
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 */
	public List<User> getAllUsersForEvent(int eventId) throws SQLException {
		List<User> userList = new ArrayList<>();
		String query = "select userid from registeredevents where eventid = ?";
		ps = con.prepareStatement(query);
		ps.setInt(1, eventId);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			userList.add(this.getUser(rs.getString("userid")));
		}
		return userList;
	}

	/**
	 * 
	 */
	public List<Event> getAllEventsForUser(String userId) throws SQLException {
		List<Event> eventList = new ArrayList<>();
		String query = "select eventid from registeredevents where userid = ?";
		ps = con.prepareStatement(query);
		ps.setString(1, userId);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			eventList.add(this.getEvent(rs.getInt("eventid")));
		}
		return eventList;
	}
	
	/**
	 * 
	 */
	public boolean isUserRegisteredForEvent(String userId, int eventId) throws SQLException {
		String query = "select userid from registeredevents where userid = ? and eventid = ?";
		ps = con.prepareStatement(query);
		ps.setString(1, userId);
		ps.setInt(2, eventId);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			return true;
		}
		return false;
	}

}
