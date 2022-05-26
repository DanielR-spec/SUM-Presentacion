/**
 * 
 */
package com.conexion;

/**
 * @author danie
 *
 */
public class GestorSolicitudes {

	/**
	 * 
	 */
	public void main() throws NoSuchMethodException, SecurityException {

		GestorSolicitudes gestorSolicitudes = new GestorSolicitudes();
	}

	public boolean GestorSolicitudes(String nombre) throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated constructor stub
		LocalizadorServicios lk = new LocalizadorServicios();

		if (lk.LocalizadorServicios().equals(nombre)) {
			return true;
		}
		/*
		 * try { Interfaz(lk); } catch (NamingException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
		return false;

	}

}
