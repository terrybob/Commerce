package com.wa.trade;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class Produit implements Serializable {

	private static final long serialVersionUID = 1L;

	private enum Couleur {
		ROUGE, ROSE, BLANC
	};

	private enum Contenant {
		BOUTEILLE, VINIBAG5, VINIBAG10, VINIBAG20
	};

	private double prix;
	private int annee;
	private String intitule;
	private String description;
	private int qInit;
	private int qAct;
	private int qCond;
	private Contenant contenant;
	private Couleur couleur;

	public Produit(Contenant contenant, Couleur couleur, int annee,
			double prix, String desc, int qInit) {
		super();
		setPrix(prix);
		setAnnee(annee);
		setIntitule(contenant.name() + " " + couleur.name() + " " + annee);
		setDescription(desc);
		setqInit(qInit);
		setqAct(getqInit());
		setqCond(0);
	}

	public Produit() {
	}

	public Produit newInstance(HttpServletRequest request) {
		Contenant contenant = Contenant.valueOf(request
				.getParameter("contenant"));
		Couleur couleur = Couleur.valueOf(request.getParameter("couleur"));
		double prix = Double.parseDouble(request.getParameter("prix"));
		int annee = Integer.parseInt(request.getParameter("annee"));
		String description = request.getParameter("description");
		int qInit = Integer.parseInt(request.getParameter("qInit"));
		return new Produit(contenant, couleur, annee, prix, description, qInit);
	}

	public boolean a(String intitule) {
		if (intitule.equals(getIntitule()))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Produit [annee=" + annee + ", intitule=" + intitule
				+ ", description=" + description + ", prix=" + prix
				+ ", qInit=" + qInit + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annee;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((intitule == null) ? 0 : intitule.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + qAct;
		result = prime * result + qCond;
		result = prime * result + qInit;
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
		Produit other = (Produit) obj;
		if (annee != other.annee)
			return false;
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
		if (Double.doubleToLongBits(prix) != Double
				.doubleToLongBits(other.prix))
			return false;
		if (qAct != other.qAct)
			return false;
		if (qCond != other.qCond)
			return false;
		if (qInit != other.qInit)
			return false;
		return true;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Contenant getContenant() {
		return contenant;
	}

	public void setContenant(Contenant contenant) {
		this.contenant = contenant;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getqInit() {
		return qInit;
	}

	public void setqInit(int qInit) {
		this.qInit = qInit;
	}

	public int getqAct() {
		return qAct;
	}

	public void setqAct(int qAct) {
		if (qAct <= qInit && qAct >= qCond)
			this.qAct = qAct;
	}

	public int getqCond() {
		return qCond;
	}

	public void setqCond(int qCond) {
		if (qCond <= qAct && qCond <= qInit)
			this.qCond = qCond;
	}

}