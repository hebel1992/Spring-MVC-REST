<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>MainView</title>
</head>
<body>
<h2>Lista ksiazek:</h2>
<table border="1">
    <thead style="background-color: green">
    <tr>
        <td>ID</td><td>ISBN</td><td>Title</td><td>Author</td><td>Publisher</td><td>Type</td>
    </tr>
    </thead>
    <c:forEach var="book" items="${allBooks}">
        <tr>
            <td>${book.id}</td><td>${book.isbn}</td><td>${book.title}</td><td>${book.author}</td><td>${book.publisher}</td><td>${book.type}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
