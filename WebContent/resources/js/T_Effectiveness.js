function drawTeachingTechnique() {
	
        var data = google.visualization.arrayToDataTable(getEf);

        var options = {
          title: 'How Students Feel Their Instructors/TA Are Effective Per Week',
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('teacher_effect'));
        chart.draw(data, options);
      }
      