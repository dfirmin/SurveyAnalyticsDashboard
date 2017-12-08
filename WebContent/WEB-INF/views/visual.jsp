<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="resources/js/confovertime.js"></script>
<script src="resources/js/jobs_applied.js"></script>
<script src="resources/js/indepth_topics.js"></script>
<script type="text/javascript">
	var getConf = ${getConf };
	var getJobsApp = ${getJobsApp };
	console.log(getConf);
	console.log(getJobsApp);
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(confOverTime);
	google.charts.setOnLoadCallback(jobs_applied);
	google.charts.setOnLoadCallback(indepth_topics);
</script>
</head>
<body>
	<div id="confovertime"></div>
	<div id="jobs_applied"></div>
	<div id="interviews"></div>
	<div id="indepth_topics"></div>
	<div id="what_make_conf"></div>
	<div id="material_pace"></div>
	<div id="conducive_learning"></div>
</body>	
</html>





<!--
<table border="1">
		<c:forEach var="myVar" items="${cList}">
			<tr>
				<td>${myVar.productID}</td>
				<td>${myVar.code}</td>
				<td>${myVar.description}</td>
				<td>${myVar.listPrice}</td>
				<td><a href="delete?id=${myVar.productID}"> Delete </a></td>
				<td><a href="update?id=${myVar.productID}"> Update </a></td>

			</tr>

		</c:forEach>

	</table>

	<script type="text/javascript">

//ArrayList<answer>
//answer object has answerid, student response, questions

	var AnswerList[];
	AnswerList[
		<c:forEach var="myVar" items="${list}">
			
		</c:forEach>
	]
	var list[] = ${list };
	var answerid = "";
	var answerresponse = "";
	var hello = "hello";	
	
	
  -->