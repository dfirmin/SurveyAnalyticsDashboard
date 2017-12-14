function drawMatPace() {
	
        var data = google.visualization.arrayToDataTable(
        		getMatPace
        );

        var options = {
          title: 'How Students Feel About Pace Of Material Per Week',
          hAxis: {title: 'Week',  titleTextStyle: {color: '#333'}},
          vAxis: {minValue: 0},
          is3D: true,
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('material_pace'));
        chart.draw(data, options);
      }