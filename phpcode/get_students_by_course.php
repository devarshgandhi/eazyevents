<?php
header('Access-Control-Allow-Origin: *');
include 'course_Dao.php';

//handle /get_course?courseId=something
if(isset($_GET["courseId"])){

	$courseId = $_GET["courseId"];
	$data = get_students_info_by_id($courseId);
}
else{
	//handle /get_course
	$data = get_course_info();
}

header('Content-Type: application/json');
echo json_encode($data);
?>