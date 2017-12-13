/*	 
google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
*/
      function jobs_applied() {

    	  	var data = google.visualization.arrayToDataTable(
    	  		getJobsApp
    	  		/*
    	  		[
              ['Number of Jobs Applied', 'Count'],
              ['0-5',     11],
              ['5-10',      2],
              ['10-20',  2],
              ['Watch TV', 2],
              ['Sleep',    7]
            ]
            
            */);

        var options = {
              title: 'Number of Jobs Applied',
              is3D: true
            };

        var chart = new google.visualization.PieChart(document.getElementById('jobs_applied'));

        chart.draw(data, options);
      }