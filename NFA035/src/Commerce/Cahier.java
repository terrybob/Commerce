package Commerce;

public class Cahier extends AbstractProduit {

	private static final long serialVersionUID = 1L;

	public enum CarreauCahier {
		GRANDS, PETITS, SANS;
	}

	public enum TypeCahier {
		SPIRALE, PIQUE, COLLE, AGRAFE;
	}

	private CarreauCahier carreau;
	private TypeCahier type;
	private String couleur;
	private int grammage;
	private String dimensions;
	private int pages;

	public Cahier(double prix, String intitule, String marque,
			String description, CarreauCahier carreau, TypeCahier type,
			String couleur, int grammage, String dimensions, int nbFeuilles) {
		super(prix, intitule, marque, description);
		setCarreau(carreau);
		setType(type);
		setCouleur(couleur);
		setGrammage(grammage);
		setDimensions(dimensions);
		setPages(nbFeuilles);
		setReference(TypeProduit.CAHIER.creerReference(this));
	}

	@Override
	public String toString() {
		return "Cahier [Référence=" + getReference() + ", Intitulé="
				+ getIntitule() + ", Carreau=" + getCarreau() + ", Couleur="
				+ getCouleur() + ", Grammage=" + getGrammage()
				+ ", Dimensions=" + getDimensions() + ", NbFeuilles=" + pages
				+ ", Marque=" + getMarque() + ", Description="
				+ getDescription() + ", Prix=" + getPrix() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((carreau == null) ? 0 : carreau.hashCode());
		result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
		result = prime * result
				+ ((dimensions == null) ? 0 : dimensions.hashCode());
		result = prime * result + grammage;
		result = prime * result + pages;
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
		Cahier other = (Cahier) obj;
		if (carreau != other.carreau)
			return false;
		if (couleur == null) {
			if (other.couleur != null)
				return false;
		} else if (!couleur.equals(other.couleur))
			return false;
		if (dimensions == null) {
			if (other.dimensions != null)
				return false;
		} else if (!dimensions.equals(other.dimensions))
			return false;
		if (grammage != other.grammage)
			return false;
		if (pages != other.pages)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	public CarreauCahier getCarreau() {
		return carreau;
	}

	public void setCarreau(CarreauCahier carreau) {
		this.carreau = carreau;
	}

	public TypeCahier getType() {
		return type;
	}

	public void setType(TypeCahier type) {
		this.type = type;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getGrammage() {
		return grammage;
	}

	public void setGrammage(int grammage) {
		this.grammage = grammage;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int nbFeuilles) {
		this.pages = nbFeuilles;
	}

}
