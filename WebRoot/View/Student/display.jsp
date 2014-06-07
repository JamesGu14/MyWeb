<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Student</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="<c:url value="/asset/css/bootstrap.min.css"/>" rel="stylesheet" />
<link href="<c:url value="/asset/css/bootstrap-theme.min.css"/>" rel="stylesheet" />

</head>

<body>
	<jsp:include page="/Tile/header.jsp"></jsp:include>

	<div id="content">
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
					<td><fmt:formatDate pattern="yyyy-MM-dd"
							value="${student.dob}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<jsp:include page="/Tile/footer.jsp"></jsp:include>
	<script src="<c:url value="/asset/js/jquery-1.11.1.min.js" />"></script>
	<script src="<c:url value="/asset/js/bootstrap.min.js" />"></script>
	
</body>
</html>
