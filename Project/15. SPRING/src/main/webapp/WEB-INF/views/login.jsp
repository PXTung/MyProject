<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<body>
	<div class="container">
		<div class="login-form">
		
			<div class="main-div">
				<c:if test="${param.incorrectAccount != null}">
					<div class="alert alert-danger" style="font-size:11px">
  						PASSWORD OR ACCOUNT INCORRECT
					</div>
				</c:if> 
				<c:if test="${param.accessDenied != null}">
					<div class="alert alert-danger" style="font-size:11px">
						DONT HAVE PERMISSION
					</div>
				</c:if>
				<form action='<c:url value = "/j_spring_security_check"/>' id="formLogin" method="post">
					<div class="form-group">
						<input type="text" class="form-control" 
						id="j_username" name="j_username" placeholder="User Name">
					</div>

					<div class="form-group">
						<input type="password" class="form-control" 
						id="j_password" name="j_password" placeholder="Password">
					</div>
					<button type="submit" class="btn btn-primary">Login</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>