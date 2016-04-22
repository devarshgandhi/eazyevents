<?php
header('Access-Control-Allow-Origin: *');
include 'database_config.php';

//$data = json_decode(file_get_contents('php://input'), true);
//$ID = $data["ID"];
//$pw = $data["password"];
$ID = $_POST["ID"];
$pw = $_POST["password"];


$conn = get_connection();
$sql = "SELECT Type FROM login WHERE `ID` = '$ID' AND Password='$pw'";

$result = mysqli_query($conn, $sql);


 while ($array = mysql_fetch_row($result));
if ($result->num_rows > 0) {
     // output data of each row
    $row = $result->fetch_assoc();
error_log($row);

$r = array('status'=>$row["Type"],'username'=>$row["name1"]);

header('Content-Type: application/json');
echo json_encode($r);

} else {
   
 $data = array("status"=>"Error","error"=>"Wrong Username or Password");

echo json_encode($data);

}






function authenticate_user($ID, $pw){
	$conn = get_connection();
	$sql = "SELECT * FROM `login` WHERE ID='$ID' AND Password='$pw'";
	$result = mysqli_query($conn, $sql);

	if (mysqli_num_rows($result) > 0) {
$sql = "SELECT Type WHERE `ID` = '$ID'";
		$data = "true";
	} else {
		$data = "false";
	}
	mysqli_close($conn);
	return $data;
}

?>