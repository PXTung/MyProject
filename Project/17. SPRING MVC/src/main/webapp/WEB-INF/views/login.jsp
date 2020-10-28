<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action='<c:url value="/j_spring_security_check"/>' id="formLogin" method="post">
	<c:if test="${param.incorrectAccount != null}">
		<div>INCORRECT USERNAME OR PASSWORD</div>
		<br>
	</c:if>
	<c:if test="${param.isAccessDenied != null}">
		<div>DONT HAVE PERMISSION</div>
		<br>
	</c:if>
	
	<label>USER NAME</label>
	<br>
	<input type="text" id="j_username" name="j_username">
	<br>
	<br>
	<label>PASSWORD</label>
	<br>
	<input type="password" id="j_password" name="j_password">
	<br>
	<br>
	<button type="submit">LOGIN</button>
</form>
</body>
</html>