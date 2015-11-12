package Commerce;

public class Crayon extends AbstractProduit {

	private static final long serialVersionUID = 1L;

	public enum DureteCrayon {
		$4B, $2B, B, HB, H, $2H, $4H;
	}

	private DureteCrayon durete;

	public Crayon(double prix, String intitule, String marque,
			String description, DureteCrayon durete) {
		super(prix, intitule, marque, description);
		setDurete(durete);
		setReference(TypeProduit.CRAYON.creerReference(this));
	}

	@Override
	public String toString() {
		return "Crayon [Référence=" + getReference() + ", Intitulé="
				+ getIntitule() + ", Dureté=" + getDurete() + ", Marque="
				+ getMarque() + ", Description=" + getDescription() + ", Prix="
				+ getPrix() + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((durete == null) ? 0 : durete.hashCode());
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
		Crayon other = (Crayon) obj;
		if (durete != other.durete)
			return false;
		return true;
	}
	
	public DureteCrayon getDurete() {
		return durete;
	}

	public void setDurete(DureteCrayon durete) {
		this.durete = durete;
	}

}
