<%@page import="com.groupeisi.controller.UserImpl" %>
<%@page import="com.groupeisi.controller.IUserLocal"%>
<%@page import="javax.persistence.NoResultException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
 	<%@ page errorPage="error.jsp" %>
    <%@ page session="true" import="javax.ejb.*" %>
    <%@page import="javax.ejb.EJB" %>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Authenfication</title>
	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
	<link rel="stylesheet" href="ressources/css/login/style.css">
	</head>
	<body>
	
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
			</div>
		
			<div class="row justify-content-center">
				<div class="col-md-7 col-lg-5">
					<div class="wrap">
						<div class="img" style="background-image: url('ressources/images/bg-1.jpg');" ></div>
						<div class="login-wrap p-4 p-md-5">
						 <%-- Check for error message and display if it exists --%>
						<c:if test="${not empty errorMessage }">
							<div class="alert alert-warning alert-dismissible fade show" role="alert">
							  <strong>
							  ${errorMessage}
							  </strong>
							  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
							</div>
						</c:if>
			      	<div class="d-flex">
			      		<div class="w-100">
			      			<h3 class="mb-4">Sign In</h3>
			      		</div>
								<div class="w-100">
									<p class="social-media d-flex justify-content-end">
										<a href="Home" class="social-icon d-flex align-items-center justify-content-center"><span class="fa fa-home"></span></a>
										<a href="#" class="social-icon d-flex align-items-center justify-content-center"><span class="fa fa-twitter"></span></a>
									</p>
								</div>
			      	</div>
							<form action="Login" class="signin-form" method="post">
			      		<div class="form-group mt-3">
			      			<input type="email" class="form-control"	required="required" name="email">
			      			<label class="form-control-placeholder" for="username" >Email</label>
			      		</div>
		            <div class="form-group">
		              <input id="password-field" type="password" class="form-control" name="password" required="required">
		              <label class="form-control-placeholder" for="password" >Password</label>
		              <span toggle="#password-field"	 class="fa fa-fw fa-eye field-icon toggle-password"></span>
		            </div>
		            <div class="form-group">
		            	<button type="submit" class="form-control btn btn-primary rounded submit px-3">Sign In</button>
		            </div>
		    
		          </form>
		       
		        </div>
		      </div>
				</div>
			</div>
		</div>
	</section>

	<script src="ressources/js/login/jquery.min.js"></script>
  <script src="ressources/js/login/popper.js"></script>
  <script src="ressources/js/login/bootstrap.min.js"></script>
  <script src="ressources/js/login/main.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
	</body>
</html>

