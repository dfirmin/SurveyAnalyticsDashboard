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
<script src="resources/js/howConfident.js"></script>
<script src="resources/js/instructor.js"></script>
<script src="resources/js/what_make_conf.js"></script>
<script src="resources/js/material_pace.js"></script>
<script src="resources/js/teaching_technique.js"></script>
<script src="resources/js/T_Effectiveness.js"></script>
<script type="text/javascript">

	var getConf = ${getConf };
	var getJobsApp = ${getJobsApp };
	var getHowConf = ${getHowConf};
	var getIE = ${Instructor_el};
	var getWhatConf = ${WhatConf};
	var getMatPace = ${matPace};
	var getTT = ${TT_el};
	var getEf = ${E_el};
	
	console.log(getConf);
	console.log(getJobsApp);
	console.log(getHowConf);
	console.log(getIE);
	console.log(getWhatConf);
	console.log(getMatPace);
	console.log(getTT);
	console.log(getEf);
	
	google.charts.load('current', {'packages':['bar']});
	google.charts.load('current', {'packages':['corechart']});
	//google.charts.load('current', {'packages':['corechart', 'scatter']});
	google.charts.setOnLoadCallback(confOverTime);
	google.charts.setOnLoadCallback(jobs_applied);
	google.charts.setOnLoadCallback(howConfident);
	google.charts.setOnLoadCallback(drawInstrEmo);
	google.charts.setOnLoadCallback(whatMakeConf);
	google.charts.setOnLoadCallback(drawMatPace);
	google.charts.setOnLoadCallback(drawTeachingTechnique);
</script>
</head>
<body>
	<div id="confovertime"></div>
	</br>
	</br>
	</br>
	<div id="jobs_applied"></div>
	</br>
	</br>
	</br>
	<div id="interviews"></div>
	</br>
	</br>
	</br>
	<div id="howConfID"></div>
	</br>
	</br>
	</br>
	<div id="instruEmotions"></div>
	</br>
	</br>
	</br>
	<div id="what_make_conf"></div>
	</br>
	</br>
	</br>
	<div id="material_pace"></div>
	</br>
	</br>
	</br>
	<div id="tt"></div>
	</br>
	</br>
	</br>
	<div id="teacher_effect"></div>
	</br>
	</br>
	</br>
	
	<div id="conducive_learning"></div>
</body>	
</html>