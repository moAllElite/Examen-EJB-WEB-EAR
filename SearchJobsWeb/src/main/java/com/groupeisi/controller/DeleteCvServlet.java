package com.groupeisi.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import com.groupeisi.entities.Contact;
import com.groupeisi.entities.Cv;
import com.groupeisi.entities.Experience;
import com.groupeisi.entities.Formation;
import com.groupeisi.entities.User;

/**
 * Servlet implementation class DeleteCvServlet
 */
@WebServlet("/DeleteCv")
public class DeleteCvServlet extends HttpServlet {
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
    public DeleteCvServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 Cookie ck[]=request.getCookies();
		 Cv cv=new Cv();
		Formation formation=new Formation();
		 Experience exp=new Experience();
		 //on récupère l'id user depuis la session qui sous format liste=[id_session,user_id,email]
  		int	user_id=Integer.parseInt(ck[1].getValue());
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
    	request.getRequestDispatcher("/views/edit/delete.jsp").forward(request, response);
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Cookie ck[]=request.getCookies();
		 Cv cv=new Cv();
		Formation formation=new Formation();
		 Experience exp=new Experience();
		 //on récupère l'id user depuis la session
  		int	user_id=Integer.parseInt(ck[1].getValue());
  		int cv_id= cv_dao.getCvByUserId(user_id).getId();
  		User u=new User();
  		int contact_id=cv_dao.get(cv_id,cv).getContact().getId();
  		int form_id=form_dao.get(cv_id,formation).getCv().getId();
  		int exp_id=exp_dao.get(cv_id, exp).getCv().getId();
  		
  		Contact c=new Contact();
  		Formation f=new Formation();
  		Experience ex=new Experience();
  		request.setAttribute("user", user_dao.get(user_id, u));
		request.setAttribute("contact", contact_dao.get(contact_id, c));
		request.setAttribute("cv", cv_dao.get(cv_id,cv));
		request.setAttribute("form", form_dao.get(form_id, formation));
		request.setAttribute("exp",exp_dao.get(exp_id, exp) );
    
  		/**
  		 * suppression
  		 */
		exp_dao.delete(exp_id, ex);
		form_dao.delete(form_id, f);
  		cv_dao.delete(cv_id, cv);
  		contact_dao.delete(contact_id, c);	
  		response.sendRedirect("RepostCv");
	}

}
