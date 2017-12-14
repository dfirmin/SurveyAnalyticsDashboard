function whatMakeConf() {
    var data = new google.visualization.arrayToDataTable(getWhatConf);

    var options = {
      title: 'What Would Probably Make Students More Confident',
      legend: { position: 'none' },
      bars: 'vertical', 
      bar: { groupWidth: "90%" }
    };

    var chart = new google.charts.Bar(document.getElementById('what_make_conf'));
    chart.draw(data, options);
  };