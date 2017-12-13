<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile Page</title>
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
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="profilepage"
						id="navbarDropdownMenuLink" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">${ profileName }<span
							class="caret"></span></a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="logout">Log Out</a>

						</div></li>
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
					<div class="row">
						<div class="main-pane">
							<div class="inner-div">
								${ profile }
							</div>
						</div>
					</div>


				</div>
			</div>
		</div>
	</section>

</body>

</html>