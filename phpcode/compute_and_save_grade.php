<?php
header('Access-Control-Allow-Origin: *');
include_once 'course_Dao.php';
include_once 'course_user_dao.php';


$input = json_decode(file_get_contents('php://input'), true);


$courseId = $_REQUEST["CourseId"];
$studentId = $_REQUEST["StudentId"];



$Homework =$_REQUEST["MHomework"];
$Labs = $_REQUEST["MLabs"];
$Project = $_REQUEST["MProject"];
$Presentation = $_REQUEST["MPresentation"];
$Midterm = $_REQUEST["MMidterm"];
$Final = $_REQUEST["MFinal"];


$data = get_course_info_by_id($courseId);

//make sure that marks are not invalid
if($Homework > $data['MHomework'] || $Labs > $data['MLabs'] || $Project > $data['MProject'] || $Presentation > $data['MPresentation']
|| $Midterm > $data['MMidterm'] || $Final > $data['MFinal']){
	 http_response_code(400);
	 $response = array("error"=>"one of the fields is wrong");
	 //$response['error'] = "One of the field has marks more than the max marks";
	 //print "returning the error";
	 return json_encode($response);	
}

//calculate percentage of every field.
$homework_percent = compute_percentage($data['MHomework'], $Homework, $data['PHomework']);
$labs_precent = compute_percentage($data['MLabs'], $Labs, $data['PLabs']);
$project_precent = compute_percentage($data['MProject'], $Project, $data['PProject']);
$presentation_precent = compute_percentage($data['MPresentation'], $Presentation, $data['PPresentation']);
$mideterm_percent = compute_percentage($data['MMidterm'], $Midterm, $data['PMidterm']);
$final_precent = compute_percentage($data['MFinal'], $Final, $data['PFinal']);

//print "\n homework marks: " . $homework_percent . "\n\n";

$total_percent = $homework_percent + $labs_precent + $project_precent + $presentation_precent + $mideterm_percent + $final_precent;

//print "total percentage: " . $total_percent ."\n\n";

$grade = compute_grade($total_percent, $data);

$total_marks = $Homework + $Labs + $Project + $Presentation + $Midterm + $Final;

insert_or_update_grades($courseId, $studentId, $Homework, $Labs, $Project, $Presentation, $Midterm, $Final, $grade);

$response_data = array("grade"=>$grade, "percentage"=>$total_percent, "totalMarks"=>$total_marks);

header('Content-Type: application/json');
echo json_encode($response_data);

return json_encode($response_data);
//http_response_code(400);

function compute_percentage($max_marks, $marks_obtained, $weightage){
	$percentage = ($weightage * $marks_obtained)/$max_marks;
	return $percentage;
}

function compute_grade($total_percent, $data){
	if($total_percent >= $data['ARangeStart'] && $total_percent <= $data['ARangeEnd']){
		return "A";
	}
	else if ($total_percent >= $data['BRangeStart'] && $total_percent < $data['ARangeStart']){
		return "B";
	}
	else if ($total_percent >= $data['CRangeStart'] && $total_percent < $data['BRangeStart']){
		return "C";
	}
	else if ($total_percent >= $data['DRangeStart'] && $total_percent < $data['CRangeStart']){
		return "D";
	}
	else if ($total_percent >= $data['FRangeStart'] && $total_percent < $data['DRangeStart']){
		return "F";
	}
}
?>