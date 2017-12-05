<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to our Survey</title>
</head>
<body>
<form>
<input type="text" name="Name" value="Name" placeholder="Name" required><br> <br>
<label>Select your Bootcamp</label> <br> <br>
<select name="Cohorts">
<option value="Java">Java</option>
<option value=".NET">.NET</option>
<option value="FrontEnd">Front End</option>
<option value="Unity 3D">Unity 3D</option>
</select>
<input type="submit" value="submit"><br>

<fieldset id="feelings">
<label>This week I am feeling...</label><br>
<input type="radio" value="Great! Excited for the rest of the bootcamp." name="feelings"> Great! Excited for the rest of the bootcamp. <br>
<input type="radio" value="A little confused, but confident I will get it soon." name="feelings"> A little confused, but confident I will get soon. <br>
<input type="radio" value="Totally confused." name="feelings"> Totally confused. <br>
<input type="radio" value="Other" name="feelings">Other <br>
<input type="text" value="" name="feelings"><br>
</fieldset>
<label>On a scale of 1-10, how confident do you feel about your understanding of the matrial?</label><br>
<input type="range" min="1" max="10" value="5"> <br>
<label>What topic would you like to spend more time on?</label> <br>
<input type="text" value="" name="topic"> <br>
</form>
</body>
</html>