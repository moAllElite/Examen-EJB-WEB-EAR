package com.groupeisi.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddExperienceServlet
 */
@WebServlet("/AddExperience")
public class AddExperienceServlet extends HttpServlet {
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
    public AddExperienceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("views/resume/show.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
