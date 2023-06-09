package com.groupeisi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.groupeisi.entities.Cv;
import com.groupeisi.entities.User;

/**
 * Servlet implementation class LoginServlet
 */
@Entity
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
 
	@EJB
       private IUserLocal user_dao;
     @EJB
     private ICvLocal cv_dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/authenfication/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User u=new User();
		String email=request.getParameter("email");//on récupere les infos des champs avec la propriété namedans login.jsp
		String password=request.getParameter("password");
	
        // Check if the username and password are valid
		try {
			if(user_dao.getConnection(email, password)!=null) {
				//on récupere les infos du current user et puis on fait un getId()
				//on récupère l'email du user 
				User currentUser=(User) user_dao.getUserByEmail(email);
				HttpSession session=request.getSession(true);
				int id=currentUser.getId();
				session.setAttribute("user_id",id);
				session.setAttribute("email", email);
				Cv currentCv=cv_dao.getCvByUserId(id);
				Cookie idUser=new Cookie("user_id",String.valueOf(id));
				Cookie emailUser=new Cookie("email",currentUser.getEmail());
				response.addCookie(idUser);
				response.addCookie(emailUser);
				idUser.setMaxAge(30*18*60);
				emailUser.setMaxAge(30*18*60);
				if(currentCv!=null) {
					u.setEmail(email);
					u.setPassword(password);
					//on récupère l'id du cv 
					session.setAttribute("cv_id", currentCv.getId());
					response.sendRedirect("Resume");
				}else {
					response.sendRedirect("RepostCv");
				}
				
			}else {
				request.setAttribute("errorMessage", "Invalid username or password");
				request.getRequestDispatcher("views/authenfication/login.jsp").forward(request, response);
			}
		}catch (NoResultException |NullPointerException s) {
			s.printStackTrace();
			s.getMessage();
		}
	}

}
