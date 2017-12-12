<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="resources/js/watsontest.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var chartData = ${chartData};
console.log(chartData);
google.charts.load('current', {'packages':['bar']});
google.charts.setOnLoadCallback(watsonBarTest);
</script>
</head>
<body>
<div id="watsonTestChart"></div>
</body>
</html>