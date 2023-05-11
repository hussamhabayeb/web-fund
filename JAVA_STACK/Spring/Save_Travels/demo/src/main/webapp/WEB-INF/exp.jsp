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
		<title>Save Travel</title>
</head>
<body>
<h1>Save Travel</h1>
<table >
    <thead>
        <tr>
            <th>Expense</th>
            <th>Vendor</th>
            <th>Amount</th>
            <th>action</th>
        </tr>
    </thead>
    <tbody>
          <c:forEach var="b" items="${expense}">
          <tr>
          
           	<th><a href="/expenses/${b.id }">${b.name}</a></th>
            <th>${b.vendor}</th>
            <th>${b.amount}</th>
            <th><a href="/expenses/edit/${b.id }">edit</a></th>
            <th>
            <form action="/expenses/${b.id }" method="post">
				<input type="hidden" name="_method" value="delete">
				<input type="submit" value="Delete">
			</form>
			</th>
        </tr>
        
    </c:forEach>
    </tbody>
</table>

<h1>Add an expense :</h1>


<form:form action="/expense" method="post" modelAttribute="exp">
    <p>
        <form:label path="name">Expens Name</form:label>
        <form:errors path="name"/>
        <form:input type="text" path="name"/>
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor"/>
       <form:input type="text" path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount</form:label>
        <form:errors path="amount"/>     
        <form:input type="number" path="amount"/>
    </p> 
    
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>     
        <form:input type="text" path="description"/>
    </p> 
    
    
       
    <input type="submit" value="Submit"/>
</form:form>  

</body>
</html>