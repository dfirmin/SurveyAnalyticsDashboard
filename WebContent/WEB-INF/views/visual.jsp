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
	<div id="chart_div"></div>
	<canvas id="confovertime"></canvas>
	<br/>
	<canvas id="jobs_applied" width="100px" height="100px"></canvas>
	<br/>
	<div style="height: 500px; width: 500px;">
		<canvas id="interviews"></canvas>
	</div>
	<canvas id="indepth_topics" width="400" height="400"></canvas>
	<canvas id="what_make_conf" width="400" height="400"></canvas>
	<canvas id="material_pace" width="400" height="400"></canvas>
	<canvas id="conducive_learning" width="400" height="400"></canvas>
</body>	
</html>




<!-- 
	<script>
	console.log("at least this works");
	var ctx = document.getElementById("confovertime").getContext('2d');
	var myChart = new Chart(ctx, {
	    type: 'bar',
	    data: {
	        labels: ["Week 1", "Week 2", "Week 3", "Week 4", "Week 5", "Week 6"],
	        datasets: 
	        		[
	        				{
				        		label: ".NET",
				            data: [12, 19, 3, 5, 2, 3],
				            backgroundColor: [
				            		'blue',
				            		'blue',
				            		'blue',
				            		'blue',
				            		'blue',
				            		'blue'
				            ],
				            borderColor: [
				        			'blue',
				        			'blue',
				        			'blue',
				        			'blue',
				        			'blue',
				        			'blue'
				            ],
				            borderWidth: 1
		        			}
	        				,
	        				{
		        		    		label: "Java",
		        		        data: [12, 19, 3, 5, 2, 3],
		        		        backgroundColor: [
		        		        		'yellow',
		        		        		'yellow',
		        		        		'yellow',
		        		        		'yellow',
		        		        		'yellow',
		        		        		'yellow'
		        		        ],
		        		        borderColor: [
		        			        	'yellow',
		        			        	'yellow',
		        			        	'yellow',
		        			        	'yellow',
		        			        	'yellow',
		        			        	'yellow'
		        		        ],
		        		        borderWidth: 1
		        		    }
	        				,
	        				{
		        		    		label: "Front End",
		        		        data: [12, 19, 3, 5, 2, 3],
		        		        backgroundColor: [
		        		        		'pink',
		        		        		'pink',
		        		        		'pink',
		        		        		'pink',
		        		        		'pink',
		        		        		'pink',
		        		        ],
		        		        borderColor: [
		        		        	'pink',
		        		        	'pink',
		        		        	'pink',
		        		        	'pink',
		        		        	'pink',
		        		        	'pink',
		        		        ],
		        		        borderWidth: 1
		        		    }
	        		]
		},
	    options: {
	        scales: {
	            yAxes: [{
	                ticks: {
	                    beginAtZero:true
	                }
	            }]
	        }
	    }
	});
	
	
	
	var ctx2 = document.getElementById("interviews").getContext('2d');
	var myPieChart = new Chart(ctx2,{
	    type: 'pie',
	    data: {
			    datasets: [{
			        data: [10, 20, 30]
			    }],
			    labels: [
			        'Red',
			        'Yellow',
			        'Blue'
			    ]
			},
	    options: {
		    	scales: {
		            yAxes: [{
		                ticks: {
		                    beginAtZero:true
		                }
		            }]
		        }
	    }
	});
	</script>
	
	-->