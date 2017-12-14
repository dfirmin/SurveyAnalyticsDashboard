<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	border: 1px solid black;
	width: 100%;
	text-align: center;
}

th {
	color: black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Survey Modification</title>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link
	href="https://fonts.googleapis.com/css?family=Barlow+Condensed:400,500|Roboto:400,700"
	rel="stylesheet">
<link rel='stylesheet'
	href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
<link href="resources/css/style.css" type="text/css" rel="stylesheet">

</head>
<body>
	<nav class="top navbar navbar-expand-lg navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"><img
					style="height: 50px; width: 88px" src="resources/sad_logo.png">
					<h1 class="logoHeader">SURVEY ANALYTICS DASHBOARD</h1> </a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul
					class="nav navbar-nav navbar-right mr-sm                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ">
					<li class="nav-item"><a href="loginPage">Profile</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid -->
	</nav>

	<section id="main">
		<div class="container container-db">
			<div class="row">
				<div class="col-md-2 sideMenu left">
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
				<div class="col-md-10">

					<div>
						<table class="table-striped table-bordered table-hover">
							<a href="#">Add Question</a>
							<tr>
								<th></th>
								<th>SurveyQA ID</th>
								<th>Question ID</th>
								<th>Question Text</th>
								<th>Question Type</th>
								<th>Offered Answer ID</th>
								<th>Answer Text</th>
								<th>isCustom?</th>
							</tr>

							<tbody>

								<c:forEach var="myVar" items="${surveyQuestions}">
									<tr>
										<td></td>
										<td>${myVar.surveyQAID}</td>
										<td>${myVar.questionID}</td>
										<td>${myVar.questionText}</td>
										<td>${myVar.questionType}</td>
										<td>${myVar.offeredAnswerID}</td>
										<td>${myVar.answerText}</td>
										<td>${myVar.isCustom}</td>

										<td><a href="deleteperson?id=${myVar.surveyQAID}">
												Delete </a></td>
										<td><a href="addupdateperson?id=${myVar.surveyQAID}">
												Update </a></td>


									</tr>

								</c:forEach>
							</tbody>
						</table>
					</div>


				</div>
			</div>
		</div>
	</section>

</body>

</html>






















