package Commerce;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;

public class CarnetCommande implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Collection<Commande> contenuCarnet;

	public CarnetCommande() {
		super();
		setContenuCarnet(new LinkedList<Commande>());
	}

	public void ajouter(Commande c) {
		contenuCarnet.add(c);
	}

	public Collection<Commande> chercherNonValidees() {
		Collection<Commande> coll = new LinkedList<Commande>();
		for (Commande cmd : contenuCarnet) {
			if (cmd.isValidation() == false)
				coll.add(cmd);
		}
		return coll;
	}

	public Collection<Commande> getContenuCarnet() {
		return contenuCarnet;
	}

	public void setContenuCarnet(Collection<Commande> contenuCarnet) {
		this.contenuCarnet = contenuCarnet;
	}

	// ****** HORS FIL ROUGE ******

	public void afficher() {
		for (Commande cmd : contenuCarnet)
			System.out.println(cmd);
	}
}
