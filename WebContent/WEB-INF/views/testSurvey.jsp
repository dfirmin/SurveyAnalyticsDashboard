<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link href="resources/css/style.css" type="text/css" rel="stylesheet">
          <title>GC Weekly Survey</title>
        </head>
        <body>
          <div class ="outerDiv">
          	<div class="row" >
			<div class="col-md-2"></div>
  			<div id="page" class="col-md-8">
  			<div class="row" >
  				<div class="col-md-1"></div>
  				<div class="col-md-10">  ${ survey }</div>
				<div class="col-md-1"></div>
				</div>
  			</div>
  			<div class="col-md-2"></div>
			</div>
        </div>
          <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
          <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>

          <script>

            var A = document.getElementById("cohorts");
            var B = document.getElementById("students");

            B.disabled = true;
            var n = 1;
            var arr = ${persons};
            B.disabled = true;


                function customRadio(sel) {
                  var val = 0;
                  var val = sel.selectedIndex;
                  console.log(sel.name);
                  console.log(sel.value);
                  var textbox = document.getElementById(sel.name);

                  textbox.addEventListener("change", changeRadioValue);
                  textbox.removeAttribute("disabled");

                }

                function changeRadioValue(){
                  console.log(this.value);
                  var rb = document.getElementById('rb'+this.id);
                  rb.value = this.value;
                }

                function selectedDrop(sel) {
                  var val = 0;
                  var val = sel.selectedIndex;
                  var selArr = arr[val - 1];
                  var $secondChoice = $("#students");

                  if (val == 0) {
                    B.disabled = true;
                    $secondChoice.empty();
                    $secondChoice.append("<option value='0'>Select an option from above</option>");

                  } else {

                    B.removeAttribute("disabled");
                    $secondChoice.empty();
                    for (var i in selArr) {
                      var newArr = selArr[i].split(":");
                      $secondChoice.append("<option value='" + newArr[0] + "'>" + newArr[1] + "</option>");
                    }
                  }
                }
          </script>
        </body>
      </html>
