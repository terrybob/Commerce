package Commerce;

public class Lot extends AbstractProduit {

	private static final long serialVersionUID = 1L;

	public Lot(double prix, String intitule, String marque, String description) {
		super(prix, intitule, marque, description);
		setReference(TypeProduit.LOT.creerReference(this));
	}

	@Override
	public String toString() {
		return "Lot [Référence=" + getReference() + ", Intitulé="
				+ getIntitule() + ", Marque=" + getMarque() + ", Description="
				+ getDescription() + ", Prix=" + getPrix() + "]";
	}

}
