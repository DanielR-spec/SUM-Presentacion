/**
 * 
 */
package com.conexion;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author danie
 *
 */
public class LocalizadorServicios {

	/**
	 * 
	 */
	public LocalizadorServicios() {

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
	}

}
