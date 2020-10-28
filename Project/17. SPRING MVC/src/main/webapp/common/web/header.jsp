<%@page import="com.springmvc.util.SecurityUtils"%>
<%@include file="/common/taglib.jsp"%>
<html>
<div>
	<table class="table">
		<tr>
			<th scope="col" width="100px">HEADER</th>
			<security:authorize access="isAnonymous()">
				<th width="1100px">
					<a class="nav-link" href="<c:url value = '/login'/>">LOGIN</a>
				</th>
			</security:authorize>

			<security:authorize access="isAuthenticated()">
				<th width="500px">
					<a>WELL COME, <%=SecurityUtils.getPrincipal().getFullName() %></a>
				</th>
				
				<th width="100px">
					<a class="nav-link" href="<c:url value = '/logout'/>">LOGOUT</a>
				</th>
			</security:authorize>
		</tr>
	</table>


</div>

<hr>
</html>