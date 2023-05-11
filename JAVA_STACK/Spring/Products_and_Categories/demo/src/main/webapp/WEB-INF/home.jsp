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
<h1>home page</h1>


<a href="/products/new">new product</a>
<a href="/Categories/new">new Category</a>

<hr>


<h1>All Products</h1>
<ul>
 <c:forEach var="b" items="${pro}">

<a href="/product/${b.id }"><li>${b.name}</li></a>
 </c:forEach>
</ul>

<h1>All Categories</h1>
<ul>
 <c:forEach var="c" items="${cat}">
<a href="/categorie/${c.id }"><li>${c.name}</li></a>

 </c:forEach>
</ul>

</body>
</html>