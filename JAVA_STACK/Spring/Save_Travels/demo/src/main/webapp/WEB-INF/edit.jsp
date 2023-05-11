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

<h1>Edit ID expense </h1>
<form:form action="/edit/${expense.id}" method="put" modelAttribute="expense">
    <p>
        <form:label path="name">Expens Name</form:label>
        <form:errors path="name"/>
        <form:input type="text" path="name" value="${ expense.name}"/>
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor"/>
       <form:input type="text" path="vendor"  value="${ expense.vendor}"/>
    </p>
    <p>
        <form:label path="amount">Amount</form:label>
        <form:errors path="amount"/>     
        <form:input type="number" path="amount" value="${ expense.amount}"/>
    </p> 
    
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>     
        <form:input type="text" path="description" value="${ expense.description}"/>
    </p> 
    
    
       
    <input type="submit" value="Submit"/>
</form:form>  

</body>
</html>