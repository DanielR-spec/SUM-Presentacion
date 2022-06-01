   <%@page import="javax.naming.Context"%>
<%@page import="javax.swing.text.AbstractDocument.Content"%>
<%@page import="com.conexion.srvlt.GestorSolicitudesSrlvt"%>
<%@page import="javax.annotation.ManagedBean"%>
<%@page import="java.beans.beancontext.BeanContext"%>
<%@page import="org.apache.catalina.User"%>
<%@page import="com.model.ctrl.Usuario"%>
<%@ page language="java" 
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"  
         import="java.util.Enumeration" 
          %>
 
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
   "http://www.w3.org/TR/html4/loose.dtd">

   <html>

      <head>
         <meta http-equiv="Content-Type" 
            content="text/html; charset=windows-1256">
         <title>   User Logged Successfully   </title>
      </head>
	
      <body>
         <center>
			<h1>HOLA BIENVENIDO</h1>
			<h2>User Name: <% out.println(this.getServletContext().getAttribute("UserName")); %></h2>
			<h2>Password: <% out.println(this.getServletContext().getAttribute("Password")); %> </h2>
			<h3>Session Information: <%Cookie[] cookies = request.getCookies(); 
			int length = cookies.length; 
			for (int i=0; i<length; i++) { 
			 Cookie cookie = cookies[i]; 
			 out.println("<B>Cookie Name:</B> " + cookie.getName() + "<BR>"); 
			 out.println("<B>Cookie Value:</B> " + cookie.getValue() + "<BR>"); 
			}
 %></h3>
			
			<h2>BackendInfo: <% out.println(this.getServletContext().getAttribute("User")); %> </h2>

         </center>

      </body>
	
   </html>