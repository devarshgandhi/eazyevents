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

	$sql = "UPDATE  `eventstable` SET `Description`='$DDescription',`date1`='$DDate',`time1`='$TTime',`capacity1`='$CCapacity',`locationname`='$LLocation' WHERE CourseName='$Course' AND createdby = '$adminname'";

	
	
	if (mysqli_query($conn, $sql)) {
		print "Record updated successfully";
	} else {
		print "Error updating record: " . mysqli_error($conn);
	}
	
	mysqli_close($conn);

?>