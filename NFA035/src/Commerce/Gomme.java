package Commerce;

public class Gomme extends AbstractProduit {

	private static final long serialVersionUID = 1L;

	public Gomme(double prix, String intitule, String marque, String description) {
		super(prix, intitule, marque, description);
		setReference(TypeProduit.GOMME.creerReference(this));
	}

	@Override
	public String toString() {
		return "Gomme [R�f�rence=" + getReference() + ", Intitul�="
				+ getIntitule() + ", Marque=" + getMarque() + ", Description="
				+ getDescription() + ", Prix=" + getPrix() + "]";
	}

}
