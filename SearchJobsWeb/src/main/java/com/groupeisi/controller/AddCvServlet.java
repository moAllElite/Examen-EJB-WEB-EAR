package com.groupeisi.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.ejb.EJB;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DateFormatter;

import com.groupeisi.entities.Contact;
import com.groupeisi.entities.Cv;
import com.groupeisi.entities.Experience;
import com.groupeisi.entities.Formation;
import com.groupeisi.entities.User;

/**
 * Servlet implementation class AddCvServlet
 */
@WebServlet("/Inscription")
public class AddCvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @EJB
       private IContactLocal contact_dao;
       @EJB
       private ICvLocal person_dao;
       @EJB
       private IUserLocal user_dao;
       @EJB
       private IExperienceLocal exp_dao;
       @EJB
       private IFormationLocal form_dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCvServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher r=request.getRequestDispatcher("views/inscription/addCV.jsp");
		r.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NonUniqueResultException {
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String skills=request.getParameter("skills");
		String niveauEtude=request.getParameter("niveauEtude");
		String expPro=request.getParameter("expPro");
		String tel=request.getParameter("telephone");
		String password=request.getParameter("password");
		String adresse=request.getParameter("adresse");
		String email=request.getParameter("email");
		String ecole=request.getParameter("ecole");
		String annee=request.getParameter("annee");
		String niveau=request.getParameter("niveauEtude");
		String datedb=request.getParameter("datedb");
		String datefn=request.getParameter("datefn");
		String poste=request.getParameter("poste");
		String societe=request.getParameter("societe");
		String ville=request.getParameter("ville");
		String interets=request.getParameter("interets");
		/**user add*/
		User u=new User();
		u.setEmail(email);
		u.setPassword(password);
		
		try {
			if(user_dao.getUserByEmail(email)==null) {
				/*cv add*/
				Cv p=new Cv();
				p.setNom(nom);
				p.setPrenom(prenom);
				p.setSkills(skills);
				p.setInterets(interets);
			
				/*contact add*/
				Contact c=new Contact();
				c.setAdresse(adresse);
				c.setTelephoneSpecialite(tel);
				
				//user 
				p.setUser(u);
				p.setContact(c);
				
				Formation f=new Formation();
				//**formation add*/
				f.setEcole(ecole);
				f.setAnnee(annee);
				f.setNiveauEtude(niveau);
				f.setCv(p);
				
				/**exp pro*/
				Experience ex=new Experience();
				ex.setPoste(poste);
				ex.setSociete(societe);
				ex.setVille(ville);
				ex.setDatedb(datedb);
				ex.setCv(p);
				p.getExperiences().add(ex);
				ex.setDatefn(datefn);
				
				//on persiste in bd user puis contact et enfin person
				user_dao.add(u);
				contact_dao.add(c);
				person_dao.add(p);
				form_dao.add(f);
				exp_dao.add(ex);
				//request.setAttribute("cv", user_dao);
				response.sendRedirect("Login");
			}else {
				
				request.setAttribute("errorMessage", "Email déjà attribué !!!");
				request.getRequestDispatcher("views/inscription/addCV.jsp").forward(request, response);
			}
		}catch (NonUniqueResultException  |NullPointerException | NoResultException e) {
			e.getMessage();
		}
		
	}

}
