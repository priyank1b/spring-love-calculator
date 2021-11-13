<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result Page</title>
</head>
<body>
<h1 align="center">Love Calculator</h1>
<hr>
<h1>The Love Calculator Predicts :</h1>
${userInfo.yourName} and ${userInfo.crushName} are
<br/>
FRIEND
<br/>
<a href="/spring-love-calculator/sendMail">Send Result to your Email</a>
</body>
</html>