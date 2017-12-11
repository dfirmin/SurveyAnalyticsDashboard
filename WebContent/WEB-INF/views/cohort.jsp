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
<title>Classes</title>
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
<script type="text/javascript">
    var getConf = ${getConf};
    var getJobsApp = ${getJobsApp};
    console.log(getConf);
    console.log(getJobsApp);
    google.charts.load('current', {
        'packages' : [ 'corechart' ]
    });
    google.charts.setOnLoadCallback(confOverTime);
    google.charts.setOnLoadCallback(jobs_applied);
    google.charts.setOnLoadCallback(indepth_topics);
</script>
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
						<a href="addCohort">Add Cohort</a> <br> <br> <br>
						<table class="table-striped table-bordered table-hover" cellspacing="10">
						<tr>
								<th style="text-align: center">Class</th>
								<th style="text-align: center">Semester</th>
								<th style="text-align: center">Start Date</th>
							</tr>
							<c:forEach var="myVar" items="${cohortID}" varStatus="status">
								<tr>
									<!-- <td>${status.count}</td> -->
									<!-- <td>${myVar.cohortID}</td> -->
									<td>${myVar.cohortName}</td>
									<td>${myVar.cohortSemester}</td>
									<td>${myVar.startDate}</td>
									<td><a href="delete?id=${myVar.cohortID}"> Delete </a></td>
									<td><a href="updatecohortform?id=${myVar.cohortID}">
											Update </a></td>
								</tr>
							</c:forEach>
			
						</table>
					</div>


				</div>
			</div>
		</div>
	</section>
 
    <script type="text/javascript"
        src="https://www.gstatic.com/charts/loader.js"></script>
    <script src="resources/js/confovertime.js"></script>
    <script src="resources/js/jobs_applied.js"></script>
    <script src="resources/js/indepth_topics.js"></script>
    
        </body>
        
        </html>