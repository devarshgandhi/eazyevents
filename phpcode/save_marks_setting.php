<?php

header('Access-Control-Allow-Origin: *');

include 'database_config.php';


$courseId = $_POST["courseId"];
$MHomework = $_POST["MHomework"];
$MLabs = $_POST["MLabs"];
$MProject = $_POST["MProject"];
$MPresentation = $_POST["MPresentation"];
$MMidterm = $_POST["MMidterm"];
$MFinal = $_POST["MFinal"];

$conn = get_connection();

$sql = "UPDATE courses SET ".
		"MHomework=$MHomework, ".
		"MLabs=$MLabs, ".
		"MProject=$MProject, ".
		"MPresentation=$MPresentation, ".
		"MMidterm=$MMidterm, ".
		"MFinal=$MFinal ".
		"WHERE ID=$courseId";

if (mysqli_query($conn, $sql)) {
    $status = "Record updated successfully";
} else {
    $status = "Error updating record: " . mysqli_error($conn);
}

$data = array("status"=>$status);	

header('Content-Type: application/json');
echo json_encode($data);

?>
