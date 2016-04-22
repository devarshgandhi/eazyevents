<?php
include 'database_config.php';

/* 
	returns course Name and courseId.
*/
function get_course_info_by_id($courseId){

	$conn = get_connection();
	$sql = "SELECT * FROM eventstable where ID=" . $courseId;
	$result = mysqli_query($conn, $sql);

	if (mysqli_num_rows($result) > 0) {
    // output data of each row
		while($row = mysqli_fetch_assoc($result)) {
			$data = get_course_record($row);
		}
	} else {
		echo "0 results";
	}
	mysqli_close($conn);
	return $data;
}

function get_students_info_by_id($courseId){
	
	$conn = get_connection();
	$sql = "select * from users inner join course_user on users.ID = course_user.PUserId where course_user.PCourseId = $courseId";
	//$sql = "SELECT * FROM eventstable where ID=" . $courseId;
	$result = mysqli_query($conn, $sql);
	$array = array();
	if (mysqli_num_rows($result) > 0) {
    // output data of each row
		while($row = mysqli_fetch_assoc($result)) {
			$data = get_course_user_record($row);
			$array[] = $data;
		}
	} else {
		echo "0 results";
	}
	mysqli_close($conn);
	return $array;
}
/*
	returns all courses present in the database.
*/
function get_course_info(){
	$conn = get_connection();
	$sql = "SELECT * FROM eventstable";
	$result = mysqli_query($conn, $sql);
	$array = array();
	if (mysqli_num_rows($result) > 0) {
    // output data of each row
		while($row = mysqli_fetch_assoc($result)) {
			$data = get_course_record($row);
			$array[] = $data;
		}
	} else {
		echo "0 results";
	}
	
	mysqli_close($conn);
	return $array;
}

/*
	gets array in the right format.
*/
function get_course_record($row){
	$data = array('ID'=>intval($row["ID"]), 
					'CourseName'=>$row["CourseName"], 
					'locationname'=>$row["locationname"],
                                        'time1'=>$row["time1"],
                                        'capacity1'=>$row["capacity1"],
					'Description'=>$row['Description']);
	//print "data is: \n" . $data;	
	return $data;
}

function get_course_user_record($row){
		$data = array('ID'=>intval($row["ID"]), 
					'Homework'=>intval($row["Homework"]), 
					'Labs'=>intval($row["Labs"]),
					'Project'=>intval($row["Project"]), 
					'Presentation'=>intval($row["Presentation"]), 
					'Midterm'=>intval($row["Midterm"]),
					'Final'=>intval($row["Final"]), 
					'FirstName'=>$row["FirstName"],
					'LastName'=>$row["LastName"],
					'EmailId'=>$row["EmailId"]);
		
		return $data;
}
?>