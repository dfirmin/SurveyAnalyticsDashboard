<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
    href="https://fonts.googleapis.com/css?family=Barlow+Condensed:400,500|Roboto:400,700"
    rel="stylesheet">
<link rel='stylesheet'
    href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
<link href="resources/css/style.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script>
  $(document).ready(function() {
    $("#datepicker").datepicker();
  });
  </script>
  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Cohort</title>
</head>
<body>

<h1>Update Cohort</h1>
<br>
<form action="update" method="get">
		<input type="hidden" name="id" value="${cohortID}"> <br>
		Course Name: 
		<br>
		 <input
			type="text" name="cohortName" value="${cohortName}" required> <br> 
			Semester: <br>
			 <input
			type="text" name="cohortSemester" required><br> 
		Start Date:<br>
		<input id="datepicker" type="text" name="startDate" required><br>
		<br><br>
		<input type="submit" value="Update Class">

	</form>
	
	<form action="addSection" method="get">
	Semester: <br>
			 <input
			type="text" name="cohortSemester" required><br> 
		Start Date:<br>
		<input id="datepicker" type="text" name="startDate" required><br>
		<br><br>
	<input type="submit" value="Add New Section">
	</form>
	
							<table class="table-striped table-bordered table-hover" cellspacing="10">
						<tr>
								<th>Class</th>
								<th>Semester</th>
								<th>Start Date</th>
							</tr>
							<c:forEach var="myVar" items="${cohortList}" varStatus="status">
								<tr>
							
									<td>${myVar.cohortName}</td>
									<td>${myVar.cohortSemester}</td>
									<td>${myVar.startDate}</td>
									<td><a href="delete?id=${myVar.cohortID}"> Delete </a></td>
								</tr>
							</c:forEach>
			
						</table>
	
</body>
</html>