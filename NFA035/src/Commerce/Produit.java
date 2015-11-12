package Commerce;

public interface Produit {

	public abstract double getPrix();

	public abstract void setPrix(double prix);

	public abstract String getIntitule();

	public abstract void setIntitule(String intitule);

	public abstract String getMarque();

	public abstract void setMarque(String marque);

	public abstract String getDescription();

	public abstract void setDescription(String description);

	public abstract String getReference();

	public abstract void setReference(String reference);

}