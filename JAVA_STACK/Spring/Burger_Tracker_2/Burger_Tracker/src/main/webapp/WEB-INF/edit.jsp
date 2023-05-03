<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Book</h1>
<form:form action="/burger/${burger.id}" method="post" modelAttribute="burger">
    <input type="hidden" name="_method" value="put">
    <p>
        <form:label path="name">Title</form:label>
        <form:errors path="name"/>
        <form:input path="name" value="${burger.name }"/>
    </p>
    <p>
        <form:label path="resturant">Description</form:label>
        <form:errors path="resturant"/>
        <form:textarea path="resturant" value="${burger.resturant }"/>
    </p>
    <p>
        <form:label path="rating">Pages</form:label>
        <form:errors path="rating"/>     
        <form:input type="number" path="rating" value="${burger.rating }"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>