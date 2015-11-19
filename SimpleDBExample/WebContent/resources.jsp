<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
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
	<% 
	ArrayList<String> symptomNames = new ArrayList();
	%>
	
	<%@ include file="navbar.jsp"%>

	<div class="container">
	
		<c:forEach items="${symptomResources}" var="sympRes">

				<li><b><c:out  value="${sympRes.getSymptomName()}" /></b></li>
				<li><a href="${sympRes.getResourceName()}" ><c:out  value="${sympRes.getResourceName()}" /></a></li>

	 		
		</c:forEach>
		
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>

