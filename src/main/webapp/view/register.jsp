<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Registration</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<div class="container mt-5 p-5 form-control" style="max-width: 600px;">
		<h1 class="text-center mb-4">Employee Registration</h1>
		<form action="register" method="post">

			<div class="mb-3">
				<label for="name" class="form-label">Employee Name</label> <input
					type="text" name="name" required class="form-control" id="name">
			</div>

			<div class="mb-3">
				<label for="dob" class="form-label">Date of Birth</label> <input
					type="date" name="dob" required class="form-control" id="dob">
			</div>

			<div class="mb-3">
				<label class="form-label">Gender</label> <br>
				<div class="form-check form-check-inline">
					<input type="radio" name="gender" value="male" required
						class="form-check-input" id="male"> <label for="male"
						class="form-check-label">Male</label>
				</div>
				<div class="form-check form-check-inline">
					<input type="radio" name="gender" value="female" required
						class="form-check-input" id="female"> <label for="female"
						class="form-check-label">Female</label>
				</div>
				<div class="form-check form-check-inline">
					<input type="radio" name="gender" value="other" required
						class="form-check-input" id="other"> <label for="other"
						class="form-check-label">Other</label>
				</div>
			</div>

			<div class="mb-3">
				<label for="address" class="form-label">Address</label> <input
					type="text" name="address" required class="form-control"
					id="address">
			</div>

			<div class="mb-3">
				<label for="city" class="form-label">City</label> <input type="text"
					name="city" required class="form-control" id="city">
			</div>

			<div class="mb-3">
				<label for="state" class="form-label">State</label> <input
					type="text" name="state" required class="form-control" id="state">
			</div>

			<div class="mb-3">
				<label for="loginId" class="form-label">Login ID (Email)</label> <input
					type="text" name="loginId" required class="form-control"
					id="loginId">
			</div>

			<div class="mb-3">
				<label for="password" class="form-label">Password</label> <input
					type="password" name="password" required class="form-control"
					id="password">
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-primary">Register</button>
			</div>
		</form>
		<br>
		<p>
			Already registered? <a href="login">Login here</a>
		</p>

	</div>
</body>
</html>
