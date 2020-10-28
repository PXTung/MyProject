<%@page import="com.login.model.NumberAdd"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% NumberAdd numberAdd = new NumberAdd(); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REGISTER</title>
</head>
<body>
	<div style="width: 500px; margin: 30px auto;">
		<h2>REGISTER</h2>
		<form action="sum" method="POST">
			<div>
				<label>NUMBER 1: </label> <input type="text" name="number1" value="" />
			</div>
			<br />
			<div>
				<label>NUMBER 2: </label> <input type="text" name="number2" value="" />
			</div>
			<br />
			<div>
				<input type="submit" name="add" value="ADD" />
			</div>
		</form>
	</div>

	<div>
		<table>
			<thead>
				<tr>
					<th>NUMBER 1</th>
					<th>NUMBER 2</th>
					<th>SUM</th>
				</tr>
				
				<tr>
					<td><%=numberAdd.getNumber1() %></td>
					<td><%=numberAdd.getNumber2()%></td>
					<td><%=numberAdd.getSum() %></td>
				</tr>
		</table>
	</div>
</body>
</html>