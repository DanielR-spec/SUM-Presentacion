package com.servlet.ctrl;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conexion.srvlt.GestorSolicitudesSrlvt;
import com.model.ctrl.Usuario;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlador() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		GestorSolicitudesSrlvt gestorSolicitudesSrlvt = new GestorSolicitudesSrlvt();
		Usuario user = new Usuario();
		//user.setName((String) servletContext.getAttribute("userNamer"));
		//user.setPassword((String) servletContext.getAttribute("password"));
		
		String name = request.getParameter("username");
		String pass = request.getParameter("pass");
		user.setText(gestorSolicitudesSrlvt.getUser(name,pass));

		if (user.getText()!=null) {
			user.setIsValid(true);

		}
		/*
		try {
			//ServletContext servletContext = this.getServletContext();
			//Enumeration attributes = servletContext.getAttributeNames();

			Usuario user = new Usuario();
			//user.setName((String) servletContext.getAttribute("userNamer"));
			//user.setPassword((String) servletContext.getAttribute("password"));
			user.setText(gestorSolicitudesSrlvt.getUser());

			if (user.getText()!=null) {
				user.setIsValid(true);

			}
			/*
			 * request.setAttribute("Usr", user); RequestDispatcher dispatch =
			 * request.getRequestDispatcher("/Controlador"); dispatch.forward(request,
			 * response);
			 */

			if (user.getIsValid()) {
				
				ServletContext servletContext = this.getServletContext();
				servletContext.setAttribute("UserName", request.getParameter("username"));
				servletContext.setAttribute("Password", request.getParameter("pass"));
				servletContext.setAttribute("User", user.getText());
				
				Cookie c1 = new Cookie("userName", request.getParameter("username")); 
				Cookie c2 = new Cookie("password", request.getParameter("pass")); 
				response.addCookie(c1); 
				response.addCookie(c2);

				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);
				response.sendRedirect("userLogged.jsp"); // logged-in page
			}

			else
				response.sendRedirect("invalidLogin.jsp"); // error page
		}
/*
		catch (Throwable theException) {
			System.out.println(theException+"HolaLindo");
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
