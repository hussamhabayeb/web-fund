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


<h1>${prod.name}</h1>


<hr>

<h1>Categories:</h1>
<ul>
<c:forEach var="dj" items="${prod.categories}">
  <li>${dj.name}</li>
   </c:forEach>
</ul>



<form:form action="/product/${prod_id}" method="post" modelAttribute="goToJspFile3">

<form:select path="name" >
<c:forEach var="b" items="${cat}">
  <option value="${ b.id}">${b.name}</option>
   </c:forEach>
</form:select>

<input type="submit" value="add"/>
</form:form>    

</body>
</html>