function watsonBarTest() {
	var data = google.visualization.arrayToDataTable(chartData);

	var options = {
		title : 'Watson Emotion Chart',
		//width : 900,
		legend : {
			position : 'none'
		},
		bars : 'vertical', // Required for Material Bar Charts.
		axes : {
			x : {
				0 : {
					side : 'bottom',
					label : ''
				}
			// Top x-axis.
			}
		},
		bar : {
			groupWidth : "90%"
		},
		hAxis: {title: "Techniques" , direction:-1, slantedText:true}
	};
	
	

	var chart = new google.charts.Bar(document
			.getElementById('watsonTestChart'));
	chart.draw(data, options);
};

