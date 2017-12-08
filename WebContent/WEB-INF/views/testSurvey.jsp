<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${ results }

 <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>

<script>

var A = document.getElementById("cohorts");
var B = document.getElementById("students");

B.disabled = true;
var arr = ${persons};
B.disabled = true; 

function selectedDrop(sel) {
	var val=0;
	var val = sel.selectedIndex;
	var selArr = arr[val-1];
    var $secondChoice = $("#students");

	if(val == 0){
		B.disabled = true; 
		 $secondChoice.empty();
			
				$secondChoice.append("<option value='0'>Select an option from above</option>");
			

	}
	else{
		
		B.removeAttribute("disabled");
    $secondChoice.empty();
	for(var i in selArr) {
		var newArr = selArr[i].split(":");
		$secondChoice.append("<option value='"+newArr[0]+"'>" + newArr[1] + "</option>");
	}
	}
}



</script>
</body>
</html>
