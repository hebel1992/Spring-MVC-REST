<%@ page contentType="text/html;=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>AddBook</title>
</head>
<body>
<h3>Dodaj nowa ksiazke:</h3>
<form:form method="post" modelAttribute="book" action="/books/">
    ID: <form:input path="id" type="number" step="1" min="0" name="id" /><br/>
    ISBN: <form:input path="isbn" type="text" name="isbn" /><br/>
    Title: <form:input path="title" type="text" name="title" /><br/>
    Author: <form:input path="author" type="text" name="author" /><br/>
    Publisher: <form:input path="publisher" type="text" name="publisher" /><br/>
    Type: <form:input path="type" type="text" name="type" /><br/>
    <input type="submit" value="dodaj"/>
</form:form>
<script src="js.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>
