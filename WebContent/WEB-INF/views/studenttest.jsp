<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
		<a href="addperson">Add Person</a>
		 <tr>
        <th></th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Location</th>
        <th>Cohort</th>
    	</tr>
        
        <tbody>
        
           <c:forEach var="myVar" items="${list}">
				<tr>
					<td></td>
					<td>${myVar.firstName}</td>
					<td>${myVar.lastName}</td>
					<td>${myVar.email}</td>
					<td>${myVar.location}</td>
					<td>${myVar.cohortID}</td>
			
					<td><a href="deleteperson?id=${myVar.personID}"> Delete </a></td>
					<td><a href="addupdateperson?id=${myVar.personID}"> Update </a></td>


				</tr>

			</c:forEach>
        </tbody>
    </table>
</body>
</html>