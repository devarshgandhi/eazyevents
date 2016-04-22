<?php

header('Access-Control-Allow-Origin: *');
include_once 'database_config.php';
//echo "Homework ". $row["Homework"]. " Labs ". $row["Labs"]. " Project " . $row["Project"] . "Presentation" . $row["Presentation"]. " Midterm" . $row["Midterm"] . " Final" . $row["Final"]. " Grade" . $row["Grade"] ;

	$conn = get_connection();
	if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 


	$retval = mysql_query( $sql, $conn );
//$sql = "SELECT Homework, Labs, Project, Presentation,Midterm, Final, Grade FROM course_user WHERE `PCourseId` = '1'";
$sql = "SELECT `ID`, `CourseName`, `locationname`, `date1`, `time1`, `capacity1`, `Description` FROM `courses` WHERE 1";
$result = mysqli_query($conn, $sql);


 while ($array = mysql_fetch_row($result));
if ($result->num_rows > 0) {
     // output data of each row
    $row = $result->fetch_assoc();
 {
        
     }
} else {
     echo "0 results";
}
$data = array("Description"=>$row["Description"],"locationname"=>$row["locationname"], "date1"=>$row["date1"], "time1"=>$row["time1"],"capacity1"=>$row["capacity1"]);	

header('Content-Type: application/json');
echo json_encode($data);
mysqli_close($conn);
?>