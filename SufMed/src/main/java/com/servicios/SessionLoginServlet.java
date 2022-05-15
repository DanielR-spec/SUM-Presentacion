package com.servicios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionLoginServlet
 */
@WebServlet("/SessionLoginServlet")
public class SessionLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName"); 
		String password = request.getParameter("password"); 
		if (login(userName, password)) {
		//enviar una cookie al browser
		HttpSession session = request.getSession(true); 
		session.setAttribute("loggedIn", new String("true")); 
		// Redirigir a otro servlet para realizar las operaciones
		} 
		else { 
		// enviar error de login
		} 
	}
	public Boolean login (String nombre, String contraseña) {
		if (nombre.equals("Dank")&&contraseña.equals("Dank"))
				return true;
		else 
				return false;
	}
	/**
	 * @see HttpServlet#leerSession(HttpServletRequest, HttpServletResponse)
	 */
	public void leerSession(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException {
		HttpSession session = request.getSession(); 
		if (session==null) {
			response.setContentType("text/html"); 
			PrintWriter out = response.getWriter(); 
			out.println("<HTML>"); 
			out.println("<HEAD>"); 
			out.println("<TITLE>Bienvenida</TITLE>"); 
			out.println("</HEAD>"); 
			out.println("<BODY>"); 
			out.println("Cliente NO conectado, redirigir a login."); 
			out.println("</BODY>"); 
			out.println("</HTML>"); 
		}
		else {
			String loggedIn = (String) session.getAttribute("loggedIn"); 
			if (!loggedIn.equals("true")) {
				response.setContentType("text/html"); 
				PrintWriter out = response.getWriter(); 
				out.println("<HTML>"); 
				out.println("<HEAD>"); 
				out.println("<TITLE>Bienvenida</TITLE>"); 
				out.println("</HEAD>"); 
				out.println("<BODY>"); 
				out.println("Bienvenida."); 
				out.println("</BODY>"); 
				out.println("</HTML>"); 
			} 
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doHead(HttpServletRequest, HttpServletResponse)
	 */
	protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doOptions(HttpServletRequest, HttpServletResponse)
	 */
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doTrace(HttpServletRequest, HttpServletResponse)
	 */
	protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
