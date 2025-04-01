<!DOCTYPE html>
<html>
<head>
<title>Add New Book</title>
<style>
body {
	font-family: Arial, sans-serif;
}

.btn {
	background-color: #4CAF50;
	color: white;
	text-decoration: none;
	padding: 10px 20px;
	border-radius: 5px;
}

.btn-large {
	font-size: 18px;
	padding: 15px 30px;
}

.success {
	color: green;
}

label {
	font-weight: bold;
}

input[type="text"], input[type="number"] {
	padding: 8px;
	width: 250px;
	margin-bottom: 15px;
	border-radius: 5px;
	border: 1px solid #ccc;
}

form {
	max-width: 400px;
	margin: 0 auto;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	background-color: #f9f9f9;
}

h1 {
	text-align: center;
	color: #4CAF50;
}
</style>
</head>
<body>
	<h1>Add New Book</h1>

	<!-- Success message block -->
	<c:if test="${not empty successMessage}">
		<p class="success">${successMessage}</p>
	</c:if>

	<form action="/books/add" method="post">
		<label for="title">Book Title:</label> <input type="text" id="title"
			name="title" required><br> <br> <label for="author">Author:</label>
		<input type="text" id="author" name="author"><br> <br>
		<label for="publishedYear">Published Year:</label> <input
			type="number" id="publishedYear" name="publishedYear"><br>
		<br>

		<!-- Removed checkbox, "isIssued" field defaults to false -->
		<input type="hidden" name="isIssued" value="false">

		<button type="submit" class="btn btn-large">Add Book</button>
	</form>

	<br>
	<a href="/welcome" class="btn">Back to Welcome</a>
</body>
</html>
