package Commerce;

import java.io.Serializable;

public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	private String mdp;
	private String email;
	transient private Panier panier = new Panier();

	public Client(String mdp, String email) {
		super();
		setMdp(mdp);
		setEmail(email);
	}

	// A FAIRE
	public void validerMdp(String mdp) {
		setMdp(mdp);
	}

	public void ajouterProduit(Produit p) {
		panier.ajouterProduit(p);
	}

	@Override
	public String toString() {
		return "Client [mdp = " + mdp + ", email = " + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mdp == null) ? 0 : mdp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (mdp == null) {
			if (other.mdp != null)
				return false;
		} else if (!mdp.equals(other.mdp))
			return false;
		return true;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

}
