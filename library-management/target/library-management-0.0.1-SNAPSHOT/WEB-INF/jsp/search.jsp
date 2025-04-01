<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Search for a Book</title>
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

.message {
	font-weight: bold;
	margin: 20px 0;
}

.error {
	color: red;
}
</style>
</head>
<body>
	<h1>Search for a Book</h1>
	<form action="/books/search" method="get">
		<label for="title">Enter Book Title:</label> <input type="text"
			id="title" name="title" required>
		<button type="submit">Search</button>
	</form>
	<br>

	<c:if test="${not empty books}">
		<h2>Search Results:</h2>
		<table border="1">
			<thead>
				<tr>
					<th>Title</th>
					<th>Author</th>
					<th>Published Year</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<td>${book.title}</td>
						<td>${book.author}</td>
						<td>${book.publishedYear}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>

	<c:if test="${empty books}">
		<div class="message error">No books found matching your search
			criteria.</div>
	</c:if>

	<br>
	<a href="/welcome" class="btn">Back to Welcome</a>
</body>
</html>
