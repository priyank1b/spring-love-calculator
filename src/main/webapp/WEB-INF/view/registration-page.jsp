<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<style type="text/css">
.error{
color: red;
position: fixed;
text-align: left;
margin-left: 30px;
}
</style>
</head>
<body>
	<h1 align="center">Please Register by filling the below details</h1>

	<form:form action="registeredUserDeatils" method="GET" modelAttribute="registerUser">
	
		<div align="center">
			<label>User : </label>
			<form:input path="user" />
			<form:errors path="user" cssClass="error"/>
			
			<br /> <label>User Name : </label>
			<form:input path="userName" />
			<form:errors path="userName" cssClass="error"/>
			
			<br /> <label>Password :</label>
			<form:password path="pass" />
			
			<br /> <label>Country : </label>
			<form:select path="country">
				<form:option value="IND">India</form:option>
				<form:option value="USA">United States</form:option>
				<form:option value="SI">Sri Lanka</form:option>
				<form:option value="DUB">Dubai</form:option>
				<form:option value="NK">New York</form:option>
			</form:select>
			
			<br /> <label>Hobbies : </label> Cricket :
			<form:checkbox path="hobbies" value="cricket" />
			Reading :
			<form:checkbox path="hobbies" value="reading" />
			Traveling :
			<form:checkbox path="hobbies" value="traveling" />
			Programming :
			<form:checkbox path="hobbies" value="programming" />
			
			<br/>
			<label>Age : </label>
			<form:input path="age"/>
			<form:errors path="age" cssClass="error"/>
			
			<br /> <label>Gender : </label> Male :
			<form:radiobutton path="gender" value="male" />
			Female :
			<form:radiobutton path="gender" value="female" />
			
			<br/> <h3 align="center">Communication</h3>
			<label>Email : </label>
			<form:input path="communicationDto.email"/>
			<form:errors path="communicationDto.email" cssClass="error"/>
			
			<label>Phone : </label>
			<form:input path="communicationDto.phone"/>
			
			<br /> <br/><input Type="submit" value="register">
			
			
		</div>
		
	</form:form>
</body>
</html>