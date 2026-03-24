<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Return a Book</title>
<style>
body {
	font-family: Arial, sans-serif;
}

.btn {
	background-color: #4CAF50;
	color: white;
	text-decoration: none;
	padding: 5px 10px;
	border-radius: 5px;
	font-size: 14px;
}

.btn-large {
	padding: 15px 30px;
	font-size: 18px;
}

button[type="submit"] {
	background-color: #4CAF50;
	color: white;
	padding: 15px 30px;
	font-size: 18px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.message {
	font-weight: bold;
	padding: 10px;
	margin-bottom: 20px;
}

.success {
	color: green;
}

.error {
	color: red;
}
</style>
</head>
<body>
	<h1>Return a Book</h1>

	<!-- Display the success or error message -->
	<c:if test="${not empty message}">
		<div
			class="message ${message.startsWith('Error') ? 'error' : 'success'}">
			${message}</div>
	</c:if>

	<form action="/books/return" method="post">
		<label for="bookId">Select Book:</label> <select name="bookId"
			id="bookId" required>
			<c:forEach var="book" items="${books}">
				<option value="${book.id}">${book.title}- ${book.author}</option>
			</c:forEach>
		</select> <br>
		<br>
		<button type="submit" class="btn-large">Return Book</button>
	</form>
	<br>
	<a href="/welcome" class="btn">Back to Welcome</a>
</body>
</html>
