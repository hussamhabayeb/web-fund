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
<h1>Project Details</h1>
<h1>Project : ${project.title }</h1>
<h1>Description : ${project.description }</h1>
<h1>dueDate : ${project.dueDate }</h1>

<c:if test = "${project.lead.id==userId}">
    <h2><a href="/projects/delete/${project.id}">Delete Project</a></h2>
</c:if>


</body>
</html>