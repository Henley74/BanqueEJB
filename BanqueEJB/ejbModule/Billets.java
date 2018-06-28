import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Billets {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int		id_billet;
	private String	valeur;
	private int		quantite;
	
	
	public Billets(){}
	public Billets(String valeur, int quantite){
		this.valeur = valeur;
		this.quantite = quantite;
	}
	
	
	public int getId_billet() {
		return id_billet;
	}
	public void setId_billet(int id_billet) {
		this.id_billet = id_billet;
	}
	public String getValeur() {
		return valeur;
	}
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}
