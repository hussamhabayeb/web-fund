<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>welcome ${user.name }</h1>    <button><a href="/logout">logout</a></button>

<h1>Book from everyone shelve's</h1> <button><a href="/books/new">Add Book</a></button>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>title</th>
            <th>Author name</th>
            <th>Posted By</th>
           
          
        </tr>
    </thead>
    <tbody>
        <c:forEach var="book" items="${books}">
		<tr>
				<td>${book.id}</td>
				<td><a href="/books/${book.id}">${book.title}</a></td>
				<td><c:out value="${book.author}"></c:out></td>
			
			    <td>${book.user.name }</td>
		   
		</tr>	
		</c:forEach>
    </tbody>
</table>
</body>
</html>