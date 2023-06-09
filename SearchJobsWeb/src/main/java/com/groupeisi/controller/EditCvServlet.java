package com.groupeisi.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.entities.Contact;
import com.groupeisi.entities.Cv;
import com.groupeisi.entities.Experience;
import com.groupeisi.entities.Formation;
import com.groupeisi.entities.User;

/**
 * Servlet implementation class EditCvServlet
 */
@WebServlet("/EditCv")
public class EditCvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @EJB
     private ICvLocal cv_dao;
     @EJB
     private IContactLocal contact_dao;
     @EJB
     private IExperienceLocal exp_dao;
     @EJB
     private IFormationLocal form_dao;
     @EJB
     private IUserLocal user_dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCvServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Cookie ck[]=request.getCookies();
		 Cv cv=new Cv();
		Formation formation=new Formation();
		 Experience exp=new Experience();
		 //on récupère l'id user depuis la session
  		int	user_id=Integer.parseInt(ck[2].getValue());
  		User u=new User();
  		int contact_id=cv_dao.get(user_id,cv).getContact().getId();
  		int form_id=form_dao.get(user_id,formation).getCv().getId();
  		int exp_id=exp_dao.get(user_id, exp).getCv().getId();
  		
  		Contact c=new Contact();
  		request.setAttribute("user", user_dao.get(user_id, u));
		request.setAttribute("contact", contact_dao.get(contact_id, c));
		request.setAttribute("cv", cv_dao.get(user_id,cv));
		request.setAttribute("form", form_dao.get(form_id, formation));
		request.setAttribute("exp",exp_dao.get(exp_id, exp) );
		request.getRequestDispatcher("views/edit/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//cv
		int cv_id=Integer.parseInt(request.getParameter("cv_id"));
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String interets=request.getParameter("interets");
		String skills=request.getParameter("skills");
		
		//user
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		
		// formation
		int f_id=Integer.parseInt(request.getParameter("ecole_id"));
		String niveauEtude=request.getParameter("niveauEtude");
		String expPro=request.getParameter("expPro");
		String ecole=request.getParameter("ecole");
		String annee=request.getParameter("annee");
		
		//exp
		int exp_id=Integer.parseInt(request.getParameter("exp_id"));
		String niveau=request.getParameter("niveauEtude");
		String datedb=request.getParameter("datedb");
		String datefn=request.getParameter("datefn");
		String poste=request.getParameter("poste");
		String societe=request.getParameter("societe");
		String ville=request.getParameter("ville");
		
		//contact
		int c_id=Integer.parseInt(request.getParameter("contact_id"));
		String adresse=request.getParameter("adresse");
		String tel=request.getParameter("telephone");
		
		/**user add*/
		User u=new User();
		u.setId(user_id);
		u.setEmail(email);
		u.setPassword(password);
		/*contact add*/
		Contact c=new Contact();
		c.setId(c_id);
		c.setAdresse(adresse);
		c.setTelephoneSpecialite(tel);
		/*cv update*/
		Cv cv=new Cv();
		cv.setId(cv_id);
		cv.setNom(nom);
		cv.setPrenom(prenom);
		cv.setInterets(interets);
		cv.setUser(u);
		cv.setContact(c);
		cv.setSkills(skills);
		
		Formation f=new Formation();
		//**formation add*/
		f.setId(f_id);
		f.setEcole(ecole);
		f.setAnnee(annee);
		f.setNiveauEtude(niveau);
		f.setCv(cv);
		
		/**exp pro*/
		Experience ex=new Experience();
		ex.setId(exp_id);
		ex.setPoste(poste);
		ex.setSociete(societe);
		ex.setVille(ville);
		ex.setDatedb(datedb);
		ex.setDatefn(datefn);
		ex.setCv(cv);
		
	
		//on persiste in bd user puis contact et enfin person
		contact_dao.update(c);
		cv_dao.update(cv);
		user_dao.update(u);
		form_dao.update(f);
		exp_dao.update(ex);
		response.sendRedirect("Resume");
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


}
