<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- this tag lb is for jstl -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered User</title>
</head>
<body>
<h1 align="center">Your Details</h1>
User : ${registerUser.user}<br/>
UserName : ${registerUser.userName}<br/>
Password : ${registerUser.pass}<br/>
Country : ${registerUser.country}<br/>
Hobbies : 
<c:forEach var="temp" items="${registerUser.hobbies}"> 
<!-- this tag is for jstl, as hobbies is in an array so to iterate over array we use jstl commands -->
${temp}
</c:forEach>
<br/>Age : ${registerUser.age}
<br/>Gender : ${registerUser.gender}
<br/>Email : ${registerUser.communicationDto.email}
<br/>Phone : ${registerUser.communicationDto.phone}
</body>
</html>