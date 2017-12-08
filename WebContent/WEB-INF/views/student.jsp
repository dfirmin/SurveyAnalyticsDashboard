<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dashboard</title>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link rel='stylesheet'
	href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
</head>
<body>


	<header id="header">
		<div class="container">
			<div class="row">
				<div class="col-md-10">
					<h1>
						<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
						Survey Analytics Dashboard <small>Grand Circus</small>
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
						<a href="dashboard" class="list-group-item main-color-bg">
							<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
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
				
				<div class="panel-heading">
				  <h3 class="panel-title">Students</h3>
				  </div>
				<div class="col-md-9 panel-body">
					<div>
						<table class="table-striped table-bordered table-hover">
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
	</section>



</body>
</html>