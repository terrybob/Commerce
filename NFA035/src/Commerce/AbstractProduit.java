package Commerce;

import java.io.Serializable;

public abstract class AbstractProduit implements Produit, Serializable {

	private static final long serialVersionUID = 1L;

	private double prix;
	private String intitule;
	private String marque;
	private String description;
	protected String reference;

	public AbstractProduit(double prix, String intitule, String marque,
			String description) {
		super();
		setPrix(prix);
		setIntitule(intitule);
		setMarque(marque);
		setDescription(description);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((intitule == null) ? 0 : intitule.hashCode());
		result = prime * result + ((marque == null) ? 0 : marque.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((reference == null) ? 0 : reference.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AbstractProduit))
			return false;
		AbstractProduit other = (AbstractProduit) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (intitule == null) {
			if (other.intitule != null)
				return false;
		} else if (!intitule.equals(other.intitule))
			return false;
		if (marque == null) {
			if (other.marque != null)
				return false;
		} else if (!marque.equals(other.marque))
			return false;
		if (Double.doubleToLongBits(prix) != Double
				.doubleToLongBits(other.prix))
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		return true;
	}

	@Override
	public double getPrix() {
		return prix;
	}

	@Override
	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String getIntitule() {
		return intitule;
	}

	@Override
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	@Override
	public String getMarque() {
		return marque;
	}

	@Override
	public void setMarque(String marque) {
		this.marque = marque;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getReference() {
		return reference;
	}

	@Override
	public void setReference(String reference) {
		this.reference = reference;
	}

}
