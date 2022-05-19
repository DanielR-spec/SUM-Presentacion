/**
 * 
 */
package com.servicios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.inject.Inject;

import com.conexion.GestorSolicitudes;
import com.controller.MyPojo2;

/**
 * @author danie
 *
 */
@WebServlet("/ResponseManager")
public class ResponseManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ResponseManager() {
		// TODO Auto-generated constructor stub
	}

	@Inject
	private MyPojo2 myPojo = new MyPojo2();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter salida = response.getWriter();

		String correo = request.getParameter("correo");
		String contraseña = request.getParameter("Password");
		// String contrase= "aaa";

		if (loginB(correo, contraseña)) {
			// enviar una cookie al browser
			HttpSession session = request.getSession(true);
			session.setAttribute("loggedIn", new String("true"));
			// Redirigir a otro servlet para realizar las operaciones
			// salida.println("<HTML>"+myPojo.getMessage());
			salida.println("<HTML>");
			salida.println("<HEAD>");
			salida.println("<TITLE>Bienvenido</TITLE>");
			salida.println("</HEAD>");
			salida.println("<BODY>");
			salida.println("<P>Bienvenido a nuestra Farmacia.</P>");
			salida.println("Tipo de cuenta: " + request.getParameter("account"));
			salida.print("<br></br>");
			salida.println("Nombre introducido: " + request.getParameter("nombre"));
			salida.print("<br></br>");
			salida.println("Correo: " + request.getParameter("correo"));
			salida.print("<br></br>");
			salida.println("Contraseña: " + request.getParameter("contraseña"));
			salida.print("<br></br>");
			salida.println("Genero: " + request.getParameter("gender"));
			salida.print("<br></br>");
			salida.println("</BODY>");
			salida.println("</HTML>");

			javax.servlet.http.Cookie[] cookies = request.getCookies();
			int length = cookies.length;

			if (length > 0 && cookies != null) {
				for (int i = 0; i < length; i++) {
					javax.servlet.http.Cookie cookie = cookies[i];
					salida.println("<B>Cookie Name:</B> " + cookie.getName() + "<BR>");
					salida.println("<B>Cookie Value:</B> " + cookie.getValue() + "<BR>");
				}
			}

		} else {
			salida.println("Cliente NO conectado, redirigir a LOGIN.");
		}

		// salida.println(login(correo,contraseña));
		/*
		 * try { if (login(correo,contraseña)==5) { //enviar una cookie al browser
		 * HttpSession session = request.getSession(true);
		 * session.setAttribute("loggedIn", new String("true")); // Redirigir a otro
		 * servlet para realizar las operaciones
		 * salida.println("<HTML>"+myPojo.getMessage()); salida.println("<HEAD>");
		 * salida.println("<TITLE>Bienvenido</TITLE>"); salida.println("</HEAD>");
		 * salida.println("<BODY>");
		 * salida.println("<P>Bienvenido a nuestra Farmacia.</P>");
		 * salida.println("Tipo de cuenta: " + request.getParameter("account"));
		 * salida.print("<br></br>"); salida.println("Nombre introducido: " +
		 * request.getParameter("nombre")); salida.print("<br></br>");
		 * salida.println("Correo: " + request.getParameter("correo"));
		 * salida.print("<br></br>"); salida.println("Contraseña: " +
		 * request.getParameter("contraseña")); salida.print("<br></br>");
		 * salida.println("Genero: " + request.getParameter("gender"));
		 * salida.print("<br></br>"); salida.println("</BODY>");
		 * salida.println("</HTML>");
		 * 
		 * javax.servlet.http.Cookie[] cookies = request.getCookies(); int length =
		 * cookies.length;
		 * 
		 * if(length>0) { for (int i=0; i<length; i++) { javax.servlet.http.Cookie
		 * cookie = cookies[i]; salida.println("<B>Cookie Name:</B> " + cookie.getName()
		 * + "<BR>"); salida.println("<B>Cookie Value:</B> " + cookie.getValue() +
		 * "<BR>"); } }
		 * 
		 * } else { salida.println("Cliente NO conectado, redirigir a LOGIN."); } }
		 * catch (NoSuchMethodException | SecurityException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */

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

	public int login(String correo, String contraseña) throws NoSuchMethodException, SecurityException {

		/*
		 * //GestorSolicitudes gestorSolicitudes = new GestorSolicitudes(); // TODO
		 * Auto-generated method stub if
		 * (correo.equalsIgnoreCase("danki")&&contraseña.equalsIgnoreCase("dank")) { if
		 * (gestorSolicitudes != null) { return 5;} }else return 0;
		 */
		return 0;
	}

	public boolean loginB(String correo, String contraseña) {

		
		// TODO Auto-generated method stub
		/*
		 * try { GestorSolicitudes gestorSolicitudes = new GestorSolicitudes(); } catch
		 * (NoSuchMethodException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (SecurityException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } if
		 * (correo.equalsIgnoreCase("danki")&&contraseña.equalsIgnoreCase("aaa")) {
		 * return true; }else
		 */
		try {
			GestorSolicitudes gestorSolicitudes = new GestorSolicitudes();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		if
		  (correo.equalsIgnoreCase("danki")&&contraseña.equalsIgnoreCase("aaa")) {
		  return true;
		  
		  }
		else
			return false;
		
	}

	/**
	 * @see HttpServlet#leerSession(HttpServletRequest, HttpServletResponse)
	 */
	public void leerSession(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session == null) {
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
		} else {
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

}
