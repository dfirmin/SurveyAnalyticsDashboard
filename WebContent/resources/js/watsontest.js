function watsonBarTest() {
	var data = google.visualization.arrayToDataTable(chartData);

	var options = {
		title : 'Watson Test',
		width : 700,
		legend : {
			position : 'none'
		},
		chart : {
			title : 'Watson Test',
			subtitle : 'popularity by percentage'
		},
		hAxis : {
			viewWindowMode: 'explicit',
			viewWindow : {
				min : 0,
				max : 100
			}
		},
		bars : 'horizontal', // Required for Material Bar Charts.
		axes : {
			x : {
				0 : {
					side : 'top',
					label : 'Percentage of Students'
				}
			// Top x-axis.
			}
		},
		bar : {
			groupWidth : "50%"
		}
	};

	var chart = new google.charts.Bar(document
			.getElementById('watsonTestChart'));
	chart.draw(data, options);
};

