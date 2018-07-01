package ejbCompte;

import java.util.Collection;

import javax.ejb.Remote;

import compteBancaire.CompteBancaire;

@Remote
public interface CompteManagerRemote {

	Collection<CompteBancaire> listerComptes();

	CompteBancaire mettreAJourSolde(CompteBancaire compte, int retrait);

}
