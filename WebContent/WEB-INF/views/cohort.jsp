<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Classes</title>
</head>
<body>
<h1>Classes</h1>
<a href="addCohort">Add Cohort</a>
	<table border="1">
		<c:forEach var="myVar" items="${cohortID}">
			<tr>
				<td>${myVar.cohortID}</td>
				<td>${myVar.cohortName}</td>
				<td>${myVar.cohortSemester}</td>
				<td><a href="delete?id=${myVar.cohortID}"> Delete </a></td>
				<td><a href="updatecohortform?id=${myVar.cohortID}"> Update </a></td>

			</tr>

		</c:forEach>

	</table>
	
</body>
</html>