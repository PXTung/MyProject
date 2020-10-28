<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME - VIEWS</title>
<link type="text/javascript"
	href="<c:url value='/resources/js/jquery-3.5.1.js' />" />
<link type="text/javascript"
	href="<c:url value='/src/webapp/WEB-INF/assets/js/jquery-3.5.1.js' />" />
<script type="text/javascript">
	function hello() {
		$.ajax({
			type : 'GET',
			url : '${pageContext.request.contextPath}/hello.html',
			success : function(list) {
				$('#result').html(list)
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert('Error...' + XMLHttpRequest.toString())
			}
		});
	}
</script>
</head>
<body>
	<h1>THIS IS HOME FROM VIEWS</h1>
</body>
</html>