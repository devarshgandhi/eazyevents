<?php
    header('Access-Control-Allow-Origin: *');
include 'database_config.php';



$username1 = $_POST["fromLoginUserName"];
error_log($username1);

$data1 = get_registered_events($username1);

error_log( print_R($data1,TRUE) );
header('Content-Type: application/json');
echo json_encode($data1);



function get_registered_events($username1){
        $conn = get_connection();
        $sql = "SELECT T1.eventid as eventid, T1.eventname as eventname, T2.locationname as location, 
                T2.date1 as eventdate, T2.time1 as eventtime
                FROM registered T1 JOIN eventstable T2 ON T1.eventid= T2.ID where userid= '$username1'";
       $result = mysqli_query($conn, $sql);
  
        error_log($sql);
        error_log($result);
         error_log($conn);
$array = array();
        if (mysqli_num_rows($result) > 0) {
            // output data of each row
            while($row = mysqli_fetch_assoc($result)) {
                    $data= get_event_details($row);
                    $array[] = $data;

               
            }
        } else { 
                echo "0 results";
error_log("0 results");
                }
 return $array;
            mysqli_close($conn);
           
    }

    function get_event_details($row){
        $data = array('eventid'=>intval($row["eventid"]), 
                    'eventname'=>$row["eventname"], 
                    'locationname'=>$row["location"],
                    'date1'=>$row["eventdate"],
                    'time1'=>$row["eventtime"]);
error_log($row["location"]);

        return $data;
}

    

?>