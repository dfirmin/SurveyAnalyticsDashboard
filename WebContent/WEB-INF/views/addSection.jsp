<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
a:link {
	color: blue;
	text-decoration: none;
}

a:visited {
	color: gray;
	text-decoration: none;
}

a:hover {
	color: green;
	text-decoration: none;
}

table {
	border: 1px solid black;
	width: 100%;
	text-align: center;
	margin: 0 auto;
}

th {
	color: black;
	text-align: center;
}
</style>
<link
	href="https://fonts.googleapis.com/css?family=Barlow+Condensed:400,500|Roboto:400,700"
	rel="stylesheet">
<link rel='stylesheet'
	href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
<link href="resources/css/style.css" type="text/css" rel="stylesheet">
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script>
	$(document).ready(function() {
		$("#datepicker").datepicker();
	});
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Section</title>
</head>
<body>

	<h1>Add Section</h1>
	<form action="addNewSection" method="get">
		<input type="hidden" name="id" value="${cohortID}"> <br>
		Course Name: <br> <input type="text" name="cohortName"
			value="${cohortName}" required><br> Semester: <br>

		<input type="text" name="cohortSemester" required><br>
		Start Date:<br> <input id="datepicker" type="text"
			name="startDate" required><br> <br> <input
			type="submit" value="Add Semester">

	</form>
	<br>
	<br>
	<a href="cohort">Cohort</a>

</body>
</html>