<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link href="resources/css/style.css" type="text/css" rel="stylesheet">
    
</head>
<body>
<%@ include file="homeHeader.jsp" %>  

${ alert }

  <div class="outerwrapper">
    <form class="formsignin" action="login" method="post">       
      <h2 class="form-signin-heading">Please login</h2>
      <input type="text" class="form-control" name="email" style="margin-top:3%;" placeholder="Email Address" required autofocus/>
      <input type="password" class="form-control" name="password" style="margin-top:3%;"placeholder="Password" required/>      
     
      <button class="btn btn-lg btn-primary btn-block" style="margin-top:10%;" type="submit">Login</button>   
    </form>
  </div>

	
	
 <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>