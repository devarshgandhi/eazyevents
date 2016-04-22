<?php
header('Access-Control-Allow-Origin: *');
include 'course_Dao.php';

//handle /get_course?courseId=something
if(isset($_GET["courseId"])){

	$courseId = $_GET["courseId"];
	$data = get_course_info_by_id($courseId);
error_log($courseId);
}
else{
	//handle /get_course
	$data = get_course_info();
}

header('Content-Type: application/json');
echo json_encode($data);

/* /* 
	returns course Name and courseId.
*/
/* function get_course_info_by_id($courseId){
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

/*
	returns all courses present in the database.
*//*
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
} */

/*
	gets array in the right format.
*/
/* function get_course_record($row){
	$data = array('ID'=>intval($row["ID"]), 
					'CourseName'=>$row["CourseName"], 
					'MHomework'=>intval($row["MHomework"]), 
					'MLabs'=>intval($row["MLabs"]),
					'MProject'=>intval($row["MProject"]), 
					'MPresentation'=>intval($row["MPresentation"]), 
					'MMidterm'=>intval($row["MMidterm"]),
					'MFinal'=>intval($row["MFinal"]), 
					'PHomework'=>intval($row["PHomework"]), 
					'PLabs'=>intval($row["PLabs"]),
					'PProject'=>intval($row["PProject"]), 
					'PPresentation'=>intval($row["PPresentation"]), 
					'PMidterm'=>intval($row["PMidterm"]),
					'PFinal'=>intval($row["PFinal"]), 
					'ARangeStart'=>intval($row["ARangeStart"]), 
					'ARangeEnd'=>intval($row["ARangeEnd"]),
					'BRangeStart'=>intval($row["BRangeStart"]), 
					'BRangeEnd'=>intval($row["BRangeEnd"]), 
					'CRangeStart'=>intval($row["CRangeStart"]), 
					'CRangeEnd'=>intval($row["CRangeEnd"]), 
					'DRangeStart'=>intval($row["DRangeStart"]), 
					'DRangeEnd'=>intval($row["DRangeEnd"]), 
					'ERangeStart'=>intval($row["ERangeStart"]), 
					'ERangeEnd'=>intval($row["ERangeEnd"]), 
					'FRangeStart'=>intval($row["FRangeStart"]),
					'FRangeEnd'=>intval($row["FRangeEnd"]));
	//print "data is: \n" . $data;	
	return $data;
} */
?>