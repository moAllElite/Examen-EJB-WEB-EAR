package com.groupeisi.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class RepostCvServlet
 */
@WebServlet("/RepostCv")
public class RepostCvServlet extends HttpServlet {
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
    public RepostCvServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/repostCv/repost.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String skills=request.getParameter("skills");
		String interets=request.getParameter("interets");
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
		 Cookie ck[]=request.getCookies();
		 //on récupère l'id user depuis la session et l'email
		 int id=Integer.parseInt(ck[2].getValue());
	      if(ck!=null){  
	  		String	emailCurrent=ck[1].getValue();
	  		User currentUser=(User) user_dao.getUserByEmail(emailCurrent);
	  		PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			out.print(ck);
			User u=new User();
			//u.setId(id);
			request.setAttribute("user",user_dao.getUserByEmail(emailCurrent));
			u.setEmail(user_dao.getUserByEmail(emailCurrent).getEmail());
			u.setPassword(user_dao.getUserByEmail(emailCurrent).getPassword());
		}
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
		ex.setDatefn(datefn);
		ex.setCv(p);
		
	
		//on persiste in bd form puis contact et enfin cc
		contact_dao.add(c);
		person_dao.add(p);
		form_dao.add(f);
		exp_dao.add(ex);
		response.sendRedirect("Resume");
	}

}
