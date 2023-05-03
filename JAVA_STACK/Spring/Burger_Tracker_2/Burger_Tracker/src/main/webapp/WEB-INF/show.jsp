<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>New Burger</h1>
<form:form action="/burger" method="post" modelAttribute="burg">
    <p>
        <form:label path="name">name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="resturant">resturant</form:label>
        <form:errors path="resturant"/>
        <form:textarea path="resturant"/>
    </p>
    <p>
        <form:label path="rating">rating</form:label>
        <form:errors path="rating"/>     
        <form:input type="number" path="rating"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>    


<h1>All Burger</h1>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>resturant</th>
            <th>rating</th>
            <th>action</th>
        </tr>
    </thead>
    <tbody>
          <c:forEach var="b" items="${burgers}">
          <tr>
            <th>${b.id}</th>
            <th>${b.name}</th>
            <th>${b.resturant}</th>
            <th>${b.rating}</th>
            <th><a href="edit/${b.id }">edit</a></th>
        </tr>
        
    </c:forEach>
    </tbody>
</table>



</body>
</html>