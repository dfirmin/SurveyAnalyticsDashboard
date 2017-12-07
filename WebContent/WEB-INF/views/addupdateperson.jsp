<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

${addPersonTitle}
${updatePersonTitle}
${addPersonAction}
${updatePersonAction}
<input type="hidden" name="id" value="${personID}">
    First Name: <input type="text" name="firstname" required> <br>
    Last Name: <input type="text" name="lastname" required> <br>
    <!--  these additional attributes for min and step allow us to take in a double variable -->
    Email: <input type="text" min="1" step="any" name="email"> <br>
    Location: <input type="text" min="1" step="any" name="location"> <br>
    Cohort ID: <input type="number" min="1" step="any" name="cohortid"> <br>
    ${addPersonButton}${updatePersonButton}

</form>

</body>
</html>