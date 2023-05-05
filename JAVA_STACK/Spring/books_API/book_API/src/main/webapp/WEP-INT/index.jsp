<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>All Books</h1>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Language</th>
            <th>Number of Pages</th>

        </tr>
    </thead>
    <tbody>
         <c:forEach var="book" items="${books}">
       <tr>
            <th>${book.id}</th>
            <th><a href="books/${book.id}">${book.title}</a> </th>
            <th>${book.language}</th>
            <th>${book.numberOfPages}</th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>