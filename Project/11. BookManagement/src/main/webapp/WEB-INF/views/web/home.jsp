<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>

</head>
<body>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.js"></script>

	<script type="text/javascript">
		function addReader() {
			$.ajax({
				type : 'GET',
				url : '${pageContext.request.contextPath}/addreader.html',
			
				cache : false,
				data : "perId=" + $("#perId").val() + "&perName="
						+ $("#perName").val() + "&perAddress="
						+ $("#perAddress").val() + "&perDob="
						+ $("#perDob").val() + "&perGender="
						+ $("#perGender").val() + "&redId=" + $("#redId").val()
						+ "&redType=" + $("#redType").val() + "&redPhone="
						+ $("#redPhone").val() + "&redEmail="
						+ $("#redEmail").val(),

				success : function(list) {
					var data = "<table><tr><th>ID</th><th>NAME</th></tr>";
					for(var i = 0; i < list.length; i++){
						data += "<tr><td>" + list[i] + "</td></tr>";
					}
					data += "</table>";
					$('#result').html(list)
				
				},
			});
		}
	</script>
	<h1>ADD READER</h1>
	<br />
	<form>
		<table>
			<tr>
				<td>IDENTIFY</td>
				<td><input type="text" name="perId" id="perId" /></td>
			</tr>
			<tr>
				<td>FULL NAME</td>
				<td><input type="text" name="perName" id="perName" /></td>
			</tr>
			<tr>
				<td>ADDRESS</td>
				<td><input type="text" name="perAddress" id="perAddress" /></td>
			</tr>
			<tr>
				<td>DATE OF BIRDTH</td>
				<td><input type="text" name="perDob" id="perDob" /></td>
			</tr>
			<tr>
				<td>GENDER</td>
				<td><input type="text" name="perGender" id="perGender" /></td>
			</tr>
			<tr>
				<td>READER ID</td>
				<td><input type="text" name="redId" id="redId" /></td>
			</tr>
			<tr>
				<td>TYPE</td>
				<td><input type="text" name="redType" id="redType" /></td>
			</tr>
			<tr>
				<td>PHONE NUMBER</td>
				<td><input type="text" name="redPhone" id="redPhone" /></td>
			</tr>
			<tr>
				<td>EMAIL</td>
				<td><input type="text" name="redEmail" id="redEmail" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="ADD"
					onclick="addReader();" /></td>
			</tr>
		</table>
	</form>

	<h1>LIST READER</h1>
	<div id="result">
	</div>
	
</body>
</html>