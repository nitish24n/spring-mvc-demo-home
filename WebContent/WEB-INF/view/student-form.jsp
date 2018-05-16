<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Student Registration Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student" >
	First Name : <form:input path="firstName" />
	<br><br>
	Last Name : <form:input path="lastName"/>
	<br><br>
	Country :
	<form:select path="country">
		<form:option value="India" label="India"/>
		<form:option value="Brazil" label="Brazil"/>
		<form:option value="United States" label="United States"/>
		<form:option value="Austrilia" label="Austrilia"/>
		<form:option value="Nepal" label="Nepal"/>
	</form:select>
	<input type="submit" value="Submit"/>
	
	
	</form:form>

</body>
</html>