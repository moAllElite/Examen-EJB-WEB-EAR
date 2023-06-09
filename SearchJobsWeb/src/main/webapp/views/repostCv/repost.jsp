<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add an new resume</title>
 	  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'><link rel="stylesheet" href="ressources/css/styleRegister.css">

		<!-- STYLE CSS -->
		<link rel="stylesheet" href="ressources/css/styleRegister.css">
	</head>
	<body>
		<div class="container">
    <div class="stepwizard">
        <div class="stepwizard-row setup-panel">
            <div class="stepwizard-step">
                <a href="#step-1" type="button" class="btn btn-primary btn-circle">1</a>
                <p>Step 1</p>
            </div>
            <div class="stepwizard-step">
                <a href="#step-2" type="button" class="btn btn-default btn-circle" disabled="disabled">2</a>
                <p>Step 2</p>
            </div>
            <div class="stepwizard-step">
                <a href="#step-3" type="button" class="btn btn-default btn-circle" disabled="disabled">3</a>
                <p>Step 3</p>
            </div>
             <div class="stepwizard-step">
                <a href="#step-4" type="button" class="btn btn-default btn-circle" disabled="disabled">4</a>
                <p>Step 4</p>
            </div>
        </div>
    </div>
    <form role="form" action="Inscription" method="post">
        <div class="row setup-content" id="step-1">
            <div class="col-xs-12">
                <div class="col-md-12">
                    <h3> Step 1</h3>
                    <div class="form-group">
                        <label class="control-label">First Name</label>
                        <input  maxlength="100" type="text" name="nom" required="required" class="form-control" placeholder="Enter First Name"  />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Last Name</label>
                        <input name="prenom" maxlength="100" type="text" required="required" class="form-control" placeholder="Enter Last Name" />
                    </div>
                     <div class="form-group">
                        <label class="control-label">Age</label>
                        <input name="age" maxlength="20" type="number" required="required" class="form-control" placeholder="Enter your age" />
                    </div>
                      <div class="form-group">
                        <label class="control-label">Phone Specialite</label>
                        <input name="telephone" maxlength="30" type="tel"  class="form-control" placeholder="Enter your phone specialite"  required="required"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label"> Address</label>
                        <input name="adresse"maxlength="200" type="text" required="required" class="form-control" placeholder="Enter  Address"  />
                    </div>
                    <button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Next</button>
                </div>
            </div>
        </div>
        <div class="row setup-content" id="step-2">
            <div class="col-xs-12">
                <div class="col-md-12">
                    <h3> Step 2</h3>
                    <div class="form-group">
                        <label class="control-label">Etablissement</label>
                        <input name="ecole" maxlength="30" type="text" required="required" class="form-control" placeholder="Enter your phone specialite" />
                    </div>
                    <div class="form-group">
                        <label class="control-label"> Annee</label>
                        <input name="annee"maxlength="200" type="month" required="required" class="form-control" placeholder="Enter  Address"  />
                    </div>
                  <div class="form-group">
                        <label class="control-label">Niveau d'�tude</label>
                        <input name="niveauEtude" maxlength="200" type="text" required="required" class="form-control" placeholder="Enter skill or skills" />
                    </div>
                    <button class="btn btn-default prevBtn btn-lg pull-left" type="button" >Prev</button>
                    <button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Next</button>
                </div>
            </div>
        </div>
        <div class="row setup-content" id="step-3">
            <div class="col-xs-12">
                <div class="col-md-12">
                    <h3> Step 3</h3>
                    <div class="form-group">
                        <label class="control-label">Nom de l'entreprise</label>
                        <input name="societe" maxlength="200" type="text" required="required" class="form-control" placeholder="Enter skill or skills" />
                    </div>
                    <div class="form-group">
                        <label class="control-label">poste</label>
                        <input name="poste" class="form-control" placeholder="Enter your role  " required="required" ></input>
                        <div class="input-group mb-3">
                           <span class="input-group-text">Date de d�but</span>
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
                    <h3> Step 4</h3>
                 <div class="form-group">
                 <%
                 	Cookie ck[]=request.getCookies();//on recupere les cookies sous formes de liste
			      if(ck!=null){  
			    //  out.println(ck[1].getValue());//on recupere l'email
			      }
                 %>
                        <label class="control-label">Email</label>
                        <input name="email" maxlength="200" type="email"   value='<% out.println(ck[1].getValue());%>'  readonly="readonly" class="form-control" placeholder="${user.email}" />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Password</label>
                        <input name="password" value="${user.password}"     class="form-control" required="required"  placeholder="${user.password}" />
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
<script src='https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.8.3/underscore-min.js'></script><script  src="ressources/js/register.js"></script>

</body>
</html>
	