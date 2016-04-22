<?php
header('Access-Control-Allow-Origin: *');
include 'database_config.php';



$courseId = $_POST["courseId"];

$ARangeStart = $_POST["ARangeStart"];
$ARangeEnd = $_POST["ARangeEnd"];

$BRangeStart = $_POST["BRangeStart"];
$BRangeEnd = $_POST["BRangeEnd"];

$CRangeStart = $_POST["CRangeStart"];
$CRangeEnd = $_POST["CRangeEnd"];

$DRangeStart = $_POST["DRangeStart"];
$DRangeEnd = $_POST["DRangeEnd"];

$FRangeStart = $_POST["FRangeStart"];
$FRangeEnd = $_POST["FRangeEnd"];

$flag = false;

//make sure that no value is greater than 100.
if($ARangeStart > 100 || $ARangeEnd > 100 || $BRangeStart > 100 || $BRangeEnd > 100 || $CRangeStart > 100 || $CRangeEnd > 100 
|| $DRangeEnd > 100 || $DRangeStart >100 || $FRangeEnd >100 || $FRangeStart >100){
	$flag = true;
	$response_message = array("error"=>"one of the fields have value greater than 100");
}

//make sure values are not overlapping.
else if($FRangeEnd > $DRangeStart || $DRangeEnd > $CRangeStart || $CRangeEnd > $BRangeStart || $BRangeEnd > $ARangeStart){
	$flag = true;
	$response_message = array("error"=>"Values are overlapping. Please check again.");
}

//make sure Min is not bigger than Max.
else if($ARangeStart > $ARangeEnd || $BRangeStart > $BRangeEnd || $CRangeStart > $CRangeEnd || $DRangeStart > $DRangeEnd || $FRangeStart > $FRangeEnd){
	$flag = true;
	$response_message = array("error"=>"Min value is more than Max value for one of the fields");
}

if($flag == true){
	http_response_code(400);
	header('Content-Type: application/json');
	echo json_encode($response_message);
	return;
}

$conn = get_connection();

$sql = "UPDATE courses SET ".
		"ARangeStart=$ARangeStart, ".
		"ARangeEnd=$ARangeEnd, ".
		"BRangeStart=$BRangeStart, ".
		"BRangeEnd=$BRangeEnd, ".
		"CRangeStart=$CRangeStart, ".
		"CRangeEnd=$CRangeEnd, ".
		"DRangeStart=$DRangeStart, ".
		"DRangeEnd=$DRangeEnd, ".
		"FRangeStart=$FRangeStart, ".
		"FRangeEnd=$FRangeEnd ".
		"WHERE ID=$courseId";

//print $sql . "\n";

if (mysqli_query($conn, $sql)) {
    $status = "Record updated successfully";
} else {
    $status = "Error updating record: " . mysqli_error($conn);
}

$data = array("status"=>$status);

header('Content-Type: application/json');
echo json_encode($data);

?>