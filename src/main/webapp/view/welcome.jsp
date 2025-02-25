<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.oakland.model.Employee"%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container mt-5 p-5" style="max-width: 1000px;">
		<div class="d-flex justify-content-between align-items-center mb-4">
			<%
			Employee user = (Employee) session.getAttribute("loggedInUser");
			if (user == null) {
				response.sendRedirect("login.jsp");
				return;
			}
			%>
			<h2 class="text-primary">
				Hello,
				<%=user.getName()%>
				!
			</h2>
			<a href="logout" class="btn btn-danger">Logout</a>
		</div>
		<h3 class="mb-3 text-center">List of Registered Employees</h3>
		<div class="table-responsive">
			<table class="table table-striped table-bordered table-hover">
				<thead class="table-dark text-center">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>City</th>
						<th>State</th>
						<th>DOB</th>
						<th>Gender</th>
						<th>Email</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<Employee> employees = (List<Employee>) request.getAttribute("employees");
					if (employees != null && !employees.isEmpty()) {
						for (Employee emp : employees) {
					%>
					<tr>
						<td><%=emp.getId()%></td>
						<td><%=emp.getName()%></td>
						<td><%=emp.getCity()%></td>
						<td><%=emp.getState()%></td>
						<td><%=emp.getDob()%></td>
						<td><%=emp.getGender()%></td>
						<td><%=emp.getLoginId()%></td>
					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td colspan="4" class="text-center text-muted">No employees
							found.</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
