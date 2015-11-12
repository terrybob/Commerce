package Commerce;

import java.util.LinkedList;

public class DonneesInvalidesException extends Exception {

	private static final long serialVersionUID = 1L;

	private LinkedList<String> contenuErreur = new LinkedList<String>();

	public DonneesInvalidesException() {
		super();
	}

	public DonneesInvalidesException ajouterMessage(String msg) {
		contenuErreur.add(msg);
		return this;
	}

	public boolean aMessage() {
		if (contenuErreur != null)
			return true;
		else
			return false;
	}

}
