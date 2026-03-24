<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>List of Books</title>
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
</style>
</head>
<body>
	<h1>List of Books</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Title</th>
				<th>Author</th>
				<th>Published Year</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${books}">
				<tr>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td>${book.publishedYear}</td>
					<td>${book.isIssued ? 'Issued' : 'Available'}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<a href="/welcome" class="btn">Back to Welcome</a>
</body>
</html>
