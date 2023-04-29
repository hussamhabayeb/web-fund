<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<table>
<tr>

	<th>name</th>
	<th>price</th>

</tr>
     			 
    	<c:forEach var="oneDojo" items="${MyController}">	
		<tr>	
			<td><c:out value="${oneDojo.name}"></c:out></td>
			<td><c:out value="${oneDojo.price}"></c:out></td>	
		</tr>
    </c:forEach>
    
    
    
</table>

</body>
</html>