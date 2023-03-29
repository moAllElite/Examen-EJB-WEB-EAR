<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add an new resume</title>
 	  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'><link rel="stylesheet" href="ressources/css/styleRegister.css">

		<!-- STYLE CSS -->
		<link rel="stylesheet" href="ressources/css/styleRegister.css">
		<link rel="stylesheet" href="ressources/css/alert.css">	
	</head>
	<body>
		<div class="container">
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
                <p>Expériences professionelles</p>
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
        <div class="row setup-content" id="step-1">
            <div class="col-xs-12">
                <div class="col-md-12">
                <h3> Informations personnelles</h3>
			                    <div class="form-group">
			                        <label class="control-label">Nom</label>
			                        <input  maxlength="100" type="text" name="nom" required="required" class="form-control" placeholder="Entrer votre nom"  />
			                    </div>
			                    <div class="form-group">
			                        <label class="control-label">prénom</label>
			                        <input name="prenom" maxlength="100" type="text" required="required" class="form-control" placeholder="Entrer votre prénom" />
			                    </div>
			                     <div class="form-group">
			                        <label class="control-label">Centres d'intérêts</label>
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
			             <a class="btn btn-default prevBtn btn-lg pull-left" href="Home" >Home</a>
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
			                        <label class="control-label"> Année</label>
			                        <input name="annee"maxlength="200" type="month" required="required" class="form-control" placeholder="Enter  Address"  />
			                    </div>
			                  <div class="form-group">
			                  	<label class="control-label " for="education">Niveau d'étude</label>
									<select id="education"  name="niveauEtude" required="required" class="form-control">
									  <option value="bac+5">Bac+5 or higher</option>
									  <option value="bac+4">Bac+4</option>
									  <option value="bac+3">Bac+3</option>
									  <option value="bac+2">Bac+2</option>
									  <option value="bac+1">Bac+1</option>
									  <option value="bac">Bac</option>
									</select>
						</div>
					
                    <button class="btn btn-default prevBtn btn-lg pull-left" type="button" >Prev</button>
                    <button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Next</button>
                </div>
            </div>
        </div>
        <div class="row setup-content" id="step-3">
            <div class="col-xs-12">
                <div class="col-md-12">
                    <h3> Experiences professionnelles</h3>
                    <div class="form-group">
                        <label class="control-label">Nom de l'entreprise</label>
                        <input name="societe" maxlength="200" type="text" required="required" class="form-control" placeholder="Enter skill or skills" />
                    </div>
                    <div class="form-group">
                        <label class="control-label">poste</label>
                        <input name="poste" class="form-control" placeholder="Enter your role  " required="required" ></input>
                        <div class="input-group mb-3">
                           <span class="input-group-text">Date de début</span>
	                        <input name="datedb" class="form-control" placeholder="Enter your debut date  "  type="month" required="required"></input>
	                       <span class="input-group-text">Date fin</span>
	                        <input name="datefn" class="form-control"  type="month" required="required" ></input>
	                    </div>
	                    <label class="control-label">Ville</label>
                        <input  name="ville" type="text" class="form-control" required="required"/>
                    </div>
                    <button class="btn btn-default prevBtn btn-lg pull-left" type="button" >Prev</button>
                    <button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Next</button>
                </div>
            </div>
        </div>
        <div class="row setup-content" id="step-4">
        <div class="col-xs-12">
            <div class="col-md-12">
                    <h3> Identifiants</h3>
                 <div class="form-group">
              
                        <label class="control-label">Email</label>
                        <input name="email" maxlength="200" type="email"    class="form-control" placeholder="email" />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Password</label>
                        <input name="password"  type="password"   class="form-control" required="required"  placeholder="password" />
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
		<script type="text/javascript" src="ressources/js/alert.js"></script>
  <script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.8.3/underscore-min.js'></script><script  src="ressources/js/register.js"></script>

</body>
</html>
	
