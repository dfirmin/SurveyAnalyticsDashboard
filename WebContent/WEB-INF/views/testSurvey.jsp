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

<script>

var A = document.getElementById("cohorts");
var B = document.getElementById("students");

A.onchange = function() {
    //clear out B
    B.length = 0;
	B.disabled = false;
    var _val = this.options[this.selectedIndex].value;

    var arr = ${persons};

    for (var i in arr[_val]) {
    	var newArr = arr[_val][i].split(":");
    	console.log(arr[_val][i]);
      //create option tag
      var op = document.createElement('option');
      //set its value
      op.value = newArr[0];
      //set the display label
      op.text = newArr[1];
      //append it to B
      B.appendChild(op);
    }
  };
  //fire this to update B on load
  A.onchange();
</script>
</body>
</html>
