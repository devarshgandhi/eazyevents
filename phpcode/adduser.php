<?php

include_once 'database_config.php';

$Course = $_POST["class"];
$LLocation = $_POST["location"];
$DDate = $_POST["date"];
$TTime = $_POST["time"];
$CCapacity = $_POST["capacity"];
$DDescription = $_POST["description"];

error_log($DDate);
$adminname = $_POST["fromLoginUserName"];


	$conn = get_connection();
	if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
echo "Connected successfully";

	$sql = "INSERT INTO `eventstable`(`CourseName`,`Description`,`date1`,`time1`,`capacity1`,`locationname`,`createdby`) 
        VALUES ('$Course','$DDescription','$DDate','$TTime','$CCapacity','$LLocation','$adminname')";

	
	
	if (mysqli_query($conn, $sql)) {
		print "Record inserted successfully";
	} else {
		print "Error inserting record: " . mysqli_error($conn);
	}
	
	mysqli_close($conn);

?>