<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script>
  $(document).ready(function() {
    $("#datepicker").datepicker();
  });

  
  </script>
  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Class</title>
</head>
<body>

<form action="add" method="get">
Course Name: <input type="text" name="cohortName" required> <br> <br>
Semester:  <input type="text" name="cohortSemester" required> <br> <br>
Start Date: <input id="datepicker" type="text" name="startDate" required> <br> <br>
<br>
<input type="submit" value="Add Cohort">
</form>

</body>
</html>