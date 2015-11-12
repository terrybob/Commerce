package Commerce;

import java.io.Serializable;

public class LignePanier implements Serializable {

	private static final long serialVersionUID = 1L;

	private Produit produit;
	private int quantite;

	public LignePanier() {
		super();
	}

	public LignePanier(Produit p, int quantite) {
		super();
		setProduit(p);
		setQuantite(quantite);
	}

	@Override
	public String toString() {
		return "LignePanier [" + getProduit() + ", Quantité=" + getQuantite()
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((produit == null) ? 0 : produit.hashCode());
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
		LignePanier other = (LignePanier) obj;
		if (produit == null) {
			if (other.produit != null)
				return false;
		} else if (!produit.equals(other.produit))
			return false;
		return true;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
