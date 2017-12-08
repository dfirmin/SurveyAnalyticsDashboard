	/*
      // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);
	*/
      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function confOverTime() {
        // Create the data table.
        var data = new google.visualization.arrayToDataTable(
        		getConf
        	/*
        [	
        		['Week', 'Java', '.NET', 'Front End'],
            ['1', 1000, 400, 200],
            ['2', 1170, 460, 250],
            ['3', 660, 1120, 300],
            ['4', 1030, 540, 350]
        ]
        */);

        // Set chart options
        var options = {
        					title:"Average Students' Confidence Over Time",
                       	//width:600,
        					isStacked: 'percent'
        				};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.ColumnChart(document.getElementById('confovertime'));
        chart.draw(data, options);
      }