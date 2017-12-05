<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.js" type="text/javascript">
</script>

</head>
<body>
<div  width="100px" height="100px">
	<canvas id="confovertime" width="100px" height="100px"></canvas>
	</div>
	<br/>
	<canvas id="jobs_applied" width="100px" height="100px"></canvas>
	<br/>
	<canvas id="interviews" width="100px" height="100px"></canvas>
	<canvas id="indepth_topics" width="400" height="400"></canvas>
	<canvas id="what_make_conf" width="400" height="400"></canvas>
	<canvas id="material_pace" width="400" height="400"></canvas>
	<canvas id="conducive_learning" width="400" height="400"></canvas>
	
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
</body>
	
	
</html>