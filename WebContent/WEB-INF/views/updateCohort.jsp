<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Class</title>
</head>
<body>

<h1>Update Class</h1>
<br>
<form action="update" method="get">
		<input type="hidden" name="id" value="${ cohortID}">
		Course Name:
		 <input
			type="text" name="cohortName" required> <br> 
			Semester:
			 <input
			type="text" name="cohortSemester" required><br> 
		<br> <input type="submit" value="Update Class">

	</form>
</body>
</html>