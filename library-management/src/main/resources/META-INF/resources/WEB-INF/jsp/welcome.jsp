<!DOCTYPE html>
<html>
<head>
<title>Welcome to Library Management System</title>
<style>
body {
	font-family: Arial, sans-serif;
	text-align: center;
	padding: 50px;
}

.btn {
	padding: 10px 20px;
	margin: 10px;
	background-color: #4CAF50;
	color: white;
	text-decoration: none;
	border-radius: 5px;
}

.logout-btn {
	position: absolute;
	top: 10px;
	right: 10px;
	background-color: red;
	color: white;
	border: none;
	padding: 10px 20px;
	cursor: pointer;
	border-radius: 5px;
}
</style>
</head>
<body>
	<h1>Welcome to Library Management System</h1>
	<div>
		<a href="/books/issue" class="btn">Issue a Book</a> <a
			href="/books/return" class="btn">Return a Book</a> <a
			href="/books/list" class="btn">Show List of Books</a> <a
			href="/books/search" class="btn">Search for a Book</a> <a
			href="/books/add" class="btn">Add New Book</a>
	</div>

	<!-- Logout Form -->
	<form action="/logout" method="post"
		style="position: absolute; top: 10px; right: 10px;">
		<button type="submit" class="logout-btn">Logout</button>
	</form>
</body>
</html>
