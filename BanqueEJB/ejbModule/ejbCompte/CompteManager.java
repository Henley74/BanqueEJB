package ejbCompte;

import java.util.Collection;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import compteBancaire.CompteBancaire;


/**
 * Session Bean implementation class CompteManager
 */
@Stateless
@LocalBean
public class CompteManager implements CompteManagerRemote {

	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public CompteManager() {}
    
    @Override
    public CompteBancaire mettreAJourSolde(CompteBancaire compte, int retrait){
    	List<CompteBancaire> comptescorrespondants = em.createQuery("SELECT c FROM Comptebancaire c WHERE id="+compte.getId()).getResultList();
    	CompteBancaire nouveausolde = comptescorrespondants.get(0);
    	nouveausolde.setSolde(nouveausolde.getSolde()-retrait);
    	em.persist(nouveausolde);
    	return nouveausolde;
    }
    
    @Override
    public Collection<CompteBancaire> listerComptes() {
    	return em.createQuery("SELECT c FROM Comptebancaire c").getResultList(); 
    }


}
