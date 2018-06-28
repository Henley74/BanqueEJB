package connexion;

import javax.ejb.Remote;

@Remote
public interface ConnexionManagerRemote {
	boolean seConnecter(String email, String mdp);

}
