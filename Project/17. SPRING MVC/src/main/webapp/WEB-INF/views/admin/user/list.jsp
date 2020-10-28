<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "/common/taglib.jsp" %>
<c:url var="userAPI" value="/api/admin/user"/>
<c:url var="userListURL" value="/admin/user/list"/>
<c:url var="userEditURL" value="/admin/user/edit"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col-xs-12">
			<div class="table-responsive">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th> <input type="checkbox" id="checkAll" name="checkAll"></th>
							<th>NAME</th>
							<th>USER</th>
							<th>ROLE</th>
							<th>STATUS</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${model.listResult}">
							<tr>
								<th> <input type="checkbox" id="check_${item.id}" value="${item.id}"></th>
								<td>${item.fullName}</td>
								<td>${item.userName}</td>
								<td>${item.role.name}</td>
								<td>${item.status}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br><br><br>
				<input type="button" id="btnAdd" name="btnAdd" onclick="addUser()" value="Add">
				<input type="button" id="btnEdit" name="btnEdit" onclick="editUser()" value="Add">
				<input type="button" id="btnDelete" name="btnDelete" onclick="deleteUser()" value="DELETE">
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	function deleteUser(){
		var ids = $('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
		$.ajax({
			url:'${userAPI}',
			type:'DELETE',
			contentType:'application/json',
			data: JSON.stringify(ids),
			success: function(success){
				window.location.href="${userListURL}";
			},
			error: function(error){
				window.location.href="${userListURL}";
			}
		});
	}

	function addUser(){
		window.location.href="${userEditURL}";
	}
	</script>
</body>
</html>