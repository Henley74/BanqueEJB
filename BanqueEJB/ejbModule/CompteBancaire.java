import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompteBancaire {

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
