<?php

include_once 'database_config.php';

function insert_or_update_grades($courseId, $studentId, $homework, $labs, $project, $presentation, $midterm, $final, $grade){
	$conn = get_connection();

	$sql = "SELECT * FROM course_user WHERE PCourseId=$courseId AND PUserId=$studentId";
	//print "\n" . $sql . "\n\n";
	$result = mysqli_query($conn, $sql);

	if (mysqli_num_rows($result) > 0) {
		$should_insert = false;
	} else {
		$should_insert = true;
	}
	//close the connection here itself.
	mysqli_close($conn);
	
	if($should_insert){
		//print "going to insert";
		insert($courseId, $studentId, $homework, $labs, $project, $presentation, $midterm, $final, $grade);
	}
	else {
		//print "Going to update";
		update($courseId, $studentId, $homework, $labs, $project, $presentation, $midterm, $final, $grade);
	}
}

function insert($courseId, $studentId, $homework, $labs, $project, $presentation, $midterm, $final, $grade){
	$conn = get_connection();
	
	$sql = "INSERT INTO `course_user`(`PCourseId`, `PUserId`, `Homework`, `Labs`, `Project`, `Presentation`, `Midterm`, `Final`, `Grade`) 
	VALUES ($courseId, $studentId, $homework, $labs, $project, $presentation, $midterm, $final, '$grade')";

	//print $sql . "\n";
	
	if (mysqli_query($conn, $sql)) {
		//print "Success";
return "abc";
	} else {
		print "Error inserting record: " . mysqli_error($conn);
	}
	
	mysqli_close($conn);
}

function update($courseId, $studentId, $homework, $labs, $project, $presentation, $midterm, $final, $grade){
	$conn = get_connection();
	
	$sql = "UPDATE `course_user` 
	SET `PCourseId`=$courseId,`PUserId`=$studentId,`Homework`=$homework,`Labs`=$labs,`Project`=$project,`Presentation`=$presentation,`Midterm`=$midterm,
	`Final`=$final,`Grade`='$grade' 
	WHERE PCourseId = $courseId AND PUserId=$studentId";

	//print $sql . "\n";
	
	if (mysqli_query($conn, $sql)) {
		//print "Record updated successfully";
	} else {
		//print "Error updating the record: " . mysqli_error($conn);
	}
	
	mysqli_close($conn);
}
?>