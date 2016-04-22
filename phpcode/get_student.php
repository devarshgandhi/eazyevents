<?php
header('Access-Control-Allow-Origin: *');
include 'database_config.php';

//handle /student_data?studentId=something
if(isset($_GET["studentId"])){
	//print "id is set";
	$studentId = $_GET["studentId"];
	$data = get_student_info_by_id($studentId);
}
else{
	//handle /student_data
	$data = get_student_info();
	//print "Id is not set";
}

header('Content-Type: application/json');

//print "returning json\n";
echo json_encode($data);


/*
Returns information of single student.
*/
function get_student_info_by_id($studentId){
	
	$conn = get_connection();
	$sql = "SELECT * FROM users where ID=" . $studentId;
	$result = mysqli_query($conn, $sql);

	if (mysqli_num_rows($result) > 0) {
    // output data of each row
		while($row = mysqli_fetch_assoc($result)) {
			$data = array('ID'=>intval($row["ID"]), 'FirstName'=>$row["FirstName"], 'LastName'=>$row["LastName"], 'EmailId'=>$row["EmailId"], 'Phone'=>$row['Phone']);
		}
	} else {
		echo "0 results";
	}

	mysqli_close($conn);
	return $data;
}

/*
	returns information of all students.
*/
function get_student_info(){
	
	$conn = get_connection();

	$sql = "SELECT * FROM users";
	$result = mysqli_query($conn, $sql);

	$array = array();
	if (mysqli_num_rows($result) > 0) {
    // output data of each row
		while($row = mysqli_fetch_assoc($result)) {
			$data = array('ID'=>intval($row["ID"]), 'FirstName'=>$row["FirstName"], 'LastName'=>$row["LastName"], 'EmailId'=>$row["EmailId"], 'Phone'=>$row['Phone']);
			$array[] = $data;
		}
	} else {
		echo "0 results";
	}

	mysqli_close($conn);
	return $array;
}
?>