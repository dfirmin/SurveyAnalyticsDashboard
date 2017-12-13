function howConfident() {
	
        var data = google.visualization.arrayToDataTable(
        		getHowConf
        	/*
        [
          ['Year', 'Sales', 'Expenses'],
          ['2013',  1000,      400],
          ['2014',  1170,      460],
          ['2015',  660,       1120],
          ['2016',  1030,      540]
        ]
        */
        );

        var options = {
          title: 'Company Performance',
          hAxis: {title: 'Week',  titleTextStyle: {color: '#333'}},
          vAxis: {minValue: 0}
        };

        var chart = new google.visualization.LineChart(document.getElementById('howConfID'));
        chart.draw(data, options);
      }

	/*
        var data = new google.visualization.DataTable();
        		data.addColumn('number', 'Week');
        		data.addColumn('number', 'Confidence Count');
        		data.addColumn('number', 'Cohort');
        		
        		data.addRows(
        				getHowConf
        		);
        var materialOptions = {
          chart: {
            title: 'How Confident Students\' Feel Overtime'
          },
          width: 800,
          height: 500,
          series: {
            0: {axis: 'count'},
            1: {axis: 'cohort'}
          },
          axes: {
            y: {
              'count': {label: 'Confidence Count'},
              'cohort': {label: 'Cohort'}
            }
          }
        };
        		
        var drawChart = new google.charts.Scatter(document.getElementById('howConfID'));
        drawChart.draw(data, google.charts.Scatter.convertOptions(materialOptions));	
	*/
      