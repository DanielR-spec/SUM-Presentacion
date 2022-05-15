package com.modelo;

import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jgroups.conf.PropertyConverters.BindInterface;

import modelo.DatosUsuario;
import modelo.DatosUsuarioRemote;


public class LocalizadorServicios {

	
	public LocalizadorServicios() {
		// TODO Auto-generated constructor stub
		try {
			getRemoteFachadaLogica();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 * @return 
	 */
	public  Object getRemoteFachadaLogica() throws NamingException {
		return this.LocalizadorServiciosCtx("ejb:");
	}
	/**
	 * @param args
	 * @return 
	 */
	private Class<? extends Object> LocalizadorServiciosCtx(String namespace) throws NamingException {
		Context ctx = createInitialContext();
		String appName = "Version1";
		String moduleName = "ServiciosNegocio";
		String distinctName = "";
		String beanName = "ServiciosNegocioExp";
		String viewClassName = "serviciosNG.ServiciosNegocioRemote";
		return ctx.lookup(namespace + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName).getClass();
	}
	/**
	 * @param args
	 */
	private static Context createInitialContext() throws NamingException {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8081");
//		jndiProperties.put(Context.SECURITY_PRINCIPAL, "root");
//		jndiProperties.put(Context.SECURITY_CREDENTIALS, "root");
		jndiProperties.put("jboss.naming.client.ejb.context", true);
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		return new InitialContext(jndiProperties);
	}

}