function drawInstrEmo() {
        var data = google.visualization.arrayToDataTable(
        	getIE
        );

        var options = {
          chart: {
            title: 'Count How Each Student Feel About Teacher'
          },
          bars: 'horizontal',
          isStacked: true
        };

        var chart = new google.charts.Bar(document.getElementById('instruEmotions'));

        chart.draw(data, google.charts.Bar.convertOptions(options));
      }