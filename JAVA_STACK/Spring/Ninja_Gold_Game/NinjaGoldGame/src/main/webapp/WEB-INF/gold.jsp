<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
<div class="input-group input-group-sm mb-3 w-25 mx-auto mt-2">
  <span class="input-group-text" id="inputGroup-sizing-sm">Your Gold</span>
  <input type="text" name="gold" value="${gold}" class="form-control" readonly>
  
</div>
 <a class="btn btn-primary" href="/rest">rest</a>
<div class="container">
  <div class="row row-cols-4">
    <div class="col border">
    <form method="post" action="/form">
    <h2>Farm</h2>
    <h3>(earns 10-20 gold)</h3>
    <input type="hidden" name="custom" value="1"><br><br>
    <input type="submit" value="Find Gold!">
</form>
    </div>
    <div class="col border">
    <form method="post" action="/form">
    <h2>cave</h2>
    <h3>(earns 10-20 gold)</h3>
    <input type="hidden" name="custom" value="2"><br><br>
    <input type="submit" value="Find Gold!">
</form>
    </div>
    <div class="col border">
    <form method="post" action="/form">
    <h2>house</h2>
    <h3>(earns 10-20 gold)</h3>
    <input type="hidden" name="custom" value="3"><br><br>
    <input type="submit" value="Find Gold!">
</form>
    </div>
    <div class="col border">
    <form method="post" action="/form">
    <h2>quest</h2>
    <h3>(earns 10-20 gold)</h3>
    <input type="hidden" name="custom" value="4"><br><br>
    <input type="submit" value="Find Gold!">
</form>
    </div>
    
  </div>
 
</div>
<div class="w-75 mx-auto border border-3">
${message}
</div>

</body>
</html>