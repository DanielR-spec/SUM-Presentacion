package com.servicios;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.io.*; 
import java.util.*; 

/**
 * Servlet implementation class PrimerServlet
 */

@WebServlet(urlPatterns = { "/PrimerServlet" }, initParams = { @WebInitParam(name = "variable1", value = "valor1") })
public class PrimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrimerServlet() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// Espesificación

		PrintWriter salida = response.getWriter();
		response.setContentType(getServletInfo());

		// Generar Respuesta
		//salida.print("<html><body>");
		//salida.print("<h1 style='text-align:center'>Prueba Servlet</h1>");

		salida.println("<HTML>"); 
		salida.println("<HEAD>"); 
		salida.println("<TITLE>Mi primer Servlet</TITLE>"); 
		salida.println("</HEAD>"); 
		salida.println("<BODY>"); 
		salida.println("Hola Mundo Usando Servlets"+"\n"); 
		salida.println("\n");
		salida.println("<B>Demostración del objeto HttpServletRequest</B>"); 
		salida.println("<BR>"); 

		salida.println("<BR>Server Port: " + request.getServerPort()); 
		salida.println("<BR>Server Name: " + request.getServerName()); 
		salida.println("<BR>Protocol: " + request.getProtocol()); 
		salida.println("<BR>Character Encoding: " + request.getCharacterEncoding()); 
		salida.println("<BR>Content Type: " + request.getContentType()); 
		salida.println("<BR>Content Length: " + request.getContentLength()); 
		salida.println("<BR>Remote Address: " + request.getRemoteAddr()); 
		salida.println("<BR>Remote Host: " + request.getRemoteHost()); 
		salida.println("<BR>Scheme: " + request.getScheme()); 

		salida.println("</BODY>"); 
		salida.println("</HTML>"); 

		 sendLoginForm(response, false); 

		Enumeration<String> parameters = request.getParameterNames(); 
		while (parameters.hasMoreElements()) {
			String parameterName = (String) parameters.nextElement(); 
			salida.println("<br>Parameter Name: " + parameterName); 
			salida.println("<br>Parameter Value: " + 
					request.getParameter(parameterName)); 
		} 
		Enumeration<String> attributes = request.getAttributeNames(); 
		while (attributes.hasMoreElements()) {
			String attribute = (String) attributes.nextElement(); 
			salida.println("<BR>Attribute name: " + attribute); 
			salida.println("<BR>Attribute value: " + request.getAttribute(attribute)); 
		} 

	} 


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String userName = request.getParameter("userName"); 
		String password = request.getParameter("password"); 
		
		if (userName!=null && password!=null && 
				userName.equals("diplomado") && password.equals("diplomado")) {
			RequestDispatcher rd = request.getRequestDispatcher("SegundoServlet"); 
			rd.forward(request, response); 
		} 
		else {
			sendLoginForm(response, true); 
		}
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("Invocación al método INIT del Servlet"+"\n");
		System.out.println("	Parametros iniciales: ");
		
		super.init(config);
		
		Enumeration parameters = config.getInitParameterNames();
		
		while (parameters.hasMoreElements()) {
			
			String parameter = (String) parameters.nextElement();
			System.out.println("		Parametro nombre : " + parameter);
			System.out.println("		Parametro valor : " + config.getInitParameter(parameter));
			
		}
		System.out.println("\n");
		// encadena una pareja nombre-valor que será compartida por otros servlets 
		 System.out.println("REGISTRAR DATOS COMPARTIDOS...");
		 ServletContext servletContext = config.getServletContext(); 
		 servletContext.setAttribute("password", "dingdong"); 
		 
		 System.out.println("\n");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Invocación al método SERVICE del Servlet"+"\n");

		 System.out.println("LEYENDO DATOS COMPARTIDOS...");

		ServletContext servletContext = this.getServletContext();
		Enumeration<String> attributes = servletContext.getAttributeNames();
		
		while (attributes.hasMoreElements()) {
			String attribute = (String) attributes.nextElement(); 
			System.out.println("	Attribute name : " + attribute); 
			System.out.println("	Attribute value : " + 
					servletContext.getAttribute(attribute)); 
		} 
		System.out.println("	Major version : " + servletContext.getMajorVersion()); 
		System.out.println("	Minor version : " + servletContext.getMinorVersion()); 
		System.out.println("	Server info : " + servletContext.getServerInfo()); 
		
		doPost(request, response);
		
	}
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy(){
		 System.out.println("Invocación al método DESTROY del Servlet"+"\n"); 
		 }
	/**
	 * @see Servlet#sendLoginForm()
	 */
	private void sendLoginForm(HttpServletResponse response, 
			boolean withErrorMessage) 
					throws ServletException, IOException {
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter(); 
		out.println("<HTML>"); 
		out.println("<HEAD>"); 
		out.println("<TITLE>Login</TITLE>"); 
		out.println("</HEAD>"); 
		out.println("<BODY>"); 
		if (withErrorMessage) 
			out.println("Login failed. Please try again.<BR>"); 
		out.println("<BR>"); 
		out.println("<BR>Please enter your user name and password."); 
		out.println("<BR><FORM METHOD=POST>"); 
		out.println("<BR>User Name: <INPUT TYPE=TEXT NAME=userName>"); 
		out.println("<BR>Password: <INPUT TYPE=PASSWORD NAME=password>"); 
		out.println("<BR><INPUT TYPE=SUBMIT VALUE=Submit>"); 
		out.println("</FORM>"); 
		out.println("</BODY>"); 
		out.println("</HTML>"); 
	}

}
