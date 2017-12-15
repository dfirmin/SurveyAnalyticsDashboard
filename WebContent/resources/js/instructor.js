function drawInstrEmo() {
        var data = google.visualization.arrayToDataTable(
        	getIE
        );

        var options = {
           title: "Count How Each Student Feel About Teacher",
          bars: 'vertical',
          isStacked: true,
          legend: { position: "bottom" }
          
        };

        var chart = new google.visualization.BarChart(document.getElementById('instruEmotions'));

        chart.draw(data, options);
      }