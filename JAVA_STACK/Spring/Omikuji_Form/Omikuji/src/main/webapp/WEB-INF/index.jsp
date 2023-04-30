<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  
</head>
<body>
<h1>welcome</h1>

<h1 class = "text-center">Send an Omikuji!</h1>
	<form action="/login" method="POST">
		<div class = "container-md-fluid">
			<div class = "row justify-content-center">
				<div class = "col-5 m-5 p-5 border">
					<h2>Pick any number from 5 to 25</h2>
					<div class="form-floating mb-3">
					  <input type="number" name="number" min="5" max="25" class="form-control" id="floatingInput" placeholder="ex. 10">
					  <label for="floatingInput">Number</label>
					</div>
					<h2>Enter the name of any city.</h2>
					<div class="form-floating mb-3">
					  <input type="text" name="city" class="form-control" id="floatingInput" placeholder="ex. New York">
					  <label for="floatingInput"></label>
					</div>
					<h2>Enter the name of any real person.</h2>
					<div class="form-floating mb-3">
					  <input type="text" name="name" class="form-control" id="floatingInput" placeholder="ex. Joe Hike">
					  <label for="floatingInput"></label>
					</div>
					<h2>Enter a professional endeavor or hobby:</h2>
					<div class="form-floating mb-3">
					  <input type="text" class="form-control" name="hobby" id="floatingInput" placeholder="ex. New York">
					  <label for="floatingInput"></label>
					</div>
					<h2>Enter any type of living thing.</h2>
					<div class="form-floating mb-3">
					  <input type="text" class="form-control" name="animal" id="floatingInput" placeholder="ex. New York">
					  <label for="floatingInput"></label>
					</div>
					<h2>Say something nice someone:</h2>
					<div class="form-floating">
					  <textarea class="form-control" placeholder="Leave a comment here" name="nice" id="floatingTextarea2" style="height: 100px"></textarea>
					  <label for="floatingTextarea2">ex. God bless you.</label>
					</div>
					<input class="btn btn-primary" type="submit" value="Send">
				</div>
			</div>
		</div>
	</form>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
 </body>
</html>