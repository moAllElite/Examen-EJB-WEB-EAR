<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
	<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Delete Cv</title>
	</head>
	<body>
		<div class="container">	
		<jsp:include page="layout.jsp"></jsp:include>
		<div class="position-relative">
			 <div class="position-absolute top-0 start-50 translate-middle">
			 	<button class="btn btn-danger  " type="submit" ><span class="fa fa-trash"></span>	Delete</button>
			 </div>
			</div>
		
		<form action="DeleteCv" method="post" class="">
			<jsp:include page="form.jsp"></jsp:include>
			
		</form>
		</div>
			
	</body>
</html>