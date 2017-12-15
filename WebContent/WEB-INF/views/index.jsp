<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link href="resources/css/style.css" type="text/css" rel="stylesheet">
    
<title>Home</title>
</head>
<body>
<div class="scrollable">
<%@ include file="homeHeader.jsp" %>  
    <main role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron" style="padding: 10%;background-image: url(https://www.grandcircus.co/wp-content/uploads/2017/10/GC_facecollage2_bw.jpg); background-color: #1ea8b4; background-blend-mode: multiply;" >
        <div class="container main-container" style = "color: white; font-family:brandon, Arial Black, Helvetica, sans-serif">       
          <h1 class="display-3">We are SAD: Survey Analytics Dashboard<h1>
          <p>You won't know glad, till you try SAD.</p>
          
        </div>
      </div>

      <div class="container">
        <!-- Example row of columns -->
        <div class="row">
          <div class="col-md-4">
            <h2>Send Surveys</h2>
            <p>Send custom surveys to any combination of students and cohorts. Make your data unique and get user feedback with our dynamic survey forms. The sky is the limit and your imagination is the ticket to meaningful data.</p>
          </div>
          <div class="col-md-4">
            <h2>Visualizations</h2>
            <p>Track trends across your userbase with stunning visuals detailing just about every variation in your surveys. Charts can range from line charts, and bar graphs, to even data filtered by IBM Watson's Emotion Analysis API.  </p>
          </div>
          <div class="col-md-4">
            <h2>Manage Users</h2>
            <p>With our robust Cohort and User database, the ability to add and edit users and cohorts is as simple as a click of a button. Make changes that make a difference and make your life easier.</p>
          </div>
        </div>

        <hr>

      </div> <!-- /container -->

    </main>

    <footer class="container">
      <p>© SAD Company 2017</p>
    </footer>
</div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
 <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  
</body>
</html>