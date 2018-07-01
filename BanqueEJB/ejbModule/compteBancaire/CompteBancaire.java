package compteBancaire;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Comptebancaire")
public class CompteBancaire implements Serializable {

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int		id;
	private int		solde;

public CompteBancaire(){}

public CompteBancaire(int id, int solde){
	this.id = id;
	this.solde = solde;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getSolde() {
	return solde;
}

public void setSolde(int solde) {
	this.solde = solde;
} 
	
}
