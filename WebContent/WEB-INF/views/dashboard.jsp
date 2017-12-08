<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dashboard</title>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link rel='stylesheet'
	href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
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


	<header id="header">
		<div class="container">
			<div class="row">
				<div class="col-md-10">
					<h1>
						<img src="resources/sad_logo.png" height="80" width="90"><small>Grand Circus</small>
					</h1>
				</div>
			</div>
		</div>
	</header>

	<section id="breadcrumb">
		<div class="container">
			<ol class="breadcrumb">
				<li class="">Dashboard</li>
			</ol>
		</div>
	</section>

	<section id="main">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<div class="list-group">
						<a href="dashboard" class="list-group-item main-color-bg"> <span
							class="glyphicon glyphicon-cog" aria-hidden="true"></span>
							Dashboard
						</a> <a href="survey" class="list-group-item"><span
							class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>
							Surveys <span class="badge"></span></a> <a href="cohort"
							class="list-group-item"><span
							class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							Cohorts <span class="badge"></span></a> <a href="student"
							class="list-group-item"><span
							class="glyphicon glyphicon-user" aria-hidden="true"></span>
							Students <span class="badge"></span></a>
					</div>


				</div>
				<div class="col-md-9">
					<!-- Chart section -->
					<div id="jobs_applied"></div>
					<div id="confovertime"></div>




				</div>
			</div>
		</div>
	</section>

	<!--<div id="interviews"></div>
	<div id="indepth_topics"></div>
	<div id="what_make_conf"></div>
	<div id="material_pace"></div>
	<div id="conducive_learning"></div>-->


	<script type="text/javascript"
		src="https://www.gstatic.com/charts/loader.js"></script>
	<script src="resources/js/confovertime.js"></script>
	<script src="resources/js/jobs_applied.js"></script>
	<script src="resources/js/indepth_topics.js"></script>
	<script type="text/javascript">
 
</body>
</html>