package Commerce;

public class Stylo extends AbstractProduit {

	private static final long serialVersionUID = 1L;

	public enum TypeStylo {
		BILLE, PLUME, FEUTRE
	}

	private String couleur;
	private TypeStylo type;

	public Stylo(double prix, String intitule, String marque,
			String description, String couleur, TypeStylo type) {
		super(prix, intitule, marque, description);
		setCouleur(couleur);
		setType(type);
		setReference(TypeProduit.STYLO.creerReference(this));
	}

	@Override
	public String toString() {
		return "Stylo [Référence=" + getReference() + ", Intitulé="
				+ getIntitule() + ", Type=" + getType() + ", Couleur="
				+ couleur + ", Marque=" + getMarque() + ", Description="
				+ getDescription() + ", Prix=" + getPrix() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stylo other = (Stylo) obj;
		if (couleur == null) {
			if (other.couleur != null)
				return false;
		} else if (!couleur.equals(other.couleur))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public TypeStylo getType() {
		return type;
	}

	public void setType(TypeStylo type) {
		this.type = type;
	}

}
