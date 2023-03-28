<%@page import="javax.persistence.NoResultException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true" %>
<!Doctype>
<html>
   <head>
      <title>Show Error Page</title>
   </head>
   <body>
   <nav class="navbar navbar-expand-lg bg-primary" data-bs-theme="dark">
				 <div class="container-fluid">
				    <a class="navbar-brand" href="Error">Search Jobs</a>
				    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
				      <span class="navbar-toggler-icon"></span>
				    </button>
				    <div class="collapse navbar-collapse" id="navbarText">
				      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
				        <li class="nav-item">
				          <a class="nav-link active" aria-current="page" href="Home">Home</a>
				        </li>
				        <li class="nav-item">
				          <a class="nav-link" href="Inscription">Inscription</a>
				        </li>
				        <li class="nav-item">
				          <a class="nav-link" href="Login">Sign In</a>
				        </li>
				      </ul>
				      <button class="btn btn-danger "  disabled="disabled">Logout</button>
				    </div>
				  </div>
			</nav>
      <h1>Opps...</h1>
      <p>Sorry, an error occurred.</p>
      <p>Here is the exception stack trace: </p>
      <pre><%= exception.getMessage() %></pre>
      <pre><%=exception.getClass().getName() %></pre>
   </body>
</html>