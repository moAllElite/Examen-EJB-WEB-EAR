package com.groupeisi.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
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
import java.util.List;

/**
 * Servlet implementation class Resume
 */
@WebServlet(name = "ResumeServlet", urlPatterns = { "/Resume" })
public class ResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @EJB
       private ICvLocal cvDao;
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
    public ResumeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ,NoResultException{
		 Cookie ck[]=request.getCookies();
		 if(ck==null) {
			 response.sendRedirect("Home");
		 }else {
			
			Formation formation=new Formation();
			 Experience exp=new Experience();
			 //on récupère l'id user depuis la session
	  		int	user_id=Integer.parseInt(ck[2].getValue());
	  	
	  		int cv_id=cvDao.getCvByUserId(user_id).getId();
	  	// Appeler la méthode getCvByUserId de CVDAO pour récupérer le CV de l'utilisateur
	  		Cv cv = cvDao.getCvByUserId(user_id);
	  		
	  		System.out.print(cvDao.getCvByUserId(user_id));
	  		int contact_id=cvDao.get(cv_id,cv).getContact().getId();
	  		int form_id=form_dao.get(cv_id,formation).getCv().getId();
	  		int exp_id=exp_dao.get(cv_id, exp).getCv().getId();
	  		User u=new User();
	  		Contact c=new Contact();
	  		request.setAttribute("contact", contact_dao.get(contact_id, c));
	  	// Ajouter l'objet CV à l'objet de requête pour l'afficher dans index.jsp
			request.setAttribute("cv", cvDao.getCvByUserId(user_id));
			request.setAttribute("forms", form_dao.getFormationByIdCv(cv_id));
			request.setAttribute("exps",exp_dao.getExperiencesByCvId(cv_id));
			request.setAttribute("user", user_dao.get(user_id, u));
	  		try {
	  			//si le cv est detruction on lui demande de crée un nouveau cv
	  			if(cvDao.getCvByUserId(user_id)!=null) {
	  				RequestDispatcher rd=request.getRequestDispatcher("views/resume/show.jsp");
	  				rd.forward(request, response);
	  			} else {
	  				response.sendRedirect("RepostCv");
	  			}
			} catch (NoResultException e) {
				e.printStackTrace();
				e.getMessage();
			}
		 }
	}
	/**
	 * do Post
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie ck[]=request.getCookies();
		 Cv cv=new Cv();
		int	cv_id=Integer.parseInt(ck[2].getValue());
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		
		String datedb=request.getParameter("datedb");
		String datefn=request.getParameter("datefn");
		String poste=request.getParameter("poste");
		String societe=request.getParameter("societe");
		String ville=request.getParameter("ville");
		
		/*cv add*/
		Cv p=new Cv();
		p.setId(cv_id);
	
		/**exp pro*/
		Experience ex=new Experience();	
		List<Experience> exps = new ArrayList<Experience>();
		exps.add(ex);
		ex.setPoste(poste);
		ex.setSociete(societe);
		ex.setVille(ville);
		ex.setDatedb(datedb);
		ex.setDatefn(datefn);
		cv.setExperiences(exps);
		ex.setCv(cv);
		exp_dao.add(ex);
		response.sendRedirect("Resume");
	}

}
