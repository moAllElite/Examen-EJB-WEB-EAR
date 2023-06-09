<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib	uri ="http://java.sun.com/jsp/jstl/core" 	prefix="c"%>

<!DOCTYPE html>
<html id="html">
	<head>
		<meta charset="ISO-8859-1">
			<link rel="stylesheet/css" href="ressources/css/resume/popup.css" type="text/css">
		<link href='https://fonts.googleapis.com/css?family=Lato:400,300,700' rel='stylesheet' type='text/css'>
		 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
		<title>Resume</title>
		<link href="ressources/css/resume/show.css" rel="stylesheet" type='text/css'>
		 <!-- our project just needs Font Awesome Solid + Brands -->
  <link href="ressources/fontawesome/css/fontawesome.css" rel="stylesheet">
  <link href="ressources/fontawesome/css/brands.css" rel="stylesheet">
  <link href="ressources/fontawesome/css/solid.css" rel="stylesheet">
	</head>
	<body>
		<nav class="navbar navbar-expand-lg bg-primary" data-bs-theme="dark">
				 <div class="container-fluid">
				    <a class="navbar-brand" href="#">
				    	<i class="fa-solid fa-briefcase"></i>
				    	Search Jobs
				    </a>
				    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
				      <span class="navbar-toggler-icon"></span>
				    </button>
				    <div class="collapse navbar-collapse" id="navbarText">
				      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
				        <li class="nav-item">
				          <a class="nav-link active" aria-current="page" href="#">
				          	<i class="fa-solid fa-house"></i>
				          		Home
				          </a>
				        </li>
				       <li class="nav-item">
				          <a class="nav-link" href="Resume">
				          <i class="fa-solid fa-eye"></i>
				         	Visualize Resume
				          </a>
				        </li>
				        <li class="nav-item">
				          <a class="nav-link " href="EditCv?id=<c:out value='${cv.id}'></c:out>">
				          	<i class="fa-sharp fa-solid fa-pen-fancy"></i>
				          	Edit Resume
				          </a>
				        </li>
				         <li class="nav-item">
				          <a class="nav-link" href="pdf">
				          	<i class="fa-sharp fa-solid fa-download"></i>
				          	Download Resume
				          </a>
				        </li>
				         <li class="nav-item">
				          <a class="nav-link" href="DeleteCv">
				          	<i class="fa-sharp fa-regular fa-trash"></i>
				          	Remove Resume
				          </a>
				        </li>
				        
				         <li class="nav-item">
				          <a href="#target-content" class="nav-link">
				          <i class="fa-sharp fa-regular fa-plus"></i>
				          Add Experience</a>
				        </li>
				      </ul>
				      <a class="btn btn-danger " href="Logout" >
				      	<i class="fa-solid fa-arrow-right-from-bracket"></i>
				      	Sign out
				      </a>
				    </div>
				  </div>
			</nav>
			
			
	
			<div class="container">
				  <div class="header">
				    <div class="full-name">
				      <span class="first-name" name="nom">${cv.nom}</span> 
				      <span class="last-name"  name="prenom">${cv.prenom}</span>
				    </div>
				    <div class="contact-info">
				      <span class="email">Email: </span>
				      <span class="email-val"  >${user.email}
				
				      </span>
				      <span class="separator"></span>
				      <span class="phone">Phone: </span>
				      <span class="phone-val">+221	${contact.telephoneSpecialite}</span>
				       <span class="separator"></span>
				       <span class="phone">Adresse: </span>
				       <span class="phone-val">	${contact.adresse}</span>
				    </div>
				    
				    <div class="details">
					    <div class="section">
					      <div class="section__title">Experience professionnel</div>
					           <c:forEach var="exp" items="${ exps}">
						     	 	<div class="section__list">
								        <div class="section__list-item">
									          <div class="left">
										            <div class="name" style="text-transform:uppercase">	${exp.societe}</div>
										            <div class="addr">${exp.ville}</div>
										            <div class="duration">${exp.datedb}	/	${exp.datefn}</div>
									          </div>
									           <div class="right">
											          <div class="name" style="text-transform: capitalize;">${exp.poste}</div>      
											    </div>
										 </div>
						      			</div>
					      		  </c:forEach>
					      </div>
					      
				      <div class="section">
				      <div class="section__title">Education</div>
				      <div class="section__list">
				      <c:forEach var="form" items="${forms}">
				        <div class="section__list-item">
				          <div class="left">
				            <div class="name" style="text-transform:uppercase">${form.ecole}</div>
				            <div class="addr">${form.niveauEtude}</div>
				            <div class="duration">${form.annee}</div>
				          </div>
				          </div>
					</c:forEach>
				 
				   <div class="section">
				       <div class="section__title">Skills</div>
				       <div class="skills">
				    
				       <div class="skills__item">
				           <div class="left"><div class="name" style="text-transform: capitalize;">
				             ${cv.skills}</div></div>
				           <div class="right">
				                          <input  id="ck1" type="checkbox" checked/>
				
				             <label for="ck1"></label>
				                          <input id="ck2" type="checkbox" checked/>
				
				              <label for="ck2"></label>
				                         <input id="ck3" type="checkbox" />
				
				              <label for="ck3"></label>
				                           <input id="ck4" type="checkbox" />
				            <label for="ck4"></label>
				                          <input id="ck5" type="checkbox" />
				              <label for="ck5"></label>
				
				           </div>
				         </div>
				         
				       </div>
				
				     <div class="section">
				     <div class="section__title">
				       Interests
				       </div>
				       <div class="section__list">
				         <div class="section__list-item" style="text-transform:capitalize; ">
				                 ${cv.interets}
				          </div>
				       </div>
				     </div>
				     </div>
				  </div>
				</div>
				</div>
				</div>
				</div>
				
			
				<!-- Modal popup -->
				
				<div id="target-content">
					  <a href="#" class="close"></a>
					  
											
						 	 <form action="Resume" method="post">
							  	<jsp:include page="popup.jsp"></jsp:include>
					  		  </form> 
				
					
									
			</div>
		
				
			<style>
				#target-content {
  position: fixed;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  pointer-events: none;
  opacity: 0;
  transition: opacity 200ms; }
  #target-content:target {
    pointer-events: all;
    opacity: 1; }
  #target-content #target-inner {
    position: absolute;
    display: block;
    padding: 48px;
    line-height: 1.8;
    width: 70%;
    top: 50%;
    left: 50%;
    transform: translateX(-50%) translateY(-50%);
    box-shadow: 0px 12px 24px rgba(0, 0, 0, 0.2);
    background: white;
    color: #34495E; }
    #target-content #target-inner h2 {
      margin-top: 0; }
    #target-content #target-inner code {
      font-weight: bold; }
  #target-content a.close {
    content: '';
    position: absolute;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    background-color: #34495E;
    opacity: 0.5;
    transition: opacity 200ms; }
    #target-content a.close:hover {
      opacity: 0.4; }

body {
  background-color: #ECF0F1;
  color: #444; }

#button {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translateX(-50%) translateY(-50%);
  padding: 16px 24px;
  border-radius: 1px;
  text-decoration: none;
  font-size: 24px;
  display: block;
  color: white;
  background-color: #34495E;
  text-align: center;
  font-weight: 100;
  transition: box-shadow 200ms;
  border-radius: 4px; }
  #button:hover {
    box-shadow: 0px 12px 24px rgba(0, 0, 0, 0.2); }
				
				
			</style>
			
		
	
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	</body>
	</html>