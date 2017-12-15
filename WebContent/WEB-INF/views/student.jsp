<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dashboard</title>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">

<link
	href="https://fonts.googleapis.com/css?family=Barlow+Condensed:400,500|Roboto:400,700"
	rel="stylesheet">
<link rel='stylesheet'
	href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
<link href="resources/css/style.css" type="text/css" rel="stylesheet">

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script src="resources/js/confovertime.js"></script>
<script src="resources/js/jobs_applied.js"></script>
<script src="resources/js/indepth_topics.js"></script>
<script src="resources/js/watsontest.js"></script>


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
						<a href="dashboard" class=" main-color-bg menu-item"> <span
							class="glyphicon glyphicon-cog" aria-hidden="true"></span>
							Dashboard
						</a> <a href="survey" class="menu-item"><span
							class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>
							Surveys <span class="badge"></span></a> <a href="cohort"
							class=" menu-item "><span class="glyphicon glyphicon-pencil"
							aria-hidden="true"></span> Cohorts <span class="badge"></span></a> <a
							href="student" class=" menu-item"><span
							class="glyphicon glyphicon-user" aria-hidden="true"></span>
							Students <span class="badge"></span></a>
					</div>


				</div>
				<div class="col-md-10 content">

					<!-- <section id="breadcrumb">
						<div class="container ">
							<ol class="breadcrumb">
								<li class="">Dashboard</li>
							</ol>
						</div>
					</section>
 -->

					<div class="row">
						<div class="main-pane">
							<div class="inner-div">
								<h1 class="pageTitle">Students</h1>
							</div>
							


							<div class="panel-heading"></div>
							<div class="col-md-9 panel-body">
								<div>
								<div class="dropdown pull-right">
								<form action="result" method="post">
									<select id="cohortSelect" name="cohort" style = "display:inline-block">
										<option value="All">All</option>
										<c:forEach var="cohort" items="${listcohorts}"><option value="${cohort}">${cohort}</option></c:forEach>
			<input type="submit" style = "display:inline-block" value="Search">
									</select> 
								</form>

							</div>
									<table class="table-striped table-bordered table-hover">
										<a href="addperson">Add Person</a>
										<tr>
											<th></th>
											<th>First Name</th>
											<th>Last Name</th>
											<th>Email</th>
											<th>Location</th>
											<th>Cohort</th>
											<th>Update</th>
											<th>Delete</th>
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

													<td><a href="deleteperson?id=${myVar.personID}">
															Delete </a></td>
													<td><a href="addupdateperson?id=${myVar.personID}">
															Update </a></td>


												</tr>

											</c:forEach>
										</tbody>
									</table>
								</div>


							</div>
						</div>
					</div>


				</div>
			</div>
		</div>
	</section>

</body>

	
