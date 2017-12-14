/*	 
google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
*/
      function jobs_applied() {

    	  	var data = google.visualization.arrayToDataTable(getJobsApp)

        var options = {
              title: 'Number of Jobs Applied',
              legend: { position: 'bottom' },
              width: 600,
              height: 600
            };

        var chart = new google.visualization.PieChart(document.getElementById('jobs_applied'));

        chart.draw(data, options);
      }