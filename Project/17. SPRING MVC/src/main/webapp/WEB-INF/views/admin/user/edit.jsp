<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="userAPI" value="/api/admin/user" />
<c:url var="userListURL" value="/admin/user/list" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form id="formSubmit">
		<label>FULL NAME</label>
		<br>
		<input type="text" id="fullName" name="fullName">
		<br>
		<br>
		<label>USER NAME</label>
		<br>
		<input type="text" id="userName" name="userName">
		<br>
		<br>
		<label>PASSWORD</label>
		<br>
		<input type="password" id="password" name="password">
		<br>
		<br>
		<label>ROLE</label>
		<br>
		<input type="text" id="role" name="role">
		<br>
		<br>
		<label>STATUS</label>
		<br>
		<input type="text" id="status" name="status">
		<br>
		<br>
		<button class="btn btn-info" type="button" id="btnAddOrUpdate">
			<i class="ace-icon fa fa-check bigger-110"></i> ADD
		</button>
		<input type="button" id="btnCancel" name="btnCancel" value="CANCEL">

	</form:form>
	<script type="text/javascript">
	$('#btnAddOrUpdate').click(function(e) {
		e.preventDefault();
		var data = {};
		var formData = $('#formSubmit').serializeArray();
		$.each(formData, function(i, v) {
			data["" + v.name + ""] = v.value;
		});
		
		addNews(data);
	});

	function addNews(data) {
		$.ajax({
			url : '${userAPI}',
			type : 'POST',
			contentType : 'application/json',
			data : JSON.stringify(data),
			dataType : 'json',
			success : function(result) {
				window.location.href = "${userListURL}";
			},
			error : function(error) {
				window.location.href = "${userListURL}";
			},
		});
	}
	</script>
</body>
</html>