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
   <h1>In <c:out value="${number}"/> , you will live in 
   <c:out value="${city}"/> with <c:out value="${name}"/>
   as your room mate ,<c:out value="${hobby}"/> for a living .
   the next time you see <c:out value="${animal}"/> , you will have a good luck 
   .<c:out value="${nice}"/>
   </h1>

</body>
</html>