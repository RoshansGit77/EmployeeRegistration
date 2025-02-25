<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container mt-5 p-5 form-control" style="max-width: 600px;">
		<h1 class="text-center">Employee Login</h1>
		<%
		String msg = (String) request.getAttribute("msg");
		%>
		<%
		if (msg != null) {
		%>
		<div class="alert alert-info text-center"><%=msg%></div>
		<%
		}
		%>
		<%
		String message = (String) session.getAttribute("message");
		%>
		<%
		if (message != null) {
		%>
		<div class="alert alert-info text-center"><%=message%></div>
		<%
		}
		%>
		<form action="login" method="post">
			<div class="mb-3">
				<label for="Email1" class="form-label">Login Id (Email
					address)</label> <input type="email" name="loginId" required
					class="form-control" id="loginId">
			</div>
			<div class="mb-3">
				<label for="Password1" class="form-label">Password</label> <input
					type="password" name="password" required class="form-control"
					id="password">
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-primary">Login</button>
			</div>
			<div>
				<br> dont have account? <a href="register"> register here</a>
			</div>
		</form>
	</div>
</body>
</html>