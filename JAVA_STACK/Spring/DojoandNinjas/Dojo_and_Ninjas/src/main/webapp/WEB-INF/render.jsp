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
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <h1>New Ninja</h1>
<form:form action="/ninja" method="post" modelAttribute="goToJspFile2">

 <form:label path="dojo">Dojo name</form:label>
 
       
   
<form:select path="dojo" >
<c:forEach var="dj" items="${alldojos}">
  <option value="${ dj.id}">${dj.name}</option>
   </c:forEach>
</form:select>
    <p>
        <form:label path="firstName">first name</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">last name</form:label>
        <form:errors path="lastName"/>
        <form:textarea path="lastName"/>
    </p>
    <p>
        <form:label path="age">age</form:label>
        <form:errors path="age"/>     
        <form:input type="number" path="age"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>    
</body>
</html>

