<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>New Project</title>
</head>
<body>

<h2><a href="/home">back to shelve's</a></h2>

<h1>edit a book from your shelve</h1>

<form:form action="/book/edit/${id}" method="post" modelAttribute="book">
  <input type="hidden" name="_method" value="put">
	<table>
	    <thead>
	    	<tr>
	            <td class="float-left"> Title:</td>
	            <td class="float-left">
	            	<form:errors path="title" class="text-danger"/>
					<form:input class="input" path="title" value="${ book1.title}"/>
	            </td>
	        </tr>
	        <tr>
	            <td class="float-left">Author:</td>
	            <td class="float-left">
	            	<form:errors path="author" class="text-danger"/>
					<form:input class="input" path="author" value="${ book1.author}"/>
	            </td>
	        </tr>
	        <tr>
	            <td class="float-left">my thoughts:</td>
	            <td class="float-left">
	            	<form:errors path="thoughts" class="text-danger"/>
					<form:textarea rows="4" class="input" path="thoughts" value="${ book1.thoughts}" />
	            </td>
	        </tr>
	       
	        <form:errors path="user" class="error"/>
			<form:input type="hidden" path="user" value="${userId.id}" class="form-control"/>
	        
			
	        <tr>
	        	<td><a class="linkBtn" href="/dashboard">Cancel</a></td>
	        	<td><input class="input" type="submit" value="Submit"/></td>
	        </tr>
	    </thead>
	</table>
</form:form>
</body>
</html>