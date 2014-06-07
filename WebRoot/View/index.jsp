<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	Hello WOrld

	<br>

	<table>
		<tr>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Dob</td>
		</tr>
		<c:forEach var="student" items="${stuList}">
			<tr>
				<td>${student.fname}</td>
				<td>${student.lname}</td>
				<td>
					<fmt:formatDate pattern="yyyy-MM-dd" value="${student.dob}" />
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
