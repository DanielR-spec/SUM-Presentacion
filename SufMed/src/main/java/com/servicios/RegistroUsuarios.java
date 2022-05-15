package com.servicios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistroUsuarios
 */
@WebServlet("/RegistroUsuarios")
public class RegistroUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		PrintWriter salida = response.getWriter();
		response.setContentType("text/html");
		


		
		/*
		 * METODO PARA IMPRIMIR VALORES CAPTURADOS EN LOGIN DEL HTML
		salida.println("<html><Body>");
		salida.println("Tipo de cuenta: " + request.getParameter("account"));
		salida.print("<div></div>");
		salida.println("Nombre introducido: " + request.getParameter("nombre"));
		salida.print("<div></div>");
		salida.println("Correo: " + request.getParameter("correo"));
		salida.print("<div></div>");
		salida.println("Contraseña: " + request.getParameter("contraseña"));
		salida.print("<div></div>");
		salida.println("Genero: " + request.getParameter("gender"));
		salida.print("<div></div>");
		salida.println("</Body>"); 
		salida.println("</html>"); 
		*/
		String correo = request.getParameter("correo");
		String contraseña = request.getParameter("contraseña");

		/*
		 * 
		 * =====COOKIE MANAGMENT=====
		 */
		
		Cookie c1 = new Cookie("userName", correo); 
		Cookie c2 = new Cookie("password", contraseña); 
		response.addCookie(c1); 
		response.addCookie(c2); 
		
		if (correo!=null && contraseña!=null ) {
				 RequestDispatcher rd2 = request.getRequestDispatcher("ResponseManager"); 
				 rd2.forward(request, response); 
				 } else {
					 sendLoginForm(response, true); 
				 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void sendLoginForm(HttpServletResponse response, 
			 boolean withErrorMessage) 
			 throws ServletException, IOException {
			 response.setContentType("text/html"); 
			 PrintWriter out = response.getWriter(); 
			 out.println("<HTML>"); 
			 out.println("<HEAD>"); 
			 out.println("<TITLE>Error Page</TITLE>");
			 out.println("</HEAD>"); 
			 out.println("<BODY>"); 
			 if (withErrorMessage) 
				 out.println("Login failed. Please try again.<BR>"); 
				 out.println("<BR>"); 
				 out.println("</BODY>"); 
				 out.println("</HTML>"); 
				 } 

}
