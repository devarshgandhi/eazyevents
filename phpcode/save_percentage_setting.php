<?php
header('Access-Control-Allow-Origin: *');
include 'database_config.php';

$courseId = $_POST["courseId"];
$username1 = $_POST["fromLoginUserName"];
$eventname = $_POST["fromEventName"];

error_log($username1);
error_log($courseId);
error_log($eventname);
//$PHomework =$_POST["PHomework"];
//$PLabs = $_POST["PLabs"];
//$PProject = $_POST["PProject"];
//$PPresentation = $_POST["PPresentation"];
//$PMidterm = $_POST["PMidterm"];
//$PFinal = $_POST["PFinal"];

/*
$total = $PHomework + $PLabs + $PProject + $PPresentation + $PMidterm + $PFinal;
if($total != 100){
	http_response_code(400);
	$response = array("error"=>"one of the fields is wrong");
	return json_encode($response);
}
print "not executed";
*/



/*$sql = "UPDATE courses SET ".
		"PHomework=$PHomework, ".
		"PLabs=$PLabs, ".
		"PProject=$PProject, ".
		"PPresentation=$PPresentation, ".
		"PMidterm=$PMidterm, ".
		"PFinal=$PFinal ".
		"WHERE ID=$courseId";

$sql = "UPDATE registeredusers SET ".
		"userid=$username1, ".
		"eventid=$courseId, ".
		"eventname=$eventname, ";*/

$conn = get_connection();

$query = "SELECT userid FROM registered WHERE eventname = '$eventname' AND userid ='$username1'";
$result = mysqli_query($conn, $query);

	
if(mysqli_num_rows($result)  > 0)
{
$status = "False";
$message = "user already registered";
}
else{

$sql = "INSERT INTO `registered`( `userid`, `eventid`, `eventname`) VALUES ('$username1','$courseId','$eventname')";

if (mysqli_query($conn, $sql)) {
    $status = "True";
$message = "Registered Successfully";
} else {
    $status = "Error updating record: " . mysqli_error($conn);
}
}
$data = array("status"=>$status,"message"=>$message);

header('Content-Type: application/json');
echo json_encode($data);

?>