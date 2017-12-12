function drawInstrEmo() {
        var data = google.visualization.arrayToDataTable(
        	getIE
        );

        var options = {
          chart: {
            title: 'Count How Each Student Feel About Teacher'
          },
          bars: 'horizontal' // Required for Material Bar Charts.
        };

        var chart = new google.charts.Bar(document.getElementById('instruEmotions'));

        chart.draw(data, google.charts.Bar.convertOptions(options));
      }