<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
	href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="style/theme.css">

<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>MIE350 Sample DB Web App: Add/Update A User</title>
</head>
<body>
	<%@ include file="navbar.jsp"%>.

	<div class="container">
		<center>
			<h1>Comments of this thread</h1>
		</center>
		<script>
			$(function() {
				$('input[name=dob]').datepicker();
			});
		</script>
		Note: U of T Professionals are marked with an asterisk (*) beside their name. <br> <br>
		
				<table border=1>
			<thead>
				<tr>
					<th>Username</th>
					<th>Comment</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${comments}" var="comment">
					<tr>
						<td align="center"><c:out value="${comment.getUsername()}" /></td>
						<td align="center"><c:out value="${comment.getComment()}" /></td>
							
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		Add comment: <br>
		<form method="POST" action="UserController?action=insertComment" name="frmAddComment">
		
		<br>
			Username: <input type="text" name="userName"
				value="<c:out value="${user.username}" />"><br>
			Password: <input type="text" name="password"
				value="<c:out value="${user.password}" />"><br>
			<input type="checkbox" name="Anon" value="Anon">Post as Anonymous<br>
			<textarea rows="4" cols="50" name="Comment"></textarea>
			<input type ="submit" value="Submit">
		</form>
	
		
	</div>
</body>
</html>