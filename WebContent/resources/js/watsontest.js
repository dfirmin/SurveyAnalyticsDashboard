function watsonBarTest() {
	var data = google.visualization.arrayToDataTable(chartData);

	var options = {
		title : 'Watson Emotion Chart',
		//width : 900,
		legend : {
			position : 'none'
		},
		chart : {
			title : 'Bootcamp Emotions',
			subtitle : ''
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
		}
	};
	
	

	var chart = new google.charts.Bar(document
			.getElementById('watsonTestChart'));
	chart.draw(data, options);
};

