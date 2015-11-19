<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Recommendations</title>
<link rel="stylesheet" type="text/css" href="style/theme.css">
</head>
<body>

	<%@ include file="navbar.jsp"%>

	<div class="container">

		<h1>Input Symptoms</h1>
	
		<p>This is some description about this functionality </p>

		
		<form action='UserController?action=symptomInput' method="POST">
		<ul>
		<c:forEach items="${symptoms}" var="symptom">
			<li><input type="checkbox" name= "${symptom.getSymptomName()}"/><c:out  value="${symptom.getSymptomName()}" /></li>
		</c:forEach>
		
		</ul>
		<input type="submit" value="Select Symptom" />
		</form>
		
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>