function drawTeachingTechnique() {
    var data = new google.visualization.arrayToDataTable(getTT);

    var options = {
      title: 'Key Teaching Techniques',
      legend: { position: 'none' },
      bars: 'horizontal', 
      bar: { groupWidth: "90%" },
      hAxis: {title: "Techniques" , direction:-1, slantedText:true}
    };

    var chart = new google.charts.Bar(document.getElementById('tt'));
    chart.draw(data, options);
  };