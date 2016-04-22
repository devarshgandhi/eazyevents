<?php
$servername = "localhost";
$username = "rubypals";
$password = "Astro123#";
$dbname = "rubypals_mydb";

/*
	returns connection object of the database.
*/
function get_connection(){
	global $servername, $username, $password, $dbname;
	// Create connection
	$conn = mysqli_connect($servername, $username, $password, $dbname);
	// Check connection
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
	return $conn;
}

?>