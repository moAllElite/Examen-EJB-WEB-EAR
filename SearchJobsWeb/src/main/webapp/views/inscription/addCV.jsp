<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Inscription</title>
		<link rel="stylesheet/css" href="ressources/css/resume/popup.css" type="text/css">
		<link href='https://fonts.googleapis.com/css?family=Lato:400,300,700' rel='stylesheet' type='text/css'>
		 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	 	  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'><link rel="stylesheet" href="ressources/css/styleRegister.css">
		<link rel="stylesheet" href="ressources/css/alert.css">
		
		<!-- STYLE CSS -->
		<link rel="stylesheet" href="ressources/css/styleRegister.css">
	</head>
	<body>
		<div class="container">
    <div class="stepwizard">
        <div class="stepwizard-row setup-panel">
        			 
            <div class="stepwizard-step">
                <a href="#step-1" type="button" class="btn btn-primary btn-circle">1</a>
                <p>Infromations personnelles</p>
            </div>
            <div class="stepwizard-step">
                <a href="#step-2" type="button" class="btn btn-default btn-circle" disabled="disabled">2</a>
                <p>Formations</p>
            </div>
            <div class="stepwizard-step">
                <a href="#step-3" type="button" class="btn btn-default btn-circle" disabled="disabled">3</a>
                <p>Exp�riences professionelles</p>
            </div>
             <div class="stepwizard-step">
                <a href="#step-4" type="button" class="btn btn-default btn-circle" disabled="disabled">4</a>
                <p>Identifiants</p>
            </div>
        </div>
    </div>
    <%-- Check for error message and display if it exists --%>
						<c:if test="${not empty	errorMessage}">
							<div class="alert warning">
								<span class='alert-close' onclick="this.parentElement.style.display='none';">&times;</span>
								<b>Warning</b><br>
								<ul><li>  ${errorMessage}</li></ul>
							</div>
						</c:if>
						
			
		    <form role="form" action="Inscription" method="post">
		    	<header>	
			        <div class="row setup-content" id="step-1">
			            <div class="col-xs-12">
			                <div class="col-md-12">
			                    <h3> Informations personnelles</h3>
			                    <div class="form-group">
			                        <label class="control-label">Nom</label>
			                        <input  maxlength="100" type="text" name="nom" required="required" class="form-control" placeholder="Entrer votre nom"  />
			                    </div>
			                    <div class="form-group">
			                        <label class="control-label">pr�nom</label>
			                        <input name="prenom" maxlength="100" type="text" required="required" class="form-control" placeholder="Entrer votre pr�nom" />
			                    </div>
			                     <div class="form-group">
			                        <label class="control-label">Centres d'int�r�ts</label>
			                        <textarea name="interets" maxlength="200" type="text" required="required" class="form-control" placeholder="Football,lutte" ></textarea>
			                    </div>
			                   
			                      <div class="form-group">
			                        <label class="control-label">Phone Specialite</label>
			                        <input name="telephone" maxlength="30" type="tel"  class="form-control" placeholder="Enter your phone specialite"  required="required"/>
			                    </div>
			                    <div class="form-group">
			                        <label class="control-label"> Adresse</label>
			                        <input name="adresse"maxlength="200" type="text" required="required" class="form-control" placeholder="Enter  Address"  />
			                    </div>
			                    <button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Next</button>
			                </div>
			            </div>
			        </div>
			        <div class="row setup-content" id="step-2">
			            <div class="col-xs-12">
			                <div class="col-md-12">
			                    <h3> Formations</h3>
			                    <div class="form-group">
			                        <label class="control-label">Etablissement</label>
			                        <input name="ecole" maxlength="30" type="text" required="required" class="form-control" placeholder="Enter your phone specialite" />
			                    </div>
			                    <div class="form-group">
			                        <label class="control-label"> Ann�e</label>
			                        <input name="annee"maxlength="200" type="month" required="required" class="form-control" placeholder="Enter  Address"  />
			                    </div>
			                  <div class="form-group">
			                  	<label class="control-label " for="education">Niveau d'�tude</label>
									<select id="education"  name="niveauEtude" required="required" class="form-control">
									  <option value="bac+5">Bac+5 or higher</option>
									  <option value="bac+4">Bac+4</option>
									  <option value="bac+3">Bac+3</option>
									  <option value="bac+2">Bac+2</option>
									  <option value="bac+1">Bac+1</option>
									  <option value="bac">Bac</option>
									</select>
			                  	
			                        
			                      <!--  <input  maxlength="200" type="text"  class="form-control" placeholder="Enter skill or skills" /> --> 
			                    </div>
			                      <div class="form-group">
			                        <label class="control-label">Comp�tences</label>
			                        <textarea name="skills" type="text" class="form-control" placeholder="Enter your skills" required="required" ></textarea>
			                    </div>
			                    
			                    <button class="btn btn-default prevBtn btn-lg pull-left" type="button" >Prev</button>
			                    <button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Next</button>
			                </div>
			            </div>
			        </div>
			        <div class="row setup-content" id="step-3">
			            <div class="col-xs-12">
			                <div class="col-md-12">
			                    <h3> Exp�riences professionnelles</h3>
			                     
					          	</div>
					          </div>
					     </div>
					          	
			                    <div class="form-group">
			                        <label class="control-label">Nom de l'entreprise</label>
			                        <input name="societe" maxlength="200" type="text" required="required" class="form-control" placeholder="Enter skill or skills" />
			                    </div>
			                    <div class="form-group">
			                        <label class="control-label">poste</label>
			                        <input name="poste" class="form-control" placeholder="Enter your role  " required="required" ></input>
			                       <div class="input-group mb-3">
										  <div class="input-group-prepend">
										    <span class="input-group-text" id="basic-addon1" style="font-size: 14px;">Date de d�but</span>
				                        <input name="datedb" style="width: 30%;" class="form-control" aria-describedby="basic-addon1" type="month" required="required"></input>
				                    </div>   
				                   <div class="input-group mb-3">
										  <div class="input-group-prepend">
										    <label class="input-group-text" id="basic-addon2" style="font-size: 14px;">Date de fin</label>
				                       
				                        <input name="datefn" class="form-control"  style="width: 30%;"  aria-describedby="basic-addon2" type="month" required="required" ></input>
				                    </div>
				                    </div>
				                 <div class="form-group">
				                    <label class="control-label">Ville</label>
			                        <input  name="ville" type="text" class="form-control" required="required"/>
			                    </div>
			                    <button class="btn btn-default prevBtn btn-lg pull-left mt-4" type="button" >Prev</button>
			                    
			                    <button class="btn btn-primary nextBtn btn-lg pull-right mt-4" type="button" >Next</button>
			                </div>
			            </div>
			        </div>
			        <div class="row setup-content" id="step-4">
			        <div class="col-xs-12">
			            <div class="col-md-12">
			                    <h3> Identifiants </h3>
			                   <div class="form-group">
			                        <label class="control-label">Email</label>
			                        <input name="email" maxlength="200" type="email" required="required" class="form-control" placeholder="Enter email" />
			                    </div>
			                    <div class="form-group">
			                        <label class="control-label">Password</label>
			                        <input name="password" class="form-control" placeholder="Enter your password" type="password"	required="required" />
			                    </div> 
			                    <button class="btn btn-default prevBtn btn-lg pull-left" type="button" >Prev</button>
			                    <button class="btn btn-success btn-lg pull-right" type="submit">Finish!</button>
			                </div>
			            </div>
			        </div>
			    
		    </form>
		    </div>
		    
	

		
		
				<!-- JQUERY STEP -->
				<!-- partial -->
		  <script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>
		<script src='https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.8.3/underscore-min.js'></script>
		<script  src="ressources/js/register.js"></script>
		
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>	
</body>
</html>
	