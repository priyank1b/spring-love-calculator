<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <!-- this taglib is used to use spring form tag library -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>

<script type="text/javascript">
function validateInput(){
	var userName = document.getElementById("yn").value;
	var crushName = document.getElementById("cn").value;
	if(userName==''){
		alert("Please provide your name");
		return false;
	}else if(crushName==''){
		alert("Please provide crush name");
		return false;
	}
	else if(userName.length<3 || userName.length>15){
		alert("Please provide username in between 3 to 15 characters");
		return false;
	}else if(crushName.length<3 || crushName.length>15){
		alert("Please provide username in between 3 to 15 characters");
		return false;
	}
	return true;
}
</script>

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
<h1 align="center">Love Calculator</h1>

<!-- ------------------------------------------------------------------------------------------------------------------------- -->
<!-- below is one way of writing form tag in html second way is using sprin tags which is written from line  -->
<!--<form action="process-homepage">
<hr>
<div align="center">
<p>
<label for="yn">Your Name : </label>
<input type="text" id="yn" name="yourName"/>
</p>
<p>
<label for="cn">Crush Name : </label>
<input type="text" id="cn" name="crushName"/>
</p>
<input type="submit" value="calculate"/>
</div>
</form> -->
<!-- ------------------------------------------------------------------------------------------------------------------------- -->

<!-- below is the second way of writing form tag using spring tag lib -->
<form:form action="process-homepage" method="GET" modelAttribute="userInfo"> <!-- also don't forget to give model attribute name here which you have given in LCAppControler -->
<hr>
<div align="center">
<p>
<label for="yn">Your Name : </label>
<form:input id="yn" path="yourName"/> <!-- in spring form tag input no need to write type="text" for:input understands it's a type="text" and name will be changed to path so that default values can pass through model attribute -->
<form:errors path="yourName" cssClass="error"/>
</p>
<p>
<label for="cn">Crush Name : </label>
<form:input id="cn" path="crushName"/>
<form:errors path="crushName" cssClass="error"/>
</p>
<p>
<form:checkbox path="termAndCondition"/>
<label>I am agreeing that this is for fun</label>
<form:errors path="termAndCondition" cssClass="error"/>
</p>
<input type="submit" value="calculate"/>
</div>
</form:form>
</body>
</html>