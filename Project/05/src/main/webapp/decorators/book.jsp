<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>BOOK STORE - HOME</title>

<!-- Bootstrap core CSS -->
<link
	href="<c:url value='/template/book/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link href="<c:url value='/template/book/css/shop-homepage.css'/>"
	rel="stylesheet" type="text/css">
</head>
<body>
	<!-- HEADER -->
	<%@include file="/common/book/header.jsp"%>
	
	<!-- BODY -->
	<dec:body/>

	<!-- Footer -->
	<%@include file="/common/book/footer.jsp"%>

	<!-- Bootstrap core JavaScript -->
	<script src="<c:url value='/template/book/jquery/jquery.min.js'/>"></script>
	<script
		src="<c:url value='/template/book/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
</body>
</html>