<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>MIE350 Sample Database Web App</title>
<link rel="stylesheet" type="text/css" href="style/theme.css">

</head>
<body>
	<%@ include file="navbar.jsp"%>

	<div class="container-noborder">
		Hello! The time is now <b><%=new java.util.Date()%></b>. Here are the forum
		topics: <br> <br> <a
			href="UserController?action=insert">Create Thread</a> <br> <br>
		<table border=1>
			<thead>
				<tr>
					<th>Thread Id</th>
					<th>Posted By</th>
					<th>Title</th>
					<th>Date of Post</th>
					<th colspan=2>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${threads}" var="thread">
					<tr>
						<td align="center"><c:out value="${thread.getThreadID()}" /></td>
						<td align="center"><c:out value="${thread.getUserID()}" /></td>
						<td align="center"><c:out value="${thread.getTitle()}" /></td>
						<td align="center"><fmt:formatDate pattern="yyyy-MMM-dd"
								value="${thread.getDoP()}" /></td>
						<td align="center"><a
							href="UserController?action=edit&ThreadID=<c:out value="${thread.getThreadID()}"/>">View Thread</a></td>
						<td align="center"><a
							href="UserController?action=delete&userId=<c:out value="${user.getUserid()}"/>">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>