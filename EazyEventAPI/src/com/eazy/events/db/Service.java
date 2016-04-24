package com.eazy.events.db;
//package VideoLibrary;
//
//import entity.Cart;
//import entity.Movie;
//import entity.Person;
//import entity.PremiumMembers;
//import entity.SimpleMembers;
//import entity.Transactions;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.Date;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//
//import javax.jws.WebService;
//
//@WebService
//public class Service {
//
//	DatabaseConnection db = new DatabaseConnection();
//	Statement stmt = null;
//
//	public String createMember(long memberId, String fName, String lName,
//			String emailId, String pwd, String address, String city,
//			String state, long zipCode, Integer userType,
//			Integer monthlySubFee, Integer totalOutstandingMovies,
//			Integer rentForMoviesIssued) throws SQLException {
//		String result;
//		result = db.createMember(memberId, fName, lName, emailId, pwd, address,
//				city, state, zipCode, userType, monthlySubFee,
//				totalOutstandingMovies, rentForMoviesIssued);
//
//		return result;
//	}
//
//	public Person login(String emailId, String pwd) throws SQLException {
//		Person person;
//		person = db.login(emailId, pwd);
//		return person;
//	}
//
//	public Person memberFromID(long membershipId) throws SQLException {
//		Person person;
//		person = db.memberFromID(membershipId);
//		return person;
//	}
//
//	public boolean updatePerson(long membershipId, String firstName,
//			String lastName, String emailId, String password, String address,
//			String city, String state, long zipCode) throws SQLException {
//		// System.out.println("inside service");
//		return db.updatePerson(membershipId, firstName, lastName, emailId,
//				password, address, city, state, zipCode);
//	}
//
//	public Movie[] displayMovies() throws SQLException {
//		// return Movies from Movie table
//		return db.displayMovies();
//	}
//
//	public PremiumMembers[] displayPremiumMembers() throws SQLException {
//		return db.displayPremiumMembers();
//	}
//
//	public Person[] displayPerson() throws SQLException {
//		return db.displayPerson();
//	}
//
//	public SimpleMembers[] displaySimpleMembers() throws SQLException {
//
//		return db.displaySimpleMembers();
//	}
//
//	public boolean createMovie(String movieName, String movieBanner,
//			Date movieReleaseDate, float movieRent, String movieCategory,
//			int availableCopies) throws SQLException {
//		return db.createMovie(movieName, movieBanner, movieReleaseDate,
//				movieRent, movieCategory, availableCopies);
//
//	}
//
//	public boolean deleteMovie(int movieId, String movieName) throws SQLException {
//		return db.deleteMovie(movieId, movieName);
//	}
//
//	public boolean deleteMember(long membershipId) throws SQLException {
//		boolean result;
//		result = db.deleteMember(membershipId);
//
//		return result;
//	}
//
//	public boolean updateMovie(int movieId, String movieName,
//			String movieBanner, Date movieReleaseDate, float movieRent,
//			String movieCategory, int availableCopies) throws SQLException {
//		return db.updateMovie(movieId, movieName, movieBanner,
//				movieReleaseDate, movieRent, movieCategory, availableCopies);
//	}
//
//	public Movie[] updateMovieRequest(int movieId) throws SQLException {
//		return db.updateMovieRequest(movieId);
//	}
//
//	public Movie[] searchMovie(String attributeName, String attributeValue) throws SQLException {
//		System.out.println("In Service- search movie");
//		Movie movieInfo[];
//		movieInfo = db.searchMovie(attributeName, attributeValue);
//
//		return movieInfo;
//	}
//
//	public Person[] searchPerson(String attributeName, String attributeValue) throws SQLException {
//		Person personInfo[];
//		personInfo = db.searchPerson(attributeName, attributeValue);
//
//		return personInfo;
//	}
//
//	public boolean addToCart(int movieId, long memberId) throws SQLException {
//		return db.addToCart(movieId, memberId);
//	}
//
//	public boolean dopayment(long membershipId, float dueAmount) throws SQLException {
//		return db.dopayment(membershipId, dueAmount);
//	}
//
//	public Movie getMovieInformationWithIssuedByUsers(int movieId) throws SQLException {
//		return db.getMovieInformationWithIssuedByUsers(movieId);
//	}
//
//	public Cart[] displayCart(long membershipId) throws SQLException {
//		return db.displayCart(membershipId);
//	}
//
//	public boolean removeMovieFromCart(int cartId) throws SQLException {
//		boolean result;
//		result = db.removeMovieFromCart(cartId);
//		return result;
//	}
//
//	public float isPaymentDue(long membershipId) throws SQLException {
//		float amount;
//		amount = db.isPaymentDue(membershipId);
//
//		return amount;
//	}
//
//	public boolean emptyCart(long membershipId) throws SQLException {
//		boolean result;
//		result = db.emptyCart(membershipId);
//		return result;
//	}
//
//	public Transactions[] issuedMovieList(long membershipId) throws SQLException {
//		System.out.println("In serevie");
//
//		return db.issuedMovieList(membershipId);
//
//	}
//
//	public boolean rentMovie(Cart[] cart_details_array, long membershipId,
//			int userType) throws SQLException {
//		return db.rentMovie(cart_details_array, membershipId, userType);
//	}
//
//	public boolean returnMovie(int movieId, long membershipId, int userType)
//			throws SQLException {
//		boolean result = false;
//		result = db.returnMovie(movieId, membershipId, userType);
//		System.out.println(result);
//		return result;
//	}
//
//	
//	public Person getUserInformationWithIssuedMovies(long membershipId) throws SQLException
//	{
//		return db.getUserInformationWithIssuedMovies(membershipId);
//	}
//
//}
