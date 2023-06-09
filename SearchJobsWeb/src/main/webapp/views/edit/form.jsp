<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	  <div class="row setup-content" id="step-1">
            <div class="col-xs-12">
                <div class="col-md-12">
                    <h3> Step 1</h3>
                       <div class="form-group">
                        <label class="control-label">Cv Id</label>
                        <input value='${cv.id}'  type="number" name="cv_id" readonly="readonly" class="form-control" placeholder="Enter First Name"  />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Pr�nom</label>
                        <input value='${cv.prenom}'  type="text" name="nom" required="required" class="form-control" placeholder="Enter First Name"  />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Nom</label>
                        <input name="prenom" value='${ cv.nom}' type="text" required="required" class="form-control" placeholder="Enter Last Name" />
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
                        <label class="control-label">Etablissement Id</label>
                        <input name="ecole_id" value='${form.id}'	type="number" readonly="readonly"	required="required" class="form-control" placeholder="Enter your phone specialite" />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Etablissement</label>
                        <input name="ecole" value='${form.ecole}'	type="text" required="required" class="form-control" placeholder="Enter your phone specialite" />
                    </div>
                    <div class="form-group">
                        <label class="control-label"> Annee</label>
                        <input name="annee" value='${form.annee}' type="month" required="required" class="form-control" placeholder="Enter  Address"  />
                    </div>
                  <div class="form-group">
                       <label class="control-label " for="education">Niveau d'�tude</label>
						<select id="education"  name="niveauEtude" required="required" class="form-control">
						  <option value="${form.niveauEtude}">${form.niveauEtude}</option>
						  <option value="bac+5">Bac+5 or higher</option>
						  <option value="bac+4">Bac+4</option>
						  <option value="bac+3">Bac+3</option>
						  <option value="bac+2">Bac+2</option>
						  <option value="bac+1">Bac+1</option>
						  <option value="bac">Bac</option>
						</select>
					</div>
					  <div class="form-group">
                        <label class="control-label"> 	Comp�tences</label>
                            <textarea name="skills" class="form-control"  required="required" >${cv.skills} </textarea>
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
                        <label class="control-label">Experience Id</label>
                        <input name="exp_id" value='${exp.id}' type="text" readonly="readonly" class="form-control" placeholder="Enter skill or skills" />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Nom de l'entreprise</label>
                        <input name="societe" value='${exp.societe}' type="text" required="required" class="form-control" placeholder="Enter skill or skills" />
                    </div>
                    <div class="form-group">
                        <label class="control-label">poste</label>
                        <input name="poste" class="form-control" value='${exp.poste}' required="required" ></input>
                    </div>
                     <div class="form-group mb-3">     
                        <label class="control-label">Ville</label>
	                        <input name="ville" class="form-control" value="${exp.ville}"	type="text"  required="required"></input>
	                 </div>
	                  
	                  <div class="form-group mb-3">     
	                      <label class="control-label m-3" >Date de d�but<label>
	                    <input name="datefn" class="form-control m-3" value='${exp.datedb}'  type="month" required="required" ></input>
					</div>
					   <div class="form-group">	
						<label class="control-label m-3" >Date fin<label>
                        <input   name="datedb" type="month"	class="form-control m-3" value='${exp.datefn}'	 required="required"></input>
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
                        <label class="control-label">Centres d'int�r�ts</label>
                        <textarea name="interets" required="required" class="form-control" placeholder="Football,lutte" >${cv.interets}</textarea>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Contact id</label>
                        <input name="contact_id" value='${contact.id}' type="id" readonly="readonly"  class="form-control" placeholder="Enter your phone specialite"  required="required"/>
                    </div>
                      <div class="form-group">
                        <label class="control-label">Phone Specialite</label>
                        <input name="telephone" value='${contact.telephoneSpecialite}' type="tel"  class="form-control" placeholder="Enter your phone specialite"  required="required"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label"> Address</label>
                        <input name="adresse" value='${contact.adresse }' type="text" required="required" class="form-control" placeholder="Enter  Address"  />
                    </div>
                    <button class="btn btn-default prevBtn btn-lg pull-left" type="button" >Prev</button>
                    <button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Next</button>
                </div>
            </div>
        </div>
        <div class="row setup-content" id="step-5">
        <div class="col-xs-12">
            <div class="col-md-12">
                    <h3> Step 5</h3>
                       <div class="form-group">
                        <label class="control-label">User Id</label>
                        <input name="user_id" maxlength="200" type="number"   value='${user.id}'  readonly="readonly" class="form-control" placeholder="${user.id}" />
                    </div>
                   <div class="form-group">
                        <label class="control-label">Email</label>
                        <input name="email" maxlength="200" type="email"   value='${user.email}'  readonly="readonly" class="form-control" placeholder="${user.email}" />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Password</label>
                        <input name="password"    value='${user.password}'  class="form-control" required="required"  placeholder="${user.password}" />
                    </div> 
                    <button class="btn btn-default prevBtn btn-lg pull-left" type="button" >Prev</button>
                    <button class="btn btn-success btn-lg pull-right" type="submit">Edit!</button>
                </div>
            </div>
        </div>
</body>
</html>