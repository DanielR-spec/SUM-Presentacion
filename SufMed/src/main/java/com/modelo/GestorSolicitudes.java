package com.modelo;

/**
 * @author danie
 *
 */
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.modelo.LocalizadorServicios;


//MUY IMPORTANTE AGREGAR LAS CARPETAS DEPENDIENTES AL CLASSPATH DEL PROYECTO, DE LO CONTRARIO NO VA A HACER EL LOOKUP LOCAL NI A PALO
//AGREGAR LIBRERIAS .JAR Y TODAS ESAS DEPENDENCIAS QUE JODEN PARA HACER BIEN EL LOOKUP, POR DEBAJO EL SISTEMA ESPESIFICA QUE TIPO
//DE CLIENTE FUNCIONA, ENTONCES HAY QUE AGREFAR UNA LIBRERIA QUE LO HAGA UN CLIENTE WILDFLY

public class GestorSolicitudes {
	
	public void main () throws NoSuchMethodException, SecurityException {
		
		GestorSolicitudes gestorSolicitudes = new GestorSolicitudes();
	}

	public GestorSolicitudes() throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated constructor stub
		LocalizadorServicios lk = new LocalizadorServicios();
		try {
			Interfaz(lk);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}
	public Object Interfaz(LocalizadorServicios srv) throws NamingException {
		
	
		Object fachade = srv.getRemoteFachadaLogica();
		return fachade;
}
	
		// Crear el localizador de servicios
		//@SuppressWarnings("unused")
		
		
		// Obtener la referencia remota usando el localizador de servicios
		
		 

		// Invocar el servicio usando la referencia remota
			//System.out.println(fachadaLogica.addUSer());
		 
		 
		/*
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
//		jndiProperties.put(Context.SECURITY_PRINCIPAL, "nicolas");
//		jndiProperties.put(Context.SECURITY_CREDENTIALS, "nicolas123");
		jndiProperties.put("jboss.naming.client.ejb.context", true);
		//jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		
		
		Context ctx;
		String namespace = "ejb:";
		String appName = "Version1";
		String moduleName = "ServiciosDatos";
		String distinctName = "";
		String beanName = ServiciosUsuario.class.getSimpleName();
		String viewClassName = ServiciosUsuarioRemote.class.getName();
		ServiciosUsuarioRemote seriviciosusuarios = null;
		System.out.print(
				namespace + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
		
		try {
			ctx = new InitialContext(jndiProperties);
			seriviciosusuarios = (ServiciosUsuarioRemote) ctx.lookup(
			namespace + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
			
			//Invocar el servicio
			//System.out.println(seriviciosusuarios.servicio());
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			List<Usuario> lista = seriviciosusuarios.getAllUsuarios();
			
			for (Usuario usuario : lista) {
				System.out.println(usuario.getIdUsuario() + ", " + usuario.getNombres());
			}
			System.out.println("Size: " + lista.size());
	*/}


	

