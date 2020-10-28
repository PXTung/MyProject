<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="login-form">
			<div class="main-div">
				<form action="<c:url value = '/login'/>" id="formLogin" method = "POST">
					<div class="form-group">
						<input type="text" class="form-control" id="userName"
							name="userName" placeholder="USER NAME">
					</div>

					<div class="form-group">
						<input type="password" class="form-control" id="password"
							name="password" placeholder="PASSWORD">
					</div>
					<input type="hidden" value="login" name="action" />
					<button type="submit" class="btn btn-primary">LOGIN</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>