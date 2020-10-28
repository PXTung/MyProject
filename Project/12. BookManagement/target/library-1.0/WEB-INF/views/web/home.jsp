<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#btnHello').click(function() {
			$.ajax({
				type:'GET',
				url:'${pageContext.request.contextPath}/result/helloajax.html',
				success: function(data){
					$('.result').html(data)
				}
			});
		});
	});
</script>
</head>
<body>


	<h1>THIS IS HOME FROM VIEWS</h1>
	<br />
	<form>
		<input type="button" value="HELLO" id="btnHello" /> <br />
	</form>
	<div class="result"></div>
</body>
</html>