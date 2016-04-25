package com.eazy.events.db;
//package VideoLibrary;
//
//import java.sql.Connection;
//import java.sql.CallableStatement;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.Types;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//
//
//import entity.Movie;
//import entity.Person;
//import entity.PremiumMembers;
//import entity.SimpleMembers;
//import entity.Cart;
//import entity.Transactions;
//
//public class DatabaseConnection1 {
//
//	Connection con = null;
//	ResultSet rs,rs1;
//	ConnectionPool connectionPool = null;
//	PreparedStatement ps,ps1;
//	
//	DatabaseConnection1() {
//		
//	/*	try {
//		Class.forName("com.mysql.jdbc.Driver").newInstance();
//		con = DriverManager.getConnection(
//				"jdbc:mysql://localhost/videolibrary", "root",
//				"");
//		if (!con.isClosed())
//			System.out.println("Successfully Connected!!!");
//	} catch (SQLException e) {
//		
//		e.printStackTrace();
//	} catch (InstantiationException e) {
//		
//		e.printStackTrace();
//	} catch (IllegalAccessException e) {
//		
//		e.printStackTrace();
//	} catch (ClassNotFoundException e) {
//		
//		e.printStackTrace();
//	}
//	}*/
//		
//		// Connection pooling start
//			
//		connectionPool = ConnectionPool.getInstance();
//		try{
//			con = connectionPool.getConnection();
//			//stmt = con.createStatement();
//			if (!con.isClosed())	
//				System.out.println("Successfully Connected!!!");
//			} catch (SQLException e) {
//					// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//	static HashMap<String, Person> emailIdList = new HashMap<String, Person>(); //abhi
//	static HashMap<Long, Person> primaryList = new HashMap<Long, Person>();		//abhi
//	
///*	public boolean create5000PremiumMembers() throws SQLException
//	{
//		int count = 222222222;
//		
//boolean r =true;
//		try 
//		{
//		for(int i =0 ; i <5000 ; i++){
//			ps = con.prepareStatement("Insert into person(membershipId, firstName,lastName, emailId, password, address, city, state, zipCode,  userType, registrationDate, lastLogin)  values (? , ? , ? ,?, SHA1(?), ?, ?, ? , ?,?, now(),now())");
//			
//			ps.setInt(1,count);
//System.out.println("index" + count);
//			ps.setString(2, "fname"+i);
//			ps.setString(3, "lname"+i);
//
//			ps.setString(4, "ePrem"+i+"@e.com");
//
//			ps.setString(5, "123456");
//			ps.setString(6, "address"+i);
//			ps.setString(7, "city"+i);
//			ps.setString(8, "California");
//			ps.setInt(9, 12345);
//			ps.setInt(10, 0);
//
//		int result = ps.executeUpdate();
//		System.out.println("Inserted");
//		
//		ps1 = con.prepareStatement("Insert into premiumMembers(membershipId,dueAmount,totalOutstandingMovies, expiryDate) values ( ?, ? ,?, now())");
//			
//		ps1.setInt(1,count);
//		ps1.setFloat(2, 50);
//		ps1.setInt(3, 0);
//		int result1 = ps1.executeUpdate();
//
//		count++;
//		r = true;
//
//		}					
//		return r;
//
//	}
//		finally{
//			connectionPool.free(con);ps.close();
//		}
//
//	}
//	
//	
//	
//	
//	public boolean create5000SimpleMembers() throws SQLException
//	{
//		int count = 777777777;
//
//		boolean r =true;
//try{
//		for(int i =0 ; i <5000 ; i++){
//			ps = con.prepareStatement("Insert into person(membershipId, firstName,lastName, emailId, password, address, city, state, zipCode,  userType, registrationDate, lastLogin)  values (? , ? , ? ,?, SHA1(?), ?, ?, ? , ?,?, now(),now())");
//			
//			ps.setInt(1,count);
//			ps.setString(2, "fname"+i);
//			ps.setString(3, "lname"+i);
//
//			ps.setString(4, "eSimp"+i+"@e.com");
//
//			ps.setString(5, "123456");
//			ps.setString(6, "address"+i);
//			ps.setString(7, "city"+i);
//			ps.setString(8, "California");
//			ps.setInt(9, 12345);
//			ps.setInt(10, 1);
//
//			int result = ps.executeUpdate();
//			
//			
//			ps1 = con.prepareStatement("Insert into simpleMembers(membershipId,rentForMoviesIssued,totalOutstandingMovies) values ( ?, ? ,?)");
//				
//			ps1.setInt(1,count);
//			ps1.setFloat(2, 0);
//			ps1.setInt(3, 0);
//			int result1 = ps1.executeUpdate();
//
//			count++;
//			r = true;
//
//			}					
//			return r;
//
//		}
//			finally{
//				connectionPool.free(con);ps.close();
//			}
//
//		}
//	public boolean create10000Movies() throws SQLException
//	{
//		
//		try{
//			
//			//PreparedStatement ps;
//			boolean success = true;
//			
//			for (int i =0 ; i<2000 ; i++ )
//			{
//			ps = con.prepareStatement("insert into movie( movieName, movieBanner, movieReleaseDate, movieRent, movieCategory, availableCopies) VALUES(?,?,NOW(),?,?,?)");
//			//ps.setInt(1, movieId);
//			ps.setString (1, "movi"+i );
//			ps.setString (2, "bann" +i);
//			ps.setFloat(3, 15);
//			ps.setString(4, "Horror");
//			ps.setInt(5, 10);
//			if(ps.executeUpdate()==1){
//				success = true;
//			}	
//
//			}
//			return success;
//
//	}catch (SQLException e) {
//		e.printStackTrace();
//	}finally{
//		connectionPool.free(con);
//		ps.close();
//	}
//		return false;
//	}
//	*/
//	
//	
//	public Person login(String emailId, String pwd) throws SQLException
//	{
//		String query;
//		Person person = null;
//
//		try {
//			//boolean msg= create5000SimpleMembers();
//			
//			//boolean msg1= create5000PremiumMembers();
//			
//			//boolean msg= create10000Movies();
//			
//			person = emailIdList.get(emailId);				//abhi
//
//			if (person != null) {
//				System.out.println("Login: Returning person from HashMap");
//				return person;
//			}										//	abhi
//			
//			query = "select membershipId,firstName, lastName, lastLogin, userType from person where emailId='"+emailId+"' and password=SHA1('"+pwd+"')";
//			System.out.println(query);
//			ps= con.prepareStatement(query);
//			rs= ps.executeQuery();	
//
//
//			if (rs.next()) {
//				System.out.println("In if condition");
//				person = new Person();
//				person.setMembershipId(rs.getLong(1));
//				
//
//				person.setFirstName(rs.getString(2));
//				person.setLastName(rs.getString(3));
//				person.setLastLogin(rs.getTimestamp(4));		
//				person.setUserType(rs.getInt(5));
//				
//				System.out.println(person.getFirstName());
//				System.out.println(person.getLastName());
//				System.out.println(person.getLastLogin());
//				System.out.println(person.getUserType() + "type is ---------");
//				
//				emailIdList.put(person.getEmailId(), person);						//abhi
//				primaryList.put(new Long(person.getMembershipId()), person);	//abhi
//				
//				query ="UPDATE person SET lastLogin = NOW() WHERE emailId='" + emailId +"'";
//				System.out.println(query);
//				ps= con.prepareStatement(query);
//				if(ps.executeUpdate() == 0)
//				{
//					System.out.println("Update for lastLogin failed");
//					return null;
//				}
//			}
//			else
//			{
//				System.out.println("Invalid Login");
//				return null;
//			}
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			connectionPool.free(con);
//			ps.close();
//			if(emailIdList.size()>100)
//			{
//				emailIdList.clear();
//			}
//		}	
//		return person;
//	}
//
//
//	
//	public String createMember(long memberId, String fName, String lName, String emailId, String pwd, String address, 
//			String city, String state, long zipCode, Integer userType,
//		    float dueAmount, Integer totalOutstandingMovies, Integer rentForMoviesIssued) throws SQLException
//	{
//		//SNEHAL D'MELLO
//		
//		String result = "";
//		long membershipId=0;
//		String query1="", query2="";
//		int rowcount1=0, rowcount2=0;
//
//		ps = null;
//		try{
//		 	//+state+"', '"+zipCode+"', '"+userType+"', '"+registrationDate.toString()+"','"+expiryDate.toString()+"', now())";
//
//
//			query1 = "Insert into person(membershipId, firstName,lastName, emailId, password, address, city, state, zipCode, " +
//					"userType, registrationDate, lastLogin)" +
//					" values('"+memberId+"' ,'" +fName +"', '" +lName  +"', '"+emailId+"', SHA1('"+pwd+"'), '" +address  +"', " + "'" +city  +"', '" 
//					+state+"', '"+zipCode+"', '"+userType+"', now(),now())";
//
//			System.out.println(query1);
//			ps = con.prepareStatement(query1); // create a statement
//			rowcount1 =ps.executeUpdate();
//			
//			
//			query2 ="select membershipId from person where emailId ='"+emailId+"'";
//
//			System.out.println(query2);
//			ps= con.prepareStatement(query2);
//			rs= ps.executeQuery();
//
//			if(rs.next()) {
//
//				membershipId = rs.getInt(1);
//				System.out.println("membershipId = "+ membershipId);
//
//			}
//			if(userType == 0)
//			{
//				query2 = "Insert into premiumMembers(membershipId,dueAmount,totalOutstandingMovies, expiryDate) " +
//									"values( '" +membershipId  +"', '" +dueAmount  +"', '" +totalOutstandingMovies  +"', now())";
//			}
//			else if(userType == 1)
//			{
//				query2 = "Insert into simpleMembers(membershipId,rentForMoviesIssued,totalOutstandingMovies) " +
//						"values(  '" +membershipId  +"', '" +rentForMoviesIssued  +"', '" +totalOutstandingMovies  +"')";
//			}
//
//			System.out.println(query2);
//		    ps = con.prepareStatement(query2);
//		    rowcount2 =ps.executeUpdate();
//
//		    if(rowcount1 >0 && rowcount2 >0)
//			{
//				result = "true";
//				System.out.println("Insert Successful");
//			}
//			else
//			{
//				result = "false";
//				System.out.println("The data could not be inserted into the database.");
//			}
//		}
//		catch(SQLException e){
//			result = "false";
//
//			e.printStackTrace();
//		}finally{
//			connectionPool.free(con);ps.close();
//		}
//
//		return result;
//	}
//
//	public Person memberFromID(long membershipId) throws SQLException
//	{
//		String query;
//		Person person = null;
//
//		try {
//			//Statement stmt=null;
//		
//			/*if ((person = primaryList.get(new Long(membershipId))) != null) {			//abhi
//			
//				System.out.println("Returning person from HashMap..");
//				return person;
//			}	*/															//
//			
//			query = "select membershipId,firstName, lastName, emailId,password,address,city,state,zipCode, userType, lastLogin  from person where membershipId='"+membershipId+"'";
//			System.out.println(query);
//			ps= con.prepareStatement(query);
//			rs= ps.executeQuery();	
//
//
//			
//			//stmt=con.createStatement();	//base case
//			//rs=stmt.executeQuery(query);	//base case
//			
//			
//			if (rs.next()) {
//				System.out.println("In if condition");
//				person = new Person();
//				person.setMembershipId(rs.getLong("membershipId"));
//
//				person.setFirstName(rs.getString("firstName"));
//				person.setLastName(rs.getString("lastName"));
//				person.setEmailId(rs.getString("emailId"));
//				person.setPassword(rs.getString("password"));
//				person.setAddress(rs.getString("address"));
//				person.setCity(rs.getString("city"));
//				person.setState(rs.getString("state"));
//				person.setZipCode(rs.getLong("zipCode"));
//				person.setUserType(rs.getInt("userType"));
//				person.setLastLogin(rs.getTimestamp("lastLogin"));
//				
//				//primaryList.put(new Long(person.getMembershipId()), person);	//abhi
//
//			}
//			else
//			{
//				System.out.println("Not available");
//				return null;
//			}
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			connectionPool.free(con);ps.close();
//			
//		}	
//		return person;
//	}
//
//	
//	public boolean updatePerson(long membershipId, String firstName, String lastName,String emailId, String password, String address, String city, String state, long zipCode) throws SQLException{
//		int rowcount=0;
//		boolean result=false;
//		String query;
//				
//		try {
//				ps=(PreparedStatement) con.prepareStatement("update person set firstName=?, lastName=?, emailId=?, password=?, address=?, city=?, state=?, zipCode=? where membershipId=?");
//		
//				ps.setString(1, firstName);
//				ps.setString(2, lastName);
//				ps.setString(3, emailId);
//				ps.setString(4, password);
//				ps.setString(5, address);
//				ps.setString(6, city);
//				ps.setString(7, state);
//				ps.setLong(8, zipCode);
//				ps.setLong(9, membershipId);
//				rowcount=ps.executeUpdate();
//				
//				if(rowcount>0)
//				{
//					result=true;
//				}
//				
//			}
//		 catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			connectionPool.free(con);ps.close();
//		}
//		return result;
//	}
//
//
//	public Movie[] displayMovies() throws SQLException{
//	// Author Sweta Patel
//		String query;
//		String countQuery;
//		int Count = 0;
//		int index=0;
//		Movie[] movieAll = null;
//				
//		try {
//				query = "select * from movie";
//				countQuery = "select count(1) from movie";
//				
//				ps= con.prepareStatement(countQuery);
//				rs= ps.executeQuery();
//				
//				if (rs.next()) {
//					 Count = rs.getInt(1);
//				}
//				
//				movieAll = new Movie[Count];
//				
//				ps= con.prepareStatement(query);
//				rs= ps.executeQuery();
//				
//				while (rs.next()) {
//					Movie movie = new Movie();
//					movie.setMovieId(rs.getInt("movieId"));
//					movie.setMovieName(rs.getString("movieName"));
//					movie.setMovieBanner(rs.getString("movieBanner"));
//					movie.setMovieReleaseDate(rs.getDate("movieReleaseDate"));
//					movie.setMovieRent(rs.getFloat("movieRent"));
//					movie.setMovieCategory(rs.getString("movieCategory"));
//					movie.setAvailableCopies(rs.getInt("availableCopies"));
//					movieAll[index] = movie;
//					index++;
//				}
//				
//			}
//		 catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			connectionPool.free(con);ps.close();
//		}
//		
//		return movieAll; 
//
//	}
//
//	public boolean createMovie(String movieName, String movieBanner, Date movieReleaseDate, float movieRent, String movieCategory, int availableCopies) throws SQLException{
//		try{
//			
//			//PreparedStatement ps;
//			boolean success;
//			ps = con.prepareStatement("insert into movie( movieName, movieBanner, movieReleaseDate, movieRent, movieCategory, availableCopies) VALUES(?,?,?,?,?,?)");
//			//ps.setInt(1, movieId);
//			ps.setString (1, movieName);
//			ps.setString (2, movieBanner);
//			ps.setDate(3, (java.sql.Date) movieReleaseDate);
//			ps.setFloat(4, movieRent);
//			ps.setString(5, movieCategory);
//			ps.setInt(6, availableCopies);
//			if(ps.executeUpdate()==1){
//				success = true;
//				return success;
//			}		
//		
//	}catch (SQLException e) {
//		e.printStackTrace();
//	}finally{
//		connectionPool.free(con);ps.close();
//	}
//		return false;
//	}
//	
//
//	
//	public boolean deleteMovie(int movieId, String movieName) throws SQLException
//	{
//		int rowcount=0;
//		boolean result=false;
//		try {
//			ps=(PreparedStatement) con.prepareStatement("delete from movie where movieId=? and movieName=?");
//			
//			ps.setInt(1, movieId);
//			ps.setString(2, movieName);
//			
//			rowcount=ps.executeUpdate();
//
//			if(rowcount>0)
//			{
//				result=true;
//			}
//
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			connectionPool.free(con);ps.close();
//		}
//		return result;
//	}
//	
//	public boolean deleteMember(long membershipId) throws SQLException
//	{
//		//SNEHAL D'MELLO
//		boolean result=true;
//		Integer userType=9999;
//		String query1="", query2="", query3="";
//		int rowcount1=0, rowcount2=0;
//		ps = null;
//		try{
//			query1 ="select userType from person where membershipId ="+membershipId;
//
//			System.out.println(query1);
//			ps= con.prepareStatement(query1);
//			rs= ps.executeQuery();
//
//			if(rs.next()) {
//
//				userType = rs.getInt(1);
//				System.out.println("userType = "+ userType);
//
//
//				if(userType == 0)
//				{
//					query2 = "delete from premiumMembers where membershipId ="+membershipId;
//				}
//				else if(userType == 1)
//				{
//					query2 = "delete from simpleMembers where membershipId ="+membershipId;
//				}
//
//				System.out.println(query2);
//				ps = con.prepareStatement(query2);
//				rowcount1 =ps.executeUpdate();
//
//				query3 = "delete from person where membershipId ="+membershipId;
//
//				System.out.println(query3);
//				ps = con.prepareStatement(query3);
//				rowcount2 =ps.executeUpdate();
//
//				if(rowcount1 >0 && rowcount2 >0)
//				{
//					result = true;
//					System.out.println("Delete Successful");
//				}
//				else
//				{
//					result = false;
//					System.out.println("The data could not be deleted from the database.");
//				}
//			}
//			else
//			{
//				result = false;
//				System.out.println("Record not found");
//			}
//
//		}
//		catch(SQLException e){
//			e.printStackTrace();
//		}finally{
//			connectionPool.free(con);ps.close();
//		}
//
//		return result;
//	}
//
//	public Person[] displayPerson() throws SQLException{
//		// Ahthor: Sweta Patel
//		String query;
//		String countQuery;
//		int Count = 0;
//		int index=0;
//		Person[] personAll = null;
//				
//		try {
//				query = "select * from person";
//				countQuery = "select count(1) from person";
//				
//				ps= con.prepareStatement(countQuery);
//				rs= ps.executeQuery();
//				
//				if (rs.next()) {
//					 Count = rs.getInt(1);
//				}
//				
//				personAll = new Person[Count];
//				
//				ps= con.prepareStatement(query);
//				rs= ps.executeQuery();
//				
//				while (rs.next()) {
//					Person person = new Person();
//					person.setMembershipId(rs.getLong("membershipId"));
//					person.setFirstName(rs.getString("firstName"));
//					person.setLastName(rs.getString("lastName"));
//					person.setEmailId(rs.getString("emailId"));
//					person.setPassword(rs.getString("password"));
//					person.setAddress(rs.getString("address"));
//					person.setCity(rs.getString("city"));
//					person.setState(rs.getString("state"));
//					person.setZipCode(rs.getInt("zipCode"));
//					person.setUserType(rs.getInt("userType"));
//					person.setRegistrationDate(rs.getDate("registrationDate"));
////					person.setExpiryDate(rs.getDate("expiryDate"));
//					person.setLastLogin(rs.getDate("lastLogin"));
//					personAll[index] = person;
//					index++;
//					
//				}
//				
//			}
//		 catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			connectionPool.free(con);ps.close();
//		}
//		
//		return personAll; 
//
//	}
//	public SimpleMembers[] displaySimpleMembers() throws SQLException
//	{
//		//ResultSet rs;
//		String query;
//		String countQuery;
//		int Count = 0;
//		int index=0;
//		SimpleMembers[] simpleMembersList = null;
//				
//		try { 
//			// Assuming userType 0 = SimpleMember and 1 = PremiumMember
//				
//				countQuery = "select count(1) from person where userType = 1";
//				query = "select * from person,simplemembers where person.membershipId = simplemembers.membershipId and userType = 1 order by person.membershipId";
//				
//				ps= con.prepareStatement(countQuery);
//				rs= ps.executeQuery();
//				
//				if (rs.next()) {
//					 Count = rs.getInt(1);
//				}
//				
//				simpleMembersList = new SimpleMembers[Count];
//				
//				ps= con.prepareStatement(query);
//				rs= ps.executeQuery();
//				
//				
//				
//				while (rs.next()) {
//					SimpleMembers simpleMember = new SimpleMembers();
//					simpleMember.setSimpleMemberId(rs.getInt("simplememberId"));
//					simpleMember.setMembershipId(rs.getLong("membershipId"));
//					simpleMember.setRentForMoviesIssued(rs.getFloat("rentForMoviesIssued"));
//					simpleMember.setTotalOutstandingMovies(rs.getInt("totalOutstandingMovies"));
//					
//					simpleMember.setFirstName(rs.getString("firstName"));
//					simpleMember.setLastName(rs.getString("lastName"));
//					simpleMember.setEmailId(rs.getString("emailId"));
//					simpleMember.setPassword(rs.getString("password"));
//					simpleMember.setAddress(rs.getString("address"));
//					simpleMember.setCity(rs.getString("city"));
//					simpleMember.setState(rs.getString("state"));
//					simpleMember.setZipCode(rs.getInt("zipCode"));
//					simpleMember.setUserType(rs.getInt("userType"));
//					simpleMember.setRegistrationDate(rs.getDate("registrationDate"));
//					simpleMember.setLastLogin(rs.getDate("lastLogin"));
//					
//					simpleMembersList[index] = simpleMember;
//					index++;
//				}
//			}
//		 catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			connectionPool.free(con);ps.close();
//		}
//		
//		
//		return simpleMembersList;
//		
//	}
//
//
//
//	
//	public PremiumMembers[] displayPremiumMembers() throws SQLException
//	{
//		//ResultSet rs;
//		String query;
//		String countQuery;
//		int Count = 0;
//		int index=0;
//		PremiumMembers[] premiumMembersList = null;
//				
//		try { 
//			// Assuming userType 0 = SimpleMember and 1 = PremiumMember
//				
//				countQuery = "select count(1) from person where userType = 0";
//				query = "select * from person,premiummembers where person.membershipId = premiummembers.membershipId and userType = 0 order by person.membershipId";
//				
//				ps= con.prepareStatement(countQuery);
//				rs= ps.executeQuery();
//				
//				if (rs.next()) {
//					 Count = rs.getInt(1);
//				}
//				
//				premiumMembersList = new PremiumMembers[Count];
//				
//				ps= con.prepareStatement(query);
//				rs= ps.executeQuery();
//				
//				
//				
//				while (rs.next()) {
//					PremiumMembers premiumMember = new PremiumMembers();
//					premiumMember.setPremiumMemberId(rs.getInt("premiumMemberId"));
//					premiumMember.setMembershipId(rs.getLong("membershipId"));
//					premiumMember.setDueAmount(rs.getFloat("dueAmount"));					
//					premiumMember.setTotalOutstandingMovies(rs.getInt("totalOutstandingMovies"));
//					premiumMember.setExpiryDate(rs.getDate("expiryDate"));
//					
//					premiumMember.setFirstName(rs.getString("firstName"));
//					premiumMember.setLastName(rs.getString("lastName"));
//					premiumMember.setEmailId(rs.getString("emailId"));
//					premiumMember.setPassword(rs.getString("password"));
//					premiumMember.setAddress(rs.getString("address"));
//					premiumMember.setCity(rs.getString("city"));
//					premiumMember.setState(rs.getString("state"));
//					premiumMember.setZipCode(rs.getInt("zipCode"));
//					premiumMember.setUserType(rs.getInt("userType"));
//					//premiumMember.setRentedMovies(rs.getInt("rentedMovies"));
//					premiumMember.setRegistrationDate(rs.getDate("registrationDate"));					
//					premiumMember.setLastLogin(rs.getDate("lastLogin"));
//					
//					premiumMembersList[index] = premiumMember;
//					index++;
//				}
//			}
//		 catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			connectionPool.free(con);ps.close();
//		}
//		
//		return premiumMembersList;
//		
//	}
//	
//
//	public boolean updateMovie(int movieId, String movieName, String movieBanner, Date movieReleaseDate, float movieRent, String movieCategory, int availableCopies ) throws SQLException
//	{
//		boolean result=false;
//		int rowcount=0;
//		String query;
//				
//		try {
//				ps=(PreparedStatement) con.prepareStatement("update movie set movieName=?, movieBanner=?, movieReleaseDate=?, movieRent=?, movieCategory=?, availableCopies=? where movieId=?");
//				//query = "update person set firstName='"+firstName+"', lastName='"+lastName+"', emailId='"+emailId+"', password='"+password+"', address='"+address+"', city='"+city+"', state='"+state+"', zipCode='"+zipCode+"' where membershipId="+membershipId;
//				
//				ps.setString(1, movieName);
//				ps.setString(2, movieBanner);
//				ps.setDate(3, (java.sql.Date) movieReleaseDate);
//				ps.setFloat(4, movieRent);
//				ps.setString(5, movieCategory);
//				ps.setInt(6, availableCopies);
//				ps.setInt(7, movieId);
//				rowcount=ps.executeUpdate();
//				
//				if(rowcount>0)
//				{
//					result=true;
//				}
//				
//			}
//		 catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			connectionPool.free(con);ps.close();
//		}
//		return result;
//	}
//
//
//	public Movie[] updateMovieRequest(int movieId) throws SQLException{
//		//ResultSet rs;
//		String query;
//		String countQuery;
//		int Count = 0;
//		int index=0;
//		Movie[] movieAll = null;
//				
//		try {
//			
//				query = "select * from movie where movieId=" + movieId;
//				countQuery = "select count(1) from movie";
//				
//				ps= con.prepareStatement(countQuery);
//				rs= ps.executeQuery();
//				
//				//rs = stmt.executeQuery(countQuery);
//				if (rs.next()) {
//					 Count = rs.getInt(1);
//				}
//				
//				movieAll = new Movie[Count];
//				ps= con.prepareStatement(query);
//				rs= ps.executeQuery();
//				
//				//rs = stmt.executeQuery(query);
//				
//				while (rs.next()) {
//					Movie movie = new Movie();
//					movie.setMovieId(rs.getInt("movieId"));
//					movie.setMovieName(rs.getString("movieName"));
//					movie.setMovieBanner(rs.getString("movieBanner"));
//					movie.setMovieReleaseDate(rs.getDate("movieReleaseDate"));
//					movie.setMovieRent(rs.getFloat("movieRent"));
//					movie.setMovieCategory(rs.getString("movieCategory"));
//					movie.setAvailableCopies(rs.getInt("availableCopies"));
//					movieAll[index] = movie;
//					index++;
//				}
//			}
//		 catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			connectionPool.free(con);ps.close();
//		}
//		
//		return movieAll;
//
//	}
//	
//	public Transactions[] issuedMovieList(long membershipId) throws SQLException{
//        //Author: Sweta Patel
//        String query;
//        String countQuery;
//        int Count = 0;
//        int index=0;
//        Transactions[] issuedMovie = null;
//                
//        try {
//            
//                query = "select * from transactions where  membershipId=" + membershipId + " and  actualReturnDate is null";
//                countQuery = "select count(1) from transactions where  membershipId=" + membershipId + " and  actualReturnDate is null";
//                
//                
//                System.out.println("Transactions" + query);
//                System.out.println("Transactions" + countQuery);
//
//
//                ps = con.prepareStatement(countQuery);
//                
//                System.out.println("Transactions count query");
//
//                
//                rs=ps.executeQuery();
//                if (rs.next()) {
//                     Count = rs.getInt(1);
//                }
//                
//                System.out.println("Count" + Count);
//
//                issuedMovie = new Transactions[Count];
//                ps = con.prepareStatement(query);
//                rs=ps.executeQuery();
//                //rs = stmt.executeQuery(query);
//                
//                while (rs.next()) {
//                    Transactions transaction = new Transactions();
//                    transaction.setTransactionId(rs.getLong("transactionId"));
//                    transaction.setMembershipId(rs.getLong("membershipId"));
//                    int tempMovieId = rs.getInt("movieId");
//                    transaction.setMovieId(tempMovieId);
//                    PreparedStatement ps1 = con.prepareStatement("select movieName from movie where movieId = "+ tempMovieId + ";");
//        			ResultSet rs1 = ps1.executeQuery();
//        				if (rs1.next()) {
//        					 transaction.setMovieName(rs1.getString("movieName"));
//        				}
//                    
//                    transaction.setFineAmount(rs.getFloat("fineAmount"));
//                    transaction.setIssueDate(rs.getDate("issueDate"));
//                    transaction.setDueDate(rs.getDate("dueDATE"));
//                    issuedMovie[index] = transaction;
//                    index++;
//                }
//            }
//         catch (SQLException e) {
//            e.printStackTrace();
//        }finally{
//            connectionPool.free(con);ps.close();
//        }
//        
//        return issuedMovie;
//
//    }
//
//	
//
//	
//	
//	public Person[] searchPerson(String attributeName, String attributeValue) throws SQLException
//	{
//		//SNEHAL D'MELLO
//		System.out.println("In Database- search person");
//		String query="",query1="";
//		int index=0, count=0;
//		Person personInfo[] = null;
//		try{
//
//			//query = "select count(1) from person where firstname='"+fName+"' OR lastname='"+lName+"' OR emailId='"+emailId+"' OR membershipId="+membershipId; 
//			query="select count(1) from person where "+attributeName+" LIKE '"+attributeValue+"%'"; // also check by having % in the beginning
//			ps= con.prepareStatement(query);
//			rs= ps.executeQuery();
//			System.out.println(query);
//
//			if (rs.next()) {
//				 count = rs.getInt(1);
//			}
//
//			personInfo = new Person[count];
//
//			query1 = "select * from person where "+attributeName+" LIKE '"+attributeValue+"%'"; // also check by having % in the beginning
//			ps = con.prepareStatement(query1);
//			rs=ps.executeQuery();
//			System.out.println(query1);
//
//			while(rs.next())
//			{
//				Person person = new Person();
//				person.setMembershipId(rs.getInt(1));
//				person.setFirstName(rs.getString(2));
//				person.setLastName(rs.getString(3));
//				person.setEmailId(rs.getString(4));
//				person.setPassword(rs.getString(5));
//				person.setAddress(rs.getString(6));
//				person.setCity(rs.getString(7));
//				person.setState(rs.getString(8));
//				person.setZipCode(rs.getInt(9));
//				person.setUserType(rs.getInt(10));
//				person.setRegistrationDate(rs.getDate(11));
//				person.setLastLogin(rs.getTimestamp(12));
//				personInfo[index] = person;
//				index++;
//
////				System.out.println(person.getMembershipId()+" "+person.getFirstName()+" "+person.getLastName()+" "+person.getEmailId()+ " " +
////				" "+person.getPassword()+" "+person.getAddress()+" "+ " "+person.getCity()+" "+person.getState()+" "+person.getZipCode()+ " "+
////					person.isUserType()+" "+person.getRegistrationDate()+" "+person.getLastLogin());
//			}
//
//			if(index>0)
//			{
//				System.out.println("Person found");
//			}
//			else
//			{
//				System.out.println("Person not found");
//				return null;
//			}
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			connectionPool.free(con);ps.close();
//		}
//		return personInfo;
//	}
//
//	
//	public Movie[] searchMovie(String attributeName, String attributeValue) throws SQLException
//	{
//		//SNEHAL D'MELLO
//		String query="";
//		int index=0, count=0;
//		Movie[] movieInfo = null;
//		try{
//
//			query="select count(1) from movie where "+attributeName+" LIKE '"+attributeValue+"%'"; // also check by having % in the beginning
//			ps= con.prepareStatement(query);
//			rs= ps.executeQuery();
//			System.out.println(query);
//
//			if (rs.next()) {
//				 count = rs.getInt(1);
//			}
//
//			movieInfo = new Movie[count];
//
//			query = "select * from movie where "+attributeName+" LIKE '"+attributeValue+"%'"; // also check by having % in the beginning
//			ps=con.prepareStatement(query);
//			rs = ps.executeQuery();
//
//			while(rs.next())
//			{
//				Movie movie = new Movie();
//				movie.setMovieId(rs.getInt(1));
//				movie.setMovieName(rs.getString(2));
//				movie.setMovieBanner(rs.getString(3));
//				movie.setMovieReleaseDate(rs.getDate(4));
//				movie.setMovieRent(rs.getFloat(5));
//				movie.setMovieCategory(rs.getString(6));
//				movie.setAvailableCopies(rs.getInt(7));
//				movieInfo[index] = movie;
//				index++;
//
//				System.out.println(movie.getMovieId()+" "+movie.getMovieName()+" "+movie.getMovieBanner()+" "+movie.getMovieReleaseDate()+ " " +
//						" "+movie.getMovieRent()+" "+movie.getMovieCategory()+" "+ " "+movie.getAvailableCopies());
//			}
//
//			if(index>0)
//			{
//				System.out.println("Movie found");
//			}
//			else
//			{
//				System.out.println("Movie not found");
//				return null;
//			}
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			connectionPool.free(con);ps.close();
//		}
//		return movieInfo;
//
//	}
//	
//	public float isPaymentDue(long membershipId) throws SQLException
//	{
//		String query="";
//		float dueAmount=0;
//		int count=0;
//		try{
//			query="select dueAmount from premiumMembers where membershipId = "+membershipId;
//			ps=con.prepareStatement(query);
//			rs=ps.executeQuery();
//
//			if(rs.next())
//			{
//				dueAmount=rs.getFloat(1);
//				count++;
//				System.out.println("DueAmount: "+dueAmount);
//			}
//
//			if(count==0)
//			{
//				System.out.println("Member not found");
//			}
//
//		}
//		catch(SQLException e)
//		{
//			e.printStackTrace();
//		}
//		finally{
//			connectionPool.free(con);ps.close();
//		}
//		return dueAmount;
//	}
//
//	public boolean removeMovieFromCart(int cartId) throws SQLException//Can also pass combination of membershipId and movieId
//	{
//		//SNEHAL D'MELLO
//		int output=0;
//		boolean result=false;
//		String query="";
//		try{
//
//			query="delete from Cart where CartId="+cartId;
//			ps=con.prepareStatement(query);
//			output = ps.executeUpdate();
//
//			System.out.println(query);
//			if(output > 0)
//			{
//				result = true;
//				System.out.println("Delete Successful");
//			}
//			else if(output == 0)
//			{
//				result = false;
//				System.out.println("The data could not be deleted from the database.");
//			}
//		}
//		catch(SQLException e)
//		{
//			e.printStackTrace();
//		}
//		finally{
//			connectionPool.free(con);ps.close();
//		}
//		return result;
//	}
//
//	
//	public Cart[] displayCart(long membershipId) throws SQLException {
//	//Author: Sweta Patel
//		//ResultSet rs,rs1;
//		//PreparedStatement ps,ps1;
//		//Movie movie = null;
//		Cart[] cartAll = null;
//		//Person[] person = null;
//		Movie movie = null;
//		int index =0;
//		try {
//			String query, query1, query2;
//			int Count=0;
//			query = "select * from cart where membershipId = "+ membershipId + ";";
//			query1 = "select count(1) from cart where membershipId = "+ membershipId + ";";
//			//query2 = "select person.membershipId,person.firstName,person.lastName from transactions,person where transactions.membershipId = person.membershipId and transactions.movieId = "+ movieId+ ";";
//			//ResultSet rs;
//			
//			
//			ps1= con.prepareStatement(query1);
//			rs1=ps1.executeQuery();
//				if (rs1.next()) {
//					 Count = rs1.getInt(1);
//				}
//			
//			cartAll = new Cart[Count];
//			
//			ps= con.prepareStatement(query);
//			rs= ps.executeQuery();
//			
//			while (rs.next()) {	
//				Cart cart = new Cart();
//				cart.setCartId(rs.getInt("cartId"));
//				int tempMovieId = rs.getInt("movieId");
//				cart.setMovieId(tempMovieId);
//				
//				ps1= con.prepareStatement("select * from movie where movieId = "+ tempMovieId + ";");
//				rs1=ps1.executeQuery();
//					if (rs1.next()) {
//						 movie = new Movie();
//						 movie.setMovieName(rs1.getString("movieName"));
//						 movie.setMovieBanner(rs1.getString("movieBanner"));
//						 movie.setMovieRent(rs1.getFloat("movieRent"));
//						 movie.setMovieCategory(rs1.getString("movieCategory"));
//						 cart.setMovieDetails(movie);
//						 
//					}
//									
//					cartAll[index] = cart;
//					index++;
//			}
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			connectionPool.free(con);ps.close();
//		}
//		return cartAll;
//			
//	}//method
//
//
//	
//	
//	public boolean addToCart(int movieId, long memberId) throws SQLException
//	{
//		boolean result=false;
//		int rowcount=0;
//		Cart cart_details=new Cart();
//
//		try {
//			
////				for (int i = 0; i < cart_details_array.length; i++) {
////					rowcount=0;
////					cart_details=cart_details_array[i];
//					ps=(PreparedStatement) con.prepareStatement("Insert into cart (membershipId,movieId) values (?,?)");
//					
//					ps.setLong(1, memberId);
//					ps.setInt(2,movieId);
//					rowcount=ps.executeUpdate();
//					
//					if(rowcount>0)
//					{
//						result=true;
//					}
//				//}				
//			}
//		 catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			connectionPool.free(con);ps.close();
//		}
//		
//		return result;
//	}
//
//	public boolean dopayment(long membershipId, float dueAmount) throws SQLException
//	{
//		boolean result=false;
//		int rowcount=0;
//		
//		int interval=((int)dueAmount/50)*30;
//				
//		try {
//				ps=(PreparedStatement) con.prepareStatement("update premiummembers set dueAmount=0, expirydate=DATE_ADD(NOW(),INTERVAL "+interval+" DAY) where membershipId=?");
//				ps.setLong(1, membershipId);
//				rowcount=ps.executeUpdate();
//				
//				if(rowcount>0)
//				{
//					result=true;
//				}
//				
//			}
//		 catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			connectionPool.free(con);ps.close();
//		}
//		
//		return result;
//	}
//
//	public Movie getMovieInformationWithIssuedByUsers(int movieId) throws SQLException {
//	// Author: Sweta Patel
//		//ResultSet rs,rs1;
//		//PreparedStatement ps,ps1;
//		Movie movie = null;
//		Person[] person = null;
//		try {
//			String query, query1, query2;
//			int Count=0;
//			query = "select * from movie where movieId = "+ movieId + ";";
//			query1 = "select count(1) from transactions where movieId = "+ movieId + ";";
//			query2 = "select person.membershipId,person.firstName,person.lastName from transactions,person where transactions.membershipId = person.membershipId and transactions.movieId = "+ movieId+ ";";
//			//ResultSet rs;
//			ps= con.prepareStatement(query);
//			rs= ps.executeQuery();
//			if (rs.next()) {	
//				movie = new Movie();
//				movie.setMovieName(rs.getString("movieName"));
//				movie.setMovieBanner(rs.getString("movieBanner"));
//				movie.setMovieReleaseDate(rs.getDate("movieReleaseDate"));
//				movie.setMovieRent(rs.getFloat("movieRent"));
//				movie.setMovieCategory(rs.getString("movieCategory"));
//				movie.setAvailableCopies(rs.getInt("availableCopies"));
//				
//				ps1= con.prepareStatement(query1);
//				rs1=ps1.executeQuery();
//					if (rs1.next()) {
//						 Count = rs1.getInt(1);
//					}
//				
//				person = new Person[Count];
//				
//				ps1= con.prepareStatement(query2);
//				rs1= ps1.executeQuery();
//				int index = 0;
//				
//					while (rs1.next()) {
//						Person p = new Person();
//						p.setMembershipId(rs1.getLong("membershipId"));
//						p.setFirstName(rs1.getString("firstName"));
//						p.setLastName(rs1.getString("lastName"));
//						person[index] = p;
//						index++;
//											
//					}
//					
//				movie.setUsers(person);	
//					
//							}
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			connectionPool.free(con);ps.close();
//		}
//		return movie;
//			
//	}//method
//
//	public boolean emptyCart(long membershipId) throws SQLException
//	{
//		//SNEHAL D'MELLO
//		int output=0;
//		boolean result=false;
//		String query="";
//		try{
//
//			query="delete from Cart where membershipId="+membershipId;
//			ps=con.prepareStatement(query);
//			output = ps.executeUpdate();
//
//			System.out.println(query);
//			if(output > 0)
//			{
//				result = true;
//				System.out.println("Delete Successful");
//			}
//			else if(output == 0)
//			{
//				result = false;
//				System.out.println("The data could not be deleted from the database.");
//			}
//		}
//		catch(SQLException e)
//		{
//			e.printStackTrace();
//		}
//		finally{
//			connectionPool.free(con);ps.close();
//		}
//		return result;
//	}
//	public boolean returnMovie(int movieId, long membershipId, int userType) throws SQLException
//	{
//		Date dueDate=new Date();
//		boolean result=false;
//		
//		//ps=(PreparedStatement)con.prepareStatement("update transactions set actu");
//		
//		//fetch date from duedate table
//		ps=(PreparedStatement)con.prepareStatement("select dueDate from transactions where membershipId=? and movieId=?");
//		ps.setLong(1, membershipId);
//		ps.setInt(2, movieId);
//		rs=ps.executeQuery();
//		while(rs.next())
//		{
//			dueDate=rs.getDate(1);
//		}
//		
//		final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
//		Date actualReturnDate = new Date(System.currentTimeMillis());
//		//actualReturnDate=currentDate;
//		int diffInDays = (int) ((actualReturnDate.getTime() - dueDate.getTime())/ DAY_IN_MILLIS );
//		if(diffInDays>0)
//		{
//			System.out.println("ur fine for "+diffInDays+" days");
//		}
//		else
//		{
//			diffInDays=0;
//		}
//		
//		//insert actualreturndate and fine amt
//		ps=(PreparedStatement)con.prepareStatement("update transactions set actualReturnDate=NOW(), fineAmount=? where membershipId=? and movieId=?");
//		ps.setFloat(1, diffInDays*5);
//		ps.setLong(2, membershipId);
//		ps.setInt(3, movieId);
//		int rowcount=ps.executeUpdate();
//		if(rowcount>0)
//		{
//			result=true;
//			ps=(PreparedStatement)con.prepareStatement("update movie set availableCopies=availableCopies+1 where movieId=?");
//			ps.setInt(1, movieId);
//			rowcount=0;
//			rowcount=ps.executeUpdate();
//			System.out.println("rowcount is "+rowcount);
//			if(rowcount>0)
//			{
//				result=true;
//			}
//			//update into premiummembers or simplemembers abt totaloutstanding-1
//			if(userType==0)
//			{
//				ps=(PreparedStatement)con.prepareStatement("update simplemembers set totalOutstandingMovies=totalOutstandingMovies-1 where membershipId=?");
//				ps.setLong(1, membershipId);
//				rowcount=ps.executeUpdate();
//			}
//			else if(userType==1)
//			{
//				ps=(PreparedStatement)con.prepareStatement("update premiummembers set totalOutstandingMovies=totalOutstandingMovies-1 where membershipId=?");
//				ps.setLong(1, membershipId);
//				rowcount=ps.executeUpdate();
//			}
//			
//		}
//			
//		connectionPool.free(con);ps.close();
//		
//		return result;
//	}
//	public boolean rentMovie(Cart[] cart_details_array , long membershipId,int userType) throws SQLException
//	{
//		int rowcount=0;
//		//ResultSet rs;
//		boolean result=false;
//		String query;
//		int availableCopies=0;
//
//		try {
//			//loop on whole cart array
//			for (int i = 0; i < cart_details_array.length; i++) {
//				Cart cart_details=new Cart();
//				cart_details=cart_details_array[i];
//
//				//fetch if copies are available for that movie
//				ps=(PreparedStatement) con.prepareStatement("select availableCopies from movie where movieId=?");
//
//				ps.setInt(1,cart_details.getMovieId());
//
//				rs=ps.executeQuery();
//
//				while(rs.next())
//				{
//					availableCopies=rs.getInt(1);
//					System.out.println("available copies is: "+availableCopies);
//				}
//
//				if(availableCopies==0)
//				{
//					return result=false;
//				}
//				else
//				{
//				
//						//update totalOutstandingMovies for simplemembers
//						if(userType==1)
//						{
//							int totalOutstandingmovies=0;
//							ps=(PreparedStatement)con.prepareStatement("select totalOutstandingMovies from simplemembers where membershipId=?");
//							ps.setLong(1, membershipId);
//							rs=ps.executeQuery();
//							while(rs.next())
//							{
//								totalOutstandingmovies=rs.getInt(1);
//								System.out.println("totalOutstandingmovies copies is: "+totalOutstandingmovies);
//							}
//							if(totalOutstandingmovies>=2)
//							{
//								return false;
//							}
//							else
//							{
//								ps=(PreparedStatement)con.prepareStatement("update simplemembers set totalOutstandingMovies=totalOutstandingMovies+1 where membershipId=?");
//								ps.setLong(1, membershipId);
//								rowcount=ps.executeUpdate();
//								if(rowcount>0)
//								{
//									result=true;
//								}
//							}
//							
//						}
//						else //update totalOutstandingMovies for premiummembers
//						{
//							int totalOutstandingmovies=0;
//							ps=(PreparedStatement)con.prepareStatement("select totalOutstandingMovies from premiummembers where membershipId=?");
//							ps.setLong(1, membershipId);
//							rs=ps.executeQuery();
//							while(rs.next())
//							{
//								totalOutstandingmovies=rs.getInt(1);
//								System.out.println("totalOutstandingmovies copies is: "+totalOutstandingmovies);
//							}
//							if(totalOutstandingmovies>=10)
//							{
//								return false;
//							}
//							else
//							{
//								ps=(PreparedStatement)con.prepareStatement("update premiummembers set totalOutstandingMovies=totalOutstandingMovies+1 where membershipId=?");
//								ps.setLong(1, membershipId);
//								rowcount=ps.executeUpdate();
//								if(rowcount>0)
//								{
//									result=true;
//								}
//							}
//							
//							
//						}
//						
//						//if copy is available then do the transaction
//						ps=(PreparedStatement)con.prepareStatement("insert into transactions (membershipId,movieId,issueDate, dueDate) values (?,?,NOW(),DATE_ADD(NOW(),INTERVAL 14 DAY))");
//						ps.setLong(1, membershipId);
//						ps.setInt(2, cart_details.getMovieId());
//						rowcount=ps.executeUpdate();
//						
//						//reflect into movie table that available copy is decreased
//						ps=(PreparedStatement)con.prepareStatement("update movie set availableCopies=availableCopies-1 where movieId=?");
//						ps.setInt(1, cart_details.getMovieId());
//						rowcount=0;
//						ps.executeUpdate();
//
//					
//
//				}
//
//			}			
//
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			connectionPool.free(con);ps.close();
//		}
//		return result;
//	}
//
//
//	public Person getUserInformationWithIssuedMovies(long membershipId) throws SQLException
//	{
//		//SNEHAL D'MELLO
//		ResultSet rs;
//		PreparedStatement ps;
//		Person person=null;
//
//		try{
//			String query;
//			int Count=0;
//			person = primaryList.get(new Long(membershipId));
//			if (person == null) {			//abhi
//				
//							
//				query="select * from person where membershipId="+membershipId;
//
//				ps = con.prepareStatement(query);
//				rs=ps.executeQuery();
//
//				if(rs.next())
//				{
//					person = new Person();
//					person.setMembershipId(rs.getLong("membershipId"));
//					person.setFirstName(rs.getString("firstName"));
//					person.setLastName(rs.getString("lastName"));
//					person.setEmailId(rs.getString("emailId"));
//					person.setPassword(rs.getString("password"));
//					person.setAddress(rs.getString("address"));
//					person.setCity(rs.getString("city"));
//					person.setState(rs.getString("state"));
//					person.setZipCode(rs.getLong("zipCode"));
//					person.setUserType(rs.getInt("userType"));
//					person.setRegistrationDate(rs.getDate("registrationDate"));
//					person.setLastLogin(rs.getTimestamp("lastLogin"));
//				}
//				
//			}	
//			else{
//				System.out.println("Returning person from HashMap..");		//ab	
//				person=primaryList.get(new Long(membershipId));				//ab
//			}
//
//			query = "select a.movieId, b.movieName from transactions a, movie b where membershipId="+membershipId+" and a.movieId = b.movieId";
//
//			ps = con.prepareStatement(query);
//			rs=ps.executeQuery();
//
//			while (rs.next()) {	
//				Transactions transaction = new Transactions();
//				Movie movie = new Movie();
//				transaction.setMovieId(rs.getInt("a.movieId"));
//				movie.setMovieName(rs.getString("b.movieName"));
//				transaction.setMovie(movie);
//				person.setTransaction(transaction);
//			}	
//		}
//		catch(SQLException e)
//		{
//			e.printStackTrace();
//		}
//		
//		finally{
//			connectionPool.free(con);
//			//ps.close();
//		}
//
//		Transactions T[] = person.getTransactions();
//
//	return person;
//	}
//
//
//	
//}//class
