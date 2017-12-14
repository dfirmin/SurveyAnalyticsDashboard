function howConfident() {
	
        var data = google.visualization.arrayToDataTable(
        		getHowConf
        );

        var options = {
          title: 'How Confident Students Feel Per Week',
          hAxis: {title: 'Week',  titleTextStyle: {color: '#333'}},
          vAxis: {minValue: 0},
          is3D: true,
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('howConfID'));
        chart.draw(data, options);
      }
      