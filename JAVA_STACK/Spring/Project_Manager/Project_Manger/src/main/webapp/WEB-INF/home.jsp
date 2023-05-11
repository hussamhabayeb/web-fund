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

<h1> Welcome ${user.firstName}</h1>  <button><a href="/logout">logout</a></button>

<h1>all Projects</h1> <button><a href="/project/new">Add Project</a></button>
<table>
    <thead>
        <tr>
            <th>Projects</th>
            <th>Team lead</th>
            <th>Due Date</th>
            <th>Actions</th>
          
        </tr>
    </thead>
    <tbody>
        <c:forEach var="project" items="${unassignedProjects}">
		<tr>
			<c:if test = "${project.lead.id!=user.id}">
				<td><a href="/projects/${project.id}">${project.title}</a></td>
				<td><c:out value="${project.lead.firstName}"></c:out></td>
				<td><fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></td>
			    <td><a href="/dashboard/join/${project.id}">Join Team</a></td>
		    </c:if>
		</tr>	
		</c:forEach>
    </tbody>
</table>

<h1>your Projects</h1>
<table>
    <thead>
        <tr>
            <th>Projects</th>
            <th>Team lead</th>
            <th>Due Date</th>
            <th>Actions</th>
          
        </tr>
    </thead>
    <tbody>
          <c:forEach var="project" items="${assignedProjects}">
		<tr>
			<td><a href="/projects/${project.id}">${project.title}</a></td>
			<td><c:out value="${project.lead.firstName}"></c:out></td>
			<td><fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></td>
			<c:if test = "${project.lead.id==user.id}">
		       <td><a href="/projects/edit/${project.id}">Edit Project</a></td>
		    </c:if>
		    <c:if test = "${project.lead.id!=user.id}">
		       <td><a href="/dashboard/leave/${project.id}">Leave Team</a></td>
		    </c:if>
		</tr>	
	</c:forEach>
    </tbody>
</table>
</body>
</html>