<?php
header('Access-Control-Allow-Origin: *');
include_once 'database_config.php';

$Course = $_POST["ID"];
$DDescription = $_POST["password"];
$TType = $_POST["Type"];
$NName = $_POST["name2"];
$Email = $_POST["email"];
$Phone = $_POST["phone"];
error_log($NName);
error_log($Email);

	$conn = get_connection();
	if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 


	$sql = "INSERT INTO `login`(`ID`,`Password`,`Type`,`name1`,`email`,`phone`) 
        VALUES ('$Course','$DDescription','$TType','$NName','$Email','$Phone')";

	
	
	if (mysqli_query($conn, $sql)) {
		$r = array('status'=>"True");

header('Content-Type: application/json');
echo json_encode($r);
	} else {
$conn = get_connection();
$query =  "SELECT * FROM `login` WHERE email='$Email'";
error_log($query);
$result = mysqli_query($conn, $query);
error_log(mysqli_num_rows($result));
if(mysqli_num_rows($result)>0){
$r = array('status'=>"Error","email"=>"Email already exists");

header('Content-Type: application/json');

    
}
		

header('Content-Type: application/json');
echo json_encode($r);
	}
	
	mysqli_close($conn);

?>