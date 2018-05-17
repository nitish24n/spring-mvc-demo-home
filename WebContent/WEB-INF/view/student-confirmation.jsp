<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Student Confirmation</title>
</head>
<body>

<h2>the student is confirmed : ${student.firstName} ${student.lastName}</h2>
<br><br>
Country : ${student.country}
<br><br>
My favorite language is : ${student.favoriteLanguage}
<br><br>
<ul>
	<c:forEach var="temp" items="${student.operatingSystems}">
		<li> ${temp} </li>
	</c:forEach>
</ul>
</body>
</html>