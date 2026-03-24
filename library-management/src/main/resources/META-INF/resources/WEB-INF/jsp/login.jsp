<!DOCTYPE html>
<html>
<head>
<title>Login - Library Management System</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f9;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.login-container {
	background-color: white;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
	width: 300px;
	text-align: center;
}

h1 {
	margin-bottom: 20px;
	color: #333;
}

.form-group {
	margin-bottom: 15px;
	text-align: left;
}

label {
	display: block;
	margin-bottom: 5px;
	color: #555;
}

input[type="text"], input[type="password"] {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
}

button {
	background-color: #4CAF50;
	color: white;
	border: none;
	padding: 10px 15px;
	border-radius: 5px;
	cursor: pointer;
	width: 100%;
}

button:hover {
	background-color: #45a049;
}

.add-user {
	margin-top: 15px;
	font-size: 14px;
}

.add-user a {
	color: #007BFF;
	text-decoration: none;
}

.add-user a:hover {
	text-decoration: underline;
}

.highlight {
	font-weight: bold;
	color: #FF5722;
}

.error-message {
	color: #FF0000;
	margin-bottom: 15px;
	font-size: 14px;
}
</style>
</head>
<body>
	<div class="login-container">
		<h1>Login</h1>
		<form action="${pageContext.request.contextPath}/login" method="post">
			<!-- CSRF Token -->
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<c:if test="${not empty error}">
				<div class="error-message">${error}</div>
			</c:if>
			<div class="form-group">
				<label for="username">Username</label> <input type="text"
					id="username" name="username" required />
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					id="password" name="password" required />
			</div>
			<button type="submit">Submit</button>
		</form>
		<div class="add-user">
			For new user, <a href="${pageContext.request.contextPath}/register"
				class="highlight">Click here</a>.
		</div>
	</div>
</body>
</html>
