package controleur;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import connexion.ConnexionManagerRemote;

public class EjbLocator {
	private static Context ctx;
	private static EjbLocator instance = new EjbLocator();
	private EjbLocator() {
	}
	public static EjbLocator getLocator() {
		return instance;
	}

	private <T> T getEjb(Class<T> ejbClass, String beanName) {
		try {
			final Hashtable jndiProperties = new Hashtable();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			final Context context = new InitialContext(jndiProperties);
			final String appName = "BanqueEAR";
			final String moduleName = "BanqueEJB";
			return (T) context.lookup("java:global/" + appName + "/" + moduleName + "/" + beanName + "!" + ejbClass.getName());
		} catch (NamingException e) {
			return null;
		}
	}

	
	public ConnexionManagerRemote getSeConnecter() {
		return getEjb(ConnexionManagerRemote.class, "ConnexionManager");
	}
	
	/*public GardienManagerRemote getGardien(){
		return getEjb(GardienManagerRemote.class, "GardienManager");
	}
	
	public MatchHockeyManagerRemote getMatchHockey(){
		return getEjb(MatchHockeyManagerRemote.class, "MatchHockeyManager");
	}
	
	public StatistiqueManagerRemote getStatistique(){
		return getEjb(StatistiqueManagerRemote.class, "StatistiqueManager");
	}*/ // supprimer/corriger
	
}
