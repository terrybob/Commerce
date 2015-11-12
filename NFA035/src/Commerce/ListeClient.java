package Commerce;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;

public class ListeClient implements Serializable {

	private static final long serialVersionUID = 1L;

	private Collection<Client> contenuListe;

	public ListeClient() {
		super();
		setContenuListe(new LinkedList<Client>());
	}

	public void ajouter(Client c) {
		contenuListe.add(c);
	}

	public Client chercher(String email) {
		for (Client c : contenuListe) {
			if (c.getEmail().equals(email))
				return c;
		}
		return null;
	}

	public Collection<Client> getContenuListe() {
		return contenuListe;
	}

	public void setContenuListe(Collection<Client> contenuListe) {
		this.contenuListe = contenuListe;
	}

	// ****** HORS FIL ROUGE ******

	public void afficher() {
		for (Client cl : contenuListe)
			System.out.println(cl);
	}

}