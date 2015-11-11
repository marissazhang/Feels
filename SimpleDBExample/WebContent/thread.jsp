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
		Note: the User ID is a fixed field and cannot be changed. <br> <br>
		
				<table border=1>
			<thead>
				<tr>
					<th>CommentID</th>
					<th>UserID</th>
					<th>Comment</th>
					<th>Timestamp</th>
					<th colspan=2>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${comments}" var="comment">
					<tr>
						<td align="center"><c:out value="${comment.getCommentID()}" /></td>
						<td align="center"><c:out value="${comment.getUserID()}" /></td>
						<td align="center"><c:out value="${comment.getComment()}" /></td>
						<td align="center"><fmt:formatDate pattern="yyyy-MMM-dd"
								value="${comment.getTimestamp()}" /></td>
						<td align="center"><a
							href="UserController?action=edit&threadId=<c:out value="${user.getThreadID()}"/>">Edit</a></td>
						<td align="center"><a
							href="UserController?action=delete&userId=<c:out value="${user.getUserid()}"/>">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		Add comment: <br>
		<form method="POST" action='UserController' name="frmAddComment">
			<textarea rows="4" cols="50" name="Comment"
			value="<c:out value="${comment.Comment}" />">
			</textarea>
			<input type ="submit" value="Submit">
		</form>
	
		
	</div>
</body>
</html>