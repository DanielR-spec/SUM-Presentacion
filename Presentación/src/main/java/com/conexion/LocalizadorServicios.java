/**
 * 
 */
package com.conexion;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientImpl;
import org.jboss.resteasy.specimpl.ResteasyUriBuilder;
import org.jboss.resteasy.spi.ResteasyAsynchronousContext;

//import org.glassfish.jersey.client.ClientConfig;
//import org.glassfish.jersey.client.JerseyClient;
//import org.hamcrest.core.Is;
//import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientImpl;


/**
 * @author danie
 *
 */
public class LocalizadorServicios {
	
	

	/**
	 * @return 
	 * 
	 */
		
	public String LocalizadorServicios() {
		
		String uri = "http://localhost:9080/RestApi/rest/Auth";
		
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI());
		
		String response = target.request()
		.accept(MediaType.TEXT_PLAIN)
		.get(String.class);
		
		System.out.print(response);
		
		return response;
		
	}
		 //Client client;
      
		/*
		WebTarget target = null;
		
        String response = target.path("hola").path("mundo").request().acceptLanguage(MediaType.TEXT_PLAIN).get(Response.class).toString();
        
        System.out.println(response);

		
       // String plainAnswer =target.path("rest").path("hello").request().acceptLanguage(MediaType.TEXT_PLAIN).get(String.class);
       // String xmlAnswer =target.path("rest").path("hello").request().acceptLanguage(MediaType.TEXT_XML).get(String.class);
       // String htmlAnswer=target.path("rest").path("hello").request().acceptLanguage(MediaType.TEXT_HTML).get(String.class);

       // System.out.println(plainAnswer);
       // System.out.println(xmlAnswer);
       // System.out.println(htmlAnswer);
    }
/*

		URLConnection connection = null;
		try {
			connection = new URL("http://localhost:8080/SufMed2/rest/hola/mundo").openConnection();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String header1 = null;
		connection.setRequestProperty("header1", header1);
		String header2 = null;
		connection.setRequestProperty("header2", header2);
		// Get Response
		try {
			InputStream is = connection.getInputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println(connection.getContentType());
		String name = connection.getHeaderField(header2);
		System.out.println(name);

		// TODO Auto-generated constructor stub
		/*
		 * try { getRemoteFachadaLogica(); } catch (NamingException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
	/*}*/
	
    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:9080/RestApi/rest/Auth").build();
    }

}
