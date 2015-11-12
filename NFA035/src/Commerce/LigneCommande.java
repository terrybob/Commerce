package Commerce;

public class LigneCommande extends LignePanier {

	private static final long serialVersionUID = 1L;

	private double prix;

	public LigneCommande(LignePanier lp) {
		super();
		setProduit(lp.getProduit());
		setQuantite(lp.getQuantite());
		setPrix(lp.getProduit().getPrix());
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
}
