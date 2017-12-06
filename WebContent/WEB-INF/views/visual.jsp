<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<style src="resources/css/bootstrap.css"></style>
<script type="text/javascript">

      // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create the data table.
        var data = new google.visualization.arrayToDataTable([
        	['Week', 'Java', '.NET', 'Front End'],
            ['1', 1000, 400, 200],
            ['2', 1170, 460, 250],
            ['3', 660, 1120, 300],
            ['4', 1030, 540, 350]
        ]);

        // Set chart options
        var options = {'title':"Average Students' Confidence Over Time",
                       'width':500,
                       'height':400,
                       'vAxis': {format: 'percent'}};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.ColumnChart(document.getElementById('confovertime'));
        chart.draw(data, options);
      }
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