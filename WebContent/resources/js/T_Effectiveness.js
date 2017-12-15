function drawTeachingTechnique() {
	
        var data = google.visualization.arrayToDataTable(getEf);

        var options = {
          title: 'How Students Feel Their Instructors/TA Are Effective Per Week',
          curveType: 'function',
          legend: { position: 'bottom' },
          vAxis: {title: "Effective",direction:-1, slantedText:true, slantedTextAngle:90},
          hAxis: {title: "Week" , direction:-1, slantedText:true, slantedTextAngle:60 }
        };

        var chart = new google.visualization.LineChart(document.getElementById('teacher_effect'));
        chart.draw(data, options);
      }
      