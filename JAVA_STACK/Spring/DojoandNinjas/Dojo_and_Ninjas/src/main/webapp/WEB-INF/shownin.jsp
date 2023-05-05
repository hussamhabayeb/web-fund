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
<table>
    <thead>
        <tr>
            <th>First name</th>
            <th>last name</th>
            <th>age</th>
          
        </tr>
    </thead>
    <tbody>
          <c:forEach var="b" items="${allninjas.ninjas}">
          <tr>
         
            <th>${b.firstName}</th>
            <th>${b.lastName}</th>
            <th>${b.age}</th>
           
        
    </c:forEach>
    </tbody>
</table>
</body>
</html>